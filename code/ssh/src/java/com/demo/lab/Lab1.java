package com.demo.lab;
/**
 * 试验一
 * 检验i = i++ 对程序的影响
 * @author Tandaly
 * @date 2013-3-13 上午10:02:24
 */
public class Lab1 {

	public static void main(String[] args)
	{
		int i = 2;
		
		i = i++;
		
		System.out.println("测试一的结果：" + i);
		
		//----------------华丽的分割线----------------------
		int j = 2;
		
		j = ++j;//此处编译器支出该语句应该写成 ++j,为了和试验一做对比所以这样写
		
		System.out.println("测试二的结果：" + j);
	}
}
