package com.lmonkey.servlet.face;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class SelectProductDetail
 */
@WebServlet("/SelectProductDetail")
public class SelectProductDetail extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LMONKEY_CATEGORYDao dao=new LMONKEY_CATEGORYDao();
		ArrayList<LMONKEY_CATEGORY> flist=dao.selectCate("father");
		request.setAttribute("flist", flist);
		ArrayList<LMONKEY_CATEGORY> clist=dao.selectCate("child");
		request.setAttribute("clist", clist);
		
		String id=request.getParameter("id");
		
		//获取最近访问
		HttpSession session=request.getSession();
		//从session获取 ids
		ArrayList<Integer> ids=(ArrayList<Integer>)session.getAttribute("ids");
		if(ids==null) {
			ids=new ArrayList<Integer>();
		}
		//最多放5个，如果多出5个将第一个删除
		if(ids.size()>=5) {
			ids.remove(0);
		}
		//添加到表里，但只要一份(不重复)
		if(id!=null && !ids.contains(Integer.parseInt(id))) {
			ids.add(Integer.parseInt(id));
		}
		session.setAttribute("ids", ids);
		
		LMONKEY_PRODUCTDao dao1=new LMONKEY_PRODUCTDao();
		ids=(ArrayList<Integer>)session.getAttribute("ids");
		if(ids!=null) {
			ArrayList<LMONKEY_PRODUCT> lastlylist=dao1.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		
		LMONKEY_PRODUCT p=null;
		if(id!=null) {
			p=dao1.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		if(p!=null) {
			int cid=p.getPRODUCT_CID();
			ArrayList<LMONKEY_PRODUCT> classlist=dao1.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			LMONKEY_CATEGORY cate=dao.selectById(cid);
			request.setAttribute("cate", cate);
		}
		
		request.getRequestDispatcher("productDetail.jsp").forward(request, response);
	}

}
