package com.bobo;

/**
 * @description: 节点类
 * @author: bobo
 * @create: 2021-10-01 17:34
 **/
public class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点,默认为空

    public Boy(int no) {
        this.no = no;

    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }


}
