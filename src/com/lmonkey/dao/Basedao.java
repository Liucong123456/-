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
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		//创建连接
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	
	//通用的增删改
	public static int executeIDU(String sql,Object[] params) {
		int count=0;
		
		try {
			//准备sql
			ps=getConn().prepareStatement(sql);
			
			for(int i=0;i<params.length;i++)
			{
				ps.setObject(i+1, params[i]);
			}
			count=ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 0;
		}finally {
			closeAll(null,ps,conn);
		}
	}
	
	//通用的查询
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
			// TODO 自动生成的 catch 块
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	
}
