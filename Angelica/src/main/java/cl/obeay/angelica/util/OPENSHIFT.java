package cl.obeay.angelica.util;

public enum OPENSHIFT {
	
	DATA_DIR("OPENSHIFT_DATA_DIR", "Dirección para guardar archivos en openshift");
	
	private String codigo;
	private String descripccion;
	
	private OPENSHIFT(String codigo, String descripccion) {
		this.codigo = codigo;
		this.descripccion = descripccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripccion() {
		return descripccion;
	}
	
	
	

}
