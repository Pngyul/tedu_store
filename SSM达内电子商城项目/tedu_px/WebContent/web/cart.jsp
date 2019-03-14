<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>商城购物车</title>
    <link rel="stylesheet" href="../css/header7.css"/>
    <link rel="stylesheet" href="../css/footer.css"/>
    <link rel="stylesheet" href="../css/cart.css"/>
    <style type="text/css">
    #pages { height: 30px; }
    #pages li { float: right; height: 30px; margin: 0 10px 0 0; }
    #pages li a { border: 1px solid #999; display: block; width: 24px; line-height: 24px; text-align: center; font-size: 14px; }
    #pages li a:hover { background: #fff; color: #000; }
    </style>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<div class="modal" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            删除提醒
        </div>
        <div class="modal_information">
            <img src="../images/model/model_img2.png" alt=""/>
            <span>确定删除您的这个宝贝吗？</span>
        </div>
        <div class="yes"><span>忍心删除</span></div>
        <div class="no"><span>再想想</span></div>
    </div>
</div>
<div class="modalNo" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            删除提示
            <img src="../images/model/model_img1.png" alt="" class="rt close"/>
        </div>
        <div class="modal_information">
            <img src="../images/model/model_img2.png" alt=""/>
            <span>请选择商品</span>
        </div>
    </div>
</div>
<div class="big">
    <form  name="" action="" method="post">
    <%-- <c:if test="${carts[0] != null}">  --%>
    <section id="section" >
        <div id="title">
            <b>购物车</b>
            <p>
                已选<span class="total color">0</span>件商品<span class="interval"></span>合计(不含运费):<span class="totalPrices color susum">0.00</span><span class="unit color">元</span>
            </p>
        </div>
        <div id="box" >
            <div id="content_box">
                <div class="imfor_top">
                    <div class="check_top">
                        <div class="all">
                            <span class="normal">
                                <img src="../images/cart/product_normal.png" alt=""/>
                            </span>  <input type="hidden" name="" value="">全选
                        </div>
                    </div>
                    <div class="pudc_top">商品</div>
                    <div class="pices_top">单价(元)</div>
                    <div class="num_top">数量</div>
                    <div class="totle_top">金额</div>
                    <div class="del_top">操作</div>
                </div>
                <div id="carts">
                
            	</div>
            	<div>
            		<ul id="pages"> 
	           		</ul>
            	</div>
			</div>
            <div class="foot">
                <div class="foot_check">
                    <div class="all">
                        <span class="normal">
                                <img src="../images/cart/product_normal.png" alt=""/>
                            </span>  <input type="hidden" name="" value="">全选
                    </div>
                </div>
                <a href="javascript:;" class="foot_del">删除</a>
                <!--<a href="javascript:;" class="foot_yr">移入收藏夹</a>-->
                <div class="foot_qk">清空失效商品</div>
                <div class="foot_cash" id="go-buy">去结算</div>
                <div class="foot_tol"><span>合计(不含运费):</span><span  class="foot_pices susumOne">0.00</span><span class='foot_des'>元</span></div>
                <div class="foot_selected">
                    已选<span class="totalOne color">0</span>件商品
                </div>
            </div>
        </div>
    </section>
    <%-- </c:if>  --%>
    </form>
    <%-- <c:if test="${carts[0] == null}"> --%>
    <div class="none" style="display:none">
        <p class="none_title">购物车</p>
        <div class="none_top"></div>
        <div class="none_content">
            <img src="../images/30.png" alt="" class="lf"/>
            <p class="lf">您的购物车竟然还是空哒( ⊙ o ⊙ )</p>
            <span class="lf">赶快去下单吧！</span>
            <a href="../main/showIndex.do" class="lf">去购物>></a>
        </div>
	<%-- </c:if> --%>
    </div>
</div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script>
    <!-- 显示空购物车页面-->
   $(function(){
    	//alert($("#sdsd").length);
        if(!$(".imfor").length>0) {
            $('#section').hide();
            $('.none').show();
        }
    })  
</script>
<script type="text/javascript" src="../js/jquery-getUrlParam1.js"></script>
<script type="text/javascript">
function showCartList() {
	
	var url = "../cart/list.do";
	var page = $.getUrlParam("page");
	if (page == null || isNaN(page)) {
		page = 1;
	}
	$.ajax({
		"url": url,
		"data": "page=" + page,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var carts = json.data;
            $("#carts").empty();
			for (var i = 0; i < carts.length; i++) {
				var html = '<div class="imfor">'
	            	+ '<div class="check">'
	            	+ '<div class="each">'
	            	+ '<span class="normal">'
                    + '<img src="../images/cart/product_normal.png" alt=""/>'
                    + '</span>'
	            	+ '<input type="hidden" name="cart_id" value="{cartId}" />'
	            	+ '</div>'
	            	+ '</div>'
	            	+ '<div class="pudc">'
	            	+ '<div class="pudc_information" id="{goodsId}">'
	            	+ '<a href="../web/goods_details.jsp?id={goodsId}">'
	            	+ '<img src="..{goodsImage}" class="lf" border="1px" style="width: 82px; height: 82px;border-color:#e8e8e8"/>'
	            	+ '</a>'
	            	+ '<input type="hidden" name="" value="">'
	            	+ '<span class="des lf" style="margin-bottom:5px">'
	            	+ '{goodsTitle}'
	            	+ '<input type="hidden" name="" value="">'
	            	+ '</span>'
	            	+ '<p class="col lf"><span>颜色：</span><span class="color_des">炫酷黑  <input type="hidden" name="" value=""></span></p>'
	            	+ '</div>'
	            	+ '</div>'
	            	+ '<div class="pices">'
	            	+ '<p class="pices_des">达内专享价</p>'
	            	+ '<p class="pices_information"><b>￥</b><span>{goodsPrice}.00</span></p>'
	            	+ '</div>'
	            	+ '<div class="num"><span class="reduc">&nbsp;-&nbsp;</span><input type="text" value="{goodsNum}" /><span class="add">&nbsp;+&nbsp;</span></div>'
	            	+ '<div class="totle">'
	            	+ '<span>￥</span>'
	            	+ '<span class="totle_information">{goodsTotalPrice}.00</span>'
	            	+ '</div>'
	            	+ '<div class="del">'
	            	+ '<a href="javascript:;" class="del_d">删除</a>'
	            	+ '</div>'
	            	+ '</div>';
	            	
				html = html.replace("{cartId}", carts[i].id);
				html = html.replace("{goodsImage}", carts[i].goodsImage);
				html = html.replace(/{goodsId}/g, carts[i].goodsId);
				html = html.replace("{goodsTitle}", carts[i].goodsTitle);
				html = html.replace("{goodsPrice}", carts[i].goodsPrice);
				html = html.replace("{goodsNum}", carts[i].goodsNum);
				html = html.replace("{goodsTotalPrice}", carts[i].goodsPrice * carts[i].goodsNum);
				
            	$("#carts").append(html);
			}
		}
	});
}
function showPages() {
	var url = "../cart/get_max_page.do";
	$.ajax({
		"url": url,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var maxPage = json.data;
			$("#pages").empty();
			for (var i = 1; i <= maxPage; i++) {
				var html = '<li><a href="?page={page}">{page}</a></li>';
				html = html.replace(/{page}/g, i);
				$("#pages").append(html);
			}
		}
	});
}

showCartList();
showPages();
</script>
<script src="../js/cart1.js"></script>
</body>
</html>