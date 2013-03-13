package com.demo.io;

import java.io.*;

public class FileExample {
	public FileExample() {
		super();// 调用父类的构造函数
	}

	public static void main(String[] args) {
		try {
			String outfile = "demoout.xml";
			// 定义了一个变量, 用于标识输出文件
			String infile = "demoin.xml";
			// 定义了一个变量, 用于标识输入文件
			DataOutputStream dt = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(outfile)));
			/**
			 * 用FileOutputStream定义一个输入流文件，
			 * 然后用BuferedOutputStream调用FileOutputStream对象生成一个缓冲输出流
			 * 然后用DataOutputStream调用BuferedOutputStream对象生成数据格式化输出流
			 */
			BufferedWriter NewFile = new BufferedWriter(new OutputStreamWriter(
					dt, "gbk"));// 对中文的处理
			DataInputStream rafFile1 = new DataInputStream(
					new BufferedInputStream(new FileInputStream(infile)));
			/**
			 * 用FileInputStream定义一个输入流文件，
			 * 然后用BuferedInputStream调用FileInputStream对象生成一个缓冲输出流
			 * ，其后用DataInputStream中调用BuferedInputStream对象生成数据格式化输出流
			 */
			BufferedReader rafFile = new BufferedReader(new InputStreamReader(
					rafFile1, "gbk"));// 对中文的处理
			String xmlcontent = "";
			char tag = 0;// 文件用字符零结束
			while (tag != (char) (-1)) {
				xmlcontent = xmlcontent + tag + rafFile.readLine();
			}
			NewFile.write(xmlcontent);
			NewFile.flush();// 清空缓冲区
			NewFile.close();
			rafFile.close();
			System.gc();// 强制立即回收垃圾，即释放内存。
		} catch (NullPointerException exc) {
			exc.printStackTrace();
		} catch (java.lang.IndexOutOfBoundsException outb) {
			System.out.println(outb.getMessage());
			outb.printStackTrace();
		} catch (FileNotFoundException fex) {
			System.out.println("fex" + fex.getMessage());
		} catch (IOException iex) {
			System.out.println("iex" + iex.getMessage());
		}
	}
}