/**
 * Copyright &copy; 
 */
package com.fyjf.modules.overdue.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 逾期报告进度Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
public class OverdueProgress extends DataEntity<OverdueProgress> {
	
	private static final long serialVersionUID = 1L;
	private String overdueId;		// 逾期方案id
	private String title;		// 标题
	private String description;		// 说明
	private String overdueImgs;		// 照片
	
	public OverdueProgress() {
		super();
	}

	public OverdueProgress(String id){
		super(id);
	}

	@Length(min=0, max=128, message="逾期方案id长度必须介于 0 和 128 之间")
	public String getOverdueId() {
		return overdueId;
	}

	public void setOverdueId(String overdueId) {
		this.overdueId = overdueId;
	}
	
	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=2048, message="说明长度必须介于 0 和 2048 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=2048, message="照片长度必须介于 0 和 2048 之间")
	public String getOverdueImgs() {
		return overdueImgs;
	}

	public void setOverdueImgs(String overdueImgs) {
		this.overdueImgs = overdueImgs;
	}
	
}