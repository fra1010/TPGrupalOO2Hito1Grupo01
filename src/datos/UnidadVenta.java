package datos;

import java.util.Set;

public abstract class UnidadVenta {

	protected int idUnidadVenta;
	protected String nombre;
	protected Empleado responsable;
	protected double superficie;
	protected String codigo;
	protected Set<Empleado> empleados;
	protected Set<Pedido> pedidos;
	protected Set<Plato> platos;

	public UnidadVenta() {
		super();
	}

	public UnidadVenta(String nombre, Empleado responsable, double superficie, String codigo) throws Exception {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.superficie = superficie;
		setCodigo(codigo);
	}

	public int getIdUnidadVenta() {
		return idUnidadVenta;
	}

	public void setIdUnidadVenta(int idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (!validarCodigo(codigo)) {
			throw new Exception("ERROR: El código no puede ser null.\n" + "    Solución: Proporcione un valor válido.\n"
					+ "    Requisitos del código:\n" + "      - Debe tener exactamente 10 caracteres\n"
					+ "      - Todos los caracteres deben estar en mayúscula\n" + "    Ejemplo válido: 'ABCDEFGHIJ'");
		}
		this.codigo = codigo;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + idUnidadVenta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadVenta other = (UnidadVenta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (idUnidadVenta != other.idUnidadVenta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UnidadVenta \n");
		sb.append("  idUnidadVenta: ").append(idUnidadVenta).append(",\n");
		sb.append("  nombre: ").append(nombre).append(",\n");
		sb.append("  responsable: ").append(responsable).append(",\n");
		sb.append("  superficie: ").append(superficie).append(",\n");
		sb.append("  codigo: ").append(codigo).append("\n");
		sb.append(" ");
		return sb.toString();
	}

	private boolean validarCodigo(String codigo) {
		// Validación 1: Null
		// Validación 2: Longitud
		if (codigo == null || codigo.length() != 10) {
			return false;
		}

		// Validación 3: Caracteres (solo letras mayúsculas)
		for (int i = 0; i < codigo.length(); i++) {
			char c = codigo.charAt(i);
			if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
				return false;
			}
		}

		return true;
	}

}
