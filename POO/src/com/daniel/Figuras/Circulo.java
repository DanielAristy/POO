package com.daniel.Figuras;

public class Circulo extends FiguraGeometrica {
	private double radio;
	
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	@Override
	public double calcularArea() {
		double areaCirculo;
		
		areaCirculo = Math.PI * (this.radio * this.radio );
		return areaCirculo;
	}
	
	@Override
	public double calcularPerimetro() {
		double perimetroCirculo;
		
		perimetroCirculo = (2 * Math.PI * this.radio);
		return perimetroCirculo;
	}
}
