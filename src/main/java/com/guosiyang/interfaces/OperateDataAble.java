package com.guosiyang.interfaces;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description: 对数据操作提供相关接口
 * @think : 起初不是特别想设计该接口 因为我感觉这个个始终是一种过渡优化的实现
 * 因为我们可以直接对数据结构进行改接口的操作, 后来觉得
 * 对于大部分存储的数据结构我们并不希望用户能直接拿到相关所有数据
 * 而是暴露给用户一个类似于方法来进行查询以及新增等相关工作 故对于不想让用户直接操作相关存储的数据结构
 * 提供一种操作方法 即增删改查
 */
public interface OperateMapDataAble<K,V> extends OperatorAble {
    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供查询并返回接口(针对映射查询)
     */
    abstract V query(K key);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供查询是否存在接口 TRUE 为存在 FLASE为不存在
     */
    abstract TrueFlagEnum exist(K key);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供更新接口并进行返回是否正确更新
     */
    abstract TrueFlagEnum update(K key,V value);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供新增接口
     */
    abstract TrueFlagEnum add(K key,V value);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供新增接口
     */
    abstract TrueFlagEnum delete(K key,V value);

    /**
     * @author 郭思洋
     * @date 2019-12-08
     * @description 提供默认方法进行可以对实现该接口的传入对应的操作符进行操作
     */
    public  static <T> Object  operateData(OperateMapDataAble<K,V> operateDataAble,String operate){
        if (operateDataAble ==null || operate==null || "".equals(operate))
            throw new NullPointerException("传入参数为空");
    }
}
