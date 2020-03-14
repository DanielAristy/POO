package com.daniel.taller1;

import java.util.ArrayList;

public class Asignatura {
	private String nombre;
	private int nroCreditos;
	private  Docente profesor;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	
	public Asignatura(String nombre, int nroCreditos) {
		this.nombre = nombre;
		this.nroCreditos = nroCreditos;
	}

	public Asignatura(Docente profesor) {
		this.profesor = profesor;
	}
	
	public Docente getProfesor() {
		return profesor;
	}

	public void setProfesor(Docente profesor) {
		this.profesor = profesor;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNroCreditos() {
		return nroCreditos;
	}
	public void setNroCreditos(int nroCreditos) {
		this.nroCreditos = nroCreditos;
	}
	
}
