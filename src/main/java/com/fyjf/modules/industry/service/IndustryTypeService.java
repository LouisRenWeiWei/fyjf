/**
 * Copyright &copy; 
 */
package com.fyjf.modules.industry.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.industry.dao.IndustryTypeDao;

/**
 * 企业类型Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class IndustryTypeService extends TreeService<IndustryTypeDao, IndustryType> {

	public IndustryType get(String id) {
		return super.get(id);
	}
	
	public List<IndustryType> findList(IndustryType industryType) {
		if (StringUtils.isNotBlank(industryType.getParentIds())){
			industryType.setParentIds(","+industryType.getParentIds()+",");
		}
		return super.findList(industryType);
	}
	
	@Transactional(readOnly = false)
	public void save(IndustryType industryType) {
		super.save(industryType);
	}
	
	@Transactional(readOnly = false)
	public void delete(IndustryType industryType) {
		super.delete(industryType);
	}

	public List<IndustryType> findListDisplay(IndustryType industry) {
		// TODO Auto-generated method stub
		return dao.findListDisplay(industry);
	}
	
}