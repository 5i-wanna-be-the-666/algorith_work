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
		//��ȡSession
		session.beginTransaction();	//��������
		String hql = "from Person ";	//HQL���
		//����Query����
		Query query = session.createQuery(hql);
		list = query.list();		//��ȡ��ѯ�����
		Iterator<Person> it=list.iterator();
		
		
		//�ύ����
		session.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		//�����ع�����
		session.getTransaction().rollback();
	}finally{
		//�ر�Session����
		session.close();
	}
 }
}

