package com.demo.io;

import java.io.*;
import java.util.*;

public class FileRW {
	// 需要输入的person数目。
	public static int NUMBER = 3;

	public static void main(String[] args) {
		Person[] people = new Person[NUMBER];
		// 暂时容纳输入数据的临时字符串数组。
		String[] field = new String[4];
		// 初始化field数组。
		for (int i = 0; i < 4; i++) {
			field[i] = "";
		}
		// IO操作必须捕获IO异常。
		try {
			// 用于对field数组进行增加控制。
			int fieldcount = 0;
			// 先使用System.in构造InputStreamReader，再构造BufferedReader。
			BufferedReader stdin = new BufferedReader(new InputStreamReader(
					System.in));
			for (int i = 0; i < NUMBER; i++) {
				fieldcount = 0;
				System.out.println("The number " + (i + 1) + " person");
				System.out
						.println("Enter name,age,salary,married(optional),please separate fields by ':'");
				// 读取一行。
				String personstr = stdin.readLine();
				// 设置分隔符。
				StringTokenizer st = new StringTokenizer(personstr, ":");
				// 判断是否还有分隔符可用。
				while (st.hasMoreTokens()) {
					field[fieldcount] = st.nextToken();
					fieldcount++;
				}
				// 如果输入married，则field[3]不为空，调用具有四个参数的Person构造函数。
				if (field[3] != "") {
					people[i] = new Person(field[0],
							Integer.parseInt(field[1]),
							Double.parseDouble(field[2]), field[3]);
					// 置field[3]为空，以备下次输入使用。
					field[3] = "";
				}
				// 如果未输入married，则field[3]为空，调用具有三个参数的Person构造函数。
				else {
					people[i] = new Person(field[0],
							Integer.parseInt(field[1]),
							Double.parseDouble(field[2]));
				}
			}
			// 将输入的数据保存至“people.dat”文本文件中。
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("people.dat")));
			writeData(people, out);
			// 关闭流。
			out.close();
			// 从文件“people.dat”读取数据。
			BufferedReader in = new BufferedReader(new FileReader("people.dat"));
			Person[] inPeople = readData(in);
			// 关闭流。
			in.close();
			// 输出从文件中读入的数据。
			for (int i = 0; i < inPeople.length; i++) {
				System.out.println(inPeople[i]);
			}
		} catch (IOException exception) {
			System.err.println("IOException");
		}
	}

	// 将所有数据写入输出流。
	static void writeData(Person[] p, PrintWriter out) throws IOException {
		// 写入记录条数，即人数。
		out.println(p.length);
		for (int i = 0; i < p.length; i++) {
			p[i].writeData(out);
		}
	}

	// 将所邮淙肓髦卸脸觥?
	static Person[] readData(BufferedReader in) throws IOException {
		// 获取记录条数，即人数。
		int n = Integer.parseInt(in.readLine());
		Person[] p = new Person[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Person();
			p[i].readData(in);
		}
		return p;
	}
}

class Person {
	private String name;
	private int age;
	private double salary;
	private String married;

	public Person() {
	}

	public Person(String n, int a, double s) {
		name = n;
		age = a;
		salary = s;
		married = "F";
	}

	public Person(String n, int a, double s, String m) {
		name = n;
		age = a;
		salary = s;
		married = m;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public String getMarried() {
		return married;
	}

	// 设置输出格式。
	public String toString() {
		return getClass().getName() + "[name=" + name + ",age=" + age
				+ ",salary=" + salary + ",married=" + married + "]";
	}

	// 写入一条记录，即一个人的数据到输出流。
	public void writeData(PrintWriter out) throws IOException {
		// 格式化输?
		out.println(name + ":" + age + ":" + salary + ":" + married);
	}

	// 从输入流读入一条记录，即一个人的数据。
	public void readData(BufferedReader in) throws IOException {
		String s = in.readLine();
		StringTokenizer t = new StringTokenizer(s, ":");
		name = t.nextToken();
		age = Integer.parseInt(t.nextToken());
		salary = Double.parseDouble(t.nextToken());
		married = t.nextToken();
	}
}