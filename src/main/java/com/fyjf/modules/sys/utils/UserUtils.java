/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
 */
package com.fyjf.modules.sys.utils;

import java.util.List;

import com.fyjf.common.service.BaseService;
import com.fyjf.common.utils.CacheUtils;
import com.fyjf.common.utils.SpringContextHolder;
import com.fyjf.modules.area.dao.AreaDao;
import com.fyjf.modules.company.dao.CompanyDao;
import com.fyjf.modules.menu.dao.MenuDao;
import com.fyjf.modules.menu.entity.Menu;
import com.fyjf.modules.office.dao.OfficeDao;
import com.fyjf.modules.role.dao.RoleDao;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.sys.security.SystemAuthorizingRealm;
import com.fyjf.modules.user.dao.UserDao;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.user.service.UserOfficeService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * 用户工具类
 * @author renweiwei
 * @version 2013-12-05
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);
	private static CompanyDao companyDao = SpringContextHolder.getBean(CompanyDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	
	
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	public static final String CACHE_OFFICE_LIST_ = "CACHE_OFFICE_LIST_";
	
	public static final String CACHE_ROLE_ALL_LIST = "CACHE_ROLE_ALL_LIST";
	public static final String CACHE_ROLE_LIST_ = "CACHE_ROLE_LIST_";
	
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_MENU_LIST_ = "CACHE_MENU_LIST_";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			
//			user.setOffice(officeDao.findUserOfficeByUserId(user.getId()));
//			if(user.getOffice()!=null){
//				user.setCompany(companyDao.findUserCompanyByUserOfficeId(user.getOffice().getId()));
//			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getAccount(), user);
		}
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByAccount(String account){
		User user = (User)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + account);
		if (user == null){
			
			user = userDao.getByAccount(account);
			if (user == null){
				return null;
			}
			
//			user.setOffice(officeDao.findUserOfficeByUserId(user.getId()));
//			if(user.getOffice()!=null){
//				user.setCompany(companyDao.findUserCompanyByUserOfficeId(user.getOffice().getId()));
//			}			
			//设置菜单  菜单这里是静态菜单
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + account, user);
		}
		return user;
	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(User user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getAccount());
	}
	
	public static void updateUserCache(User user){
		CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
		CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getAccount(), user);
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		SystemAuthorizingRealm.Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static SystemAuthorizingRealm.Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}
	
	
	
	
}
