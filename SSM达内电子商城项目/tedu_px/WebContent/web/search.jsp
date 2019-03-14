<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>商品搜索页面</title>
<link rel="stylesheet" href="../css/header7.css" />
<link rel="stylesheet" href="../css/search.css" />
<link rel="stylesheet" href="../css/footer.css" />
</head>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="big" style="min-height:970px;">
		<form name="" action="" method="post">
			<section id="section">
				<p class="header">全部结果>笔记本</p>
				<div id="wrap">
		        	<c:forEach items="${goodsList }" var="goods">
					<div class="lf" id="${goods.id }" style="width:230px;height:275px;margin-right:8px;margin-bottom:15px;">
						<div class="info">
						<div class="img pic">
							<a href="../web/goods_details.jsp?id=${goods.id}">
								<img src="..${goods.image }" alt="" onclick="toItemInfo(${goods.id})" style="width:230px;height:180px;margin-bottom:10px"/>
							</a>
						</div>			
						<div class="describe">
							<a href="../web/goods_details.jsp?id=${goods.id}">
							<p onclick="toItemInfo(${goods.id})" style="line-height:16px;height:48px;margin-bottom:10px">${goods.title}</p>
							</a>
							<span class="price"><b>￥</b><span class="priceContent">${goods.price}.00</span></span>
							<span class="addCart" style="margin-left:10px;">
								<img id="collect" src="../images/search/care.png" alt="" />
								<a href="javascript:void(0);" class="add_cart">加入购物车</a>
								</span>
						</div>
						</div>
					</div>
					</c:forEach>
					</div>
				<!--分页器-->
                <div class="tcdPageCode" style="width:1000px"></div>
				</div>
			</section>
		</form>
	</div>
	<!-- 尾部-->
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
<div class="modal" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            操作提醒
        </div>
        <div class="modal_information">
            <img src="../images/model/model_img2.png" alt=""/>
            <span>将您的宝贝加入购物车？</span>

        </div>
        <div class="yes"><span>确定</span></div>
        <div class="no"><span>取消</span></div>
    </div>
</div>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index.js"></script>
	<script src="../js/jquery.page6.js"></script>
	<script type="text/javascript" src="../js/jquery-getUrlParam1.js"></script>
	
	<script>
	$(function(){
		var id;
	$(".add_cart").click(function(){
		$(".modal").show();
		id = $(this).parent().parent().parent().parent().attr("id");
		$(".modal .modal_information span").html("将您的宝贝加入购物车?");
	})
	$(".yes").click(function(){
	    $(".modal").hide();
	    $.ajax({
            type: "POST",
            url: "../cart/add_to_cart.do",
            data: {goods_id:id,goods_num:1},
            dataType:"json",
            success: function(data){
            	if (data.state == '200') {
            		alert("加入购物车成功！");
            		//window.location.href="#";
    			}else if(data.state == 501||data.state == 502){
    				alert("加入 购物车失败！");
    			}else {
    				window.location.href = data;
    			}
            }
        });
	})
	$('.no').click(function(){
    	$('.modal').hide();
    	
    })
	})
</script>
<!-- <script type="text/javascript">
	$(".tcdPageCode").createPage({
		// 总页数
	    pageCount:8,
	 	// 起始页
	    current:1,
	    backFn:function(p){
	    	// 执行代码
	    	window.location.href="http://localhost:18888/search.html?q=${q}&page="+p;
	    }
	});
</script> -->
<script type="text/javascript">
function showPages() {
	var page = $.getUrlParam("page");
	var keyWord = $.getUrlParam("keyWord");
	if (page == null || isNaN(page)) {
		page = 1;
	}
	var url = "../goods/get_max_page.do";
	$.ajax({
		"url": url,
		"type": "GET",
		"data":"keyWord="+keyWord,
		"dataType": "json",
		"success": function(json) {
			var maxPage = json.data;
			//分页部分
			for(var i=1;i<=maxPage;i++){
				if(i==page){
					$(".tcdPageCode").createPage({
					    pageCount:maxPage,
					    current:i,
					    backFn:function(p){
					    	
					          }
					});
				}
			}
		}
	});
}
showPages();
</script>
<script type="text/javascript">
$(function() {
	var keyWord = $.getUrlParam("keyWord");
	$(".tcdPageCode>a").each(function(){
		var current = $.getUrlParam("page");
		if (current == null || isNaN(current)) {
			current = 1;
		}
		if($(this).hasClass("nextPage")){
				 current++;
				 $(this).attr("href","?keyWord="+keyWord+"&page="+current);
			 }else if($(this).hasClass("prevPage")){
				 current--;
				 $(this).attr("href","?keyWord="+keyWord+"&page="+current);
			 }else if($(this).hasClass("tcdNumber")){
				 var val = $(this).html();
				 $(this).attr("href","?keyWord="+keyWord+"&page="+val);
			 }
	}); 
})
</script>
<!--<script type="text/javascript">
    /* 商品详情页  */
	function toItemInfo(id) {
		if (id) {
			window.location.href="/toItemInfo/"+id+".html";
		}else {
			alert("商品id不存在");
		}
	} 
</script>-->
<script type="text/javascript">
	/**添加到收藏**/
    $("#collect").click(function(e){
    	$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入收藏夹");
    })
    $(".yes").click(function(){
	    $(".modal").hide();
	    $('#collect').attr("src","../images/search/care1.png");
    })
</script>
</body>
</html>