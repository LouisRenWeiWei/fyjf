/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.dao;

import com.fyjf.common.persistence.TreeDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.area.entity.AreaLevel;

/**
 * 区域级别DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface AreaLevelDao extends TreeDao<AreaLevel> {
	
}