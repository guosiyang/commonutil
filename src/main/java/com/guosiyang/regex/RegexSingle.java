package com.guosiyang.regex;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;
import com.guosiyang.interfaces.OperateMapDataAble;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
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
    private int initialCapacity=1201;

    //初始courrentHashMap加载因子
    private float loadFactor=0.75F;

    //初始courrentHashMap同时写操作的并发数(根据业务场景模拟)
    private int concurrencyLevel=32;

    private static volatile RegexSingle regexSingle;
    /*
     该对象主要存放相关的Stringh-Matcher
    */
    private AbstractMap<String, Matcher> stringToMathcer=new ConcurrentHashMap<String,Matcher>(initialCapacity,loadFactor,concurrencyLevel);

    private RegexSingle(){
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
        AbstractMap<String,Matcher> dataMap=null;
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
            dataMap.put(key,value);
            return TrueFlagEnum.TRUE;
        }

        @Override
        public TrueFlagEnum delete(String key, Matcher value) {
            return TrueFlagEnum.FALSE;
        }
    }
    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-17

     * @return
     * @throws
     * @since
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


}
