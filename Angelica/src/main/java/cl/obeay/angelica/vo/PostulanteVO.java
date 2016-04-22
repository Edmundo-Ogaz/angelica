package cl.obeay.angelica.vo;
public class PostulanteVO {

	private String rut;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String telefono;
	private String celular;

	public PostulanteVO() {
	}

	public PostulanteVO(String rut, String nombre, String apellidoPaterno,
			String apellidoMaterno, String telefono, String celular) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.celular = celular;
	}



	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCelular() {
		return celular;
	}
}