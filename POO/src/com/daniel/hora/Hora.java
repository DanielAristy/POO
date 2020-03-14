package com.daniel.hora;

public class Hora {
	
	private int hora;
	private int minutos;
	private int segundos;
	
	public Hora() {
		this.hora = 0;
		this.minutos = 0;
		this.segundos = 0;
	}

	public Hora( int hora, int minutos, int segundos) {
		if(valida(hora, minutos, segundos) == true) {
			this.hora = hora;
			this.minutos = minutos;
			this.segundos = segundos;
		} else {
			this.hora = 0;
			this.minutos = 0;
			this.segundos = 0;
		}
	}

	public void mostrar() {
		System.out.println(hora+":"+minutos+":"+segundos);
	}
	private boolean valida(int hora, int minutos, int segundos) {
		if(hora>= 0 && hora<= 23 && minutos>= 0 &&  minutos<= 59 && segundos>= 0 && segundos <= 59) {
			return true;
		}else {
			return false;
		}
	}
	public int aMinutos() {
		int cont=0;
		if(hora >= 12 && minutos < 59 ) {
			cont = (hora *60) + minutos;
			System.out.println(cont+" minutos");
		}else {
			cont = (hora* 60) + minutos;
			System.out.println(cont+" minutos");
			
		}
		return cont;
	}
	
	public void deMinutos(int minute) {
		int cont = minute/60;
		int cont1 =0;
		
		if (minute > 59 && minute <1440) {
			hora= cont;
			minutos = minute%60;
		}else {
			this.hora = 0;
			this.minutos = 0;
			this.segundos = 0;
			cont1++;
		}
		mostrar();
		System.out.println(cont1);
	}
	
	public void minutosDesde(Hora laHora) {
		int cont=0;
		
		System.out.println(hora+":"+minutos+":"+segundos+" -> "+laHora.hora+":"+laHora.minutos+":"+laHora.segundos);
		
		if ((igualHoras(laHora) && menorMinutos(laHora))) {
			cont=  laHora.minutos-this.minutos ;
			System.out.println(cont+" minutos");
		}else {
			
			if((igualHoras(laHora)  && mayorMinutos(laHora))) {
				cont=  this.minutos-laHora.minutos ;
				System.out.println(cont+" minutos");
			}else {
				
				if(this.hora < laHora.hora) {
					cont = ((laHora.hora-this.hora)*60) + (laHora.minutos - this.minutos);
					System.out.println(cont+" minutos");
				}else {
					
					if(this.hora > laHora.hora) {
					cont= ((this.hora-laHora.hora)*60) + (this.minutos-laHora.minutos);
					System.out.println(cont+" minutos");
					}else {
						System.out.println(cont+" minutos");
					}
				}
			}
		}	
	}
	
	public void siguiente() {
		if(this.hora < 23) {
			this.hora +=1;
		}else {
			this.hora =0;
		}
		mostrar();
	}
	
	public void anterior() {
		if(this.hora ==0) {
			this.hora =23;
			this.minutos =0;
			this.segundos=0;
		}else {
			this.hora -=1;
		}
		mostrar();
	}
	public boolean igualQue(Hora miHora) {
		if (igualHoras(miHora) && igualMinutos(miHora) && igualSegundos(miHora)) {
			System.out.println("Las horas son iguales!");
			return true;
		}else {
			System.out.println("Las horas son diferentes!");
			return false;
		}
	}
	
	public boolean menorQue(Hora menor) {
		if ((menorHoras(menor) || menorMinutos(menor)|| menorSegundos(menor) )) {
			System.out.println("correcto");
			return true;
		}else {
			System.out.println("Incorrecto");
			return false;
		}
	}
	public boolean  mayorQue(Hora mayor) {
		if ((mayorHoras(mayor) || mayorMinutos(mayor)|| mayorSegundos(mayor))) {
			System.out.println("correcto");
			return true;
		}else {
			System.out.println("Incorrecto");
			return false;
		}
	}
	
	public boolean igualHoras(Hora horas) {
		if (this.hora  == horas.hora) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean igualMinutos(Hora minutos) {
		if (this.minutos  == minutos.minutos) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean igualSegundos(Hora segundos) {
		if (this.segundos  == segundos.segundos) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean menorHoras(Hora menorHoras) {
		if (this.hora  < menorHoras.hora) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean menorMinutos(Hora menorMinutos) {
		if (this.minutos < menorMinutos.minutos) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean menorSegundos(Hora menorSegundos) {
		if (this.segundos < menorSegundos.segundos) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean mayorHoras(Hora mayorHora) {
		if (this.hora  > mayorHora.hora) {
			return true;
		}else {
			return false;
		}
	}
	public boolean mayorMinutos(Hora mayorMinutos) {
		if (this.minutos > mayorMinutos.minutos) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean mayorSegundos(Hora mayorSegundos) {
		if (this.segundos  > mayorSegundos.segundos) {
			return true;
		}else {
			return false;
		}
	}
}

