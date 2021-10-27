package com.bobo.binarytree.arrbinarytree;

/**
 * @Description 顺序存储二叉树
 * @Date 2021/10/23 12:20
 * @Created by bobo
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
