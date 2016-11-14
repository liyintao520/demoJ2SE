package com.lyt.designPatterns.command;
/**
 * @Title: Client.java 
 * @Package com.lyt.designPatterns.command
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月07日 上午10:26:18 
 * @version V1.0 
 */
/**窗口处理类：请求接收者*/
public class WindowHanlder {
	public void minimize() {
		System.out.println("将窗口最小化至托盘！");
	}

}
/** 帮助文档处理类： 请求接收者 */
class HelpHandler {
	public void display() {
		System.out.println("显示帮助文档！");
	}
}
