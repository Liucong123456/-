package com.lmonkey.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;

public class LMONKEY_CATEGORYDao {
	
	//��ӷ���
	public int insert(LMONKEY_CATEGORY cate) {
		String sql="insert into lmonkey_category values(null,?,?)";
		Object[] params= {
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID()};
		
		return Basedao.executeIDU(sql, params);
	}
	
	//ɾ���û�
	public int delete(int id) {
		String sql="delete from lmonkey_category where CATE_ID=?";
		Object[] params= {id};
		return Basedao.executeIDU(sql, params);
	}
	
	//���·���
	public int update(LMONKEY_CATEGORY cate) {
		String sql="update lmonkey_category set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID=?";
		Object[] params= {
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID(),
				cate.getCATE_ID()
				};
		
		return Basedao.executeIDU(sql, params);
	}
	
	//��ѯ���з���
	public ArrayList<LMONKEY_CATEGORY> selectAll(){
		ArrayList<LMONKEY_CATEGORY> list=new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs=null;
		
		String sql="select * from lmonkey_category";
		rs=Basedao.executeQuery(sql, null);
		
		
		try {
			while(rs.next()) {
				LMONKEY_CATEGORY cate=new LMONKEY_CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						);
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//��ѯ���ࣨ�ӷ���͸����ࣩ  	flag="father"	flag="child"
	public ArrayList<LMONKEY_CATEGORY> selectCate(String flag){
		ArrayList<LMONKEY_CATEGORY> list=new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs=null;
		String sql="";
		if(flag!=null&&flag.equals("father")) {
			sql="select * from lmonkey_category where CATE_PARENT_ID=0";
		}else {
			sql="select * from lmonkey_category where CATE_PARENT_ID!=0";
		}
		
		rs=Basedao.executeQuery(sql, null);
		
		
		try {
			while(rs.next()) {
				LMONKEY_CATEGORY cate=new LMONKEY_CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						);
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//ͨ��ID��ѯ����
	public LMONKEY_CATEGORY selectById(int id){
		LMONKEY_CATEGORY cate=null;
		ResultSet rs=null;
		String sql="select * from LMONKEY_CATEGORY where CATE_ID=?";
		Object[] params= {id};
		rs=Basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				cate=new LMONKEY_CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						);
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return cate;
	}
}
