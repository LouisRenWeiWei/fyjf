/**
 * Copyright &copy; 
 */
package com.fyjf.modules.loadtype.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.loadtype.entity.LoanType;
import com.fyjf.modules.loadtype.dao.LoanTypeDao;

/**
 * 信贷品种类型Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-18
 */
@Service
@Transactional(readOnly = true)
public class LoanTypeService extends TreeService<LoanTypeDao, LoanType> {

	public LoanType get(String id) {
		return super.get(id);
	}
	
	public List<LoanType> findList(LoanType loanType) {
		if (StringUtils.isNotBlank(loanType.getParentIds())){
			loanType.setParentIds(","+loanType.getParentIds()+",");
		}
		return super.findList(loanType);
	}
	
	@Transactional(readOnly = false)
	public void save(LoanType loanType) {
		super.save(loanType);
	}
	
	@Transactional(readOnly = false)
	public void delete(LoanType loanType) {
		super.delete(loanType);
	}
	
}