package com.lyt.accessModifier;

/**
 * java只有按值传递，没有按引用传递
 * 参考资料 ：http://pan.baidu.com/disk/home#list/path=%2F%E8%A1%A8%E5%A7%90%E7%9A%84%E7%BD%91%E7%9B%98%2FJ2SE
 * @author liyintao
 * @createDate 2016年10月13日 15:52
 */
public class PassByValueDemo2 {
    int num = 9;
    String str = "love";
	char[] ch = {'h','e','l','l','o'};
	void change(int num,char[] ch,String str){
		num = 10;
		ch[0] = 'm';
		ch = new char[]{'w','o','r','l','d'};
		ch[0] = 'n';
		str = "you";
	}
	public static void main(String[] args) {
		PassByValueDemo2 t = new PassByValueDemo2();
		t.change(t.num,t.ch,t.str);
		System.out.print("num:"+t.num+" str:"+t.str+" ch:");
		System.out.println(t.ch);
	}
}

