/**
 * Copyright &copy; 
 */
package com.fyjf.modules.customer.entity;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.overdue.entity.OverdueReport;
import com.fyjf.modules.report.entity.Report;
import com.fyjf.modules.user.entity.User;

/**
 * 客户Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
public class Customer extends DataEntity<Customer> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 客户名称
	private String creditCode;		// 信用代码
	private Integer customerState;//1：贷后  2：预警 3： 逾期
	private Area area;		// 所在地区
	private String address;		// 经营地址
	private String telphone;		// 联系电话
	private String manager;		// 实际控制人
	private IndustryType industryType;//industryTypeId;		// 行业类型
	private String mainBusiness;		// 主营业务
	private User managerByUs;		// 我方负责人员
	private String bankId;		// 银行
//	private String bankOfficeId;		// 银行部门
	private Office bankOffice;
	private User bankOfficeWorker;		// 银行员工
	
	private Report report;
	
	private OverdueReport overdueReport;//逾期报告
	
	public Customer() {
		super();
	}

	public Customer(String id){
		super(id);
	}

	@Length(min=1, max=100, message="客户名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="信用代码长度必须介于 0 和 100 之间")
	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=0, max=100, message="经营地址长度必须介于 0 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=100, message="联系电话长度必须介于 0 和 100 之间")
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	@Length(min=0, max=100, message="实际控制人长度必须介于 0 和 100 之间")
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	
	@Length(min=0, max=100, message="主营业务长度必须介于 0 和 100 之间")
	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}
	
	
	
	@Length(min=0, max=100, message="银行长度必须介于 0 和 100 之间")
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	

	public Office getBankOffice() {
		return bankOffice;
	}

	public void setBankOffice(Office bankOffice) {
		this.bankOffice = bankOffice;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public User getManagerByUs() {
		return managerByUs;
	}

	public void setManagerByUs(User managerByUs) {
		this.managerByUs = managerByUs;
	}

	public User getBankOfficeWorker() {
		return bankOfficeWorker;
	}

	public void setBankOfficeWorker(User bankOfficeWorker) {
		this.bankOfficeWorker = bankOfficeWorker;
	}

	

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Integer getCustomerState() {
		return customerState;
	}

	public void setCustomerState(Integer customerState) {
		this.customerState = customerState;
	}

	public OverdueReport getOverdueReport() {
		return overdueReport;
	}

	public void setOverdueReport(OverdueReport overdueReport) {
		this.overdueReport = overdueReport;
	}
	
	
	
}