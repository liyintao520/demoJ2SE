package com.lyt.accessModifier;
/**
 * 这个包下面讲的是 【修饰符】的作用域
 * @author liyintao
 * @createDate 2016年10月13日 15:52
 */
public class Modifier {
	/**
	 * 1.private 私有的
	 * 被private所修饰的属性和方法
	 * 只能在该类内部使用
	 */
	private void c(){}
	/**
	 * 2.默认的（不加任何访问修饰符）
	 * A在类内部
	 * B相同包下面的类
	 */
	void d(){}
	/**
	 * 3.protected(受保护的)
	 * A 在类内部
	 * B 相同包下面的类
	 * C 子类(可以是不同的包)
	 */
	protected void b(){}
	/**
	 * 4.public 公共的
	 * 呗public修饰的属性和方法
	 * 可以被所有类访问
	 */
	public void a(){}
}
