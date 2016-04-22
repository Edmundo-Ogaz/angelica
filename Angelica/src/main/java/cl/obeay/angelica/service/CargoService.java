package cl.obeay.angelica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obeay.angelica.dao.CargoDao;
import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.CargoVO;

@Service
public class CargoService {
	
	@Autowired
	private CargoDao dao;
	
	public List<CargoVO> getAll() throws DAOException {
		List<CargoVO> listaCargoVO = dao.getAll();		
		return listaCargoVO;
	}
}