package cl.obeay.angelica.util;

import java.net.URL;

import org.apache.log4j.Logger;

public class PathUtil {
	
	private static final Logger LOG = Logger.getLogger(PathUtil.class);
	
	public static String getDataDir() {
	
		String path = System.getenv(OPENSHIFT.DATA_DIR.getCodigo());
		if(path == null || path.equals("")) {
			URL resource = PathUtil.class.getResource("/");
			path = resource.getPath().replace("/WEB-INF/classes", "");
		}
		path = path + "file/";
		LOG.debug("DATA_DIR" + path);
		
		return path;
	}

}
