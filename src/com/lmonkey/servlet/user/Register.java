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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		//�����û�ʵ��
		LMONKEY_USER u=new LMONKEY_USER(username,name,pwd,sex,birthday,null,email,mobile,address,1);
		
		//�������ݿ����
		LMONKEY_USERDao userDao=new LMONKEY_USERDao();
		int count=userDao.insert(u);
		
		//ת��
		if(count>0) {
			response.sendRedirect("login.jsp");
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('�û�ע��ʧ�ܣ�');");
			out.write("location.href='regist.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
