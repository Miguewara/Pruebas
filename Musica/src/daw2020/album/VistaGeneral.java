package daw2020.album;

import java.io.PrintStream;
import java.util.Scanner;


/**
 * Clase abstracta con utilidades para las vistas
 *
 * @Author Rodrigo Miguez Lopez
 */
  public abstract class VistaGeneral {

	
	private Scanner in;
	private PrintStream out;
	
	  /**
     * Constructor
     *
     * @param scanner Scanner
     */
	
	public VistaGeneral(Scanner in) {
		this.in=in;
		out=System.out;
		
	}

	  /**
     * Mostrar texto por consola
     * @param texto Texto a mostrar por consola
     */
	
	public void mostrarTexto(String texto) {
		 out.printf("%s%n", texto);
		
	}
	
	 /**
     * Mostrar avisos por consola
     * @param aviso Aviso a mostrar por consola
     */
	
	public void mostrarAviso(String aviso) {
		out.printf("%n !*!*! %s%n%n", aviso);
		 
	}
	
	 /**
     * Pedir entrada de texto por consola
     * @return Resultado introducido por el usuario
     */
	
	protected String recogerTexto() throws VistasAltasException {
		
		String resultado ="";
		resultado=in.nextLine();
	        return resultado;
	    }
	
	 /**
     * Pedir numero al usuario
     * @return Numero introducido por le usuario
     */

	protected int recogerNumero() {
		int resultado =0;
		String s= in.nextLine();
		resultado=Integer.parseInt(s);
	        return resultado;
	}
	
	  /**
     * Petición de confirmación al usuario
     *
     * @param mensaje Mensaje de confirmación a mostrar
     * @return Confirmación del usuario verdadero o falso
     */
	
	public boolean confirmar(String mensaje) {
		boolean confirmacionAceptada = false;
		boolean confirmacionContestada = false;
		do {
			out.printf("%n%s%n", mensaje);
			out.printf("%n S / N%n");
			
			String entrada = in.nextLine();
			
			if ("S".equals(entrada.toUpperCase())) {
				confirmacionAceptada = true;
				confirmacionContestada = true;
			}
				else if ("N".equals(entrada.toUpperCase())) {
					confirmacionAceptada = false;
					confirmacionContestada = true;
			}
				else {
					confirmacionAceptada = false;
					confirmacionContestada = false;
			}
		}
		while (!confirmacionContestada);
			return confirmacionAceptada;
			
		}
}
