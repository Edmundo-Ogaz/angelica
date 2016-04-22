package cl.obeay.angelica.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obeay.angelica.service.ClienteService;
import cl.obeay.angelica.vo.ClienteVO;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	private static final Logger LOG = Logger.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ClienteVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("ClienteController getAll");
		
		List<ClienteVO> resp = null;

		try {			
			resp = clienteService.getAll();
		} catch(Exception e) {
			throw e;
		}		
		return resp;
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}