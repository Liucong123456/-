package com.lmonkey.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CART;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_CARTDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		LMONKEY_PRODUCT p=null;
		
		String pid=request.getParameter("id");
		String count=request.getParameter("count");
		String url=request.getParameter("url");
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		LMONKEY_USER user=(LMONKEY_USER)session.getAttribute("user");
		if(user!=null&&isLogin.equals("1")){
			
			String uid=user.getUSER_ID();
			
			//通过用户id和购物车中的商品id 查看有没有这条记录
			LMONKEY_CARTDao dao=new LMONKEY_CARTDao();
			LMONKEY_CART srcsp=dao.getCartShop(uid,pid);
			if(srcsp!=null) {
				int srccount=srcsp.getCart_quantity();
				int newcount=srccount+Integer.parseInt(count);
				if(newcount>=5) {
					newcount=5;
				}
				dao.updateNum(srcsp.getCart_id(),newcount);
			}else {
				
				if(pid!=null) {
					LMONKEY_PRODUCTDao dao1=new LMONKEY_PRODUCTDao();
					p=dao1.selectById(Integer.parseInt(pid));
				}
				
				LMONKEY_CART cart=new LMONKEY_CART(
						0,
						Integer.parseInt(count),
						1,
						p.getPRODUCT_ID(),
						p.getPRODUCT_NAME(),
						p.getPRODUCT_FILENAME(),
						p.getPRODUCT_PRICE(),
						p.getPRODUCT_STOCK(),
						uid
						);
			
				dao.insert(cart);
			}
			
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("ShowCart");
		}else {
			response.sendRedirect("SelectProductDetail?id="+pid);
		}
		
	}
}
