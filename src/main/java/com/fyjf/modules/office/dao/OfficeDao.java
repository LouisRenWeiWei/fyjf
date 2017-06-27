/**
 * Copyright &copy; 
 */
package com.fyjf.modules.office.dao;

import java.util.List;
import java.util.Map;

import com.fyjf.common.persistence.TreeDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.office.entity.Office;

/**
 * 组织结构DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	Office findUserOfficeByUserId(String userId);

	
}