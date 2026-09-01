package datos;

public class Costos {
	private long idCostos;
	private String tipoCosto;
	private double importe;
	private UnidadVenta aUnidad;
	private String tipoUnidad;
	
	public Costos() {}

	public Costos(String tipoCosto, double importe, UnidadVenta aUnidad, String tipoUnidad) {
		super();
		this.tipoCosto = tipoCosto;
		this.importe = importe;
		this.aUnidad = aUnidad;
		this.tipoUnidad = tipoUnidad;
	}

	public long getIdCostos() {
		return idCostos;
	}

	public void setIdCostos(long idCostos) {
		this.idCostos = idCostos;
	}

	public String getTipoCosto() {
		return tipoCosto;
	}

	public void setTipoCosto(String tipoCosto) {
		this.tipoCosto = tipoCosto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public UnidadVenta getaUnidad() {
		return aUnidad;
	}

	public void setaUnidad(UnidadVenta aUnidad) {
		this.aUnidad = aUnidad;
	}

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	@Override
	public String toString() {
		return "Costos [idCostos=" + idCostos + ", tipoCosto=" + tipoCosto + ", importe=" + importe + ", aUnidad="
				+ aUnidad + ", tipoUnidad=" + tipoUnidad + "]";
	}

	
	
	
}
