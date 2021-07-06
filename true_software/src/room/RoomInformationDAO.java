package room;

import booking_information.BaseHibernateDAO;
import dao.HibernateSessionFactory;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoomInformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see room.RoomInformation
 * @author MyEclipse Persistence Tools
 */
public class RoomInformationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RoomInformationDAO.class);
	// property constants
	public static final String HOUSING_TYPE = "housingType";
	public static final String PRICE = "price";
	public static final String MAXPERSON = "maxperson";
	public static final String EMPETY = "empety";
	public static final String ID_CARD = "idCard";
	public static final String AREA = "area";

	public void save(RoomInformation transientInstance) {
		log.debug("saving RoomInformation instance");
		Transaction tran=getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			   getSession().flush(); //***********
	              tran.commit(); //**********************
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoomInformation persistentInstance) {
		
		log.debug("deleting RoomInformation instance");
		try {Session session = null;
		
		session = HibernateSessionFactory.getSession();
		session.beginTransaction();	//¿ªÆôÊÂÎï
		
		getSession().delete(persistentInstance);
		session.delete(persistentInstance);
		session.getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoomInformation findById(java.lang.String id) {
		log.debug("getting RoomInformation instance with id: " + id);
		try {
			RoomInformation instance = (RoomInformation) getSession().get("room.RoomInformation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoomInformation instance) {
		log.debug("finding RoomInformation instance by example");
		try {
			List results = getSession().createCriteria("room.RoomInformation").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RoomInformation instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RoomInformation as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHousingType(Object housingType) {
		return findByProperty(HOUSING_TYPE, housingType);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByMaxperson(Object maxperson) {
		return findByProperty(MAXPERSON, maxperson);
	}

	public List findByEmpety(Object empety) {
		return findByProperty(EMPETY, empety);
	}

	public List findByIdCard(Object idCard) {
		return findByProperty(ID_CARD, idCard);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findAll() {
		log.debug("finding all RoomInformation instances");
		try {
			String queryString = "from RoomInformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoomInformation merge(RoomInformation detachedInstance) {
		log.debug("merging RoomInformation instance");
		try {
			RoomInformation result = (RoomInformation) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoomInformation instance) {
		log.debug("attaching dirty RoomInformation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoomInformation instance) {
		log.debug("attaching clean RoomInformation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}