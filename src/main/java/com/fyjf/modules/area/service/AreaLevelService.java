/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.area.entity.AreaLevel;
import com.fyjf.modules.area.dao.AreaLevelDao;

/**
 * 区域级别Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class AreaLevelService extends TreeService<AreaLevelDao, AreaLevel> {

	public AreaLevel get(String id) {
		return super.get(id);
	}
	
	public List<AreaLevel> findList(AreaLevel areaLevel) {
		if (StringUtils.isNotBlank(areaLevel.getParentIds())){
			areaLevel.setParentIds(","+areaLevel.getParentIds()+",");
		}
		return super.findList(areaLevel);
	}
	
	@Transactional(readOnly = false)
	public void save(AreaLevel areaLevel) {
		super.save(areaLevel);
	}
	
	@Transactional(readOnly = false)
	public void delete(AreaLevel areaLevel) {
		super.delete(areaLevel);
	}
	
}