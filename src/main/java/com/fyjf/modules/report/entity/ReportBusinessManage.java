/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;

/**
 * 贷后报告客户经营管理情况Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
public class ReportBusinessManage extends DataEntity<ReportBusinessManage> {
	
	private static final long serialVersionUID = 1L;
	private String loanReportId;		// 贷后报告id
	private String mainBusinessChange;		// 主营业务是否发生变化
	private String businessState;		// 生产经营是否正常
	private String enterpriseTrend;		// 企业发展趋势
	private String mainBusinessRemark;		// 主营业务备注
	private String orginaltionChange;		// 管理层是否发生重大变化
	private String orgChangeEffect;		// 管理层重大变化影响情况
	private String orgChangeRemark;		// 管理层重大变化备注
	private String shareholdersChange;		// 主要股东、关联公司与母子公司是否发生重大变化
	private String shareholdersChangeEffect;		// 主要股东、关联公司与母子公司生重大变化影响情况
	private String shareholdersChangeRemark;		// 主要股东、关联公司与母子公司重大变化备注
	private String customerManage;		// 客户内部管理情况
	private String customerManageRemark;		// 客户内部管理情况备注
	private String arbitrationState;		// 是否发生重大诉讼或仲裁、重大事故或重大赔偿
	private String arbitrationStateEffect;		// 是否发生重大诉讼或仲裁、重大事故或重大赔偿影响情况
	private String arbitrationStateRemark;		// 是否发生重大诉讼或仲裁、重大事故或重大赔偿备注
	private String outerManage;		// 外部经营环境是否发生不利经营的重大变化
	private String outerManageMeasures;		// 对竞争变化或外部条件变化是否有应对措施
	private String outerManageRemark;		// 外部经营环境是否发生不利经营的重大变化备注
	private String partnerState;		// 主要合作伙伴是否减少或流失
	private String partnerObtainGoal;		// 期目标实现
	private String partnerStateRemark;		// 主要合作伙伴是否减少或流失备注
	private String badEffectState;		// 是否存在影响该笔贷款偿还的不利因素
	private String badEffectRemark;		// 是否存在影响该笔贷款偿还的不利因素备注
	private String businessManageImgs;		// business_manage_imgs
	private String reportBusinessManageOther;
	
	public ReportBusinessManage() {
		super();
	}

	public ReportBusinessManage(String id){
		super(id);
	}

	@Length(min=0, max=64, message="贷后报告id长度必须介于 0 和 64 之间")
	public String getLoanReportId() {
		return loanReportId;
	}

	public void setLoanReportId(String loanReportId) {
		this.loanReportId = loanReportId;
	}
	
	@Length(min=0, max=1, message="主营业务是否发生变化长度必须介于 0 和 1 之间")
	public String getMainBusinessChange() {
		return mainBusinessChange;
	}

	public void setMainBusinessChange(String mainBusinessChange) {
		this.mainBusinessChange = mainBusinessChange;
	}
	
	@Length(min=0, max=1, message="生产经营是否正常长度必须介于 0 和 1 之间")
	public String getBusinessState() {
		return businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}
	
	@Length(min=0, max=1, message="企业发展趋势长度必须介于 0 和 1 之间")
	public String getEnterpriseTrend() {
		return enterpriseTrend;
	}

	public void setEnterpriseTrend(String enterpriseTrend) {
		this.enterpriseTrend = enterpriseTrend;
	}
	
	@Length(min=0, max=2048, message="主营业务备注长度必须介于 0 和 2048 之间")
	public String getMainBusinessRemark() {
		return mainBusinessRemark;
	}

	public void setMainBusinessRemark(String mainBusinessRemark) {
		this.mainBusinessRemark = mainBusinessRemark;
	}
	
	@Length(min=0, max=1, message="管理层是否发生重大变化长度必须介于 0 和 1 之间")
	public String getOrginaltionChange() {
		return orginaltionChange;
	}

	public void setOrginaltionChange(String orginaltionChange) {
		this.orginaltionChange = orginaltionChange;
	}
	
	@Length(min=0, max=1, message="管理层重大变化影响情况长度必须介于 0 和 1 之间")
	public String getOrgChangeEffect() {
		return orgChangeEffect;
	}

	public void setOrgChangeEffect(String orgChangeEffect) {
		this.orgChangeEffect = orgChangeEffect;
	}
	
	@Length(min=0, max=2048, message="管理层重大变化备注长度必须介于 0 和 2048 之间")
	public String getOrgChangeRemark() {
		return orgChangeRemark;
	}

	public void setOrgChangeRemark(String orgChangeRemark) {
		this.orgChangeRemark = orgChangeRemark;
	}
	
	@Length(min=0, max=1, message="主要股东、关联公司与母子公司是否发生重大变化长度必须介于 0 和 1 之间")
	public String getShareholdersChange() {
		return shareholdersChange;
	}

	public void setShareholdersChange(String shareholdersChange) {
		this.shareholdersChange = shareholdersChange;
	}
	
	@Length(min=0, max=1, message="主要股东、关联公司与母子公司生重大变化影响情况长度必须介于 0 和 1 之间")
	public String getShareholdersChangeEffect() {
		return shareholdersChangeEffect;
	}

	public void setShareholdersChangeEffect(String shareholdersChangeEffect) {
		this.shareholdersChangeEffect = shareholdersChangeEffect;
	}
	
	@Length(min=0, max=2048, message="主要股东、关联公司与母子公司重大变化备注长度必须介于 0 和 2048 之间")
	public String getShareholdersChangeRemark() {
		return shareholdersChangeRemark;
	}

	public void setShareholdersChangeRemark(String shareholdersChangeRemark) {
		this.shareholdersChangeRemark = shareholdersChangeRemark;
	}
	
	@Length(min=0, max=1, message="客户内部管理情况长度必须介于 0 和 1 之间")
	public String getCustomerManage() {
		return customerManage;
	}

	public void setCustomerManage(String customerManage) {
		this.customerManage = customerManage;
	}
	
	@Length(min=0, max=2048, message="客户内部管理情况备注长度必须介于 0 和 2048 之间")
	public String getCustomerManageRemark() {
		return customerManageRemark;
	}

	public void setCustomerManageRemark(String customerManageRemark) {
		this.customerManageRemark = customerManageRemark;
	}
	
	@Length(min=0, max=1, message="是否发生重大诉讼或仲裁、重大事故或重大赔偿长度必须介于 0 和 1 之间")
	public String getArbitrationState() {
		return arbitrationState;
	}

	public void setArbitrationState(String arbitrationState) {
		this.arbitrationState = arbitrationState;
	}
	
	@Length(min=0, max=1, message="是否发生重大诉讼或仲裁、重大事故或重大赔偿影响情况长度必须介于 0 和 1 之间")
	public String getArbitrationStateEffect() {
		return arbitrationStateEffect;
	}

	public void setArbitrationStateEffect(String arbitrationStateEffect) {
		this.arbitrationStateEffect = arbitrationStateEffect;
	}
	
	@Length(min=0, max=2048, message="是否发生重大诉讼或仲裁、重大事故或重大赔偿备注长度必须介于 0 和 2048 之间")
	public String getArbitrationStateRemark() {
		return arbitrationStateRemark;
	}

	public void setArbitrationStateRemark(String arbitrationStateRemark) {
		this.arbitrationStateRemark = arbitrationStateRemark;
	}
	
	@Length(min=0, max=1, message="外部经营环境是否发生不利经营的重大变化长度必须介于 0 和 1 之间")
	public String getOuterManage() {
		return outerManage;
	}

	public void setOuterManage(String outerManage) {
		this.outerManage = outerManage;
	}
	
	@Length(min=0, max=1, message="对竞争变化或外部条件变化是否有应对措施长度必须介于 0 和 1 之间")
	public String getOuterManageMeasures() {
		return outerManageMeasures;
	}

	public void setOuterManageMeasures(String outerManageMeasures) {
		this.outerManageMeasures = outerManageMeasures;
	}
	
	@Length(min=0, max=2048, message="外部经营环境是否发生不利经营的重大变化备注长度必须介于 0 和 2048 之间")
	public String getOuterManageRemark() {
		return outerManageRemark;
	}

	public void setOuterManageRemark(String outerManageRemark) {
		this.outerManageRemark = outerManageRemark;
	}
	
	@Length(min=0, max=1, message="主要合作伙伴是否减少或流失长度必须介于 0 和 1 之间")
	public String getPartnerState() {
		return partnerState;
	}

	public void setPartnerState(String partnerState) {
		this.partnerState = partnerState;
	}
	
	@Length(min=0, max=1, message="期目标实现长度必须介于 0 和 1 之间")
	public String getPartnerObtainGoal() {
		return partnerObtainGoal;
	}

	public void setPartnerObtainGoal(String partnerObtainGoal) {
		this.partnerObtainGoal = partnerObtainGoal;
	}
	
	@Length(min=0, max=2048, message="主要合作伙伴是否减少或流失备注长度必须介于 0 和 2048 之间")
	public String getPartnerStateRemark() {
		return partnerStateRemark;
	}

	public void setPartnerStateRemark(String partnerStateRemark) {
		this.partnerStateRemark = partnerStateRemark;
	}
	
	@Length(min=0, max=1, message="是否存在影响该笔贷款偿还的不利因素长度必须介于 0 和 1 之间")
	public String getBadEffectState() {
		return badEffectState;
	}

	public void setBadEffectState(String badEffectState) {
		this.badEffectState = badEffectState;
	}
	
	@Length(min=0, max=2048, message="是否存在影响该笔贷款偿还的不利因素备注长度必须介于 0 和 2048 之间")
	public String getBadEffectRemark() {
		return badEffectRemark;
	}

	public void setBadEffectRemark(String badEffectRemark) {
		this.badEffectRemark = badEffectRemark;
	}
	
	@Length(min=0, max=2048, message="business_manage_imgs长度必须介于 0 和 2048 之间")
	public String getBusinessManageImgs() {
		return businessManageImgs;
	}

	public void setBusinessManageImgs(String businessManageImgs) {
		this.businessManageImgs = businessManageImgs;
	}

	public String getReportBusinessManageOther() {
		return reportBusinessManageOther;
	}

	public void setReportBusinessManageOther(String reportBusinessManageOther) {
		this.reportBusinessManageOther = reportBusinessManageOther;
	}
	
}