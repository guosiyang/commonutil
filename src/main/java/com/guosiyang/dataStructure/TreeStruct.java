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
        private Node<T> parentNode;

        //该节点集合为当前节点的子节点
        private List<Node<T>> sonNodes;

        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @description 判断当前节点是否为根父节点
         */
        public boolean isParent(){
            if (parentNode == null)
                return true;
            return false;
        }
        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @description 判断当前节点是否为根子节点
         */
        public boolean isSon(){
            if (sonNodes==null || sonNodes.size()==0)
                return true;
            return false;
        }
        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @description 增加子节点
         */
        public boolean addSon(Node<T> nodes){
            if (nodes == null)
                throw new NullPointerException("传入子节点不能为空");
            this.sonNodes.add(nodes);
            nodes.setParentNode(this);
            return true;
        }

        public Node<T> getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node<T> parentNodeNew) {
            if (parentNodeNew == null)
                throw new NullPointerException("传入父节点不能为空");
            this.parentNode = parentNode;
        }

        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @description 通过给定子节点进行删除掉当前节点里的子节点
         */
        public boolean deleteSonNode(Node<T> deleteNode){
            if (deleteNode == null)
                throw new NullPointerException("传入删除节点不能为空");
            for (Node<T> node:
            sonNodes) {
                if (deleteNode.equals(node)){
                    sonNodes.remove(node);
                    return true;
                }
            }
            return true;
        }

        /**
         * @author 郭思洋
         * @sign 熙熙攘攘,人来人往
         * @date 2019-12-15
         * @description 删除当前节点的所有子节点
         */
        public boolean deleteAllSonNodes(){
            sonNodes.removeAll(sonNodes);
            return true;
        }
    }
}
