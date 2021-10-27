package com.bobo.binarytree.threadedbinarytree;

/**
 * @Description 线索化二叉树
 * @Date 2021/10/27 20:54
 * @Created by bobo
 */
public class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化，创建一个指向当前节点的前驱节点的指针
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode node) {
        //如果node == null 无法进行线索化
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改左指针的类型
            node.setLeftType(1);
        }
        //处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            //前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后让当前节点是下一节点的后继节点
        pre = node;
        //线索化二叉树
        threadedNodes(node.getRight());
    }

    //中序遍历线索化二叉树
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，
        HeroNode node = root;
        while (node != null) {
            //循环找到leftType ==1的节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }
    }
}
