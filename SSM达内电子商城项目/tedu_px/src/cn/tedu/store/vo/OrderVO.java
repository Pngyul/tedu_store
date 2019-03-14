package cn.tedu.store.vo;

import java.util.List;

import cn.tedu.store.bean.OrderItem;


public class OrderVO {

	private Integer id;
	private String recvName;
	private String recvPhone;
	private List<OrderItem> orderItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecvName() {
		return recvName;
	}

	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}

	public String getRecvPhone() {
		return recvPhone;
	}

	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", recvName=" + recvName + ", recvPhone=" + recvPhone + ", orderItems="
				+ orderItems + "]";
	}

}
