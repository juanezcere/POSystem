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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Facturas implements ActionListener{
    JFrame jFrmFaturas;
    JPanel jPFacturas;
    JScrollPane jSPFacturas;
    JTable jTbFacturas;
    DefaultTableModel Facturas;
    JButton jBtnAceptar, jBtnCancelar, jBtnExportar, jBtnConfig;
    JLabel jLblID;
    JTextField jTxtID;
    ResultSet RS;
    String User = null, Pass = null, Host = null, Base = null, Lengua = "", Path = "", Fact = "";
    ImageIcon Icono;
    ZabavyDB DB = new ZabavyDB();
    
    public Facturas() {
        jFrmFaturas = new JFrame("Zabavy Facturas 0.9");
        jFrmFaturas.setLayout(null);
        jPFacturas = new JPanel();
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
            BR.readLine();
            Lengua = BR.readLine();
            Fact = BR.readLine();
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
            Facturas = new DefaultTableModel();
            Facturas.addColumn(jLblID.getText());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            Facturas.addColumn(BR.readLine());
            jBtnAceptar = new JButton();
            jBtnAceptar.setToolTipText(BR.readLine());
            jBtnCancelar = new JButton();
            jBtnCancelar.setToolTipText(BR.readLine());
            jBtnExportar = new JButton();
            jBtnExportar.setToolTipText(BR.readLine());
            jBtnConfig = new JButton();
            jBtnConfig.setToolTipText(BR.readLine());
            jTxtID = new JTextField();
            jTxtID.setToolTipText(BR.readLine());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        jBtnExportar.setBounds(130, 440, 50, 50);
        jBtnExportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBtnExportar.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jBtnExportar.setFocusable(false);
        jBtnExportar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnExportar.setBackground(Color.ORANGE);
        jBtnExportar.setForeground(Color.WHITE);
        Icono  =  new ImageIcon(Path + "Facturas.zabavy");
        jBtnExportar.setIcon(Icono);
        jBtnExportar.addActionListener(this);
        jBtnExportar.setVisible(true);
        jBtnConfig.setBounds(200, 440, 50, 50);
        jBtnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBtnConfig.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jBtnConfig.setFocusable(false);
        jBtnConfig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Icono  =  new ImageIcon(Path + "Config.zabavy");
        jBtnConfig.setIcon(Icono);
        jBtnConfig.addActionListener(this);
        jBtnConfig.setVisible(true);
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
        jTbFacturas = new JTable(Facturas);
        jTbFacturas.setFont(new Font("VERDANA", Font.PLAIN, 12));
        jTbFacturas.setFocusable(false);
        jTbFacturas.setCellSelectionEnabled(false);
        jTbFacturas.setToolTipText("Facturas");
        jTbFacturas.getTableHeader().setReorderingAllowed(false);
        jTbFacturas.setVisible(true);
        jSPFacturas = new JScrollPane(jTbFacturas);
        jSPFacturas.setBounds(285, 10, 950, 500);
        jSPFacturas.setVisible(true);
        jFrmFaturas.add(jLblID);
        jFrmFaturas.add(jTxtID);
        jFrmFaturas.add(jSPFacturas);
        jFrmFaturas.add(jBtnAceptar);
        jFrmFaturas.add(jBtnCancelar);
        jFrmFaturas.add(jBtnExportar);
        jFrmFaturas.add(jBtnConfig);
        jFrmFaturas.setBounds(0, 0, 1250, 600);
        Icono = new ImageIcon(Path + "Zabavy.zabavy");
        jFrmFaturas.setIconImage(Icono.getImage());
        Icono  =  new ImageIcon(Path + "Error.zabavy");
        DB.Conection(Host, Base, User, Pass);
        try {
            RS = DB.Select("SELECT * FROM FACTURAS ORDER BY Fecha DESC;");
            int Registros = 0;
            String[] Facts = new String[9];
            while(RS.next()){
                Registros++;
            }
            RS.first();
            while(Registros > 0){
                Facts[0] = RS.getString("Factura") + RS.getString("IdFact");
                Facts[1] = RS.getString("FactIVA");
                Facts[2] = RS.getString("FactNeto");
                Facts[3] = RS.getString("FactTotal");
                Facts[4] = RS.getString("FactPagado");
                Facts[5] = RS.getString("FactDevuelta");
                Facts[6] = RS.getString("FactPago");
                Facts[7] = RS.getString("Fecha");
                Facts[8] = RS.getString("Voucher");
                Facturas.addRow(Facts);
                RS.next();
                Registros--;
            }
            jTbFacturas.setModel(Facturas);
            jFrmFaturas.setVisible(true);    
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
                JOptionPane.showMessageDialog(null, "Debe llenar el campo de código", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                try{
                    int Registros;
                    Registros = Facturas.getRowCount();
                    while (Registros > 0){
                        Facturas.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbFacturas.setModel(Facturas);
                    RS = DB.Select("SELECT * FROM FACTURAS WHERE IdFact='" + jTxtID.getText() + "';");
                    Registros = 0;
                    String[] Facts = new String[9];
                    while(RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while(Registros > 0){
                        Facts[0] = RS.getString("Factura") + RS.getString("IdFact");
                        Facts[1] = RS.getString("FactIVA");
                        Facts[2] = RS.getString("FactNeto");
                        Facts[3] = RS.getString("FactTotal");
                        Facts[4] = RS.getString("FactPagado");
                        Facts[5] = RS.getString("FactDevuelta");
                        Facts[6] = RS.getString("FactPago");
                        Facts[7] = RS.getString("Fecha");
                        Facts[8] = RS.getString("Voucher");
                        Facturas.addRow(Facts);
                        RS.next();
                        Registros--;
                    }
                    jTbFacturas.setModel(Facturas);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        } else if(e.getSource() == jTxtID){
            try{
                RS = DB.Select("SELECT * FROM FACTURAS WHERE IdFact='" + jTxtID.getText() + "';");
                if(RS.next()){
                    int Registros;
                    Registros = Facturas.getRowCount();
                    while (Registros > 0){
                        Facturas.removeRow(Registros - 1);
                        Registros--;
                    }
                    jTbFacturas.setModel(Facturas);
                    Registros = 0;
                    String[] Facts = new String[9];
                    while(RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while(Registros > 0){
                        Facts[0] = RS.getString("Factura") + RS.getString("IdFact");
                        Facts[1] = RS.getString("FactIVA");
                        Facts[2] = RS.getString("FactNeto");
                        Facts[3] = RS.getString("FactTotal");
                        Facts[4] = RS.getString("FactPagado");
                        Facts[5] = RS.getString("FactDevuelta");
                        Facts[6] = RS.getString("FactPago");
                        Facts[7] = RS.getString("Fecha");
                        Facts[8] = RS.getString("Voucher");
                        Facturas.addRow(Facts);
                        RS.next();
                        Registros--;
                    }
                    jTbFacturas.setModel(Facturas);
                } else {
                    RS = DB.Select("SELECT * FROM FACTURAS ORDER BY Fecha DESC;");
                    int Registros = 0;
                    String[] Facts = new String[9];
                    while(RS.next()){
                        Registros++;
                    }
                    RS.first();
                    while(Registros > 0){
                        Facts[0] = RS.getString("Factura") + RS.getString("IdFact");
                        Facts[1] = RS.getString("FactIVA");
                        Facts[2] = RS.getString("FactNeto");
                        Facts[3] = RS.getString("FactTotal");
                        Facts[4] = RS.getString("FactPagado");
                        Facts[5] = RS.getString("FactDevuelta");
                        Facts[6] = RS.getString("FactPago");
                        Facts[7] = RS.getString("Fecha");
                        Facts[8] = RS.getString("Voucher");
                        Facturas.addRow(Facts);
                        RS.next();
                        Registros--;
                    }
                    jTbFacturas.setModel(Facturas);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            }
        } else if(e.getSource() == jBtnCancelar){
            jTxtID.setText("");
        } else if(e.getSource() == jBtnExportar){
            File Factures = new File(Path + "FACTURAS.csv");
            Factures.delete();
            try {
                Runtime.getRuntime().exec("cmd /c start " + Path + "Facturas.bat");
            } catch (IOException ex) {}
        } else if(e.getSource() == jBtnConfig){
            JTextField jTxtConfig = new JTextField();
            String Nombre = "", NIT = "", Direccion = "", Telefono = "", Ciudad = "", Resolucion = "", Codigo = "", RangoMin = "", RangoMax = "", Agradecimiento = "", Fecha = "";
            int i = 12, okCxl;
            while (i > 0){
                jTxtConfig.setText("");
                switch (i){
                    case 12:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "NOMBRE DE LA EMPRESA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Nombre = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 11:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "NIT DE LA EMPRESA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            NIT = "NIT:" + jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 10:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "DIRECCIÓN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Direccion = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 9:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "TELÉFONO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Telefono = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 8:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "CIUDAD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Ciudad = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 7:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "RESOLUCIÓN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Resolucion = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 6:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "CÓDIGO DE FACTURAS", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Codigo = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 5:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "MÍNIMO DE FACTURA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            RangoMin = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 4:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "MÁXIMO DE FACTURA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            RangoMax = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 3:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "AGRADECIMIENTO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Agradecimiento = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 2:
                        okCxl = JOptionPane.showConfirmDialog(null, jTxtConfig, "FECHA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if(okCxl == JOptionPane.OK_OPTION){
                            Fecha = jTxtConfig.getText().toUpperCase();
                        } else {
                            i = 0;
                        }
                        i--;
                        break;
                    case 1:
                        try {
                            FileWriter fichero = new FileWriter(Path + Fact);
                            PrintWriter pw = new PrintWriter(fichero);
                            pw.println(Nombre);
                            pw.println(NIT);
                            pw.println(Direccion);
                            pw.println(Telefono);
                            pw.println(Ciudad);
                            pw.println(Resolucion);
                            pw.println(Codigo + "-");
                            pw.println(RangoMin);
                            pw.println(RangoMax);
                            pw.println(Agradecimiento);
                            pw.println("AUTORIZACIÓN DE LA DIAN");
                            pw.println("DE " + Fecha + ". RANGO: " + Codigo + "- DESDE");
                            pw.println("HASTA ");
                            fichero.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i--;
                        break;    
                }
            }
            JOptionPane.showMessageDialog(null, "El POS se cerrara para completar la tarea", "Cerrando", JOptionPane.INFORMATION_MESSAGE, Icono);
            System.exit(0);
        }
    }
}
