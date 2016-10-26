package com.lyt.array;

import java.util.Arrays;

/** 
 * @Title: ArrayCopy.java 
 * @Package com.lyt.array 
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月19日 上午11:21:24 
 * @version V1.0 
 * 数组的拷贝
 * System.arraycopy(源数组,源数组中的起始位置,目标数组,目标数据中的起始位置,要复制的源数组元素的数量)
 */
public class ArrayCopy {
	public static void main(String[] args) {
		int[] ids1 = {1,2,3,4,5};
		int[] ids2 = new int[10];
		/** 源数组,源数组中的起始位置,目标数组,目标数据中的起始位置,要复制的源数组元素的数量*/
		System.arraycopy(ids1, 1, ids2, 0, 3);//从ids1 数组中的坐标为1 的位置开始，复制到ids2 数组中，从ids2的 0坐标开始复制， 复制数量为3
		/*[2, 3, 4, 0, 0, 0, 0, 0, 0, 0]*/
		System.out.println("从ids1复制到ids2，现在ids2 为： " + Arrays.toString(ids2));
		
		int[] idsa = { 1, 2, 3, 4, 5 };
        int[] idsb = new int[10];
        /*[0, 1, 2, 3, 0, 0]*/
        System.arraycopy(idsa, 0, idsb, 1, 3);
        System.out.println(Arrays.toString(idsb));
	}
}
