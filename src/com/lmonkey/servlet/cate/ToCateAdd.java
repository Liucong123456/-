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
 * Servlet implementation class ToCateAdd
 */
@WebServlet("/manage/admin_ToCateAdd")
public class ToCateAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LMONKEY_CATEGORYDao dao=new LMONKEY_CATEGORYDao();
		ArrayList<LMONKEY_CATEGORY> catelist=dao.selectAll();
		request.setAttribute("catelist", catelist);
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
	}

}
