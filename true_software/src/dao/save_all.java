package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import person.Person;



public class save_all {
	
	public static void main(String[] args)
	{
	Session session = null;
	Transaction tx = null;
	List<Person> list = null;
    try {
		//获取Session
		session.beginTransaction();	//开启事物
		String hql = "from Person ";	//HQL语句
		//创建Query对象
		Query query = session.createQuery(hql);
		list = query.list();		//获取查询结果集
		Iterator<Person> it=list.iterator();
		
		
		//提交事物
		session.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		//出错将回滚事物
		session.getTransaction().rollback();
	}finally{
		//关闭Session对象
		session.close();
	}
 }
}

