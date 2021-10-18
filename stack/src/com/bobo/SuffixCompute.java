package com.bobo;

import java.util.Stack;

/**
 * @Description 后缀表达式(逆波兰计算) 这里简化只计算0-9的整数
 * @Date 2021/10/18 19:55
 * @Created by bobo
 */
/**
 * 实现思路
 * 从左向右扫描，将3，4压入栈中
 * 遇到+运算符，因此弹出4和3(4为栈顶元素，3为次顶元素)，计算出3+4的值，得到7，再将4入栈
 * 将5入栈
 * 接下来是*运算符，因此弹出5和7，计算出7*5=35，将35入栈
 * 最后是-运算符，计算出35-6的值，即为29，得到最终的结果
* */
public class SuffixCompute {
    public static void main(String[] args) {
        //初始化一个栈
        Stack<Integer> stackNum = new Stack<>();
        //算术表达式
        String formula = "34+5*6-";
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                Integer a = stackNum.pop();
                Integer b = stackNum.pop();
                stackNum.push(calculation(b,a,c));
            }
            else {
                String str=String.valueOf(c);
                stackNum.push(Integer.valueOf(str));
            }
        }
        System.out.println(stackNum.pop());
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
