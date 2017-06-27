/**
 * Copyright &copy; 
 */
package com.fyjf.modules.loadtype.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.TreeEntity;

/**
 * 信贷品种类型Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-18
 */
public class LoanType extends TreeEntity<LoanType> {
	
	private static final long serialVersionUID = 1L;
	private LoanType parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	private String code;		// 代码
	private String sort;		// 排序
	private String description;		// 描述
	
	public LoanType() {
		super();
	}

	public LoanType(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public LoanType getParent() {
		return parent;
	}

	public void setParent(LoanType parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="代码长度必须介于 0 和 255 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	@Length(min=0, max=100, message="描述长度必须介于 0 和 100 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}