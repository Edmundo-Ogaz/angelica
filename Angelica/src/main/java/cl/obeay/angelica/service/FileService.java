package cl.obeay.angelica.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obeay.angelica.dao.CargoDao;
import cl.obeay.angelica.dao.FichaDao;
import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.util.OPENSHIFT;
import cl.obeay.angelica.util.PathUtil;
import cl.obeay.angelica.vo.CargoVO;

@Service
public class FileService {
	
	private static final Logger LOG = Logger.getLogger(FileService.class);
	
	public InputStream get(String fileName) throws RuntimeException {
		LOG.debug("FileService get");
		
		InputStream is = null; 
		try {
//	    	String path = System.getenv(OPENSHIFT.DATA_DIR.getCodigo());
//			if(path == null || path.equals("")) {
//				URL resource = getClass().getResource("/");
//				path = resource.getPath().replace("/WEB-INF/classes", "");
//			}
//			path = path + "file/";
//			LOG.debug("END_DATA_DIR" + path);
			
			is = new FileInputStream(PathUtil.getDataDir() + fileName);

	    } catch (FileNotFoundException e) {
	      throw new RuntimeException("File Not Found " + fileName, e);
	    }
	    
	    return is;
	}
}