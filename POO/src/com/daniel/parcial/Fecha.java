package com.daniel.parcial;

import java.util.ArrayList;
import java.util.Arrays;

public class Fecha {
	private int day;
	private int month;
	private int year;
	public ArrayList<String>  meses = new ArrayList<>(Arrays.asList("Enero","Febrero","Marzo", "Abril"," Mayo", "Junio","Julio"
			,"Agosto","Septiembre", "Octubre", "Noviembre","Diciembre")) ;
	
	public ArrayList<String> dias = new ArrayList<>(Arrays.asList("Primero", "Segundo","Tercero","Cuarto","Quinto","Sexto",
			"Septimo","Octavo","Noveno","Decimo","Once"," Doce","Trece","Catorce","Quince","Dieciseis","diecisiete","Diecciocho",
			"Diesinueve", "Veinte"," Veintiuno","Veitidos","Veintitres","Veinticuatro","Veinticinco","Veintiseis","Veintisiete","Veintiocho",
		"Veintinueve","Treinta"));
	
	public Fecha() {
		day = 13;
		month = 9;
		year = 2017;
	}
	public Fecha(int day, int month, int year) {
		if (validar(day, month,  year) == true) {
			this.day = day;
			this.month = month;
			this.year = year;
		}else {
			this.day = 13;
			this.month = 9;
			this.year = 2017;
		}
	}
	
	private boolean validar(int dia,int mes,int year) {
		if(day >=0 && day <= 30 && month >=0 &&  month <= 12 && year >=2000 && year <= 2020) {
			return true;
		}
		return false;
	}
	public void mostrar() {
		System.out.println(day +"/"+ month +"/"+year);
	}
	
	public void getNombreDias() {
		String nombreDia;
		int con = this.day;
		
		for (int i = 0; i < this.dias.size(); i++) {
			nombreDia = this.dias.get(con-1);
			System.out.println(nombreDia);
			break;
		}
	}
	public void getNombreMes() {
		
		String nombreMes;
		int cont = this.month;
		
		for (int i = 0; i < this.meses.size(); i++) {
			nombreMes = this.meses.get(cont - 1);
			System.out.println(nombreMes);
			break;
		}
	}
	
	public void tomorrow() {
		if(this.day < 30 && this.month <12 && this.year < 2020) {
			this.day++;
		}else {
			this.day = 1;
			this.month++;
		}
	}
	public int comparar(Fecha otraFecha) {
		int cont = 0;
		
		if (this.day > otraFecha.day || this.month > otraFecha.month || this.year > otraFecha.year) {
			cont =1;
		}else {
			if (this.day == otraFecha.day && this.month == otraFecha.month && this.year == otraFecha.year) {
				cont = 2;
			}else {
				cont = 3;
			}
		}
		return cont;
	}

}
