/**
 * Copyright &copy; 
 */
package com.fyjf.modules.office.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.app.entity.AppVersion;
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.customer.entity.Customer;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.office.service.OfficeService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 组织结构Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/office/")
public class OfficeController extends BaseController {

	@Autowired
	private OfficeService officeService;
	
	
	
	
	@RequestMapping(value = "list/bank/office", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO bank_list_office(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(tree("0",param.getString("bankId")));
		return vo;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		Office office = new Office();
		office.setCompany(new Company(companyId));
		Page page = new Page<Office>(param.getIntValue("pageNo"),param.getIntValue("pageSize"));
		vo.setData(officeService.findPage(page, office));
		return vo;
	}


	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		Office office = new Office();
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		office.setCompany(new Company(companyId));
		String pId = param.getString("pId");
		if(!org.springframework.util.StringUtils.isEmpty(pId)){
			office.setParent(new Office(pId));
		}		
		office.setName(param.getString("name"));
		officeService.save(office);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}

	/**
	 * [{
		name: '父节点2（可以点左侧箭头，也可以双击标题）'
		,children: [{
		  name: '子节点21'
		  ,children: [{
			name: '子节点211'
		  }]
		}]
	  }]
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public BaseVO treeData(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		List<Map<String, Object>> mapList = tree("0",companyId);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(mapList);
		return vo;
	}
	
	private List<Map<String, Object>> tree(String pId,String companyId){		
		List<Map<String, Object>> mapList = Lists.newArrayList();
		Office office = new Office();
		office.setParent(new Office(pId));
		office.setCompany(new Company(companyId));
		List<Office> list = officeService.findList(office);
		for (int i=0; i<list.size(); i++){
			Office e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", e.getName());
			map.put("children", tree(e.getId(),companyId));
			mapList.add(map);
		}
		return mapList;
	}
	
	
	
}