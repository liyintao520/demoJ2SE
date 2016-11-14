package com.lyt.designPatterns.command;

/**
 * @Title: FunctionButton.java 
 * @Package com.lyt.designPatterns.command
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月07日 上午10:26:18 
 * @version V1.0 
 */
public class FunctionButton {
	private String name; // 功能键名称
	private Command command; // 维持一个抽象命令对象的引用
	public FunctionButton(String name) {
		this.name = name;
	}
	public String getName() {
        return this.name;
    }
	//为功能键注入命令
	public void setCommand(Command command) {
		this.command = command;
	}
	
	//发送请求的方法
	public void onClick() {
		System.out.println("点击功能键：");
		command.execute();
	}
}
