package com.bobo.binarytree.arrbinarytree;

/**
 * @Description 顺序存储二叉树
 * @Date 2021/10/23 12:23
 * @Created by bobo
 */
public class ArrBinaryTree {
    private int[] arr; //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * @Description 编写一个方法，完成二叉树的前序遍历
     * @Params index 数组的下标
     * @Return void
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //重载前序遍历方法
    public void preOrder() {
        this.preOrder(0);
    }
}
