package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/UsernameCheck")
public class UsernameCheck extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		LMONKEY_USERDao userDao=new LMONKEY_USERDao();
		LMONKEY_USER u=userDao.selectById(name);
		PrintWriter out=response.getWriter();
		if(u!=null) {
			out.print("false");
		}else {
			out.print("true");
		}
		out.close();
	}

}
