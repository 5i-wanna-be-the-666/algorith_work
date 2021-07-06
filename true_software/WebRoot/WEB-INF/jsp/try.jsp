<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>酒店登陆页面</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--图标-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
	
	<!--布局框架-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
	
	<!--主要样式-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>

<div class="login">
	<div class="container-login100">
		<div class="wrap-login100">
			<div class="login100-pic js-tilt" data-tilt>
				<img src="img/img-01.png" alt="IMG">
			</div>

			<form class="login100-form validate-form" action="Login_page" method="post">
				<span class="login100-form-title">
					会员登陆
				</span>

				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" name="username" id="name" placeholder="邮箱">
					<span class="focus-input100"></span>
					<span class="symbol-input100">
						<i class="fa fa-envelope" aria-hidden="true"></i>
					</span>
				</div>

				<div class="wrap-input100 validate-input">
					<input class="input100" type="password" name="passwd" id="psd" placeholder="密码">
					<span class="focus-input100"></span>
					<span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
				</div>
				
				<div class="container-login100-form-btn">
					<button class="login100-form-btn" onclick="checkUser()">
						登陆
					</button>
				</div>

				<div class="text-center p-t-12">
					<a class="txt2" href="javascript:">
						忘记密码？
					</a>
				</div>

				<div class="text-center p-t-136">
					<a class="txt2" href="#">
							还没有账号？立即注册
						<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
					</a>
				</div>
			</form>
		</div>
	</div>
</div>
	
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
    //当用户账号输入框失去焦点时调用该方法
    function checkUser()
    {
    
        //获取输入框输入的值
        var user = document.getElementById("name");
        
        var passwd = document.getElementById("psd");
        //如果输入框中的值为空，那么弹窗提示，并且让该输入框获得焦点
        if(!user)
        {
            alert("用户名不能为空！");
            obj.focus();
            return;
        }
         
        //不为空时，使用Ajax请求向后台发送信息，验证该用户名是否可用
        //get请求字符串
        var url="Login_page?username="+user.value+"&passwd="+passwd.value;
        
        //调用方法创建XMLHttpRequest对象
        XmlHttpRequest = createXmlHttpRequest();
        //设置回调函数
        XmlHttpRequest.onreadystatechange=function()
        {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200)
        {
            var result = XmlHttpRequest.responseText;
            if(result =="false")
            {
                alert("用户名不可用！");
                window.location.href="try";
                return false;
            }else
            {
                
                alert("用户名可用！");
                return true;
            }
        }
        
        };
        //初始化xmlhttprequest
        XmlHttpRequest.open("GET",url,true);
        //发送请求
        XmlHttpRequest.send(null);
         
    }
    //回调函数
    function finish()
    {
        if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200){
            var result = XmlHttpRequest.responseText;
            if(result =="true"){
                alert("用户名可用！");
                return true;
            }else{
                alert("用户名不可用！");
                return false;
            }
        }
    }
</script>
</body>
</html>
