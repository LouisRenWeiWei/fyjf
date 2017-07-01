package com.fyjf.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fyjf.vo.BaseVO;

@Controller
public class ErrorController extends BaseController{
	
	
	
	@RequestMapping(value = {"/", "/index"})
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) {		
		return "hello world";
	}
	
	@RequestMapping(value = {"/error_500", ""})
	@ResponseBody
	public JSONObject error_500(HttpServletRequest request, HttpServletResponse response) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_ERROR);
		return (JSONObject) JSON.toJSON(vo);
	}
	
	@RequestMapping(value = {"/error_400", ""})
	@ResponseBody
	public Object error_400(HttpServletRequest request, HttpServletResponse response) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_ERROR);
		return vo;
	}
	
	@RequestMapping(value = {"/auth_fail", ""})
	@ResponseBody
	public Object auth_fail(HttpServletRequest request, HttpServletResponse response) {
		BaseVO vo = new BaseVO();
		vo.setCode(BaseVO.CODE_AUTH_RROR);
		return vo;
	}
	

}
