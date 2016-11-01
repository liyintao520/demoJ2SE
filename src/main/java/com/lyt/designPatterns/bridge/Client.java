package com.lyt.designPatterns.bridge;

public class Client {
	public static void main(String[] args) throws Exception {
		Image image = (Image)XMLUtil.getBean("image");//这个类对应的是图片格式类
	    ImageImp os = (ImageImp)XMLUtil.getBean("os");//这个是显示的操作系统
//	    ImageImp linux = (ImageImp)XMLUtil.getBean("linux");//这个是显示的操作系统
//	    ImageImp unix = (ImageImp)XMLUtil.getBean("unix");//这个是显示的操作系统
	    image.setImageImp(os);  
//	    image.setImageImp(linux);  
//	    image.setImageImp(unix);  
	    image.parseFile("小龙女");
	}
}
