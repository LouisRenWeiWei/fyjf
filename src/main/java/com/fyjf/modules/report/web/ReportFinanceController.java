/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.web.BaseController;
import com.fyjf.modules.report.entity.Report;
import com.fyjf.modules.report.entity.ReportFinance;
import com.fyjf.modules.report.entity.ReportFinanceDetail;
import com.fyjf.modules.report.service.ReportFinanceDetailService;
import com.fyjf.modules.report.service.ReportFinanceService;
import com.fyjf.modules.report.service.ReportService;
import com.fyjf.vo.BaseVO;

/**
 * 贷后报告客户融资情况Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportFinance")
public class ReportFinanceController extends BaseController {
	
	@Autowired
	private ReportService reportService;

	@Autowired
	private ReportFinanceService reportFinanceService;
	
	@Autowired
	private ReportFinanceDetailService reportFinanceDetailService;
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		Report report = JSONObject.toJavaObject(param.getJSONObject("report"), Report.class);
		reportService.save(report);
		ReportFinance reportFinance = JSONObject.toJavaObject(param.getJSONObject("reportFinance"), ReportFinance.class);
		reportFinance.setLoanReportId(report.getId());
		reportFinanceService.save(reportFinance);
		JSONArray reportFinanceItems = param.getJSONArray("reportFinanceItems");
		for(int i=0;i<reportFinanceItems.size();i++){
			ReportFinanceDetail item = JSONObject.toJavaObject(reportFinanceItems.getJSONObject(i), ReportFinanceDetail.class);
			item.setLoanReportId(report.getId());
			reportFinanceDetailService.save(item);
		}
		JSONObject data = new JSONObject();
		data.put("reportId", report.getId());
		vo.setData(data);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
}