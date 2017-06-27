/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.ReportFinanceDetail;
import com.fyjf.modules.report.dao.ReportFinanceDetailDao;

/**
 * 贷后报告客户融资情况--itemService
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportFinanceDetailService extends CrudService<ReportFinanceDetailDao, ReportFinanceDetail> {

	public ReportFinanceDetail get(String id) {
		return super.get(id);
	}
	
	public List<ReportFinanceDetail> findList(ReportFinanceDetail reportFinanceDetail) {
		return super.findList(reportFinanceDetail);
	}
	
	public Page<ReportFinanceDetail> findPage(Page<ReportFinanceDetail> page, ReportFinanceDetail reportFinanceDetail) {
		return super.findPage(page, reportFinanceDetail);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportFinanceDetail reportFinanceDetail) {
		super.save(reportFinanceDetail);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportFinanceDetail reportFinanceDetail) {
		super.delete(reportFinanceDetail);
	}

	public List<ReportFinanceDetail> findListByReportId(String reportId) {
		// TODO Auto-generated method stub
		return dao.findListByReportId(reportId);
	}
	
}