/**
 * Copyright &copy;
 */
package com.fyjf.modules.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.role.entity.RoleMenu;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.role.dao.RoleDao;
import com.fyjf.modules.role.dao.RoleMenuDao;

/**
 * 角色Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class RoleService extends CrudService<RoleDao, Role> {
	
	@Autowired
	RoleMenuDao roleMenuDao;

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

	@Transactional(readOnly = false)
	public void saveRoleData(JSONObject param) {
		// TODO Auto-generated method stub
		Role role = JSONObject.toJavaObject(param.getJSONObject("role"), Role.class);
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		role.setCompany(new Company(companyId));
		save(role);
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleId(role.getId());
		roleMenuDao.deleteAllByRole(roleMenu);
		//
		JSONArray permission = param.getJSONArray("permission");
		for(int i=0;i<permission.size();i++){			
			RoleMenu tmp = new RoleMenu();
			tmp.setRoleId(role.getId());
			tmp.setMenuId(permission.getString(i));
			roleMenuDao.insert(tmp);
		}
	}

	
	
}