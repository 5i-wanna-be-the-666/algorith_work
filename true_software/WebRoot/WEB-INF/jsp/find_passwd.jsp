<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String passwd=(String) request.getSession().getAttribute("your_passwd");
if(passwd==null)
passwd="";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>找回密码</title>
    
	

  </head>
  
  <body  onload="clean()">
    <form action="find_passwd_page" method="get">
    <input id="user" name="username" type="text" maxsize="20" placeholder="请输入您的账户"/>
     <p id="passd" >您的密码:<%=passwd%></p>
     <br/>
     <input type="submit" value="确定" onclick="zhao()">
    </form>
    <%
    session.setAttribute("your_passwd","");
    %>
  </body>
  
  
  <script type="text/javascript">
  function clean()
  {
 var obj= document.getElementById("passd");
  
  obj.innerHTML="您的密码:";
  
  }
    //创建XMLHttpRequest
    var user=document.getElementById("user");
    var pass=document.getElementById("passd");
    function createXmlHttpRequest()
    {
        if(window.XMLHttpRequest){
            return new XMLHttpRequest();
        }else{
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    
    function zhao()
  {
  XmlHttpRequest = createXmlHttpRequest();
   var url="find_passwd_page?username="+user.value;
   var ppp=<%=passwd%>;
  XmlHttpRequest.open("get",url,true);
    XmlHttpRequest.send(null);
     XmlHttpRequest.onreadystatechange=function()
        {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200)
        {
        if(XmlHttpRequest.responseText=="false")
         {
           alert("账户不存在!");
           window.location.href="find_passwd";
           return false;
         }
         
        else
        {
            alert("找回成功!您的密码为"+ppp);
        
      //  pass.innerHTML=XmlHttpRequest.responseText;
        return false;
        }
        
         
        
        }
        
        }
  
  return 1;
  }
    </script>
</html>
