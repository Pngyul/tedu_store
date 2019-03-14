<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>我的订单 - 达内学子商城</title>
<link href="../css/orders.css" rel="Stylesheet" />
<link href="../css/header7.css" rel="Stylesheet" />
<link href="../css/footer.css" rel="Stylesheet" />
<link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 我的订单导航栏-->
	<div id="nav_order">
		<ul>
			<li><a href="">首页<span>&gt;</span>个人中心
			</a></li>
		</ul>
	</div>
	<!--我的订单内容区域 #container-->
	<div id="container" class="clearfix">
		<jsp:include page="left.jsp"></jsp:include>
		<!-- 右边栏-->
		<!--个人信息头部-->
		<div class="rightsidebar_box rt">
			<div class="rs_header">
				<span class="rs_header_active"><a href="../user/showPersonalPage.do">我的信息</a></span>
            <span><a href="../user/showPersonal_password.do">安全管理</a></span>
			</div>

			<!--安全管理 -->
			<div class="rs_content">
				<p class="change_password_title">更改密码</p>
				<div class="new_password">
					<span class="word">输入旧密码：</span><input type="password" id="oldPwd"/><span
						class="change_hint"></span>
				</div>
				<div class="new_password">
					<span class="word">输入新密码：</span><input type="password" id="newPwd"/><span
						class="change_hint"></span>
				</div>
				<div class="confirm_password">
					<span class="word">确 认新密码：</span><input type="password" id="cnewPwd"/><font
						class="confirm_hint" color="red"></font>
				</div>
				<div class="save_password">保存更改</div>
			</div>


		</div>
	</div>
	<!-- 页面底部-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders1.js"></script>
<script>

  /*  $("#cnewPwd").blur(function(){
    	var newPwd = $("#newPwd").val();
		var cnewPwd = $("#cnewPwd").val();
		if(newPwd!=cnewPwd){
            $(".confirm_hint").html("二次输入密码不匹配");
			$("#cnewPwd").val("");
			$("#cnewPwd").focus();
		}
    }); */ 
	$(".save_password").click(function(){
		var newPwd = $("#newPwd").val();
		var cnewPwd = $("#cnewPwd").val();
		if(newPwd==cnewPwd){ 
			$.ajax({
		    	   type: "POST",
		    	   data:"oldPwd="+$("#oldPwd").val()+"&newPwd="+$("#newPwd").val(),
		    	   url: "../user/updatePassword.do",
		    	   datatype:"json",
		    	   success: function(obj){
		    		   alert(obj.message);
		    		   if(obj.state == 1){
		    			   window.location="../user/showLogin.do";
		    		   }
		    	   }
		    	});
		}else{
			/* $(".confirm_hint").html(); */
			alert("二次输入密码不匹配");
			$("#cnewPwd").val("");
			$("#cnewPwd").focus();
		} 
		
	});
</script>
<script type="text/javascript">
	$(function(){
		//把所有的dd隐藏
		$("#leftsidebar_box dd").hide();
		//设置账号管理的列表显示
		$("#leftsidebar_box .count_managment dd").show();
		//把所有箭头改为向右箭头
		$("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
		//账号管理箭头改为向下
		$("#leftsidebar_box .count_managment img").attr("src","../images/myOrder/myOrder2.png");
	});

</script>
</html>