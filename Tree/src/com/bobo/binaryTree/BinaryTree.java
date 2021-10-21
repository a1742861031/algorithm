package com.bobo.binaryTree;

/**
 * @Description 二叉树
 * @Date 2021/10/21 21:56
 * @Created by bobo
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void middleOrder() {
        if (this.root != null) {
            this.root.middleOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }
}
