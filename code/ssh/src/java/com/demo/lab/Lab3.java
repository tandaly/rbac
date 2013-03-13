package com.demo.lab;

/**
 * 打印一个空心菱形(如要打印实心的，请去掉打印方法中的注释即可)
 * @author Tandaly
 * @date 2013-3-13 下午2:09:50
 */
public class Lab3 {

	final static int LOW = 13;//总行数
	
	/**
	 * 打印一行
	 * @param n 总长度
	 * @param p 坐标1
	 * @param q 坐标2
	 */
	public static void printLine(int n, int p, int q)
	{
		for(int i = 1; i <= n; i++)
		{
			if(i == p || i == q)
			{
				System.out.print("*");
			/*去掉一下注释可以打印一个实心的*/
			/* 
			}
			else if(i >  p && i < q)
			{
				System.out.print("*");
			*/
			}else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	/**
	 * 打印空心菱形
	 */
	public static void printDiamond()
	{
		int p, q, n = LOW/2 + 1;
		
		p = q = n;
		
		for(int i = 1; i <= LOW; i++)
		{
			printLine(LOW, p, q);
			if(i < n)
			{//控制前半部分
				p--;
				q++;
			}
			else
			{//控制后半部分
				p++;
				q--;
			}
		}
		
	}
	
	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args)
	{
		printDiamond();//打印一个空心菱形
	}
}
