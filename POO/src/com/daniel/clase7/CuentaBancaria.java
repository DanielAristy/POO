package com.daniel.clase7;

public class CuentaBancaria {
	
	public long numero;
	private double saldo;
	public String banco;
	
	public CuentaBancaria(long numero, String banco) {
		this.numero = numero;
		this.banco = banco;
		System.out.println("Se llama constructor con dos parametros");
	}

	public CuentaBancaria(long numero, double saldo, String banco) {
		this(numero, banco);
		this.consignar(saldo);
		System.out.println("Se llama constructor con tres parametros");
	}

	public void consignar(double valor) {
		saldo += valor;
	}
	
	public boolean retirar(double valorARetirar) {
		boolean operacionCorrecta;
		
		if(valorARetirar > saldo) {
			operacionCorrecta = false;
		} else {
			saldo -= valorARetirar;
			operacionCorrecta = true;
		}
		
		return operacionCorrecta;
	}
	
	public boolean transferir(CuentaBancaria destino, double valorATransferir) {
		boolean operacionCorrecta;
		
		if(valorATransferir > this.saldo) {
			operacionCorrecta = false;
		} else {
			this.saldo -= valorATransferir;
			destino.saldo += valorATransferir;
			operacionCorrecta = true;
		}
		
		return operacionCorrecta;
	}
	
	public void consultarSaldo() {
		System.out.println("El saldo actual es $" + saldo);
	}	

}
