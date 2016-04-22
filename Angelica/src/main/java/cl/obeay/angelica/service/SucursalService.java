package cl.obeay.angelica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obeay.angelica.dao.SucursalDao;
import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.SucursalVO;

@Service
public class SucursalService {
	
	@Autowired
	private SucursalDao dao;
	
	public SucursalVO get(int id) throws DAOException {
		SucursalVO sucursalVO = dao.get(id);		
		return sucursalVO;
	}
	
	public List<SucursalVO> getAll() throws DAOException {
		List<SucursalVO> listaSucursalVO = dao.getAll();		
		return listaSucursalVO;
	}
}