/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 贷后报告客户品质Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class ReportCumtomerQuality extends DataEntity<ReportCumtomerQuality> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	private String communicationState;		// 与客户沟通渠道是否正常
	private String communicationRemark;		// 与客户沟通渠道备注
	private String badEvaluate;		// 客户的供货商或其他客户对授信客户产生负面评价
	private String badEvaluateRemark;		// 负面评价备注
	private String loadState;		// 是否在几个银行借款或不断在这些银行之间借新还旧
	private String loadStateRemark;		// 银行借款或不断在这些银行之间借新还旧备注
	private String customerInfoState;		// 客户是否及时提供真实的财务、税收或抵押担保信息
	private String customerInfoStateRemark;		// 客户及时提供真实的财务、税收或抵押担保信息备注
	private String repaymentState;		// 还款意愿
	private String repaymentRemark;		// 还款意愿备注
	private String cumtomerQualityImgs;		// cumtomer_quality_imgs
	private String reportCumtomerQualityOther;
	
	public String getReportCumtomerQualityOther() {
		return reportCumtomerQualityOther;
	}

	public void setReportCumtomerQualityOther(String reportCumtomerQualityOther) {
		this.reportCumtomerQualityOther = reportCumtomerQualityOther;
	}

	public ReportCumtomerQuality() {
		super();
	}

	public ReportCumtomerQuality(String id){
		super(id);
	}

	@Length(min=0, max=64, message="贷后报告id长度必须介于 0 和 64 之间")
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}
	
	@Length(min=0, max=1, message="与客户沟通渠道是否正常长度必须介于 0 和 1 之间")
	public String getCommunicationState() {
		return communicationState;
	}

	public void setCommunicationState(String communicationState) {
		this.communicationState = communicationState;
	}
	
	@Length(min=0, max=2048, message="与客户沟通渠道备注长度必须介于 0 和 2048 之间")
	public String getCommunicationRemark() {
		return communicationRemark;
	}

	public void setCommunicationRemark(String communicationRemark) {
		this.communicationRemark = communicationRemark;
	}
	
	@Length(min=0, max=1, message="客户的供货商或其他客户对授信客户产生负面评价长度必须介于 0 和 1 之间")
	public String getBadEvaluate() {
		return badEvaluate;
	}

	public void setBadEvaluate(String badEvaluate) {
		this.badEvaluate = badEvaluate;
	}
	
	@Length(min=0, max=2048, message="负面评价备注长度必须介于 0 和 2048 之间")
	public String getBadEvaluateRemark() {
		return badEvaluateRemark;
	}

	public void setBadEvaluateRemark(String badEvaluateRemark) {
		this.badEvaluateRemark = badEvaluateRemark;
	}
	
	@Length(min=0, max=1, message="是否在几个银行借款或不断在这些银行之间借新还旧长度必须介于 0 和 1 之间")
	public String getLoadState() {
		return loadState;
	}

	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}
	
	@Length(min=0, max=2048, message="银行借款或不断在这些银行之间借新还旧备注长度必须介于 0 和 2048 之间")
	public String getLoadStateRemark() {
		return loadStateRemark;
	}

	public void setLoadStateRemark(String loadStateRemark) {
		this.loadStateRemark = loadStateRemark;
	}
	
	@Length(min=0, max=1, message="客户是否及时提供真实的财务、税收或抵押担保信息长度必须介于 0 和 1 之间")
	public String getCustomerInfoState() {
		return customerInfoState;
	}

	public void setCustomerInfoState(String customerInfoState) {
		this.customerInfoState = customerInfoState;
	}
	
	@Length(min=0, max=2048, message="客户及时提供真实的财务、税收或抵押担保信息备注长度必须介于 0 和 2048 之间")
	public String getCustomerInfoStateRemark() {
		return customerInfoStateRemark;
	}

	public void setCustomerInfoStateRemark(String customerInfoStateRemark) {
		this.customerInfoStateRemark = customerInfoStateRemark;
	}
	
	@Length(min=0, max=1, message="还款意愿长度必须介于 0 和 1 之间")
	public String getRepaymentState() {
		return repaymentState;
	}

	public void setRepaymentState(String repaymentState) {
		this.repaymentState = repaymentState;
	}
	
	@Length(min=0, max=2048, message="还款意愿备注长度必须介于 0 和 2048 之间")
	public String getRepaymentRemark() {
		return repaymentRemark;
	}

	public void setRepaymentRemark(String repaymentRemark) {
		this.repaymentRemark = repaymentRemark;
	}
	
	@Length(min=0, max=2048, message="cumtomer_quality_imgs长度必须介于 0 和 2048 之间")
	public String getCumtomerQualityImgs() {
		return cumtomerQualityImgs;
	}

	public void setCumtomerQualityImgs(String cumtomerQualityImgs) {
		this.cumtomerQualityImgs = cumtomerQualityImgs;
	}
	
}