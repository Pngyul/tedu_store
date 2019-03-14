package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

import com.sun.prism.Image;

public class User implements Serializable{

	private static final long serialVersionUID = -9211614298934592376L;
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private String user_email;
	private String user_phone;
	private String user_image;
	private Integer user_gender;
	private String created_user;
	private Date created_time;
	private String modified_user;
	private Date modified_time;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public Integer getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(Integer user_gender) {
		this.user_gender = user_gender;
	}

	public String getCreated_user() {
		return created_user;
	}

	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public String getModified_user() {
		return modified_user;
	}

	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", user_image=" + user_image + ", user_gender="
				+ user_gender + ", created_user=" + created_user + ", created_time=" + created_time + ", modified_user="
				+ modified_user + ", modified_time=" + modified_time + "]";
	}

	


}
