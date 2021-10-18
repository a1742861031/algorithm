package com.bobo;

/**
 * @Description 中缀表达式转后缀表达式
 * @Date 2021/10/18 20:21
 * @Created by bobo
 */
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
 *
**/
public class MiddleToSuffix {
}