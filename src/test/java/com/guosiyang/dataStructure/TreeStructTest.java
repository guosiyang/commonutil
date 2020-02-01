package com.guosiyang.dataStructure;


import org.junit.Test;

class TreeStructTest {

	@Test
	public static void main(String[] args){
		TreeStruct<A> treeStruct = new TreeStruct<>();
		TreeStruct.Node<A> node = treeStruct.getNode();
		node.setTarget(new A("第一层第一个"));
		treeStruct.setParentNode(node);
		TreeStruct.Node<A> node1 = treeStruct.getNode();
		node1.setTarget(new A("第二层第一个"));
		node.addSon(node1);
		TreeStruct.Node<A> node2 = treeStruct.getNode();
		node2.setTarget(new A("第二层第二个"));
		node.addSon(node2);
		TreeStruct.Node<A> node3 = treeStruct.getNode();
		node3.setTarget(new A("第三层第一个"));
		node1.addSon(node3);
		TreeStruct.Node<A> node4 = treeStruct.getNode();
		node4.setTarget(new A("第三层第二个"));
		node2.addSon(node4);
		System.out.println(treeStruct.toString());
	}
}
class A{
    public String a="";

    A(String a){
    	this.a = a;
	}
	@Override
	public String toString() {
		return a;
	}
}