package cl.obeay.angelica.model;

// Generated 18-04-2016 02:42:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Postulante generated by hbm2java
 */
@Entity
@Table(name = "postulante", catalog = "angelica")
public class Postulante implements java.io.Serializable {

	private String rut;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String telefono;
	private String celular;
	private Set<Ficha> fichas = new HashSet<Ficha>(0);

	public Postulante() {
	}

	public Postulante(String rut) {
		this.rut = rut;
	}

	public Postulante(String rut, String nombre, String apellidoPaterno,
			String apellidoMaterno, String telefono, String celular,
			Set<Ficha> fichas) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.celular = celular;
		this.fichas = fichas;
	}

	@Id
	@Column(name = "rut", unique = true, nullable = false, length = 10)
	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellidoPaterno", length = 45)
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(name = "apellidoMaterno", length = 45)
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Column(name = "telefono", length = 45)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "celular", length = 45)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postulante")
	public Set<Ficha> getFichas() {
		return this.fichas;
	}

	public void setFichas(Set<Ficha> fichas) {
		this.fichas = fichas;
	}

}