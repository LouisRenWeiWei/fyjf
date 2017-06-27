/**
 * Copyright &copy; 
 */
package com.fyjf.modules.overdue.web;

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
import com.fyjf.modules.overdue.entity.OverdueProgress;
import com.fyjf.modules.overdue.service.OverdueProgressService;

/**
 * 逾期报告进度Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
@Controller
@RequestMapping(value = "${adminPath}/overdue/progress")
public class OverdueProgressController extends BaseController {

	@Autowired
	private OverdueProgressService overdueProgressService;
	
	@ModelAttribute
	public OverdueProgress get(@RequestParam(required=false) String id) {
		OverdueProgress entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = overdueProgressService.get(id);
		}
		if (entity == null){
			entity = new OverdueProgress();
		}
		return entity;
	}
	
	@RequiresPermissions("overdue:overdueProgress:view")
	@RequestMapping(value = {""})
	public String index(OverdueProgress overdueProgress, Model model) {
		return "modules/overdue/overdueProgressIndex";
	}
	
	@RequiresPermissions("overdue:overdueProgress:view")
	@RequestMapping(value = {"list"})
	public String list(OverdueProgress overdueProgress, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OverdueProgress> page = overdueProgressService.findPage(new Page<OverdueProgress>(request, response), overdueProgress); 
		model.addAttribute("page", page);
		return "modules/overdue/overdueProgressList";
	}

	@RequiresPermissions("overdue:overdueProgress:view")
	@RequestMapping(value = "form")
	public String form(OverdueProgress overdueProgress, Model model) {
		model.addAttribute("overdueProgress", overdueProgress);
		return "modules/overdue/overdueProgressForm";
	}

	@RequiresPermissions("overdue:overdueProgress:edit")
	@RequestMapping(value = "save")
	public String save(OverdueProgress overdueProgress, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, overdueProgress)){
			return form(overdueProgress, model);
		}
		overdueProgressService.save(overdueProgress);
		addMessage(redirectAttributes, "保存逾期报告进度成功");
		return "redirect:"+Global.getAdminPath()+"/overdue/overdueProgress/list?repage";
	}
	
	@RequiresPermissions("overdue:overdueProgress:edit")
	@RequestMapping(value = "delete")
	public String delete(OverdueProgress overdueProgress, RedirectAttributes redirectAttributes) {
		overdueProgressService.delete(overdueProgress);
		addMessage(redirectAttributes, "删除逾期报告进度成功");
		return "redirect:"+Global.getAdminPath()+"/overdue/overdueProgress/list?repage";
	}

}