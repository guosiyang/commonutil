package com.guosiyang.regex;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;
import com.guosiyang.interfaces.OperateMapDataAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

/**
 * @program: commonutil
 * @className: RegexSingle
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-08
 * @sign: 熙熙攘攘, 人来人往
 * @description: 创建单例 , 存储预编译的String-Matcher
 */
public class RegexSingle {

   //初始courrentHashMap数组容量 处理逻辑预估出存储大小 initialCapacity=(存储大小/loadFactor)+1
    private static final int START_INITIAL=1201;

    //初始courrentHashMap加载因子
    private static final float START_LOAD_FACTOR=0.75F;

    //初始courrentHashMap同时写操作的并发数(根据业务场景模拟)
    private static final int START_CONCURRENCY_LEVEL=32;

    private static volatile RegexSingle regexSingle;

    //该属性存放相关实际的initialCapacity为自动扩容计算做准备
    private static volatile int nowInitial;

    private final static Logger logger = LoggerFactory.getLogger(RegexSingle.class);

    /*
     该对象主要存放相关的Stringh-Matcher
    */
    private AbstractMap<String, Matcher> stringToMathcer=new ConcurrentHashMap<String,Matcher>(START_INITIAL,START_LOAD_FACTOR,START_CONCURRENCY_LEVEL);

    //指的是当前HashMap里有多少键值对
    private AtomicInteger nowKeyValueNum=new AtomicInteger();

    //构造器
    private RegexSingle(){
        nowInitial=START_INITIAL;
    }

    /**
     * @program: commonutil
     * @className: RegexSingle
     * @version: 1.0
     * @author: 郭思洋
     * @date: 2019-12-08
     * @sign: 熙熙攘攘, 人来人往
     * @description: 创建内部类 对外暴露内部类 该内部类主要是提供相关对数据增删改查操作
     * 注意 : 该数据类型不允许进行删除或者进行更新 调用会进行报错
     */
     class RegexSingleOperator implements OperateMapDataAble<String,Matcher>{
        private AbstractMap<String,Matcher> dataMap=null;
        //当第一次被被调用时自动绑定到RegexSingle中的数据存储集合
        {
            dataMap = RegexSingle.this.stringToMathcer;
        }
        @Override
        public Matcher query(String key) {
            if (TrueFlagEnum.FALSE==this.exist(key)){
                return null;
            }else{
                return dataMap.get(key);
            }
        }

        @Override
        public TrueFlagEnum exist(String key) {
            if (key==null || "".equals(key))
                return TrueFlagEnum.FALSE;
            if (dataMap.containsKey(key)){
                return TrueFlagEnum.TRUE;
            }
            return TrueFlagEnum.FALSE;
        }

        @Override
        public TrueFlagEnum update(String key, Matcher value) {
            return TrueFlagEnum.FALSE;
        }

        @Override
        public TrueFlagEnum add(String key, Matcher value) {
            if (key==null || value==null || "".equals(key))
                return TrueFlagEnum.FALSE;
            if (dataMap.containsKey(key))
                return TrueFlagEnum.TRUE;
            //判断是否需要扩容
            if (regexSingle.addDataMapSize() != TrueFlagEnum.TRUE){
                return TrueFlagEnum.FALSE;
            }
            return TrueFlagEnum.TRUE;
        }

        @Override
        public TrueFlagEnum delete(String key, Matcher value) {
            return TrueFlagEnum.FALSE;
        }
    }

    /**
     * @author 郭思洋
     * @description 单例获取regexsingle对象
     */

     private static  RegexSingle getRegexSingle(){
        if (regexSingle==null){
            synchronized (RegexSingle.class){
                if (regexSingle==null){
                    regexSingle=new RegexSingle();
                }
            }
        }
        return regexSingle;
    }

    /**
     * @author 郭思洋
     * @description 为dataMap进行扩容准备 设计思路
     */

    private TrueFlagEnum addDataMapSize(){
        if (nowKeyValueNum.doubleValue() >= ((nowInitial-1) * START_LOAD_FACTOR) - 1){
            synchronized (regexSingle) {
                if (nowKeyValueNum.doubleValue() >= ((nowInitial-1) * START_LOAD_FACTOR) - 1){
                    int addAfterInitial = (nowInitial - 1)  * 2 + 1 ;
                    AbstractMap<String, Matcher> addAfterHashMap =new ConcurrentHashMap<>(addAfterInitial,START_LOAD_FACTOR,START_CONCURRENCY_LEVEL);
                    addAfterHashMap.putAll(stringToMathcer);
                    stringToMathcer=addAfterHashMap;
                }
            }
        }
        return TrueFlagEnum.TRUE;
    }

    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-17
     * @description 通过单例对象来获取操作连接 注意 我们必须通过此进行获取相关操作连接
     */

     OperateMapDataAble<String,Matcher> getOperator(){
         return new RegexSingleOperator();
    }

}
