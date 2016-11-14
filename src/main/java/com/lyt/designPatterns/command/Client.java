package com.lyt.designPatterns.command;
/**
 * @Title: Client.java 
 * @Package com.lyt.designPatterns.command
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月07日 上午10:26:18 
 * @version V1.0 
 */
public class Client {
	public static void main(String[] args) throws Exception {
		FBSettingWindow fbsw = new FBSettingWindow("功能键设置：");
		FunctionButton fb1,fb2;
		//赋值
		fb1 = new FunctionButton("功能键1");
		fb2 = new FunctionButton("功能键2");
		
		Command command1, command2;
		//通过读取配置文件和反射生成具体命令对象
		command1 = (Command) XMLUtil.getBean("firstCommand");
		command2 = (Command) XMLUtil.getBean("secondCommand");
		
		//将命令对象注入功能键
		fb1.setCommand(command1);
		fb2.setCommand(command2);
		
		fbsw.addFunctionButton(fb1);
		fbsw.addFunctionButton(fb2);
		fbsw.display();
		
		//调用功能键的业务方法
		fb1.onClick();
		fb2.onClick();
	}
}
