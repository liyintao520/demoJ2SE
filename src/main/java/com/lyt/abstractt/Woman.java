package com.lyt.abstractt;
/**
 * 子类 继承 父类：AbstractHuman
 * @author liyintao
 * 2016年10月13号 14:44
 */
public class Woman extends AbstractHuman{
	/**
	 * 父类有构造器的话，子类必须写自己的构造器
	 * @param type
	 */
	public Woman(String type) {
		super(type);
	}

	@Override
	public String toString() {
		return super.toString() + "女人说：";
	}
	public void 具体业务() {
		System.out.println("美女，刚才我老公存钱了，我是来取钱的！");
	}
}
