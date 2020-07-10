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
 * Servlet implementation class IndexSelect
 */
@WebServlet("/IndexSelect")
public class IndexSelect extends HttpServlet {
	
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
		
		LMONKEY_PRODUCTDao dao1=new LMONKEY_PRODUCTDao();
		ArrayList<LMONKEY_PRODUCT> list=null;
		list=dao1.selectAll();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
