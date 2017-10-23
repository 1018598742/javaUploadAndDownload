package com.imooc.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = getServletContext().getRealPath("/")+"images/";
		String filename = req.getParameter("filename");
		File file = new File(path + filename);
		if(file.exists()){
			resp.setContentType("application/x-msdownload");
			resp.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
			InputStream inputStream = new FileInputStream(file);
			ServletOutputStream outputStream = resp.getOutputStream();
			byte b[] = new byte[1024];
			int len;
			while((len = inputStream.read(b))!=-1){
				outputStream.write(b,0,len);
			}
			outputStream.close();
			inputStream.close();
		}else{
			req.setAttribute("errorResult", "文件不存在下载失败");
			RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/01.jsp");
			dispatcher.forward(req, resp);
		}
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}

}
