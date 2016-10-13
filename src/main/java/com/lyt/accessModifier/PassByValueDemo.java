package com.lyt.accessModifier;
/**
 * 考擦的是值传递，
 * 值传递！Java中只有按值传递，没有按引用传递！
 * 值传递的精髓是：传递的是存储单元中的内容，而非地址或者引用！
 * @author liyintao
 * @createDate 2016年10月13日 15:52
 */
public class PassByValueDemo {
	int in = 5;
	String str = new String("good");
	char[] ch = {'a','b','c',97};//[a, b, c, a]
	public void change(int in, String str, char[] ch){
		in = 10;
		str = "test ok";
		ch[0] = 'g';
	}
	public void changeThis(int in, String str, char[] ch){
		this.in = 10;
		this.str = "test ok";
		this.ch[0] = 'g';
	}
	public static void main(String[] args) {
		PassByValueDemo ex = new PassByValueDemo();
		ex.change(ex.in, ex.str, ex.ch);//5,good,[a, b, c, a]
		System.out.print(ex.in + " and " + ex.str + " and ");
		System.out.println(ex.ch);
		System.out.println("this的使用");
		ex.changeThis(ex.in, ex.str, ex.ch);
		System.out.print(ex.in + " and " + ex.str + " and ");
		System.out.println(ex.ch);
	}
}
