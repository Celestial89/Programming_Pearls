package org.celestial;

/*
 * 	 大量数字排序，内存不足
 */

public class SectionOne_sort {

	/*
	 * 排序实现一：多趟读取，每趟读取一定范围内的数排序
	 */
	public static void mutiSort(int[] unsort) {
		int tag = 3000;
		while(tag <= 10000) {
			int[] readNum = new int[10000];  
			for(int i = 0; i < unsort.length; i++) {
				int min = tag - 2000;
				if(unsort[i] != 0) {
					if(unsort[i] >= min && unsort[i] < tag) {	//读取一定范围的数字
						readNum[i] = unsort[i];
					}
				}
			}
			quickSort(readNum, 0, readNum.length - 1);	//对这个范围的数字排序，快排
			
			for(int i : readNum) {
				if(i != 0)
					System.out.println(i);
			}
			
			tag += 2000;		//更改边界
		}
	}
	
	//快速排序实现
	public static void quickSort(int[] readNum, int low, int high) {
		if(low < high) {
			int p = sort(readNum, low, high);
			quickSort(readNum, low, p-1);
			quickSort(readNum, p+1, high);
		}
	}
	
	public static int sort(int[] readNum, int low, int high) {
		int num = readNum[low];
		while(low < high) {
			while(low < high && readNum[high] >= num)
				high--;
			readNum[low] = readNum[high]; 
			while(low < high && readNum[low] <= num)
				low++;
			readNum[high] = readNum[low];
		}
		readNum[low] = num;
		return low;
	}
	
	/*
	 * 排序实现二：用字节数组，如果有数字n，则将数组第n位设为1，效率比上面的方法高很多
	 */
	
	public static void charSort(int[] unsort) {
		char[] sort = new char[10000];
		for(int i = 0; i < sort.length; i++)	//初始化数组
			sort[i] = 0;
		
		for(int i = 0; i < unsort.length; i++) {	//如果数字n出现，则将数组第n位设为1
			if(unsort[i] != 0) {
				sort[unsort[i]] = 1;
			}
		}
		
		for(int i = 0; i < sort.length; i++) {
			if(sort[i] != 0)
				System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		int[] unsort = new int[10000];   //待排序数组
		int count = (int)(Math.random() * 9000) + 1000;  //随机数字数量从1000到10000
		
		//初始化数组
		for(int i = 0; i < count ; i++) {
			int num = (int)(Math.random() * 9000) + 1000;
			unsort[i] = num;
		}

		//mutiSort(unsort);
		charSort(unsort);
	}
}
