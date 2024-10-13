public class EmpleadoTemporal extends Empleado {
    private int duracion; // Duración del contrato en meses
    private double salarioHora;

    public EmpleadoTemporal(String nombre, int id, double salario, int duracion, double salarioHora) {
        super(nombre, id, salario);
        this.duracion = duracion;
        this.salarioHora = salarioHora;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    @Override
    public String obtenerReporteDesempeño() {
        return "Empleado Temporal: " + super.toString() + ", Duración: " + duracion + " meses, Salario por Hora: " + salarioHora;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }
}
