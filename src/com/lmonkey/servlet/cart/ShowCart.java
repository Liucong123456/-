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
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		LMONKEY_USER user=(LMONKEY_USER)session.getAttribute("user");
		if(user!=null&&isLogin.equals("1")) {
			String uid=user.getUSER_ID();
			
			LMONKEY_CARTDao dao=new LMONKEY_CARTDao();
			ArrayList<LMONKEY_CART> list=dao.selectCart(uid);
			request.setAttribute("shoplist", list);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再查看');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
	}
}
