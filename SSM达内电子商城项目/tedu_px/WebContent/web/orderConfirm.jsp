<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>确认订单</title>
    <link href="../css/orderConfirm0.css" rel="Stylesheet"/>
    <link href="../css/header7.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="Stylesheet"/>
    </head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<div id="navlist">
    <ul>
        <li class="navlist_blue_left"></li>
        <li class="navlist_blue">确认订单信息</li>
        <li class="navlist_blue_arro"><canvas id="canvas_blue" width="20" height="38"></canvas>
        </li>
        <li class="navlist_gray">支付订单<b></b></li>
        <li class="navlist_gray_arro"><canvas id="canvas_gray" width="20" height="38"></canvas>
        </li>
        <li class="navlist_gray">支付完成<b></b></li>
        <li class="navlist_gray_right"></li>
    </ul>
</div>
<!--订单确认-->
<div id="container" class="clear">
    <!--收货地址-->
    <div class="adress_choice">
        <p>收货人信息<span class="rt" id="choose">新增收货地址</span></p>
        <div id="address">
        <!-- <div id="addresId1" class="base_select">
            <i class="address_name">
                刘冉北京
            </i>
            <i class="user_address">
                北京市 海淀区 大钟寺123号 139366668888
            </i>
            <i class="user_site rt">
                设为默认地址
            </i>
        </div>
        <div id="addresId2" class="base">
            <i class="address_name">
                刘冉北京
            </i>
            <i class="user_address">
                北京市 海淀区 大钟寺123号 139366668888
            </i>
        
            <i class="user_site rt">
                设为默认地址
            </i>
        </div>
        <div id="addresId3" class="base">
            <i class="address_name">
                刘冉北京
            </i>
            <i class="user_address">
                北京市 海淀区 大钟寺123号 139366668888
            </i>
          
            <i class="user_site rt">
                设为默认地址
            </i>
        </div> -->
        </div>
        <a id="more" href="javascript:void(0);">
            更多地址 &gt;&gt;
        </a>
    </div>
    <!-- 商品信息-->
    <form id="cart_ids_form" method="post" action="#">
        <div class="product_confirm">
            <p>确认商品信息</p>
            <ul class="item_title">
                <li class="p_info">商品信息</li>
                <li class="p_price">单价(元)</li>
                <li class="p_count">数量</li>
                <li class="p_tPrice">金额</li>
            </ul>
            <div id="cart_list">
            <ul class="item_detail">
                <li class="p_info">
                    <b><img src="../images/orderConfirm/product_simg1.png"/></b>

                    <b class="product_name lf">
                        联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)
                    </b>
                    <br/>
                <span class="product_color ">
                   颜色：深空灰
                </span>
                </li>
                <li class="p_price">
                    <i>达内专属价</i>
                    <br/>
                    <span class="pro_price">￥<span class="ppp_price">4800.00</span></span>
                </li>
                <li class="p_count">X<span>1</span></li>
                <li class="p_tPrice">￥<span></span></li>
            </ul>
            </div>
        </div>
    </form>
    <!-- 结算条-->
    <div id="count_bar">
        <span class="go_cart"><a href="cart.jsp" >&lt;&lt;返回购物车</a></span>
        <span class="count_bar_info">已选<b  id="count"> 0 </b>件商品&nbsp;&nbsp;合计(不含运费):<b class="zj"></b> <input type="hidden" name="Payment" value=""/>元</span>
        <span class="go_pay">提交订单</span>
    </div>
