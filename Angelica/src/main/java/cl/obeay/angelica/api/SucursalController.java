package cl.obeay.angelica.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obeay.angelica.service.SucursalService;
import cl.obeay.angelica.vo.SucursalVO;

@Controller
@RequestMapping(value="/sucursal")
public class SucursalController {
	
	private static final Logger LOG = Logger.getLogger(SucursalController.class);
	
	@Autowired
	private SucursalService sucursalService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  SucursalVO get(@PathVariable int id, HttpServletRequest request) throws Exception {
		LOG.debug("SucursalController get");
		
		SucursalVO resp = null;
		
		try {		
			resp = sucursalService.get(id);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<SucursalVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("SucursalController getAll");
		
		List<SucursalVO> resp = null;

		try {			
			resp = sucursalService.getAll();
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