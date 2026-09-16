package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import dao.UnidadVentaDao;
import datos.Costo;
import datos.Festival;
import datos.UnidadVenta;

public class FestivalABM {

    FestivalDao dao = new FestivalDao();
    UnidadVentaDao unidadDao = new UnidadVentaDao();
    CostoABM abmCosto = new CostoABM();

    public int agregar(Festival f) throws Exception {

        if (dao.traerPorNombre(f.getNombre()) != null) {
            throw new Exception("ERROR: ya existe un festival con el mismo nombre " + f.getNombre());
        }

        return dao.agregar(f);
    }

    public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo)
            throws Exception {

        Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costo);

        return agregar(f);
    }

    public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin);

        return agregar(f);
    }

    public int agregarConCosto(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
            int costoSuperficie, int costoMontaje, int costoElectricidad, int sueldoBase) throws Exception {

        int idFestival = agregar(nombre, temporada, fechaInicio, fechaFin);
        Festival f = dao.traer(idFestival);

        abmCosto.agregar(costoSuperficie, costoMontaje, costoElectricidad, sueldoBase, f);

        return idFestival;
    }

    public void modificar(Festival f) throws Exception {

        Festival existe = dao.traer(f.getIdFestival());

        if (existe == null) {
            throw new Exception("ERROR: no existe Festival con ese ID " + f.getIdFestival());
        }

        dao.actualizar(f);
    }

    public void eliminar(int id) throws Exception {

        Festival f = dao.traer(id);

        if (f == null) {
            throw new Exception("ERROR: no existe Festival con dicho ID");
        }

        dao.eliminar(f);
    }

    public Festival traer(int idFestival) {
        return dao.traer(idFestival);
    }

    public List<Festival> traer() {
        return dao.traer();
    }

    public Festival traerFestivalyCosto(int idFestival) {
        return dao.traerFestivalYCosto(idFestival);
    }

    public Festival traerFestivalYUnidadesVenta(int idFestival) {
        return dao.traerFestivalYUnidadesVenta(idFestival);
    }

    public void asociarUnidadVenta(int idFestival, String codigoUnidad) throws Exception {
        Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
        if (f == null) {
            throw new Exception("No existe festival con id " + idFestival);
        }

        UnidadVenta uv = dao.traerUnidadPorCodigo(codigoUnidad);
        if (uv == null) {
            throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
        }

        f.getUnidadesVenta().add(uv);
        dao.actualizar(f);
    }

    public void desasociarUnidadVenta(int idFestival, String codigoUnidad) throws Exception {
        Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
        if (f == null) {
            throw new Exception("No existe festival con id " + idFestival);
        }

        UnidadVenta uv = dao.traerUnidadPorCodigo(codigoUnidad);
        if (uv == null) {
            throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
        }

        if (!f.getUnidadesVenta().contains(uv)) {
            throw new Exception("La unidad de venta " + codigoUnidad + " no pertenece al festival " + f.getNombre());
        }

        f.getUnidadesVenta().remove(uv);
        dao.actualizar(f);
    }

    public void eliminarUnidadVentaDeFestival(int idFestival, String codigoUnidad) throws Exception {
        Festival f = dao.traerFestivalYUnidadesVenta(idFestival);
        if (f == null) {
            throw new Exception("No existe festival con id " + idFestival);
        }

        UnidadVenta uv = unidadDao.traer(codigoUnidad);
        if (uv == null) {
            throw new Exception("No existe unidad de venta con codigo " + codigoUnidad);
        }

        if (!f.getUnidadesVenta().contains(uv)) {
            throw new Exception("La unidad de venta " + codigoUnidad + " no pertenece al festival " + f.getNombre());
        }

        f.getUnidadesVenta().remove(uv);
        dao.actualizar(f);
        unidadDao.eliminar(uv);
    }


    public List<Festival> traerPorRangoDeFechas(LocalDate desde, LocalDate hasta) throws Exception {

        if (desde == null || hasta == null) {
            throw new Exception("ERROR: las fechas 'desde' y 'hasta' no pueden ser nulas");
        }

        if (hasta.isBefore(desde)) {
            throw new Exception("ERROR: la fecha 'hasta' (" + hasta + ") no puede ser anterior a 'desde' (" + desde + ")");
        }

        List<Festival> lista = dao.traerPorRangoDeFechas(desde, hasta);

        if (lista.isEmpty()) {
            throw new Exception("No hay festivales en el rango de fechas " + desde + " - " + hasta);
        }

        return lista;
    }

    public List<Festival> traerPorTemporada(String temporada) throws Exception {

        if (temporada == null || temporada.trim().isEmpty()) {
            throw new Exception("ERROR: la temporada no puede ser nula ni vacia");
        }

        List<Festival> lista = dao.traerPorTemporada(temporada);

        if (lista.isEmpty()) {
            throw new Exception("No hay festivales cargados para la temporada " + temporada);
        }

        return lista;
    }

    public List<Festival> traerPorRangoDeCosto(int montoMinimo, int montoMaximo) throws Exception {

        if (montoMinimo < 0 || montoMaximo < 0) {
            throw new Exception("ERROR: los montos no pueden ser negativos");
        }

        if (montoMaximo < montoMinimo) {
            throw new Exception("ERROR: el monto maximo (" + montoMaximo + ") no puede ser menor al minimo (" + montoMinimo + ")");
        }

        List<Festival> lista = dao.traerPorRangoDeCosto(montoMinimo, montoMaximo);

        if (lista.isEmpty()) {
            throw new Exception("No hay festivales con costo entre " + montoMinimo + " y " + montoMaximo);
        }

        return lista;
    }
}