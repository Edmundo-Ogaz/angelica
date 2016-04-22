package cl.obeay.angelica.dummy;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.CargoVO;
import cl.obeay.angelica.vo.ClienteVO;
import cl.obeay.angelica.vo.FichaVO;
import cl.obeay.angelica.vo.PostulanteVO;
import cl.obeay.angelica.vo.SucursalVO;

@Repository
public class CargoDummy {
	
	private static final Logger LOG = Logger.getLogger(CargoDummy.class);

	public List<CargoVO> getAll() throws DAOException {
		LOG.debug("CargoDummy getAll");
		
		List<CargoVO> listCargo = new LinkedList<CargoVO>();
		listCargo.add(new CargoVO(1, "unoNombre"));
		listCargo.add(new CargoVO(2, "unoNombre"));
		listCargo.add(new CargoVO(3, "unoNombre"));		
		return listCargo;
	}
}