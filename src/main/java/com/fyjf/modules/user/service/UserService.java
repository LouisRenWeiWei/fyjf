/**
 * Copyright &copy;
 */
package com.fyjf.modules.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.user.entity.User;
import com.fyjf.modules.sys.utils.SystemService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.dao.UserDao;

/**
 * 用户Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User> {

	public User get(String id) {
		return super.get(id);
	}
	
	public List<User> findList(User user) {
		return super.findList(user);
	}
	
	public Page<User> findPage(Page<User> page, User user) {
		return super.findPage(page, user);
	}
	
	@Transactional(readOnly = false)
	public void save(User user) {
		super.save(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(User user) {
		super.delete(user);
	}

	public boolean validateUserByAccout(String account, String passwd) {
		// TODO Auto-generated method stub
		User user = UserUtils.getByAccount(account);
		if(user!=null){
			if(SystemService.validatePassword(passwd, user.getPasswd())){
				return true;
			}
		}
		return false;
	}
	
}