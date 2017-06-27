/**
 * Copyright &copy;
 */
package com.fyjf.modules.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.role.dao.RoleDao;

/**
 * 角色Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class RoleService extends CrudService<RoleDao, Role> {

	public Role get(String id) {
		return super.get(id);
	}
	
	public List<Role> findList(Role role) {
		return super.findList(role);
	}
	
	public Page<Role> findPage(Page<Role> page, Role role) {
		return super.findPage(page, role);
	}
	
	@Transactional(readOnly = false)
	public void save(Role role) {
		super.save(role);
	}
	
	@Transactional(readOnly = false)
	public void delete(Role role) {
		super.delete(role);
	}

	
	
}