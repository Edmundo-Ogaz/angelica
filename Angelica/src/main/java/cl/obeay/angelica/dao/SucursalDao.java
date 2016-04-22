package cl.obeay.angelica.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Sucursal;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.vo.SucursalVO;

@Repository
public class SucursalDao {
	
	private static final Logger LOG = Logger.getLogger(SucursalDao.class);
	
	public SucursalVO get(int id) throws DAOException {
		LOG.debug("SucursalDao get");
		
		SucursalVO sucursalVO = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();		
			Sucursal sucursal = (Sucursal) session.createQuery("from Sucursal where id = ?").setInteger(0, id).uniqueResult();		
			sucursalVO = Mapper.from(sucursal);
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return sucursalVO;
	}

	public List<SucursalVO> getAll() throws DAOException {
		LOG.debug("SucursalDao getAll");
		
		List<SucursalVO> listaSucursalVO = new LinkedList<SucursalVO>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Sucursal> listaSucursal = (List<Sucursal>) session.createQuery("from Sucursal ").list();
			for(Sucursal sucursal : listaSucursal) {
				listaSucursalVO.add(Mapper.from(sucursal));
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listaSucursalVO;
	}
}