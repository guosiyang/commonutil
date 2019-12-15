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
 * @description:
 */
public class RegexSingle {

   //初始courrentHashMap数组容量 处理逻辑预估出存储大小 initialCapacity=(存储大小/loadFactor)+1
    private int initialCapacity=801;

    //初始courrentHashMap加载因子
    private float loadFactor=0.75F;

    //初始courrentHashMap同时写操作的并发数(根据业务场景模拟)
    private int concurrencyLevel=32;
    /*
     该对象主要存放相关的Stringh-Matcher
    */
    private final AbstractMap<String, Matcher> stringToMathcer=new ConcurrentHashMap<String,Matcher>(initialCapacity,loadFactor,concurrencyLevel);
    private RegexSingle(){
    }


}
