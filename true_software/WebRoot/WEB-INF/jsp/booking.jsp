<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="room.RoomInformation"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<RoomInformation> biao=(List<RoomInformation>)session.getAttribute("biao");
List<RoomInformation> big=(List<RoomInformation>)session.getAttribute("big");
List<RoomInformation> shuang=(List<RoomInformation>)session.getAttribute("shuang");
List<RoomInformation> zt=(List<RoomInformation>)session.getAttribute("zt");


		
		
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8">
		<title>预订界面</title>
		
	</head>
	<body>
	<form name="fm"  method="post" action="booking_page">
		<tr>
		<select id="itis" name="choo" onchange="add_xiang()">
							    <option value="1" >请选择：</option>
								<option value="2" >标间</option>
								<option value="3" >大床房</option>
								<option value="4" >双人间</option>
								<option value="5" >总统房</option><br/>
								
							</select>
							</tr>
							<tr>
							
	<select id="thisis" name="Serial_number">
		<option value="1" >请选择：</option>
		
													
		</select>
		</tr>
		<tr>
		<input id="at" name="arrive_time" type = "datetime-local"  value="" />
		</tr>
		
		<tr>
		<input id="dt" name="leavetime" type = "datetime-local"  value="" onblur="checktime()"/>
		</tr>
		
		<select id="way" name="Booking_method">
		<option value="1" >提前60天预订</option>
		<option value="2" >常规预订</option>
		<option value="3" >预付金预订</option>
		<tr>
		<input type ="submit"  value="确定预订" />
		</tr>
		</form>
		
		
		<script language="JavaScript">
		
		var to=new Date();
		var t1=document.getElementById("at");
		var t2=document.getElementById("dt");
		var qk=document.getElementById("way");
		
		function checktime()
		{
		if(t1.value>t2.value)
		{
		alert("非法的输入，离开时间应该晚于到达时间");
		t2.value="";
		return 0;
		}
		else if(qk.value=="1")
		{
		  
		}
		return 1;
		}
		
			var itis=document.getElementById("itis");
			var thisis = document.getElementById("thisis");//获取ID

			function add_xiang()
			{
			
				var result = itis.options[itis.selectedIndex].innerHTML;
				
				
				if(result=="标间")
				{
					
					var n=thisis.options.length;
					for(var i=0;i<n;i++)
					{
						thisis.options.remove(0);
					}
					
					var n2='<%=(int)biao.size()%>';  //标间的个数
			
				
				
					var dd = "";
//遍历获得所有的房间号
     <c:forEach items="${biao}" var="keyword" varStatus="id">

     	dd="${keyword.serialNumber}";
     	thisis.options.add(new Option(dd,dd));
     </c:forEach>
//遍历结束					
						
						
				
					}
				
				if(result=="大床房")
				{
					var n=thisis.options.length;
					
					for(var i=0;i<n;i++)
					{
						thisis.options.remove(0);
					}
							
					var dd = "";
//遍历获得所有的房间号
     <c:forEach items="${big}" var="keyword" varStatus="id">

     	dd="${keyword.serialNumber}";
     	thisis.options.add(new Option(dd,dd));
     </c:forEach>
//遍历结束					
				}
				
				if(result=="双人间")
				{
					var n=thisis.options.length;
					
					for(var i=0;i<n;i++)
					{
						thisis.options.remove(0);
					}
							
					var dd = "";
//遍历获得所有的房间号
     <c:forEach items="${shuang}" var="keyword" varStatus="id">

     	dd="${keyword.serialNumber}";
     	thisis.options.add(new Option(dd,dd));
     </c:forEach>
//遍历结束					
				}
				
				if(result=="总统房")
				{
					var n=thisis.options.length;
					
					for(var i=0;i<n;i++)
					{
						thisis.options.remove(0);
					}
							
					var dd = "";
//遍历获得所有的房间号
     <c:forEach items="${zt}" var="keyword" varStatus="id">

     	dd="${keyword.serialNumber}";
     	thisis.options.add(new Option(dd,dd));
     </c:forEach>
//遍历结束					
				}
				
			}
		</script>
	</body>
</html>

