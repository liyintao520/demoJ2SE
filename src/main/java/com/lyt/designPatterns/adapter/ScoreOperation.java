package com.lyt.designPatterns.adapter;

/**
 * @Title: ScoreOperation.java
 * @Package com.lyt.designPatterns.adapter
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 上午午11:54:44
 * @version v1.0
 */
/**抽象成绩操作类：目标接口*/
public interface ScoreOperation {
	/**
	 * 成绩排序
	 * @param array
	 * @return
	 */
	public int[] sort(int array[]);//成绩排序
	
	/**
	 * 成绩查找:利用二分查找法查找
	 * @param array
	 * @param key
	 * @return
	 */
	public int search(int array[], int key);//成绩查找
}
/**
 * 快速排序类：适配者
 * @author liyintao
 */
class QuickSort{
	/**
	 * 快速排序类：适配者  快速排序法
	 * @param array
	 * @return
	 */
	public int[] quickSort(int array[]){
		sort(array, 0, array.length - 1);
		return array;
	}

	private void sort(int array[], int p, int r) {
		int q = 0;
		if(p < r){
			q = partition(array, p, r);
			sort(array, p, q - 1);
	        sort(array, q + 1, r);
		}
	}

	public int partition(int[] a, int p, int r) {
		int x = a[r];
		int j = p-1;
		for (int i = p; i < r-1; i++) {
			if(a[i] <= x){
				j++;
				swap(a, j, i);
			}
		}
		swap(a, j + 1, r);
		return j + 1;
	}
	/**
	 * 用来交换位置的
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[] a, int i, int j) {
    	int t = a[i];
        a[i] = a[j];
        a[j] = t;
	}
}

class BinarySearch{
	/**
	 * 二分查找类：适配者
	 * 二分查找法：二分查找法是对一组【有序】的数字中进行查找
	 * */
	public int binarySearch(int array[], int key){
		int low = 0;//第一个位置.
		int high = array.length - 1;//最高位置.数组长度-1,因为下标是从0开始的.  
		int mid = 0;//中间位置计算,low + 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
		while(low <= high){
			mid = (low + high) / 2;
			int midVal = array[mid];
			if(midVal < key){//移动最低的"指针"  
				low = mid + 1;
			}else if (midVal > key) {//如果key小于midVal的话则移动最高层的"指针" 
                high = mid - 1;
            } else {
                return 1; // 找到元素返回1
            }
		}
		return -1; // 未找到元素返回-1
	}
}
/**
 * 操作适配器：适配器
 */
class OperationAdapter implements ScoreOperation {
	private QuickSort sortObj;// 定义适配者QuickSort对象
	private BinarySearch searchObj;// 定义适配者BinarySearch对象 
	
	public OperationAdapter() {
    	sortObj = new QuickSort();
    	searchObj = new BinarySearch();
	}

	@Override
	public int[] sort(int[] array) {
		return sortObj.quickSort(array);// 调用适配者类QuickSort的排序方法
	}

	@Override
	public int search(int[] array, int key) {
		return searchObj.binarySearch(array, key); // 调用适配者类BinarySearch的查找方法
	}
	
}





