package com.fyjf.common.utils;

import com.alibaba.fastjson.JSONObject;

public class PageUtils {
	
	public static void processPageParam(JSONObject param){
		if(param!=null&&param.containsKey("pageSize")&&param.containsKey("pageNo")){
			int pageSize = param.getIntValue("pageSize");
			int pageNo = param.getIntValue("pageNo");
			param.put("offset", pageNo*pageSize);//limit #{offset}, #{limit}
			param.put("limit", pageSize);
			param.remove("pageSize");
			param.remove("pageNo");
		}		
	}

}
