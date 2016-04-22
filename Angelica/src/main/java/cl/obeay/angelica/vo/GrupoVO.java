package cl.obeay.angelica.vo;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class GrupoVO implements java.io.Serializable {

	private int codigo;
	private String nombre;

	public GrupoVO() {
	}

	public GrupoVO(int codigo) {
		this.codigo = codigo;
	}

	public GrupoVO(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

}
