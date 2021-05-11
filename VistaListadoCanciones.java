package daw2020.album;

import java.util.ArrayList;

/**
 * Controlador para la vista de listado
 *
 * @Author Rodrigo Miguez Lopez
 */

import java.util.Scanner;

public class VistaListadoCanciones extends VistaGeneral{

    /**
     * Constructor
     * @param in Scanner
     */
	
	public VistaListadoCanciones(Scanner in) {
		super(in);
	}
	   /**
     * Mostrar listado de canciones
     * @param arrayConunto Listado de datos de canciones en cadena
     */
	
	public void mostrarListado(ArrayList<String> arrayConjunto) {
		mostrarTexto("Listado de Canciones");
		for (String conjuntoCancion : arrayConjunto) {
			mostrarTexto("Datos de la cancion");
			mostrarTexto(conjuntoCancion);
			
		}
	}
	

	}
	

