package daw2020.album;

/**
 * Modelo de cancion
 * @Author Rodrigo Miguez Lopez
 */

public class Cancion {

	private String nombre;
	private String duracion;
	private String genero;
	private int año;
	private String artista;
	
	
	   /**
     * Constructor
     */
		public Cancion () {

	} 
		public Cancion (String nombre, String duracion,String genero, int año,  String artista) {
				this.nombre=nombre;
				this.duracion=duracion;
				this.genero=genero;
				this.año=año;
				this.artista=artista;
		} 
		
		public Cancion (String[] listaDatosCanciones) {
			this(listaDatosCanciones[1],listaDatosCanciones[2],listaDatosCanciones[3],
					Integer.parseInt(listaDatosCanciones[4]),listaDatosCanciones[5]);

		} 
		/**
	     * Obtener duracion de la cancion
	     * @return Duracion de la cancion
	     */
	public String getDuracion() {
		return duracion;
	}

	 /**
     * Establecer duracion de la cancion
     * @param duracion Duracion de la cancion
     */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	/**
     * Obtener genero de la cancion
     * @return Genero de la cancion
     */
	public String getGenero() {
		return genero;
	}
	 /**
     * Establecer genero de la cancion
     * @param genero Genero de la cancion
     */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
     * Obtener año de la cancion
     * @return Año de la cancion
     */
	public int getAño() {
		return año;
	}

	 /**
     * Establecer año de la cancion
     * @param año Año de la cancion
     */
	public void setAño(int año) {
		this.año = año;
	}
	/**
     * Obtener nombre de la cancion
     * @return Nombre de la cancion
     */
	public String getNombre() {
		return nombre;
	}
	 /**
     * Establecer nombre de la cancion
     * @param nombre Nombre de la cancion
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Obtener artista de la cancion
     * @return Artista de la cancion
     */
	public String getArtista() {
		return artista;
	}
	
	 /**
     * Establecer nombre del artista de la cancion
     * @param artista Artista de la cancion
     */
	public void setArtista(String artista) {
		this.artista = artista;
		
	}
	
	 /**
     * Transformar los datos de la cancion a una cadena de texto
     * @return Datos de la cancion
     */
	public String toString() {
        StringBuffer texto = new StringBuffer();
        String formato = " -%s: %s%n";
        texto.append(String.format(formato,"Nombre",getNombre()));
        texto.append(String.format(formato,"Duracion",getDuracion()));
        texto.append(String.format(formato,"Genero",getGenero()));
        texto.append(String.format(formato,"Año",getAño()));
        texto.append(String.format(formato,"Artista",getArtista()));
        return texto.toString();
    }
	
	 /**
     * Transformar los datos de la cancion a una cadena de texto
     * @param separador Separador del CSV
     * @return Datos de la cancion en CSV
     */
	
	public String toStringCSV(String separador) {
		
		StringBuffer texto = new StringBuffer();
	    String formato = "%s%s";
	    texto.append(String.format(formato,getNombre(),separador));
	    texto.append(String.format(formato,getArtista(),separador));
	    texto.append(String.format(formato,getAño(),separador));
	    texto.append(String.format(formato,getDuracion(),separador));
	    texto.append(String.format(formato,getGenero(),separador));
	        return texto.toString();
	    }
	
}

