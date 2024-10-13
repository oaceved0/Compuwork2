import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTemporalTest {

    private EmpleadoTemporal empleadoTemporal;

    @BeforeEach
    public void setUp() {
        // Inicializa el objeto de empleado temporal antes de cada prueba
        empleadoTemporal = new EmpleadoTemporal("Ana Gomez", 2, 20000, 12, 15);
    }

    @Test
    public void testNombreEmpleadoTemporal() {
        assertEquals("Ana Gomez", empleadoTemporal.getNombre());
    }

    @Test
    public void testIdEmpleadoTemporal() {
        assertEquals(2, empleadoTemporal.getId());
    }

    @Test
    public void testSalarioEmpleadoTemporal() {
        assertEquals(20000, empleadoTemporal.getSalario());
    }

    @Test
    public void testDuracionEmpleadoTemporal() {
        assertEquals(12, empleadoTemporal.getDuracion());
    }

    @Test
    public void testSalarioPorHoraEmpleadoTemporal() {
        assertEquals(15, empleadoTemporal.getSalarioHora());
    }

    @Test
    public void testModificarNombre() {
        empleadoTemporal.setNombre("Laura Torres");
        assertEquals("Laura Torres", empleadoTemporal.getNombre());
    }

    @Test
    public void testModificarSalario() {
        empleadoTemporal.setSalario(25000);
        assertEquals(25000, empleadoTemporal.getSalario());
    }

    @Test
    public void testModificarDuracion() {
        empleadoTemporal.setDuracion(6);
        assertEquals(6, empleadoTemporal.getDuracion());
    }

    @Test
    public void testModificarSalarioPorHora() {
        empleadoTemporal.setSalarioHora(20);
        assertEquals(20, empleadoTemporal.getSalarioHora());
    }

    @Test
    public void testObtenerReporteDesempeño() {
        String reporteEsperado = "Empleado Temporal: Nombre: Ana Gomez, ID: 2, Salario: 20000.0, Duración: 12 meses, Salario por Hora: 15.0";
        assertEquals(reporteEsperado, empleadoTemporal.obtenerReporteDesempeño());
    }
}
