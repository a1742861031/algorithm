package com.bobo.recursion;

/**
 * @Description 八皇后问题
 * @Date 2021/10/20 19:13
 * @Created by bobo
 * <p>
 * 什么是8皇后，就是相邻行的棋子不能再同一行，同一列或者同一斜线上
 */

/**
 * 什么是8皇后，就是相邻行的棋子不能再同一行，同一列或者同一斜线上
 */

/**
 * 1、第一个皇后放在第一行的第一列
 * 2、第二个皇后放在第二行的第一列、然后判断是否ok，如果不ok，继续放在第二列，第三列，依次把所有列都放完
 * 3、继续第三个皇后，还是第一列，第二列。。。直到第8个皇后也能放在一个不冲突的位置，就算找到了一个解
 * 4、当得到一个正确解时，栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放在第一列的所有正确解，全部得到
 * 5、然后回头继续第一个皇后放第二列，后面继续循环执行1，2，3，4的步骤
 * */
public class EightQueen {
    int max = 8;//有多少皇后
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //初始化一个一维数组 表示摆法
        //用一位数组的下标表示行数 值表示列数
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.println(count);
    }

    //编写一个方法，放第n个皇后
    private void check(int n) {
        if (n == max) { //已经放好
            count++;
            print();
            return;
        }
        //依次放皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //放置皇后
            array[n] = i;
            //判断当放置后是否冲突
            //不冲突
            if (judge(n)) {
                check(n + 1); //放第n+1个
            }
            //如果冲突，就继续执行上面的循环，即将本行要放的皇后后移一个位置
        }
    }

    //判断是否冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //判断是否在同一列或者在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印结果数组
    private void print() {
        for (int i : array) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}
