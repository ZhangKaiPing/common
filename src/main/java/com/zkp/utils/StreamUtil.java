package com.zkp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: StreamUtil 
 * @Description: 流工具类
 * @author: lenovo
 * @date: 2019年11月9日 上午11:02:24
 */
public class StreamUtil {
	/**
	 * 批量关闭流，参数能传无限个。(3分) 可变参数 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	 */
	public static void closeAll(AutoCloseable...autoCloseable) {
		if(null!=autoCloseable&&autoCloseable.length>0) {
			for (AutoCloseable autoCloseable2 : autoCloseable) {
				try {
					autoCloseable2.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	// 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	public static String readTextFile(InputStream src) {
		byte[] b=new byte[1024];
		int x=0;
		String str="";
		try {
			while((x=src.read(b))!=-1) {
				str+=new String(b,0,x,"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	/*
	 * 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) throws FileNotFoundException {
		return readTextFile(new FileInputStream(txtFile));
	}
	
	
	/**
	 * 一行行读取文件并写入list集合
	 */
	public static List<String> reandLineTextFile(File txtFile){
		List<String> list=new ArrayList<String>();
		BufferedReader bf=null;
		try {
			bf=new BufferedReader(new InputStreamReader(new FileInputStream(txtFile)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str="";
		try {
			
				while((str=bf.readLine())!=null) {
					list.add(str);
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
