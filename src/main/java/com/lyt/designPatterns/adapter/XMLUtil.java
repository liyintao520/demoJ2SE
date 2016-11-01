package com.lyt.designPatterns.adapter;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/** 
 * @Title: XMLUtil.java 
 * @Package com.lyt.designPatterns.adapter
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 上午11:25:47 
 * @version V1.0 
 * 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
 */
public class XMLUtil {
	public static Object getBean() throws Exception {
		SAXReader reader = new SAXReader();
		String path = XMLUtil.class.getClassLoader().getResource("com/lyt/designPatterns/adapter/config.xml").getPath();
		Document document = reader.read(new File(path));
		//获取XML文档中的内容：<config><className>内容</className></config>
		//Document的selectNodes(String XPath)方法 还要有jaxen 包的依赖做支持
		String cName = document.selectSingleNode("/config/className").getText();
		//通过类名生成实例对象并将其返回
		Class<?> c = Class.forName(cName);//Class.forName("")返回的是类
		//Class.forName("").newInstance()返回的是object 
		Object obj = c.newInstance();//newInstance( )静态方法来实例化对象
		return obj;
	}
}
