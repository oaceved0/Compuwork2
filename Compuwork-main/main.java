public class main {
    public static void main(String[] args) {
        // Iniciar la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(() -> {
            AppUI app = new AppUI();
            app.setVisible(true);
        });
    }
}
