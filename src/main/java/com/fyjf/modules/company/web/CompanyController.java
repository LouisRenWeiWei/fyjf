/**
 * Copyright &copy; 
 */
package com.fyjf.modules.company.web;

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
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.company.service.CompanyService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 企业Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/company/")
public class CompanyController extends BaseController {

	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO companyInfo(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String userId = param.getString("userId");
		String officeId = param.getString("officeId");
		String companyId = param.getString("companyId");
		User user = UserUtils.getUser();		
		Company company = companyService.get(companyId);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(company);
		return vo;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO companyInfoUpdate(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String userId = param.getString("userId");
		String officeId = param.getString("officeId");
		String companyId = param.getString("companyId");
		User user = UserUtils.getUser();		
		Company company = new Company();
		company.setId(companyId);
		company.setName(param.getString("companyName"));
		company.setCorpid(param.getString("corpid"));
		company.setCorpsecrect(param.getString("corpsecrect"));
		company.setSocialCredit(param.getString("socialCredit"));
		company.setAreaId(param.getString("areaId"));
		if(StringUtils.isEmpty(companyId)){
		}else{
			user.setCompany(company);//
			UserUtils.updateUserCache(user);
		}		
		companyService.save(company);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(company);
		return vo;
	}
	
	
	
	@RequestMapping(value = "list/bank", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO bank_list() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(companyService.findBankList());
		return vo;
	}

	@RequiresPermissions("company:company:view")
	@RequestMapping(value = "form")
	public String form(Company company, Model model) {
		model.addAttribute("company", company);
		return "modules/company/companyForm";
	}

	@RequiresPermissions("company:company:edit")
	@RequestMapping(value = "save")
	public String save(Company company, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, company)){
			return form(company, model);
		}
		companyService.save(company);
		addMessage(redirectAttributes, "保存企业成功");
		return "redirect:"+Global.getAdminPath()+"/company/company/list?repage";
	}
	
	@RequiresPermissions("company:company:edit")
	@RequestMapping(value = "delete")
	public String delete(Company company, RedirectAttributes redirectAttributes) {
		companyService.delete(company);
		addMessage(redirectAttributes, "删除企业成功");
		return "redirect:"+Global.getAdminPath()+"/company/company/list?repage";
	}

}