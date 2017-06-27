/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.dao;

import java.util.List;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.report.entity.ReportFinanceDetail;

/**
 * 贷后报告客户融资情况--itemDAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@MyBatisDao
public interface ReportFinanceDetailDao extends CrudDao<ReportFinanceDetail> {

	List<ReportFinanceDetail> findListByReportId(String reportId);
	
}