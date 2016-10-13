package com.lyt.abstractt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liyintao
 * @createDate: 2016年10月13号 14:40
 * @description: 抽象类AbstractHuman
 * 通过继承它实现多态，后期绑定，可以为将来要实现的东西做好接口，实现重用性，
 */
public abstract class AbstractHuman {
	private final Set<String> types;
	/**
	 * 带参构造器
	 * @param String：type
	 */
	public AbstractHuman(String type){
		System.out.println("AbstractHuman is invoked!这个类被调用");
//		Arrays.asList() 返回一个受指定数组支持的固定大小的列表。
		this.types = new HashSet<String>(Arrays.asList(type));
	}
	/**
	 * //java.util.Set contains(Object o) 
	 * 如果 set 包含指定的元素，则返回 true。
	 * @param type
	 * @return 判断是否包含 是 true  否 false
	 */
	protected boolean isSupport(String type) {
		return types.contains(type);
	}
	
	protected void 办理银行业务(){
		取号();
		具体业务();
		评价();
	}
	private void 取号() {
		System.out.println("取号");
	}
	public abstract void 具体业务();
	private void 评价() {
		System.out.println("评价");
	}
}
	

	

	
