import org.junit.jupiter.api.Test;
import javax.swing.SwingUtilities;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    @Test
    public void testMain() throws InterruptedException, InvocationTargetException {
        // Utiliza SwingUtilities para garantizar que el código se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeAndWait(() -> {
            // Crear una instancia de AppUI para comprobar que no es nula
            AppUI app = new AppUI();
            app.setVisible(true);
            // Verifica que la instancia de AppUI no sea nula
            assertNotNull(app);
        });
    }
}
