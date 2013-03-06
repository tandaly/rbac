package com.frame.application.admin.modules.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.application.admin.modules.system.service.MenuService;
import com.frame.core.base.service.impl.BaseServiceImpl;
/**
 * 菜单业务接口实现
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {

	
}
