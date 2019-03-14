/**
 * Created by ttssiw on 2017/1/3.
 */
//管理收藏夹
$(function(){
        /*if(!$("#content_box").chidren().length>0) {
            $('#section').hide();
            $('.none').show();
        }*/
    
$('.manage').click(function(){
    if($('.manage span').hasClass('normal')){
        $('.manage span').removeClass('normal').addClass('show');
        $('.manage span').html('取消管理');
        $('.check_top').show();
        $('.mask').show();
    }else{
        $('.manage span').removeClass('show').addClass('normal');
        $('.manage span').html('管理收藏夹');
        $('.check_top').hide();
        $('.mask').hide();
        
    }
})
//单选

$('.mask').click(function(){
    if($(this).children().hasClass('maskNormal')){
        $(this).children().addClass('maskTrue').removeClass('maskNormal');
        $(this).children().children().attr('src','../images//myCollect/product_true_big.png');
    }else{
        $(this).children().addClass('maskNormal').removeClass('maskTrue');
        $(this).children().children().attr('src','../images/myCollect/product_normal_big.png');
    }
})
//全选
$('.all').click(function(){
    if($('.all span').hasClass('normal')){
        $('.all>span').addClass('true').removeClass('normal');
        $('.all>span>img').attr('src','../images/myCollect/product_true.png');
        $(".mask>div").each(function() {
            $(this).addClass('maskTrue').removeClass('maskNormal');
            $(this).children('img').attr('src','../images/myCollect/product_true_big.png');
        })
    }else{
        $('.all>span').addClass('normal').removeClass('true');
        $('.all>span>img').attr('src','../images/myCollect/product_normal.png');
        $(".mask>div").each(function() {
            $(this).addClass('maskNormal').removeClass('maskTrue');
            $(this).children('img').attr('src', '../images/myCollect/product_normal_big.png');
        })
    }
})

$('.del').click(function(){
    var str=[];
    $('.mask>div').each(function(){
        if($(this).hasClass('maskTrue')){
            var id=$(this).parent().parent().children("input").val();
            str.push(id);
        }
    });
    var data = "";
    var collect_ids = str.toString().split(',');
    for(var i=0;i<collect_ids.length;i++){
    	data += "&collect_ids="+collect_ids[i];
    }
    if(str.length>0){
        $('.modal').show();
        //删除宝贝
        $('.yes').one("click",function(){
        	 $('.modal').hide();
             $.ajax({
                 type: "POST",
                 url: "../collect/delete_collect_Items.do",
                 data: data,
                 dataType:"json",
                 success: function(json){
                 	if (json.state == 200) {
                 		window.location.href="../collect/showFavorites.do";
     				}else if(json.state == 503){5
    					alert(json.message);
    				}else {
    					window.location.href = data;
    				}
                 }
             });
        })
        $('.no').click(function(){
            $('.modal').hide();
        })
    }else{
        $('.modalNo').fadeIn();
        $('.close').click(function(){
            $('.modalNo').fadeOut();
        })
    }
})
$('.allAdd').click(function(){
	
    var str=[];
    $('.mask>div').each(function(){
        if($(this).hasClass('maskTrue')){
            var id=$(this).parent().parent().attr('id');
            str.push(id);
        }
    });
    var data = "";
    var goods_ids = str.toString().split(',');
    for(var i=0;i<goods_ids.length;i++){
    	data += "&goods_ids="+goods_ids[i];
    }
    console.log(str);
    if(str.length>0){
    	$(".modalYi").show();
        $(".yes").one("click",function(){
        	$('.modalYi').hide();
        	$('.mask').hide();
    		$(".check_top").hide();
    		$(".manage").children('span').html("管理收藏夹");
            $.ajax({
                type: "POST",
                url: "../cart/collect_To_Cart.do",
                data: data,
                dataType:"json",
                success: function(data){
                	if (data.state == 200) {
                		/*setTimeout(function(){
                			window.location.href="/favorites.jsp";
                		},1000);*/
                		alert("加入购物车成功！");
                		window.location.href="../collect/showFavorites.do";
    				}else if(data.state == 501||data.state == 502){
    					alert("加入购物车失败！");
    				}else {
    					window.location.href = data;
    				}
                }
            });
        })
    }else{
        $('.modalAdd').fadeIn();
        $('.close').click(function(){
        $('.modalAdd').fadeOut();
        })
    }
})
//单独添加购物车
$('.addCart').click(function(){
    var id= $(this).parent().parent().attr('id');
    $(".modalYi").show();
    $(".yes").one("click",function(){
    	$(".modalYi").hide();
    	$.ajax({
            type: "POST",
            url: "../cart/add_to_cart.do",
            data: {goods_id:id,goods_num:1},
            dataType:"json",
            success: function(data){
            	if (data.state == '200') {
            		alert("加入购物车成功！");
            		window.location.href="../collect/showFavorites.do";
    			}else if(data.state == 501||data.state == 502){
    				alert("加入 购物车失败！");
    			}else {
    				window.location.href = data;
    			}
            	
            }
        });
    });
    
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


//加入购物车
$('.no').click(function(){
    $('.modalYi').hide();
})
})