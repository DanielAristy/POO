package com.daniel.Desafio_1;

public class Jugador {

	private String nombre;
	private int saldo;
	
	public Jugador() {
		this.nombre = null;
		this.saldo = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
