package inventarioapp.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box.Filler;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private final List<ElementoMenu> menuElementos = new ArrayList<>();
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }
    
    /**
     * Este metodo agrega un elemento al menu lateral de la ventana
     * recibe el texto de la opcion del menu, el nombre del icono (imagen PNG)
     * y una funcion/metodo que sera llamada cuando den click a la opcion del menu
     */
    public ElementoMenu agregarElementoMenu(String texto, String icono, Runnable accion) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(236, 240, 241));
        panel.setMaximumSize(new Dimension(2147483647, 28));
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblIcono = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icono)));
        lblIcono.setName("icono");
            
        int lblIconoWidth = 40;
        int lblIconoHeight = 24;
        
        lblIcono.setMinimumSize(new Dimension(lblIconoWidth, lblIconoHeight));
        lblIcono.setPreferredSize(new Dimension(lblIconoWidth, lblIconoHeight));
        lblIcono.setMaximumSize(new Dimension(lblIconoWidth, lblIconoHeight));
        lblIcono.setBorder(BorderFactory.createEmptyBorder(1, 8, 0, 15));
        lblIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIcono.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel lblTexto = new JLabel();
        lblTexto.setForeground(new Color(70, 87, 107));
        lblTexto.setFont(lblTexto.getFont().deriveFont(lblTexto.getFont().getStyle() | java.awt.Font.BOLD));
        lblTexto.setName("texto");
        lblTexto.setText(texto);
        lblTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        panel.add(lblIcono);
        panel.add(lblTexto);
        menu.add(panel);

        Filler separador = new Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
        menu.add(separador);
        
        ElementoMenu elementoMenu = new ElementoMenu(texto, accion, panel);

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (elementoMenu.activo) {
                    panel.setBackground(new Color(69, 170, 242));
                } else {
                    panel.setBackground(new Color(209, 216, 224));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (elementoMenu.activo) {
                    panel.setBackground(new Color(69, 170, 242));
                } else {
                    panel.setBackground(new Color(236, 240, 241));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                desmarcarElementosMenu();
                accion.run();
                elementoMenu.activo = true;
                panel.setBackground(new Color(69, 170, 242));
                lblTexto.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}
        });
            
        menuElementos.add(elementoMenu);
        
        return elementoMenu;
    }
    
    // desmarca todos las opciones del menu
    public void desmarcarElementosMenu() {
        for (ElementoMenu elemento : menuElementos) {
            JPanel panel = elemento.panel;
            JLabel lblTexto = null;
            Component[] componentes = panel.getComponents();
            
            for (int i = 0; i < componentes.length; i++) {
                Component componente = componentes[i];
                
                if (componente.getName().equalsIgnoreCase("texto")) {
                   lblTexto = (JLabel) componente;
                   break;
                }
            }
            
            elemento.activo = false;
            panel.setBackground(new Color(236, 240, 241));
            
            if (lblTexto != null) {
                lblTexto.setForeground(new Color(70, 87, 107));
            }
        }
    }
    
    // muestra una vista en la ventana, una vista es basicamente un JPanel
    // al mostrar una vista se reemplaza un JPanel por otro
    public void mostrarVista(JPanel vista) {
        vista.setOpaque(false);
        contenedor.removeAll();
        contenedor.add(vista);
        contenedor.repaint();
        contenedor.revalidate();
    }
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sidebar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        menu = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        sidebar.setBackground(new java.awt.Color(236, 240, 241));
        sidebar.setMaximumSize(new java.awt.Dimension(200, 2147483647));
        sidebar.setMinimumSize(new java.awt.Dimension(200, 100));
        sidebar.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(236, 240, 241));

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 16));
        jLabel1.setForeground(new java.awt.Color(70, 87, 107));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Inventario");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator1.setBackground(new java.awt.Color(236, 240, 241));
        jSeparator1.setForeground(new java.awt.Color(189, 195, 199));

        menu.setBackground(new java.awt.Color(236, 240, 241));
        menu.setLayout(new javax.swing.BoxLayout(menu, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebar.add(jPanel1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(sidebar, gridBagConstraints);

        main.setBackground(new java.awt.Color(255, 255, 255));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setOpaque(false);
        contenedor.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(main, gridBagConstraints);

        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
    
    public class ElementoMenu {
        public String texto;
        public Runnable accion;
        public JPanel panel;
        public boolean activo = false;
        
        public ElementoMenu(String texto, Runnable accion, JPanel panel) {
            this.texto = texto;
            this.accion = accion;
            this.panel = panel;
        }
        
        public void seleccionar() {
            desmarcarElementosMenu();
            accion.run();
            activo = true;
            panel.setBackground(new Color(69, 170, 242));
            
            for (int i = 0; i < panel.getComponents().length; i++) {
                if (panel.getComponents()[i].getName().equalsIgnoreCase("texto")) {
                    panel.getComponents()[i].setForeground(Color.WHITE);
                    break;
                }
            }
        }
    }
}
