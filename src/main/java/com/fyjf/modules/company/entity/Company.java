/**
 * Copyright &copy; 
 */
package com.fyjf.modules.company.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 企业Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class Company extends DataEntity<Company> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String corpid;		// corpid
	private String corpsecrect;		// corpsecrect
	private String socialCredit;
	private String areaId;
	
	
	public Company() {
		super();
	}

	public Company(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="corpid长度必须介于 0 和 255 之间")
	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	
	@Length(min=0, max=255, message="corpsecrect长度必须介于 0 和 255 之间")
	public String getCorpsecrect() {
		return corpsecrect;
	}

	public void setCorpsecrect(String corpsecrect) {
		this.corpsecrect = corpsecrect;
	}

	

	public String getSocialCredit() {
		return socialCredit;
	}

	public void setSocialCredit(String socialCredit) {
		this.socialCredit = socialCredit;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	
	
}