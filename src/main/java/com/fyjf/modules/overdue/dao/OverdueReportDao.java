/**
 * Copyright &copy; 
 */
package com.fyjf.modules.overdue.dao;

import java.util.List;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.overdue.entity.OverdueReport;

/**
 * 逾期报告DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
@MyBatisDao
public interface OverdueReportDao extends CrudDao<OverdueReport> {

	List<OverdueReport> findListByBankWorker(String account);
	
}