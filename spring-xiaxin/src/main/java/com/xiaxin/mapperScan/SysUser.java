package com.xiaxin.mapperScan;

/**
 * @author cxq
 * @date 2020/9/10 17:43
 * @description
 */
public class SysUser {
	private Integer id;
	private String userName;
	private String password;

	@Override
	public String toString() {
		return "SysUser{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
