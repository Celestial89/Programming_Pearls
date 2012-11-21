package org.celestial;

/*
 * 		���ַ��������ƶ�nλ
 */

public class SectionTwo_reverse {
	
	/*
	 * ��ת�㷨, �Ƚ�ǰn����ת���ٽ����µķ�ת�����������ת
	 */
	public static void reverse(String s, int num) {
		System.out.println(s);
		
		int begin = 0;
		int end = num - 1;
		char[] arr = s.toCharArray();
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		begin = num;
		end = s.length() - 1;
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		begin = 0;
		end = s.length() - 1;
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}

		System.out.println(new String(arr));
	}
	
	public static void main(String[] args) {
		
		String s = "bcdefgkmn";
		reverse(s, 4);
	}

}
