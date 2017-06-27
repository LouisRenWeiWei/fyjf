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
import com.fyjf.modules.user.entity.UserOffice;
import com.fyjf.modules.user.service.UserOfficeService;

/**
 * 用户组织Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/user/userOffice")
public class UserOfficeController extends BaseController {

	@Autowired
	private UserOfficeService userOfficeService;
	
	@ModelAttribute
	public UserOffice get(@RequestParam(required=false) String id) {
		UserOffice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userOfficeService.get(id);
		}
		if (entity == null){
			entity = new UserOffice();
		}
		return entity;
	}
	
	@RequiresPermissions("user:userOffice:view")
	@RequestMapping(value = {""})
	public String index(UserOffice userOffice, Model model) {
		return "modules/user/userOfficeIndex";
	}
	
	@RequiresPermissions("user:userOffice:view")
	@RequestMapping(value = {"list"})
	public String list(UserOffice userOffice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<UserOffice> page = userOfficeService.findPage(new Page<UserOffice>(request, response), userOffice); 
		model.addAttribute("page", page);
		return "modules/user/userOfficeList";
	}

	@RequiresPermissions("user:userOffice:view")
	@RequestMapping(value = "form")
	public String form(UserOffice userOffice, Model model) {
		model.addAttribute("userOffice", userOffice);
		return "modules/user/userOfficeForm";
	}

	@RequiresPermissions("user:userOffice:edit")
	@RequestMapping(value = "save")
	public String save(UserOffice userOffice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, userOffice)){
			return form(userOffice, model);
		}
		userOfficeService.save(userOffice);
		addMessage(redirectAttributes, "保存用户组织成功");
		return "redirect:"+Global.getAdminPath()+"/user/userOffice/list?repage";
	}
	
	@RequiresPermissions("user:userOffice:edit")
	@RequestMapping(value = "delete")
	public String delete(UserOffice userOffice, RedirectAttributes redirectAttributes) {
		userOfficeService.delete(userOffice);
		addMessage(redirectAttributes, "删除用户组织成功");
		return "redirect:"+Global.getAdminPath()+"/user/userOffice/list?repage";
	}

}