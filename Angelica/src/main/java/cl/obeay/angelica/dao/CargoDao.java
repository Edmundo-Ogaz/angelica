package cl.obeay.angelica.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Cargo;
import cl.obeay.angelica.model.Sucursal;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.vo.CargoVO;
import cl.obeay.angelica.vo.SucursalVO;

@Repository
public class CargoDao {
	
	private static final Logger LOG = Logger.getLogger(CargoDao.class);
	
	public CargoVO get(int codigo) throws DAOException {
		LOG.debug("CargoDao get");
		
		CargoVO cargoVO = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();		
			Cargo cargo = (Cargo) session.createQuery("from Cargo where codigo = ?").setInteger(0, codigo).uniqueResult();		
			cargoVO = Mapper.from(cargo);
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return cargoVO;
	}

	public List<CargoVO> getAll() throws DAOException {
		LOG.debug("CargoDao getAll");
		
		List<CargoVO> listaCargoVO = new LinkedList<CargoVO>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();		
			List<Cargo> listaCargo = (List<Cargo>) session.createQuery("from Cargo ").list();
			for(Cargo cargo : listaCargo) {
				listaCargoVO.add(Mapper.from(cargo));
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listaCargoVO;
	}
}