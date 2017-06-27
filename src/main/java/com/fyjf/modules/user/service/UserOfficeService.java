/**
 * Copyright &copy;
 */
package com.fyjf.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.user.entity.UserOffice;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.user.dao.UserOfficeDao;

/**
 * 用户组织Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class UserOfficeService extends CrudService<UserOfficeDao, UserOffice> {

	public UserOffice get(String id) {
		return super.get(id);
	}
	
	public List<UserOffice> findList(UserOffice userOffice) {
		return super.findList(userOffice);
	}
	
	public Page<UserOffice> findPage(Page<UserOffice> page, UserOffice userOffice) {
		return super.findPage(page, userOffice);
	}
	
	@Transactional(readOnly = false)
	public void save(UserOffice userOffice) {
		super.save(userOffice);
	}
	
	@Transactional(readOnly = false)
	public void delete(UserOffice userOffice) {
		super.delete(userOffice);
	}
}