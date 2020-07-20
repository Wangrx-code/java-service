<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="servlet/ModifyServlet" method="get">
    用户名：<input type="text" name="userName"><br>密码：<input type="password" name="userPassword"><br>地址：<input type="text" name="userLocation"><br>
    身份：<select name="userType">
    <option>商家</option>
    <option>买家</option>
    </select><br>
    <input type="submit" value="修改"/>
    <input type="reset" value="重置"/>
    </form>
  </body>
</html>
