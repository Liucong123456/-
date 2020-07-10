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
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_DoUserDel")
public class DoUserDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		
		//
		LMONKEY_USERDao userDao=new LMONKEY_USERDao();
		int count=userDao.delete(id);
		
		
		//转向
		if(count>0) {
			response.sendRedirect("admin_DoUserSelect?cp="+request.getParameter("cpage"));
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败');");
			out.write("location.href='manage/admin_DoUserSelect?cp="+request.getParameter("cpage")+"';");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[]=request.getParameterValues("id[]");
		
		//
		LMONKEY_USERDao userDao=new LMONKEY_USERDao();
		for(int i=0;i<ids.length;i++) {
			userDao.delete(ids[i]);
		}
		
		//转向
		response.sendRedirect("admin_DoUserSelect?cp="+request.getParameter("cpage"));
	}

}
