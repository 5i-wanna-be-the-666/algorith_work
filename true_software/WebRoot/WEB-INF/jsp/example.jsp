<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>软工一班 王俊尧l.html</title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <script type="text/javascript">
  		/*
  			初始化页面时，对应输入框后的错误提示不显示
  			对于用户名，密码，手机号码，邮箱这四个文本框在每一个输入框进行
  			操作时进行校验，如果光标进入对应文本框，后续错误提示不现实，光标离开输入框时对具体数据进行校验
  			对于性别的选中校验根据checked进行判断和信息显示
  			
  			对于表单点击注册提交时，无论上面标签有无输入校验操作，都需要对以上的输入框进行统一校验操作，
  			只有全部满足条件校验成功后才能正确注册提交，
  			否则页面不实现跳转显示,在提交时如果以上输入选择框校验错误需要将具体的错误信息进行显示提示
  		*/
  
  </script>
  <script type="text/javascript">
  
  function hid()
 {
 document.getElementById("a1").innerHTML="";
 document.getElementById("a2").innerHTML="";
 document.getElementById("a3").innerHTML="";
 document.getElementById("a4").innerHTML="";
 document.getElementById("a5").innerHTML="";
 document.getElementById("a6").innerHTML="";
 } 
  
  function fin(obj)
  {
  obj.innerHTML="";
  }
  function c1(obj)
  {
  if(obj.value=="")
  {
  document.getElementById("a1").innerHTML="用户名不能为空";
  return 0;
  }
  else return 1;
  }
  function c2(obj)
  {
  if(!/^[A-z0-9]{6,10}$/.test(obj.value))
  {document.getElementById("a2").innerHTML="密码必须在6~10位之间";return 0;}
  else return 1;
  }
  function c3(obj1,obj2)
  {
 if(obj1.value!=obj2.value)
 {document.getElementById("a3").innerHTML="密码 不一致";return 0;}
 else return 1;
  }
  function c4(obj)
  {
  if(!/^[0-9]{11}$/.test(obj.value))
  {document.getElementById("a4").innerHTML="手机号码格式不正确";return 0;}
  else return 1;
  }
  function c5(obj)
  {
  if(!/^[A-Z0-9]*@[a-z0-9]*.(com|cn)$/.test(obj.value))
 { document.getElementById("a5").innerHTML="邮箱格式不正确";return 0;}
 else return 1;
  }
  function check()
  {
  var a=c1(b1);
  var b=c2(b2);
  var c=c3(b3,b2);
  var e=c4(b4);
  var f=c5(b5);
  var g=(sex1.checked+sex2.checked);
  if (g!=true)
  document.getElementById("a6").innerHTML="请选择性别";
  if(a&&b&&c&&e&&f&&g)
  alert("注册成功");
  else alert("注册失败");
  }
  function cle()
  {
  for(var i=1;i<=5;i++)
  {
  document.getElementById("b"+i).value="";
  document.getElementById("a"+i).innerHTML="";
  }
  sex1.checked=false;
  sex2.checked=false;
 document.getElementById("a6").innerHTML="";
  }
  </script>
  <body onload="hid()">
  
    		<table border="1">
    			<caption>用户注册</caption>
    			<form action="">
	    			<tr>
	    				<td>用户名：</td>
	    				<td><input type="text" onfocus="fin(a1)" onblur="c1(this)" id="b1"></td>
	    				<td><span style="color: red ;" id="a1">用户名不能为空</span></td>
	    			</tr>
	    			<tr>
	    				<td>密码：</td>
	    				<td><input type="password"onfocus="fin(a2)"onblur="c2(this)" id="b2"></td>
	    				<td><span style="color: red;" id="a2">密码必须在6~10位之间</span></td>
	    			</tr>
	    			<tr>
	    				<td>重复密码：</td>
	    				<td><input type="password"onfocus="fin(a3)"onblur="c3(this,b2)" id="b3"></td>
	    				<td><span style="color: red;"id="a3">密码 不一致</span></td>
	    			</tr>
	    			<tr>
	    				<td>性别：</td>
	    				<td>
	    					<input type="radio" name="sex" onfocus="fin(a6)" id="sex1">男
	    					<input type="radio" name="sex" onfocus="fin(a6)" id="sex2">女	
	    				</td>
	    				<td><span style="color: red;"id="a6">请选择性别</span></td>
	    			</tr>
	    			<tr>
	    				<td>手机号码：</td>
	    				<td><input type="text"onfocus="fin(a4)"onblur="c4(this)" id="b4"></td>
	    				<td><span style="color: red;"id="a4">手机号码格式不正确</span></td>
	    			</tr>
	    			<tr>
	    				<td>邮箱：</td>
	    				<td><input type="text"onfocus="fin(a5)"onblur="c5(this)"id="b5"></td>
	    				<td><span style="color: red;"id="a5">邮箱格式不正确</span></td>
	    			</tr>
	    			<tr>
	    				<td></td>
	    				<td>
	    					<input onclick="check()" type="submit" value="注册" ">
	    					<input onclick="cle()" type="reset" value="清空数据" >
	    				</td>
	    				<td></td>
	    			</tr>
    			</form>
    		</table>
  </body>
</html>