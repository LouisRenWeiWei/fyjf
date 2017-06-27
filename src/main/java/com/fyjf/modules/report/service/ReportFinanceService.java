/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.ReportFinance;
import com.fyjf.modules.report.dao.ReportFinanceDao;

/**
 * 贷后报告客户融资情况Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportFinanceService extends CrudService<ReportFinanceDao, ReportFinance> {

	public ReportFinance get(String id) {
		return super.get(id);
	}
	
	public List<ReportFinance> findList(ReportFinance reportFinance) {
		return super.findList(reportFinance);
	}
	
	public Page<ReportFinance> findPage(Page<ReportFinance> page, ReportFinance reportFinance) {
		return super.findPage(page, reportFinance);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportFinance reportFinance) {
		super.save(reportFinance);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportFinance reportFinance) {
		super.delete(reportFinance);
	}

	public ReportFinance getByReportId(String reportId) {
		// TODO Auto-generated method stub
		ReportFinance result = dao.getByReportId(reportId);
		return result;
	}
	
}