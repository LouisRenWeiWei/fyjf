/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.TreeEntity;

/**
 * 区域级别Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class AreaLevel extends TreeEntity<AreaLevel> {
	
	private static final long serialVersionUID = 1L;
	private AreaLevel parent;		// parent_id
	private String name;		// name
	private String level;		// level
	
	public AreaLevel() {
		super();
	}

	public AreaLevel(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="parent_id不能为空")
	public AreaLevel getParent() {
		return parent;
	}

	public void setParent(AreaLevel parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=16, message="name长度必须介于 1 和 16 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=4, message="level长度必须介于 1 和 4 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}