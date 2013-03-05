package com.frame.common.dao;

import java.io.Serializable;
import java.util.List;

import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;

/**
 * 通用dao操作接口
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-19 下午5:10:58
 */
public interface CommonDao {

	/**
	 * 初始化数据库数据
	 */
	public void initDB();
	
	/**
	 * 保存操作
	 * @param entity
	 */
	public void save(Object entity);
	
	/**
	 * 保存或者更新操作
	 * @param entity
	 */
	public void saveOrUpdate(Object entity);
	
	/**
	 * 保存实体
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 删除实体
	 * @param entity
	 */
	public void delete(Object entity);
	
	/**
	 * 根据ID删除实体类.
	 * 
	 * @param entityName
	 *            实体名
	 * @param id
	 *            编号
	 * @return 删除的数据记录数
	 */
	public Integer deleteById(String entityName, final Long id);
	
	
	
	
	
	/**
	 * 根据实体类型和ID查找实体.
	 * 
	 * @param entityType -
	 *            实体类型
	 * @param id -
	 *            序列化ID
	 * @return - 实体对象
	 */
	@SuppressWarnings("rawtypes")
	public Object findById(Class entityType, Serializable id);
	
	/**
	 * 根据实体名称和ID查找实体.
	 * 
	 * @param entityType -
	 *            实体类型
	 * @param id -
	 *            序列化ID
	 * @return - 实体对象
	 */
	public Object findById(String entityName, Serializable id);
	
	/**
	 * 查询所有
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findAll(Object entity);
	
	/**
	 * 分页查询列表
	 * @return
	 */
	public Pagination findObjectsByPage(PageParamMap pageParamMap);
	
}
