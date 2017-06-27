/**
 * Copyright &copy;
 */
package com.fyjf.modules.overdue.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.overdue.entity.OverdueReport;
import com.fyjf.modules.overdue.dao.OverdueReportDao;

/**
 * 逾期报告Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
@Service
@Transactional(readOnly = true)
public class OverdueReportService extends CrudService<OverdueReportDao, OverdueReport> {

	public OverdueReport get(String id) {
		return super.get(id);
	}
	
	public List<OverdueReport> findList(OverdueReport overdueReport) {
		return super.findList(overdueReport);
	}
	
	public Page<OverdueReport> findPage(Page<OverdueReport> page, OverdueReport overdueReport) {
		return super.findPage(page, overdueReport);
	}
	
	@Transactional(readOnly = false)
	public void save(OverdueReport overdueReport) {
		super.save(overdueReport);
	}
	
	@Transactional(readOnly = false)
	public void delete(OverdueReport overdueReport) {
		super.delete(overdueReport);
	}

	public List<OverdueReport> findListByBankWorker(String account) {
		// TODO Auto-generated method stub
		return dao.findListByBankWorker(account);
	}
	
}