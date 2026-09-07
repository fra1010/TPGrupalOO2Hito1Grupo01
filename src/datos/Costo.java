package datos;


public class Costo {
	private int idCosto;
	private int costoSuperficie;
	private int costoMontaje;
	private int costoElectricidad;
	private int sueldoBase;
	private Festival festival;
	
	public Costo() {}

	public Costo(int costoSuperficie, int costoMontaje, int costoElectricidad, int sueldoBase) {
		super();
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.costoElectricidad = costoElectricidad;
		this.sueldoBase = sueldoBase;
	}
	
    public Costo(int costoSuperficie, int costoMontaje, int costoElectricidad, int sueldoBase, Festival festival) {  
        super();
    	this.costoSuperficie = costoSuperficie;
        this.costoMontaje = costoMontaje;
        this.costoElectricidad = costoElectricidad;
        this.sueldoBase = sueldoBase;
        this.festival = festival;
    }
    

	public int getIdCosto() {
		return idCosto;
	}

	protected void setIdCosto(int idCosto) {
		this.idCosto = idCosto;
	}

	public int getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(int costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public int getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(int costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public int getCostoElectricidad() {
		return costoElectricidad;
	}

	public void setCostoElectricidad(int costoElectricidad) {
		this.costoElectricidad = costoElectricidad;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	
	@Override
	public String toString() {
	    return "Costo [id=" + idCosto
	            + ", costoSuperficie=" + costoSuperficie
	            + ", costoMontaje=" + costoMontaje
	            + ", costoElectricidad=" + costoElectricidad
	            + ", sueldoBase=" + sueldoBase + "]";
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Costo)) return false;
	    Costo other = (Costo) o;
	    return java.util.Objects.equals(festival, other.festival);
	}

	@Override
	public int hashCode() {
	    return java.util.Objects.hash(festival);
	}
	
	
}
