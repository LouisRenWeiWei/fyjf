/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.TreeEntity;

/**
 * 区域Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class Area extends TreeEntity<Area> {
	
	private static final long serialVersionUID = 1L;
	private Area parent;		// 上级ID
	private String name;		// 名称
	private int level;		// 级别
	private String longitude;		// 经度
	private String latitude;		// 纬度
	
	public Area() {
		super();
	}

	public Area(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="上级ID不能为空")
	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=18, message="名称长度必须介于 1 和 18 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	@Length(min=0, max=16, message="经度长度必须介于 0 和 16 之间")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Length(min=0, max=16, message="纬度长度必须介于 0 和 16 之间")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}