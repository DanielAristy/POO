package com.daniel.DispensadorMecato;

public class Producto {
	
	private String nombre;
	private int precio;
	protected int c_Producto;
	
	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.c_Producto = 12;
		this.precio = precio;
	}
	protected int getC_Producto() {
		return c_Producto;
	}
	protected void setC_Producto(int c_Producto) {
		this.c_Producto = c_Producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
