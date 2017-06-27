/**
 * Copyright &copy; 
 */
package com.fyjf.modules.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.menu.entity.Menu;
import com.fyjf.modules.menu.dao.MenuDao;

/**
 * 菜单Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class MenuService extends TreeService<MenuDao, Menu> {

	public Menu get(String id) {
		return super.get(id);
	}
	
	public List<Menu> findList(Menu menu) {
		if (StringUtils.isNotBlank(menu.getParentIds())){
			menu.setParentIds(","+menu.getParentIds()+",");
		}
		return super.findList(menu);
	}
	
	@Transactional(readOnly = false)
	public void save(Menu menu) {
		super.save(menu);
	}
	
	@Transactional(readOnly = false)
	public void delete(Menu menu) {
		super.delete(menu);
	}
	
}