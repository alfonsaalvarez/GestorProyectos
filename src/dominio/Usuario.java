package dominio;

public class Usuario {
	protected String usuario;
	protected String password;
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String telefono;
	protected String sexo;
	protected String correo;
	protected String fechaNacimiento;
	protected String imagen;
	
	
	
	public Usuario(String usuario, String password, String nombre, String apellidos, String dni, String telefono,
			String sexo, String correo, String fechaNacimiento, String imagen) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.sexo = sexo;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", dni=" + dni + ", telefono=" + telefono + ", sexo=" + sexo + ", correo=" + correo
				+ ", fechaNacimiento=" + fechaNacimiento + ", imagen=" + imagen + "]";
	}

	
	
}
