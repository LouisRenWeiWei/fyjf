/**
 * Copyright &copy;
 */
package com.fyjf.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.user.entity.UserRole;
import com.fyjf.modules.user.dao.UserRoleDao;

/**
 * 用户角色Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class UserRoleService extends CrudService<UserRoleDao, UserRole> {

	public UserRole get(String id) {
		return super.get(id);
	}
	
	public List<UserRole> findList(UserRole userRole) {
		return super.findList(userRole);
	}
	
	public Page<UserRole> findPage(Page<UserRole> page, UserRole userRole) {
		return super.findPage(page, userRole);
	}
	
	@Transactional(readOnly = false)
	public void save(UserRole userRole) {
		super.save(userRole);
	}
	
	@Transactional(readOnly = false)
	public void delete(UserRole userRole) {
		super.delete(userRole);
	}
	
}