/**
 * Copyright &copy; 
 */
package com.fyjf.modules.customer.dao;

import java.util.List;
import java.util.Map;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.customer.entity.Customer;

/**
 * 客户DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface CustomerDao extends CrudDao<Customer> {

	List<Map<String, Object>> findListByApp(Map<String, Object> param);
	
}