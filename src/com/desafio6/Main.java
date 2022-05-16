package com.desafio6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
       // Cargamos un ArrayList con los datos entregados para ejercicio
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");
	
		Scanner input=new Scanner(System.in);
		
 		System.out.println("Introduca el nombre de la carpeta: ");
    	String carpeta = input.nextLine();
    	System.out.println("Introduco el nombre del archivo (sin extensi�n): ");
    	String archivo = input.nextLine() + ".txt";
	
    	// Instanciamos la clase Archivo y creamos el objeto file
    	Archivo file = new Archivo (carpeta, archivo);
	
    	//Llamamos al método escribirArchivo del objeto Archivo y le pasamos la lista
    			
    	file.escribirArchivo(lista);
    	
 		// Buscar texto en el archivo, para eso llamamos al metodo buscar texto del
    	// objeto tipo Archivo y le pasamos el texto a buscar, se lo pedimos al usuario
    			
    	System.out.println("Introduca el nombre del texto a buscar: ");
    	System.out.println(file.buscarTexto(input.nextLine()) + " coincidencias en el archivo con el texto ingresado");
    		
		input.close(); // Cerramos el objeto Scanner

	
	}
	
}
