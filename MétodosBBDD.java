package es.ifp.programacion.ejercicio.uf6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;

/**
 * Clase con las utilidades de la BBDD las cules se explican en cada uno de los métodos.
 */
public class MétodosBBDD {

	/**
	 * Atributos de la clase.
	 */
	final private String userDB="postgres";
	final private String passDB = "orbe23pmc";
	final private String URL =  "jdbc:postgresql://localhost:5432/empresaDB";
	private PreparedStatement ps;
	private Connection conexion;
	private int numFilas;
	private ResultSet rs=null;


	/**
	 * Borra el registro de la tabla asociado al objeto emp pasado como parÃ¡metro
	 * @param emp objeto Empleado que se elimina de la BBDD
	 * @return true si el borrado fue correcto, false sino.
	 */
	public boolean deleteEmpleado(Empleado emp) {



		//En caso de que el empleado esté en la tabla entra por el try y realiza la eliminación.
		try {
			// Preparar la consulta SQL
			ps = this.conexion.prepareStatement(SQLClassEjercicio.SQL_DELETE);

			// Establecer el parámetro necesario para identificar el empleado a eliminar
			ps.setInt(1, emp.getEmpleadoId());

			// Ejecutar la consulta de eliminación y almacenamos la información en la variable numFilas.
			numFilas = ps.executeUpdate();

			//En caso contrario entra por el catch y lanzamos el mensaje
		} catch (SQLException sql) {
			sql.getMessage();
			System.out.println("Ocurrió un error dirante la eliminación");
			return false; 
		}
		//retornamos un valor booleano siendo si es mayor que 0 true de lo contrario false.
		return numFilas>0;


	}


	/**
	 * A partir de un objeto empleado, inserta todos sus datos en la tabla empleados.
	 * @param emp Objeto de tipo empleado
	 * @return 0 si no se ha insertado valor alguno. En caso contrario, el nÃºmero de filas insertadas.
	 */
	public int insertarEmpleado(Empleado emp) {

		//En caso de insertar el empleado entra por el try
		try {

			ps = conexion.prepareStatement(SQLClassEjercicio.SQL_INSERT);

			ps.setInt(1, emp.getEmpleadoId());
			ps.setString(2, emp.getNombre());
			ps.setString(3, emp.getApellidos());
			ps.setInt(4, emp.getSalario());

			numFilas = ps.executeUpdate();


		}
//En caso de que no se haya podido insertar entra por el catch donde lanzamos un mensaje personakizado concatenando con 
		//una función de la clase SQLException siendo esta getMesssage().
		catch (SQLException sql) {

			System.out.println("No se ha insertado debido al error: "+sql.getMessage());
		}
//Retornamos un entero almacenado en la variable numFilas.
		return numFilas;

	}




	/**
	 * Cierra todos los recursos relativos a la BBDD
	 * @return true si la operaciÃ³n fue correcta, false sino.
	 */
	public boolean closeResources() {

//En un uso normal de la función entra por el try, en caso de que ps ó conexion no sean null se cierran los recursos.
		try {

			if (ps!= null && conexion !=null) {
				ps.close();
				conexion.close();
				rs.close();
			}
			return true;
		}	
		//En caso contrario entra por el catch donde lanzamos el mensaje.
		catch (SQLException sql) {
			sql.getMessage();
			return false;

		}
	}	

	/**
	 * Se conecta a la BBDD empresadb creada en postgreSQL.
	 * @return true si la conexiÃ³n fue satisfactoria, false sino.
	 */
	public boolean connectToDB() {
		
//Entra por el try y se realiza la conexión con la BBDD pasándole los datos como variables.
		try {
			this.conexion=DriverManager.getConnection(URL,userDB, passDB);

			return true;
		}
//En caso de no realizar la conexión entra por el catch donde capturamos la excepción.
		catch (SQLException sql) {
			// TODO Auto-generated catch block
			sql.getMessage();
			return false; 
		}
	}




	/**
	 * Obtiene todos los registros de la tabla empleados
	 * @return un ArrayList de objetos de tipo Empleado mapeados a los registros de la tabla.
	 */
	public ArrayList<Empleado> getAllEmpleados() {

		// Crear una lista para almacenar objetos Empleado
		ArrayList<Empleado> EmpleadoBD = new ArrayList<Empleado>();

		
		try {
			//Preparamos la consulta SQL.
			ps = conexion.prepareStatement(SQLClassEjercicio.SQL_GETALL);

			// Ejecutar la consulta SQL y nos devuelve un ResultSet que almacenamos en la variable rs.
			rs = ps.executeQuery();


			// Iterar sobre los resultados del ResultSet mientras existan filas en la vase de datos.
			while (rs.next()) {
				// Obtener los valores de las columnas para cada fila
				int empleadoId = rs.getInt("empleadoId");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int salario = rs.getInt("salario");

				// Crear un objeto Empleado con los valores obtenidos
				Empleado tmpEmpleado = new Empleado(empleadoId, nombre, apellidos, salario);

				// Agregar el objeto Empleado al ArrayList
				EmpleadoBD.add(tmpEmpleado);

			}

//En caso de no devolver los datos de todos los empleados entra por el catch donde capturamos la excepción.
		} catch (SQLException sql) {
			
			sql.printStackTrace();

		}
//Retorna el Arraylist llamado EmpleadoBD.
		return EmpleadoBD;





	}

}




