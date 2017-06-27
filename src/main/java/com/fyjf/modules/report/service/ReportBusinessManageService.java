/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.ReportBusinessManage;
import com.fyjf.modules.report.dao.ReportBusinessManageDao;

/**
 * 贷后报告客户经营管理情况Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportBusinessManageService extends CrudService<ReportBusinessManageDao, ReportBusinessManage> {

	public ReportBusinessManage get(String id) {
		return super.get(id);
	}
	
	public List<ReportBusinessManage> findList(ReportBusinessManage reportBusinessManage) {
		return super.findList(reportBusinessManage);
	}
	
	public Page<ReportBusinessManage> findPage(Page<ReportBusinessManage> page, ReportBusinessManage reportBusinessManage) {
		return super.findPage(page, reportBusinessManage);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportBusinessManage reportBusinessManage) {
		super.save(reportBusinessManage);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportBusinessManage reportBusinessManage) {
		super.delete(reportBusinessManage);
	}

	public ReportBusinessManage getByReportId(String reportId) {
		// TODO Auto-generated method stub
		return dao.getByReportId(reportId);
	}
	
}