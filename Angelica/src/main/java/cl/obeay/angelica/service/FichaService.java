package cl.obeay.angelica.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import cl.obeay.angelica.dao.CargoDao;
import cl.obeay.angelica.dao.EstadoDao;
import cl.obeay.angelica.dao.FichaDao;
import cl.obeay.angelica.dao.SucursalDao;
import cl.obeay.angelica.dummy.FichaDummy;
import cl.obeay.angelica.exception.BusinessException;
import cl.obeay.angelica.exception.DAOException;
import cl.obeay.angelica.vo.CargoVO;
import cl.obeay.angelica.vo.EstadoVO;
import cl.obeay.angelica.vo.FichaVO;
import cl.obeay.angelica.vo.SucursalVO;

@Service
public class FichaService {
	
	private final static Logger LOG = Logger.getLogger(FichaService.class);
	
	@Autowired
	private FichaDummy dummy;
	
	@Autowired
	private FichaDao dao;
	
	@Autowired
	private SucursalDao sucursalDao;
	
	@Autowired
	private CargoDao cargoDao;
	
	@Autowired
	private EstadoDao estadoDao;
	
	public List<FichaVO> getAll() throws DAOException {
		List<FichaVO> listaFichaVO = dao.getAll();		
		return listaFichaVO;
	}
	
	public FichaVO save(FichaVO fichaVO, 
			MultipartFile fileCurriculum, MultipartFile fileInforme, MultipartFile filePerfil) 
					throws BusinessException, DAOException, Exception, Throwable {
		
		LOG.debug("FichaService save");
		
		try {
			SucursalVO sucursalVO = sucursalDao.get(fichaVO.getSucursal().getId());
			fichaVO.setSucursal(sucursalVO);
			
			CargoVO cargoVO = cargoDao.get(fichaVO.getCargo().getCodigo());
			fichaVO.setCargo(cargoVO);
			
			EstadoVO estadoVO = estadoDao.get(fichaVO.getEstado().getCodigo());
			fichaVO.setEstado(estadoVO);
			
			//ADD FILE
			fichaVO.setFileCurriculum(fileCurriculum);
			fichaVO.setFileInforme(fileInforme);
			fichaVO.setFilePerfil(filePerfil);
			
			//NOME FILE
//			fichaVO.setCurriculum(fichaVO.getFileCurriculum() != null && !fichaVO.getFileCurriculum().isEmpty() ? fichaVO.getFileCurriculum().getOriginalFilename() : "");
//			fichaVO.setInforme(fichaVO.getFileInforme() != null && !fichaVO.getFileInforme().isEmpty() ?fichaVO.getFileInforme().getOriginalFilename() : "");
//			fichaVO.setPerfil(fichaVO.getFilePerfil() != null && !fichaVO.getFilePerfil().isEmpty() ?fichaVO.getFilePerfil().getOriginalFilename() : "");
			
			if(fichaVO.getId() == 0) {
				fichaVO = dao.create(fichaVO);
			} else {
				fichaVO = dao.update(fichaVO);
			}

		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		} catch(Throwable t) {
			throw t;
		}
		
		return fichaVO;
	}
}