/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
 */
package com.fyjf.modules.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyjf.common.servlet.ValidateCodeServlet;
import com.fyjf.common.utils.IdGen;
import com.fyjf.common.web.BaseController;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.security.shiro.session.SessionDAO;
import com.fyjf.common.utils.CacheUtils;
import com.fyjf.common.utils.CookieUtils;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.sys.security.FormAuthenticationFilter;
import com.fyjf.modules.sys.security.SystemAuthorizingRealm;
import com.fyjf.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.fyjf.modules.sys.security.UsernamePasswordToken;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.user.service.UserService;
import com.fyjf.vo.BaseVO;

/**
 * 登录Controller
 * 
 * @author renweiwei
 * @version 2017-5-31
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private UserService userService;

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO login(@RequestBody JSONObject param, HttpServletRequest request, HttpServletResponse response) {
		BaseVO vo = new BaseVO();
		String msg = "";
		String account = param.getString("account");
		String password = param.getString("passwd");
		boolean rememberMe = true;
		String host = StringUtils.getRemoteAddr((HttpServletRequest)request);		
		UsernamePasswordToken token = new UsernamePasswordToken(account, password.toCharArray(), rememberMe, host);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {//ModularRealmAuthenticator//DefaultSecurityManager
			subject.login(token);
			if (subject.isAuthenticated()) {
				vo.setCode(BaseVO.CODE_SUCCESS);
				JSONObject data = new JSONObject();
				SystemAuthorizingRealm.Principal principal = (Principal) subject.getPrincipal();
//				CookieUtils.setCookie(response, "id", principal.getId());
//				CookieUtils.setCookie(response, "userName", principal.getName());
//				CookieUtils.setCookie(response, "officeId", principal.getOfficeId());
//				CookieUtils.setCookie(response, "officeName", principal.getOfficeName());
//				CookieUtils.setCookie(response, "companyId", principal.getCompanyId());
//				CookieUtils.setCookie(response, "companyName", principal.getCompanyName());
				vo.setData(principal);
			} else {
				vo.setCode(BaseVO.CODE_LOGIN_ERROR);
				msg = "未登录";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！";
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		}
		vo.setMsg(msg); 
		return vo;
	}

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@RequestMapping(value = "${adminPath}/login/success", method = RequestMethod.POST)
	public void loginSuccess(@RequestBody JSONObject param, HttpServletRequest request, HttpServletResponse response,
			Model model) {

	}
	
	@RequestMapping(value = "${adminPath}/login/v2", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO app_login(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		if(userService.validateUserByAccout(param.getString("account"),param.getString("passwd"))){
			vo.setCode(BaseVO.CODE_SUCCESS);
		}else{
			vo.setCode(BaseVO.CODE_LOGIN_ERROR);
		}
		return vo;
	}
}
