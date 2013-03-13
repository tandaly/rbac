package com.demo.io;

import java.io.*;

public class FileRandomRW {
	// 需要输入的person数目。
	public static int NUMBER = 3;

	public static void main(String[] args) {
		Persons[] people = new Persons[NUMBER];
		people[0] = new Persons("张峰", 26, 2000, "N");
		people[1] = new Persons("艳娜", 25, 50000, "Y");
		people[2] = new Persons("李朋", 50, 7000, "F");
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					"peoplerandom.dat"));
			// 将人员数据保存至“peoplerandom.dat”二进制文件中。
			writeData(people, out);
			// 关闭流。
			out.close();
			// 从二进制文件“peoplerandom.dat”中逆序读取数据。
			RandomAccessFile inOut = new RandomAccessFile("peoplerandom.dat",
					"rw");
			Persons[] inPeople = readDataReverse(inOut);
			// 输出读入的数据。
			System.out.println("原始数据：");
			for (int i = 0; i < inPeople.length; i++) {
				System.out.println(inPeople[i]);
			}
			// 修改文件的第三条记录。
			inPeople[2].setSalary(4500);
			// 将修改结果写入文件。
			inPeople[2].writeData(inOut, 3);
			// 关闭流。
			inOut.close();
			// 从文件中读入的第三条记录，并输出，以验证修改结果。
			RandomAccessFile in = new RandomAccessFile("peoplerandom.dat", "r");
			Persons in3People = new Persons();
			// 随机读第三条记录。
			in3People.readData(in, 3);
			// 关闭流。
			in.close();
			System.out.println("修改后的记录");
			System.out.println(in3People);
		} catch (IOException exception) {
			System.err.println("IOException");
		}
	}

	// 将数据写入输出流。
	static void writeData(Persons[] p, DataOutputStream out) throws IOException {
		for (int i = 0; i < p.length; i++) {
			p[i].writeData(out);
		}
	}

	// 将数据从输入流中逆序读出。
	static Persons[] readDataReverse(RandomAccessFile in) throws IOException {
		// 获得记录数目。
		int record_num = (int) (in.length() / Persons.RECORD_LENGTH);
		Persons[] p = new Persons[record_num];
		// 逆序读取。
		for (int i = record_num - 1; i >= 0; i--) {
			p[i] = new Persons();
			// 文件定位。
			in.seek(i * Persons.RECORD_LENGTH);
			p[i].readData(in, i + 1);
		}
		return p;
	}
}

class Persons {
	private String name;
	private int age; // 4个字节
	private double salary; // 8个字节
	private String married;
	public static final int NAME_LENGTH = 20; // 姓名长度
	public static final int MARRIED_LENGTH = 2; // 婚否长度
	public static final int RECORD_LENGTH = NAME_LENGTH * 2 + 4 + 8
			+ MARRIED_LENGTH * 2;

	public Persons() {
	}

	public Persons(String n, int a, double s) {
		name = n;
		age = a;
		salary = s;
		married = "F";
	}

	public Persons(String n, int a, double s, String m) {
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

	public String setName(String n) {
		name = n;
		return name;
	}

	public int setAge(int a) {
		age = a;
		return age;
	}

	public double setSalary(double s) {
		salary = s;
		return salary;
	}

	public String setMarried(String m) {
		married = m;
		return married;
	}

	// 设置输出格式。
	public String toString() {
		return getClass().getName() + "[name=" + name + ",age=" + age
				+ ",salary=" + salary + ",married=" + married + "]";
	}

	// 写入一条固定长度的记录，即一个人的数据到输出流。
	public void writeData(DataOutput out) throws IOException {
		FixStringIO.writeFixString(name, NAME_LENGTH, out);
		out.writeInt(age);
		out.writeDouble(salary);
		FixStringIO.writeFixString(married, MARRIED_LENGTH, out);
	}

	// 写入一条固定长度的记录到随机读取文件中。
	private void writeData(RandomAccessFile out) throws IOException {
		FixStringIO.writeFixString(name, NAME_LENGTH, out);
		out.writeInt(age);
		out.writeDouble(salary);
		FixStringIO.writeFixString(married, MARRIED_LENGTH, out);
	}

	// 随机写入一条固定长度的记录到输出流的指定位置。
	public void writeData(RandomAccessFile out, int n) throws IOException {
		out.seek((n - 1) * RECORD_LENGTH);
		writeData(out);
	}

	// 从输入流随机读入一条记录，即一个人的数据。
	private void readData(RandomAccessFile in) throws IOException {
		name = FixStringIO.readFixString(NAME_LENGTH, in);
		age = in.readInt();
		salary = in.readDouble();
		married = FixStringIO.readFixString(MARRIED_LENGTH, in);
	}

	// 从输入流随机读入指定位置的记录。
	public void readData(RandomAccessFile in, int n) throws IOException {
		in.seek((n - 1) * RECORD_LENGTH);
		readData(in);
	}
}

// 对固定长度字符串从文件读出、写入文件
class FixStringIO {
	// 读取固定长度的Unicode字符串。
	public static String readFixString(int size, DataInput in)
			throws IOException {
		StringBuffer b = new StringBuffer(size);
		int i = 0;
		boolean more = true;
		while (more && i < size) {
			char ch = in.readChar();
			i++;
			if (ch == 0) {
				more = false;
			} else {
				b.append(ch);
			}
		}
		// 跳过剩余的字节。
		in.skipBytes(2 * (size - i));
		return b.toString();
	}

	// 写入固定长度的Unicode字符串。
	public static void writeFixString(String s, int size, DataOutput out)
			throws IOException {
		int i;
		for (i = 0; i < size; i++) {
			char ch = 0;
			if (i < s.length()) {
				ch = s.charAt(i);
			}
			out.writeChar(ch);
		}
	}
}