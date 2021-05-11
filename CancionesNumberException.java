package daw2020.album;

/**
 * Excepción usada e la aplicación «Musica» cuando se intenta
 * manipular una entrada que no corresponde a un valor válido
 * 
 * @author Rodrigo Miguez Lopez
 */
	public class CancionesNumberException
			extends Exception {

		/**
		 * Número de serie, asociado a la versión de la clase.
		 */
		private static final long serialVersionUID = 20210324001L;

		/**
		 * Crea una excepción sin ninguna información adicional.
		 */
		public CancionesNumberException() {
			super("Opcion no valida");
		}

		/**
		 * Crea una excepción con un texto descriptivo.
		 * 
		 * @param mensaje el texto correspondiente
		 */
		public CancionesNumberException(String mensaje) {
			super(mensaje);
		}

		/**
		 * Crea una excepción secundaria almacenando otra excepción de referencia.
		 * 
		 * @param causa la excepción –o {@link Throwable}– correspondiente
		 */
		public CancionesNumberException(Throwable causa) {
			super(causa);
		}

		/**
		 * Crea una excepción secundaria almacenando otra excepción de referencia y un
		 * texto descriptivo.
		 * 
		 * @param mensaje el texto correspondiente
		 * @param causa   la excepción –o {@link Throwable}– correspondiente
		 */
		public CancionesNumberException(String mensaje,
				Throwable causa) {
			super(mensaje, causa);
		}
	}