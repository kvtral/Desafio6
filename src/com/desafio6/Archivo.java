package com.desafio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Archivo {
	
	private String carpeta;
	private String archivoNombre;
	private String ruta;
	
	public Archivo (String carpeta, String archivoNombre) throws IOException {
		this.carpeta = carpeta;
		this.archivoNombre = archivoNombre;
		this.ruta = "src/" + this.carpeta + "/" + this.archivoNombre;
		
		crearDirectorio (this.carpeta);
		
	}
	
	public static void crearDirectorio (String directorio) throws IOException {
		
		try {
			File dir = new File("src/" + directorio);		

			if (!dir.exists()) {
				dir.mkdirs();
				System.out.println ("Carpeta " + directorio +" creado con exito");
			} else {
				System.out.println ("Carpeta " + directorio + " ya existe");
			}
		
		} catch (Exception e ) {
			System.out.println ("Error al crear directorio" + e);
		}
	}
	
	public void escribirArchivo (ArrayList<String> arr) {

        Iterator<String> iter= arr.iterator();
        boolean sobrescribir = false;
        Scanner sc = new Scanner(System.in);
        FileWriter fileW;

		try {
        	File fichero = new File(this.ruta);
        	if (fichero.exists()) {
        		System.out.println ("Archivo " + archivoNombre + " ya existe");
        		System.out.println ("**********************************************");
        		System.out.println ("* Puede sobrescribir archivo o agregar texto *");
        		System.out.println ("**********************************************");
        		System.out.println ("¿Desea sobrescribir archivo? (S/N)");
        		char respuesta = sc.next().charAt(0);
        		sobrescribir = (respuesta != 'S') ? false : true ;
        	}
        	
        	if (sobrescribir) {
        		fileW = new FileWriter(fichero);
        	} else {
        		fileW = new FileWriter(fichero, true);
        	}
        	
        	BufferedWriter buffW = new BufferedWriter(fileW);
        	
        	while(iter.hasNext()) {
        		buffW.write(iter.next() + "\n");
        	}
            
			buffW.close();
			fileW.close();
		
		}catch (Exception e){
			System.out.println("Excepcion escibiendo fichero : " + e);
		}
	}
	
	
	public int buscarTexto(String texto) {
		File fichero = new File(this.ruta);
		int contador = 0;	
	
		try {
			if (!fichero.exists()){
				System.out.println("El fichero ingresado no existe");
			} else {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String data = "";
		
				while((data = br.readLine()) != null) {
					System.out.println(data);
					if (data.equalsIgnoreCase(texto)) contador += 1; 
				}
		
				br.close();
				fr.close();
			}
		}
		catch (Exception e){
			System.out.println("Excepcion leyendo fichero : " + e);
		}
	
		return (contador);

	}
	
}
