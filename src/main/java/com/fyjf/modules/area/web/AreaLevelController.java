/**
 * Copyright &copy; 
 */
package com.fyjf.modules.area.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.fyjf.common.config.Global;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.area.entity.AreaLevel;
import com.fyjf.modules.area.service.AreaLevelService;

/**
 * 区域级别Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/area/areaLevel")
public class AreaLevelController extends BaseController {

	@Autowired
	private AreaLevelService areaLevelService;
	
	@ModelAttribute
	public AreaLevel get(@RequestParam(required=false) String id) {
		AreaLevel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = areaLevelService.get(id);
		}
		if (entity == null){
			entity = new AreaLevel();
		}
		return entity;
	}
	
	@RequiresPermissions("area:areaLevel:view")
	@RequestMapping(value = {""})
	public String index(AreaLevel areaLevel, Model model) {
		return "modules/area/areaLevelIndex";
	}
	
	@RequiresPermissions("area:areaLevel:view")
	@RequestMapping(value = {"list"})
	public String list(AreaLevel areaLevel, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<AreaLevel> list = areaLevelService.findList(areaLevel); 
		model.addAttribute("list", list);
		return "modules/area/areaLevelList";
	}

	@RequiresPermissions("area:areaLevel:view")
	@RequestMapping(value = "form")
	public String form(AreaLevel areaLevel, Model model) {
		if (areaLevel.getParent()!=null && StringUtils.isNotBlank(areaLevel.getParent().getId())){
			areaLevel.setParent(areaLevelService.get(areaLevel.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(areaLevel.getId())){
				AreaLevel areaLevelChild = new AreaLevel();
				areaLevelChild.setParent(new AreaLevel(areaLevel.getParent().getId()));
				List<AreaLevel> list = areaLevelService.findList(areaLevel); 
				if (list.size() > 0){
					areaLevel.setSort(list.get(list.size()-1).getSort());
					if (areaLevel.getSort() != null){
						areaLevel.setSort(areaLevel.getSort() + 30);
					}
				}
			}
		}
		if (areaLevel.getSort() == null){
			areaLevel.setSort(30);
		}
		model.addAttribute("areaLevel", areaLevel);
		return "modules/area/areaLevelForm";
	}

	@RequiresPermissions("area:areaLevel:edit")
	@RequestMapping(value = "save")
	public String save(AreaLevel areaLevel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, areaLevel)){
			return form(areaLevel, model);
		}
		areaLevelService.save(areaLevel);
		addMessage(redirectAttributes, "保存区域级别成功");
		return "redirect:"+Global.getAdminPath()+"/area/areaLevel/list?repage";
	}
	
	@RequiresPermissions("area:areaLevel:edit")
	@RequestMapping(value = "delete")
	public String delete(AreaLevel areaLevel, RedirectAttributes redirectAttributes) {
		areaLevelService.delete(areaLevel);
		addMessage(redirectAttributes, "删除区域级别成功");
		return "redirect:"+Global.getAdminPath()+"/area/areaLevel/list?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<AreaLevel> list = areaLevelService.findList(new AreaLevel());
		for (int i=0; i<list.size(); i++){
			AreaLevel e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}