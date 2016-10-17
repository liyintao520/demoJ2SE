package com.lyt.apache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
/**
 * 
 * @Title: CommonsCollections.java 
 * @Package com.lyt.apache 
 * @Description: TODO
 * @author 李银涛
 * @date 2016年10月17日 下午15:30:59 
 * @version V1.0
 * 作用：CollectionUtils  的用法
 * CollectionUtils.isNotEmpty(list)
 * CollectionUtils.isEmpty(emptyList)
 */
public class CommonsCollections {
	public static void main(String[] args) {
		List<String> emptyList = new ArrayList<String>();
		/*集合判断： 
		例1: 判断集合是否为空:*/
		System.out.println(CollectionUtils.isEmpty(emptyList));
		System.out.println(CollectionUtils.isEmpty(Arrays.asList("1", "2", "3")));

		/*例2: 判断集合是否不为空:*/
		System.out.println(CollectionUtils.isNotEmpty(emptyList));
		System.out.println(CollectionUtils.isNotEmpty(Arrays.asList("1", "2", "3")));
		System.out.println(CollectionUtils.union(
				Arrays.asList("1", "2", "3"), 
				Arrays.asList("2", "3", "5")));//并集{3, 2, 1, 5}
		
		System.out.println(CollectionUtils.intersection(
				Arrays.asList("1", "2", "3"), 
				Arrays.asList("2", "3", "5")));//交集{3, 2}
		
		System.out.println(CollectionUtils.disjunction(
				Arrays.asList("1", "2", "3"), 
				Arrays.asList("2", "3", "5")));//交集的补集{1, 5}
		
		System.out.println(CollectionUtils.subtract(
				Arrays.asList("2", "3", "5"), 
				Arrays.asList("1", "2", "3")));//list1与list2的差{1}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "dddd");
		map.put("b", 100);
		System.out.println(MapUtils.getString(map, "a"));
		System.out.println(MapUtils.getIntValue(map, "b"));
	}
}
