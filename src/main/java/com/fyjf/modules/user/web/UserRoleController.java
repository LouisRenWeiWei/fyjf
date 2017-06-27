/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.web;

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
import com.fyjf.modules.user.entity.UserRole;
import com.fyjf.modules.user.service.UserRoleService;

/**
 * 用户角色Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/user/userRole")
public class UserRoleController extends BaseController {

	@Autowired
	private UserRoleService userRoleService;
	
	@ModelAttribute
	public UserRole get(@RequestParam(required=false) String id) {
		UserRole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userRoleService.get(id);
		}
		if (entity == null){
			entity = new UserRole();
		}
		return entity;
	}
	
	@RequiresPermissions("user:userRole:view")
	@RequestMapping(value = {""})
	public String index(UserRole userRole, Model model) {
		return "modules/user/userRoleIndex";
	}
	
	@RequiresPermissions("user:userRole:view")
	@RequestMapping(value = {"list"})
	public String list(UserRole userRole, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<UserRole> page = userRoleService.findPage(new Page<UserRole>(request, response), userRole); 
		model.addAttribute("page", page);
		return "modules/user/userRoleList";
	}

	@RequiresPermissions("user:userRole:view")
	@RequestMapping(value = "form")
	public String form(UserRole userRole, Model model) {
		model.addAttribute("userRole", userRole);
		return "modules/user/userRoleForm";
	}

	@RequiresPermissions("user:userRole:edit")
	@RequestMapping(value = "save")
	public String save(UserRole userRole, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, userRole)){
			return form(userRole, model);
		}
		userRoleService.save(userRole);
		addMessage(redirectAttributes, "保存用户角色成功");
		return "redirect:"+Global.getAdminPath()+"/user/userRole/list?repage";
	}
	
	@RequiresPermissions("user:userRole:edit")
	@RequestMapping(value = "delete")
	public String delete(UserRole userRole, RedirectAttributes redirectAttributes) {
		userRoleService.delete(userRole);
		addMessage(redirectAttributes, "删除用户角色成功");
		return "redirect:"+Global.getAdminPath()+"/user/userRole/list?repage";
	}

}