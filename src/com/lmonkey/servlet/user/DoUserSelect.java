package com.lmonkey.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_DoUserSelect")
public class DoUserSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage=1;  //��ǰҳ
		int count=6;  //ÿҳ��ʾ����
		
		//��ȡ�û�ָ����ҳ��
		String cp=request.getParameter("cp");
		
		//�����û������Ĺؼ���
		String keyword=request.getParameter("keywords");
		
		if(cp!=null) {
			cpage=Integer.parseInt(cp);
		}
		LMONKEY_USERDao userdao=new LMONKEY_USERDao();
		int[] arr=userdao.totalPage(count,keyword);
		
		
		//��ȡ���е��û���¼
		ArrayList<LMONKEY_USER> list=userdao.selectAll(cpage,count,keyword);
		
		//�ŵ������������
		request.setAttribute("userlist", list);
		request.setAttribute("tsum",arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage",cpage);
		
		if(keyword!=null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	}

}
