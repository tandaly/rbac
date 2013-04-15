package com.frame.core.base.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.frame.application.admin.modules.system.model.Menu;
import com.frame.application.admin.modules.system.model.Privilege;
import com.frame.application.admin.modules.system.model.Role;
import com.frame.application.admin.modules.system.model.User;
/**
 * 初始化数据库
 * @author Tandaly
 * @date 2013-3-8 下午2:35:30
 */
@Component
public class InitDB {

	@Resource
	private SessionFactory sessionFactory;
	
	@Value("${init.username}")//在system.properties中修改
	private String initUserName; //初始化用户名 
	
	@Value("${init.password}")
	private String initPassword;//初始化密码
	
	
	/**
	 * 初始化数据库表数据
	 */
	public void excute() {
		//修改为create表 TODO
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		try {
			/*********************1.初始化菜单表*****************/
			/////////顶级菜单
			//系统管理菜单
			Menu mSys = new Menu();
			mSys.setParentNo("-1");
			mSys.setMenuNo("1");
			mSys.setMenuName("系统管理");
			mSys.setClick("return false;");
			mSys.setOrderNo(mSys.getMenuNo());
			session.save(mSys);
			
			/////////二级菜单
			//权限管理菜单
			Menu mSysPriv = new Menu();
			mSysPriv.setMenuNo("1001");
			mSysPriv.setParentNo("1");
			mSysPriv.setMenuName("权限管理");
			mSysPriv.setClick("return false;");
			mSysPriv.setOrderNo(mSysPriv.getMenuNo());
			session.save(mSysPriv);
			
			//基础数据维护菜单
			Menu mSysBaseData = new Menu();
			mSysBaseData.setMenuNo("1002");
			mSysBaseData.setParentNo("1");
			mSysBaseData.setMenuName("基础数据维护");
			mSysBaseData.setClick("return false;");
			mSysBaseData.setOrderNo(mSysBaseData.getMenuNo());
			session.save(mSysBaseData);
			
			//运行监控菜单
			Menu mSysRunMonitor = new Menu();
			mSysRunMonitor.setMenuNo("1003");
			mSysRunMonitor.setParentNo("1");
			mSysRunMonitor.setMenuName("运行监控");
			mSysRunMonitor.setClick("return false;");
			mSysRunMonitor.setOrderNo(mSysRunMonitor.getMenuNo());
			session.save(mSysRunMonitor);
			
			//////////三级菜单
			//用户管理菜单
			Menu mSysUser = new Menu();
			mSysUser.setMenuNo("1001001");
			mSysUser.setParentNo("1001");
			mSysUser.setMenuUrl("admin/toUserList.do");
			mSysUser.setMenuName("用户管理");
			mSysUser.setOrderNo(mSysUser.getMenuNo());
			session.save(mSysUser);
			
			//角色管理菜单
			Menu mSysRole = new Menu();
			mSysRole.setMenuNo("1001002");
			mSysRole.setParentNo("1001");
			mSysRole.setMenuUrl("admin/toRoleList.do");
			mSysRole.setMenuName("角色管理");
			mSysRole.setOrderNo(mSysRole.getMenuNo());
			session.save(mSysRole);
			
			//权限分配菜单
			Menu mSysPrivilege = new Menu();
			mSysPrivilege.setMenuNo("1001003");
			mSysPrivilege.setParentNo("1001");
			mSysPrivilege.setMenuUrl("admin/build.do");
			mSysPrivilege.setMenuName("权限分配");
			mSysPrivilege.setOrderNo(mSysPrivilege.getMenuNo());
			session.save(mSysPrivilege);
			
			//菜单管理菜单
			Menu mSysMenu = new Menu();
			mSysMenu.setMenuNo("1001004");
			mSysMenu.setParentNo("1001");
			mSysMenu.setMenuUrl("admin/toMenuFrame.do");
			mSysMenu.setMenuName("菜单管理");
			mSysMenu.setOrderNo(mSysMenu.getMenuNo());
			session.save(mSysMenu);
			
			//字典维护菜单
			Menu mSysDictionary = new Menu();
			mSysDictionary.setMenuNo("1002001");
			mSysDictionary.setParentNo("1002");
			mSysDictionary.setMenuUrl("admin/build.do");
			mSysDictionary.setMenuName("字典维护");
			mSysDictionary.setOrderNo(mSysDictionary.getMenuNo());
			session.save(mSysDictionary);
			
			//全局参数表维护菜单
			Menu mSysAppParam = new Menu();
			mSysAppParam.setMenuNo("1002002");
			mSysAppParam.setParentNo("1002");
			mSysAppParam.setMenuUrl("admin/build.do");
			mSysAppParam.setMenuName("全局参数表维护");
			mSysAppParam.setOrderNo(mSysAppParam.getMenuNo());
			session.save(mSysAppParam);
			
			//request请求监控菜单
			Menu mSysRquestMonitor = new Menu();
			mSysRquestMonitor.setMenuNo("1003001");
			mSysRquestMonitor.setParentNo("1003");
			mSysRquestMonitor.setMenuUrl("admin/build.do");
			mSysRquestMonitor.setMenuName("request请求");
			mSysRquestMonitor.setOrderNo(mSysRquestMonitor.getMenuNo());
			session.save(mSysRquestMonitor);
			
			//session会话监控菜单
			Menu mSysSessionMonitor = new Menu();
			mSysSessionMonitor.setMenuNo("1003002");
			mSysSessionMonitor.setParentNo("1003");
			mSysSessionMonitor.setMenuUrl("admin/build.do");
			mSysSessionMonitor.setMenuName("session会话");
			mSysSessionMonitor.setOrderNo(mSysSessionMonitor.getMenuNo());
			session.save(mSysSessionMonitor);
			
			//JDBC执行监控菜单
			Menu mSysJDBCMonitor = new Menu();
			mSysJDBCMonitor.setMenuNo("1003003");
			mSysJDBCMonitor.setParentNo("1003");
			mSysJDBCMonitor.setMenuUrl("admin/build.do");
			mSysJDBCMonitor.setMenuName("JDBC执行监控");
			mSysJDBCMonitor.setOrderNo(mSysJDBCMonitor.getMenuNo());
			session.save(mSysJDBCMonitor);
			
			//系统异常监控菜单
			Menu mSysExceptionMonitor = new Menu();
			mSysExceptionMonitor.setMenuNo("1003004");
			mSysExceptionMonitor.setParentNo("1003");
			mSysExceptionMonitor.setMenuUrl("admin/build.do");
			mSysExceptionMonitor.setMenuName("系统异常监控");
			mSysExceptionMonitor.setOrderNo(mSysExceptionMonitor.getMenuNo());
			session.save(mSysExceptionMonitor);
			
			//服务器信息菜单
			Menu mSysServerMonitor = new Menu();
			mSysServerMonitor.setMenuNo("1003005");
			mSysServerMonitor.setParentNo("1003");
			mSysServerMonitor.setMenuUrl("admin/build.do");
			mSysServerMonitor.setMenuName("服务器信息监控");
			mSysServerMonitor.setOrderNo(mSysServerMonitor.getMenuNo());
			session.save(mSysServerMonitor);
			
			/*******************2.初始化权限表*******************/
			//超级权限
			Privilege p = new Privilege();
			p.setPrivilegeName("超级权限");
			session.save(p);
			
			//系统权限
			Privilege pAdmin = new Privilege();
			pAdmin.setPrivilegeName("系统权限");
			session.save(pAdmin);
			
			
			/********************3.给权限分配菜单****************/
			///////////////一级菜单
			//系统管理菜单 - 超级权限
			mSys.getPrivileges().add(p);
			p.getMenus().add(mSys);
			
			//系统管理菜单 - 系统权限
			mSys.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSys);
			
			/////////////二级菜单
			//权限管理菜单- 超级权限
			mSysPriv.getPrivileges().add(p);
			p.getMenus().add(mSysPriv);
			
			//权限管理菜单 - 系统权限
			mSysPriv.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSysPriv);
			
