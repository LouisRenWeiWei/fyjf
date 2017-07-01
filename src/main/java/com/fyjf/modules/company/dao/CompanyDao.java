/**
 * Copyright &copy; 
 */
package com.fyjf.modules.company.dao;

import java.util.List;
import java.util.Map;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.company.entity.Company;

/**
 * 企业DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface CompanyDao extends CrudDao<Company> {

	Company findUserCompanyByUserOfficeId(String officeId);

	List<Map<String, Object>> findBankList(Company company);
	
}