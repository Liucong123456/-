package com.lmonkey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	private static final String URL="jdbc:mysql://localhost:3306/lmonkeyshop?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="123456";
	public static Connection conn=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	
	static {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		//��������
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	
	//ͨ�õ���ɾ��
	public static int executeIDU(String sql,Object[] params) {
		int count=0;
		
		try {
			//׼��sql
			ps=getConn().prepareStatement(sql);
			
			for(int i=0;i<params.length;i++)
			{
				ps.setObject(i+1, params[i]);
			}
			count=ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return 0;
		}finally {
			closeAll(null,ps,conn);
		}
	}
	
	//ͨ�õĲ�ѯ
	public static ResultSet executeQuery(String sql,Object[] params) {
		try {
			ps=getConn().prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn) {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}
	
}
