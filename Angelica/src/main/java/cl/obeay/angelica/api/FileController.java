package cl.obeay.angelica.api;

import java.io.IOException;

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

import cl.obeay.angelica.service.FileService;

@Controller
@RequestMapping(value="/file")
public class FileController {
	
	private static final Logger LOG = Logger.getLogger(FileController.class);
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = "/get/{file_name:.+}", method = RequestMethod.GET)
	public void getFile(@PathVariable("file_name") String fileName, HttpServletRequest request, HttpServletResponse response) {
		LOG.error("FileController getFile");
		
		try {
	      org.apache.commons.io.IOUtils.copy(fileService.get(fileName), response.getOutputStream());
	      response.setContentType("application/ms-word");
	      response.flushBuffer();
	    } catch (RuntimeException e) {
	    	throw e;
	    } catch (IOException e) {
	      throw new RuntimeException("IOError writing file to output stream. Filename was " + fileName, e);
	    }

	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}