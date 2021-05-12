package daw2020.album;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Vista para el menú por consola
 *
 * @Author Rodrigo Miguez Lopez
 */
public class VistaMenuConsola {
	private String título;
	private String[] opciones;

	private static int númRespuestas = 0;

	private Scanner in;
	private PrintStream out;

	public static int getNúmRespuestas() {
		return númRespuestas;
	}

	/**
     * Función para rellenar con un carácter ocupando el mismo espacio que una cadena de texto
     *
     * @param longitud Longitud de la cadena
     * @param c Carácter con el que se va a rellenar el espacio
     * @return Cadena para rellenar espacio
     */
	
	public static String rellenar(int longitud, char c) {
		String resultado;

		char[] relleno = new char[longitud];

		Arrays.fill(relleno, c);
		resultado = new String(relleno);

		return resultado;
	}
	
	  /**
     * Constructor
     *
     * @param optionesMenú Opciones del menú
     * @param scEntrada Scanner
     */

	public VistaMenuConsola(String[] opcionesMenú,
			Scanner scEntrada) {
		título = opcionesMenú[0];
		opciones = Arrays.copyOfRange(opcionesMenú, 1,
				opcionesMenú.length);

		in = scEntrada;
		out = System.out;
	}

	/**
     * Mostrar el menú
     */
	
	public void mostrarMenú() {
		final String FORMATO_OPCIONES = " %d) %s%n";

		out.println(rellenar(título.length(), '-'));
		out.println(título);
		out.println(rellenar(título.length(), '-'));

		for (int i = 1; i <= opciones.length; i++) {
			out.printf(FORMATO_OPCIONES, i,
					opciones[i - 1]);
		}
		out.printf(FORMATO_OPCIONES, 0, "SALIR");
	}

	/**
     * Mostrar invitacion al usuario
     * 
     */
	public void mostrarInvitación() {
		out.printf("%n  Escriba la opción que desea escoger → ");
	}
	/**
     * Mostrar mensaje al usuario
     * 
     * @param mensaje Mensaje que se muestra al usuario
     */
	public void mostrarMensaje(String mensaje) {
		out.printf("%n *** %s%n%n", mensaje);
	}

	   /**
     * Pedir al usuario la opción del menú
     *
     * @return Opción escogida por el usuario
     */
	
	public int pedirOpcion() {
		String s, mensaje;
		int entrada = -1;

		boolean salir = false;

		do {
			mostrarMenú();
			mostrarInvitación();

			// Recoger y validar opciones
			try {
				s = in.nextLine();
				entrada = Integer.parseInt(s);
				númRespuestas = getNúmRespuestas() + 1;
				if (entrada < 0
						|| entrada > opciones.length) {
					throw new CancionesNumberException(
							"Opción no válida");
				}
				salir = true;
			} catch (NumberFormatException e) {
				mostrarMensaje(
						"¡El sistema solo admite números enteros!");
			} catch (CancionesNumberException e) {
				mensaje = String.format(
						"¡Hay que introducir una opción de menú válida (1-%d, 0 para salir)!",
						opciones.length);
				mostrarMensaje(mensaje);
			}
		} while (!salir);
		return entrada;
	}
}
