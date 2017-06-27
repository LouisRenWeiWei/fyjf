/**
 * Copyright &copy; 
 */
package com.fyjf.modules.role.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fyjf.common.config.Global;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.role.entity.RoleMenu;
import com.fyjf.modules.role.service.RoleMenuService;

/**
 * 角色菜单Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/role/roleMenu")
public class RoleMenuController extends BaseController {

	@Autowired
	private RoleMenuService roleMenuService;
	
	@ModelAttribute
	public RoleMenu get(@RequestParam(required=false) String id) {
		RoleMenu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = roleMenuService.get(id);
		}
		if (entity == null){
			entity = new RoleMenu();
		}
		return entity;
	}
	
	@RequiresPermissions("role:roleMenu:view")
	@RequestMapping(value = {""})
	public String index(RoleMenu roleMenu, Model model) {
		return "modules/role/roleMenuIndex";
	}
	
	@RequiresPermissions("role:roleMenu:view")
	@RequestMapping(value = {"list"})
	public String list(RoleMenu roleMenu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RoleMenu> page = roleMenuService.findPage(new Page<RoleMenu>(request, response), roleMenu); 
		model.addAttribute("page", page);
		return "modules/role/roleMenuList";
	}

	@RequiresPermissions("role:roleMenu:view")
	@RequestMapping(value = "form")
	public String form(RoleMenu roleMenu, Model model) {
		model.addAttribute("roleMenu", roleMenu);
		return "modules/role/roleMenuForm";
	}

	@RequiresPermissions("role:roleMenu:edit")
	@RequestMapping(value = "save")
	public String save(RoleMenu roleMenu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, roleMenu)){
			return form(roleMenu, model);
		}
		roleMenuService.save(roleMenu);
		addMessage(redirectAttributes, "保存角色菜单成功");
		return "redirect:"+Global.getAdminPath()+"/role/roleMenu/list?repage";
	}
	
	@RequiresPermissions("role:roleMenu:edit")
	@RequestMapping(value = "delete")
	public String delete(RoleMenu roleMenu, RedirectAttributes redirectAttributes) {
		roleMenuService.delete(roleMenu);
		addMessage(redirectAttributes, "删除角色菜单成功");
		return "redirect:"+Global.getAdminPath()+"/role/roleMenu/list?repage";
	}

}