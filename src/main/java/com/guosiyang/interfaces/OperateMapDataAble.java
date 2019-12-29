package com.guosiyang.interfaces;

/**
 * Created by admin on 2019/12/20.
 */

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description: 对数据操作提供相关接口
 */
public interface OperateMapDataAble<K,V> extends OperatorAble {
    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供查询并返回接口(针对映射查询)
     */
    public abstract V query(K key);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供查询是否存在接口 TRUE 为存在 FLASE为不存在
     */
    public abstract TrueFlagEnum exist(K key);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供更新接口并进行返回是否正确更新
     */
    public abstract TrueFlagEnum update(K key,V value);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供新增接口
     */
    public abstract TrueFlagEnum add(K key,V value);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供新增接口
     */
    public abstract TrueFlagEnum delete(K key,V value);


}
