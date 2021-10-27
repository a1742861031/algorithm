package com.bobo.binarytree.threadedbinarytree;

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

    //说明
    //1、如果leftType==0表示指向的是左子树，如果是1表示指向前驱节点
    //2、如果rightType==0表示指向右子树，如果是1表示指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
}
