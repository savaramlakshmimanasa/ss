package com.BigBasket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BigBasket.entity.BigBasketConsumer;
import com.BigBasket.service.BigBasketService;
import com.BigBasket.service.BigBasketServiceInterface;

@WebServlet("/GlobalServletBb")
public class GlobalServletBb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String option=request.getParameter("bb");
		if(option.equals("registration"))
		{
			String name=request.getParameter("name");
			String mobileno=request.getParameter("mobileno");
			String email=request.getParameter("email");
			String location=request.getParameter("location");
			
			
			BigBasketConsumer bbc=new BigBasketConsumer();
			
			

			bbc.setName(name);
			bbc.setMobileno(mobileno);
			bbc.setEmail(email);
			bbc.setLocation(location);
			
			BigBasketServiceInterface bbs=BigBasketService.createServiceObject();
			
			int i=bbs.createProfile(bbc);
			if(i>0)
			{
				out.println("Registration is successful");
			}
			else
			{
				out.println("Invalid data");
			}
			out.println("</body></html>");
			
			
		}
	}
}
