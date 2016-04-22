package cl.obeay.angelica.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Cargo;
import cl.obeay.angelica.model.Estado;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.vo.EstadoVO;

@Repository
public class EstadoDao {
	
	private static final Logger LOG = Logger.getLogger(EstadoDao.class);
	
	public EstadoVO get(String codigo) throws DAOException {
		LOG.debug("EstadoDao get");
		
		EstadoVO estadoVO = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();		
			Estado estado = (Estado) session.createQuery("from Estado where codigo = ?").setString(0, codigo).uniqueResult();		
			estadoVO = Mapper.from(estado);
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return estadoVO;
	}
}