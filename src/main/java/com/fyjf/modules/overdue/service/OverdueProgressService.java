/**
 * Copyright &copy;
 */
package com.fyjf.modules.overdue.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.overdue.entity.OverdueProgress;
import com.fyjf.modules.overdue.dao.OverdueProgressDao;

/**
 * 逾期报告进度Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-27
 */
@Service
@Transactional(readOnly = true)
public class OverdueProgressService extends CrudService<OverdueProgressDao, OverdueProgress> {

	public OverdueProgress get(String id) {
		return super.get(id);
	}
	
	public List<OverdueProgress> findList(OverdueProgress overdueProgress) {
		return super.findList(overdueProgress);
	}
	
	public Page<OverdueProgress> findPage(Page<OverdueProgress> page, OverdueProgress overdueProgress) {
		return super.findPage(page, overdueProgress);
	}
	
	@Transactional(readOnly = false)
	public void save(OverdueProgress overdueProgress) {
		super.save(overdueProgress);
	}
	
	@Transactional(readOnly = false)
	public void delete(OverdueProgress overdueProgress) {
		super.delete(overdueProgress);
	}
	
}