package com.lyt.designPatterns.builder;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/** 
 * @Title: XMLUtil.java 
 * @Package com.lyt.designPatterns.builder
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 下午16:25:47 
 * @version V1.0 
 */
public class XMLUtil {
	//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
	public static Object getBean(String str) throws Exception{
		SAXReader reader = new SAXReader();
		String path = XMLUtil.class.getClassLoader().getResource("com/lyt/designPatterns/builder/config.xml").getPath();
		Document document = reader.read(new File(path));
		String cName = null;
		if(str.equals("angelBuilder")){
			cName = document.selectSingleNode("/config/angelBuilder").getText();
		} else if(str.equals("devilBuilder")){
			cName = document.selectSingleNode("/config/devilBuilder").getText();
		} else if(str.equals("heroBuilder")){
			cName = document.selectSingleNode("/config/heroBuilder").getText();
		}
		Class<?> c = Class.forName(cName);
		Object obj = c.newInstance();
		return obj;
	}
}
