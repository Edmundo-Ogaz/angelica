package cl.obeay.angelica.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.model.Ficha;
import cl.obeay.angelica.util.HibernateUtil;
import cl.obeay.angelica.util.Mapper;
import cl.obeay.angelica.util.PathUtil;
import cl.obeay.angelica.vo.FichaVO;

@Repository
public class FichaDao {
	
	private static final Logger LOG = Logger.getLogger(FichaDao.class);
	
	public List<FichaVO> getAll() throws DAOException {
		LOG.debug("FichaDao getAll");
		
		List<FichaVO> listaFichaVO = new LinkedList<FichaVO>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();		
			List<Ficha> listaFicha = (List<Ficha>) session.createQuery("from Ficha ").list();
			for(Ficha ficha : listaFicha) {
				listaFichaVO.add(Mapper.from(ficha));
			}
			tx.commit();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return listaFichaVO;
	}
	
	public FichaVO create(FichaVO fichaVO) throws DAOException {
		LOG.debug("FichaDao save");
		
		Ficha ficha = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ficha = Mapper.from(fichaVO);
			
			session.saveOrUpdate(ficha.getPostulante());			
			session.save(ficha);
			
			if(fichaVO.getFileCurriculum() != null && !fichaVO.getFileCurriculum().isEmpty()) {
				BufferedOutputStream streamCurriculum = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getCurriculum())));
		        FileCopyUtils.copy(fichaVO.getFileCurriculum().getInputStream(), streamCurriculum);
				streamCurriculum.close();
			}
			
			if(fichaVO.getFileInforme() != null && !fichaVO.getFileInforme().isEmpty()) {
				BufferedOutputStream streamInforme = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getInforme())));
		        FileCopyUtils.copy(fichaVO.getFileInforme().getInputStream(), streamInforme);
		        streamInforme.close();
			}
	        
			if(fichaVO.getFilePerfil() != null && !fichaVO.getFilePerfil().isEmpty()) {
		        BufferedOutputStream streamPerfil = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getPerfil())));
		        FileCopyUtils.copy(fichaVO.getFilePerfil().getInputStream(), streamPerfil);
		        streamPerfil.close();
			}
			
		    tx.commit();
		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					LOG.error("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new DAOException("Error al grabar Campo y en rollback", e);
				}
			}
			throw new DAOException("Error al Nivel persistencia", e);
		} finally {
			session.close();
		}
		return Mapper.from(ficha);
	}
	
	public FichaVO update(FichaVO fichaVO) throws DAOException {
		LOG.debug("FichaDao update");
		
		Ficha ficha = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ficha = Mapper.from(fichaVO);
			
			session.saveOrUpdate(ficha.getPostulante());			
			session.update(ficha);
			
			if(fichaVO.getFileCurriculum() != null && !fichaVO.getFileCurriculum().isEmpty()) {
				BufferedOutputStream streamCurriculum = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getCurriculum())));
		        FileCopyUtils.copy(fichaVO.getFileCurriculum().getInputStream(), streamCurriculum);
				streamCurriculum.close();
			}
			
			if(fichaVO.getFileInforme() != null && !fichaVO.getFileInforme().isEmpty()) {
				BufferedOutputStream streamInforme = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getInforme())));
		        FileCopyUtils.copy(fichaVO.getFileInforme().getInputStream(), streamInforme);
		        streamInforme.close();
			}
	        
			if(fichaVO.getFilePerfil() != null && !fichaVO.getFilePerfil().isEmpty()) {
		        BufferedOutputStream streamPerfil = new BufferedOutputStream(
						new FileOutputStream(
								new File(PathUtil.getDataDir() + fichaVO.getPerfil())));
		        FileCopyUtils.copy(fichaVO.getFilePerfil().getInputStream(), streamPerfil);
		        streamPerfil.close();
			}
		    
		    tx.commit();
		} catch (Exception e) {
			LOG.error("Fatal " + e.getMessage());
			if (tx != null && tx.isActive()){
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					LOG.error("Fatal al tratar de hacer rollback " + e.getMessage());
					throw new DAOException("Error al grabar Campo y en rollback", e);
				}
			}
			throw new DAOException("Error al Nivel persistencia", e);
		} finally {
			session.close();
		}
		return Mapper.from(ficha);
	}

}
