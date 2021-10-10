package com.bobo;

import java.util.Stack;

/**
 * @Description 通过栈实现计算器
 * @Date 2021/10/10 12:22
 * @Created by bobo
 */
/**
 * 实现思路：当
 */
public class ComputeWithStack {
    public static void main(String[] args) {
        //初始化一个计数栈
        Stack<Integer> stackNum = new Stack<>();
        //初始化一个运算符栈
        Stack<Character> stackOperator = new Stack<>();
        //算术表达式
        String formula = "7+7+8/2-3";
        for (int i = 0; i < formula.length(); i++) {
            char ele = formula.charAt(i);
            Character topEle = ' ';
            if (stackOperator.size() > 0) {
                topEle = stackOperator.get(stackOperator.size() - 1);
            }
            if (ele == '*' || ele == '/' || ele == '+' || ele == '-') {
                if (stackOperator.size() == 0) {
                    stackOperator.push(ele);
                } else if (topEle == '+' || topEle == '-' || ele == '*' || ele == '/') {
                    stackOperator.push(ele);
                } else {
                    //弹出两个元素，并计算
                    Integer a = stackNum.pop();
                    Integer b = stackNum.pop();
                    Character el = stackOperator.pop();
                    Integer result = calculation(b, a, el);
                    stackNum.push(result);
                    stackOperator.push(ele);
                }
            } else {
                stackNum.push(Integer.valueOf(String.valueOf(ele)));
            }
        }
        while (true) {
            if (stackNum.size() == 1) {
                //当栈中只剩一个元素时 则为计算结果
                System.out.println(stackNum.pop());
                break;
            } else {
                //这里要注意计算的顺序
                Integer a = stackNum.pop();
                Integer b = stackNum.pop();
                Character el = stackOperator.pop();
                Integer calculation = calculation(b, a, el);
                stackNum.push(calculation);
            }
        }
    }

    private static Integer calculation(Integer a, Integer b, Character ele) {
        if (ele == '*') {
            return a * b;
        } else if (ele == '/') {
            return a / b;
        } else if (ele == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }
}
