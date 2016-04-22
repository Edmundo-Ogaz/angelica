package cl.obeay.angelica.vo;
public class CargoVO {

	private int codigo;
	private String nombre;

	public CargoVO() {
	}
	
	public CargoVO(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
}