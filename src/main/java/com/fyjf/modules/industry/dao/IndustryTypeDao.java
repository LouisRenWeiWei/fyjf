/**
 * Copyright &copy; 
 */
package com.fyjf.modules.industry.dao;

import java.util.List;

import com.fyjf.common.persistence.TreeDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.industry.entity.IndustryType;

/**
 * 企业类型DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface IndustryTypeDao extends TreeDao<IndustryType> {

	List<IndustryType> findListDisplay(IndustryType industry);
	
}