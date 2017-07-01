/**
 * Copyright &copy; 
 */
package com.fyjf.modules.menu.web;

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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.company.service.CompanyService;
import com.fyjf.modules.customer.entity.Customer;
import com.fyjf.modules.customer.service.CustomerService;
import com.fyjf.modules.loadtype.entity.LoanType;
import com.fyjf.modules.menu.entity.Menu;
import com.fyjf.modules.menu.service.MenuService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 菜单Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/menu/")
public class MenuController extends BaseController {

	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private MenuService menuService;


	/**
	 * 根据用户所在的公司设置用户的菜单
	 * @param extId
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "treeData")
	@ResponseBody
	public BaseVO treeData() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Menu> list = menuService.findList(new Menu());
		for (int i=0; i<list.size(); i++){
			Menu e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", e.getName());
			map.put("open", true);
			mapList.add(map);
		}
		vo.setData(mapList);
		return vo;
	}
	
	/**
	 * 查询富源金服用户对应权限的菜单
	 * 根据富源金服的员工职位生成相应的权限
	 * 普通员工权限：
	 * 
	 * [
		{
			"title": "富源金服",
			"icon": "fa-cubes",
			"spread": true,
			"children": [
				{
					"title": "我的客户",
					"href": "fyjf/customer/list.html"
				}
			]
		}
	]
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "mine", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO mine_menu() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		JSONArray data = new JSONArray();
		User user = UserUtils.getUser();
		//查询权限下的公司菜单
		//查询权限下的银行，生成对应的菜单,银行菜单加上银行id（在管理平台需要根据银行添加员工和部门）
		//富源金服菜单
		JSONObject fyjfItem = new JSONObject();
		fyjfItem.put("title", "富源金服");
		fyjfItem.put("icon", "fa-cubes");
		fyjfItem.put("spread", true);//默认展开富源金服这个菜单,别的都关闭
		JSONArray fyjfChildren = new JSONArray();
		
		JSONObject fyjfChildrenItem1 = new JSONObject();		
		fyjfChildrenItem1.put("title", "我的客户");
		fyjfChildrenItem1.put("href", "fyjf/customer/list.html");
		fyjfChildren.add(fyjfChildrenItem1);
		
		JSONObject fyjfChildrenItem2 = new JSONObject();
		fyjfChildrenItem2.put("title", "企业管理");
		fyjfChildrenItem2.put("href", "fyjf/enterprise/list.html");
		fyjfChildren.add(fyjfChildrenItem2);
		
//		JSONObject fyjfChildrenItem3 = new JSONObject();
//		fyjfChildrenItem3.put("title", "我的客户");
//		fyjfChildrenItem3.put("href", "fyjf/customer/list.html");
//		fyjfChildren.add(fyjfChildrenItem3);
		
		JSONObject fyjfChildrenItem4 = new JSONObject();
		fyjfChildrenItem4.put("title", "员工管理");
		fyjfChildrenItem4.put("href", "fyjf/employee/list.html");
		fyjfChildren.add(fyjfChildrenItem4);
		
		
		JSONObject fyjfChildrenItem10 = new JSONObject();
		fyjfChildrenItem10.put("title", "部门管理");
		fyjfChildrenItem10.put("href", "fyjf/office/list.html");
		fyjfChildren.add(fyjfChildrenItem10);
		
		JSONObject fyjfChildrenItem5 = new JSONObject();
		fyjfChildrenItem5.put("title", "职位管理");
		fyjfChildrenItem5.put("href", "fyjf/role/list.html");
		fyjfChildren.add(fyjfChildrenItem5);
		
		JSONObject fyjfChildrenItem6 = new JSONObject();
		fyjfChildrenItem6.put("title", "代理银行管理");
		fyjfChildrenItem6.put("href", "fyjf/proxy/list.html");
		fyjfChildren.add(fyjfChildrenItem6);
		
		JSONObject fyjfChildrenItem7 = new JSONObject();
		fyjfChildrenItem7.put("title", "行业管理");
		fyjfChildrenItem7.put("href", "fyjf/industry/list.html");
		fyjfChildren.add(fyjfChildrenItem7);
		
		JSONObject fyjfChildrenItem8 = new JSONObject();
		fyjfChildrenItem8.put("title", "信贷品种");
		fyjfChildrenItem8.put("href", "fyjf/xindai/list.html");
		fyjfChildren.add(fyjfChildrenItem8);
		
		JSONObject fyjfChildrenItem9 = new JSONObject();
		fyjfChildrenItem9.put("title", "系统设置");
		fyjfChildrenItem9.put("href", "fyjf/fyjf.html");
		fyjfChildren.add(fyjfChildrenItem9);
		
		JSONObject fyjfChildrenItem11 = new JSONObject();
		fyjfChildrenItem11.put("title", "APP管理");
		fyjfChildrenItem11.put("href", "fyjf/app/list.html");
		fyjfChildren.add(fyjfChildrenItem11);
		
		fyjfItem.put("children", fyjfChildren);
		
		data.add(fyjfItem);
		
		Company company = new Company();
		company.setId("0");//排查非0的公司
		List<Map<String,Object>> banks = companyService.findBankList(company);
		for(Map<String,Object> b : banks){
			JSONObject customerItem = new JSONObject();
			customerItem.put("title", b.get("name"));
			customerItem.put("icon", "fa-cubes");
			customerItem.put("spread", false);
			JSONArray customerChildren = new JSONArray();
			
			JSONObject customerChildrenItem1 = new JSONObject();		
			customerChildrenItem1.put("title", "员工管理");
			customerChildrenItem1.put("href", "fyjf/employee/list.html?bankId="+b.get("id"));
			customerChildren.add(customerChildrenItem1);
			
			JSONObject customerChildrenItem2 = new JSONObject();	
			customerChildrenItem2.put("title", "部门管理");
			customerChildrenItem2.put("href", "fyjf/office/list.html?bankId="+b.get("id"));
			customerChildren.add(customerChildrenItem2);
			
			JSONObject customerChildrenItem3 = new JSONObject();		
			customerChildrenItem3.put("title", "职位管理");
			customerChildrenItem3.put("href", "fyjf/role/list.html?bankId="+b.get("id"));
			customerChildren.add(customerChildrenItem3);
			
			customerItem.put("children", customerChildren);
			
			data.add(customerItem);
		}
		
		
		
		vo.setData(data);
		
		System.out.println(data.toJSONString());
		return vo;
	}
	
	
	
}