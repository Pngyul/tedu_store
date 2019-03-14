<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header7.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../css/icon/css/bootstrap.min.css">
	<link href="../css/icon/css/cropper.min.css" rel="stylesheet">
	<link href="../css/icon/css/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/icon/css/font-awesome.min.css">
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<div id="nav_order">
		<ul>
			<li><a href="">首页<span>&gt;</span>个人中心
			</a></li>
		</ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span class="rs_header_active"><a href="../user/showPersonalPage.do">我的信息</a></span>
            <span><a href="../user/showPersonal_password.do">安全管理</a></span>
        </div>
        <FORM id=form1 name=form1
		action="#" enctype="multipart/form-data" >
        <!--个人信息具体内容 -->
        <div class="rs_content">
        
            <!--头像-->
            <div class="rs_content_headPortrait">
	                <span class="same">我的头像：</span>
	                <img src="../../..${user.user_image }" alt="" id="icon" width="50px" height="50px"/>
	                <input type="file" name="file" id="iconPic" onchange="getImage()">
	                <input type="hidden" name="user_image" value="${user.user_image }" id="user_image">
	               <!-- <span class="change_headPortrait same_click" data-toggle="modal" data-target="#avatar-modal" >更改头像</span> -->
	            </div>
            <!--用户名-->
            <div class="rs_content_username">
                <span class="same">用户名：</span>
                <span class="same rs_username">${user.user_name }</span>
                <input class="ed_username" name="user_name" value="${user.user_name }" style="display: none;"/>
                <span class="change_username same_click">更改用户名</span>
            </div>
            <!--性别-->
            <div class="rs_content_sex">
                <span class="same">性别：</span>
                <c:if test="${user.user_gender==0 }">
                <input id="gender_inp_male" name="user_gender" type="radio" value="0" checked="checked" />男 
                <input id="gender_inp_female" name="user_gender" type="radio" value="1" />女
                </c:if>
                <c:if test="${user.user_gender!=0 }">
                <input id="gender_inp_male" name="user_gender" type="radio" value="0"  />男 
                <input id="gender_inp_female" name="user_gender" type="radio" value="1" checked="checked"/>女
                </c:if>
            </div>
            <!-- <div class="rs_content_sex">
                <span class="same">性别：</span>
                <span class="man selected">
                    <img src="../images/personage/select.png" alt=""/>男
                </span>
                <span class="women">
                    <img src="../images/personage/un_select.png" alt=""/>女
                </span>
            </div> -->
            <!--绑定电话-->
            <div class="rs_content_tel">
                <span class="same">绑定电话：</span>
                <input type="text" name="user_phone" value="${user.user_phone }"/>
            </div>
            <!--绑定邮箱-->
            <div class="rs_content_mail">
                <span class="same">绑定邮箱：</span>
                <input name="user_email" class="ed_email" value="${user.user_email }" style="display: none;"/>
                <span class="rs_mail">${user.user_email }</span>
                <span class="same_click change_mail">更改邮箱</span>
            </div>
            <!--保存按钮-->
            <div class="save">
                保存更改
            </div>
        </div>
        </FORM>
    </div>
</div>
<!-- 头像插件 -->
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1"> 
    <div class="modal-dialog modal-lg"> 
        <div class="modal-content"> 
            <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">--> 
            <form class="avatar-form"> 
                <div class="modal-header"> 
                    <button class="close" data-dismiss="modal" type="button">×</button> 
                    <h4 class="modal-title" id="avatar-modal-label">上传图片</h4> 
                </div> 
                <div class="modal-body"> 
                    <div class="avatar-body"> 
                        <div class="avatar-upload"> 
                            <input class="avatar-src" name="avatar_src" type="hidden"> 
                            <input class="avatar-data" name="avatar_data" type="hidden"> 
                            <label for="avatarInput" style="line-height: 35px;">图片上传</label> 
                            <button class="btn btn-info"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button> 
                            <span id="avatar-name"></span> 
                            <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div> 
                        <div class="row"> 
                            <div class="col-md-9"> 
                                <div class="avatar-wrapper"></div> 
                            </div> 
                            <div class="col-md-3"> 
                                <div class="avatar-preview preview-lg" id="imageHead"></div> 
                                <!--<div class="avatar-preview preview-md"></div> 
                        <div class="avatar-preview preview-sm"></div>--> 
                            </div> 
                        </div> 
                        <div class="row avatar-btns"> 
                            <div class="col-md-4"> 
                                <div class="btn-group"> 
                                    <button class="btn btn-info fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button> 
                                </div> 
                                <div class="btn-group"> 
                                    <button class="btn  btn-info fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button> 
                                </div> 
                            </div> 
                            <div class="col-md-5" style="text-align: right;">                                 
                                <button class="btn btn-info fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("setDragMode", "move")"> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", 0.1)"> 
                                  <!--<span class="fa fa-search-plus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", -0.1)"> 
                                  <!--<span class="fa fa-search-minus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-refresh" data-method="reset" title="重置图片"> 
                                    <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("reset")" aria-describedby="tooltip866214"> 
                               </button> 
                            </div> 
                            <div class="col-md-3"> 
                                <button id="button_save" class="btn btn-info btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
            </form> 
        </div> 
    </div> 