</div>
<!--标题栏-->
<div class="modal" style="display:none">
        <!--收货人信息填写栏-->     
        <div class="rs_content rs_content_1">
        	<p class="cha">×</p>
        	<form id="address_form" method="post" action="${pageContext.request.contextPath }/address/insert.do">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recvName" id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div data-toggle="distpicker" class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span>
					 <select name="recvProvince" data-province="---- 选择省 ----" id="recvProvince">
					 <option value="0">----- 请选择 -----</option>
					 </select>
					  城市：<select name="recvCity" data-city="---- 选择市 ----" id="recvCity">
					  <option value="0">----- 请选择 -----</option>
					  </select>
					  区/县：<select name="recvArea" data-district="---- 选择区 ----" id="recvArea">
					  <option value="0">----- 请选择 -----</option>
					  </select>
				</div> 
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="recvAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="recvPhone"/>固定电话：<input type="text" name="recvTel" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="recvZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="recvTag"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient">
	                保存收货人信息
	            </div>
	
    		</form>
    		</div>
</div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
<script>

    
</script>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script>
    var html=0;
    var total=0;
    $(function(){
        $(".item_detail").each(function() {
            html+=1;
            var p=parseFloat($(this).children('.p_price').children('.pro_price').children('.ppp_price').html());
            console.log(p);
            var sl=parseFloat($(this).children('.p_count').children('span').html());
            var xj=parseFloat(p*sl).toFixed(2);
            console.log("xiaoji"+xj);
            $(this).children('.p_tPrice').children('span').html(xj);
            total+=xj-0;
        })
        console.log("zongji"+total);
        $("#count").html(html)-0;
        $('.zj').html(total.toFixed(2))-0;
        var input_zj=parseFloat($('.zj').html()).toFixed(2);
        $('#payment').val(input_zj);
    })
</script>

<script>
    var canvas=document.getElementById("canvas_gray");
    var cxt=canvas.getContext("2d");
    var gray = cxt.createLinearGradient (10, 0, 10, 38);
    gray.addColorStop(0, '#f5f4f5');
    gray.addColorStop(1, '#e6e6e5');
    cxt.beginPath();
    cxt.fillStyle = gray;
    cxt.moveTo(20,19);
    cxt.lineTo(0,38);
    cxt.lineTo(0,0);
    cxt.fill();
    cxt.closePath();
</script>
<script>
    var canvas=document.getElementById("canvas_blue");
    var cxt=canvas.getContext("2d");
    var blue = cxt.createLinearGradient (10, 0, 10, 38);
    blue.addColorStop(0, '#27b0f6');
    blue.addColorStop(1, '#0aa1ed');
    cxt.beginPath();
    cxt.fillStyle = blue;
    cxt.moveTo(20,19);
    cxt.lineTo(0,38);
    cxt.lineTo(0,0);
    cxt.fill();
    cxt.closePath();
</script>
<!-- <script src="../js/distpicker.data.js"></script>
<script src="../js/distpicker.js"></script> -->
<script>
	$("#choose").click(function(){
		$(".modal").show();
	})
	$(".cha").click(function(){
		$(".modal").hide();
	})
	
	$("#more").click(function(){
		if($(this).hasClass("upup")){
			$.each($("#address>div"), function(i, n){
				if(i !=0){
					$(this).hide();
				}
				});
			$("#more").html("更多地址>>");
			$(this).removeClass("upup");
		}else{
			$.each($("#address>div"), function(i, n){
					$(this).show();
				});
			$("#more").html("收起地址>>");
			$("#more").addClass("upup");
		}
		
	})
</script>

<script type="text/javascript" src="../js/jquery-getUrlParam1.js"></script>
<script type="text/javascript">
function showAddressDropDownMenu() {
	var url = "../address/list.do";
	$.ajax({
		"url": url,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var list = json.data;
			$("#address").empty();
			for (var i = 0; i < list.length; i++) {
				var html = '<div class="base" style="display:none">'
					+ '<input type="hidden" value="{value}" name="address_id" />'
					+ '<i class="address_name">{recvName}</i>'
					+ '<i class="user_address">   {text}</i>'
					
					+ '<i class="user_site rt" style="display:block">设为默认地址</i>'
					+ '</div>';
				html = html.replace("{value}", list[i].id);
				html = html.replace("{recvName}", list[i].recvName);
				html = html.replace("{text}",list[i].recvPhone + "/" + list[i].recvDistrict + " " + list[i].recvAddress);
				if(list[i].isDefault == 1){
					html = html.replace("base", "base_select");
					html = html.replace("block", "none");
					html = html.replace("none", "block");
				}
				$("#address").append(html);
			}
		}
	});
}

