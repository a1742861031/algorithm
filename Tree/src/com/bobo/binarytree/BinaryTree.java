package com.bobo.binarytree;

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

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序
    public HeroNode middleOrderSearch(int no) {
        if (root != null) {
            return root.middleOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除指定节点
    public void deleteNode(int no) {
        if (root == null) {
            System.out.println("这是空树");
            return;
        }
        if (root.getNo() == no) {
            this.root = null;
            return;
        } else {
            this.root.deleteNode(no);
        }
    }
}
