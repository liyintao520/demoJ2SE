package com.lyt.apache;

import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * @Title: CommonsConfiguration.java 
 * @Package com.lyt.apache 
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月17日 下午15:29
 * @version V1.0
 * 作用：对配置文件的操作。比如读取配置文件并利用配置文件信息
 */
public class CommonsConfiguration {
	
	public void configuration(){
		//age=25 password=123456 username=dreamsunday
		String fileName = "info.properties";
		try {
			String url = getClass().getClassLoader().getResource(fileName).getPath();
			System.out.println(url);
			PropertiesConfiguration config = new PropertiesConfiguration(url);
			//这样可以修改配置文件中属性对应的值：
			//config.setProperty("age", "23");
			//config.save();
			
			Integer age = config.getInt("age");
			String username = config.getString("username");
			System.out.println("age : " + age);
            System.out.println("username : " + username);
            System.out.println("用Iterator实现遍历集合 :");
            for(Iterator<String> it = config.getKeys();it.hasNext();){
                String key = (String)it.next();
                String value = config.getString(key);
                System.out.println(key +"="+value);
            }
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
        CommonsConfiguration config = new CommonsConfiguration();
        config.configuration();
    }
}
