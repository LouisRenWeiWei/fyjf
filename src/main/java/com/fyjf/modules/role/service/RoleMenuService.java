/**
 * Copyright &copy;
 */
package com.fyjf.modules.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.role.entity.RoleMenu;
import com.fyjf.modules.role.dao.RoleMenuDao;

/**
 * 角色菜单Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class RoleMenuService extends CrudService<RoleMenuDao, RoleMenu> {

	public RoleMenu get(String id) {
		return super.get(id);
	}
	
	public List<RoleMenu> findList(RoleMenu roleMenu) {
		return super.findList(roleMenu);
	}
	
	public Page<RoleMenu> findPage(Page<RoleMenu> page, RoleMenu roleMenu) {
		return super.findPage(page, roleMenu);
	}
	
	@Transactional(readOnly = false)
	public void save(RoleMenu roleMenu) {
		super.save(roleMenu);
	}
	
	@Transactional(readOnly = false)
	public void delete(RoleMenu roleMenu) {
		super.delete(roleMenu);
	}
	
}