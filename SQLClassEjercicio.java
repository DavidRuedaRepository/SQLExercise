package es.ifp.programacion.ejercicio.uf6;

public class SQLClassEjercicio {
	
	
	
	/**
	 * Clase con variables estÃ¡ticas que definen las consultas SQL a realizar.
	 * La forma de invocarlas (vista en la UF4) es como se invoca a una variable de clase.
	 * 
	 * Por ejemplo:
	 * SQLClassEjercicio.SQL_INSERT
	 * 
	 * @author juan
	 *
	 */

	/**
	 * Definición de la consulta SQL que introduce los valores desconocidos aquí epro que le pasaremos en otra clase en la BBDD empleados.
	 */
		public static String SQL_INSERT = "insert into empleados values(?,?,?,?)";
		
		/**
		 * Definición de la consulta SQL donde selecciona los datos desde la tabla empleados.
		 */
		
		public static String SQL_GETALL = "select * from empleados";
		
		
		
		/**
		 * Definición de la consulta SQL que borra un registro de la tabla empleados a través de su id que e este momento desconocemos
		 * y que lo apsaremos a través de otra clase.
		 */
		public static String SQL_DELETE = "delete from empleados where empleadoid=?";
	}


