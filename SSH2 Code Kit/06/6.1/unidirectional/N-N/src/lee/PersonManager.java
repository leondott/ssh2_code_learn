package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

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
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		//创建一个Person对象
		Person p = new Person();
		//创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		//必须先持久化Address对象
		session.persist(a);
		//设置Person的Name为Yeeku字符串
		p.setName("Yeeku");
		p.setAge(29);
		//设置Person和Address之间的关联关系
		p.getAddresses().add(a);
		//持久化Person对象
		session.save(p);
		//创建一个瞬态的Address对象
		Address a2 = new Address("上海虹口");
		//先持久化Address对象
		session.persist(a2);
		//修改持久化状态的Person对象
		p.getAddresses().add(a2);

		//创建一个Person对象
		Person p2 = new Person();
		p2.setName("crazyit.org");
		p2.getAddresses().add(a);
		session.save(p2);

		tx.commit();
		HibernateUtil.closeSession();
	}

}
