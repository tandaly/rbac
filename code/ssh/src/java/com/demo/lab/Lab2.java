package com.demo.lab;
/**
 * 试验2(测试这样的程序是不是挺2呐，嘿嘿)
 * switch的default无论放在哪里都一样哈
 * (还有一点default就像它的名字一样，无论放在哪里都一样哟)
 * @author Tandaly
 * @date 2013-3-13 上午10:52:47
 */
public class Lab2 {

	public void switchFun1(int i)
	{
		switch(i)
		{
		case 1: 
			System.out.println("你传入了1");
			break;
		case 2:
			System.out.println("你传入了2");
			break;
		default:
			System.out.println("你传入的不是1也不是2");
			break;
		}
	}
	
	public void switchFun2(int i)
	{
		switch(i)
		{
		default:
			System.out.println("你传入的不是1也不是2");
			break;
		case 1: 
			System.out.println("你传入了1");
			break;
		case 2:
			System.out.println("你传入了2");
			break;
		
		}
	}
	
	public static void main(String[] args) {
		
		//-------------试试看两个函数执行的结果是否一样呐--------------------
		Lab2 l = new Lab2();
		l.switchFun1(1);
		l.switchFun2(1);
		
		//---------------华丽的分割线--------------
		
		l.switchFun1(3);
		l.switchFun2(3);
	}
}
