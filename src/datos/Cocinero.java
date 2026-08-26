package datos;

public class Cocinero extends Empleado {
	private long idCocinero;
	private String especialidad;
	private String categoria;
	private double plus;
	
	public Cocinero() {}
	
	
	
	public Cocinero(String especialidad, String categoria, double plus) {
		super();
		this.especialidad = especialidad;
		this.categoria = categoria;
		this.plus = plus;
	}



	public long getIdCocinero() {
		return idCocinero;
	}



	public void setIdCocinero(long idCocinero) {
		this.idCocinero = idCocinero;
	}



	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPlus() {
		return plus;
	}
	public void setPlus(double plus) {
		this.plus = plus;
	}



	@Override
	public String toString() {
		return "Cocinero [idCocinero=" + idCocinero + ", especialidad=" + especialidad + ", categoria=" + categoria
				+ ", plus=" + plus + "]";
	}



	
	
	
	
}
