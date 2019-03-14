package cn.tedu.store.bean;

import java.io.Serializable;

public class District implements Serializable {
	
	private static final long serialVersionUID = -2777570570541589252L;
	
	private Integer id;
	private String parent_code;
	private String code;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", parent_code=" + parent_code + ", code=" + code + ", name=" + name + "]";
	}



}
