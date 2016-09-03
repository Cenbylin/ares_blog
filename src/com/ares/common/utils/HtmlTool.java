package com.ares.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlTool {
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式 

	public static String getTextFromHtml(String htmlStr) {
		htmlStr = stripHtml(htmlStr);
		htmlStr = htmlStr.replaceAll("&nbsp;", " ");
		return htmlStr;
	}
	
	/**
	 * 去掉其他html标签
	 */
	public static String stripHtml(String content) {
		// 过滤script标签 
		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
        Matcher m_script = p_script.matcher(content);  
        content = m_script.replaceAll(" "); 
		// 过滤style标签
		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(content);  
        content = m_style.replaceAll(" "); 
		
		// 去掉其它的<>之间的东西
		content = content.replaceAll("<[^>]*>", " ");
		return content;
	}

	public static void main(String[] args) {
		String str = "<div style='text-align:center;'> 整治“四风”   清弊除垢<br/><span style='font-size:14px;'> <li>66</li></span><span style='font-size:18px;'>公司召开党的群众路线教育实践活动动员大会。</span><br/></div>";
		str = "<P><FONT size=2>Tel : 0086-755 81465961&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </FONT></P><P><FONT size=2>Fax :0086-755 27399932 </FONT></P><P><FONT size=2>Eamil :info@topxin-led.com </FONT></P><P><FONT size=2>Skype:jasonpt1983</FONT></P>";
		System.out.println(stripHtml(str));
	}

}
