package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/manage/AdminLogout")
public class AdminLogout extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("isLogin");
		session.removeAttribute("isAdminLogin");
		
		PrintWriter out=response.getWriter();
		out.write("<script>");
		out.write("alert('退出成功！');");
		out.write("location.href='adminlogin.jsp'");
		out.write("</script>");
		out.close();
	}

}
