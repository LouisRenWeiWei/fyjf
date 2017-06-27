/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.dao;

import java.util.Date;
import java.util.List;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.report.entity.ReportCustomerFinancial;

/**
 * 贷后报告客户融资情况DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@MyBatisDao
public interface ReportCustomerFinancialDao extends CrudDao<ReportCustomerFinancial> {

	ReportCustomerFinancial getByReportId(String reportId);

	ReportCustomerFinancial getPre();

	List<ReportCustomerFinancial> findListByCustomerId(String customerId);
	
}