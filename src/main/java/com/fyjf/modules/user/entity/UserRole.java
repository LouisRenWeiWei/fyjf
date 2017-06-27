/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 用户角色Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class UserRole extends DataEntity<UserRole> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// user_id
	private String roleId;		// role_id
	
	public UserRole() {
		super();
	}

	public UserRole(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=255, message="role_id长度必须介于 0 和 255 之间")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}