package cl.tswoo.lab.modelapp.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class Usuario {
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@Positive
	private int edad;
	@Pattern(regexp="^\\d{1,2}\\.{0,1}\\d{3}\\.{0,1}\\d{3}\\-{0,1}(\\d|k|K)$", message="Ups, run no sigue el formato")
	private String run;
	
	public Usuario(String nombre, String apellido, int edad, String run) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.run = run;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}
	
	
}
