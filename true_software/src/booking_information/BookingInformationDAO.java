package booking_information;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import booking_information.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * BookingInformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see true_book.BookingInformation
 * @author MyEclipse Persistence Tools
 */
public class BookingInformationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BookingInformationDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String BOOKING_METHOD = "bookingMethod";
	public static final String LIVE_DAYS = "liveDays";

	public void save(BookingInformation transientInstance) 
	{
		log.debug("saving BookingInformation instance");
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

	public void delete(BookingInformation persistentInstance) {
		log.debug("deleting BookingInformation instance");
		Transaction tran=getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			 getSession().flush(); //***********
             tran.commit(); //**********************
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BookingInformation findById(BookingInformationId id) {
		log.debug("getting BookingInformation instance with id: " + id);
		try {
			BookingInformation instance = (BookingInformation) getSession().get("true_book.BookingInformation", id);
			return instance;
		} catch (RuntimeException re) 
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BookingInformation instance) {
		log.debug("finding BookingInformation instance by example");
		try {
			List results = getSession().createCriteria("true_book.BookingInformation").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BookingInformation instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from BookingInformation as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByBookingMethod(Object bookingMethod) {
		return findByProperty(BOOKING_METHOD, bookingMethod);
	}

	public List findByLiveDays(Object liveDays) {
		return findByProperty(LIVE_DAYS, liveDays);
	}

	public List findAll() {
		log.debug("finding all BookingInformation instances");
		try {
			String queryString = "from BookingInformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BookingInformation merge(BookingInformation detachedInstance) {
		log.debug("merging BookingInformation instance");
		try {
			BookingInformation result = (BookingInformation) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BookingInformation instance) {
		log.debug("attaching dirty BookingInformation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookingInformation instance) {
		log.debug("attaching clean BookingInformation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}