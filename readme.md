# Desafio 6 
### Lectura y Escritura Archivo en Java

En el siguiente desafío debes crear un archivo y un fichero. Se necesita escribir y leer desde
el archivo creado por el usuario.

### Autor
**Alvaro J. Carrillanca**   
*alvaro(dot)carrillanca(at)gmail.com*  
[Github/kvtral](https://github.com/kvtral/)

---

## Requerimientos

El archivo tendrá múltiples líneas y en cada línea un texto aleatorio.
Cada elemento debe corresponder a un texto precargado dentro de ArrayList que se
entregará en el requerimiento, esto debe implementarse para llenar el archivo.

```bash
Perro
Gato
Juan
Daniel
Juan
Gato
Perro
Camila
Daniel
Camila
```
### 1.-Crear un método llamado crearArchivo(directorio,fichero), este método recibe el nombre del directorio y el fichero como parámetros de entrada.

Se realizó otra aproximación para dar solución al ejericio planteado, se trabajo con una clase Archivo
que tendria como contructor el nombre de la carpeta y nombre de archivo. 

```java
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
```
### 2.- El nombre del fichero debe terminar con “.txt”, para indicar que es un archivo de texto.

Para dar solución a este requerimiento, se le solicita el nombre del archivo al usuario y posteriormente se le agrega .txt a la variable

```java
 		System.out.println("Introduca el nombre de la carpeta: ");
    	String carpeta = input.nextLine();
    	System.out.println("Introduco el nombre del archivo (sin extensión): ");
    	String archivo = input.nextLine() + ".txt";
```
### 3. Validar que el nombre del directorio no exista dentro del programa.
* **Si el directorio no existe, se debe crear.**
* **Si existe se mostrará el siguiente mensaje por consola**
* **Si existe algún otro problema al crear el directorio, se mostrará el siguiente mensaje por consola:**

En el metodo de creación de la carpeta que es llamado desde el contructor de la clase, se genera un try-catch para cumplir con el punto de si se genera un error imprima el error por pantalla, si no existe crea el directorio y si existe, indica que ya existe.

```java
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
```
### 4. Escribir en el archivo con un salto de línea lo que se encuentra en el ArrayList del inicio del requerimiento. Considerar utilizar *Iterator* para recorrer la lista

Para agregar el ArrayList existe un metodo en la clase Archivo que recibe un ArrayList y lo ingresa al archivo

```java
	public void escribirArchivo (ArrayList<String> arr) {
```
Por lo que en el Main del programa lo llamo desde el objeto creado (que ya contiene la ruta donde se encuentra)
```java
Archivo file = new Archivo (carpeta, archivo);
file.escribirArchivo(lista);
```
Para recorrer el ArrayList y agregarlo al archivo se utiliza *Iterator*
```java
Iterator<String> iter= arr.iterator();
    while(iter.hasNext()) {
        buffW.write(iter.next() + "\n");
    }
```
### 5. Crear un método llamado buscarTexto(nombreFichero,texto), este método recibe el nombre del fichero y el texto a buscar como parámetros de entrada

Como la solución planteada ocupa un objeto que contiene en si mismo su ruta (con nombre de archivo),  solo se crea el método que busque un texto recibido, pero el nombre del archivo no es necesario ya  que es parte de sus atributos.
```java
	public int buscarTexto(String texto) {
```
Y desde el main lo llamamos asi:

```java
    	System.out.println("Introduca el nombre del texto a buscar: ");
    	file.buscarTexto(input.nextLine());
```
### 6. Validar que el fichero exista. 
* **Si el fichero no existe, se mostrará el siguiente mensaje por consola.**  
```
El fichero ingresado no existe
```
Se genera un condicional para mostrar el mensaje en caso que no existe cuando se invoque al método buscar.-
```java
		File fichero = new File(this.ruta);

		try {
			if (!fichero.exists()){
				System.out.println("El fichero ingresado no existe");
			} else {
				FileReader fr = new FileReader(fichero);
				BufferedReader br=new BufferedReader(fr);
```
### 7. Si el fichero existe, contar las coincidencias del texto ingresado dentro del archivo.
```java
		FileReader fr = new FileReader(fichero);
		BufferedReader br=new BufferedReader(fr);
		String data = null;
		
		while((br.readLine())!=null) {
			data = br.readLine();
			System.out.println(data);
			if (data.equalsIgnoreCase(texto)) contador += 1; 
		}
```
### 8. Mostrar por consola la cantidad de veces que la palabra ingresada se encuentra en el texto.
```
cantidad de repeticiones del texto -> 2
```
En la clase Main, cuando llamamos al método buscarTexto de la clase Archivo, nos retorna el número de coincidencias de dicho texto dentro del fichero por lo que imprimimos por consola el resultado del retorno:
```java
    	System.out.println("Introduca el nombre del texto a buscar: ");
    	System.out.println(file.buscarTexto(input.nextLine()) + " coincidencias en el archivo con el texto ingresado");
```
Ejemplo
```
Introduca el nombre del texto a buscar: 
Gato
2 coincidencias en el archivo con el texto ingresado
```


### Bonus
Cuando escribimos en el archivo el ArrayList, consultamos si el archivo existe, si existe, le preguntamos al usuario si quiere sobrescribir el archivo o agregar inclusiones al final del archivo.
```java
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
```

## Contribuciones
Pull requests son bienvenidos. Si tiene alguna sugerencia o mejora que puede ser agregada también me puede escribir al correo indicado.





