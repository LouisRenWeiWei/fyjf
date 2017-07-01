/**
 * Copyright &copy; 
 */
package com.fyjf.modules.customer.web;

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
import com.fyjf.modules.app.entity.AppVersion;
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.area.service.AreaService;
import com.fyjf.modules.customer.entity.Customer;
import com.fyjf.modules.customer.service.CustomerService;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.industry.service.IndustryTypeService;
import com.fyjf.modules.loadtype.entity.LoanType;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.user.entity.UserOffice;
import com.fyjf.modules.user.entity.UserRole;
import com.fyjf.vo.BaseVO;

/**
 * 客户Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/customer")
public class CustomerController extends BaseController {

	@Autowired IndustryTypeService industryTypeService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		Customer customer = customerService.get(param.getString("id"));
		if(customer.getIndustryType()!=null){			
			customer.setIndustryType(industryTypeService.get(customer.getIndustryType().getId()));
		}
		vo.setData(customer);
		return vo;
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		Page page = new Page<Customer>(param.getIntValue("pageNo"),param.getIntValue("pageSize"));
		vo.setData(customerService.findPage(page, new Customer()));
		return vo;
	}
	
	@RequestMapping(value = "list/mine", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list_mine(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		Customer customer = new Customer();
		customer.setManagerByUs(UserUtils.getUser());		
		Page page = new Page<Customer>(param.getIntValue("pageNo"),param.getIntValue("pageSize"));
		vo.setData(customerService.findPage(page, customer));
		
		return vo;
	}
	
	//app
	@RequestMapping(value = "list/by/bank/user", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list_by_bank_user(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
//		String account = param.getString("account");
//		int customerState = param.getIntValue("customerState");
//		Customer customer = new Customer();
//		customer.setCustomerState(customerState);
//		customer.setBankOfficeWorker(UserUtils.getByAccount(account));
//		customer.setPage(JSONObject.toJavaObject(param.getJSONObject("page"), Page.class));
		vo.setData(customerService.findListByApp(param));
		return vo;
	}

	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		Customer customer = new Customer();
		if(param.containsKey("id"))customer.setId(param.getString("id"));
		customer.setName(param.getString("name"));
		customer.setCreditCode(param.getString("creditCode"));
		customer.setCustomerState(param.getIntValue("customerState"));
		customer.setAddress(param.getString("address"));
		customer.setTelphone(param.getString("telphone"));
		customer.setManager(param.getString("manager"));
		customer.setMainBusiness(param.getString("mainBusiness"));
		customer.setBankId(param.getString("bankId"));
		if(param.containsKey("bankOfficeId"))customer.setBankOffice(new Office(param.getString("bankOfficeId")));
		if(param.containsKey("areaId"))customer.setArea(new Area(param.getString("areaId")));
		if(param.containsKey("industryTypeId"))customer.setIndustryType(new IndustryType(param.getString("industryTypeId")));
		if(param.containsKey("managerByUs"))customer.setManagerByUs(new User(param.getString("managerByUs")));
		if(param.containsKey("bankOfficeWorker"))customer.setBankOfficeWorker(new User(param.getString("bankOfficeWorker")));
		customerService.save(customer);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public BaseVO delete(Customer customer) {
		customerService.delete(customer);
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}

}