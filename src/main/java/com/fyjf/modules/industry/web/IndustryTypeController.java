/**
 * Copyright &copy; 
 */
package com.fyjf.modules.industry.web;

import java.util.HashMap;
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
import com.fyjf.modules.company.entity.Company;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.industry.service.IndustryTypeService;
import com.fyjf.modules.office.entity.Office;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 企业类型Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/industryType/")
public class IndustryTypeController extends BaseController {

	@Autowired
	private IndustryTypeService industryTypeService;
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO industryTypeInfo(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String industryId = param.getString("id");
		IndustryType industryType = industryTypeService.get(industryId);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(industryType);
		return vo;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO industryTypeUpdate(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String industryId = param.getString("id");
		String parentId = param.getString("parentId");
		String code = param.getString("code");
		String name = param.getString("name");
		IndustryType industryType = new IndustryType();
		industryType.setId(industryId);
		industryType.setCode(code);
		industryType.setName(name);
		if(!StringUtils.isEmpty(parentId)){
			industryType.setParent(industryTypeService.get(parentId));
			industryType.setSort(industryType.getSort()+industryType.getParent().getSort());
		}	
		industryTypeService.save(industryType);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(industryType);
		return vo;
	}
	
	

	@RequestMapping(value = "delete")
	public String delete(IndustryType industryType) {
		industryTypeService.delete(industryType);
		return "redirect:"+Global.getAdminPath()+"/industry/industryType/list?repage";
	}
	
//	@RequestMapping(value = "firstLevel", method = RequestMethod.POST)
//	@ResponseBody
//	public BaseVO list_firstLevel() {
//		BaseVO vo = new BaseVO();
//		vo.setCode(BaseVO.CODE_SUCCESS);
//		IndustryType industryType = new IndustryType();
//		industryType.setParent(new IndustryType("0"));
//		vo.setData(industryTypeService.findList(industryType));
//		return vo;
//	}
	
	@RequestMapping(value = "levelByPid", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list_byLevell(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		String id = param.getString("id");
		IndustryType industry =  new IndustryType();
		industry.setParent(new IndustryType(id));
		vo.setData(industryTypeService.findList(industry));
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value = "list/display")
	public BaseVO list_display() {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		IndustryType industry =  new IndustryType();
		industry.setSort(industry.getSort()*3);
		List<IndustryType> list = industryTypeService.findListDisplay(industry);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (int i=0; i<list.size(); i++){
			IndustryType e = list.get(i);
			//e.getParent().setParent(industryTypeService.get("0"));
			e.setParent(industryTypeService.get(e.getParent().getId()));
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", e.getName());
			map.put("code", e.getCode());
			map.put("pName", e.getParent().getName());
			map.put("topName", e.getParent().getParent().getName());
			mapList.add(map);
		}
		vo.setData(mapList);
		return vo;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "treeData")
	public BaseVO treeData() {
		BaseVO vo = new BaseVO();
		IndustryType industryType = new IndustryType();
		industryType.setParent(new IndustryType("0"));
		List<Map<String, Object>> mapList = tree(industryType);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(mapList);
		return vo;
	}
	
	private List<Map<String, Object>> tree(IndustryType industryType){
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<IndustryType> list = industryTypeService.findList(industryType);
		for (int i=0; i<list.size(); i++){
			IndustryType e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", e.getName());
			map.put("spread", true);
			IndustryType temp = new IndustryType();
			temp.setParent(new IndustryType(e.getId()));
			map.put("children", tree(temp));
			mapList.add(map);
		}
		return mapList;
	}
	
}