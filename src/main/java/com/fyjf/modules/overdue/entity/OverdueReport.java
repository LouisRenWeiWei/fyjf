/**
 * Copyright &copy; 
 */
package com.fyjf.modules.overdue.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fyjf.common.persistence.DataEntity;
import com.fyjf.modules.customer.entity.Customer;

/**
 * 逾期报告Entity
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
public class OverdueReport extends DataEntity<OverdueReport> {
	
	private static final long serialVersionUID = 1L;
	private Customer customer;		// 客户id
	private String overduePdf;		// 催收方案PDF
	private String overdueDays;		// 逾期天数
	
	private List<OverdueProgress> overdueProgress;
	
	public OverdueReport() {
		super();
	}

	public OverdueReport(String id){
		super(id);
	}

	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Length(min=0, max=255, message="催收方案PDF长度必须介于 0 和 255 之间")
	public String getOverduePdf() {
		return overduePdf;
	}

	public void setOverduePdf(String overduePdf) {
		this.overduePdf = overduePdf;
	}

	public String getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(String overdueDays) {
		this.overdueDays = overdueDays;
	}

	public List<OverdueProgress> getOverdueProgress() {
		return overdueProgress;
	}

	public void setOverdueProgress(List<OverdueProgress> overdueProgress) {
		this.overdueProgress = overdueProgress;
	}
	
	
	
	
	
}