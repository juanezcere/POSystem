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
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Inventario implements ActionListener{
    JFrame jFrmInventario;
    JPanel jPInventario;
    JScrollPane jSPInventario;
    JTable jTbInventario;
    DefaultTableModel Inventario;
    JButton jBtnAceptar, jBtnCancelar, jBtnEliminar;
    JLabel jLblID, jLblNombre, jLblCantidad;
    JTextField jTxtID, jTxtNombre, jTxtCantidad;
    ResultSet RS;
    String User = null, Pass = null, Host = null, Base = null, Lengua = "", Path = "";
    ImageIcon Icono;
    ZabavyDB DB = new ZabavyDB();
    
    public Inventario() {
        jFrmInventario = new JFrame("Zabavy Inventario 0.9");
        jFrmInventario.setLayout(null);
        jPInventario = new JPanel();
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
            BR.readLine();
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
            jLblID = new JLabel(BR.readLine());
            jLblNombre = new JLabel(BR.readLine());
            jLblCantidad = new JLabel(BR.readLine());
            Inventario = new DefaultTableModel();
            Inventario.addColumn(jLblID.getText());
            Inventario.addColumn(jLblNombre.getText());
            Inventario.addColumn(jLblCantidad.getText());
            jBtnAceptar = new JButton();
            jBtnAceptar.setToolTipText(BR.readLine());
            jBtnCancelar = new JButton();
            jBtnCancelar.setToolTipText(BR.readLine());
            jBtnEliminar = new JButton();
            jBtnEliminar.setToolTipText(BR.readLine());
            jTxtID = new JTextField();
            jTxtID.setToolTipText(BR.readLine());
            jTxtNombre = new JTextField();
            jTxtCantidad = new JTextField();
            jTxtCantidad.setToolTipText(jTxtID.getToolTipText());
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
        Icono  =  new ImageIcon(Path + "Remover.zabavy");
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
        Icono  =  new ImageIcon(Path + "Cancelar.zabavy");
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
        Icono  =  new ImageIcon(Path + "Aceptar.zabavy");
        jBtnAceptar.setIcon(Icono);
        jBtnAceptar.addActionListener(this);
        jBtnAceptar.setVisible(true);
        jLblID.setBounds(10, 10, 100, 30);
        jLblID.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblID.setVisible(true);
        jTxtID.setBounds(115, 10, 150, 30);
        jTxtID.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtID.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtID.setVisible(true);
        jTxtID.addActionListener(this);
        jLblNombre.setBounds(10, 40, 100, 30);
        jLblNombre.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblNombre.setVisible(true);
        jTxtNombre.setBounds(115, 40, 150, 30);
        jTxtNombre.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtNombre.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtNombre.setVisible(true);
        jTxtNombre.setFocusable(false);
        jLblCantidad.setBounds(10, 70, 100, 30);
        jLblCantidad.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblCantidad.setVisible(true);
        jTxtCantidad.setBounds(115, 70, 150, 30);
        jTxtCantidad.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtCantidad.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtCantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtCantidad.setVisible(true);
        jTbInventario = new JTable(Inventario);
        jTbInventario.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTbInventario.setFocusable(false);
        jTbInventario.setCellSelectionEnabled(false);
        jTbInventario.setToolTipText("Clientes");
        jTbInventario.getTableHeader().setReorderingAllowed(false);
        jTbInventario.setVisible(true);
        jSPInventario = new JScrollPane(jTbInventario);
        jSPInventario.setBounds(285, 10, 950, 500);
        jSPInventario.setVisible(true);
        jFrmInventario.add(jLblID);
        jFrmInventario.add(jTxtID);
        jFrmInventario.add(jLblNombre);
        jFrmInventario.add(jTxtNombre);
        jFrmInventario.add(jLblCantidad);
        jFrmInventario.add(jTxtCantidad);
        jFrmInventario.add(jSPInventario);
        jFrmInventario.add(jBtnAceptar);
        jFrmInventario.add(jBtnCancelar);
        jFrmInventario.add(jBtnEliminar);
        jFrmInventario.setBounds(0, 0, 1250, 600);
        Icono = new ImageIcon(Path + "Zabavy.zabavy");
        jFrmInventario.setIconImage(Icono.getImage());
        Icono  =  new ImageIcon(Path + "Error.zabavy");
        DB.Conection(Host, Base, User, Pass);
        try {
            RS = DB.Select("SELECT productos.Producto, productos.NomProd, inventario.CantProd FROM inventario INNER JOIN productos ON inventario.IdProd = productos.Producto;");
            int Registros = 0;
            String[] Inventory = new String[3];
            while(RS.next()){
                Registros++;
            }
            RS.first();
            while(Registros > 0){
                Inventory[0] = RS.getString("Producto");
                Inventory[1] = RS.getString("NomProd");
                Inventory[2] = RS.getString("CantProd");
                Inventario.addRow(Inventory);
                RS.next();
                Registros--;
            }
            jTbInventario.setModel(Inventario);
            jFrmInventario.setVisible(true);    
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            System.exit(0);
        }
        Icono = new ImageIcon(Path + "Error.zabavy");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jBtnAceptar){
            if((jTxtID.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                try{
                    int ID = Integer.parseInt(jTxtID.getText()), Cantidad = Integer.parseInt(jTxtCantidad.getText());
                    RS = DB.Select("SELECT CantProd FROM INVENTARIO WHERE IdProd='" + ID + "';");
                    if(RS.next()){
                        DB.Update("UPDATE INVENTARIO SET CantProd=CantProd+" + Cantidad + " WHERE IdProd='" + ID + "';");
                    } else {
                        DB.Insert("INSERT INTO INVENTARIO VALUES ('" + ID + "','" + Cantidad + "');");
                    }
                    DB.Insert("INSERT INTO HISTORIAL VALUES ('1','" + ID + "','1','" + Cantidad + "','INVENTARIO', NOW());");
                    int Registros;
                    Registros = Inventario.getRowCount();
                    while (Registros > 0){
                        Inventario.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbInventario.setModel(Inventario);
                    RS = DB.Select("SELECT productos.Producto, productos.NomProd, inventario.CantProd FROM inventario INNER JOIN productos ON inventario.IdProd = productos.Producto;");
                    Registros = 0;
                    String[] Inventory = new String[3];
                    while(RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while(Registros > 0){
                        Inventory[0] = RS.getString("Producto");
                        Inventory[1] = RS.getString("NomProd");
                        Inventory[2] = RS.getString("CantProd");
                        Inventario.addRow(Inventory);
                        RS.next();
                        Registros--;
                    }
                    jTbInventario.setModel(Inventario);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        } else if(e.getSource() == jTxtID){
            try{
                RS = DB.Select("SELECT productos.NomProd, inventario.CantProd FROM inventario INNER JOIN productos ON inventario.IdProd = productos.Producto WHERE productos.Producto ='" + jTxtID.getText() + "';");
                if(RS.next()){
                    jTxtNombre.setText(RS.getString("NomProd"));
                    jTxtCantidad.setText(RS.getString("CantProd"));
                } else {
                    jTxtNombre.setText("");
                    jTxtCantidad.setText("0");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            }
        } else if(e.getSource() == jBtnCancelar){
            jTxtID.setText("");
            jTxtNombre.setText("");
            jTxtCantidad.setText("0");
        } else if(e.getSource() == jBtnEliminar){
            if(!jTxtID.getText().isEmpty()){
                try{
                    DB.Delete("DELETE FROM INVENTARIO WHERE IdProd='" + jTxtID.getText() + "';");
                    jTxtID.setText("");
                    jTxtNombre.setText("");
                    jTxtCantidad.setText("0");
                    int Registros;
                    Registros = Inventario.getRowCount();
                    while (Registros > 0){
                        Inventario.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbInventario.setModel(Inventario);
                    RS = DB.Select("SELECT productos.Producto, productos.NomProd, inventario.CantProd FROM inventario INNER JOIN productos ON inventario.IdProd = productos.Producto;");
                    Registros = 0;
                    String[] Inventory = new String[3];
                    while(RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while(Registros > 0){
                        Inventory[0] = RS.getString("Producto");
                        Inventory[1] = RS.getString("NomProd");
                        Inventory[2] = RS.getString("CantProd");
                        Inventario.addRow(Inventory);
                        RS.next();
                        Registros--;
                    }
                    jTbInventario.setModel(Inventario);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        }
    }
    
    
}

