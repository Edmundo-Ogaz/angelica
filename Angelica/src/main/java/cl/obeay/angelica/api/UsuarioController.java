package cl.obeay.angelica.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obeay.angelica.service.UsuarioService;
import cl.obeay.angelica.vo.UsuarioVO;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	private static final Logger LOG = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET, consumes = "application/json")
	@ResponseBody
	public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("UsuarioController login");
		
		boolean resp = false;
		
		try {
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			UsuarioVO usuario = mapper.readValue(q, UsuarioVO.class);
			resp = usuarioService.login(usuario);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public @ResponseBody boolean logout(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		LOG.debug("LogoutController logout");
		return true;
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}