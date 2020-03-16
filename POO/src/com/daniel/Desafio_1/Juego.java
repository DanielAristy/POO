package com.daniel.Desafio_1;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.omg.CORBA.Environment;

public class Juego {
	
	private static final String INSTRUCCIONES_JUEGO = 
			"Sí el jugador saca 1 o 6 entonces pierde la posibilidad de apostar y por ende\n"
			+"cede el turno al otro jugador.\n\n"
			+ "Sí por el contrario saca un número del 2 al 5 tiene la posibilidad de apostar por\n"
		    +"el pote que hay en juego. Si elige que no quiere apostar cede su turno, pero sí\n"
			+"quiere hacerlo el juego le debe permitir ingresar el monto por el que desea\n"
			+"apostar y luego tirar nuevamente el dado.\n\n"
			+"El jugador puede apostar por la totalidad del pote o por una parte (por ejemplo,\n"
			+"si el pote es de $1200 el jugador puede apostar $1200 o un valor inferior). Se\n"
			+"debe controlar que el jugador si cuente con el valor de la apuesta que desea\n"
			+"realizar.\n\n"
			+"Sí el jugador saca un número mayor al que sacó en la tirada anterior entonces\n"
			+"se lleva el dinero del pote (la parte que apostó). Si por el contrario el jugador\n"
			+"saca un número igual o inferior entonces tendrá que entregar lo que apostó al\n"
			+"pote y así este irá aumentando.\n\n"
			+"Sí después de una jugada el pote queda en $0, el juego vuelve a comenzar con\n"
			+"$200 (Ambos jugadores aportan de a $100).\n\n"
			+"Después de esto al otro jugador se le pregunta si desea lanzar el dado y\n"
			+"comienza su flujo nuevamente.\n\n"
			+"El juego termina cuando uno de los dos jugadores no tenga dinero suficiente\n"
			+"para iniciar una ronda.";
	
	private  static final ImageIcon ICONO = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\guayabas.png");
	private  static final ImageIcon UNO = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\uno.png");
	private  static final ImageIcon DOS = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\dos.png");
	private  static final ImageIcon TRES = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\tres.png");
	private  static final ImageIcon CUATRO = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\cuatro.png");
	private  static final ImageIcon CINCO = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\cinco.png");
	private  static final ImageIcon SEIS = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Desafio_1\\seis.png");
	
	private static final String INICIO_JUEGO = "Bienvenido al juego de la Guayabita !\n\n ¿Que quieres hacer?";
	private static  final String  TITULO = "Guayabita";
	private static final int APUESTA_MINIMA_POR_JUGADOR = 100;
	private ArrayList<Jugador> jugadores;
	private ArrayList<ImageIcon> dados;
	private int pote = 0;
	
