package com.frame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.common.service.BaseServiceImpl;
import com.frame.dao.RoleDao;
import com.frame.service.RoleService;
/**
 * 角色业务接口实现
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
}
