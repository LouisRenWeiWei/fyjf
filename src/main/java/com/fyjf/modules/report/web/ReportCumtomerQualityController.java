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
import com.fyjf.modules.report.entity.ReportCumtomerQuality;
import com.fyjf.modules.report.service.ReportCumtomerQualityService;

/**
 * 贷后报告客户品质Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportCumtomerQuality")
public class ReportCumtomerQualityController extends BaseController {

	@Autowired
	private ReportCumtomerQualityService reportCumtomerQualityService;
	
	@ModelAttribute
	public ReportCumtomerQuality get(@RequestParam(required=false) String id) {
		ReportCumtomerQuality entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = reportCumtomerQualityService.get(id);
		}
		if (entity == null){
			entity = new ReportCumtomerQuality();
		}
		return entity;
	}
	
	@RequiresPermissions("report:reportCumtomerQuality:view")
	@RequestMapping(value = {""})
	public String index(ReportCumtomerQuality reportCumtomerQuality, Model model) {
		return "modules/report/reportCumtomerQualityIndex";
	}
	
	@RequiresPermissions("report:reportCumtomerQuality:view")
	@RequestMapping(value = {"list"})
	public String list(ReportCumtomerQuality reportCumtomerQuality, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ReportCumtomerQuality> page = reportCumtomerQualityService.findPage(new Page<ReportCumtomerQuality>(request, response), reportCumtomerQuality); 
		model.addAttribute("page", page);
		return "modules/report/reportCumtomerQualityList";
	}

	@RequiresPermissions("report:reportCumtomerQuality:view")
	@RequestMapping(value = "form")
	public String form(ReportCumtomerQuality reportCumtomerQuality, Model model) {
		model.addAttribute("reportCumtomerQuality", reportCumtomerQuality);
		return "modules/report/reportCumtomerQualityForm";
	}

	@RequiresPermissions("report:reportCumtomerQuality:edit")
	@RequestMapping(value = "save")
	public String save(ReportCumtomerQuality reportCumtomerQuality, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, reportCumtomerQuality)){
			return form(reportCumtomerQuality, model);
		}
		reportCumtomerQualityService.save(reportCumtomerQuality);
		addMessage(redirectAttributes, "保存贷后报告客户品质成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportCumtomerQuality/list?repage";
	}
	
	@RequiresPermissions("report:reportCumtomerQuality:edit")
	@RequestMapping(value = "delete")
	public String delete(ReportCumtomerQuality reportCumtomerQuality, RedirectAttributes redirectAttributes) {
		reportCumtomerQualityService.delete(reportCumtomerQuality);
		addMessage(redirectAttributes, "删除贷后报告客户品质成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportCumtomerQuality/list?repage";
	}

}