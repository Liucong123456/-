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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_DoUserAdd")
public class DoUserAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String pwd=request.getParameter("passWord");
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
			response.sendRedirect("admin_DoUserSelect");
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('�û����ʧ��');");
			out.write("location.href='manage/admin_useradd.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
