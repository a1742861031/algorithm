package com.bobo;

/**
 * @description: 约瑟夫环问题
 * @author: bobo
 * @create: 2021-10-01 17:34
 **/
public class JosePfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.display();
        System.out.println();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
