package com.ares.common.utils;

import java.io.UnsupportedEncodingException;

public class ByteBlobTool {
	/**
	 * byte数组转Sring
	 * @param data
	 * @return
	 */
	public static String blobToString(byte[] data){
		String str = null;
		if (data!=null) {
			try {
				str = new String(data, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * String转Byte数组
	 * @param str
	 * @return
	 */
	public static byte[] stringToBlob(String str){
		byte[] data = null;
		try {
			data =  str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}
}
