<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyGoods.jsp' starting page</title>
    
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
    <form action="servlet/ModifyGoodsServlet" method="get">
     商品id：<input type="text" name="goodsId"><br>
    商品名：<input type="text" name="goodsName"><br>
    价格：<input type="text" name="goodsPrice"><br>
    类型：<input type="text" name="goodsType"><br>
    状态：<input type="text" name="isSale"><br>
    <input type="submit" value="修改"/>
    <input type="reset" value="重置"/>
    </form>
  </body>
</html>
