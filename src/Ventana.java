import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private ArrayList<Usuario> usuarios;
    private DefaultTableModel modelo;
    private int valoresIgualesSeleccionado;

    public Ventana(){
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //inicializa valores
        usuarios=new ArrayList<>();
        añadirUsuarios(usuarios);
        valoresIgualesSeleccionado = -1;

        JPanel main = new JPanel(new BorderLayout());
        this.add(main);

        //DEFINES TABLA
        modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        String[] cabeceras ={"Nombre", "Apellido", "Numero"};
        JScrollPane scroll = new JScrollPane(tabla);

        //PONES LA TABLA EN LA VENTANA
        modelo.setColumnIdentifiers(cabeceras);
        main.add(scroll, BorderLayout.CENTER);

        //RELLENAS LA TABLA
        for(Usuario u : usuarios){
            Object[] nuevo = {u.getName(), u.getApellido(), u.getNumero()};
            modelo.addRow(nuevo);
        }

        JButton añadir = new JButton("añadir nuevo");
        main.add(añadir, BorderLayout.SOUTH);

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirNuevo();
            }
        });

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int columna = tabla.columnAtPoint(e.getPoint());
                int fila = tabla.rowAtPoint(e.getPoint());

                /*
                if(columna==2){
                    valoresIgualesSeleccionado = (int) tabla.getValueAt(fila, columna);
                }else{
                    valoresIgualesSeleccionado = -1;
                }
                 */

            }
        });

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //COLUMNA NOMBRES DE GRIS
                if(column == 0){
                    c.setBackground(Color.gray);
                }else{
                    c.setBackground(Color.white);
                }

                //IGUALES DE AZUL
                if(valoresIgualesSeleccionado!=-1){
                    if(column==2 && value.equals(valoresIgualesSeleccionado)){
                        c.setBackground(Color.cyan);
                    }
                }

                //PROGRESSBAR EN COLUMNA 3
                if(column==2){
                    JProgressBar bar = new JProgressBar(0, 100000);
                    bar.setValue((Integer) value);
                    bar.setStringPainted(true);

                    if(80000 > (Integer) value){
                        bar.setForeground(Color.red);
                    }else{
                        bar.setForeground(Color.green);
                    }

                    return bar;
                }

                tabla.repaint();

                return c;
            }
        });

        this.setVisible(true);

    }

    private void añadirUsuarios( ArrayList<Usuario> usuarios){
        Usuario u1 = new Usuario("Eneko", "Alvarez", 34567);
        usuarios.add(u1);

        Usuario u2 = new Usuario("Sofia", "Gomez", 12345);
        usuarios.add(u2);

        Usuario u3 = new Usuario("Pedro", "Rodriguez", 98765);
        usuarios.add(u3);

        Usuario u4 = new Usuario("Maria", "Perez", 55555);
        usuarios.add(u4);

        Usuario u5 = new Usuario("Jorge", "Hernandez", 11111);
        usuarios.add(u5);

        Usuario u6 = new Usuario("Luisa", "Fernandez", 88888);
        usuarios.add(u6);

        Usuario u7 = new Usuario("Andres", "Sanchez", 44444);
        usuarios.add(u7);

        Usuario u8 = new Usuario("Lucia", "Gonzalez", 77777);
        usuarios.add(u8);

        Usuario u9 = new Usuario("Diego", "Diaz", 66666);
        usuarios.add(u9);

        Usuario u10 = new Usuario("Carla", "Torres", 33333);
        usuarios.add(u10);

        Usuario u11 = new Usuario("Marcos", "Jimenez", 22222);
        usuarios.add(u11);

        Usuario u12 = new Usuario("Paula", "Suarez", 99999);
        usuarios.add(u12);

        Usuario u13 = new Usuario("Alejandro", "Lopez", 88888);
        usuarios.add(u13);

        Usuario u14 = new Usuario("Elena", "Martinez", 77777);
        usuarios.add(u14);

        Usuario u15 = new Usuario("Hector", "Garcia", 66666);
        usuarios.add(u15);

        Usuario u16 = new Usuario("Rocio", "Perez", 55555);
        usuarios.add(u16);

        Usuario u17 = new Usuario("Juan", "Fernandez", 44444);
        usuarios.add(u17);

        Usuario u18 = new Usuario("Clara", "Rodriguez", 33333);
        usuarios.add(u18);

        Usuario u19 = new Usuario("Daniel", "Sanchez", 22222);
        usuarios.add(u19);

        Usuario u20 = new Usuario("Ana", "Torres", 11111);
        usuarios.add(u20);

        Usuario u21 = new Usuario("Manuel", "Gomez", 99999);
        usuarios.add(u21);

        Usuario u22 = new Usuario("Isabel", "Alvarez", 88888);
        usuarios.add(u22);

        Usuario u23 = new Usuario("Raul", "Diaz", 77777);
        usuarios.add(u23);

        Usuario u24 = new Usuario("Carmen", "Suarez", 66666);
        usuarios.add(u24);

        Usuario u25 = new Usuario("Pablo", "Jimenez", 55555);
        usuarios.add(u25);

        Usuario u26 = new Usuario("Lorena", "Lopez", 44444);
        usuarios.add(u26);

        Usuario u27 = new Usuario("Adrian", "Garcia", 33333);
        usuarios.add(u27);

        Usuario u28 = new Usuario("Natalia", "Martinez", 22222);
        usuarios.add(u28);

        Usuario u29 = new Usuario("Hugo", "Fernandez", 11111);
        usuarios.add(u29);

        Usuario u30 = new Usuario("Silvia", "Rodriguez", 99999);
        usuarios.add(u30);
    }

    private void añadirNuevo(){
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(1,2));
        frame.add(panel);

        panel.add(new JLabel("Nombre:"));
        JTextField tnombre = new JTextField();
        panel.add(tnombre);

        JButton guardar = new JButton("Guardar");
        frame.add(guardar, BorderLayout.SOUTH);
        frame.setVisible(true);

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = tnombre.getText();
                Usuario nuevo = new Usuario(nombre, "sdfgh", 567);
                usuarios.add(nuevo);

                Object[] nuevotabla = {nuevo.getName(), nuevo.getApellido(), nuevo.getNumero()};
                modelo.addRow(nuevotabla);
                frame.dispose();

            }
        });
    }
}
