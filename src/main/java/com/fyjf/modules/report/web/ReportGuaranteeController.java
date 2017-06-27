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
import com.fyjf.modules.report.entity.ReportGuarantee;
import com.fyjf.modules.report.service.ReportGuaranteeService;

/**
 * 贷后报告担保基本情况Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportGuarantee")
public class ReportGuaranteeController extends BaseController {

	@Autowired
	private ReportGuaranteeService reportGuaranteeService;
	
	@ModelAttribute
	public ReportGuarantee get(@RequestParam(required=false) String id) {
		ReportGuarantee entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = reportGuaranteeService.get(id);
		}
		if (entity == null){
			entity = new ReportGuarantee();
		}
		return entity;
	}
	
	@RequiresPermissions("report:reportGuarantee:view")
	@RequestMapping(value = {""})
	public String index(ReportGuarantee reportGuarantee, Model model) {
		return "modules/report/reportGuaranteeIndex";
	}
	
	@RequiresPermissions("report:reportGuarantee:view")
	@RequestMapping(value = {"list"})
	public String list(ReportGuarantee reportGuarantee, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ReportGuarantee> page = reportGuaranteeService.findPage(new Page<ReportGuarantee>(request, response), reportGuarantee); 
		model.addAttribute("page", page);
		return "modules/report/reportGuaranteeList";
	}

	@RequiresPermissions("report:reportGuarantee:view")
	@RequestMapping(value = "form")
	public String form(ReportGuarantee reportGuarantee, Model model) {
		model.addAttribute("reportGuarantee", reportGuarantee);
		return "modules/report/reportGuaranteeForm";
	}

	@RequiresPermissions("report:reportGuarantee:edit")
	@RequestMapping(value = "save")
	public String save(ReportGuarantee reportGuarantee, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, reportGuarantee)){
			return form(reportGuarantee, model);
		}
		reportGuaranteeService.save(reportGuarantee);
		addMessage(redirectAttributes, "保存贷后报告担保基本情况成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportGuarantee/list?repage";
	}
	
	@RequiresPermissions("report:reportGuarantee:edit")
	@RequestMapping(value = "delete")
	public String delete(ReportGuarantee reportGuarantee, RedirectAttributes redirectAttributes) {
		reportGuaranteeService.delete(reportGuarantee);
		addMessage(redirectAttributes, "删除贷后报告担保基本情况成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportGuarantee/list?repage";
	}

}