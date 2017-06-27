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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.area.entity.Area;
import com.fyjf.modules.area.service.AreaService;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.vo.BaseVO;

/**
 * 区域Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/area/")
public class AreaController extends BaseController {

	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public Area get(@RequestParam(required=false) String id) {
		Area entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = areaService.get(id);
		}
		if (entity == null){
			entity = new Area();
		}
		return entity;
	}
	
	@RequiresPermissions("area:area:view")
	@RequestMapping(value = {""})
	public String index(Area area, Model model) {
		return "modules/area/areaIndex";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO area_list() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		Area area =  new Area();
		area.setLevel(3);
		vo.setData(areaService.findList(area));
		return vo;
	}

	@RequiresPermissions("area:area:view")
	@RequestMapping(value = "form")
	public String form(Area area, Model model) {
		if (area.getParent()!=null && StringUtils.isNotBlank(area.getParent().getId())){
			area.setParent(areaService.get(area.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(area.getId())){
				Area areaChild = new Area();
				areaChild.setParent(new Area(area.getParent().getId()));
				List<Area> list = areaService.findList(area); 
				if (list.size() > 0){
					area.setSort(list.get(list.size()-1).getSort());
					if (area.getSort() != null){
						area.setSort(area.getSort() + 30);
					}
				}
			}
		}
		if (area.getSort() == null){
			area.setSort(30);
		}
		model.addAttribute("area", area);
		return "modules/area/areaForm";
	}

	@RequiresPermissions("area:area:edit")
	@RequestMapping(value = "save")
	public String save(Area area, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, area)){
			return form(area, model);
		}
		areaService.save(area);
		addMessage(redirectAttributes, "保存区域成功");
		return "redirect:"+Global.getAdminPath()+"/area/area/list?repage";
	}
	
	@RequiresPermissions("area:area:edit")
	@RequestMapping(value = "delete")
	public String delete(Area area, RedirectAttributes redirectAttributes) {
		areaService.delete(area);
		addMessage(redirectAttributes, "删除区域成功");
		return "redirect:"+Global.getAdminPath()+"/area/area/list?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findList(new Area());
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
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