function showCarts() {
	var params = location.search.substring(1).split("&").toString();
	var strs = params.split("=");
	var paramsArray = strs[1].split(",");
	// params -> { "cart_id=10", "cart_id=14", "cart_id=15" }
	var data = ""; // 目标格式：ids=xx&ids=xx&ids=xx
	for (var i = 0; i < paramsArray.length; i++) {
		data += "&ids=" + paramsArray[i];
	}
	
	var url = "../cart/get_list_by_ids.do";
	$.ajax({
		"url": url,
		"data": data,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			var list = json.data;
			$("#cart_list").empty();
			
			var totalCount = 0;
			var totalPrice = 0;
			
			for (var i = 0; i < list.length; i++) {
				var html = '<ul class="item_detail">'
	                + '<li class="p_info">'
	                + '<b><input type="hidden" name="cart_id" value="{cartId}" /><img src="..{goodsImage}" style="width: 84px; height: 84px;"/></b>'
	                + '<b class="product_name lf">'
	                + '{goodsTitle}'
	                + '</b><br/>'
	                + '<span class="product_color ">颜色：深空灰</span>'
	                + '</li>'
	                + '<li class="p_price">'
	                + '<i>达内专属价</i><br/>'
	                + '<span class="pro_price">￥<span class="ppp_price">{goodsPrice}.00</span></span>'
	                + '</li>'
	                + '<li class="p_count">X<span>{goodsNum}</span></li>'
	                + '<li class="p_tPrice">￥<span>{goodsTotalPrice}</span></li>'
	                + '</ul>';
				
	            html = html.replace("{cartId}", list[i].id);
	            html = html.replace("{goodsImage}", list[i].goodsImage);
	            html = html.replace("{goodsTitle}", list[i].goodsTitle);
	            html = html.replace("{goodsPrice}", list[i].goodsPrice);
	            html = html.replace("{goodsNum}", list[i].goodsNum);
	            html = html.replace("{goodsTotalPrice}", list[i].goodsPrice * list[i].goodsNum);
				$("#cart_list").append(html);
				
				totalCount += list[i].goodsNum;
				totalPrice += list[i].goodsPrice * list[i].goodsNum;
			}
			$("#count").html(totalCount);
			$("#total_price").html(totalPrice);
		}
	});
}

showAddressDropDownMenu();
showCarts();
</script>


<script type="text/javascript">
function setDefault(id) {
	// 发AJAX请求，并处理结果
	var url = "../address/set_default.do";
	var data = "id=" + id;
	$.ajax({
		"url": url,
		"data": data,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			if (json.state == 200) {
				window.location.href="#";
			} else {
				alert(json.message);
			}
		},
		"error": function(xhr, textStatus, errorThrown) {
			if (xhr.status >= 400 && xhr.status < 500) {
				alert("请求错误，响应码=" + xhr.status);
			} else if (xhr.status >= 500) {
				alert("服务器端运行错误，响应码=" + xhr.status);
			} else if (xhr.status >= 300 && xhr.status < 400) {
				alert("您的登录信息已经过期，请重新登录！");
			} else {
				alert("未知错误！响应码=" + xhr.status)
			}
		}
	});
}
</script>
<script>
	$(document).on("mouseover",".base",function(){
		$(this).find("i:eq(2)").show();
	});
	$(document).on("mouseout",".base",function(){
		$(this).find("i:eq(2)").hide();
	});
