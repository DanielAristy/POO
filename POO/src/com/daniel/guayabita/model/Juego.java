package com.daniel.guayabita.model;

import javax.swing.*;
import java.util.ArrayList;

public class Juego {

    private String titulo;
    private int instrucciones;
    private int pote;
    private ArrayList<Jugador> jugadores;
    private static ArrayList<ImageIcon> imagenes;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(int instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getPote() {
        return pote;
    }

    public void setPote(int pote) {
        this.pote = pote;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ImageIcon> imagenes) {
        this.imagenes = imagenes;
    }

    public  static ArrayList<ImageIcon> imageList(){

        return imagenes;
    }
}
