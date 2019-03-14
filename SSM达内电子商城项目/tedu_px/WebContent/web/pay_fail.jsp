<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学子商城——支付页面</title>
    <link href="../css/payment.css" rel="Stylesheet" />
    <link href="../css/header7.css" rel="Stylesheet" />
    <link href="../css/footer.css" rel="Stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<div id="navlist">
    <ul>
        <li class="navlist_gray_left"></li>
        <li class="navlist_gray">确认订单信息</li>
        <li class="navlist_gray_arrow"></li>
        <li class="navlist_gray">支付订单<b></b></li>
        <li class="navlist_gray_arrow"></li>
        <li class="navlist_blue">支付结果<b></b></li>
        <li class="navlist_blue_right"></li>
    </ul>
</div>
<div id="container">
    <div>
        <h1><i>支付失败</i>
            <span class="rt">支付订单：123455666677 &nbsp;支付金额：<b>4999.00元</b></span></h1>
    </div>
    <div class="rightsidebar_box rt" >
        <div class="pay_result">
            <img src="../images/pay/pay_fail.png" alt=""/>
            <p>支付失败</p>
            <span><a href="#">查看订单状态？ </a><b><a href="#">查看订单&gt;&gt;</a></b></span>
            <br/>
            达内学子商城不会以系统异常、订单升级为由，要求你点击任何链接进行退款操作！
        </div>

    </div>
</div>

<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
</body>
</html>