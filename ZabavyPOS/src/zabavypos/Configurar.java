package zabavypos;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanez
 */

public class Configurar implements ActionListener{
    
    JFrame jFrmConfig;
    JButton jBtnPOS, jBtnInventario, jBtnProductos, jBtnReportes, jBtnFacturas, jBtnUsuarios, jBtnClientes, jBtnSalir;
    int x, y;
    String Path, Host, Base, User, Pass, Lengua;
    ImageIcon Icono;
    
    public Configurar(){
        jFrmConfig = new JFrame("Zabavy POS 0.9");
        jFrmConfig.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = (int) screenSize.getWidth();
        y = (int) screenSize.getHeight();
        Path = (new File("").getAbsolutePath() + File.separatorChar + "datos" + File.separatorChar);
        File Config = new File (Path + "ZabavyPOSConfig.zabavy");
        try(FileReader FR = new FileReader(Config); BufferedReader BR = new BufferedReader(FR)){
            BR.readLine();
            BR.readLine();
            BR.readLine();
            BR.readLine();
            BR.readLine();
            Host = BR.readLine();
            Base = BR.readLine();
            User = BR.readLine();
            Pass = BR.readLine();
            BR.readLine();
            Lengua = BR.readLine();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        File Lenguaje = new File(Path + Lengua);
        try (FileReader FR = new FileReader(Lenguaje); BufferedReader BR = new BufferedReader(FR)) {
            BR.readLine();
            jBtnProductos = new JButton();
            jBtnProductos.setToolTipText(BR.readLine());
            jBtnPOS = new JButton();
            jBtnPOS.setToolTipText(BR.readLine());
            jBtnReportes = new JButton();
            jBtnReportes.setToolTipText(BR.readLine());
            jBtnFacturas = new JButton();
            jBtnFacturas.setToolTipText(BR.readLine());
            jBtnInventario = new JButton();
            jBtnInventario.setToolTipText(BR.readLine());
            jBtnUsuarios = new JButton();
            jBtnUsuarios.setToolTipText(BR.readLine());
            jBtnClientes = new JButton();
            jBtnClientes.setToolTipText(BR.readLine());
            jBtnSalir = new JButton();
            jBtnSalir.setToolTipText(BR.readLine());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        jBtnSalir.setBounds(0, 0, 190, 50);
        jBtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Salir.zabavy");
        jBtnSalir.setIcon(Icono);
        jBtnSalir.setFocusable(false);
        jBtnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnSalir.addActionListener(this);
        jBtnSalir.setVisible(true);
        jBtnProductos.setBounds(10, 60, 50, 50);
        jBtnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Productos.zabavy");
        jBtnProductos.setIcon(Icono);
        jBtnProductos.setFocusable(false);
        jBtnProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnProductos.addActionListener(this);
        jBtnProductos.setVisible(true);
        jBtnFacturas.setBounds(70, 60, 50, 50);
        jBtnFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Facturas.zabavy");
        jBtnFacturas.setIcon(Icono);
        jBtnFacturas.setFocusable(false);
        jBtnFacturas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnFacturas.addActionListener(this);
        jBtnFacturas.setVisible(true);
        jBtnPOS.setBounds(70, 120, 50, 50);
        jBtnPOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "POS.zabavy");
        jBtnPOS.setIcon(Icono);
        jBtnPOS.setFocusable(false);
        jBtnPOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnPOS.addActionListener(this);
        jBtnPOS.setVisible(true);
        jBtnInventario.setBounds(130, 60, 50, 50);
        jBtnInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Inventarios.zabavy");
        jBtnInventario.setIcon(Icono);
        jBtnInventario.setFocusable(false);
        jBtnInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnInventario.addActionListener(this);
        jBtnInventario.setVisible(true);
        jBtnReportes.setBounds(10, 180, 50, 50);
        jBtnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Reportes.zabavy");
        jBtnReportes.setIcon(Icono);
        jBtnReportes.setFocusable(false);
        jBtnReportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnReportes.addActionListener(this);
        jBtnReportes.setVisible(true);
        jBtnUsuarios.setBounds(70, 180, 50, 50);
        jBtnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Usuarios.zabavy");
        jBtnUsuarios.setIcon(Icono);
        jBtnUsuarios.setFocusable(false);
        jBtnUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnUsuarios.addActionListener(this);
        jBtnUsuarios.setVisible(true);
        jBtnClientes.setBounds(130, 180, 50, 50);
        jBtnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Clientes.zabavy");
        jBtnClientes.setIcon(Icono);
        jBtnClientes.setFocusable(false);
        jBtnClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnClientes.addActionListener(this);
        jBtnClientes.setVisible(true);
        jFrmConfig.add(jBtnProductos);
        jFrmConfig.add(jBtnPOS);
        jFrmConfig.add(jBtnReportes);
        jFrmConfig.add(jBtnFacturas);
        jFrmConfig.add(jBtnInventario);
        jFrmConfig.add(jBtnUsuarios);
        jFrmConfig.add(jBtnClientes);
        jFrmConfig.add(jBtnSalir);
        jFrmConfig.setBounds(((x / 2) - 105), ((y / 2) - 150), 210, 300);
        Icono  =  new ImageIcon(Path + "Zabavy.zabavy");
        jFrmConfig.setIconImage(Icono.getImage());
        jFrmConfig.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jBtnProductos){
            Productos Init = new Productos();
        } else if(e.getSource() == jBtnUsuarios){
            Usuarios Init = new Usuarios();
        } else if(e.getSource() == jBtnClientes){
            Clientes Init = new Clientes();
        } else if(e.getSource() == jBtnSalir){
            System.exit(0);
        } else if(e.getSource() == jBtnReportes){
            Path = (new File("").getAbsolutePath() + File.separatorChar + "datos" + File.separatorChar);
            File Historia = new File(Path + "HISTORIAL.csv");
            Historia.delete();
            try {
                Runtime.getRuntime().exec("cmd /c start " + Path + "Historial.bat");
            } catch (IOException ex) {}
        } else if(e.getSource() == jBtnPOS){
            POSDesign Init = new POSDesign();
        } else if(e.getSource() == jBtnFacturas){
            Facturas Init = new Facturas();
        } else if(e.getSource() == jBtnInventario){
            Inventario Init = new Inventario();
        }
    }
}
