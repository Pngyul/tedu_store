<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header7.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>订单管理</a></li>
    </ul>
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
        <!-- 左边栏-->
        <jsp:include page="left.jsp"></jsp:include>
         <!-- 右边栏-->
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="90">交易状态</th>
                    <th width="92">操作</th>
                </tr>
            </table>
         <div id="orders">
            <!-- 订单列表项 -->
            <div id="orderItem">
              <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
                 </span>
                  &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                        联系客服<img src="../images/myOrder/kefuf.gif"/>
                      </a>
                 </span>
              </p>
            </div>
            <div id="orderItem_detail">
                  <ul>
                      <li class="product">
                          <b><a href="#"><img src="../images/myOrder/product_img1.png" /></a></b>
                          <b class="product_name lf" >
                              <a href="">联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)</a>
                              <br/>
                          </b>
                          <b class="product_color ">
                              颜色：深空灰
                          </b>
                      </li>
                      <li class="unit_price">
                          专属价
                          <br/>
                          ￥8800
                      </li>
                      <li class="count">
                          1件
                      </li>
                      <li class="sale_support">
                          退款/退货
                          <br/>
                          我要维权
                      
                      <li class=" payments_received">
                          ￥1222.00
                      </li>
                      <li class="trading_status">
                          <img src="../images/myOrder/car.png" alt=""/>已发货
                          <br/>
                          <a href="orderInfo.html">订单详情</a>
                          <br/>
                          <a href="#" class="view_logistics">查看物流</a>
                      </li>
                      <li class="operate">
                          <a href="../web/help.jsp">确认收货</a>
                      </li>
                  </ul>
              </div>

            <div id="orderItem">
                <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
                 </span>
                    &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                         联系客服<img src="../images/myOrder/kefuf.gif"/>
                     </a>
                 </span>
                </p>
            </div>
            <div id="orderItem_detail">
                <ul>
                    <li class="product">
                        <b><a href="#"><img src="../images/myOrder/product_img1.png" /></a></b>
                        <b class="product_name lf" >
                            <a href="">联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)</a>
                            <br/>
                        </b>
                        <b class="product_color ">
                            颜色：深空灰
                        </b>
                    </li>
                    <li class="unit_price">
                        专属价
                        <br/>
                        ￥8800
                    </li>
                    <li class="count">
                        1件
                    </li>
                    <li class="sale_support">
                        退款/退货
                        <br/>
                        我要维权
                    </li>
                    <li class=" payments_received">
                        ￥1222.00
                    </li>
                    <li class="trading_status">
                        <img src="../images/myOrder/car.png" alt=""/>已发货
                        <br/>
                        <a href="orderInfo.html">订单详情</a>
                        <br/>
                        <a href="#" class="view_logistics">查看物流</a>
                    </li>
                    <li class="operate">
                        <a href="#">确认收货</a>
                    </li>
                </ul>
            </div>

            <div id="orderItem">
                <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
                 </span>
                    &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                         联系客服<img src="../images/myOrder/kefuf.gif"/>
                     </a>
                 </span>
                </p>
            </div>
            <div id="orderItem_detail">
                <ul>
                    <li class="product">
                        <b><a href="#"><img src="../images/myOrder/product_img1.png" /></a></b>
                        <b class="product_name lf" >
                            <a href="">联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)</a>
                            <br/>
                        </b>
                        <b class="product_color ">
                            颜色：深空灰
                        </b>
                    </li>
                    <li class="unit_price">
                        专属价
                        <br/>
                        ￥8800
                    </li>
                    <li class="count">
                        1件
                    </li>
                    <li class="sale_support">
                        退款/退货
                        <br/>
                        我要维权
                    </li>
                    <li class=" payments_received">
                        ￥1222.00
                    </li>
                    <li class="trading_status">
                        <img src="../images/myOrder/car.png" alt=""/>已发货
                        <br/>
                        <a href="orderInfo.html">订单详情</a>
                        <br/>
                        <a href="#" class="view_logistics">查看物流</a>
                    </li>
                    <li class="operate">
                        <a href="#">确认收货</a>
                    </li>
                </ul>
            </div>

		</div>


