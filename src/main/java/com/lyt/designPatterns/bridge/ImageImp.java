package com.lyt.designPatterns.bridge;

/** 
 * @Title: ImageImp.java 
 * @Package com.lyt.designPatterns.bridge 
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 下午3:18:04 
 * @version V1.0 
 */
/**抽象操作系统实现类：实现类接口  */
public interface ImageImp {
	 public void doPaint(Matrix m);  //显示像素矩阵m
}
/**Windows操作系统实现类：具体实现类  */
class WindowsImp implements ImageImp {  
	/**
	 * 调用Windows系统的绘制函数绘制像素矩阵  
	 */
	public void doPaint(Matrix m) {  
	    //调用Windows系统的绘制函数绘制像素矩阵  
	    System.out.print("在Windows操作系统中显示图像：");  
	}  
} 

/**Linux操作系统实现类：具体实现类 */ 
class LinuxImp implements ImageImp { 
	/**调用Linux系统的绘制函数绘制像素矩阵*/
	public void doPaint(Matrix m) {  
	    //调用Linux系统的绘制函数绘制像素矩阵  
	    System.out.print("在Linux操作系统中显示图像：");  
	}  
}  

/**Unix操作系统实现类：具体实现类  */
class UnixImp implements ImageImp {  
	/**
	 * 调用Unix系统的绘制函数绘制像素矩阵  
	 */
	public void doPaint(Matrix m) {  
	    //调用Unix系统的绘制函数绘制像素矩阵  
	    System.out.print("在Unix操作系统中显示图像：");  
	}  
}  
