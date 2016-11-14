package com.lyt.test;

import java.io.File;
/**
 * 获取项目中，包下面的所有java文件
 * @author liyintao
 */
public class TestGetBean {
	 public static void main(String[] args) throws Exception {
	    	String packageName = "";
	    	System.out.println("当前项目所在硬盘的绝对路径：" + System.getProperty("user.dir")); // 当前项目所在硬盘的绝对路径
	    	File root = new File(System.getProperty("user.dir") + "\\src");
	    	System.out.println("root = " + root);
			loop(root, packageName);
		}
		public static void loop(File folder, String packageName) throws Exception {
	    	File[] files = folder.listFiles();
	    	for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
		    	File file = files[fileIndex];
		    	if (file.isDirectory()) {
		    		loop(file, packageName + file.getName() + ".");
		    	} else {
		    		System.out.println("ClassName:"+file.getName());
	 	    	}
	    	}
		}
		

}