<!--分页器-->
            <div class="tcdPageCode"></div>

        </div>
    </div>

        <!--<iframe src="order_status.html" width="1000" height=500""></iframe>-->
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page6.js"></script>
<script type="text/javascript" src="../js/orders1.js"></script>
<script type="text/javascript" src="../js/jquery-getUrlParam1.js"></script>
<script type="text/javascript">
 function loadOrder(){
	var url = "../order/orderitem_list.do";
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
			var orderItem = json.data;
            $("#orders").empty();
			for (var i = 0; i < orderItem.length; i++) {
				var html = '<div id="orderItem">'
	             		 + '<p class="orderItem_title">'
	              		 + '<span id="order_id">'  
	                	 + ' &nbsp;&nbsp;订单编号:<a href="#">{orderId}</a>'   
	                	 + '</span>' 
	                	 + ' &nbsp;&nbsp;成交时间：{createdTime} 13:52&nbsp;&nbsp;'
	                	 + '<span>'
	                     + '<a href="#" class="servie">'  
	                     + '联系客服<img src="../images/myOrder/kefuf.gif"/>'
	                     +' </a>'
	                     + '</span>'
	              		 + '</p>'
	              		 + '</div>'
	          		     + '<div id="orderItem_detail">'
	                  	 + '<ul>'
	                     + '<li class="product">'  
	                     + '<b><a href="../web/goods_details.jsp?id={goodsId}"><img src="..{goodsImage}" width="82px" height="82px" border="1px" style="border-color:#e8e8e8"/></a></b>'
	                     + '<b class="product_name lf" >'
	                     + '<a href="../web/goods_details.jsp?id={goodsId}">{goodsTitle}</a>'
	                     + '<br/>'
	                     + '</b>'
	                     + '<b class="product_color ">颜色：深空灰</b>'
	                     + '</li>'
	                     + '<li class="unit_price">专属价<br/>'
	                     + '￥{goodsPrice}'
	                     + '</li>'
	                     + '<li class="count">'
	                     + '{goodsNum}件'
	                     + '</li>'
	                     + '<li class="sale_support">'
	                     + '退款/退货 <br/>'
	                     + '我要维权'
	                     + '</li>'
	                     + '<li class=" payments_received">'
	                     + ' ￥{goodsTotalPrice}.00'
	                     + '</li>'
	                     + '<li class="trading_status">'
	                     + '<img src="../images/myOrder/car.png" alt=""/>已发货'
	                     + '<br/>'
	                     + '<a href="../order/orderInfo.do?id={orderId}">订单详情</a>'
	                     + '<br/>'
	                     + '<a href="../web/505.jsp" class="view_logistics">查看物流</a>'
	                     + '</li>'
	                     + '<li class="operate">'
	                     + '<a href="../web/505.jsp">确认收货</a>'
	                     + '</li>'
	                     + '</ul>'
	                     + '</div>';
	            	
				html = html.replace(/{orderId}/g, orderItem[i].orderId);
				html = html.replace(/{goodsId}/g, orderItem[i].goodsId);
				html = html.replace("{goodsImage}", orderItem[i].goodsImage);
				html = html.replace("{goodsPrice}", orderItem[i].goodsPrice);
				html = html.replace("{goodsTitle}", orderItem[i].goodsTitle);
				html = html.replace("{goodsNum}", orderItem[i].goodsNum);
				html = html.replace("{createdTime}", "2019-03-14");
				html = html.replace("{goodsTotalPrice}", orderItem[i].goodsPrice*orderItem[i].goodsNum);
				
            	$("#orders").append(html);
			}
		}
	});
} 
 
 loadOrder();
</script>
<script type="text/javascript">
function showPages() {
	var page = $.getUrlParam("page");
	if (page == null || isNaN(page)) {
		page = 1;
	}
	var url = "../order/get_max_page.do";
	$.ajax({
		"url": url,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var maxPage = json.data;
			//$(".tcdPageCode").empty();
			//分页部分
			//不知道为啥我直接赋值page会有点小问题，我也很纳闷！！！！
			/* $(".tcdPageCode").createPage({
					    pageCount:maxPage,
					    current:page,
					    backFn:function(p){
					    	
					          }
					}); */
			//就这样循环一下就可以了。。。。。
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
	var current = $.getUrlParam("page");
	if (current == null || isNaN(current)) {
		current = 1;
	}
	$(".tcdPageCode>a").each(function(){
		$(this).click(function(){
			if($(this).hasClass("nextPage")){
				 current++;
				 window.location.href="?page="+current;
			 }else if($(this).hasClass("prevPage")){
				 current--;
				 window.location.href="?page="+current;
			 }else if($(this).hasClass("tcdNumber")){
				 var val = $(this).html();
				 window.location.href="?page="+val;
			 }
		});
		 
	}); 
})
</script>
</html>











