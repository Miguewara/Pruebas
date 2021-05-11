package daw2020.album;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Controlador principal del programa
 *
 * @Author Rodrigo Miguez Lopez
 */



public class ControlCanciones {
	private static final String[] OP_MENÚ_PRINCIPAL = {
			"Canciones", "Dar de alta nueva cancion", "Listar cancniones", "Exportar canciones",
			"Importar canciones" };
	private Scanner in;
	private Album canciones ;
	 /**
     * Constructor
     * @param in Scanner
     */
	public ControlCanciones(Scanner in) {
		this.in = in;
		canciones = new Album();
	}

	  /**
     * Bucle principal 
     */
	private void buclePrincipal() {
		String[] opciones = OP_MENÚ_PRINCIPAL;
		VistaMenuConsola menú = new VistaMenuConsola(
				opciones, in);

		int entrada = -1;

		// Bucle general
		do {
			entrada = menú.pedirOpcion();
			switch (entrada) {
			case 0: // Salir
				menú.mostrarMensaje("¡¡¡A-D-I-O-S!!");
				break;
			case 1: // Dar de alta una cancion
				darDeAlta();
				break;
			case 2: // Listar canciones
				listadoCanciones();
				break;
			case 3: // Exportar canciones
				try {
					volcarCanciones();
				} catch (CancionesFileException e) {
					String mensaje = String.format("Atencion: %s",e.getMessage());
					menú.mostrarMensaje(mensaje);
				}
				break;
				
			case 4: // Importar canciones
				try {
					importarArchivo();
					
				} catch (CancionesNumberException e) {
					String mensaje = String.format("Atencion: %s",e.getMessage());
					menú.mostrarMensaje(mensaje);
				}
				break;
				

			default: // Opción no esperada: abortar
				System.err.println(
						"Error interno de programa");
				System.exit(1);
			}

		} while (entrada != 0);
	}

	
	 /**
     * Añadir una nueva cancion
     */
	
	public void darDeAlta() {
	
        VistaAltaCanciones vista;
        Cancion nuevaCancion;
        
        vista = new VistaAltaCanciones(in);
        nuevaCancion = new Cancion();
  
        if(vista.gestionarAlta(nuevaCancion)) {
        	canciones.añadir(nuevaCancion);
        }
        
    }
	
	  /**
     * Listar canciones
     */
	
	public void listadoCanciones() {
		System.out.printf("Listado de Canciones: ");
		 VistaListadoCanciones vistaListadoCanciones = new VistaListadoCanciones(in);
	        ArrayList<String> listaCanciones = this.canciones.toListaString();
	        vistaListadoCanciones.mostrarListado(listaCanciones);
	       
		
	}
	
    /**
     * Importar las canciones desde un fichero
     */

	public void importarArchivo() throws CancionesNumberException {
		String listaCancionesCSV = AccesoArchivo.leer("canciones.csv");
		String[] canciones = listaCancionesCSV.split("\n");
		 for(String cancionCsv : canciones)
	        {
	            if(!cancionCsv.equals("")){
	                Cancion cancion = new Cancion();
	                String[] cancionDatos = cancionCsv.split(",");
	                cancion.setNombre(cancionDatos[0]);
	                cancion.setDuracion(cancionDatos[1]);
	                cancion.setAño(Integer.parseInt(cancionDatos[2]));
	                cancion.setGenero(cancionDatos[3]);
	                cancion.setArtista(cancionDatos[4]);
	                this.canciones.añadir(cancion);
	            }
	        }
	}
	
	   /**
     * Exportar las canciones a fichero
     */

	
	public void volcarCanciones() throws CancionesFileException {
		StringBuilder stringBuffer = new StringBuilder();
		for(String stringCancionCSV : this.canciones.toListaStringCSV(",")) {
			 stringBuffer.append(stringCancionCSV).append("\n");
		}
		
		AccesoArchivo.escribir("canciones.csv", stringBuffer.toString());
		
	}


	  /**
     * Método principal
     * @param args Argumentos
     */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ControlCanciones control = new ControlCanciones(
				sc);
		control.buclePrincipal();
		sc.close();
	}
}
