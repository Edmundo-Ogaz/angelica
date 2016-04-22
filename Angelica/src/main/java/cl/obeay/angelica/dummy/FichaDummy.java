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
public class FichaDummy {
	
	private static final Logger LOG = Logger.getLogger(FichaDummy.class);

	public List<FichaVO> getAll() throws DAOException {
		LOG.debug("RegionDummy getAll");
		
		List<FichaVO> listFicha = new LinkedList<FichaVO>();
//		listFicha.add(new FichaVO(1, 
//				      new SucursalVO(1, "unoNombre", "unoDirec", "11111", 
//				    		  new ClienteVO("1111-1", "unonombreE", "unoRz", "11-01-2011", "111", "11-01-2011"
//				    				  )),
//				    	"1111", 
//				    	new PostulanteVO("1111-1", "1111nombew", "1111apellP", "1111apellM", "21111", "911111"),
//				    	new CargoVO(1, "111nombre"),
//				    	new Byte("1"), "11-01-2011", "11-01-2011", "11-01-2011", "1111re" , "11111c.doc", "1111i.doc", "11111p.doc", "11111Con")
//				);
//		listFicha.add(new FichaVO(2, 
//			      new SucursalVO(2, "unoNombre", "unoDirec", "22222", 
//			    		  new ClienteVO("2222-2", "unonombreE", "unoRz", "22-03-2022", "222", "22-02-2022"
//			    				  )),
//			    	"2222", 
//			    	new PostulanteVO("2222-2", "2222nombew", "2222apellP", "2222apellM", "22222", "922222"),
//			    	new CargoVO(2, "222nombre"),
//			    	new Byte("2"), "22-02-2022", "22-02-2022", "22-02-2022", "2222re" , "22222c.doc", "22222i.doc", "22222p.doc", "22222Con")
//				);
//		listFicha.add(new FichaVO(3, 
//			      new SucursalVO(3, "unoNombre", "unoDirec", "33333", 
//			    		  new ClienteVO("3333-3", "unonombreE", "unoRz", "30-03-2033", "333", "30-03-2033"
//			    				  )),
//			    	"3333", 
//			    	new PostulanteVO("3333-3", "3333nombew", "3333apellP", "3333apellM", "33333", "933333"),
//			    	new CargoVO(3, "333nombre"),
//			    	new Byte("3"), "30-03-2033", "30-03-2033", "30-03-2033", "3333re" , "33333c.doc", "33333i.doc", "33333p.doc", "33333Con")
//				);
		
		return listFicha;
	}
}