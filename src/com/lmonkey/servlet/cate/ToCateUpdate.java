package com.lmonkey.servlet.cate;

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
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_ToCateUpdate")
public class ToCateUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		LMONKEY_CATEGORYDao dao=new LMONKEY_CATEGORYDao();
		LMONKEY_CATEGORY cate=dao.selectById(id);
		ArrayList<LMONKEY_CATEGORY> catelist=dao.selectAll();
		request.setAttribute("cate1", cate);
		request.setAttribute("catelist", catelist);
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}

}
