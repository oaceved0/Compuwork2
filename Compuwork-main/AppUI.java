import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppUI extends JFrame {
    private ReporteDesempeño reporte;
    private ArrayList<Departamento> departamentos;

    public AppUI() {
        reporte = new ReporteDesempeño();
        departamentos = new ArrayList<>();
        // Agregar departamentos por defecto
        departamentos.add(new Departamento("TI", 1));
        departamentos.add(new Departamento("Recursos Humanos", 2));

        initUI();
    }

    private void initUI() {
        setTitle("Gestión de Recursos Humanos");

        JPanel panel = new JPanel(new GridLayout(7, 1));

        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        btnAgregarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        JButton btnAgregarDepartamento = new JButton("Agregar Departamento");
        btnAgregarDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDepartamento();
            }
        });

        JButton btnModificarEmpleado = new JButton("Modificar Empleado");
        btnModificarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEmpleado();
            }
        });

        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
        btnEliminarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEmpleado();
            }
        });

        JButton btnReporteIndividual = new JButton("Generar Reporte Individual");
        btnReporteIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteIndividual();
            }
        });

        JButton btnReporteDepartamento = new JButton("Generar Reporte por Departamento");
        btnReporteDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteDepartamento();
            }
        });

        panel.add(btnAgregarEmpleado);
        panel.add(btnAgregarDepartamento);
        panel.add(btnModificarEmpleado);
        panel.add(btnEliminarEmpleado);
        panel.add(btnReporteIndividual);
        panel.add(btnReporteDepartamento);

        add(panel);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void agregarDepartamento() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo departamento:");
        int id = obtenerNuevoId();

        if (nombre != null && !nombre.trim().isEmpty()) {
            departamentos.add(new Departamento(nombre, id));
            JOptionPane.showMessageDialog(this, "Departamento agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de departamento no válido.");
        }
    }

    private void agregarEmpleado() {
        String id = JOptionPane.showInputDialog("Ingrese el Id del empleado");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado:");
        String salarioStr = JOptionPane.showInputDialog("Ingrese salario del empleado:");
        double salario = Double.parseDouble(salarioStr);

        // Selección de tipo de empleado
        String[] opciones = {"Permanente", "Temporal"};
        int tipo = JOptionPane.showOptionDialog(this, "Seleccione el tipo de empleado:",
                "Tipo de Empleado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (tipo == -1) {
            JOptionPane.showMessageDialog(this, "Selección de tipo de empleado cancelada.");
            return; // Si el usuario cierra la ventana, no hacemos nada
        }

        Empleado nuevoEmpleado;
        if (tipo == 0) { // Permanente
            String beneficios = JOptionPane.showInputDialog("Ingrese beneficios:");
            String salarioAnualStr = JOptionPane.showInputDialog("Ingrese salario anual:");
            double salarioAnual = Double.parseDouble(salarioAnualStr);
            nuevoEmpleado = new EmpleadoPermanente(nombre, Integer.parseInt(id), salario, beneficios, salarioAnual);
        } else { // Temporal
            String duracionStr = JOptionPane.showInputDialog("Ingrese duración del contrato (meses):");
            int duracion = Integer.parseInt(duracionStr);
            String salarioHoraStr = JOptionPane.showInputDialog("Ingrese salario por hora:");
            double salarioHora = Double.parseDouble(salarioHoraStr);
            nuevoEmpleado = new EmpleadoTemporal(nombre, Integer.parseInt(id), salario, duracion, salarioHora);
        }

        // Seleccionar departamento
        String[] departamentoNombres = new String[departamentos.size()];
        for (int i = 0; i < departamentos.size(); i++) {
            departamentoNombres[i] = departamentos.get(i).getNombre();
        }

        int resultado = JOptionPane.showOptionDialog(this, "Selecciona el departamento:",
                "Seleccionar Departamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                departamentoNombres, null);

        if (resultado != -1) {
            departamentos.get(resultado).agregarEmpleado(nuevoEmpleado);
            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Departamento no válido. Empleado no agregado.");
        }
    }

    private void modificarEmpleado() {
        String idStr = JOptionPane.showInputDialog("Ingrese ID del empleado a modificar:");
        int id = Integer.parseInt(idStr);
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", empleado.getNombre());
            empleado.setNombre(nuevoNombre);
            String nuevoSalarioStr = JOptionPane.showInputDialog("Nuevo salario:", empleado.getSalario());
            double nuevoSalario = Double.parseDouble(nuevoSalarioStr);
            empleado.setSalario(nuevoSalario);
            JOptionPane.showMessageDialog(this, "Empleado modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
        }
    }

    private void eliminarEmpleado() {
        String idStr = JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar:");
        int id = Integer.parseInt(idStr);
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            for (Departamento departamento : departamentos) {
                if (departamento.buscarEmpleado(id) != null) {
                    departamento.removerEmpleado(empleado);
                    JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente.");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
    }

    private void generarReporteIndividual() {
        String idStr = JOptionPane.showInputDialog("Ingrese ID del empleado para generar el reporte:");
        int id = Integer.parseInt(idStr);
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            String reporteIndividual = reporte.generarReporteIndividual(empleado);
            JOptionPane.showMessageDialog(this, reporteIndividual);
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
        }
    }

    private void generarReporteDepartamento() {
        String[] departamentoNombres = new String[departamentos.size()];
        for (int i = 0; i < departamentos.size(); i++) {
            departamentoNombres[i] = departamentos.get(i).getNombre();
        }

        int resultado = JOptionPane.showOptionDialog(this, "Selecciona el departamento:",
                "Seleccionar Departamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                departamentoNombres, null);

        if (resultado != -1) {
            String reporteDep = reporte.generarReporteDepartamento(departamentos.get(resultado));
            JOptionPane.showMessageDialog(this, reporteDep);
        } else {
            JOptionPane.showMessageDialog(this, "Departamento no válido.");
        }
    }

    private Empleado buscarEmpleadoPorId(int id) {
        for (Departamento departamento : departamentos) {
            Empleado empleado = departamento.buscarEmpleado(id);
            if (empleado != null) {
                return empleado;
            }
        }
        return null;
    }

    private int obtenerNuevoId() {
        return (int) (Math.random() * 1000); // Generar un ID aleatorio
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppUI app = new AppUI();
            app.setVisible(true);
        });
    }
}
