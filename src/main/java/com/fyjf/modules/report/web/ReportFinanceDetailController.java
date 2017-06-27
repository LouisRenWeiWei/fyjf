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
import com.fyjf.modules.report.entity.ReportFinanceDetail;
import com.fyjf.modules.report.service.ReportFinanceDetailService;

/**
 * 贷后报告客户融资情况--itemController
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportFinanceDetail")
public class ReportFinanceDetailController extends BaseController {

	@Autowired
	private ReportFinanceDetailService reportFinanceDetailService;
	
	@ModelAttribute
	public ReportFinanceDetail get(@RequestParam(required=false) String id) {
		ReportFinanceDetail entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = reportFinanceDetailService.get(id);
		}
		if (entity == null){
			entity = new ReportFinanceDetail();
		}
		return entity;
	}
	
	@RequiresPermissions("report:reportFinanceDetail:view")
	@RequestMapping(value = {""})
	public String index(ReportFinanceDetail reportFinanceDetail, Model model) {
		return "modules/report/reportFinanceDetailIndex";
	}
	
	@RequiresPermissions("report:reportFinanceDetail:view")
	@RequestMapping(value = {"list"})
	public String list(ReportFinanceDetail reportFinanceDetail, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ReportFinanceDetail> page = reportFinanceDetailService.findPage(new Page<ReportFinanceDetail>(request, response), reportFinanceDetail); 
		model.addAttribute("page", page);
		return "modules/report/reportFinanceDetailList";
	}

	@RequiresPermissions("report:reportFinanceDetail:view")
	@RequestMapping(value = "form")
	public String form(ReportFinanceDetail reportFinanceDetail, Model model) {
		model.addAttribute("reportFinanceDetail", reportFinanceDetail);
		return "modules/report/reportFinanceDetailForm";
	}

	@RequiresPermissions("report:reportFinanceDetail:edit")
	@RequestMapping(value = "save")
	public String save(ReportFinanceDetail reportFinanceDetail, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, reportFinanceDetail)){
			return form(reportFinanceDetail, model);
		}
		reportFinanceDetailService.save(reportFinanceDetail);
		addMessage(redirectAttributes, "保存贷后报告客户融资情况--item成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportFinanceDetail/list?repage";
	}
	
	@RequiresPermissions("report:reportFinanceDetail:edit")
	@RequestMapping(value = "delete")
	public String delete(ReportFinanceDetail reportFinanceDetail, RedirectAttributes redirectAttributes) {
		reportFinanceDetailService.delete(reportFinanceDetail);
		addMessage(redirectAttributes, "删除贷后报告客户融资情况--item成功");
		return "redirect:"+Global.getAdminPath()+"/report/reportFinanceDetail/list?repage";
	}

}