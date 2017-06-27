/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.loadtype.entity.LoanType;

/**
 * 贷后报告客户融资情况--itemEntity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class ReportFinanceDetail extends DataEntity<ReportFinanceDetail> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	//private String reportFinanceId;		// report_finance_id
	private LoanType creditType;		// 信贷品种
	private String contractAmount;		// 合同金额
	private String currentBalance;		// 当期余额
	private String refundStartTime;		// 贷款起日期
	private String refundEndTime;		// 贷款止日期
	private String guaranteeMeasures;		// 担保措施
	
	public ReportFinanceDetail() {
		super();
	}

	public ReportFinanceDetail(String id){
		super(id);
	}

	
	
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}

	
	
	public LoanType getCreditType() {
		return creditType;
	}

	public void setCreditType(LoanType creditType) {
		this.creditType = creditType;
	}

	public String getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}
	
	@Length(min=0, max=100, message="当期余额长度必须介于 0 和 100 之间")
	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	@Length(min=0, max=100, message="贷款起日期长度必须介于 0 和 100 之间")
	public String getRefundStartTime() {
		return refundStartTime;
	}

	public void setRefundStartTime(String refundStartTime) {
		this.refundStartTime = refundStartTime;
	}
	
	@Length(min=0, max=100, message="贷款止日期长度必须介于 0 和 100 之间")
	public String getRefundEndTime() {
		return refundEndTime;
	}

	public void setRefundEndTime(String refundEndTime) {
		this.refundEndTime = refundEndTime;
	}
	
	@Length(min=0, max=100, message="担保措施长度必须介于 0 和 100 之间")
	public String getGuaranteeMeasures() {
		return guaranteeMeasures;
	}

	public void setGuaranteeMeasures(String guaranteeMeasures) {
		this.guaranteeMeasures = guaranteeMeasures;
	}
	
}