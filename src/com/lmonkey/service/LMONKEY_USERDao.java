package com.lmonkey.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_USER;

public class LMONKEY_USERDao {
	//添加用户
	public int insert(LMONKEY_USER u) {
		String sql="insert into lmonkey_user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params= {
				u.getUSER_ID(),
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENTITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS()};
		
		return Basedao.executeIDU(sql, params);
	}
	
	//删除用户
	public int delete(String id) {
		String sql="delete from lmonkey_user where USER_ID=? and USER_STATUS!=2";
		Object[] params= {id};
		return Basedao.executeIDU(sql, params);
	}
	
	//更新用户
		public int update(LMONKEY_USER u) {
			String sql="update lmonkey_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),USER_IDENTITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
			Object[] params= {
					u.getUSER_NAME(),
					u.getUSER_PASSWORD(),
					u.getUSER_SEX(),
					u.getUSER_BIRTHDAY(),
					u.getUSER_IDENTITY_CODE(),
					u.getUSER_EMAIL(),
					u.getUSER_MOBILE(),
					u.getUSER_ADDRESS(),
					u.getUSER_STATUS(),
					u.getUSER_ID()};
			
			return Basedao.executeIDU(sql, params);
		}
	
	//查询所有用户
	public ArrayList<LMONKEY_USER> selectAll(int cpage,int count,String keyword){
		ArrayList<LMONKEY_USER> list=new ArrayList<LMONKEY_USER>();
		ResultSet rs=null;
		String sql="";
		
		if(keyword!=null) {
			sql="select * from lmonkey_user where USER_NAME like ? order by USER_ID limit ?,?";
			Object[] params=new Object[3];
			params[0]= "%"+keyword+"%";
			params[1]=(cpage-1)*count;
			params[2]=count;
			rs=Basedao.executeQuery(sql, params);
		}else {
			sql="select * from lmonkey_user order by USER_ID limit ?,?";
			Object[] params=new Object[2];
			params[0]= (cpage-1)*count;
			params[1]=count;
			rs=Basedao.executeQuery(sql, params);
		}
		
		
		try {
			while(rs.next()) {
				LMONKEY_USER u=new LMONKEY_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENTITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//通过ID查询用户
	public LMONKEY_USER selectById(String id){
		LMONKEY_USER u=null;
		ResultSet rs=null;
		String sql="select m.*,DATE_FORMAT(m.USER_BIRTHDAY,'%Y-%m-%d') BIRTHDAY from LMONKEY_USER m where USER_ID=?";
		Object[] params= {id};
		rs=Basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				u=new LMONKEY_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("BIRTHDAY"),
						rs.getString("USER_IDENTITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return u;
	}
	
	//通过用户名和密码查询（返回整数）
	public int selectByUsernamePassword(String username,String password) {
		int count=0;
		ResultSet rs=null;
		String sql="select count(*) from LMONKEY_USER where USER_ID=? and USER_PASSWORD=?";
		Object[] params= {username,password};
		rs=Basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return count;
	}
	
	//通过用户名和密码查询（返回LMONKEY_USER）
	public LMONKEY_USER selectUser(String username,String password) {
		LMONKEY_USER u=null;
		ResultSet rs=null;
		String sql="select m.*,DATE_FORMAT(m.USER_BIRTHDAY,'%Y-%m-%d') BIRTHDAY from LMONKEY_USER m where USER_ID=? and USER_PASSWORD=?";
		Object[] params= {username,password};
		rs=Basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				u=new LMONKEY_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("BIRTHDAY"),
						rs.getString("USER_IDENTITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return u;
	}
	
	//查询总记录数和页数
	public int[] totalPage(int count,String keyword) {
		//0总记录数，1页数
		int[] arr= {0,1};
		ResultSet rs=null;
		String sql="";
		if(keyword!=null) {
			sql="select count(*) from lmonkey_user where USER_NAME like ?";
			Object[] params= {"%"+keyword+"%"};
			rs=Basedao.executeQuery(sql, params);
		}else {
			sql="select count(*) from lmonkey_user";
			rs=Basedao.executeQuery(sql, null);
		}
		
		try {
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				arr[1]=(arr[0]-1)/count+1;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		
		return arr;
	}
	
}
