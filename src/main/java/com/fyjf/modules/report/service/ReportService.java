/**
 * Copyright &copy;
 */
package com.fyjf.modules.report.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.report.entity.Report;
import com.fyjf.modules.report.entity.ReportBusinessManage;
import com.fyjf.modules.report.entity.ReportCumtomerQuality;
import com.fyjf.modules.report.entity.ReportCustomerFinancial;
import com.fyjf.modules.report.entity.ReportFinance;
import com.fyjf.modules.report.entity.ReportFinanceDetail;
import com.fyjf.modules.report.entity.ReportGuarantee;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.customer.dao.CustomerDao;
import com.fyjf.modules.customer.entity.Customer;
import com.fyjf.modules.customer.service.CustomerService;
import com.fyjf.modules.report.dao.ReportBusinessManageDao;
import com.fyjf.modules.report.dao.ReportCumtomerQualityDao;
import com.fyjf.modules.report.dao.ReportCustomerFinancialDao;
import com.fyjf.modules.report.dao.ReportDao;
import com.fyjf.modules.report.dao.ReportFinanceDao;
import com.fyjf.modules.report.dao.ReportFinanceDetailDao;
import com.fyjf.modules.report.dao.ReportGuaranteeDao;

/**
 * 贷后报告Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Service
@Transactional(readOnly = true)
public class ReportService extends CrudService<ReportDao, Report> {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ReportFinanceService reportFinanceService;
	@Autowired
	ReportFinanceDetailService reportFinanceDetailService;
	@Autowired
	ReportBusinessManageService reportBusinessManageService;
	@Autowired
	ReportCumtomerQualityService reportCumtomerQualityService;
	@Autowired
	ReportCustomerFinancialService reportCustomerFinancialService;
	@Autowired
	ReportGuaranteeService reportGuaranteeService;
	
	public Report get(String id) {
		return super.get(id);
	}
	
	public List<Report> findList(Report report) {
		return super.findList(report);
	}
	
	public Page<Report> findPage(Page<Report> page, Report report) {
		return super.findPage(page, report);
	}
	
	@Transactional(readOnly = false)
	public void save(Report report) {
		super.save(report);
	}
	
	@Transactional(readOnly = false)
	public void delete(Report report) {
		super.delete(report);
	}

	@Transactional(readOnly = false)
	public int saveReport(JSONObject param) {
		// TODO Auto-generated method stub
		//客户数据--这个地方肯定是更新
		Customer customer = JSONObject.toJavaObject(param.getJSONObject("customer"), Customer.class);
		
		
		Report report = JSONObject.toJavaObject(param.getJSONObject("report"), Report.class);
		save(report);
		//如果是预警了，设置用户状态为预警
		if("1".equalsIgnoreCase(report.getRiskWarning())){
			customer.setCustomerState(2);//2 预警
		}
		customerService.save(customer);
		
		ReportFinance reportFinance = JSONObject.toJavaObject(param.getJSONObject("reportFinance"), ReportFinance.class);
		reportFinance.setLoanReportId(report.getId());
		reportFinanceService.save(reportFinance);
		JSONArray reportFinanceItems = param.getJSONArray("reportFinanceItems");
		for(int i=0;i<reportFinanceItems.size();i++){
			ReportFinanceDetail item = JSONObject.toJavaObject(reportFinanceItems.getJSONObject(i), ReportFinanceDetail.class);
			item.setLoanReportId(report.getId());
			reportFinanceDetailService.save(item);
		}
		
		//
		ReportBusinessManage reportBusinessManage = JSONObject.toJavaObject(param.getJSONObject("reportBusinessManage"), ReportBusinessManage.class);
		reportBusinessManage.setLoanReportId(report.getId());
		reportBusinessManageService.save(reportBusinessManage);
		
		ReportCumtomerQuality reportCumtomerQuality = JSONObject.toJavaObject(param.getJSONObject("reportCumtomerQuality"), ReportCumtomerQuality.class);
		reportCumtomerQuality.setLoanReportId(report.getId());
		reportCumtomerQualityService.save(reportCumtomerQuality);
		
		ReportCustomerFinancial reportCustomerFinancial = JSONObject.toJavaObject(param.getJSONObject("reportCustomerFinancial"), ReportCustomerFinancial.class);
		reportCustomerFinancial.setLoanReportId(report.getId());
		reportCustomerFinancialService.save(reportCustomerFinancial);
		
		ReportGuarantee reportGuarantee = JSONObject.toJavaObject(param.getJSONObject("reportGuarantee"), ReportGuarantee.class);
		reportGuarantee.setLoanReportId(report.getId());
		reportGuaranteeService.save(reportGuarantee);
		
		
		return 0;
	}

	public JSONObject getReport(String reportId) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		Report report = get(reportId);
		result.put("report",report);
		result.put("reportFinance",reportFinanceService.getByReportId(reportId));
		result.put("reportFinanceItems",reportFinanceDetailService.findListByReportId(reportId));
		result.put("reportBusinessManage",reportBusinessManageService.getByReportId(reportId));
		result.put("reportCumtomerQuality",reportCumtomerQualityService.getByReportId(reportId));
		ReportCustomerFinancial reportCustomerFinancial = reportCustomerFinancialService.getByReportId(reportId);
		Report lastMonthReport = getCustomerPreReport(report.getCustomerId(),report.getCreateDate());
		if(lastMonthReport!=null){
			ReportCustomerFinancial reportCustomerFinancialPre = reportCustomerFinancialService.getByReportId(lastMonthReport.getId());
			if(reportCustomerFinancialPre!=null){
				reportCustomerFinancial.setCustomerFinaceIncDecSalePre(reportCustomerFinancialPre.getCustomerFinaceIncDecSaleCur());
				reportCustomerFinancial.setCustomerFinaceIncDecProfitPre(reportCustomerFinancialPre.getCustomerFinaceIncDecProfitCur());
				reportCustomerFinancial.setCustomerFinaceIncDecConsumPre(reportCustomerFinancialPre.getCustomerFinaceIncDecConsumCur());
				reportCustomerFinancial.setCustomerFinaceAssetsAccountNeedPre(reportCustomerFinancialPre.getCustomerFinaceAssetsAccountNeedCur());
				reportCustomerFinancial.setCustomerFinaceAssetsInventoryPre(reportCustomerFinancialPre.getCustomerFinaceAssetsInventoryCur());
				reportCustomerFinancial.setCustomerFinaceDebtAccountNeedPre(reportCustomerFinancialPre.getCustomerFinaceDebtAccountNeedCur());
				reportCustomerFinancial.setCustomerFinaceDebtBorrowingPre(reportCustomerFinancialPre.getCustomerFinaceDebtBorrowingCur());
				reportCustomerFinancial.setCustomerFinaceDebtGuarantyPre(reportCustomerFinancialPre.getCustomerFinaceDebtGuarantyCur());
				reportCustomerFinancial.setCustomerFinaceRatioAssetsLiabilitiesPre(reportCustomerFinancialPre.getCustomerFinaceRatioAssetsLiabilitiesCur());
				reportCustomerFinancial.setCustomerFinaceRatioCurrentRatioPre(reportCustomerFinancialPre.getCustomerFinaceRatioCurrentRatioCur());
				reportCustomerFinancial.setCustomerFinaceRatioAccountTurnroundRatePre(reportCustomerFinancialPre.getCustomerFinaceRatioAccountTurnroundRateCur());
				reportCustomerFinancial.setCustomerFinaceRatioSaleProfitPre(reportCustomerFinancialPre.getCustomerFinaceRatioSaleProfitCur());
				reportCustomerFinancial.setCustomerFinaceRatioInventoryPre(reportCustomerFinancialPre.getCustomerFinaceRatioInventoryCur());
			}
		}		
		result.put("reportCustomerFinancial",reportCustomerFinancial);
		result.put("reportGuarantee",reportGuaranteeService.getByReportId(reportId));
		return result;
	}
	
	public JSONObject getReportForPdf(String reportId) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		Report report = get(reportId);
		result.put("report",report);
		result.put("reportFinance",reportFinanceService.getByReportId(reportId));
		result.put("reportFinanceItems",reportFinanceDetailService.findListByReportId(reportId));
		result.put("reportBusinessManage",reportBusinessManageService.getByReportId(reportId));
		result.put("reportCumtomerQuality",reportCumtomerQualityService.getByReportId(reportId));
		ReportCustomerFinancial reportCustomerFinancial = reportCustomerFinancialService.getByReportId(reportId);
		Report lastMonthReport = getCustomerPreReport(report.getCustomerId(),report.getCreateDate());
		if(lastMonthReport!=null){
			ReportCustomerFinancial reportCustomerFinancialPre = reportCustomerFinancialService.getByReportId(lastMonthReport.getId());
			if(reportCustomerFinancialPre!=null){
				reportCustomerFinancial.setCustomerFinaceIncDecSalePre(reportCustomerFinancialPre.getCustomerFinaceIncDecSaleCur());
				reportCustomerFinancial.setCustomerFinaceIncDecProfitPre(reportCustomerFinancialPre.getCustomerFinaceIncDecProfitCur());
				reportCustomerFinancial.setCustomerFinaceIncDecConsumPre(reportCustomerFinancialPre.getCustomerFinaceIncDecConsumCur());
				reportCustomerFinancial.setCustomerFinaceAssetsAccountNeedPre(reportCustomerFinancialPre.getCustomerFinaceAssetsAccountNeedCur());
				reportCustomerFinancial.setCustomerFinaceAssetsInventoryPre(reportCustomerFinancialPre.getCustomerFinaceAssetsInventoryCur());
				reportCustomerFinancial.setCustomerFinaceDebtAccountNeedPre(reportCustomerFinancialPre.getCustomerFinaceDebtAccountNeedCur());
				reportCustomerFinancial.setCustomerFinaceDebtBorrowingPre(reportCustomerFinancialPre.getCustomerFinaceDebtBorrowingCur());
				reportCustomerFinancial.setCustomerFinaceDebtGuarantyPre(reportCustomerFinancialPre.getCustomerFinaceDebtGuarantyCur());
				reportCustomerFinancial.setCustomerFinaceRatioAssetsLiabilitiesPre(reportCustomerFinancialPre.getCustomerFinaceRatioAssetsLiabilitiesCur());
				reportCustomerFinancial.setCustomerFinaceRatioCurrentRatioPre(reportCustomerFinancialPre.getCustomerFinaceRatioCurrentRatioCur());
				reportCustomerFinancial.setCustomerFinaceRatioAccountTurnroundRatePre(reportCustomerFinancialPre.getCustomerFinaceRatioAccountTurnroundRateCur());
				reportCustomerFinancial.setCustomerFinaceRatioSaleProfitPre(reportCustomerFinancialPre.getCustomerFinaceRatioSaleProfitCur());
				reportCustomerFinancial.setCustomerFinaceRatioInventoryPre(reportCustomerFinancialPre.getCustomerFinaceRatioInventoryCur());
			}
		}		
		result.put("reportCF",reportCustomerFinancial);
		result.put("reportGuarantee",reportGuaranteeService.getByReportId(reportId));
		return result;
	}

	private Report getCustomerPreReport(String customerId, Date createDate) {
		// TODO Auto-generated method stub
		return dao.getCustomerPreReport(customerId,createDate);
	}
	
}