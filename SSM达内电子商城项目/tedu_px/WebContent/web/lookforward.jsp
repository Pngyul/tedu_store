<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../css/header7.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/animate.css" rel="Stylesheet"/>
    <style>
        #forward{
            width: 1000px;
            height: 500px;
            margin:0px auto;
            text-align: center;
            vertical-align: middle;
        }
        #forward img{
            position: relative;
            top: 193px;
        }
        #forward p {
            font-size: 20px;
            position: relative;
            top: 218px;
            font-weight: inherit;
            opacity: 0.3;
        }
    </style>
</head>
<body>
<!-- 页面底部-->
<jsp:include page="header.jsp"></jsp:include>
<!--敬请期待页面-->
<div id="forward">
    <img src="../images/lookforward/lookforward_img1.png" alt="" class="animated bounce"/>
    <p class="animated slideInDown">服务暂未上线 敬请期待!!</p>
</div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
</body>
</html>