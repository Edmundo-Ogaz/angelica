package cl.obeay.angelica.vo;
public class SucursalVO {

	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private ClienteVO cliente;
	
	public SucursalVO() {
	}

	public SucursalVO(int id, String nombre, String direccion,
			String telefono, ClienteVO cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public ClienteVO getCliente() {
		return cliente;
	}
}