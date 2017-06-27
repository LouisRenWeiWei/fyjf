/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.ReportCumtomerQuality;
import com.fyjf.modules.report.entity.ReportCustomerFinancial;
import com.fyjf.modules.report.dao.ReportCustomerFinancialDao;

/**
 * 贷后报告客户融资情况Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportCustomerFinancialService extends CrudService<ReportCustomerFinancialDao, ReportCustomerFinancial> {

	public ReportCustomerFinancial get(String id) {
		return super.get(id);
	}
	
	public List<ReportCustomerFinancial> findList(ReportCustomerFinancial reportCustomerFinancial) {
		return super.findList(reportCustomerFinancial);
	}
	
	public Page<ReportCustomerFinancial> findPage(Page<ReportCustomerFinancial> page, ReportCustomerFinancial reportCustomerFinancial) {
		return super.findPage(page, reportCustomerFinancial);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportCustomerFinancial reportCustomerFinancial) {
		super.save(reportCustomerFinancial);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportCustomerFinancial reportCustomerFinancial) {
		super.delete(reportCustomerFinancial);
	}

	public ReportCustomerFinancial getByReportId(String reportId) {
		// TODO Auto-generated method stub
		ReportCustomerFinancial result= dao.getByReportId(reportId);
		return result;
	}

	public ReportCustomerFinancial get_pre() {
		// TODO Auto-generated method stub
		return dao.getPre();
	}

	public List<ReportCustomerFinancial> getLast12MonethEcharts(String customerId) {
		// TODO Auto-generated method stub
		return dao.findListByCustomerId(customerId);
	}
	
}