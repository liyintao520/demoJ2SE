package com.lyt.designPatterns.command;

/**
 * @Title: Command.java 
 * @Package com.lyt.designPatterns.command
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月07日 上午10:26:18 
 * @version V1.0 
 */
//抽象命令类
public abstract class Command {
	public abstract void execute();
}
/**帮助命令类：具体命令类*/
class HelpCommand extends Command {
	private HelpHandler hhObj;//维持对请求接收者的引用
	
	public HelpCommand() {
		hhObj = new HelpHandler();
	}
	//命令执行方法，将调用请求接收者的业务方法  
	public void execute() {  
		hhObj.display();  
	}  
}
/**最小化命令类： 具体命令类*/
class MinimizeCommand extends Command {
	private WindowHanlder whObj;//维持对请求接收者的引用
	
	public MinimizeCommand() {
		whObj = new WindowHanlder();
	}
	
	//命令执行方法，将调用请求接收者的业务方法  
	@Override
	public void execute() {
		whObj.minimize();
	}
}