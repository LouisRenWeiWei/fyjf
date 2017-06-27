/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 贷后报告客户融资情况Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class ReportFinance extends DataEntity<ReportFinance> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	private String financePurpose;		// 融资批准用途
	private String financePurposeActual;		// 融资实际用途
	private String usedByAllowed;		// 是否按规定用途使用
	private String moneyInPlace;		// 客户配套资金是否到位
	private String repaymentState;		// 还款记录是否正常
	private String aplayDeferred;		// 是否不断申请延期支付或申请实施新的授信
	private String debtState;		// 短期债务是否超常增加
	private String repaymentStateRemark;		// repayment_state_remark
	private String otherFinaceCreditAmount;		// 其他金融机构授信金额
	private String otherFinaceLoan;		// 贷款
	private String otherFinaceOtherAmount;		// 其他信贷品种及金额
	private String loanHasBadRecordState;		// 有无不良贷款或不良记录
	private String loanHasBadRecordAmount;		// 不良贷款或不良记录金额
	private String outerGuaranteeLoanAmount;		// 对外担保总额
	private String outerGuaranteeLoan;		// 对外担保总额中保证担保
	private String outerGuaranteeLoanMortgage;		// 对外担保总额中抵质押担保
	private String financeImgs;		// finance_imgs
	private String reportFinanceOther;		// reportFinanceOther
	
	public ReportFinance() {
		super();
	}

	public ReportFinance(String id){
		super(id);
	}

	@Length(min=0, max=64, message="贷后报告id长度必须介于 0 和 64 之间")
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}
	
	@Length(min=0, max=100, message="融资批准用途长度必须介于 0 和 100 之间")
	public String getFinancePurpose() {
		return financePurpose;
	}

	public void setFinancePurpose(String financePurpose) {
		this.financePurpose = financePurpose;
	}
	
	@Length(min=0, max=100, message="融资实际用途长度必须介于 0 和 100 之间")
	public String getFinancePurposeActual() {
		return financePurposeActual;
	}

	public void setFinancePurposeActual(String financePurposeActual) {
		this.financePurposeActual = financePurposeActual;
	}
	
	@Length(min=0, max=1, message="是否按规定用途使用长度必须介于 0 和 1 之间")
	public String getUsedByAllowed() {
		return usedByAllowed;
	}

	public void setUsedByAllowed(String usedByAllowed) {
		this.usedByAllowed = usedByAllowed;
	}
	
	@Length(min=0, max=1, message="客户配套资金是否到位长度必须介于 0 和 1 之间")
	public String getMoneyInPlace() {
		return moneyInPlace;
	}

	public void setMoneyInPlace(String moneyInPlace) {
		this.moneyInPlace = moneyInPlace;
	}
	
	@Length(min=0, max=1, message="还款记录是否正常长度必须介于 0 和 1 之间")
	public String getRepaymentState() {
		return repaymentState;
	}

	public void setRepaymentState(String repaymentState) {
		this.repaymentState = repaymentState;
	}
	
	@Length(min=0, max=1, message="是否不断申请延期支付或申请实施新的授信长度必须介于 0 和 1 之间")
	public String getAplayDeferred() {
		return aplayDeferred;
	}

	public void setAplayDeferred(String aplayDeferred) {
		this.aplayDeferred = aplayDeferred;
	}
	
	@Length(min=0, max=1, message="短期债务是否超常增加长度必须介于 0 和 1 之间")
	public String getDebtState() {
		return debtState;
	}

	public void setDebtState(String debtState) {
		this.debtState = debtState;
	}
	
	@Length(min=0, max=2048, message="repayment_state_remark长度必须介于 0 和 2048 之间")
	public String getRepaymentStateRemark() {
		return repaymentStateRemark;
	}

	public void setRepaymentStateRemark(String repaymentStateRemark) {
		this.repaymentStateRemark = repaymentStateRemark;
	}
	
	public String getOtherFinaceCreditAmount() {
		return otherFinaceCreditAmount;
	}

	public void setOtherFinaceCreditAmount(String otherFinaceCreditAmount) {
		this.otherFinaceCreditAmount = otherFinaceCreditAmount;
	}
	
	public String getOtherFinaceLoan() {
		return otherFinaceLoan;
	}

	public void setOtherFinaceLoan(String otherFinaceLoan) {
		this.otherFinaceLoan = otherFinaceLoan;
	}
	
	public String getOtherFinaceOtherAmount() {
		return otherFinaceOtherAmount;
	}

	public void setOtherFinaceOtherAmount(String otherFinaceOtherAmount) {
		this.otherFinaceOtherAmount = otherFinaceOtherAmount;
	}
	
	@Length(min=0, max=1, message="有无不良贷款或不良记录长度必须介于 0 和 1 之间")
	public String getLoanHasBadRecordState() {
		return loanHasBadRecordState;
	}

	public void setLoanHasBadRecordState(String loanHasBadRecordState) {
		this.loanHasBadRecordState = loanHasBadRecordState;
	}
	
	public String getLoanHasBadRecordAmount() {
		return loanHasBadRecordAmount;
	}

	public void setLoanHasBadRecordAmount(String loanHasBadRecordAmount) {
		this.loanHasBadRecordAmount = loanHasBadRecordAmount;
	}
	
	public String getOuterGuaranteeLoanAmount() {
		return outerGuaranteeLoanAmount;
	}

	public void setOuterGuaranteeLoanAmount(String outerGuaranteeLoanAmount) {
		this.outerGuaranteeLoanAmount = outerGuaranteeLoanAmount;
	}
	
	public String getOuterGuaranteeLoan() {
		return outerGuaranteeLoan;
	}

	public void setOuterGuaranteeLoan(String outerGuaranteeLoan) {
		this.outerGuaranteeLoan = outerGuaranteeLoan;
	}
	
	public String getOuterGuaranteeLoanMortgage() {
		return outerGuaranteeLoanMortgage;
	}

	public void setOuterGuaranteeLoanMortgage(String outerGuaranteeLoanMortgage) {
		this.outerGuaranteeLoanMortgage = outerGuaranteeLoanMortgage;
	}
	
	@Length(min=0, max=2048, message="finance_imgs长度必须介于 0 和 2048 之间")
	public String getFinanceImgs() {
		return financeImgs;
	}

	public void setFinanceImgs(String financeImgs) {
		this.financeImgs = financeImgs;
	}

	public String getReportFinanceOther() {
		return reportFinanceOther;
	}

	public void setReportFinanceOther(String reportFinanceOther) {
		this.reportFinanceOther = reportFinanceOther;
	}
	
	
	
}