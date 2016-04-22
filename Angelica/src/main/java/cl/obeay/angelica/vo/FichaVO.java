package cl.obeay.angelica.vo;

import org.springframework.web.multipart.MultipartFile;

public class FichaVO {

	private int id;
	private SucursalVO sucursal;
	private String valorInforme;
	private PostulanteVO postulante;
	private CargoVO cargo;
	private byte internoExterno;
	private String fechaSolicitud;
	private String fechaEntrevista;
	private String fechaEntregaInforme;
	private String resultado;
	private String curriculum;
	private String informe;
	private String perfil;
	private String comentarios;
	private EstadoVO estado;
	
	private MultipartFile fileCurriculum;
	private MultipartFile fileInforme;
	private MultipartFile filePerfil;

	public FichaVO() {
	}

	public FichaVO(int id, SucursalVO sucursal, String valorInforme,
			PostulanteVO postulante, CargoVO cargo, byte internoExterno,
			String fechaSolicitud, String fechaEntrevista,
			String fechaEntregaInforme, String resultado, String curriculum,
			String informe, String perfil, String comentarios, EstadoVO estado) {
		super();
		this.id = id;
		this.sucursal = sucursal;
		this.valorInforme = valorInforme;
		this.postulante = postulante;
		this.cargo = cargo;
		this.internoExterno = internoExterno;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrevista = fechaEntrevista;
		this.fechaEntregaInforme = fechaEntregaInforme;
		this.resultado = resultado;
		this.curriculum = curriculum;
		this.informe = informe;
		this.perfil = perfil;
		this.comentarios = comentarios;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public SucursalVO getSucursal() {
		return sucursal;
	}

	public String getValorInforme() {
		return valorInforme;
	}

	public PostulanteVO getPostulante() {
		return postulante;
	}

	public CargoVO getCargo() {
		return cargo;
	}

	public byte getInternoExterno() {
		return internoExterno;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public String getFechaEntrevista() {
		return fechaEntrevista;
	}

	public String getFechaEntregaInforme() {
		return fechaEntregaInforme;
	}

	public String getResultado() {
		return resultado;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public String getInforme() {
		return informe;
	}

	public String getPerfil() {
		return perfil;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setSucursal(SucursalVO sucursal) {
		this.sucursal = sucursal;
	}

	public void setCargo(CargoVO cargo) {
		this.cargo = cargo;
	}

	public EstadoVO getEstado() {
		return estado;
	}

	public void setEstado(EstadoVO estado) {
		this.estado = estado;
	}

	public MultipartFile getFileCurriculum() {
		return fileCurriculum;
	}

	public void setFileCurriculum(MultipartFile fileCurriculum) {
		this.fileCurriculum = fileCurriculum;
	}

	public MultipartFile getFileInforme() {
		return fileInforme;
	}

	public void setFileInforme(MultipartFile fileInforme) {
		this.fileInforme = fileInforme;
	}

	public MultipartFile getFilePerfil() {
		return filePerfil;
	}

	public void setFilePerfil(MultipartFile filePerfil) {
		this.filePerfil = filePerfil;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}