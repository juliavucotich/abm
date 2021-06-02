
public class Cliente {
	private String nombre;
	private String apellido;
	private String telefono;
	private String mail;
	private String direccion;
	private String localidad;
	// DONDE ESTÁN LOS GETTERS Y SETTERS DE LA PROPIEDAD ID?...
	private int id; // la BD se encarga de asignar esos valores, en ppio no los necesitamos en la
					// clase

	public Cliente(String nombre, String apellido, String telefono, String mail, String direccion, String localidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.localidad = localidad;
		// ak tmp está el id
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}