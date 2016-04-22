package cl.obeay.angelica.vo;
public class ClienteVO {

	private String rut;
	private String nombre;
	private String razonSocial;
	private String fechaPago;
	private String valorInforme;
	private String entregaInforme;

	public ClienteVO() {
	}

	public ClienteVO(String rut, String nombre, String razonSocial,
			String fechaPago, String valorInforme, String entregaInforme) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.fechaPago = fechaPago;
		this.valorInforme = valorInforme;
		this.entregaInforme = entregaInforme;
	}



	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public String getValorInforme() {
		return valorInforme;
	}

	public String getEntregaInforme() {
		return entregaInforme;
	}
	
	
}