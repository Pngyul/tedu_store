<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 页面顶部-->
<header id="top" class="fixed_nav">
<div id="logo" class="lf">
	<img class="animated jello" src="../images/header/logo.png" alt="logo" />
</div>
<div id="top_input" class="lf">
	<input id="input" type="text" placeholder="请输入您要搜索的内容" /> <a
		href="javascript:" class="rt" id="search"><img 
		src="../images/header/search.png" alt="搜索" /></a>
		<script type="text/javascript">
		var search = document.getElementById("search");
		search.onclick=function(){
			var keyword = document.getElementById("input").value;
			window.location.href="../goods/search_list.do?keyWord="+keyword+"&page=1";
		}
		</script>
</div>
<div class="rt">
	<ul class="lf">
		<c:if test="${user!=null }">
			<li><a href="../user/showPersonalPage.do">${user.user_name }</a><b>|</b></li>
		</c:if>

		<li><a href="../order/showOrders.do" title="我的订单"><img
				class="order" src="../images/header/order.png" alt="" /></a><b>|</b></li>
		<li><a href="../collect/showFavorites.do" title="我的收藏"><img
				class="care" src="../images/header/care.png" alt="" /></a><b>|</b></li>
		<li><a href="../cart/showCart.do" title="我的购物车"><img
				class="shopcar" src="../images/header/shop_car.png" alt="" /></a><b>|</b></li>
		<!-- <li><a href="../web/help.html">帮助</a><b>|</b></li> -->
		<c:if test="${user==null }">
			<li><a href="../user/showLogin.do">登录</a></li>
		</c:if>
		<c:if test="${user!=null }">
			<li><a href="../main/exit.do">退出</a></li>
		</c:if>
	</ul>
</div>
</header>
<!-- nav主导航-->
<nav id="nav">
<ul>
	<li><a href="../web/index.jsp" class="acti">首页</a></li>
	<li><a href="../web/index.jsp#computer">电脑办公</a></li>
	<li><a href="../web/index.jsp#stationery">办公文具</a></li>
</ul>
</nav>