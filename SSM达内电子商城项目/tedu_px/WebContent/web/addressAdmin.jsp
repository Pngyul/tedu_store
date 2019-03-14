<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header7.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div id="nav_order">
		<ul>
			<li><a href="">首页<span>&gt;</span>收货管理
			</a></li>
		</ul>
	</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
   <jsp:include page="left.jsp"></jsp:include>
   <!-- 右边栏-->
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form id="address_form" method="post" action="${pageContext.request.contextPath }/address/insert.do">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recvName" id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div data-toggle="distpicker" class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span>
					 <select name="recvProvince" data-province="---- 选择省 ----" id="recvProvince" style="width: 150px;">
					 	<option value="0">----- 请选择 -----</option>
					 </select>
					  城市：<select name="recvCity" data-city="---- 选择市 ----" id="recvCity" style="width: 150px;">
					 	<option value="0">----- 请选择 -----</option>
					 </select>
					  区/县：<select name="recvArea" data-district="---- 选择区 ----" id="recvArea" style="width: 150px;">
						<option value="0">----- 请选择 -----</option>
					 </select>
				</div> 
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="recvAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="recvPhone"/>
	                	固定电话：<input type="text" name="recvTel" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span><span>邮政编码：</span>&nbsp;<input type="text" name="recvZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="recvTag"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient" id="submit">
	                保存收货人信息
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
                <div class="aim_title">
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
                
                <div id="address_list">
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders1.js"></script>
<!-- <script type="text/javascript" src="../js/distpicker.data.js"></script> --><!-- 
<script type="text/javascript" src="../js/distpicker.js"></script> -->
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
<script type="text/javascript">
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
	/* $("#recvArea").append("<option value=0>----- 请选择 -----</option>"); */
	
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
				// 重新加载收货地址列表
				showList();
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
<script type="text/javascript">
function showList() {
	var url = "../address/list.do";
	$.ajax({
		"url": url,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			$("#address_list").empty();
			
			var addresses = json.data;
			for (var i=0; i < addresses.length; i++) {
				console.log(addresses[i].recvName + ", " + addresses[i].recvDistrict + ", " + addresses[i].recvAddress + ", " + addresses[i].isDefault);
				
				var html = '<div class="aim_content_one aim_active">'
	                + '<span class="dzmc dzmc_active">{tag}</span>'
	                + '<span class="dzxm dzxm_normal">{name}</span>'
	                + '<span class="dzxq dzxq_normal">{address}</span>'
	                + '<span class="lxdh lxdh_normal">{phone}</span>'
	                + '<span class="operation operation_normal">'
	                + '	<span class="aco_change">修改</span>|<span class="aco_delete"><a href="javascript:del({id});">删除</a></span>'
	                + '</span>'
	                + '<span class="swmr swmr_normal"><a href="javascript:setDefault({id});">{default}</a></span>'
	                + '</div>';
	                
	            html = html.replace("{tag}", addresses[i].recvTag);
	            html = html.replace("{name}", addresses[i].recvName);
	            html = html.replace("{address}", addresses[i].recvDistrict + addresses[i].recvAddress);
	            html = html.replace("{phone}", addresses[i].recvPhone);
	            html = html.replace(/{id}/g, addresses[i].id);
	            
	            if (addresses[i].isDefault != 1) {
	            	html = html.replace("dzmc_active", "dzmc_normal");
	            	html = html.replace(" aim_active", "");
	            	html = html.replace("{default}", "设为默认");
	            } else {
	            	html = html.replace("{default}", "");
	            }
            
				$("#address_list").append(html);
				
			}
		},
		"error": function(xhr, textStatus, errorThrown) {
			// xhr：XMLHttpRequest类型的对象
			// - responseText：响应的文本
			// - readyState：状态，值为0~4
			// - status：响应码
			console.log("状态码：" + xhr.readyState);
			console.log("响应码：" + xhr.status);
			console.log("响应文本：" + xhr.responseText);
			console.log("textStatus=" + textStatus);
			console.log("errorThrown=" + errorThrown);
		}
	});
}

showList();
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
				showList();
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
<script type="text/javascript">
function del(id) {
	var url = "../address/delete.do";
	var data = "id=" + id;
	$.ajax({
		"url": url,
		"data": data,
		"type": "GET",
		"dataType": "json",
		"success": function(json) {
			if (json.state == 200) {
				showList();
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

<script type="text/javascript">
	$(function(){
		//把所有的dd隐藏
		$("#leftsidebar_box dd").hide();
		//设置账号管理的列表显示
		$("#leftsidebar_box .address dd").show();
		//把所有箭头改为向右箭头
		$("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
		//账号管理箭头改为向下
		$("#leftsidebar_box .address img").attr("src","../images/myOrder/myOrder2.png");
	});

</script>
</html>