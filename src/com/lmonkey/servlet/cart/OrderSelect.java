package com.lmonkey.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CART;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_CARTDao;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/OrderSelect")
public class OrderSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		LMONKEY_USER user=(LMONKEY_USER)session.getAttribute("user");
		
		String eids=request.getParameter("eids");
		
		if(user!=null&&isLogin.equals("1")) {
			
			double totalprice=0;
			String ids[]=eids.split(",");
			ArrayList<LMONKEY_CART> list=new ArrayList<LMONKEY_CART>();
			LMONKEY_CARTDao dao=new LMONKEY_CARTDao();
			for(int i=0;i<ids.length;i++) {
				LMONKEY_CART es=dao.getCartShop(ids[i]);
				double dprice=es.getCart_p_price()*es.getCart_quantity();
				totalprice+=dprice;
				list.add(es);
			}
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('µÇÂ¼ºó£¬ÔÙ¹ºÂò');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
	}

}
