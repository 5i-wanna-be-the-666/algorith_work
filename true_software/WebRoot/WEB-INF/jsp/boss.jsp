<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="booking_information.BookingInformation"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
double jijia=(double) session.getAttribute("jijia");
List now_biao=(List)session.getAttribute("now_biao");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>管理员界面</title>
    
	

  </head>
  
  <body>
    <form action="change_jia" method="post">
    <p id="xz">现在的基价为:<%=jijia%></p>
    
    <input id="jijia" name="jijia" type="text"  placeholder="您希望修改的新的基价"/>
    <input type="submit" value="确定" onclick="gai()"/>
    
    </form>
    <form action="cunbiao_page" method="post">
    <input type="submit" value="保存报表" onclick="gai()"/>
    </form>
    
    <input id="tijiao" type="button" value="查看报表" onclick="kan()"/>
    
    
    <table id="biao" border="1">
    <th>身份证号</th>
    <th>姓名</th>
    <th>房间号</th>
    <th>预订方式</th>
    <th>预订日期</th>
    <th>到达日期</th>
    <th>居住时长</th>
    <th>离开日期</th>
   
    </table>
  </body>
  <script type="text/javascript">
  var now=document.getElementById("xz");
  var xin=document.getElementById("jijia");
 
  
    function createXmlHttpRequest()
    {
        if(window.XMLHttpRequest){
            return new XMLHttpRequest();
        }else{
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    
     function gai()
  {
  XmlHttpRequest = createXmlHttpRequest();
   var url="change_page?jijia="+xin.value;
  XmlHttpRequest.open("get",url,true);
    XmlHttpRequest.send(null);
     XmlHttpRequest.onreadystatechange=function()
        {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200)
        {
        
        if(XmlHttpRequest.responseText=="true")
        {
        alert("修改成功");
      //  now.innerHTML="现在的基价为:"+xin.value;
        }
        
        }
        
        };
  
  return 1;
  }
    
    
  function kan()
  {
  var tt=document.getElementById("biao");
   XmlHttpRequest = createXmlHttpRequest();
       var url="emplye_page";
        
    XmlHttpRequest.open("get",url,true);
    XmlHttpRequest.send(null);
   
    XmlHttpRequest.onreadystatechange=function()
        {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200)
        {
     while(tt.rows.length > 1)
				{
					bookTb.deleteRow(bookTb.rows.length - 1);
				}
     
            var text = XmlHttpRequest.responseText;
            var me=JSON.parse(text);
	  
	            for(var i=0;i<me.length;i++)
	            {
	            var x=tt.insertRow(tt.length);
	            var k0=x.insertCell(0);
	            var k1=x.insertCell(1);
		        var k2=x.insertCell(2);
		        var k3=x.insertCell(3);
		        var k4=x.insertCell(4);
		        var k5=x.insertCell(5);
		        var k6=x.insertCell(6);
				var k7=x.insertCell(7);
		        
		        
		        var at=new Date(me[i].arriveTime.time);
		        var bt=new Date(me[i].bookingDate.time);
		        var dt=new Date(me[i].leavetime.time);
		        
		        k0.innerHTML=me[i].id.idCard;
		        k1.innerHTML=me[i].name;
		        k2.innerHTML=me[i].id.serialNumber;
		        k3.innerHTML=me[i].bookingMethod;
		        k4.innerHTML=bt.toLocaleString();
		        k5.innerHTML=at.toLocaleString(); 
		        k6.innerHTML=me[i].liveDays;
		        k7.innerHTML=dt.toLocaleString();      
              }
         
        }
        };
  }
  </script>
</html>
