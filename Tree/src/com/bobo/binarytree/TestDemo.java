package com.bobo.binarytree;

/**
 * @Description 测试
 * @Date 2021/10/21 21:47
 * @Created by bobo
 */
public class TestDemo {
    //创建二叉树
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "武松");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "二娘");
        //我们先学习手动创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
//        System.out.println("前序遍历");
//        binaryTree.preOrder(); //1,2,3,4
//        System.out.println("中序遍历"); //2，1，3，4
//        binaryTree.middleOrder();
//        System.out.println("后序遍历"); //2,4,3,1
//        binaryTree.postOrder();
//        System.out.println("前序遍历");
//        System.out.println(binaryTree.preOrderSearch(5));
//        System.out.println("中序遍历");
//        System.out.println(binaryTree.middleOrderSearch(5));
//        System.out.println("后序遍历");
//        System.out.println(binaryTree.postOrderSearch(5));
        //删除前
        System.out.println("删除前");
        binaryTree.preOrder();
        binaryTree.deleteNode(5);
        System.out.println("删除后");
        binaryTree.preOrder();
    }
}
