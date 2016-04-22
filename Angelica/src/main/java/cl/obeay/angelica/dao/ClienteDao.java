package cl.obeay.angelica.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Cliente;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.vo.ClienteVO;

@Repository
public class ClienteDao {
	
	private static final Logger LOG = Logger.getLogger(ClienteDao.class);

	public List<ClienteVO> getAll() throws DAOException {
		LOG.debug("ClienteDao getAll");
		
		List<ClienteVO> listaClienteVO = new LinkedList<ClienteVO>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();		
			@SuppressWarnings("unchecked")
			List<Cliente> listaCliente = (List<Cliente>) session.createQuery("from Cliente ").list();
			for(Cliente cliente : listaCliente) {
				listaClienteVO.add(Mapper.from(cliente));
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listaClienteVO;
	}
}