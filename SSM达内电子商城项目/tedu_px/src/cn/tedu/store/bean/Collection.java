package cn.tedu.store.bean;

import java.util.Date;

public class Collection extends BaseEntity {

	private static final long serialVersionUID = 8369726853872288207L;
	
	private Integer id;
	private Integer uid;
	private String goodsId;
	private String createdUser;
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Collection [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", createdUser=" + createdUser
				+ ", createdTime=" + createdTime + "]";
	}
	



}