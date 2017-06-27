/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.dao;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.report.entity.ReportBusinessManage;

/**
 * 贷后报告客户经营管理情况DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@MyBatisDao
public interface ReportBusinessManageDao extends CrudDao<ReportBusinessManage> {

	ReportBusinessManage getByReportId(String reportId);
	
}