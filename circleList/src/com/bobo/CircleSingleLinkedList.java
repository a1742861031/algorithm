package com.bobo;

/**
 * @description: 环形链表
 * @author: bobo
 * @create: 2021-10-01 17:37
 **/
public class CircleSingleLinkedList {
    //创建一个first节点 当前没有编号
    private Boy first = new Boy(-1);

    //添加一个小孩节点 构成一个环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy cur = null;//辅助指针，帮助我们创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //第一个小孩节点比较特别
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first; //让cur节点指向第一个小孩节点
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //遍历该环
    public void display() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何节点");
            return;
        }
        //通过一个辅助节点完成遍历
        Boy cur = first;
        while (cur.getNext() != first) {
            System.out.print(cur.getNo() + ",");
            cur = cur.getNext();
        }
        //打印环的最后一个节点
        System.out.print(cur.getNo());
    }

    /**
     * @Description: 生成小孩出圈的顺序
     * @Param: [startNo(开始的序号), countNum(数几下), nums(最初有多少)]
     * @return: void
     **/
    public void countBoy(int startNo, int countNum, int nums) {
        //数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入错误，请重新输入");
            return;
        }
        //创建一个辅助指针
        Boy helper = first;
        //让辅助指针指向环的最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // startNo表示从哪个节点开始计数(比如从一号开始计数，则不移动，二号开始计数，则移动一次)
        // 所以通过循环移动到那个节点去
        for (int j = 0; j < startNo - 1; j++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //移动多少次出圈 直到圈中只有一个节点
        /*当helper节点与first节点发生重合，则表示说明圈中只有一个节点(重点)*/
        while (helper != first) {
            //让first和helper指针共移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo() + "出圈");
            //出圈的动作
            //first指向下一个节点，让helper指向新的first节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first.getNo() + "出圈");
    }
}
