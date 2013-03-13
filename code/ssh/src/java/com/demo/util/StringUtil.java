package com.demo.util;
/**
 * 字符操作
 * @author Tandaly
 * @date 2013-3-12 上午8:35:06
 */
public class StringUtil {

	/**
	 * 统计某个字符串出现的次数
	 * @param source 源字符串
	 * @param target 目标字符串
	 * @return
	 */
	public static int countChar(String source, String target)
	{
		//如果源字符串为空则返回0
		if(null == source || "".equals(source))
		{
			return 0;
		}
		
		int index = -1;//位置索引
		int count = 0; //统计变量
		//循环统计目标字符串在源字符串出现的次数
		while(true)
		{
			index = source.indexOf(target, index+1);
			if(index >= 0)
			{
				count++;
				continue;
			}
			break;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		String str = "13242 342343 ";
		int count = countChar(str, "1");
		System.out.println(count);
	}
}
