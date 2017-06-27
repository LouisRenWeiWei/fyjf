/**
 * Copyright &copy; 
 */
package com.fyjf.modules.role.dao;

import java.util.List;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.role.entity.Role;

/**
 * 角色DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {

	List<Role> findListByUserId(String userId);
	
	
}