package com.guosiyang.constant.codeEnum.CodeList;

import com.guosiyang.constant.codeEnum.CodeAble;

/**
 * @program: commonutil
 * @className: TrueFlagEmnum
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-08
 * @sign: 熙熙攘攘, 人来人往
 * @description:
 */
public enum TrueFlagEnum  implements CodeAble {
    /*
    该枚举类型表示返回正确
    */
    TRUE,
    /*
    该枚举类型表示返回错误
     */
    FALSE,
    /*
    该枚举类型表示不知道返回正确还是错误(主要是不知道如果返回错误时错误是什么 如果只要的话直接返回具体错误类型)
    如果对于方法返回该类型 应预先做错误处理判断
    */
    NOTKNOW;

    public static final String CODETYPE="TrueFlag";

    @Override
    public String getCodeType() {
        return CODETYPE;
    }
}
