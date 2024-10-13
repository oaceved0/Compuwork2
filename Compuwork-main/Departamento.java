import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private int id;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null; // Si no se encuentra el empleado
    }

    public ArrayList<Empleado> obtenerListaEmpleados() {
        return empleados;
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder("Reporte del Departamento: " + nombre + "\n");
        reporte.append("ID: ").append(id).append("\n");
        reporte.append("Empleados:\n");

        for (Empleado empleado : empleados) {
            reporte.append(empleado.toString()).append("\n");
        }

        return reporte.toString();
    }
    @Override
    public String toString() {
        return "Departamento: " + nombre + ", ID: " + id;
    }

}
