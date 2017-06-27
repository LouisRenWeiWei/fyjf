/**
 * Copyright &copy; 
 */
package com.fyjf.modules.user.dao;

import java.util.List;
import java.util.Map;

import com.fyjf.common.persistence.CrudDao;
import com.fyjf.common.persistence.annotation.MyBatisDao;
import com.fyjf.modules.user.entity.User;

/**
 * 用户DAO接口
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {

	User getByAccount(String account);

	
}