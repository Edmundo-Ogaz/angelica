package cl.obeay.angelica.vo;
public class EstadoVO {

	private String codigo;
	private String nombre;

	public EstadoVO() {
	}
	
	public EstadoVO(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
}