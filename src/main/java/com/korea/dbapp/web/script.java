package com.korea.dbapp.web;

public class script {
	
	public static String href(String uri) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("location.href = '"+uri+"';");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	public static String back(String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert(''"+msg+"'');");
		sb.append("</script>");
		
		
		return sb.toString();
	}
}
