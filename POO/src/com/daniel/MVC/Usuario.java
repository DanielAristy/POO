package com.daniel.MVC;

public class Usuario {
	private int id;
	private String nombre;
	private String labor;
	private int saldo;
	
	public Usuario(int id, String nombre, String labor, int saldo) {
		this.id = id;
		this.nombre = nombre;
		this.labor = labor;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getLabor() {
		return labor;
	}

	public void setLabor(String labor) {
		this.labor = labor;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	
	
}
