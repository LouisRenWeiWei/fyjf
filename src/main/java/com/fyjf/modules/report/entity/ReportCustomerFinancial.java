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
public class ReportCustomerFinancial extends DataEntity<ReportCustomerFinancial> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	
	private String customerAccountInBank;		// 本行结算账户账号
	private String moneyDuringCheck;		// 检查期间现金流入
	private String customerMoneyChangeState;		// 是否有异常变动情况
	private String customerMoneyReturnState;		// 是否达到归行比率
	private String customerAccountRemark;		// 备注
	
	private String customerFinanceType;		// 财务资料类型
	
	private String customerFinaceIncDecSaleCur;		// 损益情况 销售收入
	private String customerFinaceIncDecSalePre;		// 损益情况 销售收入
	private String customerFinaceIncDecProfitCur;		// 损益情况 利润总额
	private String customerFinaceIncDecProfitPre;		// 损益情况  利润总额
	
	private String customerFinaceIncDecConsumCur;		// 损益情况 主要能耗
	private String customerFinaceIncDecConsumPre;		// 损益情况  主要能耗
	private String customerFinaceAssetsAccountNeedCur;		// 资产情况  应收账款
	private String customerFinaceAssetsAccountNeedPre;		// 资产情况  应收账款
	
	private String customerFinaceAssetsInventoryCur;		// 资产情况 存货
	private String customerFinaceAssetsInventoryPre;		// 资产情况  存货
	private String customerFinaceDebtAccountNeedCur;		// 负债情况 应付账款
	private String customerFinaceDebtAccountNeedPre;		// 负债情况  应付账款
	
	private String customerFinaceDebtBorrowingCur;		// 负债情况 银行借款
	private String customerFinaceDebtBorrowingPre;		// 负债情况 银行借款
	private String customerFinaceDebtGuarantyCur;		// 负债情况  对外担保
	private String customerFinaceDebtGuarantyPre;		// 负债情况  对外担保
	
	private String customerFinaceRatioAssetsLiabilitiesCur;		// 比率情况 资产负债率
	private String customerFinaceRatioAssetsLiabilitiesPre;		// 比率情况  资产负债率
	private String customerFinaceRatioCurrentRatioCur;		// 比率情况 流动比率
	private String customerFinaceRatioCurrentRatioPre;		// 比率情况 流动比率
	
	private String customerFinaceRatioAccountTurnroundRateCur;		// 比率情况 应收帐款周转率
	private String customerFinaceRatioAccountTurnroundRatePre;		// 比率情况 应收帐款周转率
	private String customerFinaceRatioSaleProfitCur;		// 比率情况 销售利润率
	private String customerFinaceRatioSaleProfitPre;		// 比率情况 销售利润率
	
	private String customerFinaceRatioInventoryCur;		// 比率情况 存货周转率
	private String customerFinaceRatioInventoryPre;		// 比率情况 存货周转率
	
	private String customerFinaceForecastSale;		// 合同到期前财务状况预测  销售收入变化趋势
	private String customerFinaceForecastProfit;		// 合同到期前财务状况预测  利润变动趋势	
	private String customerFinaceForecastCash;		// 合同到期前财务状况预测  现金流量变动趋势
	private String customerFinaceForecastBusinessCash;		// 合同到期前财务状况预测  经营活动现金流量变动趋势
	private String customerFinaceForecastRemark;		// 合同到期前财务状况预测 备注
	
	private String customerEffectFinanceWaring;		// 影响贷款偿还的因素分析  财务风险预警信号	
	private String customerEffectPayMoney;		// 影响贷款偿还的因素分析  还本金能力
	private String customerEffectPayMoneyAmount;		// 影响贷款偿还的因素分析  预计还款金额
	private String customerEffectPayProfit;		// 影响贷款偿还的因素分析  还息能力
	private String customerEffectPayProfitRemark;		// customer_effect_pay_profit_remark
	private String customerFinancialImgs;		// customer_financial_imgs
	
	private String reportCustomerFinancialOther;
	
	public String getReportCustomerFinancialOther() {
		return reportCustomerFinancialOther;
	}

	public void setReportCustomerFinancialOther(String reportCustomerFinancialOther) {
		this.reportCustomerFinancialOther = reportCustomerFinancialOther;
	}

	public ReportCustomerFinancial() {
		super();
	}

	public ReportCustomerFinancial(String id){
		super(id);
	}

	@Length(min=0, max=64, message="贷后报告id长度必须介于 0 和 64 之间")
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}
	
	@Length(min=0, max=64, message="本行结算账户账号长度必须介于 0 和 64 之间")
	public String getCustomerAccountInBank() {
		return customerAccountInBank;
	}

	public void setCustomerAccountInBank(String customerAccountInBank) {
		this.customerAccountInBank = customerAccountInBank;
	}
	
	@Length(min=0, max=64, message="检查期间现金流入长度必须介于 0 和 64 之间")
	public String getMoneyDuringCheck() {
		return moneyDuringCheck;
	}

	public void setMoneyDuringCheck(String moneyDuringCheck) {
		this.moneyDuringCheck = moneyDuringCheck;
	}
	
	@Length(min=0, max=1, message="是否有异常变动情况长度必须介于 0 和 1 之间")
	public String getCustomerMoneyChangeState() {
		return customerMoneyChangeState;
	}

	public void setCustomerMoneyChangeState(String customerMoneyChangeState) {
		this.customerMoneyChangeState = customerMoneyChangeState;
	}
	
	@Length(min=0, max=1, message="是否达到归行比率长度必须介于 0 和 1 之间")
	public String getCustomerMoneyReturnState() {
		return customerMoneyReturnState;
	}

	public void setCustomerMoneyReturnState(String customerMoneyReturnState) {
		this.customerMoneyReturnState = customerMoneyReturnState;
	}
	
	@Length(min=0, max=2048, message="备注长度必须介于 0 和 2048 之间")
	public String getCustomerAccountRemark() {
		return customerAccountRemark;
	}

	public void setCustomerAccountRemark(String customerAccountRemark) {
		this.customerAccountRemark = customerAccountRemark;
	}
	
	@Length(min=0, max=1, message="财务资料类型长度必须介于 0 和 1 之间")
	public String getCustomerFinanceType() {
		return customerFinanceType;
	}

	public void setCustomerFinanceType(String customerFinanceType) {
		this.customerFinanceType = customerFinanceType;
	}
	
	@Length(min=0, max=32, message="损益情况 销售收入长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecSaleCur() {
		return customerFinaceIncDecSaleCur;
	}

	public void setCustomerFinaceIncDecSaleCur(String customerFinaceIncDecSaleCur) {
		this.customerFinaceIncDecSaleCur = customerFinaceIncDecSaleCur;
	}
	
	@Length(min=0, max=32, message="损益情况 销售收入长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecSalePre() {
		return customerFinaceIncDecSalePre;
	}

	public void setCustomerFinaceIncDecSalePre(String customerFinaceIncDecSalePre) {
		this.customerFinaceIncDecSalePre = customerFinaceIncDecSalePre;
	}
	
	@Length(min=0, max=32, message="损益情况 利润总额长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecProfitCur() {
		return customerFinaceIncDecProfitCur;
	}

	public void setCustomerFinaceIncDecProfitCur(String customerFinaceIncDecProfitCur) {
		this.customerFinaceIncDecProfitCur = customerFinaceIncDecProfitCur;
	}
	
	@Length(min=0, max=32, message="损益情况  利润总额长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecProfitPre() {
		return customerFinaceIncDecProfitPre;
	}

	public void setCustomerFinaceIncDecProfitPre(String customerFinaceIncDecProfitPre) {
		this.customerFinaceIncDecProfitPre = customerFinaceIncDecProfitPre;
	}
	
	@Length(min=0, max=32, message="损益情况 主要能耗长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecConsumCur() {
		return customerFinaceIncDecConsumCur;
	}

	public void setCustomerFinaceIncDecConsumCur(String customerFinaceIncDecConsumCur) {
		this.customerFinaceIncDecConsumCur = customerFinaceIncDecConsumCur;
	}
	
	@Length(min=0, max=32, message="损益情况  主要能耗长度必须介于 0 和 32 之间")
	public String getCustomerFinaceIncDecConsumPre() {
		return customerFinaceIncDecConsumPre;
	}

	public void setCustomerFinaceIncDecConsumPre(String customerFinaceIncDecConsumPre) {
		this.customerFinaceIncDecConsumPre = customerFinaceIncDecConsumPre;
	}
	
	@Length(min=0, max=32, message="资产情况  应收账款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceAssetsAccountNeedCur() {
		return customerFinaceAssetsAccountNeedCur;
	}

	public void setCustomerFinaceAssetsAccountNeedCur(String customerFinaceAssetsAccountNeedCur) {
		this.customerFinaceAssetsAccountNeedCur = customerFinaceAssetsAccountNeedCur;
	}
	
	@Length(min=0, max=32, message="资产情况  应收账款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceAssetsAccountNeedPre() {
		return customerFinaceAssetsAccountNeedPre;
	}

	public void setCustomerFinaceAssetsAccountNeedPre(String customerFinaceAssetsAccountNeedPre) {
		this.customerFinaceAssetsAccountNeedPre = customerFinaceAssetsAccountNeedPre;
	}
	
	@Length(min=0, max=32, message="资产情况 存货长度必须介于 0 和 32 之间")
	public String getCustomerFinaceAssetsInventoryCur() {
		return customerFinaceAssetsInventoryCur;
	}

	public void setCustomerFinaceAssetsInventoryCur(String customerFinaceAssetsInventoryCur) {
		this.customerFinaceAssetsInventoryCur = customerFinaceAssetsInventoryCur;
	}
	
	@Length(min=0, max=32, message="资产情况  存货长度必须介于 0 和 32 之间")
	public String getCustomerFinaceAssetsInventoryPre() {
		return customerFinaceAssetsInventoryPre;
	}

	public void setCustomerFinaceAssetsInventoryPre(String customerFinaceAssetsInventoryPre) {
		this.customerFinaceAssetsInventoryPre = customerFinaceAssetsInventoryPre;
	}
	
	@Length(min=0, max=32, message="负债情况 应付账款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtAccountNeedCur() {
		return customerFinaceDebtAccountNeedCur;
	}

	public void setCustomerFinaceDebtAccountNeedCur(String customerFinaceDebtAccountNeedCur) {
		this.customerFinaceDebtAccountNeedCur = customerFinaceDebtAccountNeedCur;
	}
	
	@Length(min=0, max=32, message="负债情况  应付账款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtAccountNeedPre() {
		return customerFinaceDebtAccountNeedPre;
	}

	public void setCustomerFinaceDebtAccountNeedPre(String customerFinaceDebtAccountNeedPre) {
		this.customerFinaceDebtAccountNeedPre = customerFinaceDebtAccountNeedPre;
	}
	
	@Length(min=0, max=32, message="负债情况 银行借款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtBorrowingCur() {
		return customerFinaceDebtBorrowingCur;
	}

	public void setCustomerFinaceDebtBorrowingCur(String customerFinaceDebtBorrowingCur) {
		this.customerFinaceDebtBorrowingCur = customerFinaceDebtBorrowingCur;
	}
	
	@Length(min=0, max=32, message="负债情况 银行借款长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtBorrowingPre() {
		return customerFinaceDebtBorrowingPre;
	}

	public void setCustomerFinaceDebtBorrowingPre(String customerFinaceDebtBorrowingPre) {
		this.customerFinaceDebtBorrowingPre = customerFinaceDebtBorrowingPre;
	}
	
	@Length(min=0, max=32, message="负债情况  对外担保长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtGuarantyCur() {
		return customerFinaceDebtGuarantyCur;
	}

	public void setCustomerFinaceDebtGuarantyCur(String customerFinaceDebtGuarantyCur) {
		this.customerFinaceDebtGuarantyCur = customerFinaceDebtGuarantyCur;
	}
	
	@Length(min=0, max=32, message="负债情况  对外担保长度必须介于 0 和 32 之间")
	public String getCustomerFinaceDebtGuarantyPre() {
		return customerFinaceDebtGuarantyPre;
	}

	public void setCustomerFinaceDebtGuarantyPre(String customerFinaceDebtGuarantyPre) {
		this.customerFinaceDebtGuarantyPre = customerFinaceDebtGuarantyPre;
	}
	
	@Length(min=0, max=32, message="比率情况 资产负债率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioAssetsLiabilitiesCur() {
		return customerFinaceRatioAssetsLiabilitiesCur;
	}

	public void setCustomerFinaceRatioAssetsLiabilitiesCur(String customerFinaceRatioAssetsLiabilitiesCur) {
		this.customerFinaceRatioAssetsLiabilitiesCur = customerFinaceRatioAssetsLiabilitiesCur;
	}
	
	@Length(min=0, max=32, message="比率情况  资产负债率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioAssetsLiabilitiesPre() {
		return customerFinaceRatioAssetsLiabilitiesPre;
	}

	public void setCustomerFinaceRatioAssetsLiabilitiesPre(String customerFinaceRatioAssetsLiabilitiesPre) {
		this.customerFinaceRatioAssetsLiabilitiesPre = customerFinaceRatioAssetsLiabilitiesPre;
	}
	
	@Length(min=0, max=32, message="比率情况 流动比率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioCurrentRatioCur() {
		return customerFinaceRatioCurrentRatioCur;
	}

	public void setCustomerFinaceRatioCurrentRatioCur(String customerFinaceRatioCurrentRatioCur) {
		this.customerFinaceRatioCurrentRatioCur = customerFinaceRatioCurrentRatioCur;
	}
	
	@Length(min=0, max=32, message="比率情况 流动比率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioCurrentRatioPre() {
		return customerFinaceRatioCurrentRatioPre;
	}

	public void setCustomerFinaceRatioCurrentRatioPre(String customerFinaceRatioCurrentRatioPre) {
		this.customerFinaceRatioCurrentRatioPre = customerFinaceRatioCurrentRatioPre;
	}
	
	@Length(min=0, max=32, message="比率情况 应收帐款周转率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioAccountTurnroundRateCur() {
		return customerFinaceRatioAccountTurnroundRateCur;
	}

	public void setCustomerFinaceRatioAccountTurnroundRateCur(String customerFinaceRatioAccountTurnroundRateCur) {
		this.customerFinaceRatioAccountTurnroundRateCur = customerFinaceRatioAccountTurnroundRateCur;
	}
	
	@Length(min=0, max=32, message="比率情况 应收帐款周转率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioAccountTurnroundRatePre() {
		return customerFinaceRatioAccountTurnroundRatePre;
	}

	public void setCustomerFinaceRatioAccountTurnroundRatePre(String customerFinaceRatioAccountTurnroundRatePre) {
		this.customerFinaceRatioAccountTurnroundRatePre = customerFinaceRatioAccountTurnroundRatePre;
	}
	
	@Length(min=0, max=32, message="比率情况 销售利润率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioSaleProfitCur() {
		return customerFinaceRatioSaleProfitCur;
	}

	public void setCustomerFinaceRatioSaleProfitCur(String customerFinaceRatioSaleProfitCur) {
		this.customerFinaceRatioSaleProfitCur = customerFinaceRatioSaleProfitCur;
	}
	
	@Length(min=0, max=32, message="比率情况 销售利润率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioSaleProfitPre() {
		return customerFinaceRatioSaleProfitPre;
	}

	public void setCustomerFinaceRatioSaleProfitPre(String customerFinaceRatioSaleProfitPre) {
		this.customerFinaceRatioSaleProfitPre = customerFinaceRatioSaleProfitPre;
	}
	
	@Length(min=0, max=32, message="比率情况 存货周转率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioInventoryCur() {
		return customerFinaceRatioInventoryCur;
	}

	public void setCustomerFinaceRatioInventoryCur(String customerFinaceRatioInventoryCur) {
		this.customerFinaceRatioInventoryCur = customerFinaceRatioInventoryCur;
	}
	
	@Length(min=0, max=32, message="比率情况 存货周转率长度必须介于 0 和 32 之间")
	public String getCustomerFinaceRatioInventoryPre() {
		return customerFinaceRatioInventoryPre;
	}

	public void setCustomerFinaceRatioInventoryPre(String customerFinaceRatioInventoryPre) {
		this.customerFinaceRatioInventoryPre = customerFinaceRatioInventoryPre;
	}
	
	@Length(min=0, max=1, message="合同到期前财务状况预测  销售收入变化趋势长度必须介于 0 和 1 之间")
	public String getCustomerFinaceForecastSale() {
		return customerFinaceForecastSale;
	}

	public void setCustomerFinaceForecastSale(String customerFinaceForecastSale) {
		this.customerFinaceForecastSale = customerFinaceForecastSale;
	}
	
	@Length(min=0, max=1, message="合同到期前财务状况预测  利润变动趋势长度必须介于 0 和 1 之间")
	public String getCustomerFinaceForecastProfit() {
		return customerFinaceForecastProfit;
	}

	public void setCustomerFinaceForecastProfit(String customerFinaceForecastProfit) {
		this.customerFinaceForecastProfit = customerFinaceForecastProfit;
	}
	
	@Length(min=0, max=1, message="合同到期前财务状况预测  现金流量变动趋势长度必须介于 0 和 1 之间")
	public String getCustomerFinaceForecastCash() {
		return customerFinaceForecastCash;
	}

	public void setCustomerFinaceForecastCash(String customerFinaceForecastCash) {
		this.customerFinaceForecastCash = customerFinaceForecastCash;
	}
	
	@Length(min=0, max=1, message="合同到期前财务状况预测  经营活动现金流量变动趋势长度必须介于 0 和 1 之间")
	public String getCustomerFinaceForecastBusinessCash() {
		return customerFinaceForecastBusinessCash;
	}

	public void setCustomerFinaceForecastBusinessCash(String customerFinaceForecastBusinessCash) {
		this.customerFinaceForecastBusinessCash = customerFinaceForecastBusinessCash;
	}
	
	@Length(min=0, max=2048, message="合同到期前财务状况预测 备注长度必须介于 0 和 2048 之间")
	public String getCustomerFinaceForecastRemark() {
		return customerFinaceForecastRemark;
	}

	public void setCustomerFinaceForecastRemark(String customerFinaceForecastRemark) {
		this.customerFinaceForecastRemark = customerFinaceForecastRemark;
	}
	
	@Length(min=0, max=1, message="影响贷款偿还的因素分析  财务风险预警信号长度必须介于 0 和 1 之间")
	public String getCustomerEffectFinanceWaring() {
		return customerEffectFinanceWaring;
	}

	public void setCustomerEffectFinanceWaring(String customerEffectFinanceWaring) {
		this.customerEffectFinanceWaring = customerEffectFinanceWaring;
	}
	
	@Length(min=0, max=1, message="影响贷款偿还的因素分析  还本金能力长度必须介于 0 和 1 之间")
	public String getCustomerEffectPayMoney() {
		return customerEffectPayMoney;
	}

	public void setCustomerEffectPayMoney(String customerEffectPayMoney) {
		this.customerEffectPayMoney = customerEffectPayMoney;
	}
	
	public String getCustomerEffectPayMoneyAmount() {
		return customerEffectPayMoneyAmount;
	}

	public void setCustomerEffectPayMoneyAmount(String customerEffectPayMoneyAmount) {
		this.customerEffectPayMoneyAmount = customerEffectPayMoneyAmount;
	}
	
	@Length(min=0, max=1, message="影响贷款偿还的因素分析  还息能力长度必须介于 0 和 1 之间")
	public String getCustomerEffectPayProfit() {
		return customerEffectPayProfit;
	}

	public void setCustomerEffectPayProfit(String customerEffectPayProfit) {
		this.customerEffectPayProfit = customerEffectPayProfit;
	}
	
	@Length(min=0, max=2048, message="customer_effect_pay_profit_remark长度必须介于 0 和 2048 之间")
	public String getCustomerEffectPayProfitRemark() {
		return customerEffectPayProfitRemark;
	}

	public void setCustomerEffectPayProfitRemark(String customerEffectPayProfitRemark) {
		this.customerEffectPayProfitRemark = customerEffectPayProfitRemark;
	}
	
	@Length(min=0, max=2048, message="customer_financial_imgs长度必须介于 0 和 2048 之间")
	public String getCustomerFinancialImgs() {
		return customerFinancialImgs;
	}

	public void setCustomerFinancialImgs(String customerFinancialImgs) {
		this.customerFinancialImgs = customerFinancialImgs;
	}
	
}