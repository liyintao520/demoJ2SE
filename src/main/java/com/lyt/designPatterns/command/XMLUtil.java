package com.lyt.designPatterns.command;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * @Title: XMLUtil.java 
 * @Package com.lyt.designPatterns.command
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月07日 上午10:26:18 
 * @version V1.0 
 */
public class XMLUtil {
	public static Object getBean(String args) throws Exception {
		SAXReader reader = new SAXReader();
		String path = XMLUtil.class.getClassLoader().getResource("com/lyt/designPatterns/command/config.xml").getPath();
		Document document = reader.read(new File(path));
		String cName = null;
		if(args.equals("firstCommand")){
			cName = document.selectSingleNode("/config/firstCommand").getText();
		}else if(args.equals("secondCommand")) {  
            //获取第二个包含类名的节点，即具体实现类  
            cName = document.selectSingleNode("/config/secondCommand").getText();
        } 
		//通过类名生成实例对象并将其返回
		Class<?> c = Class.forName(cName);
		Object obj = c.newInstance();
		return obj;
	}
}
