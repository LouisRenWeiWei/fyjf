/**
 * Copyright &copy; 
 */
package com.fyjf.modules.role.dao;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.role.entity.RoleMenu;

/**
 * 角色菜单DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface RoleMenuDao extends CrudDao<RoleMenu> {
	
}