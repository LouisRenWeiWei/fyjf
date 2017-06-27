/**
 * Copyright &copy; 
 */
package com.fyjf.modules.report.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.utils.DateUtils;
import com.fyjf.common.utils.DocUtil;
import com.fyjf.common.utils.FreeMarkers;
import com.fyjf.common.utils.ImageUtils;
import com.fyjf.common.web.BaseController;
import com.fyjf.modules.customer.service.CustomerService;
import com.fyjf.modules.report.entity.ReportCumtomerQuality;
import com.fyjf.modules.report.entity.ReportCustomerFinancial;
import com.fyjf.modules.report.service.ReportCumtomerQualityService;
import com.fyjf.modules.report.service.ReportCustomerFinancialService;
import com.fyjf.modules.report.service.ReportService;
import com.fyjf.vo.BaseVO;

/**
 * 贷后报告Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/report/")
public class ReportController extends BaseController {

	
	@Value("#{APP_PROP['file.report.location']}")
	String report_location;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private ReportCustomerFinancialService reportCustomerFinancialService;
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String id = param.getString("id");
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(reportService.getReport(id));
		return vo;
	}
	
	@RequestMapping(value = "get/report/file", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get_pdf(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		
		try {
			String id = param.getString("id");
			JSONObject data = reportService.getReport(id);
			data.put("customer", customerService.get(data.getJSONObject("report").getString("customerId")));
			
			
			
//			DocUtil docutil = new DocUtil();
//			String pathName = "/template/";
//			Resource resource = new ClassPathResource(pathName);
//	    	docutil.createDoc(data, "rww", resource.getURL().getPath(), "E:/work/other/fyjf/system/fyjf/src/main/resources/template/rww.doc", "E:/work/other/fyjf/system/fyjf/src/main/resources/template/rww.pdf", "pdf");

	    	
	    	String pathName = "/template/report.ftl";
			Resource resource = new ClassPathResource(pathName); 
			InputStream is = resource.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();  
			while (true) {
				String line = br.readLine();
				if (line == null){
					break;
				}
				sb.append(line).append("\r\n");
			}
			if (is != null) {
				is.close();
			}
			if (br != null) {
				br.close();
			}			
			String docPath = report_location+"/doc/";
			String doc_file = docPath+id+".doc";
			File docPath_ = new File(docPath);
			if(!docPath_.exists()){
				docPath_.mkdirs();
			}
			String pdfPath = report_location+"/pdf/";
			File pdfPath_ = new File(pdfPath);
			if(!pdfPath_.exists()){
				pdfPath_.mkdirs();
			}
			String pdf_file = pdfPath+id+".pdf";
			
			//doc image resource
//			JSONObject images = new JSONObject();
//			images.put("selected", ImageUtils.getClassPageImage("/template/image/selected.png"));
//			images.put("unselected", ImageUtils.getClassPageImage("/template/image/unselected.png"));
//			images.put("selected_error", ImageUtils.getClassPageImage("/template/image/selected_error.png"));
//			images.put("selected_good", ImageUtils.getClassPageImage("/template/image/selected_good.png"));
//			images.put("selected_info", ImageUtils.getClassPageImage("/template/image/selected_info.png"));
//			images.put("selected_wanring", ImageUtils.getClassPageImage("/template/image/selected_wanring.png"));
//			data.put("images", images);
//			Locale local = Locale.getDefault();
//			String lan = local.getLanguage();
//			System.err.println(lan);
//			System.err.println(sb.toString());
			FreeMarkers.renderToFile(sb.toString(), data, doc_file);
			//PdfUtil.word2Pdf(new FileInputStream(doc_file),pdf_file);
			DocUtil.exportDocToPDF(doc_file, pdf_file);
//			FreeMarkers.pdfHandler(html_file,pdf_file);
			System.out.println("生成html和pdf文档ok!");
//			FreeMarkers.writeHtmlToPdf1(html_file, pdf_file);
			//FreeMarkers.writeStringToPdf(sb.toString(),pdf_file);
//			PDFUtils.exportToPdfBox(html_file, pdf_file);
			vo.setCode(BaseVO.CODE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setCode(BaseVO.CODE_ERROR);
		}
		return vo;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		reportService.saveReport(param);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	@RequestMapping(value = "get/echarts", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get_echarts(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String customerId = param.getString("customerId");
		vo.setCode(BaseVO.CODE_SUCCESS);
		List<ReportCustomerFinancial> reportCustomerFinancials = reportCustomerFinancialService.getLast12MonethEcharts(customerId);
		JSONObject result = new JSONObject();
		JSONArray xAxis = new JSONArray();
		JSONArray incDecSalePerMonth = new JSONArray();
		JSONArray incDecSaleRate = new JSONArray();
		
		String lastYear ="";
		double preIncDecSale = 0;
		for(int i=reportCustomerFinancials.size()-1;i>=0;i--){
			try {
				ReportCustomerFinancial item = reportCustomerFinancials.get(i);
				String year = DateUtils.formatDate(item.getCreateDate(), "yyyy");
				if(year.equalsIgnoreCase(lastYear)){
					xAxis.add(DateUtils.formatDate(item.getCreateDate(), "MM月"));
				}else{
					xAxis.add(DateUtils.formatDate(item.getCreateDate(), "yyyy年MM月"));
					lastYear = year;
				}
				double cur = Double.parseDouble(item.getCustomerFinaceIncDecSaleCur());
				incDecSalePerMonth.add(cur);
				if(i==(reportCustomerFinancials.size()-1)){
					incDecSaleRate.add(0);
				}else{
					incDecSaleRate.add((cur-preIncDecSale)/preIncDecSale);
				}
				preIncDecSale = cur;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result.put("incDecSalePerMonth", incDecSalePerMonth);
		result.put("incDecSaleRate", incDecSaleRate);
		result.put("xAxis", xAxis);
		vo.setData(result);
		return vo;
	}

}