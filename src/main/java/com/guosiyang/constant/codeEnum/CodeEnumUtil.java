package com.guosiyang.constant.codeEnum;

/**
 * @program: commonutil
 * @className: CodeEnumUtil
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description:
 */
public class CodeEnumUtil {
    /**
     * @author 郭思洋
     * @sign 熙熙攘攘,人来人往
     * @date 2019-12-15
     * @return
     * @throws
     * @since
     * @description 该方法主要是为所有码值名称提供一个默认方法 如果当前类没有定义对应的码值列表则使用默认的码值定义 默认从0开始
     * 如果不想使用从0开始或者enum自带的码值 则可以使用创建一个跟你的enum对象对应的数组 使用该ordinal的数字作为数组的索引调用
    */
    public static Integer getCommonCode(Enum e){
        if (e==null)
            throw new NullPointerException("传入的code枚举为空");
        return e.ordinal();
    }
}
