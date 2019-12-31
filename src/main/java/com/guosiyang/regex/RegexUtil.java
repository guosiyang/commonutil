package com.guosiyang.regex;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;
import com.guosiyang.interfaces.OperateMapDataAble;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: commonutil
 * @className: RegexUtil
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-07
 * @sign: 熙熙攘攘, 人来人往
 * @description: 该类为对外暴露的正则处理公共类,如果不提前预编译正则表达式会产生OOM异常
 */
public final class RegexUtil {

    private final static Logger logger = LoggerFactory.getLogger(RegexUtil.class);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 对于获取对应的pattern
    */
    private static Pattern getParttern(String regix){
        RegexSingle regexSingle=RegexSingle.getRegexSingle();
        OperateMapDataAble<String,Pattern> operateMapDataMap=regexSingle.getOperator();
        if (operateMapDataMap.exist(regix) == TrueFlagEnum.TRUE){
            logger.info("正则表达式为 : " +regix+ "已存在");
            return operateMapDataMap.query(regix);
        }
        Pattern p = Pattern.compile(regix);
        operateMapDataMap.add(regix,p);
        return p;
    }

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 对外暴露的方法  所有正则匹配推荐使用此方法
     */
    public static TrueFlagEnum isMatching(String regex,String target){
        logger.info("传入的正则匹配表达式为 : " + regex + "被匹配的string为 : " + target);
        if (regex == null || target == null || "".equals(regex) || "".equals(target)){
            throw new NullPointerException("传入的正则表达式或者被匹配的string为空");
        }
        LocalDateTime getBeforeTime=LocalDateTime.now();
        Pattern p = getParttern(regex);
        Matcher matcher = p.matcher(target);
        LocalDateTime getAfterTime=LocalDateTime.now();
        logger.info("匹配结果正则表达式为 : " + regex + " 被匹配字符串为 : " +target+ "所需要时间为 : " + Duration.between(getBeforeTime,getAfterTime).toMillis());
        if (matcher.matches()){
            return TrueFlagEnum.TRUE;
        }
        return TrueFlagEnum.FALSE;
    }
}