$(function(){
	$(".user_site").click(function(){
		$(this).parent().attr("class","base_select");
		$(this).parent().siblings().attr("class","base");
		$(this).hide();
		var id = $(this).siblings("input").val();
		setDefault(id);
		window.location.href = "#";
	})
})
</script>
<script>
$(".go_pay").click(function () {
	var data = $("#cart_ids_form").serialize();
	var addressId = $("#address").children(".base_select").children("input").val();
	/* alert("addressId:"+addressId);
	alert("data"+data); */
	data = data+"&address_id="+addressId;
	//alert(data);
	var url = "../order/create.do";
	$.ajax({
		"url":url,
		"data":data,
		"type":"POST",
		"dataType":"json",
		"success":function(json){
			var order = json.data;
			//alert(order.id);
			if(json.state == 200){
				location.href = "payment.jsp?order_id="+order.id;
			} else{
				alert(json.message);
			}
		}
		
	});
})
</script>
<script type="text/javascript">
/* 获取地址初始化数据 */
function getDistricts(parent, menu) {
	menu.empty();
	
	var op = "<option value=0>----- 请选择 -----</option>";
	menu.append(op);
	
	var url = "../district/list.do";
	var data = "parent=" + parent;
	$.ajax({
		"url": url,
		"data": data,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			// 响应结果中的data即是省的列表
			var districts = json.data;
			// 遍历省的列表
			for (var i=0; i < districts.length; i++) {
				// 将省的数据填充到省的下拉菜单中
				var op = "<option value=" 
					+ districts[i].code 
					+ ">" 
					+ districts[i].name 
					+ "</option>";
				menu.append(op);
			}
		}
	});
}

// 页面加载完成时，即加载并显示省列表
getDistricts("86", $("#recvProvince"));

// 为省列表绑定change()函数，当选中的项发生变化时被触发
$("#recvProvince").change(function() {
	// 清空城市列表
	$("#recvCity").empty();
	// 清空区县列表
	$("#recvArea").empty();
	$("#recvArea").append("<option value=0>----- 请选择 -----</option>"); 
	
	// 获取省列表中选中的项
	var provinceCode = $("#recvProvince").val();
	// 判断当前选中的省是否为“请选择”
	if (provinceCode == 0) {
		return;
	}
	// 加载并显示城市列表
	getDistricts(provinceCode, $("#recvCity"));
});

// 为城市列表绑定change()函数，当选中的项发生变化时被触发
$("#recvCity").change(function() {
	// 清空区县列表
	$("#recvArea").empty();
	// 获取城市列表中选中的项
	var cityCode = $("#recvCity").val();
	// 判断当前选中的城市是否为“请选择”
	if (cityCode == 0) {
		return;
	}
	// 加载并显示区县列表
	getDistricts(cityCode, $("#recvArea"));
});
</script>
<script type="text/javascript">
$(".save_recipient").click(function(){
	var receiverName = $("#receiverName").val();// 收件人
	var receiverProvince = $("#recvProvince").val();// 省
	var receiverCity = $("#recvCity").val();// 市
	var receiverArea = $("#recvArea").val();// 区/县
	var receiverAddress = $("#receiverAddress").val();// 
	var receiverMobile = $("#receiverMobile").val();
	alert(receiverName+" "+receiverProvince+" "+receiverCity+" "+receiverArea+" "+receiverAddress+" "+receiverMobile);
	if(receiverName && receiverProvince && receiverCity && receiverArea && receiverAddress && receiverMobile){
		handle_addnew();
	}else{
		alert("请将必填信息填写完整");
	}
})
function handle_addnew(){
	var url = "../address/handle_addnew.do";
	var data = $("#address_form").serialize();
	$.ajax({
		"url": url,
		"data": data,
		"type": "post",
		"dataType": "json",
		"success": function(json) {
			if (json.state == 200) {
				alert("提交成功！");
				// 重置表单
				$("#address_form")[0].reset();
				$(".modal").hide();
				// 重新加载收货地址列表
				window.location.reload();
				//window.location.href=window.location.href+"";
			} else if (json.state == 501) {
				alert("严重错误！" + json.message);
			} else {
				alert("莫名其妙！！！");
			}
		},
		"error": function() {
			alert("您的登录信息已经过期，请重新登录！");
			location.href = "login.jsp";
		}
	});
}
</script>
</body>
</html>

