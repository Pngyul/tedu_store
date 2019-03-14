<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>阿甲学子商城-订单详情页</title>
    <link rel="stylesheet" href="../css/header7.css"/>
    <link rel="stylesheet" href="../css/footer.css"/>
    <link rel="stylesheet" href="../css/order.css"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!--详细信息-->
<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span>${order1.id }</span>
        </div>
        <div class="orderInfo_icon">
            <p>订单<span class="order-num">${order1.id }</span>&nbsp;&nbsp;&nbsp;当前状态：<span class="state">等待发货</span></p>
        </div>
        <!-- 订单状态流程图-->
        <div id="orderStatusChart">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
                  <dd>
                      <p>提交订单</p>
                      <span>${order1.createTime }</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img2_1.png" alt=""/></dt>
                  <dd>
                      <p>付款成功</p>
                      <span>${order1.payTime }</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img3.png" alt=""/></dt>
                  <dd>
                      <p style="display: none">配送中</p>
                      <span style="display: none">${order1.payTime }</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img4.png" alt=""/></dt>
                  <dd >
                      <p style="display: none">确认收货</p>
                      <span style="display: none">${order1.payTime }</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

            <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img5.png" alt=""/></dt>
                  <dd >
                      <p style="display: none">评价</p>
                      <span style="display: none">2019.03.14 13:39</span>
                  </dd>
              </dl>

        </div>
        <div class="clear">

        <!-- 详细信息-->
            <h1>详细信息</h1>
            收货人：<span class="consignee">${order1.recvName }</span>&nbsp;&nbsp;&nbsp;&nbsp;邮编：<span class="postcode">100000</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel">${order1.recvPhone }</span>
            <br/>
            <p>收货地址：<span>${order1.recvAddress }</span></p>
        </div>

        <!-- 物流信息-->
        <div style="width: 1000px; margin:0px auto" class="logistics">
            <h1>物流信息</h1>
            <p>发货时间：<span>2019.03.14 13:39</span></p>
            <p>物流公司：<span class="express">顺丰快递</span><a href="#">顺丰官网</a></p>
            <p>快递单号：<span>301111303203048</span></p>
            <div><span>物流信息：</span>
                <div>
                    <p>2019.03.14 13:39 您的快递在【北京马驹桥镇分拣中心】分拣完毕</p>
                    <p>2019.03.14 13:39 您的快递在【北京马驹桥镇分拣中心】准备装车</p>
                    <p>22019.03.14 13:39 您的快递到达【北京昌平分拣中心】</p>
                    <p>2019.03.14 13:39 您的快递到达【北京昌平沙河分拣中心】</p>
                </div>
            </div>
        </div>

        <!-- 商品信息-->
        <div style="width: 1000px; margin:0px auto">
            <h1 class="commodity">商品信息</h1>
            <div class="product_confirm">
                <ul class="item_title">
                    <li class="p_info">商品信息</li>
                    <li class="p_price">单价(元)</li>
                    <li class="p_count">数量</li>
                    <li class="p_tPrice">实付款</li>
                </ul>
                <div>订单编号：<span>${order1.id }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成交时间：${order1.payTime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系客服：<img src="../images/orderinfo/kefuf.gif" alt=""/></div>
                
                <!-- <ul class="item_detail" style="margin-bottom:10px">
                    <li class="p_info" style="height:102px">
                        <b><img src="../images/orderinfo/product_simg1.png" /></b>
                        <p class="product_name lf" >
                            联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)
                        </p>
                        <br/>
                <span class="product_color ">
                   颜色：深空灰
                </span>
                    </li>
                    <li class="p_price">
                        <i>专属价</i>
                        <br/>
                        <span class="pro_price">￥4888.80</span>
                    </li>
                    <li class="p_count">1件</li>
                    <li class="p_tPrice">￥4888.80</li>
                    <li class="remark">备注</li>
                    <li></li>
                </ul> -->
                
            </div>

        </div>

    </div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','../images/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','../images/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../images/header/care1.png");
    },function(){
        $(this).attr('src',"../images/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../images/header/order1.png");
    },function(){
        $(this).attr('src',"../images/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../images/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../images/header/shop_car.png");
    });
</script>
<script type="text/javascript">
function getOrderItem(oid){
	var url = "../order/getOrderItem.do";
	$.ajax({
		"url": url,
		"data": "oid="+oid,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var list = json.data;
			for (var i = 0; i < list.length; i++) {
				var html = '<ul class="item_detail" style="margin-bottom:10px">'
                	     + '<li class="p_info" height="102px">'
                		 + '<b><img src="..{goodsImage}" width="82px" height="82px" border="1px" style="border-color:#e8e8e8"/></b>'
               			 + ' <p class="product_name lf" >'
                         + '{goodsTitle}'
                         + ' </p>'
                         + ' <br/>' 
                         + '<span class="product_color ">'
                         + ' 颜色：深空灰'
                         + '</span>'
                         + ' </li>'
               			 + '<li class="p_price">'
                         + '<i>专属价</i>'
              			 + '<br/>'
             			 + '<span class="pro_price">￥{goodsPrice}.00</span>'
            			 + '</li>'
          				 + '<li class="p_count">{goodsNum}件</li>'
          				 + '<li class="p_tPrice">￥{goodsTotalPrice}.00</li>'
       					 + '</ul>';
	            	
				html = html.replace("{goodsImage}", list[i].goodsImage);
				html = html.replace("{goodsTitle}", list[i].goodsTitle);
				html = html.replace("{goodsPrice}", list[i].goodsPrice);
				html = html.replace("{goodsNum}", list[i].goodsNum);
				html = html.replace("{goodsTotalPrice}", list[i].goodsPrice * list[i].goodsNum);
				
				$(".product_confirm").append(html);
			}
		}
	});
}

getOrderItem(${order1.id});
</script>
</body>
</html>