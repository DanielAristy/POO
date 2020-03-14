package com.daniel.clase7;

public class Principal {
	
	public static void main(String[] args) {
//		DispensadorDeAgua botellon = new DispensadorDeAgua();
//		botellon.llenar(); 
//		
//		botellon.servir(100);
//		botellon.llenar();
//		botellon.servir(10);
//		botellon.vaciar();
//		botellon.servir(3);
		
		CuentaBancaria miCuentaB = new CuentaBancaria(1234, 100000, "Corpbanca");
		CuentaBancaria otraCuenta = new CuentaBancaria(31610, "Bancolombia");
		
		
		miCuentaB.consignar(75000);
		otraCuenta.consignar(4000000);

		miCuentaB.consultarSaldo();
		otraCuenta.consultarSaldo();
		
		boolean transferenciaExitosa = otraCuenta.transferir(miCuentaB, 3900000);
		System.out.println(transferenciaExitosa);
		
		miCuentaB.consultarSaldo();
		
		otraCuenta.retirar(90000);
		
		otraCuenta.consultarSaldo();
	
	
	}
}
