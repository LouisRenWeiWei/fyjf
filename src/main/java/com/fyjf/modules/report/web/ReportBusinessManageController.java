/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.web;

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
import com.fyjf.modules.report.entity.ReportBusinessManage;
import com.fyjf.modules.report.service.ReportBusinessManageService;

/**
 * 贷后报告客户经营管理情况Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportBusinessManage")
public class ReportBusinessManageController extends BaseController {

	@Autowired
	private ReportBusinessManageService reportBusinessManageService;
	
	@ModelAttribute
	public ReportBusinessManage get(@RequestParam(required=false) String id) {
		ReportBusinessManage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = reportBusinessManageService.get(id);
		}
		if (entity == null){
			entity = new ReportBusinessManage();
		}
		return entity;
	}
	
	@RequiresPermissions("report:reportBusinessManage:view")
	@RequestMapping(value = {""})
	public String index(ReportBusinessManage reportBusinessManage, Model model) {
		return "modules/report/reportBusinessManageIndex";
	}
	
	@RequiresPermissions("report:reportBusinessManage:view")
	@RequestMapping(value = {"list"})
	public String list(ReportBusinessManage reportBusinessManage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ReportBusinessManage> page = reportBusinessManageService.findPage(new Page<ReportBusinessManage>(request, response), reportBusinessManage); 
		model.addAttribute("page", page);
		return "modules/report/reportBusinessManageList";
	}

	@RequiresPermissions("report:reportBusinessManage:view")
	@RequestMapping(value = "form")
	public String form(ReportBusinessManage reportBusinessManage, Model model) {
		model.addAttribute("reportBusinessManage", reportBusinessManage);
		return "modules/report/reportBusinessManageForm";
	}

	@RequiresPermissions("report:reportBusinessManage:edit")
	@RequestMapping(value = "save")
	public String save(ReportBusinessManage reportBusinessManage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, reportBusinessManage)){
			return form(reportBusinessManage, model);
		}
		reportBusinessManageService.save(reportBusinessManage);
		addMessage(redirectAttributes, "保存贷后报告客户经营管理情况成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportBusinessManage/list?repage";
	}
	
	@RequiresPermissions("report:reportBusinessManage:edit")
	@RequestMapping(value = "delete")
	public String delete(ReportBusinessManage reportBusinessManage, RedirectAttributes redirectAttributes) {
		reportBusinessManageService.delete(reportBusinessManage);
		addMessage(redirectAttributes, "删除贷后报告客户经营管理情况成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportBusinessManage/list?repage";
	}

}