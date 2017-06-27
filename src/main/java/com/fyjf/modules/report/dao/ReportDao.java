/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.dao;

import java.util.Date;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.report.entity.Report;

/**
 * 贷后报告DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@MyBatisDao
public interface ReportDao extends CrudDao<Report> {


	Report getCustomerPreReport(String customerId, Date createDate);
	
}