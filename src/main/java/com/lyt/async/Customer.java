package com.lyt.async;

import com.lyt.async.Cake;
import com.lyt.async.CakeShop;

public class Customer {
	public static void main(String[] args) {

		System.out.println("主函数开始");
		CakeShop host = new CakeShop();
		Cake cake1 = host.request(10, 'A');
		/*Cake cake2 = host.request(20, 'B');
		Cake cake3 = host.request(30, 'C');*/
		System.out.println("主函数  其他工作者otherJob  开始");
		try {
			System.out.println("沉睡 2 秒钟....");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		System.out.println("主函数  其他工作者otherJob  结束");
		System.out.println("cake1 = " + cake1.getCake());
		/*System.out.println("cake2 = " + cake2.getCake());
		System.out.println("cake3 = " + cake3.getCake());*/
		System.out.println("主函数结束");

	
	}
}
