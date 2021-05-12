package daw2020.album;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Utilidades de acceso a los archivos 
 * @Author Rodrigo Miguez Lopez
 */
public class AccesoArchivo {

    /**
     * Escribir contenido en archivo
     *
     * @param rutaArchivo Ruta del archivo
     * @param texto Contenido del archivo
     */
	public static void escribir(String rutaArchivo, String texto) {
		File refArchivo = new File(rutaArchivo);
		try {
			FileWriter fs = new FileWriter(refArchivo);
			PrintWriter out = new PrintWriter(fs);
			out.println(texto);
			out.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s", e.getLocalizedMessage());
		}
	}
	  /**
     * Leer archivo 
     *
     * @param rutaArchivo Ruta del archivo
     * @return Contenido del fichero en formato de cadena de texto
     */
	public static String leer(String rutaArchivo) {
		String texto = null;
		File refArchivo = new File(rutaArchivo);
		try {
			FileReader fr = new FileReader(refArchivo);
			BufferedReader in = new BufferedReader(fr);
			texto = in.readLine();
			in.close();
			System.out.println(texto);
		} catch (FileNotFoundException e) {
			System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de lectura: %s", e.getLocalizedMessage());
		}
		return texto;
	}
}
