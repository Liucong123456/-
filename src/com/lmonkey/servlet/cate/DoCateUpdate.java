package com.lmonkey.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_DoCateUpdate")
public class DoCateUpdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int fid=Integer.parseInt(request.getParameter("parentId"));
		String name=request.getParameter("className");
		
		LMONKEY_CATEGORY cate=new LMONKEY_CATEGORY(id,name,fid);
		LMONKEY_CATEGORYDao dao=new LMONKEY_CATEGORYDao();
		dao.update(cate);
		
		response.sendRedirect("admin_CateSelect");
	}

}
