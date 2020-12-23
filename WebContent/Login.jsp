<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body{
    background:url(Resoure/Login.jpg) no-repeat;
    background-size:cover;
}
form{
    margin-left:50px;
    margin-top:240px;
}
input{
    margin-top:20px;
    margin-right:30px;
    height:40px;
    size:20;
}
h2{
    color:white;
    margin-bottom:-10px;
    margin-left:15px;
}
a{
    color:white;
    text-decoration:none;
}
a:hover{
    color:orange;
}
#msg{
    margin-top:6px;
    color:red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>(welcome to back)</title>
</head>
<body>
     <form action="LoginServlet" method="post">
        <h2>MySteam</h2>
        <span id="msg">
            <%if(request.getAttribute("msg")!=null){ %>
            <%=request.getAttribute("msg") %>
            <%} %>
        </span><br>
		<input type="text" name="username" placeholder="请输入用户名"><br/>
		<input type="password" name="password" placeholder="请输入密码"><br/>
		<input type="submit" value="登录">
		<a href="Register.jsp">注册</a>
	</form>
</body>
</html>