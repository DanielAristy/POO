package com.daniel.DispensadorMecato;

public class Main {
	
	public static void main(String[] args) {
		
		
DispensadorDeMecato dispensador = new DispensadorDeMecato();
		
		dispensador.getProductos();
		
		System.out.println(dispensador.getUbicacion());
		System.out.println(" ");
		
		// Creo los productos
		Producto producto= new Producto("Papas de pollo",1500);    dispensador.getProductos().add(producto);
		Producto producto1= new Producto("Papas de limon",1500);  	dispensador.getProductos().add(producto1);
		Producto producto2= new Producto("Wafer jet",1000);        dispensador.getProductos().add(producto2);
		Producto producto3= new Producto("Bombonbum",600);        	dispensador.getProductos().add(producto3);
		Producto producto4= new Producto("Goloza",1300);           dispensador.getProductos().add(producto4);
		Producto producto5= new Producto("Chocorramo",1600);		  dispensador.getProductos().add(producto5);
		Producto producto6= new Producto("Mini chips",1100);       dispensador.getProductos().add(producto6);
		Producto producto7= new Producto("Ponque ramo",2000);      dispensador.getProductos().add(producto7);
		Producto producto8= new Producto("Arequipe",1000);         dispensador.getProductos().add(producto8);
		Producto producto9= new Producto("Burbujas",500);         dispensador.getProductos().add(producto9);
		
		//Sacar una unidad de un producto de acuerdo a su nombre
		dispensador.sacarProducto("Papas de pollo");dispensador.sacarProducto("Wafer jet");dispensador.sacarProducto("Wafer jet");dispensador.sacarProducto("Bombonbum");
		dispensador.sacarProducto("Papas de pollo");dispensador.sacarProducto("Wafer jet");dispensador.sacarProducto("Bombonbum");dispensador.sacarProducto("Bombonbum");
		dispensador.sacarProducto("Papas de limon");dispensador.sacarProducto("Wafer jet");dispensador.sacarProducto("Bombonbum");dispensador.sacarProducto("Bombonbum");
		dispensador.sacarProducto("Goloza");dispensador.sacarProducto("Chocorramo");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Mini chips");
		dispensador.sacarProducto("Goloza");dispensador.sacarProducto("Chocorramo");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Ponque ramo");
		dispensador.sacarProducto("Goloza");dispensador.sacarProducto("Chocorramo");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Ponque ramo");
		dispensador.sacarProducto("Goloza");dispensador.sacarProducto("Chocorramo");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Ponque ramo");
		dispensador.sacarProducto("Goloza");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Mini chips");dispensador.sacarProducto("Ponque ramo");
		dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");
		dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");
		dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");dispensador.sacarProducto("Arequipe");
		dispensador.sacarProducto("Burbujas");dispensador.sacarProducto("Burbujas");dispensador.sacarProducto("Burbujas");dispensador.sacarProducto("Burbujas");
		System.out.println("");
		
//		metodo para saber que porductos quedan disponible
		dispensador.imprimir();
		
//		Consultar los nombres de los productos agotados
		dispensador.productosAgotados();
		
//		Consultar el total de unidades de un producto determinado
		dispensador.unidadesProducto("Goloza");
		
//		Consultar el total de unidades de todos los productos
		dispensador.inventario();
		
//		Aumentar la cantidad de unidades a un producto determinado
		dispensador.aumentarCantidad(producto,2);
		System.out.println("");
		
		dispensador.imprimir();
	}
}
