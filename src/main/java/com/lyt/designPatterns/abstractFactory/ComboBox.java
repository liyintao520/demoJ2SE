package com.lyt.designPatterns.abstractFactory;

/**
 * @Title: ComboBox.java
 * @Package com.lyt.designPatterns.abstractFactory
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月31日 上午11:58:52
 * @version V1.0
 */
// 组合框接口：抽象产品
public interface ComboBox {
	public void display();
}

// Spring组合框类：具体产品
class SpringComboBox implements ComboBox {
	public void display() {
		System.out.println("Spring组合框类:显示绿色边框组合框。");
	}
}

// Liyintao组合框类：具体产品
class LiyintaoComboBox implements ComboBox {
	public void display() {
		System.out.println("Liyintao组合框类：显示蓝色边框组合框。");
	}
}