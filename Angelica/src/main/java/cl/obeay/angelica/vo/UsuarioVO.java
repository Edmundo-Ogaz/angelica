package cl.obeay.angelica.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class UsuarioVO implements java.io.Serializable {

	private String username;
	private GrupoVO grupo;
	private String password;

	public UsuarioVO() {
	}

	public UsuarioVO(String username) {
		this.username = username;
	}

	public UsuarioVO(String username, GrupoVO grupo, String password) {
		this.username = username;
		this.grupo = grupo;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public GrupoVO getGrupo() {
		return this.grupo;
	}

	public String getPassword() {
		return this.password;
	}
}