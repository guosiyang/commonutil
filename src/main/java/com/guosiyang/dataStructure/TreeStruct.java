package com.guosiyang.dataStructure;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: commonutil
 * @className: TreeStruct
 * @version: 1.0
 * @author: 郭思洋
 * @date: 2019-12-15
 * @sign: 熙熙攘攘, 人来人往
 * @description: 该类主要是实现了树结构  为啥要设计该类 主要是为了
 *               实现对于文件系统的拿到树状结构进行处理
 */
public class TreeStruct<T> {
    private Node<T> parentNode;
    /**
     * @program: commonutil
     * @className: TreeStruct
     * @version: 1.0
     * @author: 郭思洋
     * @date: 2019-12-15
     * @sign: 熙熙攘攘, 人来人往
     * @description: 在树的数据结构中每一个节点都为子节点
     */
    private static class Node<T>{
        //该节点指的是当前的节点对象的父节点 每一个节点对象只能有一个父节点
        @Getter
        @Setter
        private Node<T> parentNode;

        //该节点集合为当前节点的子节点
        private List< Node<T>> sonNodes;

        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @return
         * @throws
         * @since
         * @description 判断当前节点是否为父节点
         */
        public boolean isParent(){
            if (parentNode == null){
                return true;
            }
            return false;
        }
        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @return
         * @throws
         * @since
         * @description 判断当前节点是否为子节点
         */
        public boolean isSon(){
            if (sonNodes==null || sonNodes.size()==0){
                return true;
            }
            return false;
        }
    }
}
