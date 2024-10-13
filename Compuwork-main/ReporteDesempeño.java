public class ReporteDesempeño {

    public String generarReporteIndividual(Empleado empleado) {
        return empleado.obtenerReporteDesempeño();
    }

    public String generarReporteDepartamento(Departamento departamento) {
        return departamento.generarReporte();
    }
}
