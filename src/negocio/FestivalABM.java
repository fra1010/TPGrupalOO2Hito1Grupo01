package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Costo;
import datos.Festival;

public class FestivalABM {

    FestivalDao dao = new FestivalDao();

    public int agregar(Festival f) throws Exception {

        if (dao.traerPorNombre(f.getNombre()) != null) {
            throw new Exception(
                "ERROR: ya existe un festival con el mismo nombre "
                + f.getNombre()
            );
        }

        return dao.agregar(f);
    }

    public int agregar(String nombre, String temporada,
                       LocalDate fechaInicio, LocalDate fechaFin,
                       Costo costo) throws Exception {

        Festival f = new Festival(
            nombre,
            temporada,
            fechaInicio,
            fechaFin,
            costo
        );

        return agregar(f);
    }

    public int agregar(String nombre, String temporada,
                       LocalDate fechaInicio, LocalDate fechaFin)
            throws Exception {

        Festival f = new Festival(
            nombre,
            temporada,
            fechaInicio,
            fechaFin
        );

        return agregar(f);
    }

    public void modificar(Festival f) throws Exception {

        Festival existe = dao.traer(f.getIdFestival());

        if (existe == null) {
            throw new Exception(
                "ERROR: no existe Festival con dicho ID "
                + f.getIdFestival()
            );
        }

        dao.actualizar(f);
    }

    public void eliminar(int id) throws Exception {

        Festival f = dao.traer(id);

        if (f == null) {
            throw new Exception(
                "ERROR: no existe Festival con dicho ID"
            );
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
}