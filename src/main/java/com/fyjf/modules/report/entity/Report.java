/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.user.entity.User;

/**
 * 贷后报告Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class Report extends DataEntity<Report> {
	
	private static final long serialVersionUID = 1L;
	private String customerId;		// customer_id
	private String year;		// 年度
	private String reportNo;		// 年度第几次检查
	private String reportCount;		// 年度总共多少次检查
	private User examiner;		// 检查人
	private String examinTime;		// 检查日期
	private String riskWarning;		// 是否发起风险预警
	private String riskWarningReason;		// 风险预警原因
	private String proposedMeasures;		// 建议采取的措施
	private String supervisor;		// 贷后监管员签名
	private String businessDirectorAdvice;		// 业务主管意见
	private String businessDirector;		// 业务主管签名
	private String bankCreditReport;		// 银行信证pdf
	private String socialCreditReport;		// 社会信证pdf
	
	public Report() {
		super();
	}

	public Report(String id){
		super(id);
	}

	@Length(min=0, max=64, message="customer_id长度必须介于 0 和 64 之间")
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	@Length(min=1, max=4, message="年度长度必须介于 1 和 4 之间")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Length(min=0, max=11, message="年度第几次检查长度必须介于 0 和 11 之间")
	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	
	@Length(min=0, max=11, message="年度总共多少次检查长度必须介于 0 和 11 之间")
	public String getReportCount() {
		return reportCount;
	}

	public void setReportCount(String reportCount) {
		this.reportCount = reportCount;
	}
	
	
	
	public User getExaminer() {
		return examiner;
	}

	public void setExaminer(User examiner) {
		this.examiner = examiner;
	}

	@Length(min=0, max=20, message="检查日期长度必须介于 0 和 20 之间")
	public String getExaminTime() {
		return examinTime;
	}

	public void setExaminTime(String examinTime) {
		this.examinTime = examinTime;
	}
	
	@Length(min=0, max=1, message="是否发起风险预警长度必须介于 0 和 1 之间")
	public String getRiskWarning() {
		return riskWarning;
	}

	public void setRiskWarning(String riskWarning) {
		this.riskWarning = riskWarning;
	}
	
	@Length(min=0, max=512, message="风险预警原因长度必须介于 0 和 512 之间")
	public String getRiskWarningReason() {
		return riskWarningReason;
	}

	public void setRiskWarningReason(String riskWarningReason) {
		this.riskWarningReason = riskWarningReason;
	}
	
	@Length(min=0, max=512, message="建议采取的措施长度必须介于 0 和 512 之间")
	public String getProposedMeasures() {
		return proposedMeasures;
	}

	public void setProposedMeasures(String proposedMeasures) {
		this.proposedMeasures = proposedMeasures;
	}
	
	@Length(min=0, max=100, message="贷后监管员签名长度必须介于 0 和 100 之间")
	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	@Length(min=0, max=512, message="业务主管意见长度必须介于 0 和 512 之间")
	public String getBusinessDirectorAdvice() {
		return businessDirectorAdvice;
	}

	public void setBusinessDirectorAdvice(String businessDirectorAdvice) {
		this.businessDirectorAdvice = businessDirectorAdvice;
	}
	
	@Length(min=0, max=100, message="业务主管签名长度必须介于 0 和 100 之间")
	public String getBusinessDirector() {
		return businessDirector;
	}

	public void setBusinessDirector(String businessDirector) {
		this.businessDirector = businessDirector;
	}

	public String getBankCreditReport() {
		return bankCreditReport;
	}

	public void setBankCreditReport(String bankCreditReport) {
		this.bankCreditReport = bankCreditReport;
	}

	public String getSocialCreditReport() {
		return socialCreditReport;
	}

	public void setSocialCreditReport(String socialCreditReport) {
		this.socialCreditReport = socialCreditReport;
	}
	
}