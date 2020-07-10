package com.lmonkey.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CART;

public class LMONKEY_CARTDao {
	//���뵽���ﳵ
	public int insert(LMONKEY_CART cart) {
		String sql="insert into lmonkey_cart values(null,?,?,?,?,?,?,?,?)";
		Object[] params= {
				cart.getCart_quantity(),
				cart.getCart_valid(),
				cart.getCart_p_id(),
				cart.getCart_p_name(),
				cart.getCart_p_filename(),
				cart.getCart_p_price(),
				cart.getCart_p_stock(),
				cart.getCart_u_id()
		};
		return Basedao.executeIDU(sql, params);
	}
	
	//��ѯ���ﳵ��ͨ���û�id��
	public ArrayList<LMONKEY_CART> selectCart(String uid){
		ArrayList<LMONKEY_CART> list=new ArrayList<LMONKEY_CART>();
		ResultSet rs=null;
		Object[] params= {uid};
		String sql="select * from lmonkey_cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
		rs=Basedao.executeQuery(sql,params);
		
		try {
			while(rs.next()) {
				LMONKEY_CART c=new LMONKEY_CART(
						rs.getInt("cart_id"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_valid"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_p_name"),
						rs.getString("cart_p_filename"),
						rs.getDouble("cart_p_price"),
						rs.getInt("cart_p_stock"),
						rs.getString("cart_u_id")
						);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//��ȡ���ﳵ�е���Ʒ��ͨ��uid,pid��
	public LMONKEY_CART getCartShop(String uid,String pid) {
		LMONKEY_CART es=null;
		ResultSet rs=null;
		Object[] params= {uid,Integer.parseInt(pid)};
		String sql="select * from lmonkey_cart where cart_u_id=? and cart_p_id=? and cart_valid=1 order by cart_id desc";
		rs=Basedao.executeQuery(sql,params);
		
		try {
			while(rs.next()) {
				es=new LMONKEY_CART(
						rs.getInt("cart_id"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_valid"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_p_name"),
						rs.getString("cart_p_filename"),
						rs.getDouble("cart_p_price"),
						rs.getInt("cart_p_stock"),
						rs.getString("cart_u_id")
						);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return es;
	}
	
	//��ȡ���ﳵ�е���Ʒ��ͨ��id��
	public LMONKEY_CART getCartShop(String id) {
		LMONKEY_CART es=null;
		ResultSet rs=null;
		Object[] params= {id};
		String sql="select * from lmonkey_cart where cart_id=? and cart_valid=1 order by cart_id desc";
		rs=Basedao.executeQuery(sql,params);
		
		try {
			while(rs.next()) {
				es=new LMONKEY_CART(
						rs.getInt("cart_id"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_valid"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_p_name"),
						rs.getString("cart_p_filename"),
						rs.getDouble("cart_p_price"),
						rs.getInt("cart_p_stock"),
						rs.getString("cart_u_id")
						);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return es;
	}
	
	//���¹�����Ʒ������
	public int updateNum(int esid,int count) {
		String sql="update lmonkey_cart set cart_quantity=? where cart_id=?";
		Object[] params= {count,esid};
		return Basedao.executeIDU(sql, params);
	}
	
	//ɾ����ͨ��id��
	public int deleteById(int id) {
		String sql="delete from lmonkey_cart where cart_id=?";
		Object[] params= {id};
		return Basedao.executeIDU(sql, params);
	}
}
