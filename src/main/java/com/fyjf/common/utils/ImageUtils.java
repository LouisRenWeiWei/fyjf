package com.fyjf.common.utils;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class ImageUtils {
	
	public static String getImage(InputStream in){
		Base64Encoder encoder = new Base64Encoder();
        byte[] data = null;    
        try {
            data = new byte[in.available()];    
            in.read(data);    
            in.close();    
        } catch (Exception e) {
        	e.printStackTrace();
        }finally {    
            if(in != null){    
                try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
            }    
        }
        return encoder.encode(data);
	}
	
	public static String getClassPageImage(String image){
		Resource resource = new ClassPathResource(image); 
		InputStream in = null;
		try {
			in = resource.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return getImage(in);
	}

}
