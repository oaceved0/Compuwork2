import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Departamentotest {
    private Departamento departamento;

    @BeforeEach
    public void setUp() {
        departamento = new Departamento("Recursos Humanos", 1);
    }

    @Test
    public void testConstructor() {
        assertEquals("Recursos Humanos", departamento.getNombre());
        assertEquals(1, departamento.getId());
    }

    @Test
    public void testToString() {
        String expected = "Departamento: Recursos Humanos, ID: 1";
        assertEquals(expected, departamento.toString());
    }

}
