/**
 * Copyright &copy; 
 */
package com.fyjf.modules.office.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.office.dao.OfficeDao;

/**
 * 组织结构Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class OfficeService extends TreeService<OfficeDao, Office> {

	public Office get(String id) {
		return super.get(id);
	}
	
	public List<Office> findList(Office office) {
		if (StringUtils.isNotBlank(office.getParentIds())){
			office.setParentIds(","+office.getParentIds()+",");
		}
		return super.findList(office);
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
	}
	
	@Transactional(readOnly = false)
	public void delete(Office office) {
		super.delete(office);
	}



	
	
}