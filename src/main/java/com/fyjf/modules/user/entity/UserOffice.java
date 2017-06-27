/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.entity;


import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.office.entity.Office;

/**
 * 用户组织Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class UserOffice extends DataEntity<UserOffice> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// user_id
	private Office office;		// office_id
	private Company	company;
	
	public UserOffice() {
		super();
	}

	public UserOffice(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}