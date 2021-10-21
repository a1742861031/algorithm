package com.bobo.recursion;

/**
 * @Description 栈的例子
 * @Date 2021/10/19 15:15
 * @Created by bobo
 */
public class Example {
    public static void main(String[] args) {
        print(4);
    }

    public static void print(int n) {
        if (n > 2) {
            print(n - 1);
        }
        System.out.println(n);
    }
}
