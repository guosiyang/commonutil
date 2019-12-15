package com.guosiyang.constant.codeEnum;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;

/**
 * @program: commonutil
 * @className: CodeAble
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description: 该类主要是对一些程序中常用的状态比如对错等声明为枚举表示状态返回 所有定义的程序的状态必须实现该接口
 */
public interface CodeAble {
    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-15

     * @return
     * @throws
     * @since
     * @description 该接口主要描述所有实现该类的枚举应该有对应的编码类型
    */
    abstract String getCodeType();

    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-15

     * @return
     * @throws
     * @since
     * @description 该方法获取对应的枚举的CodeType类型
    */
    public static String getCodeType(CodeAble codeAble){
        return  codeAble.getCodeType();
    }
    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-15

     * @return
     * @throws
     * @since
     * @description 该方法主要是判断传入的两个codeAble的codeType是否一致
    */
    public static TrueFlagEnum CodeEquals(CodeAble codeTypeA, CodeAble codeTypeB){
        if (codeTypeA==null || codeTypeB==null)
            throw new NullPointerException("传入的code枚举为空");
        if (codeTypeA.getCodeType() == codeTypeB.getCodeType()){
            return TrueFlagEnum.TRUE;
        }
        return TrueFlagEnum.FALSE;
    }
}
