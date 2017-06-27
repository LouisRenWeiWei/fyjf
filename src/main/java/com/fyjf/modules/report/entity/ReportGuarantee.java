/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 贷后报告担保基本情况Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class ReportGuarantee extends DataEntity<ReportGuarantee> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	private String guaranteeType;		// 担保方式
	private String guaranteeOther;		// 担保方式--其他
	private String collateralType;		// 抵（质）押品种类
	private String collateralPerson;		// 抵（质）押人名称
	private String guaranteeState;		// 抵（质）押品状态
	
	private String collateralValue;		// 抵质押品价值
	private String collateralRate;		// 抵质押率
	private String collateralCurrentValue;		// 抵（质）押品目前价值
	private String guaranteeRemark;		// 担保情况 备注
	private String guaranteeImgs;		// 上传的照片，以，分割存储
	private String reportGuaranteeOther;
	
	public String getReportGuaranteeOther() {
		return reportGuaranteeOther;
	}

	public void setReportGuaranteeOther(String reportGuaranteeOther) {
		this.reportGuaranteeOther = reportGuaranteeOther;
	}

	public ReportGuarantee() {
		super();
	}

	public ReportGuarantee(String id){
		super(id);
	}

	@Length(min=0, max=64, message="贷后报告id长度必须介于 0 和 64 之间")
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}
	
	@Length(min=0, max=1, message="担保方式长度必须介于 0 和 1 之间")
	public String getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	
	@Length(min=0, max=512, message="担保方式--其他长度必须介于 0 和 512 之间")
	public String getGuaranteeOther() {
		return guaranteeOther;
	}

	public void setGuaranteeOther(String guaranteeOther) {
		this.guaranteeOther = guaranteeOther;
	}
	
	@Length(min=0, max=512, message="抵（质）押品种类长度必须介于 0 和 512 之间")
	public String getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}
	
	@Length(min=0, max=512, message="抵（质）押人名称长度必须介于 0 和 512 之间")
	public String getCollateralPerson() {
		return collateralPerson;
	}

	public void setCollateralPerson(String collateralPerson) {
		this.collateralPerson = collateralPerson;
	}
	
	@Length(min=0, max=1, message="抵（质）押品状态长度必须介于 0 和 1 之间")
	public String getGuaranteeState() {
		return guaranteeState;
	}

	public void setGuaranteeState(String guaranteeState) {
		this.guaranteeState = guaranteeState;
	}
	
	public String getCollateralValue() {
		return collateralValue;
	}

	public void setCollateralValue(String collateralValue) {
		this.collateralValue = collateralValue;
	}
	
	public String getCollateralRate() {
		return collateralRate;
	}

	public void setCollateralRate(String collateralRate) {
		this.collateralRate = collateralRate;
	}
	
	public String getCollateralCurrentValue() {
		return collateralCurrentValue;
	}

	public void setCollateralCurrentValue(String collateralCurrentValue) {
		this.collateralCurrentValue = collateralCurrentValue;
	}
	
	@Length(min=0, max=2048, message="担保情况 备注长度必须介于 0 和 2048 之间")
	public String getGuaranteeRemark() {
		return guaranteeRemark;
	}

	public void setGuaranteeRemark(String guaranteeRemark) {
		this.guaranteeRemark = guaranteeRemark;
	}
	
	@Length(min=0, max=2048, message="上传的照片，以，分割存储长度必须介于 0 和 2048 之间")
	public String getGuaranteeImgs() {
		return guaranteeImgs;
	}

	public void setGuaranteeImgs(String guaranteeImgs) {
		this.guaranteeImgs = guaranteeImgs;
	}
	
}