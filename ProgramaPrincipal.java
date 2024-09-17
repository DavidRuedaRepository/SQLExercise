package es.ifp.programacion.ejercicio.uf6;

import java.util.Iterator;


/**
 * Programa principal donde se ejecutan las diferentes utilidades creadas para interactuar con la BBDD en postgresql.
 */
public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		/**
		 * Instanciamos la clase MétodosBBDD.
		 */
		MétodosBBDD métodosBBDD = new MétodosBBDD();

		/**
		 * Instanciamos 3 empleados incluyendo los datos "a fuego" para crearlos.
		 */
		Empleado ana = new Empleado (1, "Ana", "Pérez Lira", 1500);
		Empleado juan = new Empleado (2, "Juan", "Sanchez Zapico", 1600);
		Empleado roberto = new Empleado (3, "Roberto", "Suarez González", 1200);



		/**
		 * Usamos el ,étodo connectToDB para conectar con la base de datos e imprimimos un mensaje de "conexión establecida" en caso
		 * de que se realice la conexión(entra por el if), de lo contrario se nos aparecerá en consola la excepción capturada en el método.
		 */
		if (métodosBBDD.connectToDB()) {
			System.out.println("=====================");
			System.out.println("Conexión establecida");
			System.out.println("=====================");
		}

		//Mensaje separador para organizar las utilidades.
		System.out.println("===========================================");
		System.out.println("1.-Muestro todos los registros de la BBDD");
		System.out.println("===========================================");





		/**
		 * En este caso llamamos al método getAllEmpleados para que nos imprima en consola todos los registros, en caso 
		 * de que la tabla esté vacía entra por el if e imprime un mensaje informando del caso.
		 * De lo contrario iteramos cada mientras haya filas, cuando no existan más filas se imprime en consola a través del método toString de la clase Empleado.
		 */
		if (métodosBBDD.getAllEmpleados().isEmpty()) {
			System.out.println("No hay registros en la tabla.");

		}
		else {

			Iterator<Empleado> itEmpleado = métodosBBDD.getAllEmpleados().iterator();
			Empleado tmpEmpleado = null;
			while (itEmpleado.hasNext()) {
				tmpEmpleado=itEmpleado.next();

				System.out.println(tmpEmpleado.toString());

			}
		}

		//Separador para organizar la información impresa en consola.
		System.out.println("===========================================");
		System.out.println("2.-Insertamos 3 empleados");
		System.out.println("===========================================");




		/**
		 * Aquí utilizamos el método inserta empleado para introducir los datos de los empleados en la BBDD e imprimiremos
		 * en consola un mesanje concatenando con los datos usando los métodos get del empleado.
		 *  En caso de que no se inserte en la tabla imprimimos un mensaje en consola.
		 */

		if (métodosBBDD.insertarEmpleado(ana)>0) {
			System.out.println("Se ha insertado en la tabla con ID " +ana.getEmpleadoId()+" en la BBDD: "+ana.getNombre()+" "+ana.getApellidos());
		}
		else {
			System.out.println("No se ha insertado debido al ");
		}

		if (métodosBBDD.insertarEmpleado(juan)>0) {
			System.out.println("Se ha insertado en la tabla con ID " +juan.getEmpleadoId()+" en la BBDD: "+juan.getNombre()+" "+juan.getApellidos());
		}
		else 
			System.out.println("No se ha insertado debido al ");

		if (métodosBBDD.insertarEmpleado(roberto)>0) {
			System.out.println("Se ha insertado en la tabla con ID " +roberto.getEmpleadoId()+" en la BBDD: "+roberto.getNombre()+" "+roberto.getApellidos());
		}
		else 
			System.out.println("No se ha insertado debido al ");



		//Mensaje separador para organizar la información en consola.
		System.out.println("===========================================");
		System.out.println("3.-Mostramos todos los registros");
		System.out.println("===========================================");



		/**
		 * Aquí utilizamos el método getAllEmpleados para volver a imprimir los datos en consola.
		 * Al igual que anteriormente en caso de que no existan registros entra por el if, de lo contrario entra por el else itera e imprimimos
		 * a través del método toString.
		 */

		if (métodosBBDD.getAllEmpleados().isEmpty()) {
			System.out.println("No hay registros en la tabla.");

		}
		else {

			Iterator<Empleado> itEmpleado = métodosBBDD.getAllEmpleados().iterator();
			Empleado tmpEmpleado = null;
			while (itEmpleado.hasNext()) {
				tmpEmpleado=itEmpleado.next();

				System.out.println(tmpEmpleado.toString());

			}
		}

		//Mensaje serparador para organizar la información en consola.	
		System.out.println("===========================================");
		System.out.println("4.-Borramos un registro");
		System.out.println("===========================================");

		/**
		 * Aquí utilizamos el método deleteEmpleado para borrar 1 empleado de la tabla. Si el empleado ha sido eliminado correctamente 
		 * imprimimos un mensaje informando de ello. De lo contrario entra por el else donde imprimimos un mensaje informativo.
		 */

		if (métodosBBDD.deleteEmpleado(ana)) {
			System.out.println("Se ha eliminado el empleado con id: "+ana.getEmpleadoId()+" con nombre "+ana.getNombre()+" "+ana.getApellidos());
		}
		else
			System.out.println("El usuario no se ha podido eliminar");

		//Mensaje separador para organizar la información en consola.

		System.out.println("===========================================");
		System.out.println("5.-Mostramos todos los registros");
		System.out.println("===========================================");




		/**
		 * Aquí volvemos a imprimir en consolo todos los empleados que se encuentren en la tabla, funciona igual que más arriba, 
		 * si la tabla está vacío informamos a través de la consola de lo contrario iteramos e imprimimos todos los recursos.
		 */

		if (métodosBBDD.getAllEmpleados().isEmpty()) {
			System.out.println("No hay registros en la tabla.");
		}
		else {

			Iterator<Empleado> itEmpleado = métodosBBDD.getAllEmpleados().iterator();
			Empleado tmpEmpleado = null;
			while (itEmpleado.hasNext()) {
				tmpEmpleado=itEmpleado.next();
				System.out.println(tmpEmpleado.toString());
			}
		}


		//Mensaje informativo para organizar la información en consola.

		System.out.println("===========================================");
		System.out.println("6.-Cerramos los recursos");
		System.out.println("===========================================");



		/**
		 * Aquí utilziamos el método closeResources donde cerramos todos los recursos evitando que queden abiertos y consumiendo memoria.
		 * En caso afirmativo entra por el if e imprimimos en consola un mensaje. De lo contrario se imprime en consola otro mensaje informativo.
		 */

		if (métodosBBDD.closeResources()) {
			System.out.println("Se han cerrado los recursos");
		}
		else 
			System.out.println("No se han cerrado los recursos");





	}

}
























