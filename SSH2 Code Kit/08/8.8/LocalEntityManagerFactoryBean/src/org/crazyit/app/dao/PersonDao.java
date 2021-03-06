package org.crazyit.app.dao;

import java.util.List;
import org.springframework.transaction.annotation.*;

import org.crazyit.app.domain.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Transactional
public interface PersonDao 
{
	/**
	 * 加载Person实例
	 * @param id 需要加载的Person实例的主键值
	 * @return 返回加载的Person实例
	 */ 
	Person get(Integer id);
	 
	/**
	 * 保存Person实例
	 * @param person 需要保存的Person实例
	 * @return 刚刚保存的Person实例的标识属性值
	 */	
	Integer save(Person person);
	 
	/**
	 * 修改Person实例
	 * @param person 需要修改的Person实例
	 */
	void update(Person person);
	
	/**
	 * 删除Person实例
	 * @param id 需要删除的Person实例的标识属性值
	 */
	void delete(Integer id);
	
	/**
	 * 删除Person实例
	 * @param person 需要删除的Person实例
	 */
	void delete(Person person);
	
	/**
	 * 根据用户名查找Person
	 * @param name 查询的人名
	 * @return 指定用户名对应的全部Person
	 */
	List<Person> findByName(String name);
	
	/**
	 * 查询全部Person实例
	 * @return 全部Person实例
	 */
	public List findAllPerson();
	
	/**
	 * 查询数据表中Person实例的总数
	 * @return 数据表中Person实例的总数
	 */
	long getPersonNumber();
}