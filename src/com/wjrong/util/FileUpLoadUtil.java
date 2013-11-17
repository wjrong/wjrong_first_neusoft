package com.wjrong.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class FileUpLoadUtil {
	private FileUpLoadUtil(){}
	
	public static String getFileExt(String fileName){
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	public static String updateFileName(String oldName){
		return UUID.randomUUID().toString() + "." + getFileExt(oldName);
	}
	
	@SuppressWarnings("resource")
	public static void UploadFile(String filePath, File file){
		try {
			InputStream input = new FileInputStream(file);
			OutputStream output = new FileOutputStream(filePath);
			
			byte[] bytes = new byte[1024];
			
			while(input.read(bytes) > 0){
				output.write(bytes);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e1){
			e1.printStackTrace();
		}
	}
}
