package com.channelsoft.demo.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private String id;
	private String phone;
	private String salt;
	private String password;
	private String nickName;
	private String userName;
	private String idNumber;
	private Integer gender;
	private String location;
	private Date registTime;
	private Date lastLogin;
	private Integer status;
	private String urlImage;
	private String localImage;
	private String email;
	private Integer type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String phone, String salt, String password, String nickName, String userName,
			String idNumber, Integer gender, String location, Date registTime, Date lastLogin, Integer status,
			String urlImage, String localImage, String email, Integer type) {
		super();
		this.id = id;
		this.phone = phone;
		this.salt = salt;
		this.password = password;
		this.nickName = nickName;
		this.userName = userName;
		this.idNumber = idNumber;
		this.gender = gender;
		this.location = location;
		this.registTime = registTime;
		this.lastLogin = lastLogin;
		this.status = status;
		this.urlImage = urlImage;
		this.localImage = localImage;
		this.email = email;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getLocalImage() {
		return localImage;
	}
	public void setLocalImage(String localImage) {
		this.localImage = localImage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", salt=" + salt + ", password=" + password + ", nickName="
				+ nickName + ", userName=" + userName + ", idNumber=" + idNumber + ", gender=" + gender + ", location="
				+ location + ", registTime=" + registTime + ", lastLogin=" + lastLogin + ", status=" + status
				+ ", urlImage=" + urlImage + ", localImage=" + localImage + ", email=" + email + ", type=" + type + "]";
	}
}
