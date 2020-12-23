package com.MySteam.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MySteam.service.UserService;
import com.MySteam.service.impl.UserServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获取前端数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String role=request.getParameter("role");
		//判断两次输入的密码是否一致
		if(password.equals(password2)){
			UserService userService=new UserServiceImpl();
			boolean flag=userService.register(username,password,role);
			//判断是否重复了用户名
			if(flag){
				response.sendRedirect("Login.jsp");
			}else{
				request.setAttribute("msg", "此用户名已存在,请重新输入!");//设置请求信息
				request.getRequestDispatcher("Register.jsp").forward(request, response);//请求转发
			}
		}else{
			request.setAttribute("msg", "两次输入的密码不一致,请重新输入!");//设置请求信息
			request.getRequestDispatcher("Register.jsp").forward(request, response);//请求转发
		}
		
	}

}
