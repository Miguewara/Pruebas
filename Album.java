package daw2020.album;

import java.util.ArrayList;
/**
 * Modelo de album
 * @Author Rodrigo Miguez Lopez
 */


public class Album {
	  /**
     * Declaracion de la lista
     */
	public ArrayList<Cancion> lista;
	  /**
     * Constructor
     */
	public Album() {
		lista = new ArrayList<Cancion>();
	};
	
	  /**
     * Añadir cancion al album
     * @param cancion La cancion que se va a añadir al album
     */
	
	public void añadir(Cancion cancion) {
		 lista.add(cancion);
	};

	  /**
     * Convierte la información de las canciones del album a una lista 
     * @return Información de las canciones
     */
	
	public ArrayList<String> toListaString() {

		ArrayList<String> listaCancionesString = new ArrayList<String>();
		for (Cancion cancion : lista) {
			listaCancionesString.add(cancion.toString());
	        }
	        return listaCancionesString;
		
	}
	   /**
    *
    * Convertir la información de las canciones a una listas en formato CSV
    * @param separator Separador del CSV
    * @return Información de las canciones en formato CSV
    */
	public ArrayList<String> toListaStringCSV(String separador) {

		 ArrayList<String> listaCancionesStringCSV = new ArrayList<String>();
	        for (Cancion cancion : lista) {
	        	listaCancionesStringCSV.add(cancion.toStringCSV(separador));
	        }
	        return listaCancionesStringCSV;
	}

	

		
	}
	
