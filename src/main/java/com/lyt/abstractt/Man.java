package com.lyt.abstractt;
/**
 * 子类 继承 父类：AbstractHuman
 * @author liyintao
 * 2016年10月13号 14:44
 */
public class Man extends AbstractHuman{

	public Man(String type) {
		super(type);
	}
	@Override
	public String toString() {
		return super.toString() + "男人说：";
	}
	@Override
	public void 具体业务() {
		System.out.println("妹子，我是来存钱的。");
	}
}
