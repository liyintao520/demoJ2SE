package com.lyt.designPatterns.bridge;

/** 
 * @Title: Image.java 
 * @Package com.lyt.designPatterns.bridge 
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 下午3:16:39 
 * @version V1.0 
 */
/**抽象图像类：抽象类  */
public abstract class Image {
	protected ImageImp imp;
	
	public void setImageImp(ImageImp imp) {  
	      this.imp = imp;  
	  }  
	public abstract void parseFile(String fileName); 
}

/**JPG格式图像：扩充抽象类  */
class JPGImage extends Image {
	@Override
	public void parseFile(String fileName) {
		//模拟解析PNG文件并获得一个像素矩阵对象m;
		Matrix m = new Matrix();
		imp.doPaint(m);
		System.out.println(fileName + ", 格式为JPG。");
	}  
}
/**BMP格式图像：扩充抽象类*/  
class BMPImage extends Image {
	/**模拟解析BMP文件并获得一个像素矩阵对象m;  */  
	public void parseFile(String fileName) {  
	    //模拟解析BMP文件并获得一个像素矩阵对象m;  
	    Matrix m = new Matrix();   
	    imp.doPaint(m);  
	    System.out.println(fileName + "，格式为BMP。");  
	}  
} 


/**GIF格式图像：扩充抽象类  */
class GIFImage extends Image {  
	/**模拟解析GIF文件并获得一个像素矩阵对象m; */
	public void parseFile(String fileName) {  
	    //模拟解析GIF文件并获得一个像素矩阵对象m;  
	    Matrix m = new Matrix();   
	    imp.doPaint(m);  
	    System.out.println(fileName + "，格式为GIF。");  
	}  
}  


