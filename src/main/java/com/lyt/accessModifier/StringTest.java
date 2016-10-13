package com.lyt.accessModifier;

import org.junit.Test;

/**
 * 知识点 值传递 引用对象对比
 * @author liyintao
 * @createDate 2016年10月13日 15:52
 */
//TODO 不会
public class StringTest {
	@Test
	public void strTest(){
		String str = "abcd";
		String str2 = "cd";
		System.out.println(str == ("ab" + "cd"));//true
		System.out.println((str == "ab") + "cd");//true
		System.out.println(str == "ab" + str2);//false
	}
	@Test
	public void strTest2(){
		String str = "abcd";
		final String a = "ab";
		String b = "ab";
		System.out.println(str == a + "cd");//true
		System.out.println(str == b + "cd");//false
	}
	@Test
	public void strTest3(){
		String str = "abcd"; 
        final String a = "cd";
        String b = "cd";
        System.out.println(str == "ab" + a);//true
        System.out.println(str == "ab" + b);//false
        System.out.println(str.equals("ab" + b));//true
	}
}
