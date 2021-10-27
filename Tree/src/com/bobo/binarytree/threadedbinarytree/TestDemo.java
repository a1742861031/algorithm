package com.bobo.binarytree.threadedbinarytree;

/**
 * @Description 测试
 * @Date 2021/10/27 21:24
 * @Created by bobo
 */
public class TestDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes(root);
        threadedBinaryTree.threadedList();
//        //测试 10号的前驱和后继节点
//        HeroNode left = node5.getLeft();
//        System.out.println(left);
//        HeroNode right = node5.getRight();
//        System.out.println(right);
    }
}
