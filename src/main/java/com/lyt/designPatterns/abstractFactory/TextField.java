package com.lyt.designPatterns.abstractFactory;

/**
 * @Title: TextField.java
 * @Package com.lyt.designPatterns.abstractFactory
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月31日 下午16:59:25
 * @version V1.0
 */
// 文本框接口：抽象产品
public interface TextField {
	public void display();
}

// Spring文本框类：具体产品
class SpringTextField implements TextField {
	public void display() {
		System.out.println("Spring文本框类：显示绿色边框文本框。");
	}
}

// Liyintao文本框类：具体产品
class LiyintaoTextField implements TextField {
	public void display() {
		System.out.println("Liyintao文本框类：显示蓝色边框文本框。");
	}
}