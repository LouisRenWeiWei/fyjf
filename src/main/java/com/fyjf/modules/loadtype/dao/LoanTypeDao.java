/**
 * Copyright &copy; 
 */
package com.fyjf.modules.loadtype.dao;

import com.fyjf.common.persistence.TreeDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.loadtype.entity.LoanType;

/**
 * 信贷品种类型DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-18
 */
@MyBatisDao
public interface LoanTypeDao extends TreeDao<LoanType> {
	
}