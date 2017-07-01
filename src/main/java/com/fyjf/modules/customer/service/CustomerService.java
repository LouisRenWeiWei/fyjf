/**
 * Copyright &copy;
 */
package com.fyjf.modules.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.fyjf.common.persistence.Page;
import com.fyjf.common.service.CrudService;
import com.fyjf.modules.customer.entity.Customer;
import com.fyjf.modules.industry.service.IndustryTypeService;
import com.fyjf.modules.customer.dao.CustomerDao;

/**
 * 客户Service
 * @author 任伟伟
 * granted by renweiwei 18511582867
 * @version 2017-06-01
 */
@Service
@Transactional(readOnly = true)
public class CustomerService extends CrudService<CustomerDao, Customer> {
	
	

	public Customer get(String id) {
		Customer result= super.get(id);
		
		return result;
	}
	
	public List<Customer> findList(Customer customer) {
		return super.findList(customer);
	}
	
	public Page<Customer> findPage(Page<Customer> page, Customer customer) {
		return super.findPage(page, customer);
	}
	
	@Transactional(readOnly = false)
	public void save(Customer customer) {
		super.save(customer);
	}
	
	@Transactional(readOnly = false)
	public void delete(Customer customer) {
		super.delete(customer);
	}

	public List<Map<String,Object>> findListByApp(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return dao.findListByApp(param);
	}
	
}