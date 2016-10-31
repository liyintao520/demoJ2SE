package com.lyt.designPatterns.abstractFactory;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/** 
 * @Title: XMLUtil.java 
 * @Package com.lyt.designPatterns.abstractFactory
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月31日 上午11:25:47 
 * @version V1.0 
 */
/**http://blog.csdn.net/yyywyr/article/details/38359049
 * http://blog.csdn.net/redarmy_chen/article/details/12969219
 * DOM4j中，获得Document对象的方式有三种：
 *     1.读取XML文件,获得document对象              
                      SAXReader reader = new SAXReader();                
           Document   document = reader.read(new File("csdn.xml"));  
    2.解析XML形式的文本,得到document对象.  
                      String text = "<csdn></csdn>";              
                      Document document = DocumentHelper.parseText(text);  
    3.主动创建document对象.  
                     Document document = DocumentHelper.createDocument();             //创建根节点  
                     Element root = document.addElement("csdn");  
 * @author liyintao
 *
 */
public class XMLUtil {
	//该方法用于从XML配置文件中提取图表类型，并返回类型名  
	public static Object getBean() throws Exception{
		SAXReader reader = new SAXReader();
		String path = XMLUtil.class.getClassLoader().getResource("com/lyt/designPatterns/abstractFactory/config.xml").getPath();
		Document document = reader.read(new File(path));
		//获取XML文档中的内容：<config><className>内容</className></config>
		//Document的selectNodes(String XPath)方法 还要有jaxen 包的依赖做支持
		String cName = document.selectSingleNode("/config/className").getText();
		//通过类名生成实例对象并将其返回
		Class<?> c = Class.forName(cName);
		Object obj = c.newInstance();
		return obj;
	}
}
