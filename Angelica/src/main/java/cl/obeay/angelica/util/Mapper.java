package cl.obeay.angelica.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import cl.obeay.angelica.model.Cargo;
import cl.obeay.angelica.model.Cliente;
import cl.obeay.angelica.model.Estado;
import cl.obeay.angelica.model.Ficha;
import cl.obeay.angelica.model.Grupo;
import cl.obeay.angelica.model.Postulante;
import cl.obeay.angelica.model.Sucursal;
import cl.obeay.angelica.model.Usuario;
import cl.obeay.angelica.vo.CargoVO;
import cl.obeay.angelica.vo.ClienteVO;
import cl.obeay.angelica.vo.EstadoVO;
import cl.obeay.angelica.vo.FichaVO;
import cl.obeay.angelica.vo.GrupoVO;
import cl.obeay.angelica.vo.PostulanteVO;
import cl.obeay.angelica.vo.SucursalVO;
import cl.obeay.angelica.vo.UsuarioVO;

public class Mapper {
	
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Ficha from(FichaVO fichaVO) throws ParseException {
		Ficha ficha = null;
		if(fichaVO instanceof FichaVO) {
			ficha = new Ficha(
							Mapper.from(fichaVO.getSucursal(), fichaVO),
							Mapper.from(fichaVO.getPostulante(), fichaVO),
							Mapper.from(fichaVO.getEstado(), fichaVO),
   							Mapper.from(fichaVO.getCargo(), fichaVO),
   							fichaVO.getValorInforme(),
   							fichaVO.getInternoExterno(),
   							fichaVO.getFechaSolicitud() != null && !fichaVO.getFechaSolicitud().equals("") ? sdf.parse(fichaVO.getFechaSolicitud()) : null,
   							fichaVO.getFechaEntrevista() != null && !fichaVO.getFechaEntrevista().equals("") ? sdf.parse(fichaVO.getFechaEntrevista()) : null,
   							fichaVO.getFechaEntregaInforme() != null && !fichaVO.getFechaEntrevista().equals("") ? sdf.parse(fichaVO.getFechaEntrevista()) : null,
   							fichaVO.getResultado(),
   							fichaVO.getComentarios(),
   							fichaVO.getCurriculum(),
   							fichaVO.getInforme(),
   							fichaVO.getPerfil());
			ficha.setId(fichaVO.getId());
		}
		return ficha;
	}
	
	public static FichaVO from(Ficha ficha) {
		FichaVO fichaVO = null;
		if(ficha instanceof Ficha) {
			fichaVO = new FichaVO(
									ficha.getId(),
									Mapper.from(ficha.getSucursal()),
									ficha.getValorInforme(),
									Mapper.from(ficha.getPostulante()),
									Mapper.from(ficha.getCargo()),
									ficha.getInternoExterno(),
									ficha.getFechaSolicitud() != null ? sdf.format(ficha.getFechaSolicitud()) : null,
									ficha.getFechaEntrevista() != null ? sdf.format(ficha.getFechaEntrevista()) : null,
									ficha.getFechaInforme() != null ? sdf.format(ficha.getFechaInforme()) : null,
									ficha.getResultado(),
									ficha.getCurriculum(),
									ficha.getInforme(),
									ficha.getPerfil(),
									ficha.getComentarios(),
									Mapper.from(ficha.getEstado()));
	   }
	   return fichaVO;
   }
	
	public static Postulante from(PostulanteVO postulanteVO, FichaVO fichaVO) throws ParseException {
		Postulante postulante = null;
		if(postulanteVO instanceof PostulanteVO) {
			postulante = new Postulante(
										postulanteVO.getRut(),
										postulanteVO.getNombre(),
										postulanteVO.getApellidoPaterno(),
										postulanteVO.getApellidoMaterno(),
										postulanteVO.getTelefono(),
										postulanteVO.getCelular(),
										null);
		}
		return postulante;
	}
	
	public static PostulanteVO from(Postulante postulante) {
		PostulanteVO postulanteVO = null;
		if(postulante instanceof Postulante) {
			postulanteVO = new PostulanteVO(
											postulante.getRut(),
											postulante.getNombre(),
											postulante.getApellidoPaterno(),
											postulante.getApellidoMaterno(),
											postulante.getTelefono(),
											postulante.getCelular());
		}
		return postulanteVO;
	}
	
