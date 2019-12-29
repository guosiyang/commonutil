package com.guosiyang.interfaces;

import com.guosiyang.regex.RegexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description: 该类主要是提供对Operate的工具类
 */
public class OperateUtil {

	private final static Logger logger = LoggerFactory.getLogger(OperateUtil.class);

	/**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供默认方法进行可以对实现该接口的传入对应的操作符进行操作
	 * @think 其实的目的是针对一般的opeateAble操作我们都大部分都是增删改查 针对不同的类型我们可以进行统一处理
	 * @warning 首先因为是动态绑定到方法名称 故传入的operate包括大小写必须与方法名称一致
	 * 			第二 参数化列表的顺序必须与方法中的顺序保持一致
     */
    public  static <K,V> Object  operateData(OperatorAble operateAble,String operate,Object...methodParams){
    	if (operateAble==null || operate==null || "".equals(operate)){
    		throw new NullPointerException("传入的operate对象或者操作不能为空");
		}
    	//将参数化列表转换成流 在把流转换成class对象
		Stream<Object> methodParamsStream = Arrays.asList(methodParams).stream();
    	Stream<Class> methodParamsClassStream = methodParamsStream.map(o -> {return o.getClass();});
		Class[] methodParamsClass = (Class[])methodParamsClassStream.toArray();
    	Class<?> operateAbleClass=operateAble.getClass();
		Method getMethod=null;
		//根据操作符来确定所需要执行的方法
		try {
			getMethod = operateAbleClass.getDeclaredMethod(operate,methodParamsClass);
		} catch (NoSuchMethodException e) {
			logger.info("传入的操作在传入的操作接口中不存在请确认参数列表或者操作符是否与方法名称一致");
			e.printStackTrace();
			return null;
		}
		try {
			return getMethod.invoke(operateAble,methodParams);
		} catch (IllegalAccessException e) {
			logger.info("当前对象不能访问");
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			logger.info("参数值不能转换为相应的形式参数类型,请确认参数顺序是否正确");
			e.printStackTrace();
			return null;
		}
	}
}
