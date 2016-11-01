package com.lyt.designPatterns.chainOfResp;

public class Client {
	public static void main(String[] args) {
	    Approver wjzhang,gyang,jguo,meeting;  
	    wjzhang = new Director("张无忌");  //主任类：具体处理者
	    gyang = new VicePresident("杨过");  //副董事长类：具体处理者
	    jguo = new President("郭靖");  //董事长类：具体处理者
	    meeting = new Congress("董事会");  //董事会类：具体处理者
	  
	    //创建职责链  
	    wjzhang.setSuccessor(gyang);  
	    gyang.setSuccessor(jguo);  
	    jguo.setSuccessor(meeting);  
	      
	    //创建采购单  
	    PurchaseRequest pr1 = new PurchaseRequest(450000,10001,"购买倚天剑");  
	    wjzhang.processRequest(pr1);  
	      
	    PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");  
	    wjzhang.processRequest(pr2);  
	  
	    PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");  
	    wjzhang.processRequest(pr3);  

	    PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");  
	    wjzhang.processRequest(pr4);  

	}
}
