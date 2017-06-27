/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">fyjf</a> All rights reserved.
 */
package com.fyjf.modules.sys.utils;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.fyjf.common.persistence.Page;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.config.Global;
import com.fyjf.common.security.Digests;
import com.fyjf.common.security.shiro.session.SessionDAO;
import com.fyjf.common.service.BaseService;
import com.fyjf.common.service.ServiceException;
import com.fyjf.common.utils.CacheUtils;
import com.fyjf.common.utils.Encodes;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.common.web.Servlets;
import com.fyjf.modules.menu.dao.MenuDao;
import com.fyjf.modules.menu.entity.Menu;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.role.dao.RoleDao;
import com.fyjf.modules.role.entity.Role;
import com.fyjf.modules.sys.security.SystemAuthorizingRealm;
import com.fyjf.modules.sys.utils.LogUtils;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.dao.UserDao;
import com.fyjf.modules.user.dao.UserOfficeDao;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.user.entity.UserOffice;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author renweiwei
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService extends BaseService implements InitializingBean {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private SessionDAO sessionDao;
	@Autowired
	private SystemAuthorizingRealm systemRealm;
	
	@Autowired
	private UserOfficeDao userOfficeDao;
	
	public SessionDAO getSessionDao() {
		return sessionDao;
	}

	

	//-- User Service --//
	
	/**
	 * 获取用户
	 * @param id: 用户id
	 * @return
	 */
	public User getUser(String id) {
		return UserUtils.get(id);
	}

	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return
	 */
	public User getUserByAccount(String account) {
		return UserUtils.getByAccount(account);
	}
	

	public User getUserById(String uid) {
		return UserUtils.get(uid);
	}
	
	

	
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}
	
	/**
	 * 获得活动会话
	 * @return
	 */
	public Collection<Session> getActiveSessions(){
		return sessionDao.getActiveSessions(false);
	}
	

	////////////////////////////////////////////////////////////////
	public List<Menu> getUserMenus(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	///////////////////////////////////////////////////////////////
	

	
	
	/**
	 * 获取Key加载信息
	 */
	public static boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 "+Global.getConfig("productName")+"  - Powered By "+Global.getConfig("productAuthor")+"\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}



	
	
	///////////////// Synchronized to the Activiti //////////////////
	
	
}
