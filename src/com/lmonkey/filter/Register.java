package com.lmonkey.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Register
 */
@WebFilter("/Register")
public class Register implements Filter {

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//不通过则直接return
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String userName=req.getParameter("userName");
		PrintWriter out=resp.getWriter();
		if(userName.equals("")||userName==null) {
			out.write("<script>");
			out.write("alert('用户名称不能为空！');");
			out.write("location.href='regist.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		HttpSession session=req.getSession();
		String code=req.getParameter("code");
		String sysCode=(String)session.getAttribute("code");
		
		if(!sysCode.contentEquals(code)) {
			out.write("<script>");
			out.write("alert('验证码输入有误！');");
			out.write("location.href='regist.jsp';");
			out.write("</script>");
			out.close();
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(req, resp);   //通过则使用这条语句
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
