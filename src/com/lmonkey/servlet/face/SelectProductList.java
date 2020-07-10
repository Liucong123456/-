package com.lmonkey.servlet.face;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/SelectProductList")
public class SelectProductList extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LMONKEY_CATEGORYDao dao=new LMONKEY_CATEGORYDao();
		ArrayList<LMONKEY_CATEGORY> flist=dao.selectCate("father");
		request.setAttribute("flist", flist);
		ArrayList<LMONKEY_CATEGORY> clist=dao.selectCate("child");
		request.setAttribute("clist", clist);
		
		String fid=request.getParameter("fid");
		String cid=request.getParameter("cid");
		
		int id=0;
		LMONKEY_PRODUCTDao dao1=new LMONKEY_PRODUCTDao();
		ArrayList<LMONKEY_PRODUCT> list=null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list=dao1.selectAllByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list=dao1.selectAllByCid(id);
		}
		
		request.setAttribute("title", dao.selectById(id).getCATE_NAME());
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

}
