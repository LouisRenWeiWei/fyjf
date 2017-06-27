/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
 */
package com.fyjf.modules.sys.security;

/**
 * 用户和密码（包含验证码）令牌类
 * @author renweiwei
 * @version 2013-5-19
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	
	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, char[] password,boolean rememberMe, String host) {
		super(username, password, rememberMe, host);
	}
	
}