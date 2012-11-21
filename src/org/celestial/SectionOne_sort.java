package org.celestial;

/*
 * 	 �������������ڴ治��
 */

public class SectionOne_sort {

	/*
	 * ����ʵ��һ�����˶�ȡ��ÿ�˶�ȡһ����Χ�ڵ�������
	 */
	public static void mutiSort(int[] unsort) {
		int tag = 3000;
		while(tag <= 10000) {
			int[] readNum = new int[10000];  
			for(int i = 0; i < unsort.length; i++) {
				int min = tag - 2000;
				if(unsort[i] != 0) {
					if(unsort[i] >= min && unsort[i] < tag) {	//��ȡһ����Χ������
						readNum[i] = unsort[i];
					}
				}
			}
			quickSort(readNum, 0, readNum.length - 1);	//�������Χ���������򣬿���
			
			for(int i : readNum) {
				if(i != 0)
					System.out.println(i);
			}
			
			tag += 2000;		//���ı߽�
		}
	}
	
	//��������ʵ��
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
	 * ����ʵ�ֶ������ֽ����飬���������n���������nλ��Ϊ1��Ч�ʱ�����ķ����ߺܶ�
	 */
	
	public static void charSort(int[] unsort) {
		char[] sort = new char[10000];
		for(int i = 0; i < sort.length; i++)	//��ʼ������
			sort[i] = 0;
		
		for(int i = 0; i < unsort.length; i++) {	//�������n���֣��������nλ��Ϊ1
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
		int[] unsort = new int[10000];   //����������
		int count = (int)(Math.random() * 9000) + 1000;  //�������������1000��10000
		
		//��ʼ������
		for(int i = 0; i < count ; i++) {
			int num = (int)(Math.random() * 9000) + 1000;
			unsort[i] = num;
		}

		//mutiSort(unsort);
		charSort(unsort);
	}
}
