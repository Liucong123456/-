package com.lmonkey.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class ToProductAdd
 */
@WebServlet("/manage/admin_ToProductAdd")
public class ToProductAdd extends HttpServlet {
	
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
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
	}

}
