<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
background:url(Resoure/Register.jpg) no-repeat;
background-size:cover;
}
form{
    margin-left:600px;
    margin-top:150px;
}
input{
    margin-top:20px;
    margin-right:30px;
    height:40px;
    size:20;
}
h1{
color:white;
margin-bottom:-10px;
margin-left:35px;
}
a{
    color:white;
    text-decoration:none;
}
a:hover{
    color:orange;
}
#msg{
    margin-top:3px;
    color:red;
}
</style>
</head>
<body>
   <form action="RegisterServlet" method="post">
        <h1>欢迎注册</h1>
        <span id="msg">
            <%if(request.getAttribute("msg")!=null){ %>
            <%=request.getAttribute("msg") %>
            <%} %>
        </span><br>
		<input type="text" name="username" placeholder="请输入用户名" size="30"><br/>
		<input type="password" name="password" placeholder="  请输入密码  " size="30"><br/>
	    <input type="password" name="password2" placeholder="  请确认密码  " size="30"><br/>
	    <input type="text" name="role" placeholder="  请输入身份" size="30"><br/>
		<input type="submit" value="注册"><input type="reset" value="重置">
		<a href="Login.jsp">返回</a>
	</form>
</body>
</html>