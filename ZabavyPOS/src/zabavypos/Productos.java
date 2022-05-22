package zabavypos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juanez
 */

public class Productos implements ActionListener{
    JFrame jFrmProductos;
    JPanel jPProductos;
    JScrollPane jSPProductos;
    JTable jTbProductos;
    DefaultTableModel Productos;
    JButton jBtnAceptar, jBtnCancelar, jBtnEliminar;
    JLabel jLblProducto, jLblNombre, jLblValor, jLblIVA;
    JTextField jTxtProducto, jTxtNombre, jTxtValor, jTxtIVA;
    JCheckBox jChkIVA, jChkInventario, jChkPOS, jChkHabil;
    ResultSet RS;
    String User = null, Pass = null, Host = null, Base = null, Lengua = "", Path = "";
    ImageIcon Icono;
    ZabavyDB DB = new ZabavyDB();

    public Productos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZabavyPOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFrmProductos = new JFrame("Zabavy Productos 0.9");
        jFrmProductos.setLayout(null);
        jPProductos = new JPanel();
        Path = (new File("").getAbsolutePath() + File.separatorChar + "datos" + File.separatorChar);
        File Config = new File (Path + "ZabavyPOSConfig.zabavy");
        try (FileReader FR = new FileReader(Config); BufferedReader BR = new BufferedReader(FR)) {
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
            jLblProducto = new JLabel(BR.readLine());
            jLblNombre = new JLabel(BR.readLine());
            jLblValor = new JLabel(BR.readLine());
            jChkIVA = new JCheckBox(BR.readLine());
            jLblIVA = new JLabel(BR.readLine());
            jChkInventario = new JCheckBox(BR.readLine());
            jChkHabil = new JCheckBox(BR.readLine());
            jChkPOS = new JCheckBox(BR.readLine());
            jTxtProducto = new JTextField();
            jTxtProducto.setToolTipText(BR.readLine());
            jTxtNombre = new JTextField();
            jTxtValor = new JTextField();
            jTxtValor.setToolTipText(jTxtProducto.getToolTipText());
            jTxtIVA = new JTextField();
            jTxtIVA.setToolTipText(jTxtProducto.getToolTipText());
            Productos = new DefaultTableModel();
            Productos.addColumn(jLblProducto.getText());
            Productos.addColumn(jLblNombre.getText());
            Productos.addColumn(jLblValor.getText());
            Productos.addColumn("IVA?");
            Productos.addColumn(jLblIVA.getText());
            Productos.addColumn("Inventory?");
            Productos.addColumn("Available?");
            Productos.addColumn("POS?");
            jBtnAceptar = new JButton();
            jBtnAceptar.setToolTipText(BR.readLine());
            jBtnCancelar = new JButton();
            jBtnCancelar.setToolTipText(BR.readLine());
            jBtnEliminar = new JButton();
            jBtnEliminar.setToolTipText(BR.readLine());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        jBtnEliminar.setBounds(130, 440, 50, 50);
        jBtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBtnEliminar.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jBtnEliminar.setFocusable(false);
        jBtnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnEliminar.setBackground(Color.ORANGE);
        jBtnEliminar.setForeground(Color.WHITE);
        Icono = new ImageIcon(Path + "Remover.zabavy");
        jBtnEliminar.setIcon(Icono);
        jBtnEliminar.addActionListener(this);
        jBtnEliminar.setVisible(true);
        jBtnCancelar.setBounds(70, 440, 50, 50);
        jBtnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBtnCancelar.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jBtnCancelar.setFocusable(false);
        jBtnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnCancelar.setBackground(Color.RED);
        jBtnCancelar.setForeground(Color.WHITE);
        Icono = new ImageIcon(Path + "Cancelar.zabavy");
        jBtnCancelar.setIcon(Icono);
        jBtnCancelar.addActionListener(this);
        jBtnCancelar.setVisible(true);
        jBtnAceptar.setBounds(10, 440, 50, 50);
        jBtnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBtnAceptar.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jBtnAceptar.setFocusable(false);
        jBtnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAceptar.setBackground(Color.GREEN);
        jBtnAceptar.setForeground(Color.WHITE);
        Icono = new ImageIcon(Path + "Aceptar.zabavy");
        jBtnAceptar.setIcon(Icono);
        jBtnAceptar.addActionListener(this);
        jBtnAceptar.setVisible(true);
        jLblProducto.setBounds(10, 10, 100, 30);
        jLblProducto.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblProducto.setVisible(true);
        jTxtProducto.setBounds(115, 10, 150, 30);
        jTxtProducto.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtProducto.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtProducto.setVisible(true);
        jTxtProducto.addActionListener(this);
        jLblNombre.setBounds(10, 40, 100, 30);
        jLblNombre.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblNombre.setVisible(true);
        jTxtNombre.setBounds(115, 40, 150, 30);
        jTxtNombre.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtNombre.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtNombre.setVisible(true);
        jLblValor.setBounds(10, 70, 100, 30);
        jLblValor.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblValor.setVisible(true);
        jTxtValor.setBounds(115, 70, 150, 30);
        jTxtValor.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtValor.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtValor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtValor.setVisible(true);
        jChkIVA.setBounds(10, 220, 250, 30);
        jChkIVA.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jChkIVA.setVisible(true);
        jLblIVA.setBounds(10, 250, 100, 30);
        jLblIVA.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblIVA.setVisible(true);
        jTxtIVA.setBounds(115, 250, 150, 30);
        jTxtIVA.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtIVA.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtIVA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtIVA.setVisible(true);
        jChkInventario.setBounds(10, 280, 250, 30);
        jChkInventario.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jChkInventario.setVisible(true);
        jChkPOS.setBounds(10, 340, 250, 30);
        jChkPOS.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jChkPOS.setVisible(true);
        jChkHabil.setBounds(10, 400, 250, 30);
        jChkHabil.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jChkHabil.setVisible(true);
        jTbProductos = new JTable(Productos);
        jTbProductos.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTbProductos.setFocusable(false);
        jTbProductos.setCellSelectionEnabled(false);
        jTbProductos.setToolTipText("Productos");
        jTbProductos.getTableHeader().setReorderingAllowed(false);
        jTbProductos.setVisible(true);
        jSPProductos = new JScrollPane(jTbProductos);
        jSPProductos.setBounds(285, 10, 950, 500);
        jSPProductos.setVisible(true);
        jFrmProductos.add(jLblProducto);
        jFrmProductos.add(jTxtProducto);
        jFrmProductos.add(jLblNombre);
        jFrmProductos.add(jTxtNombre);
        jFrmProductos.add(jLblValor);
        jFrmProductos.add(jTxtValor);
        jFrmProductos.add(jChkIVA);
        jFrmProductos.add(jLblIVA);
        jFrmProductos.add(jTxtIVA);
        jFrmProductos.add(jChkInventario);
        jFrmProductos.add(jChkPOS);
        jFrmProductos.add(jChkHabil);
        jFrmProductos.add(jBtnAceptar);
        jFrmProductos.add(jBtnCancelar);
        jFrmProductos.add(jBtnEliminar);
        jFrmProductos.add(jSPProductos);
        jFrmProductos.setBounds(0, 0, 1250, 600);
        Icono = new ImageIcon(Path + "Zabavy.zabavy");
        jFrmProductos.setIconImage(Icono.getImage());
        Icono  =  new ImageIcon(Path + "Error.zabavy");
        DB.Conection(Host, Base, User, Pass);
        try {
            RS = DB.Select("SELECT * FROM PRODUCTOS;");
            int Registros = 0;
            String[] Products = new String[14];
            while (RS.next()){
                Registros++;
            }
            RS.first();
            while (Registros > 0){
                Products[0] = RS.getString("Producto");
                Products[1] = RS.getString("NomProd");
                Products[2] = RS.getString("ValorProd");
                Products[3] = RS.getString("IVA");
                Products[4] = RS.getString("IVAValor");
                Products[5] = RS.getString("Inventario");
                Products[6] = RS.getString("Habilitado");
                Products[7] = RS.getString("POS");
                Productos.addRow(Products);
                RS.next();
                Registros--;
            }
            jTbProductos.setModel(Productos);
            jFrmProductos.setVisible(true);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            System.exit(0);
        }
        Icono  =  new ImageIcon(Path + "Error.zabavy");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jBtnAceptar){
            if((jTxtProducto.getText().isEmpty()) || (jTxtNombre.getText().isEmpty()) || (jTxtValor.getText().isEmpty()) || (jTxtIVA.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                try{
                    String Nombre = jTxtNombre.getText().toUpperCase();
                    int Prod = Integer.parseInt(jTxtProducto.getText()), Habil = jChkHabil.isSelected()?1:0, POS = jChkPOS.isSelected()?1:0, IsIVA = jChkIVA.isSelected()?1:0, Inventario = jChkInventario.isSelected()?1:0;
                    float Valor = Float.parseFloat(jTxtValor.getText()), IVA = Float.parseFloat(jTxtIVA.getText());
                    RS = DB.Select("SELECT * FROM PRODUCTOS WHERE Producto='" + Prod + "';");
                    if(RS.next()){
                        DB.Update("UPDATE PRODUCTOS SET NomProd='" + Nombre + "', ValorProd='" + Valor + "', IVA=" + IsIVA + ", IVAValor='" + IVA + "', Inventario=" + Inventario + ", Habilitado=" + Habil + ", POS=" + POS + " WHERE Producto='" + Prod + "';");
                        if(Inventario == 1){
                            DB.Insert("INSERT INTO INVENTARIO VALUES ('" + Prod +"', 0)");
                        }
                    } else {
                        DB.Insert("INSERT INTO PRODUCTOS VALUES (NULL,'" + Prod + "','" + Nombre + "','" + Valor + "'," + IsIVA + ",'" + IVA + "'," + Inventario + "," + Habil + "," + POS + ");");
                        if(Inventario == 1){
                            DB.Insert("INSERT INTO INVENTARIO VALUES ('" + Prod +"', 0)");
                        }
                    }
                    int Registros = 0;
                    Registros = Productos.getRowCount();
                    while (Registros > 0){
                        Productos.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbProductos.setModel(Productos);
                    RS = DB.Select("SELECT * FROM PRODUCTOS;");
                    Registros = 0;
                    String[] Products = new String[14];
                    while (RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while (Registros > 0){
                        Products[0] = RS.getString("Producto");
                        Products[1] = RS.getString("NomProd");
                        Products[2] = RS.getString("ValorProd");
                        Products[3] = RS.getString("IVA");
                        Products[4] = RS.getString("IVAValor");
                        Products[5] = RS.getString("Inventario");
                        Products[6] = RS.getString("Habilitado");
                        Products[7] = RS.getString("POS");
                        Productos.addRow(Products);
                        RS.next();
                        Registros--;
                    }
                    jTbProductos.setModel(Productos);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        } else if(e.getSource() == jTxtProducto){
            try{
                RS = DB.Select("SELECT * FROM PRODUCTOS WHERE Producto='" + jTxtProducto.getText() + "';");
                if(RS.next()){
                    jTxtNombre.setText(RS.getString("NomProd"));
                    jTxtValor.setText(RS.getString("ValorProd"));
                    jChkIVA.setSelected(RS.getBoolean("IVA"));
                    jTxtIVA.setText(RS.getString("IVAValor"));
                    jChkInventario.setSelected(RS.getBoolean("Inventario"));
                    jChkHabil.setSelected(RS.getBoolean("Habilitado"));
                    jChkPOS.setSelected(RS.getBoolean("POS"));
                } else {
                    jTxtNombre.setText("");
                    jTxtValor.setText("");
                    jChkIVA.setSelected(false);
                    jTxtIVA.setText("");
                    jChkInventario.setSelected(false);
                    jChkHabil.setSelected(false);
                    jChkPOS.setSelected(false);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            }
        } else if(e.getSource() == jBtnCancelar){
            jTxtProducto.setText("");
            jTxtNombre.setText("");
            jTxtValor.setText("");
            jChkIVA.setSelected(false);
            jTxtIVA.setText("");
            jChkInventario.setSelected(false);
            jChkHabil.setSelected(false);
            jChkPOS.setSelected(false);
        } else if(e.getSource() == jBtnEliminar){
            if(!jTxtProducto.getText().isEmpty()){
                DB.Delete("DELETE FROM INVENTARIO WHERE IdProd='" + jTxtProducto.getText() +"';");
                try{
                    DB.Delete("DELETE FROM PRODUCTOS WHERE Producto='" + jTxtProducto.getText() + "';");
                    jTxtProducto.setText("");
                    jTxtNombre.setText("");
                    jTxtValor.setText("");
                    jChkIVA.setSelected(false);
                    jTxtIVA.setText("");
                    jChkInventario.setSelected(false);
                    jChkHabil.setSelected(false);
                    jChkPOS.setSelected(false);
                    int Registros = 0;
                    Registros = Productos.getRowCount();
                    while (Registros > 0){
                        Productos.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbProductos.setModel(Productos);
                    RS = DB.Select("SELECT * FROM PRODUCTOS;");
                    Registros = 0;
                    String[] Products = new String[14];
                    while (RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while (Registros > 0){
                        Products[0] = RS.getString("Producto");
                        Products[1] = RS.getString("NomProd");
                        Products[2] = RS.getString("ValorProd");
                        Products[3] = RS.getString("IVA");
                        Products[4] = RS.getString("IVAValor");
                        Products[5] = RS.getString("Inventario");
                        Products[6] = RS.getString("Habilitado");
                        Products[7] = RS.getString("POS");
                        Productos.addRow(Products);
                        RS.next();
                        Registros--;
                    }
                    jTbProductos.setModel(Productos);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        }
    }
}
