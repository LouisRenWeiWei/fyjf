package com.fyjf.common.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.config.Global;
import com.fyjf.vo.BaseVO;

@Controller
public class UploadFileController extends BaseController{
	
	@Value("#{APP_PROP['uploadFilePath']}")
	String uploadFilePath;
	
	@RequestMapping(value = "${adminPath}/file/upload", method = RequestMethod.POST)
	@ResponseBody
	public BaseVO upload_file(@RequestParam("file")MultipartFile attach) {
		BaseVO vo = new BaseVO();
		if(attach!=null){
			String oldFileName = attach.getOriginalFilename();
			String newFileName = UUID.randomUUID()+oldFileName.substring(oldFileName.lastIndexOf("."));
			File tempFile = new File(uploadFilePath,newFileName);
	        try {
				attach.transferTo(tempFile);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        JSONObject data = new JSONObject();
	        data.put("src", newFileName);
	        vo.setData(data);
			vo.setCode(BaseVO.CODE_SUCCESS);
		}else{
			vo.setCode(BaseVO.CODE_ERROR);
		}
		
		return vo;
	}
	
}