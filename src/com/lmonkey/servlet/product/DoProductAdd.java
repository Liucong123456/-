package com.lmonkey.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_DoProductAdd")
public class DoProductAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����SmartUpload����
		SmartUpload su=new SmartUpload();
		
		//��ʼ��
		su.initialize(this.getServletConfig(), request, response);
		
		//�ϴ�����
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//��ȡ�ϴ����ļ�����
		Files fs=su.getFiles();
		File f=fs.getFile(0);
		
		//��ȡ�ϴ����ļ�����
		String fname=f.getFileName();
		
		try {
			su.save("images/product");
		} catch (SmartUploadException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		Request req1=su.getRequest();
		String pname=req1.getParameter("productName");
		String id=req1.getParameter("parentId");
		String price=req1.getParameter("productPrice");
		String desc=req1.getParameter("productDesc");
		String stock=req1.getParameter("productStock");
		
		LMONKEY_PRODUCT p=new LMONKEY_PRODUCT(
				0,
				pname,
				desc,
				Double.parseDouble(price),
				Integer.parseInt(stock),
				Integer.parseInt(id.split("-")[0]),
				Integer.parseInt(id.split("-")[1]),
				fname
				);
		
		LMONKEY_PRODUCTDao dao=new LMONKEY_PRODUCTDao();
		int count=dao.insert(p);
		
		//ת��
		if(count>0) {
			response.sendRedirect("admin_ProductSelect");
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('��Ʒ����ʧ��');");
			out.write("location.href='manage/admin_ToProductAdd';");
			out.write("</script>");
			out.close();
		}
	}

}