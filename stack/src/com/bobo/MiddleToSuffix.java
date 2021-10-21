package com.bobo;

/**
 * @Description 中缀表达式转后缀表达式
 * @Date 2021/10/18 20:21
 * @Created by bobo
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1、初始化两个栈：运算符栈s1与存储中间结果的栈s2
 * 2、从左至右扫描中缀表达式
 * 3、遇到操作数，将其压入s2
 * 4、遇到运算符时，比较其与s1栈顶元素的优先级
 * ****4.1、如果s1为空，或栈顶运算符为左括号 直接将此运算符入栈
 * ****4.2、如果优先级比栈顶运算符的高，也将运算符压入s1
 * ****4.3、否则，将s1栈顶的运算符弹出并压入到s2，再次转到(4.1)与s1中新的栈顶运算符相比较
 * 5、遇到括号时：
 * ****5.1、如果是左括号，直接压入s1
 * ****5.2、如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 6、重复2至5，直到表达式的最右边
 * 7、将s1中剩余的运算符以此弹出并压入s2
 * 8、以此弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 **/
public class MiddleToSuffix {
    public static void main(String[] args) {
        String str = "1+((2+3)*4)-5";
        List<String> stringList = covetCompressionToList(str);
        System.out.println(stringList);
        List<String> result = parseSuffixExpressionList(stringList);
        System.out.println(result);
    }

    //中缀转后缀
    public static List<String> parseSuffixExpressionList(List<String> strs) {
        //初始化一个符号栈
        Stack<String> s = new Stack<>();
        //因为s2这个栈，在转换过程中，没有任何pop操作，后面还需要逆序输出，所有可以采用list简化
        List<String> list = new ArrayList<>(); //存储中间的运算结果
        for (String str : strs) {
            if (str.matches("\\d+")) { //匹配数字
                list.add(str);
            } else if (str.equals("(")) { //左括号，直接入栈
                s.push(str);
            } else if (str.equals(")")) {  //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s.peek().equals("(")) {
                    list.add(s.pop());
                }
                s.pop();//弹出左括号
            } else {
                //当str运算符的优先级小于或等于栈顶元素的优先级 将栈顶的运算符弹出压入到list中，直到栈为空，或者str运算符大于栈顶运算符
                //拿到优先级高低优先级高低的方法
                while (s.size() != 0 && (Operation.getValue(str) <= Operation.getValue(s.peek()))) {
                    list.add(s.pop());
                }
                //当前扫描到的str压入栈
                s.push(str);
            }
        }
        //将s剩余的运算符以此弹出并加入到s2
        while (s.size() != 0) {
            list.add(s.pop());
        }
        return list;
    }

    //拆分表达式的各个元素到一个list中
    public static List<String> covetCompressionToList(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c;
            String s = "";
            c = str.charAt(i);
            if (c >= 48 && c <= 57) { //为数字
                while (c >= 48 && c <= 57) {
                    s = s + c;
                    i++;
                    if (i >= str.length()) {
                        break;
                    }
                    c = str.charAt(i);
                }
                list.add(s);
                i--;
            } else {
                list.add(c + "");
            }
        }
        return list;
    }
}

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    //返回运算符优先级的数字
    public static int getValue(String operation) {
        switch (operation) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}

