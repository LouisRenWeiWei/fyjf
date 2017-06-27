/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.web;

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
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.office.service.OfficeService;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.role.service.RoleService;
import com.fyjf.modules.sys.utils.SystemService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.user.entity.UserOffice;
import com.fyjf.modules.user.entity.UserRole;
import com.fyjf.modules.user.service.UserOfficeService;
import com.fyjf.modules.user.service.UserRoleService;
import com.fyjf.modules.user.service.UserService;
import com.fyjf.vo.BaseVO;

/**
 * 用户Controller
 * @author 任伟伟  
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/user/")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private OfficeService officeSerivce;
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserOfficeService userOfficeService;
	
	@RequestMapping(value = "get/current", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get_current() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(UserUtils.getUser());
		return vo;
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		User user = new User();
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		user.setCompany(new Company(companyId));
		vo.setData(userService.findList(user));
		return vo;
	}
	
	
	@RequestMapping(value = "list/by/office", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list_office_users(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		User user = new User();
		user.setOffice(officeSerivce.get(param.getString("officeId")));
		vo.setData(userService.findList(user));
		return vo;
	}
	

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		User user = JSONObject.toJavaObject(param, User.class);
		if(StringUtils.isEmpty(user.getPasswd()))user.setPasswd("123456");
		user.setPasswd(SystemService.entryptPassword(user.getPasswd()));
		userService.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRoleId(param.getString("roleId"));
		userRoleService.save(userRole);
		
		UserOffice userOffice = new UserOffice();
		userOffice.setUser(user);		
		String companyId = param.getString("companyId");
		if(org.springframework.util.StringUtils.isEmpty(companyId))companyId= UserUtils.getUser().getCompany().getId();
		userOffice.setCompany(new Company(companyId));
		userOffice.setOffice(new Office(param.getString("officeId")));
		userOfficeService.save(userOffice);
		
		
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
}