import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    private EmpleadoPermanente empleadoPermanente;
    private EmpleadoTemporal empleadoTemporal;

    @BeforeEach
    public void setUp() {
        // Inicializa los objetos de empleado antes de cada prueba
        empleadoPermanente = new EmpleadoPermanente("Juan Perez", 1, 50000, "Seguro Médico", 60000);
        empleadoTemporal = new EmpleadoTemporal("Ana Gomez", 2, 20000, 12, 15);
    }

    @Test
    public void testNombreEmpleadoPermanente() {
        assertEquals("Juan Perez", empleadoPermanente.getNombre());
    }

    @Test
    public void testSalarioEmpleadoTemporal() {
        assertEquals(20000, empleadoTemporal.getSalario());
    }

    @Test
    public void testModificarNombre() {
        empleadoPermanente.setNombre("Carlos Ruiz");
        assertEquals("Carlos Ruiz", empleadoPermanente.getNombre());
    }

    @Test
    public void testModificarSalario() {
        empleadoTemporal.setSalario(25000);
        assertEquals(25000, empleadoTemporal.getSalario());
    }
}
