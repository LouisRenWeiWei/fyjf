/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.role.entity.Role;

/**
 * 用户Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class User extends DataEntity<User> {
	
	private static final long serialVersionUID = 1L;
	private String account;		// account
	private String passwd;		// passwd
	private String name;		// name
	private String telphone;		// telphone
	
	private Office office;
	private Company company;
	
	private Role role;
	
	public User() {
		super();
	}

	public User(String id){
		super(id);
	}

	@Length(min=0, max=255, message="account长度必须介于 0 和 255 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=0, max=255, message="passwd长度必须介于 0 和 255 之间")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="telphone长度必须介于 0 和 255 之间")
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
}