package com.lmonkey.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_PRODUCT;


public class LMONKEY_PRODUCTDao {
	
	//添加商品
	public int insert(LMONKEY_PRODUCT p) {
		String sql="insert into lmonkey_product values(null,?,?,?,?,?,?,?)";
		Object[] params= {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_FILENAME()};
		
		return Basedao.executeIDU(sql, params);
	}
	
	//查询所有商品
	public ArrayList<LMONKEY_PRODUCT> selectAll(){
		ArrayList<LMONKEY_PRODUCT> list=new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs=null;
		
		String sql="select * from lmonkey_product";
		rs=Basedao.executeQuery(sql, null);
		
		
		try {
			while(rs.next()) {
				LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getDouble("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//查询商品（通过id）
	public LMONKEY_PRODUCT selectById(int id){
		LMONKEY_PRODUCT p=null;
		ResultSet rs=null;
		
		String sql="select * from lmonkey_product where PRODUCT_ID=?";
		Object params[]= {id};
		rs=Basedao.executeQuery(sql, params);
		
		
		try {
			while(rs.next()) {
				p=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getDouble("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return p;
	}
	
	//查询所有商品(通过fid)
	public ArrayList<LMONKEY_PRODUCT> selectAllByFid(int fid){
		ArrayList<LMONKEY_PRODUCT> list=new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs=null;
		
		String sql="select * from lmonkey_product where PRODUCT_FID=?";
		Object params[]= {fid};
		rs=Basedao.executeQuery(sql, params);
		
		
		try {
			while(rs.next()) {
				LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getDouble("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//查询所有商品(通过cid)
	public ArrayList<LMONKEY_PRODUCT> selectAllByCid(int cid){
		ArrayList<LMONKEY_PRODUCT> list=new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs=null;
		
		String sql="select * from lmonkey_product where PRODUCT_CID=?";
		Object params[]= {cid};
		rs=Basedao.executeQuery(sql, params);
		
		
		try {
			while(rs.next()) {
				LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getDouble("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
		}
		return list;
	}
	
	//查询所有商品(通过ids)
		public ArrayList<LMONKEY_PRODUCT> selectAllById(ArrayList<Integer> ids){
			ArrayList<LMONKEY_PRODUCT> lastlylist=new ArrayList<LMONKEY_PRODUCT>();
			LMONKEY_PRODUCT p=null;
			ResultSet rs=null;
			
			try {
				for(int i=0;i<ids.size();i++) {
					String sql="select * from lmonkey_product where PRODUCT_ID=?";
					Object params[]= {ids.get(i)};
					rs=Basedao.executeQuery(sql, params);
					
					while(rs.next()) {
						p=new LMONKEY_PRODUCT(
								rs.getInt("PRODUCT_ID"),
								rs.getString("PRODUCT_NAME"),
								rs.getString("PRODUCT_DESCRIPTION"),
								rs.getDouble("PRODUCT_PRICE"),
								rs.getInt("PRODUCT_STOCK"),
								rs.getInt("PRODUCT_FID"),
								rs.getInt("PRODUCT_CID"),
								rs.getString("PRODUCT_FILENAME")
								);
						lastlylist.add(p);
					}
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				Basedao.closeAll(rs, Basedao.ps, Basedao.conn);
			}
			return lastlylist;
		}
}
