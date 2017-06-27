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
import com.fyjf.modules.report.entity.ReportCustomerFinancial;
import com.fyjf.modules.report.service.ReportCustomerFinancialService;
import com.fyjf.vo.BaseVO;

/**
 * 贷后报告客户融资情况Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/customerFinancial")
public class ReportCustomerFinancialController extends BaseController {

	@Autowired
	private ReportCustomerFinancialService reportCustomerFinancialService;
	
	@RequestMapping(value = "pre", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get_pre() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(reportCustomerFinancialService.get_pre());
		return vo;
	}
}