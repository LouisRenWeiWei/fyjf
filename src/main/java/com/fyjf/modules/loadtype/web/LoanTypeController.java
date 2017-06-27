/**
 * Copyright &copy; 
 */
package com.fyjf.modules.loadtype.web;

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
import com.opensymphony.module.sitemesh.Page;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.common.web.BaseController;
import com.fyjf.common.utils.PageUtils;
import com.fyjf.common.utils.StringUtils;
import com.fyjf.modules.industry.entity.IndustryType;
import com.fyjf.modules.loadtype.entity.LoanType;
import com.fyjf.modules.loadtype.service.LoanTypeService;
import com.fyjf.modules.sys.utils.UserUtils;
import com.fyjf.modules.user.entity.User;
import com.fyjf.vo.BaseVO;

/**
 * 信贷品种类型Controller
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-18
 */
@Controller
@RequestMapping(value = "${adminPath}/loadtype")
public class LoanTypeController extends BaseController {

	@Autowired
	private LoanTypeService loanTypeService;
	
	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO get(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String id = param.getString("id");
		LoanType loanType = loanTypeService.get(id);
		vo.setCode(BaseVO.CODE_SUCCESS);
		vo.setData(loanType);
		return vo;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO save(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		String id = param.getString("id");
		String name = param.getString("name");
		String remarks = param.getString("remarks");
		LoanType loanType = new LoanType();
		loanType.setId(id);
		loanType.setName(name);
		loanTypeService.save(loanType);
		vo.setCode(BaseVO.CODE_SUCCESS);
		return vo;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO list(@RequestBody JSONObject param) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_SUCCESS);
		LoanType loanType =  new LoanType();
		//loanType.setPage(JSONObject.toJavaObject(param, Page.class));
		vo.setData(loanTypeService.findList(loanType));
		return vo;
	}
	
	
	@RequiresPermissions("loadtype:loanType:edit")
	@RequestMapping(value = "delete")
	public String delete(LoanType loanType, RedirectAttributes redirectAttributes) {
		loanTypeService.delete(loanType);
		addMessage(redirectAttributes, "删除信贷品种类型成功");
		return "redirect:"+Global.getAdminPath()+"/loadtype/loanType/list?repage";
	}


	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<LoanType> list = loanTypeService.findList(new LoanType());
		for (int i=0; i<list.size(); i++){
			LoanType e = list.get(i);
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