package com.demo.lab;
/**
 * 搜索器
 * @author Tandaly
 * @date 2013-3-13 下午2:50:16
 */
public class Lab4 {

	/**
	 * 返回字符在字符数组中的索引(采用了闭合原则)
	 * @param arr
	 * @param c
	 * @return
	 */
	public static int indexOf(char[] arr, char c)
	{
		int i;//索引指针
		
		//如果指针不等于数组长度且字符不等于指针所指向的字符数组的值就进行循环(看看这个经典的写法哦)
		for(i = 0; arr.length != i && c != arr[i]; i++);
		
		//如果指针等于字符数组的长度，那么说明没有找到
		if(arr.length == i)
		{
			i = -1;
		}
		
		return i;
	}
	
	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args)
	{
		char[] arr = new char[]{'1', 's', 't'};
		
		int index = indexOf(arr, 't');
		
		System.out.println(index);
	}
}
