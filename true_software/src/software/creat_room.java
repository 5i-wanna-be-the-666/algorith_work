package software;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.HibernateSessionFactory;
import person.Person;
import room.RoomInformation;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class creat_room {

public static void main(String[] args)
{  
	Session session = null;
	
    try {
    	
    	session = HibernateSessionFactory.getSession();
		session.beginTransaction();	//��������
		
		
		
	
		String iii=new String("");
		int i=10000;
	
		int jishu=1;
		while(jishu<=50)
		{
			String s=new String("");
			s=""+i;
			RoomInformation r=new RoomInformation();
			
			if(jishu%10==0)
			{
				r.setHousingType("��ͳ��");
				r.setMaxperson(8);
				r.setPrice(50000.0);
				r.setEmpety(true);
				r.setSerialNumber(s);
				r.setIdCard(iii);
				r.setArea(r.getPrice()/20+i/250);
			}
			else if(jishu%5==0)
			{
				r.setHousingType("�󴲷�");
				r.setMaxperson(2);
				r.setPrice(40000.0);
				r.setEmpety(true);
				r.setSerialNumber(s);
				r.setIdCard(iii);
				r.setArea(r.getPrice()/20+i/450);
			}
			else if(jishu%2==0)
			{
				r.setHousingType("˫�˼�");
				r.setMaxperson(2);
				r.setPrice(30000.0);
				r.setEmpety(true);
				r.setSerialNumber(s);
				r.setIdCard(iii);
				r.setArea(r.getPrice()/20+i/850);
			}
			else
			{
				r.setHousingType("���");
				r.setMaxperson(1);
				r.setPrice(10000.0);
				r.setEmpety(true);
				r.setSerialNumber(s);
				r.setIdCard(iii);
				r.setArea(r.getPrice()/20+i/950);
				
			}
			
			
			session.save(r);//�������
			
			jishu++;
			i++;
			
		}
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
