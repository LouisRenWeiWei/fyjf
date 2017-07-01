/**
 * Copyright &copy; 
 */
package com.fyjf.modules.role.web;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.app.entity.AppVersion;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.role.entity.RoleMenu;
import com.fyjf.modules.role.service.RoleMenuService;
import com.fyjf.modules.role.service.RoleService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 角色Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/role/")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		Role role = new Role();
		role.setCompany(new Company(companyId));
		Page page = new Page<Role>(param.getIntValue("pageNo"),param.getIntValue("pageSize"));
		vo.setData(roleService.findPage(page, role));
		
		return vo;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		roleService.saveRoleData(param);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public BaseVO delete(Role role) {
		roleService.delete(role);
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}

}