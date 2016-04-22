package cl.obeay.angelica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obeay.angelica.dao.ClienteDao;
import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.ClienteVO;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDao dao;
	
	public List<ClienteVO> getAll() throws DAOException {
		List<ClienteVO> listaClienteVO = dao.getAll();		
		return listaClienteVO;
	}
}