	public static Sucursal from(SucursalVO sucursalVO, FichaVO fichaVO) throws ParseException {
		Sucursal sucursal = null;
		if(sucursalVO instanceof SucursalVO) {
			sucursal = new Sucursal(
									sucursalVO.getId(),
									Mapper.from(sucursalVO.getCliente(), sucursalVO),
									sucursalVO.getNombre(),
									sucursalVO.getDireccion(),
									sucursalVO.getTelefono(),
									null,
									null);
		}
		return sucursal;
	}
	
	public static SucursalVO from(Sucursal sucursal) {
		SucursalVO sucursalVO = null;
		if(sucursal instanceof Sucursal) {
			sucursalVO = new SucursalVO(
										sucursal.getId(),
										sucursal.getNombre(),
										sucursal.getDireccion(),
										sucursal.getTelefono(),
										Mapper.from(sucursal.getCliente()));
		}
		return sucursalVO;
	}
	
	public static Cliente from(ClienteVO clienteVO, SucursalVO sucursalVO) throws ParseException {
		Cliente cliente = null;
		if(clienteVO instanceof ClienteVO) {
			cliente = new Cliente(
									clienteVO.getRut(),
									clienteVO.getNombre(),
									clienteVO.getRazonSocial(),
									clienteVO.getFechaPago(),
									clienteVO.getValorInforme(),
									clienteVO.getEntregaInforme(),
									null);
		}
		return cliente;
	}
	
	public static ClienteVO from(Cliente cliente) {
		ClienteVO clienteVO = null;
		if(cliente instanceof Cliente) {
			clienteVO = new ClienteVO(
										cliente.getRut(),
										cliente.getNombre(),
										cliente.getRazonSocial(),
										cliente.getFechaPago(),
										cliente.getValorInforme(),
										cliente.getEntregaInforme());
	   }
	   return clienteVO;
   }
	
	public static Cargo from(CargoVO cargoVO, FichaVO fichaVO) throws ParseException {
		Cargo cargo = null;
		if(cargoVO instanceof CargoVO) {
			cargo = new Cargo(
								cargoVO.getCodigo(),
								cargoVO.getNombre(),
								null);
		}
		return cargo;
	}
	
	public static CargoVO from(Cargo cargo) {
		CargoVO cargoVO = null;
		if(cargo instanceof Cargo) {
			cargoVO = new CargoVO(
									cargo.getCodigo(),
									cargo.getNombre());
		}	   	
		return cargoVO;
	}
	
	public static Estado from(EstadoVO estadoVO, FichaVO fichaVO) throws ParseException {
		Estado estado = null;
		if(estadoVO instanceof EstadoVO) {
			estado = new Estado(
								estadoVO.getCodigo(),
								estadoVO.getNombre(),
											null);
		}
		return estado;
	}
	
	public static EstadoVO from(Estado estado) {
		EstadoVO estadoVO = null;
		if(estado instanceof Estado) {
			estadoVO = new EstadoVO(
									estado.getCodigo(),
									estado.getDescripcion());
		}
		return estadoVO;
	}
	
	public static UsuarioVO from(Usuario usuario) {
		UsuarioVO usuarioVO = null;
		if(usuario instanceof Usuario) {
			usuarioVO = new UsuarioVO(
									usuario.getLogin(),
									Mapper.from(usuario.getGrupo()),
									usuario.getPassword());
		}
		return usuarioVO;
	}
	
	public static List<UsuarioVO> from(List<Usuario> usuarios) {
		List<UsuarioVO> usuariosVO = null;
		if(usuarios instanceof List) {
			usuariosVO = new LinkedList<UsuarioVO>();
			for(Usuario usuario : usuarios) {
				usuariosVO.add(Mapper.from(usuario));
			}
		}
		return usuariosVO;
	}
	
	public static GrupoVO from(Grupo grupo) {
		GrupoVO grupoVO = null;
		if(grupo instanceof Grupo) {
			grupoVO = new GrupoVO(
									grupo.getCodigo(),
									grupo.getNombre());
		}
		return grupoVO;
	}

}
