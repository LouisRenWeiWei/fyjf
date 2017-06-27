/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fyjf.common.service.TreeService;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.area.dao.AreaDao;

/**
 * 区域Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {

	public Area get(String id) {
		return super.get(id);
	}
	
	public List<Area> findList(Area area) {
		if (StringUtils.isNotBlank(area.getParentIds())){
			area.setParentIds(","+area.getParentIds()+",");
		}
		return super.findList(area);
	}
	
	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
	}
	
}