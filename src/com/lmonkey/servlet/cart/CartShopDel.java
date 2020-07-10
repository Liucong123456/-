package com.lmonkey.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.LMONKEY_CARTDao;

/**
 * Servlet implementation class CartShopDel
 */
@WebServlet("/CartShopDel")
public class CartShopDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String esid=request.getParameter("esid");
		LMONKEY_CARTDao dao=new LMONKEY_CARTDao();
		dao.deleteById(Integer.parseInt(esid));
	}

}
