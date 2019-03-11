package dominio;

public class Proyecto {
	
	protected String ID;
	protected String titulo;
	protected String descripcion;
	protected String responsable;
	protected String miembros;
	protected String tareas;
	protected String fechaDeCreacion;
	
	public Proyecto(String ID, String titulo, String descripcion, String responsable,String miembros, String tareas, String fechaDeCreacion){
		this.ID=ID;
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.responsable=responsable;
		this.miembros=miembros;
		this.tareas=tareas;
		this.fechaDeCreacion=fechaDeCreacion;
		
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getMiembros() {
		return miembros;
	}

	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}

	public String getTareas() {
		return tareas;
	}

	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(String fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	

}
