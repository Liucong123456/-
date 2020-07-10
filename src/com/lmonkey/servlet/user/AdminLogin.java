package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/AdminLogin")
public class AdminLogin extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("userName");
		String password=request.getParameter("passWord");
		
		LMONKEY_USERDao userDao=new LMONKEY_USERDao();
		int count=userDao.selectByUsernamePassword(username,password);
		if(count>0) {
			
			HttpSession session=request.getSession();
			LMONKEY_USER user=userDao.selectUser(username, password);
			session.setAttribute("user", user);
			session.setAttribute("isLogin", "1");
			
			if(user.getUSER_STATUS()==2) {
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("admin_index.jsp");
			}else {
				PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("alert('�û���¼ʧ��');");
				out.write("location.href='adminlogin.jsp'");
				out.write("</script>");
				out.close();
			}
	
		}else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('�û���¼ʧ��');");
			out.write("location.href='adminlogin.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
