package com.guosiyang.interfaces;

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
 * 提供一种操作方法 即增删改查 与此同时 该接口仅仅就是一个声明接口( ps :我也不知道为啥有什么共同性 但是就留着吧 当成一个标识符或者扩展用)
 */
public interface OperatorAble {

}
