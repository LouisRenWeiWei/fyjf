/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.dao;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.user.entity.UserRole;

/**
 * 用户角色DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface UserRoleDao extends CrudDao<UserRole> {
	
}