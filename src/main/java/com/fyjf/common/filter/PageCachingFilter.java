/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
 */
package com.fyjf.common.filter;

import com.fyjf.common.utils.CacheUtils;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * 页面高速缓存过滤器
 * @author renweiwei
 * @version 2013-8-5
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	@Override
	protected CacheManager getCacheManager() {
		return CacheUtils.getCacheManager();
	}
	
}
