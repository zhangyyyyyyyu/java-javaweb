package com.MySteam.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MySteam.domain.User;
import com.MySteam.service.UserService;
import com.MySteam.service.impl.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取view层jsp中的数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//调用service层进行操作
		UserService userService=new UserServiceImpl();
		User user=userService.login(username, password);
		//判断用户名和密码是否正确并分类进行跳转
		if(user!=null){
		    response.sendRedirect("index.jsp");//响应重定向
		}else{
			//设置提示信息
			request.setAttribute("msg", "用户名或密码不正确！");
			//请求转发(这种形式才能获取Attribute的提示信息)
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
