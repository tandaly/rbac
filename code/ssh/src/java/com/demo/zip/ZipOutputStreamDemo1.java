package com.demo.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo1 {
	
	public static void zipFile(String sourceFile, String targetFile, String comment)
	{
		try {
			File file = new File(sourceFile);
			File zipFile = new File(targetFile);
			InputStream input = new FileInputStream(file);
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
					zipFile));
			zipOut.putNextEntry(new ZipEntry(file.getName()));
			// 设置注释
			zipOut.setComment(comment);
			int temp = 0;
			while ((temp = input.read()) != -1) {
				zipOut.write(temp);
			}
			input.close();
			zipOut.close();
		} catch (Exception e) {
			System.out.println("压缩文件失败");
		}
	}
	
	public static void main(String[] args) {
		String sourceFile = "c:" + File.separator + "Test.java";
		String targetFile = "c:" + File.separator + "test.zip";
		
		zipFile(sourceFile, targetFile, "压缩文件注释");
		
	}
}