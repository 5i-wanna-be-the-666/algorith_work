<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<script language="javascript"> 
	var times=6; 
	clock(); 
	function clock() 
	{ 
	   window.setTimeout('clock()',1000); 
	   times=times-1; 
	   time.innerHTML =times; 
	} 
	</script>
	<head>
	<meta http-equiv= "Refresh" content= "5;url=Login ">
	<title>Insert title here</title>
	<style type="text/css">
	<!--
	.STYLE1 {color: #FF0000}
	-->
	
	a
{
	text-align:center;
	color:blue;
} 
	</style>
	
	</head>
	<body>
	
	恭喜您注册成功！
	<table> 
	<tr> 
	<td class= "FontBlack STYLE1"> 　　该页面将在 </td> 
	<td class= "FontBlack"> <div class="STYLE1" id= "time"> 5 </div> </td> 
	<td class= "FontBlack STYLE1"> 秒后自动跳转至登录页面 </td> 
	
	</tr> 
	<a href="http://localhost:8080/true_software/Login">立即返回</a>
	</table> 
	</body>
	
	
	
	</html>

