package daw2020.album;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Vista de las altas de las canciones
 *
 * @Author Rodrigo Miguez Lopez
 */

public class VistaAltaCanciones extends VistaGeneral{

	 private PrintStream out;
	 
	  /**
	     * Controlador
	     * @param in Scanner
	     */
	public VistaAltaCanciones(Scanner in) {
		super(in);
		out = System.out;
		
	}

		  /**
	     * Formulario de alta de nueva cancion
	     * @return Cancion dada de alta
	     */
		
	
			public boolean gestionarAlta(Cancion cancionNueva) {
				
			boolean datosCorrectos=false;
			
			do {
					try {
			
			
				out.println("Registro de nueva cancion");
				mostrarTexto("Nombre: ");
				cancionNueva.setNombre(recogerTexto());
				mostrarTexto("Duracion: ");
				cancionNueva.setDuracion(recogerTexto());
				mostrarTexto("Genero: ");
				cancionNueva.setGenero(recogerTexto());
				mostrarTexto("Año: ");
				cancionNueva.setAño(recogerNumero());
				mostrarTexto("Artista: ");
				cancionNueva.setArtista(recogerTexto());
				
				datosCorrectos=true; }
					catch (VistasAltasException e ){
						mostrarAviso("Codigo introducido incorreto. ");
					}
			}  while(!datosCorrectos);
			
		
					
	return datosCorrectos;
}
			
		    /**
		     * Confirmación para crear nueva cancion
		     *
		     * @param cancion Cancion a confirmar
		     * @return Confirmación del usuario verdadero o falso
		     */
			
			 public boolean confirmPlayer(Cancion cancion) {
			       mostrarTexto("Datos del jugador:");
			        mostrarTexto(cancion.toString());
			        return confirmar("¿Dar de alta el jugador?");
			    }
}
