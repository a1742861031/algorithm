package com.bobo.binaryTree;

/**
 * @Description 二叉树数据结构
 * @Date 2021/10/21 21:48
 * @Created by bobo
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认空
    private HeroNode right; //默认空

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //遍历中序遍历方法
    public void middleOrder() {
        if (this.left != null) {
            this.left.middleOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleOrder();
        }
    }

    //遍历后序遍历方法
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
