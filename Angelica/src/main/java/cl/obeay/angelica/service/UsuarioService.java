package cl.obeay.angelica.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obeay.angelica.dao.UsuarioDao;
import cl.obeay.angelica.vo.UsuarioVO;

@Service
public class UsuarioService {
	
	private static final Logger LOG = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioDao dao;
	
	public boolean login(UsuarioVO usuarioVO) throws Exception {
		LOG.debug("UsuarioService login");
		
		boolean resp = false;
		if (usuarioVO.getUsername() == null || usuarioVO.getPassword() == null) {
			throw new Exception("wrong parameters");
		} else {
			try {
				List<UsuarioVO> list = dao.getAllEqBy(usuarioVO);
				if(list instanceof List && !list.isEmpty()) {
					resp = true;
				} else {
					throw new Exception("wrong username/pwd");
				}
			} catch(Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return resp;
	}
}