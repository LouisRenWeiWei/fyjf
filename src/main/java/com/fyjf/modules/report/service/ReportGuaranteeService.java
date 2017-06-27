/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.ReportGuarantee;
import com.fyjf.modules.report.dao.ReportGuaranteeDao;

/**
 * 贷后报告担保基本情况Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportGuaranteeService extends CrudService<ReportGuaranteeDao, ReportGuarantee> {

	public ReportGuarantee get(String id) {
		return super.get(id);
	}
	
	public List<ReportGuarantee> findList(ReportGuarantee reportGuarantee) {
		return super.findList(reportGuarantee);
	}
	
	public Page<ReportGuarantee> findPage(Page<ReportGuarantee> page, ReportGuarantee reportGuarantee) {
		return super.findPage(page, reportGuarantee);
	}
	
	@Transactional(readOnly = false)
	public void save(ReportGuarantee reportGuarantee) {
		super.save(reportGuarantee);
	}
	
	@Transactional(readOnly = false)
	public void delete(ReportGuarantee reportGuarantee) {
		super.delete(reportGuarantee);
	}

	public ReportGuarantee getByReportId(String reportId) {
		// TODO Auto-generated method stub
		return dao.getByReportId(reportId);
	}
	
}