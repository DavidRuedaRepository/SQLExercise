package es.ifp.programacion.ejercicio.uf6;

/**
 * Clase empleado con atributos, 1 constructor con 4 parámetros, no tenemos el setEmpleadiId ya que
 * en el ejercicio se menciona que no se permite la modificación de este dato.
 * Se incluye un método toString que sobreescribe los datos formateados.
 */
public class Empleado {
	
	
	//Atributos
	private int empleadoId;
	private String nombre;
	private String apellidos;
	private int salario;
	
	//Constructores
	
	public Empleado(int empleadoId, String nombre, String apellidos, int salario) {
		
		this.empleadoId=empleadoId;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.salario=salario;
		
		
	}

	
	//Métodos
	/**
	 * @return the empleadoId
	 */
	public int getEmpleadoId() {
		return empleadoId;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "=====================================================\n"
				+"EMPLEADO:\n"
				+"ID del empleado: " + getEmpleadoId()+"\n"
				+ "Nombre: "+ getNombre()+"\n"
				+"Apellidos: "+ getApellidos()+"\n"
				+"Salario: "+ getSalario()+"\n"
		+"============================================================";
				
		
	}
	
	

}
