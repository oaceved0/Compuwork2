public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private double salarioAnual;

    public EmpleadoPermanente(String nombre, int id, double salario, String beneficios, double salarioAnual) {
        super(nombre, id, salario);
        this.beneficios = beneficios;
        this.salarioAnual = salarioAnual;
    }

    @Override
    public String obtenerReporteDesempeño() {
        return "Empleado Permanente: " + super.toString() + ", Beneficios: " + beneficios + ", Salario Anual: " + salarioAnual;
    }
}
