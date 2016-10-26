package com.lyt.array;
/**
 * 二分查找法：二分查找法是对一组【有序】的数字中进行查找
 * @author liyintao
 */
public class BinarySearch {
	public static int binarySearch(int[] array, int value){
		int low = 0;//第一个位置.
		int high = array.length -1 ;//最高位置.数组长度-1,因为下标是从0开始的.  
		int middle = 0;//中间位置计算,low + 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2  
		while(low <= high){
			middle = (low + high)/2;//0 6    4 6   6 6
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
				if(i == middle){//3 5 6 紧随着最中间的指向 后面 打印分隔符
					System.out.println("$$  ");
				}
			}
			System.out.println();
			if(array[middle] == value){//与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.  
				return middle;
			}
			if(value < array[middle]){ //如果小于的话则移动最高层的"指针"  
				high = middle - 1;
			}
			if(value > array[middle]){//移动最低的"指针"   
				low = middle + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {7,3,9,5,6,8,1};
		int[] array1 = BubbleSort.bubbleSort(array);//冒泡排序 变成有序数组
		int index = binarySearch(array1, 1);
		System.out.println("所在的位置： " + index);
 	}
	
	
    /** 
     * 递归方法实现二分查找法. 
     * @param Array数组 
     * @param low 数组第一位置 
     * @param high 最高 
     * @param key 要查找的值. 
     * @return 返回值. 
     */  
    public int BinSearch(int Array[],int low,int high,int key) {  
        if (low<=high) {  
            int mid = (low+high)/2;  
            if(key == Array[mid])  
                return mid;  
            else if(key<Array[mid])  
                //移动low和high  
                return BinSearch(Array,low,mid-1,key);  
            else if(key>Array[mid])  
                return BinSearch(Array,mid+1,high,key);  
        }  
        else  
            return -1;
		return -1; 
    }
}
