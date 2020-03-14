package com.daniel.DispensadorMecato;

import java.util.ArrayList;

public class DispensadorDeMecato {
	private String ubicacion;
	private ArrayList<Producto> productos;

	public DispensadorDeMecato() {
		this.ubicacion = "¡Dispensador de mecato Parque Principal Marinilla!";
		this.productos = new ArrayList<Producto>();
	}
	
	public void sacarProducto(String nombre) {
		
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getNombre() == nombre) {
				if(productos.get(i).c_Producto > 0) {
					productos.get(i).c_Producto -=1;
					break;
				}
				System.out.println("Agotados");
			}
		}
	}
	
	public int productosAgotados() {
		
		int cont = 0;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).c_Producto == 0) {
				cont++;
				System.out.println(productos.get(i).getNombre()+" producto Agotado");
			}
		}
		if (cont == 0) {
			System.out.println(" Productos agotados!");
		}
		
		return cont;
		
	}

	public void unidadesProducto(String nombre) {
		
		int cont = 0;
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getNombre() == nombre) {
				cont = productos.get(i).c_Producto;
				System.out.println("Unidades de "+productos.get(i).getNombre()+": "+cont);
			}
		}
	}
	
	public int inventario() {
		
		int cont=0;
		
		for (int i = 0; i < productos.size(); i++) {
			cont = cont + productos.get(i).c_Producto;
		}
		System.out.println("Inventario del Dispensador: "+cont );
		return cont;
	}
	
	public boolean aumentarCantidad(Producto articulo, int cantidad) {
		int posicion, cont;
	
		posicion = productos.indexOf(articulo);
		cont = productos.get(posicion).c_Producto +cantidad;
	
		if (cont <= 12) {
			productos.get(posicion).c_Producto = cont;
			System.out.println("Si es posible!");
			return true;
		}else {
			System.out.println("No es posible");
			return false;
		}

	}
	
	public void imprimir() {
		for (int i = 0; i < productos.size(); i++) {
			System.out.println("Producto: "+productos.get(i).getNombre());
			System.out.println("Unidades: "+productos.get(i).c_Producto);
			System.out.println("Precio: "+productos.get(i).getPrecio());
			System.out.println(" ");
		}
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public String getUbicacion() {
		return ubicacion;
	}
}