	public int generarRandom() {
		int generarDado = (int)Math.floor(Math.random()*6);
		return generarDado;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, TITULO, JOptionPane.INFORMATION_MESSAGE, ICONO);
	}
	
	public Juego() {
		dados = new ArrayList<ImageIcon>();
		dados.add(UNO);
		dados.add(DOS);
		dados.add(TRES);
		dados.add(CUATRO);
		dados.add(CINCO);
		dados.add(SEIS);
	}
	
	public void sumarAl_Pote(int apuesta) {
		setPote(getPote()+ apuesta);
	}
	public void restarAl_Pote(int apuesta) {
		setPote(getPote()- apuesta);
	}

	public void apuestaJugadores(){
		if (getPote() == 0) {
			jugadores.forEach(jugador -> jugador.setSaldo(jugador.getSaldo() - APUESTA_MINIMA_POR_JUGADOR));
			setPote(APUESTA_MINIMA_POR_JUGADOR * jugadores.size());
		}
	}


	public void inicio() {
		
		Jugador j1  = new Jugador();
		Jugador j2  = new Jugador();
		
		jugadores = new ArrayList<Jugador>();
		
		boolean verificar = false , entrar = true , entradaNro1 = false,entradaNro2 = false;
		
		int turno = 0, contInst = 0, opcion , saldoJug1 = 0,saldoJug2 = 0;
		
		while (entrar == true) {
			
				opcion = JOptionPane.showOptionDialog(null, INICIO_JUEGO, TITULO, JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,ICONO, new String[] { "Jugar", "Ver instrucciones" }, null);
			
			if (opcion == 0 && verificar == false ) {
				
				String nombreJugador1 , nombreJugador2;
				int saldoJugador1,saldoJugador2;
				
				//Control de la entrada de datos
				do {
					nombreJugador1 = (String) JOptionPane.showInputDialog(null,"Nombre del jugador 1"
							,TITULO,JOptionPane.DEFAULT_OPTION,ICONO,null, null);
					
				} while ((nombreJugador1.equals(null)) || (nombreJugador1.trim().isEmpty()));
				
				do {
					try {
						saldoJugador1 =  Integer.parseInt((String) JOptionPane.showInputDialog(null,"Saldo del jugador 1"
								,TITULO,JOptionPane.DEFAULT_OPTION,ICONO,null, null));
						entradaNro1 = true;
						saldoJug1 = saldoJugador1;
					} catch (NumberFormatException e) {
						
						mostrarMensaje("Error solo numeros, y mayores a 200");
					}
					
				} while ( saldoJug1 < 200 || !entradaNro1);
				
				do {
					nombreJugador2 = (String) JOptionPane.showInputDialog(null,"Nombre del jugador 2"
							,TITULO,JOptionPane.DEFAULT_OPTION,ICONO,null, null);
					
				} while ((nombreJugador2.equals(null)) || nombreJugador2.trim().isEmpty());
				
				do {
					try {
						saldoJugador2 =  Integer.parseInt((String) JOptionPane.showInputDialog(null,"Saldo del jugador 2 "
								,TITULO,JOptionPane.DEFAULT_OPTION,ICONO,null, null));
						entradaNro2 = true;
						saldoJug2 = saldoJugador2;
					} catch (NumberFormatException e) {
						
						mostrarMensaje("Error solo numeros, y mayores a 200");
					}
					
				} while ( saldoJug2 < 200 || !entradaNro2);
				
				j1.setNombre(nombreJugador1);
				j1.setSaldo(saldoJug1);
				j2.setNombre(nombreJugador2);
				j2.setSaldo(saldoJug2);
				
				//Ingresar jugadores a un array
				jugadores.add(j1);
				jugadores.add(j2);
				
				verificar = true;
				boolean conPrimera = false , conSegunda = false;
				
				while(verificar == true) {
					
					apuestaJugadores();
					
					int apuesta = JOptionPane.showOptionDialog(null, jugadores.get(turno).getNombre()+","+" el pote actual es de "+ getPote()+
											"\n\n  ¿Deseas lanzar el dado?", TITULO, JOptionPane.DEFAULT_OPTION,
											JOptionPane.QUESTION_MESSAGE,ICONO, new String[] { "Si", "No" }, null);
					
					if (turno == 0) {//Turno del jugador 1
						if(apuesta == 0 ) {
							conPrimera = true;
							
							int tuPrimerDado = generarRandom();
							
							int tuDado_Jugador = JOptionPane.showOptionDialog(null,j1.getNombre()+", este es tu dado. \n\n"
									+ " ¿Deseas hacer una apuesta?", TITULO, JOptionPane.DEFAULT_OPTION,
									JOptionPane.QUESTION_MESSAGE,dados.get(tuPrimerDado), new String[] { "Si", "No" }, null);
							
							
							if (dados.get(0).equals(dados.get(tuPrimerDado)) || dados.get(5).equals(dados.get(tuPrimerDado))) {
								turno = 1;
								
							}else if (tuDado_Jugador == 0) {
										int apuestaJugador1;
										
										do {//Control de la apuesta
											apuestaJugador1 = Integer.parseInt((String) JOptionPane.showInputDialog(null,
													jugadores.get(turno).getNombre()+". Este es tu saldo "+jugadores.get(turno).getSaldo()+"\n\n (El pote actual es de "
											+getPote()+")",TITULO,JOptionPane.DEFAULT_OPTION,ICONO,null, null));
											
											if( apuestaJugador1 > getPote()) {
												mostrarMensaje("Monto es mayor al pote");
											}
											
										} while (apuestaJugador1 > getPote() || apuestaJugador1 > jugadores.get(turno).getSaldo());
										
										if (apuestaJugador1 <= getPote() && jugadores.get(turno).getSaldo() >= apuestaJugador1) {
											int tuSegundoDado = generarRandom();
											JOptionPane.showMessageDialog(null, "Este fue tu segundo dado", TITULO, JOptionPane.INFORMATION_MESSAGE,
													dados.get(tuSegundoDado));
											
											if (tuPrimerDado < tuSegundoDado) {
												restarAl_Pote(apuestaJugador1);
												jugadores.get(turno).setSaldo(jugadores.get(turno).getSaldo() + apuestaJugador1);
												mostrarMensaje("Ganaste! Tu saldo es "+jugadores.get(turno).getSaldo());
												
											}else if(tuPrimerDado >= tuSegundoDado){
												sumarAl_Pote(apuestaJugador1);
												jugadores.get(turno).setSaldo(jugadores.get(turno).getSaldo() - apuestaJugador1);
												mostrarMensaje("Perdiste! Tu saldo es "+jugadores.get(turno).getSaldo());
											}
											
											if (getPote() > 0 && jugadores.get(turno).getSaldo() == 0) {
							 					int saldoFinal = jugadores.get(turno+1).getSaldo()+getPote();
												mostrarMensaje("El ganador es "+jugadores.get(turno+1).getNombre()+" $ "+saldoFinal);
												verificar = false;
												entrar = false;
												}
											turno = 1;
										}
										
								}else if (tuDado_Jugador == 1) turno = 1;
							
						}else if (apuesta == 1 ) {
								if (conPrimera == false) {
									
									if (JOptionPane.OK_OPTION == 0) {
										verificar = false;
										entrar = false;
									}
								}else {
										turno = 1;
								}
						}	
						
					}else if (turno == 1) { //Turno del jugador 2
							if(apuesta == 0) {
								
								conSegunda = true;
								
								int tuPrimerDado = generarRandom();
								
								int tuDado_Jugador2 = JOptionPane.showOptionDialog(null,j2.getNombre()+", este es tu dado. \n"
										+ " ¿Deseas hacer una apuesta?", TITULO, JOptionPane.DEFAULT_OPTION,
										JOptionPane.QUESTION_MESSAGE,dados.get(tuPrimerDado), new String[] { "Si", "No" }, null);
								
								if (dados.get(0).equals(dados.get(tuPrimerDado)) || dados.get(5).equals(dados.get(tuPrimerDado))) {
									turno = 0;
									
								}else if (tuDado_Jugador2 == 0) {
									
									int apuestaJugador2;
									
									do {//Control de la apuesta
										
										apuestaJugador2  = Integer.parseInt((String) JOptionPane.showInputDialog(null, jugadores.get(turno).getNombre()+
												". Este es tu saldo "+jugadores.get(turno).getSaldo()+"\n\n(El pote actual es de "+getPote()+")",TITULO,
												JOptionPane.DEFAULT_OPTION,ICONO,null, null));
										
										if (apuestaJugador2 > getPote()) {
											mostrarMensaje("Monto es mayor al pote");
										}
										
									} while (apuestaJugador2 > getPote() || apuestaJugador2 > jugadores.get(turno).getSaldo());
									
									if (apuestaJugador2 <= getPote() && jugadores.get(turno).getSaldo() >= apuestaJugador2) {
										
										int tuSegundoDado = generarRandom();
										JOptionPane.showMessageDialog(null, "Este fue tu segundo dado", TITULO, JOptionPane.INFORMATION_MESSAGE,
												dados.get(tuSegundoDado));
										
										if (tuPrimerDado < tuSegundoDado) {
											restarAl_Pote(apuestaJugador2);
											jugadores.get(turno).setSaldo(jugadores.get(turno).getSaldo() + apuestaJugador2);
											mostrarMensaje("Ganaste! Tu saldo es "+jugadores.get(turno).getSaldo());
											
										}else if(tuPrimerDado >= tuSegundoDado){
											sumarAl_Pote(apuestaJugador2);
											jugadores.get(turno).setSaldo(jugadores.get(turno).getSaldo() - apuestaJugador2);
											mostrarMensaje("Perdiste! Tu saldo es "+jugadores.get(turno).getSaldo());
										}
										
										if (getPote() > 0 && jugadores.get(turno).getSaldo() == 0) {
											int saldoFinal = jugadores.get(turno-1).getSaldo()+getPote();
											mostrarMensaje("El ganador es "+jugadores.get(turno-1).getNombre()+" $ "+saldoFinal);
											verificar = false;
											entrar = false;
										}
										turno = 0;
									}
									
								}else if (tuDado_Jugador2 == 1) turno = 0;
								
				
							}else if (apuesta == 1) {
								if (conSegunda  == false) {
									mostrarMensaje("Ganador del juego "+ jugadores.get(turno-1).getNombre());
									
									if (JOptionPane.OK_OPTION == 0) {
										verificar = false;
										entrar = false;
									}
								}else {
										turno = 0;
								}
							}
					}
				}
			}else if (opcion == 1 && contInst <= 0) {
				JOptionPane.showMessageDialog(null, INSTRUCCIONES_JUEGO, TITULO, JOptionPane.INFORMATION_MESSAGE, ICONO);
				contInst++;
				
				if(JOptionPane.OK_OPTION == 0) contInst--;
			}
		}
		
	}
	
	public int getPote() {
		return pote;
	}

	public void setPote(int pote) {
		this.pote = pote;
	}
}

