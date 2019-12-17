package com.guosiyang.regex;

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
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-17

     * @return
     * @throws
     * @since
     * @description 单例获取regexsingle对象
    */
     static  RegexSingle getRegexSingle(){
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
