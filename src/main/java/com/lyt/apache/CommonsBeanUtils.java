package com.lyt.apache;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

/**
 * @Title: CommonsBeanUtils.java 
 * @Package com.lyt.apache 
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月17日 上午 11：44
 * @version V1.0
 * BeanUtils.cloneBean(person) 克隆对象
 * BeanUtils.populate(person, map);将map转化为一个Person对象
 * BeanUtils.describe(person);将一个Bean转化为一个Map对象了
 * BeanUtils.copyProperties(people, person);拥有相同属性的对象转换
 */
public class CommonsBeanUtils {
	@Test
	public void cloneBean() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
		Person person = new Person();
		person.setName("tom");
		person.setAge(21);
		/*克隆对象BeanUtils.cloneBean(Object);*/
		Person person2 = (Person) BeanUtils.cloneBean(person);
		System.out.println("克隆对象》》 " + person2);
	}
	@SuppressWarnings("unchecked")
	@Test
    public void populate() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "tom");
		map.put("email", "tom@163.com");
		map.put("age", "21");
		map.put("sex", "男");
		/*将map转化为一个Person对象*/
		Person person = new Person();
		BeanUtils.populate(person, map);
		System.out.println("将map转化为一个Person对象>>" + person);
        /*通过上面的一行代码，此时person的属性就已经具有了上面所赋的值了。*/
        /*将一个Bean转化为一个Map对象了，如下：*/
		Map<String, String> beanMap = BeanUtils.describe(person);
		System.out.println("将一个Bean转化为一个Map对象了...");
		System.out.println("name : " + beanMap.get("name") + " >> age : " + beanMap.get("age"));
	}
	/**
	 * 拥有相同属性的对象转换
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test
    public void copyProperties() throws IllegalAccessException, InvocationTargetException{
        Person person = new Person();
        person.setName("tom");
        person.setAge(21);
        /*拥有相同属性的对象转换*/
        People people = new People();
        BeanUtils.copyProperties(people, person);
        System.out.println("拥有相同属性的对象转换>> " + people);
    }
	@Test
    public void reflect() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Person person = new Person();
        person.setName("andy");
        /*反射调用get方法*/
        String name = (String) PropertyUtils.getProperty(person, "name");
        System.out.println("反射调用get方法 : " + name);
        /**反射调用set方法*/
        PropertyUtils.setProperty(person, "age", 25);
        System.out.println("反射调用set方法 : " + person.getAge());
	}
	
	@Test
    public void reflect2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        Person person = new Person();
        MethodUtils.invokeMethod(person, "setName", new Object[] { "andy" });
        String name = (String) MethodUtils.invokeMethod(person, "getName", new Object[] { });
        System.out.println("  MethodUtils.invokeMethod的用法： " + name);
    }
}
