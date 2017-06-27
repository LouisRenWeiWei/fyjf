/**
 * Copyright &copy; 
 */
package com.fyjf.modules.office.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fyjf.common.persistence.TreeEntity;
import com.fyjf.modules.company.entity.Company;

/**
 * 组织结构Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class Office extends TreeEntity<Office> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Office parent;		// parent_id
	private String parentIds;		// parent_ids
	private Company company;		// company_id
	
	public Office() {
		super();
	}

	public Office(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonBackReference
	public Office getParent() {
		return parent;
	}

	public void setParent(Office parent) {
		this.parent = parent;
	}
	
	@Length(min=0, max=255, message="parent_ids长度必须介于 0 和 255 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}