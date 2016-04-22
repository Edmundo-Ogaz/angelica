package cl.obeay.angelica.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Usuario;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.vo.UsuarioVO;

@Repository
public class UsuarioDao {
	
	private static final Logger LOG = Logger.getLogger(UsuarioDao.class);
	
	@SuppressWarnings("unchecked")
	public List<UsuarioVO> getAllEqBy(UsuarioVO usuarioVO) throws DAOException {
		LOG.debug("UsuarioDao getAllEqBy");
		
		List<UsuarioVO> listUsuarioVO = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			StringBuilder query = new StringBuilder();
			
			query.append("from Usuario where 1 = 1 ");
			query.append(usuarioVO.getUsername() instanceof String && !usuarioVO.getUsername().isEmpty() ? "and LOGIN = '"  + usuarioVO.getUsername() + "' " : "");
			query.append(usuarioVO.getPassword() instanceof String && !usuarioVO.getPassword().isEmpty() ? "and PASSWORD = '" + usuarioVO.getPassword() + "' " : "");
			
			List<Usuario> listUsuario = (List<Usuario>) session.createQuery(query.toString()).list();
			listUsuarioVO = Mapper.from(listUsuario);
			tx.commit();
		} catch (JDBCConnectionException e) {
			throw new DAOException("Problemas para acceder a base de dato", e);
		} catch (Exception e) {
			throw new DAOException("Problemas para leer usuario", e);
		} finally {
			session.close();
		}
		return listUsuarioVO;
	}
}