package com.lyt.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
/**
 * 简单来说序列化就是把java对象存储在摸一个地方 （网络，硬盘等）方便传输
 * 序列化是从一种类型通过流的方式转换为另外一种类型的过程
 * 主要用于存储对象状态为另一种通用格式，比如存储为二进制、xml、json等等，把对象转换成这种格式就叫序列化，
 * 而反序列化通常是从这种格式转换回来。
 * 使用序列化主要是因为跨平台和对象存储的需求，因为网络上只允许字符串或者二进制格式，而文件需要使用二进制流格式，
 * 如果想把一个内存中的对象存储下来就必须使用序列化转换为xml（字符串）、json（字符串）或二进制（流）
 * @author liyintao
 *
 */
public class FastJsonTestCase {
	/**
     * 简单序列化
     */
	@Test
	public void simpleTest() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		user.setAge(20);
		User user2 = new User();
		user2.setUsername("admin2");
		user2.setPassword("123456");
		user2.setAge(24);
		// Arrays.asList(Object o)返回一个受指定数组支持的固定大小的列表
		List<Plot> list = Arrays.asList(new Plot("diudiu"), new Plot("dudu"));
		user.setList(list);
		/*Map<String,List<String>> map = new HashMap<String, List<String>>();
        map.put("somnus",Arrays.asList("1","2"));
        user.setMap(map);*/
		String jsonStr = JSON.toJSONString(user);
		System.out.println("简单序列化 jsonStr = " + jsonStr);
	}
	
	/**
     * 复杂序列化
     */
	@Test
	public void complexTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "owen");
        map.put("age", 25);
        map.put("sex", "男");
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("name", "jack");
        temp.put("age", 18);
        List<String> list = new ArrayList<String>();
        list.add("爬山");
        list.add("电影");
        list.add("旅游");
        map.put("hobby", list);

        String jsonStr = JSON.toJSONString(map);
        System.out.println("复杂序列化 jsonStr = " + jsonStr);
	}
	/**
     * 简单反序列化
     */
	@Test
	public void simpleDeserializeTest() {
		String jsonStr = "{\"username\":\"owen\",\"password\":\"passw0rd\", \"age\":24}";
		User user = JSON.parseObject(jsonStr, User.class);
		System.out.println("简单反序列化 :" + user);
	}
	/**
     * 泛型反序列化
     */
	@Test
    public void genericTypeDeserializeTest() {
		System.out.println("*******************泛型反序列化**********************");
		String jsonStr = "{\"user\":{\"username\":\"owen\",\"password\":\"passw0rd\", \"age\":24}}";
		Map<String, User> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, User>>(){});
		System.out.println(map.get("user") + "\n");
		String jsonStr2 = "{\"user\":[{\"username\":\"owen\", \"age\":24}, {\"username\":\"jack\", \"age\":18}]}";
		Map<String,List<User>> users = JSON.parseObject(jsonStr2, new TypeReference<Map<String, List<User>>>(){});
		for(User user : users.get("user")){
			System.out.println("user = "  + user);
			System.out.println("------------------");
		}
		
		String jsonStr3 = "[{\"username\":\"owen\", \"age\":24}, {\"username\":\"jack\", \"age\":18}]";
        List<User> list = JSON.parseObject(jsonStr3, new TypeReference<List<User>>(){});
        for (User user : list) {
        	System.out.println(user);
            System.out.println("------------------");
        }
	}
}
