package cl.obeay.angelica.dummy;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.GrupoVO;
import cl.obeay.angelica.vo.UsuarioVO;

@Repository
public class UsuarioDummy {
	
	private static final Logger LOG = Logger.getLogger(UsuarioDummy.class);
	
	@SuppressWarnings("unchecked")
	public List<UsuarioVO> getAllEqBy(UsuarioVO usuario) throws DAOException {
		LOG.debug("UsuarioDummy getAllEqBy");
		
		List<UsuarioVO> listUsuario = null;
		
		if("angelica".equals(usuario.getUsername()) && "angelica".equals(usuario.getPassword())) {
			listUsuario = new LinkedList<UsuarioVO>();
			listUsuario.add(new UsuarioVO("angelica", new GrupoVO(1), "angelica"));
		}
			return listUsuario;
	}
}
