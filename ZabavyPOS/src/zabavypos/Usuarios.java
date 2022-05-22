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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juanez
 */

public class Usuarios implements ActionListener{
    JFrame jFrmUsuarios;
    JPanel jPUsuarios;
    JScrollPane jSPUsuarios;
    JTable jTbUsuarios;
    DefaultTableModel Usuarios;
    JButton jBtnAceptar, jBtnCancelar, jBtnEliminar;
    JLabel jLblID, jLblNombre, jLblApellido, jLblCelular, jLblMail;
    JTextField jTxtID, jTxtNombre, jTxtApellido, jTxtCelular, jTxtMail;
    ResultSet RS;
    String User = null, Pass = null, Host = null, Base = null, Lengua = "", Path = "";
    ImageIcon Icono;
    ZabavyDB DB = new ZabavyDB();
    
    public Usuarios() {
        jFrmUsuarios = new JFrame("Zabavy Proveedores 0.9");
        jFrmUsuarios.setLayout(null);
        jPUsuarios = new JPanel();
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
            jLblApellido = new JLabel(BR.readLine());
            jLblCelular = new JLabel(BR.readLine());
            jLblMail = new JLabel(BR.readLine());
            Usuarios = new DefaultTableModel();
            Usuarios.addColumn(jLblID.getText());
            Usuarios.addColumn(jLblNombre.getText());
            Usuarios.addColumn(jLblApellido.getText());
            Usuarios.addColumn(jLblCelular.getText());
            Usuarios.addColumn(jLblMail.getText());
            jBtnAceptar = new JButton();
            jBtnAceptar.setToolTipText(BR.readLine());
            jBtnCancelar = new JButton();
            jBtnCancelar.setToolTipText(BR.readLine());
            jBtnEliminar = new JButton();
            jBtnEliminar.setToolTipText(BR.readLine());
            jTxtID = new JTextField();
            jTxtID.setToolTipText(BR.readLine());
            jTxtNombre = new JTextField();
            jTxtApellido = new JTextField();
            jTxtCelular = new JTextField();
            jTxtCelular.setToolTipText(jTxtID.getToolTipText());
            jTxtMail = new JTextField();
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
        jLblApellido.setBounds(10, 70, 100, 30);
        jLblApellido.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblApellido.setVisible(true);
        jTxtApellido.setBounds(115, 70, 150, 30);
        jTxtApellido.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtApellido.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtApellido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtApellido.setVisible(true);
        jLblCelular.setBounds(10, 130, 100, 30);
        jLblCelular.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblCelular.setVisible(true);
        jTxtCelular.setBounds(115, 130, 150, 30);
        jTxtCelular.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtCelular.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtCelular.setVisible(true);
        jLblMail.setBounds(10, 160, 100, 30);
        jLblMail.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jLblMail.setVisible(true);
        jTxtMail.setBounds(115, 160, 150, 30);
        jTxtMail.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtMail.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTxtMail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtMail.setVisible(true);
        jTbUsuarios = new JTable(Usuarios);
        jTbUsuarios.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTbUsuarios.setFocusable(false);
        jTbUsuarios.setCellSelectionEnabled(false);
        jTbUsuarios.setToolTipText("Proveedores");
        jTbUsuarios.getTableHeader().setReorderingAllowed(false);
        jTbUsuarios.setVisible(true);
        jSPUsuarios = new JScrollPane(jTbUsuarios);
        jSPUsuarios.setBounds(285, 10, 950, 500);
        jSPUsuarios.setVisible(true);
        jFrmUsuarios.add(jLblID);
        jFrmUsuarios.add(jTxtID);
        jFrmUsuarios.add(jLblNombre);
        jFrmUsuarios.add(jTxtNombre);
        jFrmUsuarios.add(jLblApellido);
        jFrmUsuarios.add(jTxtApellido);
        jFrmUsuarios.add(jLblCelular);
        jFrmUsuarios.add(jTxtCelular);
        jFrmUsuarios.add(jLblMail);
        jFrmUsuarios.add(jTxtMail);
        jFrmUsuarios.add(jSPUsuarios);
        jFrmUsuarios.add(jBtnAceptar);
        jFrmUsuarios.add(jBtnCancelar);
        jFrmUsuarios.add(jBtnEliminar);
        jFrmUsuarios.setBounds(0, 0, 1250, 600);
        Icono = new ImageIcon(Path + "Zabavy.zabavy");
        jFrmUsuarios.setIconImage(Icono.getImage());
        Icono  =  new ImageIcon(Path + "Error.zabavy");
        DB.Conection(Host, Base, User, Pass);
        try {
            RS = DB.Select("SELECT * FROM USUARIOS;");
            int Registros = 0;
            String[] Users = new String[5];
            while(RS.next()){
                Registros++;
            }
            RS.first();
            while(Registros > 0){
                Users[0] = RS.getString("CedUser");
                Users[1] = RS.getString("NomUser");
                Users[2] = RS.getString("ApelUser");
                Users[3] = RS.getString("CelUser");
                Users[4] = RS.getString("MailUser");
                Usuarios.addRow(Users);
                RS.next();
                Registros--;
            }
            jTbUsuarios.setModel(Usuarios);
            jFrmUsuarios.setVisible(true);    
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
                JOptionPane.showMessageDialog(null, "You must meet all fields", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                try{
                    String Nombre = jTxtNombre.getText().toUpperCase(), Direccion = jTxtApellido.getText().toUpperCase(), Mail = jTxtMail.getText().toUpperCase(), Celular = jTxtCelular.getText();
                    int  Cedula = Integer.parseInt(jTxtID.getText());
                    RS = DB.Select("SELECT * FROM USUARIOS WHERE CedUser='" + Cedula + "';");
                    if(RS.next()){
                        DB.Update("UPDATE USUARIOS SET NomUser='" + Nombre + "', ApelUser='" + Direccion + "', CelUser='" + Celular + "', MailUser='" + Mail + "', UserUser=' ', PassUser=' ', Admin=0 WHERE CedUser='" + Cedula + "';");
                    } else {
                        DB.Insert("INSERT INTO USUARIOS VALUES ('" + Cedula + "','" + Nombre + "','" + Direccion + "','" + Celular + "','" + Mail + "',' ',' ',0);");
                    }
                    int Registros;
                    Registros = Usuarios.getRowCount();
                    while (Registros > 0){
                        Usuarios.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbUsuarios.setModel(Usuarios);
                    RS = DB.Select("SELECT * FROM USUARIOS;");
                    Registros = 0;
                    String[] Users = new String[5];
                    while (RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while (Registros > 0){
                        Users[0] = RS.getString("CedUser");
                        Users[1] = RS.getString("NomUser");
                        Users[2] = RS.getString("ApelUser");
                        Users[3] = RS.getString("CelUser");
                        Users[4] = RS.getString("MailUser");
                        Usuarios.addRow(Users);
                        RS.next();
                        Registros--;
                    }
                    jTbUsuarios.setModel(Usuarios);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        } else if(e.getSource() == jTxtID){
            try{
                RS = DB.Select("SELECT * FROM USUARIOS WHERE CedUser='" + jTxtID.getText() + "';");
                if(RS.next()){
                    jTxtNombre.setText(RS.getString("NomUser"));
                    jTxtApellido.setText(RS.getString("ApelUser"));
                    jTxtCelular.setText(RS.getString("CelUser"));
                    jTxtMail.setText(RS.getString("MailUser"));
                } else {
                    jTxtNombre.setText("");
                    jTxtApellido.setText("");
                    jTxtCelular.setText("");
                    jTxtMail.setText("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            }
        } else if(e.getSource() == jBtnCancelar){
            jTxtID.setText("");
            jTxtNombre.setText("");
            jTxtApellido.setText("");
            jTxtCelular.setText("");
            jTxtMail.setText("");
        } else if(e.getSource() == jBtnEliminar){
            if(!jTxtID.getText().isEmpty()){
                try{
                    DB.Delete("DELETE FROM USUARIOS WHERE CedUser='" + jTxtID.getText() + "';");
                    jTxtID.setText("");
                    jTxtNombre.setText("");
                    jTxtApellido.setText("");
                    jTxtCelular.setText("");
                    jTxtMail.setText("");
                    int Registros;
                    Registros = Usuarios.getRowCount();
                    while (Registros > 0){
                        Usuarios.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbUsuarios.setModel(Usuarios);
                    RS = DB.Select("SELECT * FROM USUARIOS;");
                    Registros = 0;
                    String[] Users = new String[5];
                    while (RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while (Registros > 0){
                        Users[0] = RS.getString("CedUser");
                        Users[1] = RS.getString("NomUser");
                        Users[2] = RS.getString("ApelUser");
                        Users[3] = RS.getString("CelUser");
                        Users[4] = RS.getString("MailUser");
                        Usuarios.addRow(Users);
                        RS.next();
                        Registros--;
                    }
                    jTbUsuarios.setModel(Usuarios);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        }
    }
    
    
}
