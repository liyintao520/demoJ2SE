package com.lyt.designPatterns.bridge;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * @Title: XMLUtil.java 
 * @Package com.lyt.designPatterns.bridge
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 下午3:25:47 
 * @version V1.0 
 *
 */
/** 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  */
public class XMLUtil {
	//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
	public static Object getBean(String args) throws Exception {
		SAXReader reader = new SAXReader();
		String path = XMLUtil.class.getClassLoader().getResource("com/lyt/designPatterns/bridge/config.xml").getPath();
		Document document = reader.read(new File(path));
		String cName = null;
		//selectSingleNode() 方法查找和 XPath 查询匹配的一个节点。
		if(args.equals("image")){
			cName = document.selectSingleNode("/config/image").getText();
		} else if(args.equals("os")) {
			//获取第二个包含类名的节点，即具体实现类  
            cName = document.selectSingleNode("/config/os").getText();
		}else if(args.equals("linux")) {
			//获取第二个包含类名的节点，即具体实现类  
            cName = document.selectSingleNode("/config/linux").getText();
		}else if(args.equals("unix")) {
			//获取第二个包含类名的节点，即具体实现类  
            cName = document.selectSingleNode("/config/unix").getText();
		}
		//通过类名生成实例对象并将其返回  
        Class<?> c = Class.forName(cName);  
        Object obj = c.newInstance();  
        return obj;  
	}
}
