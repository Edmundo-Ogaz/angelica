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
public class SucursalDummy {
	
	private static final Logger LOG = Logger.getLogger(SucursalDummy.class);

	public List<SucursalVO> getAll() throws DAOException {
		LOG.debug("SucursalDummy getAll");
		
		List<SucursalVO> listSucursal = new LinkedList<SucursalVO>();
		listSucursal.add(new SucursalVO(1, "unoNombre", "unoDirec", "11111", 
				    		  new ClienteVO("1111-1", "unonombreE", "unoRz", "11-11-11", "111", "11-11-11"
				    				  )));
		listSucursal.add(new SucursalVO(2, "unoNombre", "unoDirec", "22222", 
			    		  new ClienteVO("2222-2", "unonombreE", "unoRz", "22-22-22", "222", "22-22-22"
			    				  )));
		listSucursal.add(new SucursalVO(3, "unoNombre", "unoDirec", "33333", 
			    		  new ClienteVO("3333-3", "unonombreE", "unoRz", "33-33-33", "333", "33-33-33"
			    				  )));		
		return listSucursal;
	}
}