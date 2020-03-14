
package com.daniel.taller1;


public class Main {

	public static void main(String[] args) {
		//Creando las asignaturas
		
		Asignatura poo = new Asignatura("Poo",4);
		
		poo.getEstudiantes();
		
		//Creando docentes
		Docente docente = new Docente("1234567890", "Alejandro Ramirez");
		
		poo.setProfesor(docente);
		
		// Asignacion de docente a sus materia
		
		// Creando las notas
			Nota nota = new Nota(poo, 3, 4, 3.5);
			Nota nota1 = new Nota(poo, 2, 3.5, 3.5);
			Nota nota2 = new Nota(poo, 2, 4, 4);
			Nota nota3 = new Nota(poo, 5, 4, 3.5);
			Nota nota4 = new Nota(poo, 2, 2.5, 3.3);
			Nota nota5 = new Nota(poo, 2, 4, 3.5);
			
			nota.setAsignatura(poo);
				
		
		//Creando los estudiante
		Estudiante alumno = new Estudiante("1002344576", "Daniel Aristy");
		Estudiante alumno1 = new Estudiante("1234578901", "Juan Lopez");
		Estudiante alumno2 = new Estudiante("1987654342", "Sara Gomez");
		Estudiante alumno3 = new Estudiante("1987654342", "Karen Nalga");
		Estudiante alumno4 = new Estudiante("1987654342", "Chimo Strufia");
		Estudiante alumno5 = new Estudiante("1567894303", "Gabo Roto");
		
		//Alumnos a los cursos
		poo.getEstudiantes().add(alumno);
		poo.getEstudiantes().add(alumno1);
		poo.getEstudiantes().add(alumno2);
		poo.getEstudiantes().add(alumno3);
		poo.getEstudiantes().add(alumno4);
		poo.getEstudiantes().add(alumno5);
		
		//Nota Final de los estudiantes
		alumno.setNota(nota);
		alumno1.setNota(nota1);
		alumno2.setNota(nota2);
		alumno3.setNota(nota3);
		alumno4.setNota(nota4);
		alumno5.setNota(nota5);
		
		
		for (int i = 0; i < poo.getEstudiantes().size(); i++) {
			System.out.println("Materia: "+poo.getEstudiantes().get(i).getNota().getAsignatura().getNombre());
			System.out.println("Docente: "+poo.getEstudiantes().get(i).getNota().getAsignatura().getProfesor().getNombre());
			System.out.println("Alumno: "+poo.getEstudiantes().get(i).getNombre());
			System.out.println("Nota final: "+poo.getEstudiantes().get(i).getNota().getFinal());
			System.out.println("");
		}
	
	}
}
