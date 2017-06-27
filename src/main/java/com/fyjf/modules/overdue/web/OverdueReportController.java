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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.overdue.entity.OverdueProgress;
import com.fyjf.modules.overdue.entity.OverdueReport;
import com.fyjf.modules.overdue.service.OverdueProgressService;
import com.fyjf.modules.overdue.service.OverdueReportService;
import com.fyjf.vo.BaseVO;

/**
 * 逾期报告Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
@Controller
@RequestMapping(value = "${adminPath}/overdue/")
public class OverdueReportController extends BaseController {

	@Autowired
	private OverdueReportService overdueReportService;
	
	@Autowired
	private OverdueProgressService overdueProgressService;
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setData(overdueReportService.get(param.getString("id")));
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		OverdueReport overdueReport = JSONObject.toJavaObject(param.getJSONObject("overdue"), OverdueReport.class);
		if(StringUtils.isEmpty(overdueReport.getId())){
			overdueReportService.save(overdueReport);
		}		
		OverdueProgress overdueProgress = JSONObject.toJavaObject(param.getJSONObject("overdueProgress"), OverdueProgress.class);
		overdueProgress.setOverdueId(overdueReport.getId());
		overdueProgressService.save(overdueProgress);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	
	@RequestMapping(value = "list/by/bank/worker", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list_by_bank_worker(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String account = param.getString("account");
		vo.setData(overdueReportService.findListByBankWorker(account));
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	

}