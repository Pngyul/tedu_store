<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 左边栏-->
		<div id="leftsidebar_box" class="lf">
			<div class="line"></div>
			<dl class="my_order">
				<dt>
					我的订单 <img src="../images/myOrder/myOrder2.png">
				</dt>
				<dd class="first_dd">
					<a href="../web/orders.jsp">全部订单</a>
				</dd>
				<dd>
					<a href="../web/help.jsp"> 待付款 <span> <!--待付款数量-->
					</span>
					</a>
				</dd>
				<dd>
					<a href="../web/help.jsp"> 待收货 <span> <!--待收货数量-->1
					</span>
					</a>
				</dd>
				<dd>
					<a href="../web/help.jsp"> 待评价<span> <!--待评价数量-->
					</span>
					</a>
				</dd>
				<dd>
					<a href="../web/help.jsp">退货退款</a>
				</dd>
			</dl>

			<dl class="footMark">
				<dt>
					我的优惠卷<img src="../images/myOrder/myOrder1.png">
				</dt>
			</dl>
			<dl class="address">
				<dt>
					收货地址<img src="../images/myOrder/myOrder1.png">
				</dt>
				<dd>
					<a href="../address/showAddressAdmin.do">地址管理</a>
				</dd>
			</dl>
			<dl class="count_managment">
				<dt>
					帐号管理<img src="../images/myOrder/myOrder1.png">
				</dt>
				<dd class="first_dd">
					<a href="../user/showPersonalPage.do">我的信息</a>
				</dd>
				<dd>
					<a href="../user/showPersonal_password.do">安全管理</a>
				</dd>
			</dl>
		</div>
		
		