			//基础数据维护菜单- 超级权限
			mSysBaseData.getPrivileges().add(p);
			p.getMenus().add(mSysBaseData);
			
			//运行监控菜单 - 超级权限
			mSysRunMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysRunMonitor);
			
			/////////////三级菜单
			//用户管理菜单- 超级权限
			mSysUser.getPrivileges().add(p);
			p.getMenus().add(mSysUser);
			
			//用户管理菜单 - 系统权限
			mSysUser.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSysUser);
			
			//角色管理菜单- 超级权限
			mSysRole.getPrivileges().add(p);
			p.getMenus().add(mSysRole);
			
			//角色管理菜单 - 系统权限
			mSysRole.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSysRole);
			
			//权限分配菜单- 超级权限
			mSysPrivilege.getPrivileges().add(p);
			p.getMenus().add(mSysPrivilege);
			
			//权限分配菜单 - 系统权限
			mSysPrivilege.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSysPrivilege);
			
			//菜单管理菜单- 超级权限
			mSysMenu.getPrivileges().add(p);
			p.getMenus().add(mSysMenu);
			
			//菜单管理菜单 - 系统权限
			mSysMenu.getPrivileges().add(pAdmin);
			pAdmin.getMenus().add(mSysMenu);
			
			//字典表菜单- 超级权限
			mSysDictionary.getPrivileges().add(p);
			p.getMenus().add(mSysDictionary);
			
			//全局参数表维护菜单- 超级权限
			mSysAppParam.getPrivileges().add(p);
			p.getMenus().add(mSysAppParam);
			
			//request请求监控菜单 - 超级权限
			mSysRquestMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysRquestMonitor);
			
			//session会话监控菜单 - 超级权限
			mSysSessionMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysSessionMonitor);
			
			//JDBC执行监控菜单 - 超级权限
			mSysJDBCMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysJDBCMonitor);
			
			//系统异常监控菜单 - 超级权限
			mSysExceptionMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysExceptionMonitor);
			
			//服务器信息监控菜单 - 超级权限
			mSysServerMonitor.getPrivileges().add(p);
			p.getMenus().add(mSysServerMonitor);
			
			/**************4.初始化角色表******************/
			//超级管理员角色
			Role role = new Role();
			role.setRoleName("超级管理员");
			session.save(role);
			
			//超级管理员角色
			Role roleAdmin = new Role();
			roleAdmin.setRoleName("系统管理员");
			session.save(roleAdmin);
			
			/**************5.给角色分配权限***************/
			//超级权限  - 超级管理员角色
			p.getRoles().add(role);
			role.getPrivileges().add(p);
			
			//系统权限  - 系统管理员角色
			pAdmin.getRoles().add(roleAdmin);
			roleAdmin.getPrivileges().add(pAdmin);
			
			/****************6.初始化用户表**************/
			//超级用户
			User user = new User();
			user.setUserName(this.initUserName);
			user.setPassword(this.initPassword);
			user.setRegisterDate(new Date());
			session.save(user);
			
			//系统管理员
			User admin = new User();
			admin.setUserName("admin");
			admin.setPassword("123456");
			admin.setRegisterDate(new Date());
			session.save(admin);
			
			/****************7.给用户分配角色***************/
			//超级用户 - 超级管理员
			role.getUsers().add(user);
			user.getRoles().add(role);
			
			//系统管理员 - 系统管理员
			roleAdmin.getUsers().add(admin);
			admin.getRoles().add(roleAdmin);
			
			
			//提交存入数据库
			session.getTransaction().commit();
			session.flush();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}
