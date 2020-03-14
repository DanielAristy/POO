package com.daniel.libreriaSwing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class creandoMarcos {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		miMarco marco = new miMarco();//intanciar la clase
		 marco.setVisible(true);
		 marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame.EXIT_ON_CLOSE termina con la ejecucion del programa
	}
}

class miMarco extends JFrame{
	
	private static final ImageIcon icono = new ImageIcon("src/com/daniel/Desafio_1/guayabas.png");
	public miMarco() {
		
		Toolkit marco = Toolkit.getDefaultToolkit();
		
		Dimension tamaņoPantalla = marco.getScreenSize();
//		setSize(500, 300);//tamaņo
//		setLocation(500, 250);//ubicacion en pantalla 
//		setBounds(500, 300, 350, 250);
//		setResizable(false);//Redimensionar la ventana
//		setTitle("Bienvenidos");
//		setExtendedState(JFrame.MAXIMIZED_BOTH);// maximinzar la ventana 
		//setIconImage(icono);
		int altura = tamaņoPantalla.height;
		int ancho = tamaņoPantalla.width;
		
		setSize(ancho/2, altura/2);//tamaņo
		setLocation(ancho/4, altura/4);//ubicacion en pantalla 
		
		Image imagen = marco.getImage("src/com/daniel/Desafio_1/guayabas.png");
		
		setIconImage(imagen);
		
		lamina lam = new lamina();
		
		add(lam);
	}
}

class lamina extends JPanel{
	 
	public void paintComponent(Graphics g ) {
		
		super.paintComponent(g);
		g.drawString("Linea de Escritura", 100, 100);
	}
}