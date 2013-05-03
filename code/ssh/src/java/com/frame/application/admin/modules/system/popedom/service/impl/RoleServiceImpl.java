package com.frame.application.admin.modules.system.popedom.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.application.admin.modules.system.popedom.service.RoleService;
import com.frame.core.base.service.impl.BaseServiceImpl;
/**
 * 角色业务接口实现
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	
}
