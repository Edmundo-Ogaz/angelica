package cl.obeay.angelica.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cl.obeay.angelica.service.FichaService;
import cl.obeay.angelica.vo.FichaVO;

@Controller
@RequestMapping(value="/ficha")
public class FichaController {
	
	private static final Logger LOG = Logger.getLogger(FichaController.class);
	
	@Autowired
	private FichaService fichaService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<FichaVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("FichaController getAll");
		
		List<FichaVO> resp = null;

		try {			
			resp = fichaService.getAll();
		} catch(Exception e) {
			throw e;
		}		
		return resp;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public FichaVO add(@RequestPart("ficha") FichaVO fichaVO,
			@RequestPart(value="curriculum", required=false) MultipartFile fileCurriculum,
			@RequestPart(value="informe", required=false) MultipartFile fileInforme,
			@RequestPart(value="perfil", required=false) MultipartFile filePerfil,
			HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LOG.debug("PedidoController save");
		
		FichaVO resp = null;
		
		try {			
			resp = fichaService.save(fichaVO, fileCurriculum, fileInforme, filePerfil);
		} catch(Throwable e) {
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