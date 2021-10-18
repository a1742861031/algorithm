package com.bobo;

import java.util.Stack;

/**
 * @Description 通过栈实现计算器 这里简化只计算0-9的整数
 * @Date 2021/10/10 12:22
 * @Created by bobo
 */


/**
 * 实现思路
 * 1、初始化一个符号栈和一个数栈
 * 2、遍历输入的表达式
 * ***2.1、如果发现是一个数字，直接入数栈
 * ***2.2、如果扫描到的是一个符号，
 * *******2.3.1如果当前符号栈为空，则直接入符号栈
 * *******2.3.2如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或等于符号栈顶的操作符，就从数栈中pop出两个数，并从符号栈中pop出一个符号进行运算，将运算的结果压入数栈，当前操作符入符号栈
 * *******2.3.3如果符号栈的运算符优先级大于栈顶的元素，直接入符号栈
 * 3、当表达式扫描完毕后，就从数栈弹出两个数，从符号栈弹出运算符号，进行运算，若数栈中只剩一个元素，则最后这个数就是运算结果
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
