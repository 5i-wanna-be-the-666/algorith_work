<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="software.client"%>
<%@ page import="booking_information.BookingInformation"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <title>欢迎用户</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  client yong_hu=(client)request.getAttribute("client");
  session.setAttribute("client",yong_hu);
  %>
  <body>
  <div class="login_resister">
  <p>欢迎光临</p>
  <p ><%=yong_hu.get_person().getName()%> <%=yong_hu.get_person().getSex()%> <a href="http://localhost:8080/true_software/Login">退出登录</a></p>

    
    </div>
   <input  type="button" value="房间情况" onclick="geet()"/>
  
      <a href="http://localhost:8080/true_software/du_room">预订</a>
    
    <div>
    <div>
    <span id="biao"></span>
  
      <br>
    
    <span id="big"></span>
      <br>
    </div>
    
    <div>
    <span id="shuang"></span>
    <br>
    </div>
    
    <div>
    <span id="zt"></span>
      <br>
    </div>
    
    <input id="tijiao" type="button" value="我的预订" onclick="my_kan()"/>
     <table id="my_yuding" border="1">
    <th>身份证号</th>
    <th>姓名</th>
    <th>房间号</th>
    <th>预订方式</th>
    <th>预订日期</th>
    <th>到达日期</th>
    <th>居住时长</th>
    <th>离开日期</th>
     <th>操作</th>
   
    </table>
    
    
  </body>
  <script type="text/javascript">
    //创建XMLHttpRequest
    function createXmlHttpRequest()
    {
        if(window.XMLHttpRequest){
            return new XMLHttpRequest();
        }else{
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function geet()
    {
    //标间
       XmlHttpRequest1 = createXmlHttpRequest();
       var url1="room_inform_page?lei=1";
       
    XmlHttpRequest1.open("get", url1, true);
    XmlHttpRequest1.send(null);
    XmlHttpRequest1.onreadystatechange=function()
        {
        if(XmlHttpRequest1.readyState == 4&& XmlHttpRequest1.status == 200)
        {
            var text1 = XmlHttpRequest1.responseText;
           document.getElementById("biao").innerHTML="<font color='blue'>"+text1+"</font>";
        }
        };
        
        
    //大床房    
  
    
       
       
         XmlHttpRequest2 = createXmlHttpRequest();
        var url2="room_inform_page?lei=2";
          
          XmlHttpRequest2.open("get", url2, true);
    XmlHttpRequest2.send(null);
    XmlHttpRequest2.onreadystatechange=function()
        {
        if(XmlHttpRequest2.readyState == 4&& XmlHttpRequest2.status == 200)
        {
            var text2 = XmlHttpRequest2.responseText;
           document.getElementById("big").innerHTML="<font color='blue'>"+text2+"</font>";
        }
        };
        //双人间
         XmlHttpRequest3 = createXmlHttpRequest();
           var url3="room_inform_page?lei=3";
             
              XmlHttpRequest3.open("get", url3, true);
    XmlHttpRequest3.send(null);
    XmlHttpRequest3.onreadystatechange=function()
        {
        if(XmlHttpRequest3.readyState == 4&& XmlHttpRequest3.status == 200)
        {
            var text3 = XmlHttpRequest3.responseText;
           document.getElementById("shuang").innerHTML="<font color='blue'>"+text3+"</font>";
        }
        };
             //总统房
               XmlHttpRequest4 = createXmlHttpRequest();
             var url4="room_inform_page?lei=4";
             
               XmlHttpRequest4.open("get", url4, true);
    XmlHttpRequest4.send(null);
    XmlHttpRequest4.onreadystatechange=function()
        {
        if(XmlHttpRequest4.readyState == 4&& XmlHttpRequest4.status == 200)
        {
            var text4 = XmlHttpRequest4.responseText;
           document.getElementById("zt").innerHTML="<font color='red'>"+text4+"</font>";
        }
        };
             
            // requestAnimationFrame(geet);
             setInterval('geet',1000);
       
    }
   
    
     function my_kan()
  {

  var ww=document.getElementById("my_yuding");
   XmlHttpRequest = createXmlHttpRequest();
       var url="my_booking";
        
    XmlHttpRequest.open("get",url,true);
    XmlHttpRequest.send(null);
    
    XmlHttpRequest.onreadystatechange=function()
        {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200)
        {
        
      while(ww.rows.length > 1)
				{
					bookTb.deleteRow(bookTb.rows.length - 1);
					
				} 
    
            var text = XmlHttpRequest.responseText;
            
            var me=JSON.parse(text);
	  
	            for(var i=0;i<me.length;i++)
	            {
	            
	            var x=ww.insertRow(ww.length);
	            var k0=x.insertCell(0);
	            var k1=x.insertCell(1);
		        var k2=x.insertCell(2);
		        var k3=x.insertCell(3);
		        var k4=x.insertCell(4);
		        var k5=x.insertCell(5);
		        var k6=x.insertCell(6);
				var k7=x.insertCell(7);
		         var k8=x.insertCell(8);
		         
		         
		        k0.innerHTML=me[i].id.idCard;
		        var at=new Date(me[i].arriveTime.time);
		        var bt=new Date(me[i].bookingDate.time);
		        var dt=new Date(me[i].leavetime.time);
		        
		        
		        k1.innerHTML=me[i].name;
		        k2.innerHTML=me[i].id.serialNumber;
		        k3.innerHTML=me[i].bookingMethod;
		        k4.innerHTML=bt.toLocaleString();
		        k5.innerHTML=at.toLocaleString(); 
		        k6.innerHTML=me[i].liveDays;
		        k7.innerHTML=dt.toLocaleString();     
		        
		        k8.innerHTML="<a href='###' onclick='return tui_ding(this)'>退订</a>"
              }
         
        }
        };
  }
   function tui_ding(obj)
   {
    var ww=document.getElementById("my_yuding");
    var i=obj.parentNode.parentNode.rowIndex;
    ww.deleteRow(i);
     XmlHttpRequest = createXmlHttpRequest();
       var url="tuiding_page?hang="+i;
        
    XmlHttpRequest.open("get",url,true);
    XmlHttpRequest.send(null);
    return false;
   }
    </script>
</html>
