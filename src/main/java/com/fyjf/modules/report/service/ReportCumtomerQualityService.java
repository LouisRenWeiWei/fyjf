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
import com.fyjf.modules.report.dao.ReportCumtomerQualityDao;

/**
 * 贷后报告客户品质Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportCumtomerQualityService extends CrudService<ReportCumtomerQualityDao, ReportCumtomerQuality> {

	public ReportCumtomerQuality get(String id) {
		return super.get(id);
	}
	
	public List<ReportCumtomerQuality> findList(ReportCumtomerQuality reportCumtomerQuality) {
		return super.findList(reportCumtomerQuality);
	}
	
	public Page<ReportCumtomerQuality> findPage(Page<ReportCumtomerQuality> page, ReportCumtomerQuality reportCumtomerQuality) {
		return super.findPage(page, reportCumtomerQuality);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportCumtomerQuality reportCumtomerQuality) {
		super.save(reportCumtomerQuality);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportCumtomerQuality reportCumtomerQuality) {
		super.delete(reportCumtomerQuality);
	}

	public ReportCumtomerQuality getByReportId(String reportId) {
		// TODO Auto-generated method stub
		return dao.getByReportId(reportId);
	}

	
	
}