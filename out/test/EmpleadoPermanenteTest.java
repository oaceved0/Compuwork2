import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoPermanenteTest {
    private EmpleadoPermanente empleado;

    @BeforeEach
    public void setUp() {
        empleado = new EmpleadoPermanente("Juan Perez", 1, 50000.0, "Seguro Médico", 1000.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Juan Perez", empleado.getNombre());
        assertEquals(1, empleado.getId());
        assertEquals(50000.0, empleado.getSalario());
    }

    @Test
    public void testObtenerReporteDesempeño() {
        String expected = "Empleado Permanente: Nombre: Juan Perez, ID: 1, Salario: 50000.0, Beneficios: Seguro Médico, Salario Anual: 1000.0";
        assertEquals(expected, empleado.obtenerReporteDesempeño());
    }

    @Test
    public void testGetters() {
        assertEquals("Juan Perez", empleado.getNombre());
        assertEquals(1, empleado.getId());
        assertEquals(50000.0, empleado.getSalario());
    }
}