</div> 
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders1.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script src="../js/icon/bootstrap.min.js"></script>
<script src="../js/icon/cropper.js"></script>
<script src="../js/icon/sitelogo.js"></script>
<script src="../js/icon/html2canvas.min.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript"> 
//做个下简易的验证  大小 格式  
    $('#avatarInput').on('change', function(e) {
        var filemaxsize = 1024 * 5;//5M 
        var target = $(e.target); 
        var Size = target[0].files[0].size / 1024; 
        if(Size > filemaxsize) { 
            alert('图片过大，请重新选择!'); 
            $(".avatar-wrapper").childre().remove; 
            return false; 
        } 
        if(!this.files[0].type.match(/image.*/)) { 
            alert('请选择正确的图片!') 
        } else { 
            var filename = document.querySelector("#avatar-name"); 
            var texts = document.querySelector("#avatarInput").value; 
            var teststr = texts; //你这里的路径写错了 
            testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的 
            filename.innerHTML = testend; 
        } 
     
    }); 
 
    $(".avatar-save").on("click", function() { 
        var img_lg = document.getElementById('imageHead'); 
        // 截图小的显示框内的内容 
        html2canvas(img_lg, { 
            allowTaint: true, 
            taintTest: false, 
            onrendered: function(canvas) { 
                canvas.id = "mycanvas"; 
                //生成base64图片数据 
                var dataUrl = canvas.toDataURL("image/png"); 
                var newImg = document.createElement("img"); 
                newImg.src = dataUrl; 
                imagesAjax(dataUrl) 
            } 
        }); 
    }) 
    function imagesAjax(src) { 
        var data = {}; 
        data.img = src; 
        $.ajax({ 
            url: "", 
            data: data, 
            type: "POST", 
            dataType: 'json', 
            success: function(re) {
            	if (re) {
	                if(re.status == 200) {
	                    $('#icon').attr('src',re.data.url );
	                    $('#iconPic').val(re.data.url);
	                }else {
						alert("上传失败")
					} 
					
				}
            } 
        });
    } 
</script>
<script type="text/javascript">
$("#icon").click(function() {
	window.open($(this).attr("src"));
})
</script> 
<!--<script>
	$(".x").click(function(){
		$(".modal").hide();
	})
	$(".change_headPortrait").click(function(){
		$(".modal").show();
	})
</script>-->
<script>
	$("#button_save").click(function(){
		var url = $("#imageHead img").attr("src");
		$('#icon').attr('src',url);
	})
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

<script type="text/javascript">
	function getImage(){
		var formData = new FormData();
		
		var file = document.getElementById("iconPic").files[0];
		
		formData.append("file",file);
		
		$.ajax({
			url:"../user/upload.do",
			dataType:"json",
			type:"POST",
			data:formData,
			contentType:false,
			processData:false,
			
			success:function(obj){
				/* alert(obj.message); */
				//创建url对象
				var url = window.URL.createObjectURL(file);
				icon.src = url;
				$("#user_image").val(obj.data);
			}
			
		});
		
	}
</script>
<script type="text/javascript">
	$(".save").click(function(){
		/* var uname = $(".ed_username").val();
		var uemail = $(".ed_email").val(); */
		var inputData = $('#form1').serialize();
		$.ajax({
			url:"../user/changeInfo.do",
			dataType:"json",
			type:"POST",
			data:inputData,
			
			success:function(obj){
				alert(obj.message);
				if(obj.state == 1){
					window.location="../user/showPersonalPage.do";
				}
			}
			
		});
		
	});
</script>
</html>