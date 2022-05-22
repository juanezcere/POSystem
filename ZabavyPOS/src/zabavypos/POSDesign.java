package zabavypos;

/**
 *
 * @author Juanez
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class POSDesign implements ActionListener{

    JFrame jFrmPOS;
    JButton jBtnAddB, jBtnAddT, jBtnAceptar, jBtnColorB, jBtnColorL, jBtnCambiarImg;
    JLabel jLblCompany, jLblNombre, jLblProducto, jLblColorB, jLblColorL;
    JTextField jTxtNombre;
    JComboBox jCmbProductos;
    ResultSet RS;
    JPanel jPProd0, jPProd1, jPProd2, jPProd3, jPProd4, jPProd5, jPProd6, jPProd7, jPProd8, jPProd9, jPProd10, jPProd11, jPProd12, jPProd13, jPProd14, jPProd15;
    JTabbedPane jTabProductos;
    int Tabs = 0, Btns = 0, TabP = 0, evt = 0;
    InputStream Input, InputImagen;
    JButton jBtnProd0, jBtnProd1, jBtnProd2, jBtnProd3, jBtnProd4, jBtnProd5, jBtnProd6, jBtnProd7, jBtnProd8, jBtnProd9, jBtnProd10, jBtnProd11, jBtnProd12, jBtnProd13, jBtnProd14, jBtnProd15, jBtnProd16, jBtnProd17, jBtnProd18, jBtnProd19, jBtnProd20, jBtnProd21, jBtnProd22, jBtnProd23, jBtnProd24, jBtnProd25, jBtnProd26, jBtnProd27, jBtnProd28, jBtnProd29, jBtnProd30, jBtnProd31, jBtnProd32, jBtnProd33, jBtnProd34, jBtnProd35, jBtnProd36, jBtnProd37, jBtnProd38, jBtnProd39, jBtnProd40, jBtnProd41, jBtnProd42, jBtnProd43, jBtnProd44, jBtnProd45, jBtnProd46, jBtnProd47, jBtnProd48, jBtnProd49, jBtnProd50, jBtnProd51, jBtnProd52, jBtnProd53, jBtnProd54, jBtnProd55, jBtnProd56, jBtnProd57, jBtnProd58, jBtnProd59, jBtnProd60, jBtnProd61, jBtnProd62, jBtnProd63, jBtnProd64, jBtnProd65;
    int x, y;
    ImageIcon Icono;
    String User = null, Pass = null, Host = null, Base = null, Lengua = "", Path = "";
    Icon Icon;
    ZabavyDB DB = new ZabavyDB();
    Color ColB, ColL;
    boolean[] HabilBtn = new boolean[66];
    
    @SuppressWarnings({"LeakingThisInConstructor", "null"})
    public POSDesign(){
        jFrmPOS = new JFrame("Zabavy POS Design 0.9");
        jFrmPOS.setLayout(null);
        jTabProductos = new JTabbedPane();
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
            BR.readLine();
            BR.readLine();
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = (int) screenSize.getWidth();
        y = (int) screenSize.getHeight();
        File Lenguaje = new File(Path + Lengua);
        try (FileReader FR = new FileReader(Lenguaje); BufferedReader BR = new BufferedReader(FR)) {
            BR.readLine();
            jLblNombre = new JLabel(BR.readLine());
            jLblProducto = new JLabel(BR.readLine());
            jLblColorB = new JLabel(BR.readLine());
            jLblColorL = new JLabel(BR.readLine());
            jBtnAddB = new JButton();
            jBtnAddT = new JButton();
            jBtnAceptar = new JButton();
            jBtnAddB.setToolTipText(BR.readLine());
            jBtnAddT.setToolTipText(BR.readLine());
            jBtnAceptar.setToolTipText(BR.readLine());
            jLblCompany = new JLabel();
            jBtnCambiarImg = new JButton();
            jBtnCambiarImg.setToolTipText(BR.readLine());
            jBtnColorL = new JButton();
            jBtnColorB = new JButton();
            jBtnColorL.setToolTipText(BR.readLine());
            jBtnColorB.setToolTipText(jBtnColorL.getToolTipText());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        jBtnAddT.setBounds(20, ((y / 2) + 20), 50, 50);
        jBtnAddT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "AddTab.zabavy");
        jBtnAddT.setIcon(Icono);
        jBtnAddT.setFocusable(false);
        jBtnAddT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAddT.addActionListener(this);
        jBtnAddT.setVisible(true);
        jBtnAddB.setBounds(80, ((y / 2) + 20), 50, 50);
        jBtnAddB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "AddBtn.zabavy");
        jBtnAddB.setIcon(Icono);
        jBtnAddB.setFocusable(false);
        jBtnAddB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAddB.addActionListener(this);
        jBtnAddB.setVisible(true);
        jBtnAceptar.setBounds(150, ((y / 2) + 20), 50, 50);
        jBtnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Aceptar.zabavy");
        jBtnAceptar.setIcon(Icono);
        jBtnAceptar.setFocusable(false);
        jBtnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAceptar.setBackground(Color.GREEN);
        jBtnAceptar.setForeground(Color.WHITE);
        jBtnAceptar.addActionListener(this);
        jBtnAceptar.setVisible(true);
        jLblCompany = new JLabel();
        jLblCompany.setBounds((x - 210), 10, 200, 200);
        jLblCompany.setFont(new Font("VERDANA", Font.PLAIN, 20));
        Icono = new ImageIcon(Path + "Company.zabavy");
        Icon = new ImageIcon(Icono.getImage().getScaledInstance(jLblCompany.getWidth(), jLblCompany.getHeight(), Image.SCALE_DEFAULT));
        jLblCompany.setIcon(Icon);
        jLblCompany.setVisible(true);
        jBtnCambiarImg.setBounds((x - 125), 220, 50, 50);
        jBtnCambiarImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Cambiar.zabavy");
        jBtnCambiarImg.setIcon(Icono);
        jBtnCambiarImg.setFocusable(false);
        jBtnCambiarImg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnCambiarImg.addActionListener(this);
        jBtnCambiarImg.setVisible(true);
        jLblNombre.setBounds(220, ((y / 2) + 20), 300, 50);
        jLblNombre.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jLblNombre.setVisible(true);
        jLblProducto.setBounds(220, ((y / 2) + 80), 300, 50);
        jLblProducto.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jLblProducto.setVisible(true);
        jLblColorB.setBounds(220, ((y / 2) + 140), 300, 50);
        jLblColorB.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jLblColorB.setVisible(true);
        jBtnColorB.setBounds(530, ((y / 2) + 140), 50, 50);
        jBtnColorB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Color.zabavy");
        jBtnColorB.setIcon(Icono);
        jBtnColorB.setFocusable(false);
        jBtnColorB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnColorB.addActionListener(this);
        jBtnColorB.setVisible(true);
        jLblColorL.setBounds(220, ((y / 2) + 200), 300, 50);
        jLblColorL.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jLblColorL.setVisible(true);
        jBtnColorL.setBounds(530, ((y / 2) + 200), 50, 50);
        jBtnColorL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Icono  =  new ImageIcon(Path + "Color.zabavy");
        jBtnColorL.setIcon(Icono);
        jBtnColorL.setFocusable(false);
        jBtnColorL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnColorL.addActionListener(this);
        jBtnColorL.setVisible(true);
        jTxtNombre = new JTextField();
        jTxtNombre.setBounds(530, ((y / 2) + 20), 300, 50);
        jTxtNombre.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jTxtNombre.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jTxtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtNombre.setVisible(true);
        jCmbProductos = new JComboBox();
        jCmbProductos.setBounds(530, ((y / 2) + 80), 300, 50);
        jCmbProductos.setFont(new Font("VERDANA", Font.PLAIN, 20));
        jCmbProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCmbProductos.setVisible(true);
        jFrmPOS.add(jBtnAddT);
        jFrmPOS.add(jBtnAddB);
        jFrmPOS.add(jBtnAceptar);
        jFrmPOS.add(jLblNombre);
        jFrmPOS.add(jLblProducto);
        jFrmPOS.add(jLblColorB);
        jFrmPOS.add(jLblColorL);
        jFrmPOS.add(jBtnColorB);
        jFrmPOS.add(jBtnColorL);
        jFrmPOS.add(jTxtNombre);
        jFrmPOS.add(jCmbProductos);
        jFrmPOS.add(jLblCompany);
        jFrmPOS.add(jBtnCambiarImg);
        Icono  =  new ImageIcon(Path + "Error.zabavy");
        for(int i = 0; i <= 15; i++){
            switch (i){
                case 0:
                    jPProd0 = new JPanel();
                    jPProd0.setLayout(null);
                    jPProd0.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 1;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd0);
                                jTxtNombre.setText("");
                                TabP = 1;
                            }
                        }
                    });
                    break;
                case 1:
                    jPProd1 = new JPanel();
                    jPProd1.setLayout(null);
                    jPProd1.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 2;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd1);
                                jTxtNombre.setText("");
                                TabP = 2;
                            }
                        }
                    });
                    break;
                case 2:
                    jPProd2 = new JPanel();
                    jPProd2.setLayout(null);
                    jPProd2.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 3;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd2);
                                jTxtNombre.setText("");
                                TabP = 3;
                            }
                        }
                    });
                    break;
                case 3:
                    jPProd3 = new JPanel();
                    jPProd3.setLayout(null);
                    jPProd3.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 4;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd3);
                                jTxtNombre.setText("");
                                TabP = 4;
                            }
                        }
                    });
                    break;
                case 4:
                    jPProd4 = new JPanel();
                    jPProd4.setLayout(null);
                    jPProd4.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 5;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd4);
                                jTxtNombre.setText("");
                                TabP = 5;
                            }
                        }
                    });
                    break;
                case 5:
                    jPProd5 = new JPanel();
                    jPProd5.setLayout(null);
                    jPProd5.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 6;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd5);
                                jTxtNombre.setText("");
                                TabP = 6;
                            }
                        }
                    });
                    break;
                case 6:
                    jPProd6 = new JPanel();
                    jPProd6.setLayout(null);
                    jPProd6.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 7;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd6);
                                jTxtNombre.setText("");
                                TabP = 7;
                            }
                        }
                    });
                    break;
                case 7:
                    jPProd7 = new JPanel();
                    jPProd7.setLayout(null);
                    jPProd7.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 8;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd7);
                                jTxtNombre.setText("");
                                TabP = 8;
                            }
                        }
                    });
                    break;
                case 8:
                    jPProd8 = new JPanel();
                    jPProd8.setLayout(null);
                    jPProd8.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 9;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd8);
                                jTxtNombre.setText("");
                                TabP = 9;
                            }
                        }
                    });
                    break;
                case 9:
                    jPProd9 = new JPanel();
                    jPProd9.setLayout(null);
                    jPProd9.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 10;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd9);
                                jTxtNombre.setText("");
                                TabP = 10;
                            }
                        }
                    });
                    break;
                case 10:
                    jPProd10 = new JPanel();
                    jPProd10.setLayout(null);
                    jPProd10.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 11;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd10);
                                jTxtNombre.setText("");
                                TabP = 11;
                            }
                        }
                    });
                    break;
                case 11:
                    jPProd11 = new JPanel();
                    jPProd11.setLayout(null);
                    jPProd11.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 12;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd11);
                                jTxtNombre.setText("");
                                TabP = 12;
                            }
                        }
                    });
                    break;
                case 12:
                    jPProd12 = new JPanel();
                    jPProd12.setLayout(null);
                    jPProd12.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 13;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd12);
                                jTxtNombre.setText("");
                                TabP = 13;
                            }
                        }
                    });
                    break;
                case 13:
                    jPProd13 = new JPanel();
                    jPProd13.setLayout(null);
                    jPProd13.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 14;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd13);
                                jTxtNombre.setText("");
                                TabP = 14;
                            }
                        }
                    });
                    break;
                case 14:
                    jPProd14 = new JPanel();
                    jPProd14.setLayout(null);
                    jPProd14.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 15;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd14);
                                jTxtNombre.setText("");
                                TabP = 15;
                            }
                        }
                    });
                    break;
                case 15:
                    jPProd15 = new JPanel();
                    jPProd15.setLayout(null);
                    jPProd15.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                TabP = 16;
                                jTxtNombre.setText(jTabProductos.getTitleAt(TabP - 1));
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jTabProductos.remove(jPProd15);
                                jTxtNombre.setText("");
                                TabP = 16;
                            }
                        }
                    });
                    break;
            }
        }
        for(int i = 0; i <= 65; i++){
            switch(i){
                case 0:
                    jBtnProd0 = new JButton();
                    jBtnProd0.setVisible(false);
                    jBtnProd0.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd0.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd0.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd0.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd0.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd0.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd0.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 1:
                    jBtnProd1 = new JButton();
                    jBtnProd1.setVisible(false);
                    jBtnProd1.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd1.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd1.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd1.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd1.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd1.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd1.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 2:
                    jBtnProd2 = new JButton();
                    jBtnProd2.setVisible(false);
                    jBtnProd2.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd2.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd2.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd2.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd2.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd2.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd2.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 3:
                    jBtnProd3 = new JButton();
                    jBtnProd3.setVisible(false);
                    jBtnProd3.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd3.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd3.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd3.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd3.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd3.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd3.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 4:
                    jBtnProd4 = new JButton();
                    jBtnProd4.setVisible(false);
                    jBtnProd4.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd4.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd4.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd4.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd4.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd4.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd4.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 5:
                    jBtnProd5 = new JButton();
                    jBtnProd5.setVisible(false);
                    jBtnProd5.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd5.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd5.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd5.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd5.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd5.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd5.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 6:
                    jBtnProd6 = new JButton();
                    jBtnProd6.setVisible(false);
                    jBtnProd6.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd6.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd6.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd6.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd6.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd6.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd6.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 7:
                    jBtnProd7 = new JButton();
                    jBtnProd7.setVisible(false);
                    jBtnProd7.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd7.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd7.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd7.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd7.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd7.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd7.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 8:
                    jBtnProd8 = new JButton();
                    jBtnProd8.setVisible(false);
                    jBtnProd8.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd8.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd8.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd8.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd8.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd8.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd8.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 9:
                    jBtnProd9 = new JButton();
                    jBtnProd9.setVisible(false);
                    jBtnProd9.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd9.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd9.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd9.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd9.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd9.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd9.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 10:
                    jBtnProd10 = new JButton();
                    jBtnProd10.setVisible(false);
                    jBtnProd10.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd10.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd10.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd10.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd10.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd10.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd10.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 11:
                    jBtnProd11 = new JButton();
                    jBtnProd11.setVisible(false);
                    jBtnProd11.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd11.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd11.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd11.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd11.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd11.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd11.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 12:
                    jBtnProd12 = new JButton();
                    jBtnProd12.setVisible(false);
                    jBtnProd12.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd12.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd12.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd12.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd12.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd12.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd12.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 13:
                    jBtnProd13 = new JButton();
                    jBtnProd13.setVisible(false);
                    jBtnProd13.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd13.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd13.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd13.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd13.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd13.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd13.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 14:
                    jBtnProd14 = new JButton();
                    jBtnProd14.setVisible(false);
                    jBtnProd14.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd14.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd14.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd14.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd14.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd14.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd14.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 15:
                    jBtnProd15 = new JButton();
                    jBtnProd15.setVisible(false);
                    jBtnProd15.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd15.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd15.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd15.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd15.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd15.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd15.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 16:
                    jBtnProd16 = new JButton();
                    jBtnProd16.setVisible(false);
                    jBtnProd16.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd16.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd16.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd16.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd16.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd16.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd16.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 17:
                    jBtnProd17 = new JButton();
                    jBtnProd17.setVisible(false);
                    jBtnProd17.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd17.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd17.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd17.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd17.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd17.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd17.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 18:
                    jBtnProd18 = new JButton();
                    jBtnProd18.setVisible(false);
                    jBtnProd18.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd18.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd18.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd18.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd18.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd18.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd18.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 19:
                    jBtnProd19 = new JButton();
                    jBtnProd19.setVisible(false);
                    jBtnProd19.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd19.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd19.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd19.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd19.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd19.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd19.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 20:
                    jBtnProd20 = new JButton();
                    jBtnProd20.setVisible(false);
                    jBtnProd20.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd20.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd20.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd20.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd20.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd20.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd20.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 21:
                    jBtnProd21 = new JButton();
                    jBtnProd21.setVisible(false);
                    jBtnProd21.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd21.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd21.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd21.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd21.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd21.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd21.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 22:
                    jBtnProd22 = new JButton();
                    jBtnProd22.setVisible(false);
                    jBtnProd22.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd22.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd22.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd22.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd22.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd22.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd22.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 23:
                    jBtnProd23 = new JButton();
                    jBtnProd23.setVisible(false);
                    jBtnProd23.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd23.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd23.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd23.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd23.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd23.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd23.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 24:
                    jBtnProd24 = new JButton();
                    jBtnProd24.setVisible(false);
                    jBtnProd24.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd24.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd24.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd24.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd24.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd24.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd24.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 25:
                    jBtnProd25 = new JButton();
                    jBtnProd25.setVisible(false);
                    jBtnProd25.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd25.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd25.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd25.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd25.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd25.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd25.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 26:
                    jBtnProd26 = new JButton();
                    jBtnProd26.setVisible(false);
                    jBtnProd26.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd26.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd26.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd26.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd26.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd26.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd26.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 27:
                    jBtnProd27 = new JButton();
                    jBtnProd27.setVisible(false);
                    jBtnProd27.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd27.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd27.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd27.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd27.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd27.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd27.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 28:
                    jBtnProd28 = new JButton();
                    jBtnProd28.setVisible(false);
                    jBtnProd28.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd28.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd28.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd28.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd28.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd28.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd28.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 29:
                    jBtnProd29 = new JButton();
                    jBtnProd29.setVisible(false);
                    jBtnProd29.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd29.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd29.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd29.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd29.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd29.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd29.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 30:
                    jBtnProd30 = new JButton();
                    jBtnProd30.setVisible(false);
                    jBtnProd30.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd30.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd30.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd30.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd30.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd30.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd30.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 31:
                    jBtnProd31 = new JButton();
                    jBtnProd31.setVisible(false);
                    jBtnProd31.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd31.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd31.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd31.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd31.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd31.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd31.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 32:
                    jBtnProd32 = new JButton();
                    jBtnProd32.setVisible(false);
                    jBtnProd32.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd32.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd32.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd32.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd32.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd32.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd32.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 33:
                    jBtnProd33 = new JButton();
                    jBtnProd33.setVisible(false);
                    jBtnProd33.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd33.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd33.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd33.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd33.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd33.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd33.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 34:
                    jBtnProd34 = new JButton();
                    jBtnProd34.setVisible(false);
                    jBtnProd34.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd34.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd34.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd34.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd34.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd34.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd34.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 35:
                    jBtnProd35 = new JButton();
                    jBtnProd35.setVisible(false);
                    jBtnProd35.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd35.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd35.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd35.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd35.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd35.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd35.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 36:
                    jBtnProd36 = new JButton();
                    jBtnProd36.setVisible(false);
                    jBtnProd36.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd36.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd36.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd36.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd36.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd36.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd36.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 37:
                    jBtnProd37 = new JButton();
                    jBtnProd37.setVisible(false);
                    jBtnProd37.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd37.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd37.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd37.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd37.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd37.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd37.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 38:
                    jBtnProd38 = new JButton();
                    jBtnProd38.setVisible(false);
                    jBtnProd38.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd38.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd38.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd38.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd38.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd38.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd38.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 39:
                    jBtnProd39 = new JButton();
                    jBtnProd39.setVisible(false);
                    jBtnProd39.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd39.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd39.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd39.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd39.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd39.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd39.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 40:
                    jBtnProd40 = new JButton();
                    jBtnProd40.setVisible(false);
                    jBtnProd40.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd40.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd40.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd40.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd40.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd40.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd40.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 41:
                    jBtnProd41 = new JButton();
                    jBtnProd41.setVisible(false);
                    jBtnProd41.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd41.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd41.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd41.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd41.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd41.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd41.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 42:
                    jBtnProd42 = new JButton();
                    jBtnProd42.setVisible(false);
                    jBtnProd42.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd42.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd42.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd42.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd42.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd42.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd42.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 43:
                    jBtnProd43 = new JButton();
                    jBtnProd43.setVisible(false);
                    jBtnProd43.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd43.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd43.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd43.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd43.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd43.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd43.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 44:
                    jBtnProd44 = new JButton();
                    jBtnProd44.setVisible(false);
                    jBtnProd44.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd44.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd44.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd44.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd44.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd44.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd44.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 45:
                    jBtnProd45 = new JButton();
                    jBtnProd45.setVisible(false);
                    jBtnProd45.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd45.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd45.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd45.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd45.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd45.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd45.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 46:
                    jBtnProd46 = new JButton();
                    jBtnProd46.setVisible(false);
                    jBtnProd46.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd46.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd46.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd46.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd46.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd46.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd46.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 47:
                    jBtnProd47 = new JButton();
                    jBtnProd47.setVisible(false);
                    jBtnProd47.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd47.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd47.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd47.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd47.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd47.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd47.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 48:
                    jBtnProd48 = new JButton();
                    jBtnProd48.setVisible(false);
                    jBtnProd48.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd48.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd48.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd48.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd48.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd48.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd48.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 49:
                    jBtnProd49 = new JButton();
                    jBtnProd49.setVisible(false);
                    jBtnProd49.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd49.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd49.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd49.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd49.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd49.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd49.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 50:
                    jBtnProd50 = new JButton();
                    jBtnProd50.setVisible(false);
                    jBtnProd50.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd50.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd50.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd50.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd50.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd50.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd50.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 51:
                    jBtnProd51 = new JButton();
                    jBtnProd51.setVisible(false);
                    jBtnProd51.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd51.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd51.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd51.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd51.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd51.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd51.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 52:
                    jBtnProd52 = new JButton();
                    jBtnProd52.setVisible(false);
                    jBtnProd52.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd52.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd52.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd52.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd52.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd52.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd52.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 53:
                    jBtnProd53 = new JButton();
                    jBtnProd53.setVisible(false);
                    jBtnProd53.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd53.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd53.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd53.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd53.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd53.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd53.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 54:
                    jBtnProd54 = new JButton();
                    jBtnProd54.setVisible(false);
                    jBtnProd54.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd54.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd54.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd54.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd54.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd54.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd54.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 55:
                    jBtnProd55 = new JButton();
                    jBtnProd55.setVisible(false);
                    jBtnProd55.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd55.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd55.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd55.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd55.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd55.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd55.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 56:
                    jBtnProd56 = new JButton();
                    jBtnProd56.setVisible(false);
                    jBtnProd56.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd56.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd56.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd56.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd56.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd56.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd56.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 57:
                    jBtnProd57 = new JButton();
                    jBtnProd57.setVisible(false);
                    jBtnProd57.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd57.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd57.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd57.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd57.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd57.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd57.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 58:
                    jBtnProd58 = new JButton();
                    jBtnProd58.setVisible(false);
                    jBtnProd58.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd58.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd58.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd58.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd58.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd58.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd58.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 59:
                    jBtnProd59 = new JButton();
                    jBtnProd59.setVisible(false);
                    jBtnProd59.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd59.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd59.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd59.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd59.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd59.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd59.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 60:
                    jBtnProd60 = new JButton();
                    jBtnProd60.setVisible(false);
                    jBtnProd60.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd60.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd60.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd60.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd60.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd60.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd60.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 61:
                    jBtnProd61 = new JButton();
                    jBtnProd61.setVisible(false);
                    jBtnProd61.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd61.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd61.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd61.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd61.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd61.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd61.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 62:
                    jBtnProd62 = new JButton();
                    jBtnProd62.setVisible(false);
                    jBtnProd62.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd62.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd62.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd62.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd62.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd62.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd62.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 63:
                    jBtnProd63 = new JButton();
                    jBtnProd63.setVisible(false);
                    jBtnProd63.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd63.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd63.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd63.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd63.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd63.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd63.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 64:
                    jBtnProd64 = new JButton();
                    jBtnProd64.setVisible(false);
                    jBtnProd64.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd64.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd64.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd64.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd64.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd64.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd64.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
                case 65:
                    jBtnProd65 = new JButton();
                    jBtnProd65.setVisible(false);
                    jBtnProd65.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
                                jTxtNombre.setText(jBtnProd65.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 1;
                            } else if(e.getButton() == MouseEvent.BUTTON2){
                                jBtnProd65.setVisible(false);
                                jTxtNombre.setText("");
                                jCmbProductos.setEnabled(true);
                            } else if(e.getButton() == MouseEvent.BUTTON3){
                                jTxtNombre.setText(jBtnProd65.getText().toUpperCase());
                                jCmbProductos.setEnabled(true);
                                evt = 2;
                            }
                        }
                    });
                    jBtnProd65.addMouseMotionListener(new MouseMotionAdapter(){
                        @Override
                        public void mouseDragged(MouseEvent e){
                            if(evt == 1){
                                jBtnProd65.setLocation(e.getXOnScreen(), e.getYOnScreen() - 50);
                            } else if(evt == 2){
                                jBtnProd65.setSize(e.getX(), e.getY());
                            }
                        }
                    });
                    break;
            }
        }
        DB.Conection(Host, Base, User, Pass);
        try{
            RS = DB.Select("SELECT NomProd FROM PRODUCTOS;");
            while(RS.next()){
                jCmbProductos.addItem(RS.getString("NomProd"));
            }
        } catch (SQLException e){}
        try{
            RS = DB.Select("SELECT * FROM TABPDV;");
            int Registros = 0;
            while(RS.next()){
                Registros++;
            }
            Tabs = Registros;
            RS.first();
            jTabProductos.setBounds(0, 0, x - 250, ((y / 2) - 10));
            jTabProductos.setVisible(true);
            int i = 1;
            while(i <= Registros){
                switch(i){
                    case 1:
                        jTabProductos.add(RS.getString("Texto"), jPProd0);
                        jPProd0.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 2:
                        jTabProductos.add(RS.getString("Texto"), jPProd1);
                        jPProd1.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 3:
                        jTabProductos.add(RS.getString("Texto"), jPProd2);
                        jPProd2.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 4:
                        jTabProductos.add(RS.getString("Texto"), jPProd3);
                        jPProd3.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 5:
                        jTabProductos.add(RS.getString("Texto"), jPProd4);
                        jPProd4.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 6:
                        jTabProductos.add(RS.getString("Texto"), jPProd5);
                        jPProd5.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 7:
                        jTabProductos.add(RS.getString("Texto"), jPProd6);
                        jPProd6.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 8:
                        jTabProductos.add(RS.getString("Texto"), jPProd7);
                        jPProd7.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 9:
                        jTabProductos.add(RS.getString("Texto"), jPProd8);
                        jPProd8.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 10:
                        jTabProductos.add(RS.getString("Texto"), jPProd9);
                        jPProd9.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 11:
                        jTabProductos.add(RS.getString("Texto"), jPProd10);
                        jPProd10.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 12:
                        jTabProductos.add(RS.getString("Texto"), jPProd11);
                        jPProd11.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 13:
                        jTabProductos.add(RS.getString("Texto"), jPProd12);
                        jPProd12.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 14:
                        jTabProductos.add(RS.getString("Texto"), jPProd13);
                        jPProd13.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 15:
                        jTabProductos.add(RS.getString("Texto"), jPProd14);
                        jPProd14.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                    case 16:
                        jTabProductos.add(RS.getString("Texto"), jPProd15);
                        jPProd15.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        break;
                }
                i++;
                RS.next();
            }
            DB.Delete("DELETE FROM TabPDV;");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            System.exit(0);
        }
        try{
            RS = DB.Select("SELECT * FROM PDV;");
            int Registros = 0;
            while(RS.next()){
                Registros++;
            }
            Btns = Registros;
            RS.first();
            int i = 1;
            while(i <= Registros){
                HabilBtn[i - 1] = true;
                switch(i){
                    case 1:
                        jBtnProd0.setText(RS.getString("Texto"));
                        jBtnProd0.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd0.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd0.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd0.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd0.setIcon(Icono);
                        }
                        jBtnProd0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd0);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd0);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd0);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd0);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd0);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd0);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd0);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd0);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd0);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd0);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd0);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd0);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd0);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd0);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd0);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd0);
                                break;
                        }
                        jBtnProd0.setVisible(true);
                        break;
                    case 2:
                        jBtnProd1.setText(RS.getString("Texto"));
                        jBtnProd1.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd1.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd1.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd1.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd1.setIcon(Icono);
                        }
                        jBtnProd1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd1);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd1);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd1);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd1);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd1);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd1);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd1);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd1);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd1);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd1);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd1);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd1);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd1);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd1);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd1);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd1);
                                break;
                        }
                        jBtnProd1.setVisible(true);
                        break;
                    case 3:
                        jBtnProd2.setText(RS.getString("Texto"));
                        jBtnProd2.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd2.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd2.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd2.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd2.setIcon(Icono);
                        }
                        jBtnProd2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd2);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd2);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd2);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd2);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd2);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd2);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd2);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd2);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd2);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd2);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd2);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd2);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd2);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd2);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd2);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd2);
                                break;
                        }
                        jBtnProd2.setVisible(true);
                        break;
                    case 4:
                        jBtnProd3.setText(RS.getString("Texto"));
                        jBtnProd3.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd3.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd3.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd3.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd3.setIcon(Icono);
                        }
                        jBtnProd3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd3);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd3);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd3);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd3);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd3);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd3);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd3);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd3);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd3);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd3);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd3);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd3);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd3);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd3);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd3);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd3);
                                break;
                        }
                        jBtnProd3.setVisible(true);
                        break;
                    case 5:
                        jBtnProd4.setText(RS.getString("Texto"));
                        jBtnProd4.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd4.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd4.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd4.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd4.setIcon(Icono);
                        }
                        jBtnProd4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd4);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd4);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd4);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd4);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd4);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd4);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd4);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd4);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd4);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd4);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd4);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd4);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd4);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd4);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd4);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd4);
                                break;
                        }
                        jBtnProd4.setVisible(true);
                        break;
                    case 6:
                        jBtnProd5.setText(RS.getString("Texto"));
                        jBtnProd5.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd5.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd5.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd5.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd5.setIcon(Icono);
                        }
                        jBtnProd5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd5);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd5);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd5);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd5);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd5);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd5);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd5);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd5);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd5);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd5);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd5);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd5);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd5);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd5);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd5);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd5);
                                break;
                        }
                        jBtnProd5.setVisible(true);
                        break;
                    case 7:
                        jBtnProd6.setText(RS.getString("Texto"));
                        jBtnProd6.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd6.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd6.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd6.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd6.setIcon(Icono);
                        }
                        jBtnProd6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd6);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd6);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd6);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd6);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd6);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd6);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd6);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd6);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd6);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd6);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd6);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd6);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd6);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd6);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd6);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd6);
                                break;
                        }
                        jBtnProd6.setVisible(true);
                        break;
                    case 8:
                        jBtnProd7.setText(RS.getString("Texto"));
                        jBtnProd7.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd7.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd7.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd7.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd7.setIcon(Icono);
                        }
                        jBtnProd7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd7);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd7);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd7);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd7);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd7);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd7);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd7);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd7);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd7);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd7);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd7);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd7);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd7);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd7);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd7);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd7);
                                break;
                        }
                        jBtnProd7.setVisible(true);
                        break;
                    case 9:
                        jBtnProd8.setText(RS.getString("Texto"));
                        jBtnProd8.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd8.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd8.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd8.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd8.setIcon(Icono);
                        }
                        jBtnProd8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd8);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd8);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd8);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd8);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd8);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd8);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd8);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd8);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd8);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd8);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd8);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd8);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd8);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd8);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd8);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd8);
                                break;
                        }
                        jBtnProd8.setVisible(true);
                        break;
                    case 10:
                        jBtnProd9.setText(RS.getString("Texto"));
                        jBtnProd9.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd9.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd9.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd9.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd9.setIcon(Icono);
                        }
                        jBtnProd9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd9);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd9);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd9);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd9);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd9);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd9);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd9);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd9);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd9);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd9);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd9);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd9);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd9);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd9);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd9);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd9);
                                break;
                        }
                        jBtnProd9.setVisible(true);
                        break;
                    case 11:
                        jBtnProd10.setText(RS.getString("Texto"));
                        jBtnProd10.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd10.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd10.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd10.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd10.setIcon(Icono);
                        }
                        jBtnProd10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd10);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd10);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd10);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd10);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd10);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd10);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd10);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd10);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd10);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd10);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd10);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd10);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd10);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd10);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd10);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd10);
                                break;
                        }
                        jBtnProd10.setVisible(true);
                        break;
                    case 12:
                        jBtnProd11.setText(RS.getString("Texto"));
                        jBtnProd11.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd11.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd11.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd11.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd11.setIcon(Icono);
                        }
                        jBtnProd11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd11);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd11);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd11);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd11);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd11);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd11);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd11);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd11);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd11);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd11);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd11);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd11);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd11);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd11);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd11);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd11);
                                break;
                        }
                        jBtnProd11.setVisible(true);
                        break;
                    case 13:
                        jBtnProd12.setText(RS.getString("Texto"));
                        jBtnProd12.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd12.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd12.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd12.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd12.setIcon(Icono);
                        }
                        jBtnProd12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd12);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd12);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd12);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd12);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd12);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd12);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd12);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd12);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd12);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd12);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd12);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd12);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd12);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd12);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd12);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd12);
                                break;
                        }
                        jBtnProd12.setVisible(true);
                        break;
                    case 14:
                        jBtnProd13.setText(RS.getString("Texto"));
                        jBtnProd13.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd13.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd13.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd13.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd13.setIcon(Icono);
                        }
                        jBtnProd13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd13);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd13);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd13);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd13);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd13);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd13);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd13);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd13);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd13);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd13);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd13);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd13);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd13);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd13);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd13);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd13);
                                break;
                        }
                        jBtnProd13.setVisible(true);
                        break;
                    case 15:
                        jBtnProd14.setText(RS.getString("Texto"));
                        jBtnProd14.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd14.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd14.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd14.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd14.setIcon(Icono);
                        }
                        jBtnProd14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd14);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd14);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd14);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd14);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd14);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd14);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd14);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd14);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd14);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd14);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd14);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd14);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd14);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd14);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd14);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd14);
                                break;
                        }
                        jBtnProd14.setVisible(true);
                        break;
                    case 16:
                        jBtnProd15.setText(RS.getString("Texto"));
                        jBtnProd15.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd15.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd15.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd15.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd15.setIcon(Icono);
                        }
                        jBtnProd15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd15);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd15);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd15);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd15);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd15);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd15);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd15);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd15);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd15);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd15);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd15);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd15);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd15);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd15);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd15);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd15);
                                break;
                        }
                        jBtnProd15.setVisible(true);
                        break;
                    case 17:
                        jBtnProd16.setText(RS.getString("Texto"));
                        jBtnProd16.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd16.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd16.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd16.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd16.setIcon(Icono);
                        }
                        jBtnProd16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd16);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd16);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd16);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd16);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd16);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd16);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd16);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd16);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd16);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd16);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd16);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd16);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd16);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd16);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd16);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd16);
                                break;
                        }
                        jBtnProd16.setVisible(true);
                        break;
                    case 18:
                        jBtnProd17.setText(RS.getString("Texto"));
                        jBtnProd17.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd17.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd17.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd17.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd17.setIcon(Icono);
                        }
                        jBtnProd17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd17);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd17);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd17);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd17);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd17);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd17);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd17);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd17);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd17);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd17);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd17);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd17);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd17);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd17);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd17);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd17);
                                break;
                        }
                        jBtnProd17.setVisible(true);
                        break;
                    case 19:
                        jBtnProd18.setText(RS.getString("Texto"));
                        jBtnProd18.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd18.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd18.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd18.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd18.setIcon(Icono);
                        }
                        jBtnProd18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd18);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd18);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd18);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd18);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd18);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd18);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd18);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd18);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd18);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd18);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd18);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd18);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd18);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd18);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd18);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd18);
                                break;
                        }
                        jBtnProd18.setVisible(true);
                        break;
                    case 20:
                        jBtnProd19.setText(RS.getString("Texto"));
                        jBtnProd19.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd19.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd19.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd19.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd19.setIcon(Icono);
                        }
                        jBtnProd19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd19);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd19);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd19);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd19);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd19);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd19);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd19);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd19);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd19);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd19);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd19);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd19);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd19);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd19);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd19);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd19);
                                break;
                        }
                        jBtnProd19.setVisible(true);
                        break;
                    case 21:
                        jBtnProd20.setText(RS.getString("Texto"));
                        jBtnProd20.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd20.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd20.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd20.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd20.setIcon(Icono);
                        }
                        jBtnProd20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd20);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd20);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd20);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd20);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd20);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd20);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd20);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd20);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd20);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd20);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd20);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd20);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd20);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd20);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd20);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd20);
                                break;
                        }
                        jBtnProd20.setVisible(true);
                        break;
                    case 22:
                        jBtnProd21.setText(RS.getString("Texto"));
                        jBtnProd21.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd21.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd21.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd21.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd21.setIcon(Icono);
                        }
                        jBtnProd21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd21);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd21);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd21);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd21);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd21);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd21);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd21);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd21);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd21);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd21);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd21);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd21);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd21);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd21);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd21);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd21);
                                break;
                        }
                        jBtnProd21.setVisible(true);
                        break;
                    case 23:
                        jBtnProd22.setText(RS.getString("Texto"));
                        jBtnProd22.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd22.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd22.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd22.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd22.setIcon(Icono);
                        }
                        jBtnProd22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd22);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd22);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd22);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd22);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd22);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd22);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd22);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd22);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd22);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd22);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd22);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd22);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd22);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd22);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd22);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd22);
                                break;
                        }
                        jBtnProd22.setVisible(true);
                        break;
                    case 24:
                        jBtnProd23.setText(RS.getString("Texto"));
                        jBtnProd23.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd23.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd23.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd23.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd23.setIcon(Icono);
                        }
                        jBtnProd23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd23);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd23);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd23);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd23);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd23);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd23);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd23);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd23);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd23);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd23);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd23);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd23);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd23);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd23);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd23);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd23);
                                break;
                        }
                        jBtnProd23.setVisible(true);
                        break;
                    case 25:
                        jBtnProd24.setText(RS.getString("Texto"));
                        jBtnProd24.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd24.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd24.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd24.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd24.setIcon(Icono);
                        }
                        jBtnProd24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd24);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd24);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd24);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd24);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd24);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd24);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd24);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd24);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd24);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd24);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd24);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd24);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd24);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd24);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd24);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd24);
                                break;
                        }
                        jBtnProd24.setVisible(true);
                        break;
                    case 26:
                        jBtnProd25.setText(RS.getString("Texto"));
                        jBtnProd25.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd25.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd25.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd25.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd25.setIcon(Icono);
                        }
                        jBtnProd25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd25);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd25);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd25);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd25);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd25);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd25);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd25);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd25);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd25);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd25);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd25);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd25);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd25);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd25);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd25);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd25);
                                break;
                        }
                        jBtnProd25.setVisible(true);
                        break;
                    case 27:
                        jBtnProd26.setText(RS.getString("Texto"));
                        jBtnProd26.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd26.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd26.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd26.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd26.setIcon(Icono);
                        }
                        jBtnProd26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd26);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd26);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd26);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd26);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd26);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd26);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd26);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd26);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd26);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd26);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd26);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd26);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd26);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd26);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd26);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd26);
                                break;
                        }
                        jBtnProd26.setVisible(true);
                        break;
                    case 28:
                        jBtnProd27.setText(RS.getString("Texto"));
                        jBtnProd27.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd27.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd27.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd27.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd27.setIcon(Icono);
                        }
                        jBtnProd27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd27);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd27);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd27);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd27);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd27);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd27);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd27);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd27);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd27);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd27);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd27);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd27);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd27);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd27);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd27);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd27);
                                break;
                        }
                        jBtnProd27.setVisible(true);
                        break;
                    case 29:
                        jBtnProd28.setText(RS.getString("Texto"));
                        jBtnProd28.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd28.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd28.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd28.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd28.setIcon(Icono);
                        }
                        jBtnProd28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd28);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd28);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd28);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd28);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd28);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd28);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd28);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd28);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd28);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd28);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd28);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd28);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd28);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd28);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd28);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd28);
                                break;
                        }
                        jBtnProd28.setVisible(true);
                        break;
                    case 30:
                        jBtnProd29.setText(RS.getString("Texto"));
                        jBtnProd29.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd29.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd29.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd29.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd29.setIcon(Icono);
                        }
                        jBtnProd29.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd29);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd29);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd29);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd29);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd29);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd29);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd29);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd29);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd29);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd29);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd29);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd29);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd29);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd29);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd29);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd29);
                                break;
                        }
                        jBtnProd29.setVisible(true);
                        break;
                    case 31:
                        jBtnProd30.setText(RS.getString("Texto"));
                        jBtnProd30.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd30.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd30.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd30.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd30.setIcon(Icono);
                        }
                        jBtnProd30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd30);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd30);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd30);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd30);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd30);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd30);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd30);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd30);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd30);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd30);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd30);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd30);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd30);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd30);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd30);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd30);
                                break;
                        }
                        jBtnProd30.setVisible(true);
                        break;
                    case 32:
                        jBtnProd31.setText(RS.getString("Texto"));
                        jBtnProd31.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd31.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd31.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd31.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd31.setIcon(Icono);
                        }
                        jBtnProd31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd31);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd31);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd31);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd31);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd31);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd31);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd31);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd31);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd31);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd31);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd31);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd31);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd31);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd31);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd31);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd31);
                                break;
                        }
                        jBtnProd31.setVisible(true);
                        break;
                    case 33:
                        jBtnProd32.setText(RS.getString("Texto"));
                        jBtnProd32.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd32.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd32.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd32.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd32.setIcon(Icono);
                        }
                        jBtnProd32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd32);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd32);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd32);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd32);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd32);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd32);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd32);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd32);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd32);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd32);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd32);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd32);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd32);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd32);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd32);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd32);
                                break;
                        }
                        jBtnProd32.setVisible(true);
                        break;
                    case 34:
                        jBtnProd33.setText(RS.getString("Texto"));
                        jBtnProd33.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd33.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd33.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd33.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd33.setIcon(Icono);
                        }
                        jBtnProd33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd33);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd33);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd33);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd33);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd33);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd33);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd33);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd33);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd33);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd33);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd33);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd33);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd33);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd33);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd33);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd33);
                                break;
                        }
                        jBtnProd33.setVisible(true);
                        break;
                    case 35:
                        jBtnProd34.setText(RS.getString("Texto"));
                        jBtnProd34.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd34.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd34.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd34.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd34.setIcon(Icono);
                        }
                        jBtnProd34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd34);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd34);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd34);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd34);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd34);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd34);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd34);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd34);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd34);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd34);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd34);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd34);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd34);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd34);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd34);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd34);
                                break;
                        }
                        jBtnProd34.setVisible(true);
                        break;
                    case 36:
                        jBtnProd35.setText(RS.getString("Texto"));
                        jBtnProd35.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd35.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd35.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd35.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd35.setIcon(Icono);
                        }
                        jBtnProd35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd35);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd35);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd35);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd35);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd35);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd35);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd35);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd35);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd35);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd35);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd35);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd35);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd35);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd35);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd35);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd35);
                                break;
                        }
                        jBtnProd35.setVisible(true);
                        break;
                    case 37:
                        jBtnProd36.setText(RS.getString("Texto"));
                        jBtnProd36.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd36.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd36.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd36.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd36.setIcon(Icono);
                        }
                        jBtnProd36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd36);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd36);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd36);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd36);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd36);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd36);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd36);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd36);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd36);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd36);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd36);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd36);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd36);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd36);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd36);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd36);
                                break;
                        }
                        jBtnProd36.setVisible(true);
                        break;
                    case 38:
                        jBtnProd37.setText(RS.getString("Texto"));
                        jBtnProd37.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd37.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd37.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd37.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd37.setIcon(Icono);
                        }
                        jBtnProd37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd37);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd37);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd37);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd37);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd37);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd37);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd37);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd37);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd37);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd37);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd37);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd37);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd37);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd37);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd37);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd37);
                                break;
                        }
                        jBtnProd37.setVisible(true);
                        break;
                    case 39:
                        jBtnProd38.setText(RS.getString("Texto"));
                        jBtnProd38.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd38.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd38.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd38.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd38.setIcon(Icono);
                        }
                        jBtnProd38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd38);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd38);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd38);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd38);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd38);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd38);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd38);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd38);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd38);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd38);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd38);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd38);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd38);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd38);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd38);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd38);
                                break;
                        }
                        jBtnProd38.setVisible(true);
                        break;
                    case 40:
                        jBtnProd39.setText(RS.getString("Texto"));
                        jBtnProd39.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd39.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd39.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd39.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd39.setIcon(Icono);
                        }
                        jBtnProd39.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd39);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd39);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd39);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd39);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd39);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd39);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd39);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd39);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd39);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd39);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd39);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd39);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd39);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd39);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd39);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd39);
                                break;
                        }
                        jBtnProd39.setVisible(true);
                        break;
                    case 41:
                        jBtnProd40.setText(RS.getString("Texto"));
                        jBtnProd40.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd40.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd40.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd40.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd40.setIcon(Icono);
                        }
                        jBtnProd40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd40);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd40);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd40);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd40);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd40);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd40);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd40);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd40);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd40);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd40);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd40);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd40);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd40);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd40);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd40);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd40);
                                break;
                        }
                        jBtnProd40.setVisible(true);
                        break;
                    case 42:
                        jBtnProd41.setText(RS.getString("Texto"));
                        jBtnProd41.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd41.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd41.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd41.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd41.setIcon(Icono);
                        }
                        jBtnProd41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd41);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd41);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd41);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd41);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd41);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd41);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd41);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd41);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd41);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd41);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd41);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd41);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd41);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd41);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd41);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd41);
                                break;
                        }
                        jBtnProd41.setVisible(true);
                        break;
                    case 43:
                        jBtnProd42.setText(RS.getString("Texto"));
                        jBtnProd42.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd42.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd42.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd42.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd42.setIcon(Icono);
                        }
                        jBtnProd42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd42);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd42);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd42);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd42);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd42);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd42);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd42);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd42);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd42);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd42);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd42);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd42);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd42);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd42);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd42);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd42);
                                break;
                        }
                        jBtnProd42.setVisible(true);
                        break;
                    case 44:
                        jBtnProd43.setText(RS.getString("Texto"));
                        jBtnProd43.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd43.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd43.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd43.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd43.setIcon(Icono);
                        }
                        jBtnProd43.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd43);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd43);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd43);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd43);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd43);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd43);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd43);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd43);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd43);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd43);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd43);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd43);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd43);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd43);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd43);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd43);
                                break;
                        }
                        jBtnProd43.setVisible(true);
                        break;
                    case 45:
                        jBtnProd44.setText(RS.getString("Texto"));
                        jBtnProd44.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd44.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd44.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd44.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd44.setIcon(Icono);
                        }
                        jBtnProd44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd44);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd44);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd44);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd44);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd44);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd44);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd44);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd44);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd44);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd44);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd44);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd44);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd44);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd44);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd44);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd44);
                                break;
                        }
                        jBtnProd44.setVisible(true);
                        break;
                    case 46:
                        jBtnProd45.setText(RS.getString("Texto"));
                        jBtnProd45.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd45.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd45.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd45.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd45.setIcon(Icono);
                        }
                        jBtnProd45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd45);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd45);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd45);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd45);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd45);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd45);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd45);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd45);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd45);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd45);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd45);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd45);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd45);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd45);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd45);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd45);
                                break;
                        }
                        jBtnProd45.setVisible(true);
                        break;
                    case 47:
                        jBtnProd46.setText(RS.getString("Texto"));
                        jBtnProd46.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd46.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd46.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd46.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd46.setIcon(Icono);
                        }
                        jBtnProd46.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd46);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd46);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd46);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd46);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd46);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd46);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd46);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd46);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd46);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd46);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd46);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd46);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd46);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd46);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd46);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd46);
                                break;
                        }
                        jBtnProd46.setVisible(true);
                        break;
                    case 48:
                        jBtnProd47.setText(RS.getString("Texto"));
                        jBtnProd47.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd47.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd47.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd47.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd47.setIcon(Icono);
                        }
                        jBtnProd47.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd47);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd47);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd47);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd47);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd47);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd47);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd47);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd47);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd47);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd47);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd47);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd47);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd47);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd47);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd47);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd47);
                                break;
                        }
                        jBtnProd47.setVisible(true);
                        break;
                    case 49:
                        jBtnProd48.setText(RS.getString("Texto"));
                        jBtnProd48.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd48.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd48.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd48.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd48.setIcon(Icono);
                        }
                        jBtnProd48.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd48);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd48);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd48);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd48);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd48);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd48);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd48);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd48);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd48);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd48);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd48);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd48);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd48);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd48);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd48);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd48);
                                break;
                        }
                        jBtnProd48.setVisible(true);
                        break;
                    case 50:
                        jBtnProd49.setText(RS.getString("Texto"));
                        jBtnProd49.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd49.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd49.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd49.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd49.setIcon(Icono);
                        }
                        jBtnProd49.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd49);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd49);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd49);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd49);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd49);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd49);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd49);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd49);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd49);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd49);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd49);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd49);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd49);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd49);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd49);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd49);
                                break;
                        }
                        jBtnProd49.setVisible(true);
                        break;
                    case 51:
                        jBtnProd50.setText(RS.getString("Texto"));
                        jBtnProd50.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd50.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd50.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd50.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd50.setIcon(Icono);
                        }
                        jBtnProd50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd50);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd50);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd50);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd50);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd50);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd50);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd50);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd50);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd50);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd50);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd50);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd50);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd50);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd50);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd50);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd50);
                                break;
                        }
                        jBtnProd50.setVisible(true);
                        break;
                    case 52:
                        jBtnProd51.setText(RS.getString("Texto"));
                        jBtnProd51.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd51.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd51.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd51.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd51.setIcon(Icono);
                        }
                        jBtnProd51.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd51);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd51);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd51);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd51);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd51);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd51);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd51);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd51);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd51);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd51);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd51);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd51);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd51);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd51);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd51);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd51);
                                break;
                        }
                        jBtnProd51.setVisible(true);
                        break;
                    case 53:
                        jBtnProd52.setText(RS.getString("Texto"));
                        jBtnProd52.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd52.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd52.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd52.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd52.setIcon(Icono);
                        }
                        jBtnProd52.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd52);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd52);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd52);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd52);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd52);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd52);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd52);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd52);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd52);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd52);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd52);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd52);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd52);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd52);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd52);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd52);
                                break;
                        }
                        jBtnProd52.setVisible(true);
                        break;
                    case 54:
                        jBtnProd53.setText(RS.getString("Texto"));
                        jBtnProd53.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd53.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd53.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd53.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd53.setIcon(Icono);
                        }
                        jBtnProd53.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd53);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd53);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd53);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd53);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd53);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd53);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd53);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd53);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd53);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd53);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd53);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd53);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd53);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd53);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd53);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd53);
                                break;
                        }
                        jBtnProd53.setVisible(true);
                        break;
                    case 55:
                        jBtnProd54.setText(RS.getString("Texto"));
                        jBtnProd54.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd54.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd54.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd54.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd54.setIcon(Icono);
                        }
                        jBtnProd54.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd54);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd54);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd54);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd54);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd54);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd54);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd54);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd54);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd54);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd54);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd54);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd54);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd54);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd54);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd54);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd54);
                                break;
                        }
                        jBtnProd54.setVisible(true);
                        break;
                    case 56:
                        jBtnProd55.setText(RS.getString("Texto"));
                        jBtnProd55.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd55.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd55.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd55.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd55.setIcon(Icono);
                        }
                        jBtnProd55.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd55);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd55);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd55);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd55);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd55);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd55);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd55);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd55);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd55);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd55);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd55);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd55);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd55);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd55);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd55);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd55);
                                break;
                        }
                        jBtnProd55.setVisible(true);
                        break;
                    case 57:
                        jBtnProd56.setText(RS.getString("Texto"));
                        jBtnProd56.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd56.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd56.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd56.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd56.setIcon(Icono);
                        }
                        jBtnProd56.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd56);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd56);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd56);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd56);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd56);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd56);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd56);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd56);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd56);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd56);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd56);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd56);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd56);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd56);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd56);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd56);
                                break;
                        }
                        jBtnProd56.setVisible(true);
                        break;
                    case 58:
                        jBtnProd57.setText(RS.getString("Texto"));
                        jBtnProd57.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd57.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd57.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd57.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd57.setIcon(Icono);
                        }
                        jBtnProd57.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd57);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd57);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd57);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd57);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd57);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd57);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd57);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd57);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd57);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd57);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd57);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd57);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd57);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd57);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd57);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd57);
                                break;
                        }
                        jBtnProd57.setVisible(true);
                        break;
                    case 59:
                        jBtnProd58.setText(RS.getString("Texto"));
                        jBtnProd58.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd58.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd58.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd58.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd58.setIcon(Icono);
                        }
                        jBtnProd58.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd58);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd58);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd58);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd58);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd58);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd58);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd58);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd58);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd58);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd58);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd58);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd58);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd58);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd58);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd58);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd58);
                                break;
                        }
                        jBtnProd58.setVisible(true);
                        break;
                    case 60:
                        jBtnProd59.setText(RS.getString("Texto"));
                        jBtnProd59.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd59.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd59.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd59.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd59.setIcon(Icono);
                        }
                        jBtnProd59.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd59);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd59);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd59);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd59);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd59);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd59);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd59);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd59);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd59);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd59);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd59);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd59);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd59);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd59);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd59);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd59);
                                break;
                        }
                        jBtnProd59.setVisible(true);
                        break;
                    case 61:
                        jBtnProd60.setText(RS.getString("Texto"));
                        jBtnProd60.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd60.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd60.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd60.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd60.setIcon(Icono);
                        }
                        jBtnProd60.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd60);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd60);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd60);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd60);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd60);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd60);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd60);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd60);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd60);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd60);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd60);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd60);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd60);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd60);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd60);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd60);
                                break;
                        }
                        jBtnProd60.setVisible(true);
                        break;
                    case 62:
                        jBtnProd61.setText(RS.getString("Texto"));
                        jBtnProd61.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd61.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd61.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd61.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd61.setIcon(Icono);
                        }
                        jBtnProd61.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd61);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd61);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd61);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd61);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd61);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd61);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd61);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd61);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd61);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd61);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd61);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd61);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd61);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd61);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd61);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd61);
                                break;
                        }
                        jBtnProd61.setVisible(true);
                        break;
                    case 63:
                        jBtnProd62.setText(RS.getString("Texto"));
                        jBtnProd62.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd62.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd62.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd62.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd62.setIcon(Icono);
                        }
                        jBtnProd62.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd62);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd62);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd62);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd62);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd62);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd62);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd62);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd62);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd62);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd62);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd62);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd62);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd62);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd62);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd62);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd62);
                                break;
                        }
                        jBtnProd62.setVisible(true);
                        break;
                    case 64:
                        jBtnProd63.setText(RS.getString("Texto"));
                        jBtnProd63.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd63.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd63.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd63.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd63.setIcon(Icono);
                        }
                        jBtnProd63.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd63);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd63);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd63);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd63);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd63);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd63);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd63);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd63);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd63);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd63);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd63);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd63);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd63);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd63);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd63);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd63);
                                break;
                        }
                        jBtnProd63.setVisible(true);
                        break;
                    case 65:
                        jBtnProd64.setText(RS.getString("Texto"));
                        jBtnProd64.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd64.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd64.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd64.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd64.setIcon(Icono);
                        }
                        jBtnProd64.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd64);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd64);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd64);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd64);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd64);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd64);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd64);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd64);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd64);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd64);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd64);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd64);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd64);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd64);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd64);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd64);
                                break;
                        }
                        jBtnProd64.setVisible(true);
                        break;
                    case 66:
                        jBtnProd65.setText(RS.getString("Texto"));
                        jBtnProd65.setBounds(RS.getInt("X"), RS.getInt("Y"), RS.getInt("W"), RS.getInt("H"));
                        jBtnProd65.setBackground(new Color(RS.getInt("ColorR"), RS.getInt("ColorG"), RS.getInt("ColorB")));
                        jBtnProd65.setForeground(new Color(RS.getInt("LetraR"), RS.getInt("LetraG"), RS.getInt("LetraB")));
                        jBtnProd65.setToolTipText(RS.getInt("IdProd") + ", " + RS.getInt("IdTabPDV"));
                        if(!(RS.getString("Imagen") == null)){
                            InputImagen = RS.getBinaryStream("Imagen");
                            BufferedImage BufferImagen = ImageIO.read(InputImagen);
                            Icono  =  new ImageIcon(BufferImagen);
                            jBtnProd65.setIcon(Icono);
                        }
                        jBtnProd65.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        switch(16 - (RS.getInt("IdTabPDV"))){
                            case 0:
                                jPProd15.add(jBtnProd65);
                                break;
                            case 1:
                                jPProd14.add(jBtnProd65);
                                break;
                            case 2:
                                jPProd13.add(jBtnProd65);
                                break;
                            case 3:
                                jPProd12.add(jBtnProd65);
                                break;
                            case 4:
                                jPProd11.add(jBtnProd65);
                                break;
                            case 5:
                                jPProd10.add(jBtnProd65);
                                break;
                            case 6:
                                jPProd9.add(jBtnProd65);
                                break;
                            case 7:
                                jPProd8.add(jBtnProd65);
                                break;
                            case 8:
                                jPProd7.add(jBtnProd65);
                                break;
                            case 9:
                                jPProd6.add(jBtnProd65);
                                break;
                            case 10:
                                jPProd5.add(jBtnProd65);
                                break;
                            case 11:
                                jPProd4.add(jBtnProd65);
                                break;
                            case 12:
                                jPProd3.add(jBtnProd65);
                                break;
                            case 13:
                                jPProd2.add(jBtnProd65);
                                break;
                            case 14:
                                jPProd1.add(jBtnProd65);
                                break;
                            case 15:
                                jPProd0.add(jBtnProd65);
                                break;
                        }
                        jBtnProd65.setVisible(true);
                        break;
                }
                RS.next();
                i++;
            }
            DB.Delete("DELETE FROM PDV;");
        } catch(SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE, Icono);
            System.exit(0);
        }
        jFrmPOS.add(jTabProductos);
        jFrmPOS.setUndecorated(true);
        jFrmPOS.setResizable(false);
        jFrmPOS.setBounds(0, 0, x, y);
        Icono  =  new ImageIcon(Path + "POS.zabavy");
        jFrmPOS.setIconImage(Icono.getImage());
        jFrmPOS.setVisible(true);
        Icono  =  new ImageIcon(Path + "Error.zabavy");
    }
    
    @Override
    @SuppressWarnings("null")
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jBtnAddT){
            if(jTxtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe llenar el campo de nombre", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else if (Tabs > 17){
                JOptionPane.showMessageDialog(null, "No es posible crear otra pestaña. Por favor guarde los cambios y reinicie el POS.", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                switch(Tabs){
                    case 0:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd0);
                        jPProd0.setBackground(ColB);
                        break;
                    case 1:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd1);
                        jPProd1.setBackground(ColB);
                        break;
                    case 2:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd2);
                        jPProd2.setBackground(ColB);
                        break;
                    case 3:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd3);
                        jPProd3.setBackground(ColB);
                        break;
                    case 4:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd4);
                        jPProd4.setBackground(ColB);
                        break;
                    case 5:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd5);
                        jPProd5.setBackground(ColB);
                        break;
                    case 6:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd6);
                        jPProd6.setBackground(ColB);
                        break;
                    case 7:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd7);
                        jPProd7.setBackground(ColB);
                        break;
                    case 8:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd8);
                        jPProd8.setBackground(ColB);
                        break;
                    case 9:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd9);
                        jPProd9.setBackground(ColB);
                        break;
                    case 10:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd10);
                        jPProd10.setBackground(ColB);
                        break;
                    case 11:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd11);
                        jPProd11.setBackground(ColB);
                        break;
                    case 12:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd12);
                        jPProd12.setBackground(ColB);
                        break;
                    case 13:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd13);
                        jPProd13.setBackground(ColB);
                        break;
                    case 14:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd14);
                        jPProd14.setBackground(ColB);
                        break;
                    case 15:
                        jTabProductos.add(jTxtNombre.getText().toUpperCase(), jPProd15);
                        jPProd15.setBackground(ColB);
                        break;
                }
                Tabs++;
            }
        } else if (e.getSource() == jBtnAddB){
            if(jTxtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else if (Btns > 67){
                JOptionPane.showMessageDialog(null, "No es posible crear otro botón. Por favor guarde los cambios y reinicie el POS.", "Error", JOptionPane.ERROR_MESSAGE, Icono);
            } else {
                if (TabP > 0){
                    int Prod = 0;
                    RS = DB.Select("SELECT Producto FROM productos WHERE NomProd='" + jCmbProductos.getSelectedItem() + "';");
                    try {
                        if (RS.next()){
                            Prod = RS.getInt("Producto");
                        }
                    } catch (SQLException ex) {}
                    switch (Btns){
                        case 0:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd0);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd0);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd0);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd0);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd0);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd0);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd0);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd0);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd0);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd0);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd0);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd0);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd0);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd0);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd0);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd0);
                                    break;
                            }
                            jBtnProd0.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd0.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd0.setBounds(0, 0, 50, 50);
                            jBtnProd0.setBackground(ColB);
                            jBtnProd0.setForeground(ColL);
                            jBtnProd0.setVisible(true);
                            break;
                        case 1:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd1);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd1);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd1);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd1);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd1);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd1);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd1);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd1);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd1);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd1);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd1);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd1);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd1);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd1);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd1);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd1);
                                    break;
                            }
                            jBtnProd1.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd1.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd1.setBounds(0, 0, 50, 50);
                            jBtnProd1.setBackground(ColB);
                            jBtnProd1.setForeground(ColL);
                            jBtnProd1.setVisible(true);
                            break;
                        case 2:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd2);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd2);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd2);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd2);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd2);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd2);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd2);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd2);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd2);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd2);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd2);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd2);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd2);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd2);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd2);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd2);
                                    break;
                            }
                            jBtnProd2.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd2.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd2.setBounds(0, 0, 50, 50);
                            jBtnProd2.setBackground(ColB);
                            jBtnProd2.setForeground(ColL);
                            jBtnProd2.setVisible(true);
                            break;
                        case 3:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd3);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd3);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd3);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd3);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd3);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd3);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd3);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd3);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd3);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd3);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd3);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd3);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd3);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd3);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd3);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd3);
                                    break;
                            }
                            jBtnProd3.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd3.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd3.setBounds(0, 0, 50, 50);
                            jBtnProd3.setBackground(ColB);
                            jBtnProd3.setForeground(ColL);
                            jBtnProd3.setVisible(true);
                            break;
                        case 4:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd4);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd4);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd4);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd4);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd4);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd4);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd4);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd4);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd4);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd4);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd4);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd4);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd4);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd4);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd4);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd4);
                                    break;
                            }
                            jBtnProd4.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd4.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd4.setBounds(0, 0, 50, 50);
                            jBtnProd4.setBackground(ColB);
                            jBtnProd4.setForeground(ColL);
                            jBtnProd4.setVisible(true);
                            break;
                        case 5:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd5);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd5);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd5);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd5);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd5);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd5);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd5);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd5);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd5);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd5);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd5);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd5);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd5);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd5);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd5);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd5);
                                    break;
                            }
                            jBtnProd5.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd5.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd5.setBounds(0, 0, 50, 50);
                            jBtnProd5.setBackground(ColB);
                            jBtnProd5.setForeground(ColL);
                            jBtnProd5.setVisible(true);
                            break;
                        case 6:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd6);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd6);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd6);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd6);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd6);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd6);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd6);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd6);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd6);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd6);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd6);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd6);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd6);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd6);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd6);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd6);
                                    break;
                            }
                            jBtnProd6.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd6.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd6.setBounds(0, 0, 50, 50);
                            jBtnProd6.setBackground(ColB);
                            jBtnProd6.setForeground(ColL);
                            jBtnProd6.setVisible(true);
                            break;
                        case 7:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd7);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd7);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd7);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd7);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd7);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd7);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd7);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd7);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd7);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd7);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd7);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd7);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd7);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd7);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd7);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd7);
                                    break;
                            }
                            jBtnProd7.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd7.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd7.setBounds(0, 0, 50, 50);
                            jBtnProd7.setBackground(ColB);
                            jBtnProd7.setForeground(ColL);
                            jBtnProd7.setVisible(true);
                            break;
                        case 8:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd8);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd8);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd8);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd8);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd8);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd8);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd8);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd8);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd8);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd8);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd8);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd8);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd8);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd8);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd8);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd8);
                                    break;
                            }
                            jBtnProd8.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd8.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd8.setBounds(0, 0, 50, 50);
                            jBtnProd8.setBackground(ColB);
                            jBtnProd8.setForeground(ColL);
                            jBtnProd8.setVisible(true);
                            break;
                        case 9:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd9);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd9);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd9);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd9);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd9);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd9);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd9);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd9);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd9);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd9);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd9);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd9);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd9);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd9);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd9);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd9);
                                    break;
                            }
                            jBtnProd9.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd9.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd9.setBounds(0, 0, 50, 50);
                            jBtnProd9.setBackground(ColB);
                            jBtnProd9.setForeground(ColL);
                            jBtnProd9.setVisible(true);
                            break;
                        case 10:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd10);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd10);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd10);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd10);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd10);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd10);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd10);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd10);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd10);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd10);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd10);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd10);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd10);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd10);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd10);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd10);
                                    break;
                            }
                            jBtnProd10.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd10.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd10.setBounds(0, 0, 50, 50);
                            jBtnProd10.setBackground(ColB);
                            jBtnProd10.setForeground(ColL);
                            jBtnProd10.setVisible(true);
                            break;
                        case 11:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd11);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd11);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd11);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd11);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd11);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd11);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd11);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd11);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd11);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd11);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd11);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd11);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd11);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd11);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd11);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd11);
                                    break;
                            }
                            jBtnProd11.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd11.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd11.setBounds(0, 0, 50, 50);
                            jBtnProd11.setBackground(ColB);
                            jBtnProd11.setForeground(ColL);
                            jBtnProd11.setVisible(true);
                            break;
                        case 12:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd12);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd12);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd12);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd12);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd12);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd12);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd12);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd12);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd12);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd12);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd12);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd12);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd12);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd12);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd12);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd12);
                                    break;
                            }
                            jBtnProd12.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd12.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd12.setBounds(0, 0, 50, 50);
                            jBtnProd12.setBackground(ColB);
                            jBtnProd12.setForeground(ColL);
                            jBtnProd12.setVisible(true);
                            break;
                        case 13:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd13);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd13);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd13);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd13);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd13);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd13);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd13);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd13);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd13);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd13);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd13);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd13);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd13);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd13);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd13);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd13);
                                    break;
                            }
                            jBtnProd13.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd13.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd13.setBounds(0, 0, 50, 50);
                            jBtnProd13.setBackground(ColB);
                            jBtnProd13.setForeground(ColL);
                            jBtnProd13.setVisible(true);
                            break;
                        case 14:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd14);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd14);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd14);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd14);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd14);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd14);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd14);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd14);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd14);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd14);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd14);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd14);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd14);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd14);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd14);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd14);
                                    break;
                            }
                            jBtnProd14.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd14.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd14.setBounds(0, 0, 50, 50);
                            jBtnProd14.setBackground(ColB);
                            jBtnProd14.setForeground(ColL);
                            jBtnProd14.setVisible(true);
                            break;
                        case 15:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd15);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd15);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd15);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd15);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd15);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd15);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd15);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd15);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd15);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd15);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd15);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd15);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd15);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd15);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd15);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd15);
                                    break;
                            }
                            jBtnProd15.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd15.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd15.setBounds(0, 0, 50, 50);
                            jBtnProd15.setBackground(ColB);
                            jBtnProd15.setForeground(ColL);
                            jBtnProd15.setVisible(true);
                            break;
                        case 16:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd16);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd16);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd16);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd16);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd16);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd16);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd16);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd16);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd16);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd16);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd16);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd16);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd16);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd16);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd16);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd16);
                                    break;
                            }
                            jBtnProd16.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd16.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd16.setBounds(0, 0, 50, 50);
                            jBtnProd16.setBackground(ColB);
                            jBtnProd16.setForeground(ColL);
                            jBtnProd16.setVisible(true);
                            break;
                        case 17:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd17);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd17);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd17);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd17);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd17);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd17);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd17);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd17);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd17);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd17);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd17);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd17);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd17);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd17);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd17);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd17);
                                    break;
                            }
                            jBtnProd17.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd17.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd17.setBounds(0, 0, 50, 50);
                            jBtnProd17.setBackground(ColB);
                            jBtnProd17.setForeground(ColL);
                            jBtnProd17.setVisible(true);
                            break;
                        case 18:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd18);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd18);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd18);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd18);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd18);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd18);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd18);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd18);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd18);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd18);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd18);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd18);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd18);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd18);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd18);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd18);
                                    break;
                            }
                            jBtnProd18.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd18.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd18.setBounds(0, 0, 50, 50);
                            jBtnProd18.setBackground(ColB);
                            jBtnProd18.setForeground(ColL);
                            jBtnProd18.setVisible(true);
                            break;
                        case 19:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd19);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd19);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd19);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd19);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd19);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd19);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd19);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd19);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd19);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd19);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd19);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd19);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd19);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd19);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd19);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd19);
                                    break;
                            }
                            jBtnProd19.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd19.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd19.setBounds(0, 0, 50, 50);
                            jBtnProd19.setBackground(ColB);
                            jBtnProd19.setForeground(ColL);
                            jBtnProd19.setVisible(true);
                            break;
                        case 20:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd20);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd20);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd20);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd20);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd20);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd20);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd20);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd20);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd20);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd20);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd20);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd20);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd20);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd20);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd20);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd20);
                                    break;
                            }
                            jBtnProd20.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd20.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd20.setBounds(0, 0, 50, 50);
                            jBtnProd20.setBackground(ColB);
                            jBtnProd20.setForeground(ColL);
                            jBtnProd20.setVisible(true);
                            break;
                        case 21:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd21);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd21);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd21);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd21);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd21);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd21);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd21);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd21);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd21);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd21);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd21);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd21);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd21);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd21);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd21);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd21);
                                    break;
                            }
                            jBtnProd21.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd21.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd21.setBounds(0, 0, 50, 50);
                            jBtnProd21.setBackground(ColB);
                            jBtnProd21.setForeground(ColL);
                            jBtnProd21.setVisible(true);
                            break;
                        case 22:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd22);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd22);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd22);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd22);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd22);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd22);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd22);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd22);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd22);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd22);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd22);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd22);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd22);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd22);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd22);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd22);
                                    break;
                            }
                            jBtnProd22.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd22.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd22.setBounds(0, 0, 50, 50);
                            jBtnProd22.setBackground(ColB);
                            jBtnProd22.setForeground(ColL);
                            jBtnProd22.setVisible(true);
                            break;
                        case 23:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd23);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd23);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd23);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd23);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd23);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd23);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd23);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd23);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd23);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd23);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd23);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd23);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd23);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd23);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd23);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd23);
                                    break;
                            }
                            jBtnProd23.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd23.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd23.setBounds(0, 0, 50, 50);
                            jBtnProd23.setBackground(ColB);
                            jBtnProd23.setForeground(ColL);
                            jBtnProd23.setVisible(true);
                            break;
                        case 24:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd24);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd24);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd24);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd24);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd24);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd24);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd24);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd24);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd24);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd24);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd24);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd24);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd24);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd24);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd24);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd24);
                                    break;
                            }
                            jBtnProd24.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd24.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd24.setBounds(0, 0, 50, 50);
                            jBtnProd24.setBackground(ColB);
                            jBtnProd24.setForeground(ColL);
                            jBtnProd24.setVisible(true);
                            break;
                        case 25:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd25);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd25);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd25);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd25);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd25);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd25);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd25);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd25);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd25);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd25);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd25);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd25);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd25);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd25);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd25);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd25);
                                    break;
                            }
                            jBtnProd25.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd25.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd25.setBounds(0, 0, 50, 50);
                            jBtnProd25.setBackground(ColB);
                            jBtnProd25.setForeground(ColL);
                            jBtnProd25.setVisible(true);
                            break;
                        case 26:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd26);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd26);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd26);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd26);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd26);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd26);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd26);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd26);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd26);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd26);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd26);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd26);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd26);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd26);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd26);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd26);
                                    break;
                            }
                            jBtnProd26.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd26.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd26.setBounds(0, 0, 50, 50);
                            jBtnProd26.setBackground(ColB);
                            jBtnProd26.setForeground(ColL);
                            jBtnProd26.setVisible(true);
                            break;
                        case 27:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd27);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd27);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd27);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd27);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd27);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd27);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd27);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd27);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd27);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd27);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd27);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd27);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd27);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd27);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd27);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd27);
                                    break;
                            }
                            jBtnProd27.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd27.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd27.setBounds(0, 0, 50, 50);
                            jBtnProd27.setBackground(ColB);
                            jBtnProd27.setForeground(ColL);
                            jBtnProd27.setVisible(true);
                            break;
                        case 28:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd28);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd28);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd28);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd28);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd28);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd28);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd28);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd28);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd28);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd28);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd28);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd28);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd28);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd28);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd28);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd28);
                                    break;
                            }
                            jBtnProd28.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd28.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd28.setBounds(0, 0, 50, 50);
                            jBtnProd28.setBackground(ColB);
                            jBtnProd28.setForeground(ColL);
                            jBtnProd28.setVisible(true);
                            break;
                        case 29:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd29);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd29);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd29);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd29);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd29);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd29);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd29);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd29);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd29);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd29);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd29);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd29);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd29);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd29);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd29);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd29);
                                    break;
                            }
                            jBtnProd29.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd29.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd29.setBounds(0, 0, 50, 50);
                            jBtnProd29.setBackground(ColB);
                            jBtnProd29.setForeground(ColL);
                            jBtnProd29.setVisible(true);
                            break;
                        case 30:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd30);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd30);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd30);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd30);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd30);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd30);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd30);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd30);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd30);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd30);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd30);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd30);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd30);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd30);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd30);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd30);
                                    break;
                            }
                            jBtnProd30.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd30.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd30.setBounds(0, 0, 50, 50);
                            jBtnProd30.setBackground(ColB);
                            jBtnProd30.setForeground(ColL);
                            jBtnProd30.setVisible(true);
                            break;
                        case 31:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd31);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd31);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd31);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd31);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd31);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd31);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd31);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd31);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd31);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd31);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd31);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd31);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd31);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd31);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd31);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd31);
                                    break;
                            }
                            jBtnProd31.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd31.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd31.setBounds(0, 0, 50, 50);
                            jBtnProd31.setBackground(ColB);
                            jBtnProd31.setForeground(ColL);
                            jBtnProd31.setVisible(true);
                            break;
                        case 32:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd32);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd32);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd32);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd32);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd32);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd32);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd32);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd32);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd32);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd32);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd32);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd32);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd32);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd32);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd32);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd32);
                                    break;
                            }
                            jBtnProd32.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd32.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd32.setBounds(0, 0, 50, 50);
                            jBtnProd32.setBackground(ColB);
                            jBtnProd32.setForeground(ColL);
                            jBtnProd32.setVisible(true);
                            break;
                        case 33:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd33);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd33);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd33);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd33);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd33);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd33);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd33);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd33);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd33);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd33);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd33);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd33);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd33);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd33);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd33);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd33);
                                    break;
                            }
                            jBtnProd33.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd33.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd33.setBounds(0, 0, 50, 50);
                            jBtnProd33.setBackground(ColB);
                            jBtnProd33.setForeground(ColL);
                            jBtnProd33.setVisible(true);
                            break;
                        case 34:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd34);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd34);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd34);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd34);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd34);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd34);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd34);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd34);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd34);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd34);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd34);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd34);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd34);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd34);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd34);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd34);
                                    break;
                            }
                            jBtnProd34.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd34.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd34.setBounds(0, 0, 50, 50);
                            jBtnProd34.setBackground(ColB);
                            jBtnProd34.setForeground(ColL);
                            jBtnProd34.setVisible(true);
                            break;
                        case 35:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd35);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd35);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd35);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd35);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd35);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd35);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd35);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd35);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd35);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd35);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd35);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd35);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd35);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd35);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd35);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd35);
                                    break;
                            }
                            jBtnProd35.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd35.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd35.setBounds(0, 0, 50, 50);
                            jBtnProd35.setBackground(ColB);
                            jBtnProd35.setForeground(ColL);
                            jBtnProd35.setVisible(true);
                            break;
                        case 36:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd36);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd36);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd36);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd36);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd36);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd36);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd36);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd36);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd36);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd36);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd36);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd36);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd36);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd36);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd36);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd36);
                                    break;
                            }
                            jBtnProd36.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd36.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd36.setBounds(0, 0, 50, 50);
                            jBtnProd36.setBackground(ColB);
                            jBtnProd36.setForeground(ColL);
                            jBtnProd36.setVisible(true);
                            break;
                        case 37:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd37);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd37);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd37);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd37);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd37);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd37);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd37);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd37);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd37);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd37);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd37);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd37);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd37);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd37);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd37);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd37);
                                    break;
                            }
                            jBtnProd37.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd37.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd37.setBounds(0, 0, 50, 50);
                            jBtnProd37.setBackground(ColB);
                            jBtnProd37.setForeground(ColL);
                            jBtnProd37.setVisible(true);
                            break;
                        case 38:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd38);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd38);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd38);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd38);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd38);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd38);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd38);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd38);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd38);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd38);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd38);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd38);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd38);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd38);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd38);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd38);
                                    break;
                            }
                            jBtnProd38.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd38.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd38.setBounds(0, 0, 50, 50);
                            jBtnProd38.setBackground(ColB);
                            jBtnProd38.setForeground(ColL);
                            jBtnProd38.setVisible(true);
                            break;
                        case 39:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd39);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd39);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd39);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd39);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd39);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd39);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd39);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd39);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd39);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd39);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd39);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd39);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd39);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd39);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd39);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd39);
                                    break;
                            }
                            jBtnProd39.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd39.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd39.setBounds(0, 0, 50, 50);
                            jBtnProd39.setBackground(ColB);
                            jBtnProd39.setForeground(ColL);
                            jBtnProd39.setVisible(true);
                            break;
                        case 40:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd40);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd40);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd40);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd40);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd40);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd40);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd40);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd40);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd40);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd40);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd40);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd40);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd40);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd40);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd40);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd40);
                                    break;
                            }
                            jBtnProd40.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd40.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd40.setBounds(0, 0, 50, 50);
                            jBtnProd40.setBackground(ColB);
                            jBtnProd40.setForeground(ColL);
                            jBtnProd40.setVisible(true);
                            break;
                        case 41:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd41);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd41);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd41);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd41);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd41);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd41);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd41);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd41);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd41);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd41);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd41);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd41);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd41);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd41);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd41);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd41);
                                    break;
                            }
                            jBtnProd41.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd41.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd41.setBounds(0, 0, 50, 50);
                            jBtnProd41.setBackground(ColB);
                            jBtnProd41.setForeground(ColL);
                            jBtnProd41.setVisible(true);
                            break;
                        case 42:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd42);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd42);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd42);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd42);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd42);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd42);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd42);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd42);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd42);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd42);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd42);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd42);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd42);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd42);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd42);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd42);
                                    break;
                            }
                            jBtnProd42.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd42.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd42.setBounds(0, 0, 50, 50);
                            jBtnProd42.setBackground(ColB);
                            jBtnProd42.setForeground(ColL);
                            jBtnProd42.setVisible(true);
                            break;
                        case 43:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd43);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd43);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd43);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd43);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd43);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd43);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd43);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd43);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd43);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd43);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd43);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd43);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd43);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd43);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd43);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd43);
                                    break;
                            }
                            jBtnProd43.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd43.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd43.setBounds(0, 0, 50, 50);
                            jBtnProd43.setBackground(ColB);
                            jBtnProd43.setForeground(ColL);
                            jBtnProd43.setVisible(true);
                            break;
                        case 44:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd44);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd44);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd44);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd44);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd44);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd44);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd44);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd44);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd44);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd44);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd44);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd44);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd44);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd44);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd44);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd44);
                                    break;
                            }
                            jBtnProd44.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd44.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd44.setBounds(0, 0, 50, 50);
                            jBtnProd44.setBackground(ColB);
                            jBtnProd44.setForeground(ColL);
                            jBtnProd44.setVisible(true);
                            break;
                        case 45:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd45);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd45);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd45);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd45);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd45);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd45);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd45);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd45);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd45);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd45);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd45);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd45);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd45);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd45);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd45);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd45);
                                    break;
                            }
                            jBtnProd45.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd45.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd45.setBounds(0, 0, 50, 50);
                            jBtnProd45.setBackground(ColB);
                            jBtnProd45.setForeground(ColL);
                            jBtnProd45.setVisible(true);
                            break;
                        case 46:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd46);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd46);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd46);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd46);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd46);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd46);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd46);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd46);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd46);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd46);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd46);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd46);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd46);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd46);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd46);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd46);
                                    break;
                            }
                            jBtnProd46.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd46.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd46.setBounds(0, 0, 50, 50);
                            jBtnProd46.setBackground(ColB);
                            jBtnProd46.setForeground(ColL);
                            jBtnProd46.setVisible(true);
                            break;
                        case 47:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd47);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd47);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd47);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd47);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd47);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd47);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd47);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd47);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd47);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd47);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd47);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd47);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd47);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd47);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd47);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd47);
                                    break;
                            }
                            jBtnProd47.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd47.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd47.setBounds(0, 0, 50, 50);
                            jBtnProd47.setBackground(ColB);
                            jBtnProd47.setForeground(ColL);
                            jBtnProd47.setVisible(true);
                            break;
                        case 48:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd48);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd48);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd48);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd48);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd48);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd48);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd48);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd48);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd48);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd48);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd48);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd48);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd48);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd48);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd48);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd48);
                                    break;
                            }
                            jBtnProd48.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd48.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd48.setBounds(0, 0, 50, 50);
                            jBtnProd48.setBackground(ColB);
                            jBtnProd48.setForeground(ColL);
                            jBtnProd48.setVisible(true);
                            break;
                        case 49:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd49);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd49);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd49);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd49);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd49);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd49);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd49);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd49);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd49);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd49);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd49);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd49);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd49);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd49);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd49);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd49);
                                    break;
                            }
                            jBtnProd49.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd49.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd49.setBounds(0, 0, 50, 50);
                            jBtnProd49.setBackground(ColB);
                            jBtnProd49.setForeground(ColL);
                            jBtnProd49.setVisible(true);
                            break;
                        case 50:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd50);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd50);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd50);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd50);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd50);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd50);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd50);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd50);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd50);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd50);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd50);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd50);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd50);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd50);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd50);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd50);
                                    break;
                            }
                            jBtnProd50.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd50.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd50.setBounds(0, 0, 50, 50);
                            jBtnProd50.setBackground(ColB);
                            jBtnProd50.setForeground(ColL);
                            jBtnProd50.setVisible(true);
                            break;
                        case 51:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd51);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd51);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd51);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd51);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd51);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd51);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd51);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd51);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd51);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd51);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd51);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd51);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd51);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd51);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd51);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd51);
                                    break;
                            }
                            jBtnProd51.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd51.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd51.setBounds(0, 0, 50, 50);
                            jBtnProd51.setBackground(ColB);
                            jBtnProd51.setForeground(ColL);
                            jBtnProd51.setVisible(true);
                            break;
                        case 52:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd52);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd52);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd52);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd52);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd52);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd52);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd52);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd52);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd52);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd52);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd52);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd52);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd52);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd52);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd52);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd52);
                                    break;
                            }
                            jBtnProd52.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd52.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd52.setBounds(0, 0, 50, 50);
                            jBtnProd52.setBackground(ColB);
                            jBtnProd52.setForeground(ColL);
                            jBtnProd52.setVisible(true);
                            break;
                        case 53:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd53);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd53);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd53);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd53);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd53);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd53);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd53);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd53);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd53);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd53);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd53);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd53);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd53);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd53);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd53);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd53);
                                    break;
                            }
                            jBtnProd53.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd53.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd53.setBounds(0, 0, 50, 50);
                            jBtnProd53.setBackground(ColB);
                            jBtnProd53.setForeground(ColL);
                            jBtnProd53.setVisible(true);
                            break;
                        case 54:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd54);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd54);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd54);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd54);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd54);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd54);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd54);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd54);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd54);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd54);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd54);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd54);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd54);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd54);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd54);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd54);
                                    break;
                            }
                            jBtnProd54.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd54.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd54.setBounds(0, 0, 50, 50);
                            jBtnProd54.setBackground(ColB);
                            jBtnProd54.setForeground(ColL);
                            jBtnProd54.setVisible(true);
                            break;
                        case 55:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd55);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd55);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd55);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd55);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd55);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd55);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd55);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd55);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd55);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd55);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd55);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd55);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd55);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd55);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd55);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd55);
                                    break;
                            }
                            jBtnProd55.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd55.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd55.setBounds(0, 0, 50, 50);
                            jBtnProd55.setBackground(ColB);
                            jBtnProd55.setForeground(ColL);
                            jBtnProd55.setVisible(true);
                            break;
                        case 56:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd56);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd56);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd56);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd56);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd56);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd56);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd56);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd56);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd56);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd56);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd56);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd56);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd56);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd56);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd56);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd56);
                                    break;
                            }
                            jBtnProd56.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd56.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd56.setBounds(0, 0, 50, 50);
                            jBtnProd56.setBackground(ColB);
                            jBtnProd56.setForeground(ColL);
                            jBtnProd56.setVisible(true);
                            break;
                        case 57:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd57);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd57);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd57);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd57);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd57);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd57);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd57);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd57);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd57);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd57);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd57);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd57);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd57);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd57);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd57);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd57);
                                    break;
                            }
                            jBtnProd57.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd57.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd57.setBounds(0, 0, 50, 50);
                            jBtnProd57.setBackground(ColB);
                            jBtnProd57.setForeground(ColL);
                            jBtnProd57.setVisible(true);
                            break;
                        case 58:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd58);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd58);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd58);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd58);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd58);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd58);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd58);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd58);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd58);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd58);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd58);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd58);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd58);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd58);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd58);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd58);
                                    break;
                            }
                            jBtnProd58.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd58.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd58.setBounds(0, 0, 50, 50);
                            jBtnProd58.setBackground(ColB);
                            jBtnProd58.setForeground(ColL);
                            jBtnProd58.setVisible(true);
                            break;
                        case 59:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd59);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd59);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd59);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd59);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd59);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd59);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd59);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd59);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd59);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd59);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd59);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd59);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd59);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd59);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd59);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd59);
                                    break;
                            }
                            jBtnProd59.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd59.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd59.setBounds(0, 0, 50, 50);
                            jBtnProd59.setBackground(ColB);
                            jBtnProd59.setForeground(ColL);
                            jBtnProd59.setVisible(true);
                            break;
                        case 60:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd60);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd60);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd60);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd60);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd60);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd60);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd60);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd60);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd60);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd60);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd60);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd60);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd60);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd60);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd60);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd60);
                                    break;
                            }
                            jBtnProd60.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd60.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd60.setBounds(0, 0, 50, 50);
                            jBtnProd60.setBackground(ColB);
                            jBtnProd60.setForeground(ColL);
                            jBtnProd60.setVisible(true);
                            break;
                        case 61:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd61);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd61);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd61);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd61);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd61);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd61);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd61);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd61);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd61);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd61);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd61);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd61);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd61);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd61);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd61);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd61);
                                    break;
                            }
                            jBtnProd61.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd61.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd61.setBounds(0, 0, 50, 50);
                            jBtnProd61.setBackground(ColB);
                            jBtnProd61.setForeground(ColL);
                            jBtnProd61.setVisible(true);
                            break;
                        case 62:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd62);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd62);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd62);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd62);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd62);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd62);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd62);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd62);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd62);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd62);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd62);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd62);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd62);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd62);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd62);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd62);
                                    break;
                            }
                            jBtnProd62.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd62.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd62.setBounds(0, 0, 50, 50);
                            jBtnProd62.setBackground(ColB);
                            jBtnProd62.setForeground(ColL);
                            jBtnProd62.setVisible(true);
                            break;
                        case 63:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd63);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd63);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd63);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd63);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd63);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd63);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd63);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd63);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd63);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd63);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd63);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd63);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd63);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd63);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd63);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd63);
                                    break;
                            }
                            jBtnProd63.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd63.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd63.setBounds(0, 0, 50, 50);
                            jBtnProd63.setBackground(ColB);
                            jBtnProd63.setForeground(ColL);
                            jBtnProd63.setVisible(true);
                            break;
                        case 64:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd64);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd64);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd64);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd64);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd64);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd64);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd64);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd64);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd64);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd64);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd64);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd64);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd64);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd64);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd64);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd64);
                                    break;
                            }
                            jBtnProd64.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd64.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd64.setBounds(0, 0, 50, 50);
                            jBtnProd64.setBackground(ColB);
                            jBtnProd64.setForeground(ColL);
                            jBtnProd64.setVisible(true);
                            break;
                        case 65:
                            switch (TabP - 1){
                                case 0:
                                    jPProd0.add(jBtnProd65);
                                    break;
                                case 1:
                                    jPProd1.add(jBtnProd65);
                                    break;
                                case 2:
                                    jPProd2.add(jBtnProd65);
                                    break;
                                case 3:
                                    jPProd3.add(jBtnProd65);
                                    break;
                                case 4:
                                    jPProd4.add(jBtnProd65);
                                    break;
                                case 5:
                                    jPProd5.add(jBtnProd65);
                                    break;
                                case 6:
                                    jPProd6.add(jBtnProd65);
                                    break;
                                case 7:
                                    jPProd7.add(jBtnProd65);
                                    break;
                                case 8:
                                    jPProd8.add(jBtnProd65);
                                    break;
                                case 9:
                                    jPProd9.add(jBtnProd65);
                                    break;
                                case 10:
                                    jPProd10.add(jBtnProd65);
                                    break;
                                case 11:
                                    jPProd11.add(jBtnProd65);
                                    break;
                                case 12:
                                    jPProd12.add(jBtnProd65);
                                    break;
                                case 13:
                                    jPProd13.add(jBtnProd65);
                                    break;
                                case 14:
                                    jPProd14.add(jBtnProd65);
                                    break;
                                case 15:
                                    jPProd15.add(jBtnProd65);
                                    break;
                            }
                            jBtnProd65.setText(jTxtNombre.getText().toUpperCase());
                            jBtnProd65.setToolTipText(Prod + ", " + String.valueOf(TabP));
                            jBtnProd65.setBounds(0, 0, 50, 50);
                            jBtnProd65.setBackground(ColB);
                            jBtnProd65.setForeground(ColL);
                            jBtnProd65.setVisible(true);
                            break;
                    }
                    Btns++;
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una pestaña", "Error", JOptionPane.ERROR_MESSAGE, Icono);
                }
            }
        } else if (e.getSource() == jBtnAceptar){
            int i;
            for (i = 0; i < Tabs; i++){
                switch(i){
                    case 0:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd0.getBackground().getRed() + "','" + jPProd0.getBackground().getGreen() + "','" + jPProd0.getBackground().getBlue() + "');");
                        break;
                    case 1:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd1.getBackground().getRed() + "','" + jPProd1.getBackground().getGreen() + "','" + jPProd1.getBackground().getBlue() + "');");
                        break;
                    case 2:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd2.getBackground().getRed() + "','" + jPProd2.getBackground().getGreen() + "','" + jPProd2.getBackground().getBlue() + "');");
                        break;
                    case 3:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd3.getBackground().getRed() + "','" + jPProd3.getBackground().getGreen() + "','" + jPProd3.getBackground().getBlue() + "');");
                        break;
                    case 4:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd4.getBackground().getRed() + "','" + jPProd4.getBackground().getGreen() + "','" + jPProd4.getBackground().getBlue() + "');");
                        break;
                    case 5:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd5.getBackground().getRed() + "','" + jPProd5.getBackground().getGreen() + "','" + jPProd5.getBackground().getBlue() + "');");
                        break;
                    case 6:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd6.getBackground().getRed() + "','" + jPProd6.getBackground().getGreen() + "','" + jPProd6.getBackground().getBlue() + "');");
                        break;
                    case 7:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd7.getBackground().getRed() + "','" + jPProd7.getBackground().getGreen() + "','" + jPProd7.getBackground().getBlue() + "');");
                        break;
                    case 8:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd8.getBackground().getRed() + "','" + jPProd8.getBackground().getGreen() + "','" + jPProd8.getBackground().getBlue() + "');");
                        break;
                    case 9:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd9.getBackground().getRed() + "','" + jPProd9.getBackground().getGreen() + "','" + jPProd9.getBackground().getBlue() + "');");
                        break;
                    case 10:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd10.getBackground().getRed() + "','" + jPProd10.getBackground().getGreen() + "','" + jPProd10.getBackground().getBlue() + "');");
                        break;
                    case 11:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd11.getBackground().getRed() + "','" + jPProd11.getBackground().getGreen() + "','" + jPProd11.getBackground().getBlue() + "');");
                        break;
                    case 12:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd12.getBackground().getRed() + "','" + jPProd12.getBackground().getGreen() + "','" + jPProd12.getBackground().getBlue() + "');");
                        break;
                    case 13:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd13.getBackground().getRed() + "','" + jPProd13.getBackground().getGreen() + "','" + jPProd13.getBackground().getBlue() + "');");
                        break;
                    case 14:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd14.getBackground().getRed() + "','" + jPProd14.getBackground().getGreen() + "','" + jPProd14.getBackground().getBlue() + "');");
                        break;
                    case 15:
                        DB.Insert("INSERT INTO TabPDV VALUES ('" + (i + 1) + "','" + jTabProductos.getTitleAt(i) + "','" + jPProd15.getBackground().getRed() + "','" + jPProd15.getBackground().getGreen() + "','" + jPProd15.getBackground().getBlue() + "');");
                        break;
                }
            }
            int A = 0, B = 0;
            for (i = 0; i < Btns; i++){
                switch (i){
                    case 0:
                        if (jBtnProd0.isVisible()){
                            A = Integer.parseInt(jBtnProd0.getToolTipText().substring(0, jBtnProd0.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd0.getToolTipText().substring(jBtnProd0.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd0.getText().toUpperCase() + "','" + jBtnProd0.getBackground().getRed() + "','" + jBtnProd0.getBackground().getGreen() + "','" + jBtnProd0.getBackground().getBlue() + "','" + jBtnProd0.getForeground().getRed() + "','" + jBtnProd0.getForeground().getGreen() + "','" + jBtnProd0.getForeground().getBlue() + "','" + jBtnProd0.getBounds().x + "','" + jBtnProd0.getBounds().y + "','" + jBtnProd0.getBounds().height + "','" + jBtnProd0.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 1:
                        if (jBtnProd1.isVisible()){
                            A = Integer.parseInt(jBtnProd1.getToolTipText().substring(0, jBtnProd1.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd1.getToolTipText().substring(jBtnProd1.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd1.getText().toUpperCase() + "','" + jBtnProd1.getBackground().getRed() + "','" + jBtnProd1.getBackground().getGreen() + "','" + jBtnProd1.getBackground().getBlue() + "','" + jBtnProd1.getForeground().getRed() + "','" + jBtnProd1.getForeground().getGreen() + "','" + jBtnProd1.getForeground().getBlue() + "','" + jBtnProd1.getBounds().x + "','" + jBtnProd1.getBounds().y + "','" + jBtnProd1.getBounds().height + "','" + jBtnProd1.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 2:
                        if (jBtnProd2.isVisible()){
                            A = Integer.parseInt(jBtnProd2.getToolTipText().substring(0, jBtnProd2.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd2.getToolTipText().substring(jBtnProd2.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd2.getText().toUpperCase() + "','" + jBtnProd2.getBackground().getRed() + "','" + jBtnProd2.getBackground().getGreen() + "','" + jBtnProd2.getBackground().getBlue() + "','" + jBtnProd2.getForeground().getRed() + "','" + jBtnProd2.getForeground().getGreen() + "','" + jBtnProd2.getForeground().getBlue() + "','" + jBtnProd2.getBounds().x + "','" + jBtnProd2.getBounds().y + "','" + jBtnProd2.getBounds().height + "','" + jBtnProd2.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 3:
                        if (jBtnProd3.isVisible()){
                            A = Integer.parseInt(jBtnProd3.getToolTipText().substring(0, jBtnProd3.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd3.getToolTipText().substring(jBtnProd3.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd3.getText().toUpperCase() + "','" + jBtnProd3.getBackground().getRed() + "','" + jBtnProd3.getBackground().getGreen() + "','" + jBtnProd3.getBackground().getBlue() + "','" + jBtnProd3.getForeground().getRed() + "','" + jBtnProd3.getForeground().getGreen() + "','" + jBtnProd3.getForeground().getBlue() + "','" + jBtnProd3.getBounds().x + "','" + jBtnProd3.getBounds().y + "','" + jBtnProd3.getBounds().height + "','" + jBtnProd3.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 4:
                        if (jBtnProd4.isVisible()){
                            A = Integer.parseInt(jBtnProd4.getToolTipText().substring(0, jBtnProd4.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd4.getToolTipText().substring(jBtnProd4.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd4.getText().toUpperCase() + "','" + jBtnProd4.getBackground().getRed() + "','" + jBtnProd4.getBackground().getGreen() + "','" + jBtnProd4.getBackground().getBlue() + "','" + jBtnProd4.getForeground().getRed() + "','" + jBtnProd4.getForeground().getGreen() + "','" + jBtnProd4.getForeground().getBlue() + "','" + jBtnProd4.getBounds().x + "','" + jBtnProd4.getBounds().y + "','" + jBtnProd4.getBounds().height + "','" + jBtnProd4.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 5:
                        if (jBtnProd5.isVisible()){
                            A = Integer.parseInt(jBtnProd5.getToolTipText().substring(0, jBtnProd5.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd5.getToolTipText().substring(jBtnProd5.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd5.getText().toUpperCase() + "','" + jBtnProd5.getBackground().getRed() + "','" + jBtnProd5.getBackground().getGreen() + "','" + jBtnProd5.getBackground().getBlue() + "','" + jBtnProd5.getForeground().getRed() + "','" + jBtnProd5.getForeground().getGreen() + "','" + jBtnProd5.getForeground().getBlue() + "','" + jBtnProd5.getBounds().x + "','" + jBtnProd5.getBounds().y + "','" + jBtnProd5.getBounds().height + "','" + jBtnProd5.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 6:
                        if (jBtnProd6.isVisible()){
                            A = Integer.parseInt(jBtnProd6.getToolTipText().substring(0, jBtnProd6.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd6.getToolTipText().substring(jBtnProd6.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd6.getText().toUpperCase() + "','" + jBtnProd6.getBackground().getRed() + "','" + jBtnProd6.getBackground().getGreen() + "','" + jBtnProd6.getBackground().getBlue() + "','" + jBtnProd6.getForeground().getRed() + "','" + jBtnProd6.getForeground().getGreen() + "','" + jBtnProd6.getForeground().getBlue() + "','" + jBtnProd6.getBounds().x + "','" + jBtnProd6.getBounds().y + "','" + jBtnProd6.getBounds().height + "','" + jBtnProd6.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 7:
                        if (jBtnProd7.isVisible()){
                            A = Integer.parseInt(jBtnProd7.getToolTipText().substring(0, jBtnProd7.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd7.getToolTipText().substring(jBtnProd7.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd7.getText().toUpperCase() + "','" + jBtnProd7.getBackground().getRed() + "','" + jBtnProd7.getBackground().getGreen() + "','" + jBtnProd7.getBackground().getBlue() + "','" + jBtnProd7.getForeground().getRed() + "','" + jBtnProd7.getForeground().getGreen() + "','" + jBtnProd7.getForeground().getBlue() + "','" + jBtnProd7.getBounds().x + "','" + jBtnProd7.getBounds().y + "','" + jBtnProd7.getBounds().height + "','" + jBtnProd7.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 8:
                        if (jBtnProd8.isVisible()){
                            A = Integer.parseInt(jBtnProd8.getToolTipText().substring(0, jBtnProd8.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd8.getToolTipText().substring(jBtnProd8.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd8.getText().toUpperCase() + "','" + jBtnProd8.getBackground().getRed() + "','" + jBtnProd8.getBackground().getGreen() + "','" + jBtnProd8.getBackground().getBlue() + "','" + jBtnProd8.getForeground().getRed() + "','" + jBtnProd8.getForeground().getGreen() + "','" + jBtnProd8.getForeground().getBlue() + "','" + jBtnProd8.getBounds().x + "','" + jBtnProd8.getBounds().y + "','" + jBtnProd8.getBounds().height + "','" + jBtnProd8.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 9:
                        if (jBtnProd9.isVisible()){
                            A = Integer.parseInt(jBtnProd9.getToolTipText().substring(0, jBtnProd9.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd9.getToolTipText().substring(jBtnProd9.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd9.getText().toUpperCase() + "','" + jBtnProd9.getBackground().getRed() + "','" + jBtnProd9.getBackground().getGreen() + "','" + jBtnProd9.getBackground().getBlue() + "','" + jBtnProd9.getForeground().getRed() + "','" + jBtnProd9.getForeground().getGreen() + "','" + jBtnProd9.getForeground().getBlue() + "','" + jBtnProd9.getBounds().x + "','" + jBtnProd9.getBounds().y + "','" + jBtnProd9.getBounds().height + "','" + jBtnProd9.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 10:
                        if (jBtnProd10.isVisible()){
                            A = Integer.parseInt(jBtnProd10.getToolTipText().substring(0, jBtnProd10.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd10.getToolTipText().substring(jBtnProd10.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd10.getText().toUpperCase() + "','" + jBtnProd10.getBackground().getRed() + "','" + jBtnProd10.getBackground().getGreen() + "','" + jBtnProd10.getBackground().getBlue() + "','" + jBtnProd10.getForeground().getRed() + "','" + jBtnProd10.getForeground().getGreen() + "','" + jBtnProd10.getForeground().getBlue() + "','" + jBtnProd10.getBounds().x + "','" + jBtnProd10.getBounds().y + "','" + jBtnProd10.getBounds().height + "','" + jBtnProd10.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 11:
                        if (jBtnProd11.isVisible()){
                            A = Integer.parseInt(jBtnProd11.getToolTipText().substring(0, jBtnProd11.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd11.getToolTipText().substring(jBtnProd11.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd11.getText().toUpperCase() + "','" + jBtnProd11.getBackground().getRed() + "','" + jBtnProd11.getBackground().getGreen() + "','" + jBtnProd11.getBackground().getBlue() + "','" + jBtnProd11.getForeground().getRed() + "','" + jBtnProd11.getForeground().getGreen() + "','" + jBtnProd11.getForeground().getBlue() + "','" + jBtnProd11.getBounds().x + "','" + jBtnProd11.getBounds().y + "','" + jBtnProd11.getBounds().height + "','" + jBtnProd11.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                            break;
                        }
                    case 12:
                        if (jBtnProd12.isVisible()){
                            A = Integer.parseInt(jBtnProd12.getToolTipText().substring(0, jBtnProd12.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd12.getToolTipText().substring(jBtnProd12.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd12.getText().toUpperCase() + "','" + jBtnProd12.getBackground().getRed() + "','" + jBtnProd12.getBackground().getGreen() + "','" + jBtnProd12.getBackground().getBlue() + "','" + jBtnProd12.getForeground().getRed() + "','" + jBtnProd12.getForeground().getGreen() + "','" + jBtnProd12.getForeground().getBlue() + "','" + jBtnProd12.getBounds().x + "','" + jBtnProd12.getBounds().y + "','" + jBtnProd12.getBounds().height + "','" + jBtnProd12.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 13:
                        if (jBtnProd13.isVisible()){
                            A = Integer.parseInt(jBtnProd13.getToolTipText().substring(0, jBtnProd13.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd13.getToolTipText().substring(jBtnProd13.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd13.getText().toUpperCase() + "','" + jBtnProd13.getBackground().getRed() + "','" + jBtnProd13.getBackground().getGreen() + "','" + jBtnProd13.getBackground().getBlue() + "','" + jBtnProd13.getForeground().getRed() + "','" + jBtnProd13.getForeground().getGreen() + "','" + jBtnProd13.getForeground().getBlue() + "','" + jBtnProd13.getBounds().x + "','" + jBtnProd13.getBounds().y + "','" + jBtnProd13.getBounds().height + "','" + jBtnProd13.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 14:
                        if (jBtnProd14.isVisible()){
                            A = Integer.parseInt(jBtnProd14.getToolTipText().substring(0, jBtnProd14.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd14.getToolTipText().substring(jBtnProd14.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd14.getText().toUpperCase() + "','" + jBtnProd14.getBackground().getRed() + "','" + jBtnProd14.getBackground().getGreen() + "','" + jBtnProd14.getBackground().getBlue() + "','" + jBtnProd14.getForeground().getRed() + "','" + jBtnProd14.getForeground().getGreen() + "','" + jBtnProd14.getForeground().getBlue() + "','" + jBtnProd14.getBounds().x + "','" + jBtnProd14.getBounds().y + "','" + jBtnProd14.getBounds().height + "','" + jBtnProd14.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 15:
                        if (jBtnProd15.isVisible()){
                            A = Integer.parseInt(jBtnProd15.getToolTipText().substring(0, jBtnProd15.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd15.getToolTipText().substring(jBtnProd15.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd15.getText().toUpperCase() + "','" + jBtnProd15.getBackground().getRed() + "','" + jBtnProd15.getBackground().getGreen() + "','" + jBtnProd15.getBackground().getBlue() + "','" + jBtnProd15.getForeground().getRed() + "','" + jBtnProd15.getForeground().getGreen() + "','" + jBtnProd15.getForeground().getBlue() + "','" + jBtnProd15.getBounds().x + "','" + jBtnProd15.getBounds().y + "','" + jBtnProd15.getBounds().height + "','" + jBtnProd15.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 16:
                        if (jBtnProd16.isVisible()){
                            A = Integer.parseInt(jBtnProd16.getToolTipText().substring(0, jBtnProd16.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd16.getToolTipText().substring(jBtnProd16.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd16.getText().toUpperCase() + "','" + jBtnProd16.getBackground().getRed() + "','" + jBtnProd16.getBackground().getGreen() + "','" + jBtnProd16.getBackground().getBlue() + "','" + jBtnProd16.getForeground().getRed() + "','" + jBtnProd16.getForeground().getGreen() + "','" + jBtnProd16.getForeground().getBlue() + "','" + jBtnProd16.getBounds().x + "','" + jBtnProd16.getBounds().y + "','" + jBtnProd16.getBounds().height + "','" + jBtnProd16.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 17:
                        if (jBtnProd17.isVisible()){
                            A = Integer.parseInt(jBtnProd17.getToolTipText().substring(0, jBtnProd17.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd17.getToolTipText().substring(jBtnProd17.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd17.getText().toUpperCase() + "','" + jBtnProd17.getBackground().getRed() + "','" + jBtnProd17.getBackground().getGreen() + "','" + jBtnProd17.getBackground().getBlue() + "','" + jBtnProd17.getForeground().getRed() + "','" + jBtnProd17.getForeground().getGreen() + "','" + jBtnProd17.getForeground().getBlue() + "','" + jBtnProd17.getBounds().x + "','" + jBtnProd17.getBounds().y + "','" + jBtnProd17.getBounds().height + "','" + jBtnProd17.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 18:
                        if (jBtnProd18.isVisible()){
                            A = Integer.parseInt(jBtnProd18.getToolTipText().substring(0, jBtnProd18.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd18.getToolTipText().substring(jBtnProd18.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd18.getText().toUpperCase() + "','" + jBtnProd18.getBackground().getRed() + "','" + jBtnProd18.getBackground().getGreen() + "','" + jBtnProd18.getBackground().getBlue() + "','" + jBtnProd18.getForeground().getRed() + "','" + jBtnProd18.getForeground().getGreen() + "','" + jBtnProd18.getForeground().getBlue() + "','" + jBtnProd18.getBounds().x + "','" + jBtnProd18.getBounds().y + "','" + jBtnProd18.getBounds().height + "','" + jBtnProd18.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 19:
                        if (jBtnProd19.isVisible()){
                            A = Integer.parseInt(jBtnProd19.getToolTipText().substring(0, jBtnProd19.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd19.getToolTipText().substring(jBtnProd19.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd19.getText().toUpperCase() + "','" + jBtnProd19.getBackground().getRed() + "','" + jBtnProd19.getBackground().getGreen() + "','" + jBtnProd19.getBackground().getBlue() + "','" + jBtnProd19.getForeground().getRed() + "','" + jBtnProd19.getForeground().getGreen() + "','" + jBtnProd19.getForeground().getBlue() + "','" + jBtnProd19.getBounds().x + "','" + jBtnProd19.getBounds().y + "','" + jBtnProd19.getBounds().height + "','" + jBtnProd19.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 20:
                        if (jBtnProd20.isVisible()){
                            A = Integer.parseInt(jBtnProd20.getToolTipText().substring(0, jBtnProd20.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd20.getToolTipText().substring(jBtnProd20.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd20.getText().toUpperCase() + "','" + jBtnProd20.getBackground().getRed() + "','" + jBtnProd20.getBackground().getGreen() + "','" + jBtnProd20.getBackground().getBlue() + "','" + jBtnProd20.getForeground().getRed() + "','" + jBtnProd20.getForeground().getGreen() + "','" + jBtnProd20.getForeground().getBlue() + "','" + jBtnProd20.getBounds().x + "','" + jBtnProd20.getBounds().y + "','" + jBtnProd20.getBounds().height + "','" + jBtnProd20.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 21:
                        if (jBtnProd21.isVisible()){
                            A = Integer.parseInt(jBtnProd21.getToolTipText().substring(0, jBtnProd21.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd21.getToolTipText().substring(jBtnProd21.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd21.getText().toUpperCase() + "','" + jBtnProd21.getBackground().getRed() + "','" + jBtnProd21.getBackground().getGreen() + "','" + jBtnProd21.getBackground().getBlue() + "','" + jBtnProd21.getForeground().getRed() + "','" + jBtnProd21.getForeground().getGreen() + "','" + jBtnProd21.getForeground().getBlue() + "','" + jBtnProd21.getBounds().x + "','" + jBtnProd21.getBounds().y + "','" + jBtnProd21.getBounds().height + "','" + jBtnProd21.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 22:
                        if (jBtnProd22.isVisible()){
                            A = Integer.parseInt(jBtnProd22.getToolTipText().substring(0, jBtnProd22.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd22.getToolTipText().substring(jBtnProd22.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd22.getText().toUpperCase() + "','" + jBtnProd22.getBackground().getRed() + "','" + jBtnProd22.getBackground().getGreen() + "','" + jBtnProd22.getBackground().getBlue() + "','" + jBtnProd22.getForeground().getRed() + "','" + jBtnProd22.getForeground().getGreen() + "','" + jBtnProd22.getForeground().getBlue() + "','" + jBtnProd22.getBounds().x + "','" + jBtnProd22.getBounds().y + "','" + jBtnProd22.getBounds().height + "','" + jBtnProd22.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 23:
                        if (jBtnProd23.isVisible()){
                            A = Integer.parseInt(jBtnProd23.getToolTipText().substring(0, jBtnProd23.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd23.getToolTipText().substring(jBtnProd23.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd23.getText().toUpperCase() + "','" + jBtnProd23.getBackground().getRed() + "','" + jBtnProd23.getBackground().getGreen() + "','" + jBtnProd23.getBackground().getBlue() + "','" + jBtnProd23.getForeground().getRed() + "','" + jBtnProd23.getForeground().getGreen() + "','" + jBtnProd23.getForeground().getBlue() + "','" + jBtnProd23.getBounds().x + "','" + jBtnProd23.getBounds().y + "','" + jBtnProd23.getBounds().height + "','" + jBtnProd23.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 24:
                        if (jBtnProd24.isVisible()){
                            A = Integer.parseInt(jBtnProd24.getToolTipText().substring(0, jBtnProd24.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd24.getToolTipText().substring(jBtnProd24.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd24.getText().toUpperCase() + "','" + jBtnProd24.getBackground().getRed() + "','" + jBtnProd24.getBackground().getGreen() + "','" + jBtnProd24.getBackground().getBlue() + "','" + jBtnProd24.getForeground().getRed() + "','" + jBtnProd24.getForeground().getGreen() + "','" + jBtnProd24.getForeground().getBlue() + "','" + jBtnProd24.getBounds().x + "','" + jBtnProd24.getBounds().y + "','" + jBtnProd24.getBounds().height + "','" + jBtnProd24.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 25:
                        if (jBtnProd25.isVisible()){
                            A = Integer.parseInt(jBtnProd25.getToolTipText().substring(0, jBtnProd25.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd25.getToolTipText().substring(jBtnProd25.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd25.getText().toUpperCase() + "','" + jBtnProd25.getBackground().getRed() + "','" + jBtnProd25.getBackground().getGreen() + "','" + jBtnProd25.getBackground().getBlue() + "','" + jBtnProd25.getForeground().getRed() + "','" + jBtnProd25.getForeground().getGreen() + "','" + jBtnProd25.getForeground().getBlue() + "','" + jBtnProd25.getBounds().x + "','" + jBtnProd25.getBounds().y + "','" + jBtnProd25.getBounds().height + "','" + jBtnProd25.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 26:
                        if (jBtnProd26.isVisible()){
                            A = Integer.parseInt(jBtnProd26.getToolTipText().substring(0, jBtnProd26.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd26.getToolTipText().substring(jBtnProd26.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd26.getText().toUpperCase() + "','" + jBtnProd26.getBackground().getRed() + "','" + jBtnProd26.getBackground().getGreen() + "','" + jBtnProd26.getBackground().getBlue() + "','" + jBtnProd26.getForeground().getRed() + "','" + jBtnProd26.getForeground().getGreen() + "','" + jBtnProd26.getForeground().getBlue() + "','" + jBtnProd26.getBounds().x + "','" + jBtnProd26.getBounds().y + "','" + jBtnProd26.getBounds().height + "','" + jBtnProd26.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 27:
                        if (jBtnProd27.isVisible()){
                            A = Integer.parseInt(jBtnProd27.getToolTipText().substring(0, jBtnProd27.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd27.getToolTipText().substring(jBtnProd27.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd27.getText().toUpperCase() + "','" + jBtnProd27.getBackground().getRed() + "','" + jBtnProd27.getBackground().getGreen() + "','" + jBtnProd27.getBackground().getBlue() + "','" + jBtnProd27.getForeground().getRed() + "','" + jBtnProd27.getForeground().getGreen() + "','" + jBtnProd27.getForeground().getBlue() + "','" + jBtnProd27.getBounds().x + "','" + jBtnProd27.getBounds().y + "','" + jBtnProd27.getBounds().height + "','" + jBtnProd27.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 28:
                        if (jBtnProd28.isVisible()){
                            A = Integer.parseInt(jBtnProd28.getToolTipText().substring(0, jBtnProd28.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd28.getToolTipText().substring(jBtnProd28.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd28.getText().toUpperCase() + "','" + jBtnProd28.getBackground().getRed() + "','" + jBtnProd28.getBackground().getGreen() + "','" + jBtnProd28.getBackground().getBlue() + "','" + jBtnProd28.getForeground().getRed() + "','" + jBtnProd28.getForeground().getGreen() + "','" + jBtnProd28.getForeground().getBlue() + "','" + jBtnProd28.getBounds().x + "','" + jBtnProd28.getBounds().y + "','" + jBtnProd28.getBounds().height + "','" + jBtnProd28.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 29:
                        if (jBtnProd29.isVisible()){
                            A = Integer.parseInt(jBtnProd29.getToolTipText().substring(0, jBtnProd29.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd29.getToolTipText().substring(jBtnProd29.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd29.getText().toUpperCase() + "','" + jBtnProd29.getBackground().getRed() + "','" + jBtnProd29.getBackground().getGreen() + "','" + jBtnProd29.getBackground().getBlue() + "','" + jBtnProd29.getForeground().getRed() + "','" + jBtnProd29.getForeground().getGreen() + "','" + jBtnProd29.getForeground().getBlue() + "','" + jBtnProd29.getBounds().x + "','" + jBtnProd29.getBounds().y + "','" + jBtnProd29.getBounds().height + "','" + jBtnProd29.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 30:
                        if (jBtnProd30.isVisible()){
                            A = Integer.parseInt(jBtnProd30.getToolTipText().substring(0, jBtnProd30.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd30.getToolTipText().substring(jBtnProd30.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd30.getText().toUpperCase() + "','" + jBtnProd30.getBackground().getRed() + "','" + jBtnProd30.getBackground().getGreen() + "','" + jBtnProd30.getBackground().getBlue() + "','" + jBtnProd30.getForeground().getRed() + "','" + jBtnProd30.getForeground().getGreen() + "','" + jBtnProd30.getForeground().getBlue() + "','" + jBtnProd30.getBounds().x + "','" + jBtnProd30.getBounds().y + "','" + jBtnProd30.getBounds().height + "','" + jBtnProd30.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 31:
                        if (jBtnProd31.isVisible()){
                            A = Integer.parseInt(jBtnProd31.getToolTipText().substring(0, jBtnProd31.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd31.getToolTipText().substring(jBtnProd31.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd31.getText().toUpperCase() + "','" + jBtnProd31.getBackground().getRed() + "','" + jBtnProd31.getBackground().getGreen() + "','" + jBtnProd31.getBackground().getBlue() + "','" + jBtnProd31.getForeground().getRed() + "','" + jBtnProd31.getForeground().getGreen() + "','" + jBtnProd31.getForeground().getBlue() + "','" + jBtnProd31.getBounds().x + "','" + jBtnProd31.getBounds().y + "','" + jBtnProd31.getBounds().height + "','" + jBtnProd31.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 32:
                        if (jBtnProd32.isVisible()){
                            A = Integer.parseInt(jBtnProd32.getToolTipText().substring(0, jBtnProd32.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd32.getToolTipText().substring(jBtnProd32.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd32.getText().toUpperCase() + "','" + jBtnProd32.getBackground().getRed() + "','" + jBtnProd32.getBackground().getGreen() + "','" + jBtnProd32.getBackground().getBlue() + "','" + jBtnProd32.getForeground().getRed() + "','" + jBtnProd32.getForeground().getGreen() + "','" + jBtnProd32.getForeground().getBlue() + "','" + jBtnProd32.getBounds().x + "','" + jBtnProd32.getBounds().y + "','" + jBtnProd32.getBounds().height + "','" + jBtnProd32.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 33:
                        if (jBtnProd33.isVisible()){
                            A = Integer.parseInt(jBtnProd33.getToolTipText().substring(0, jBtnProd33.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd33.getToolTipText().substring(jBtnProd33.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd33.getText().toUpperCase() + "','" + jBtnProd33.getBackground().getRed() + "','" + jBtnProd33.getBackground().getGreen() + "','" + jBtnProd33.getBackground().getBlue() + "','" + jBtnProd33.getForeground().getRed() + "','" + jBtnProd33.getForeground().getGreen() + "','" + jBtnProd33.getForeground().getBlue() + "','" + jBtnProd33.getBounds().x + "','" + jBtnProd33.getBounds().y + "','" + jBtnProd33.getBounds().height + "','" + jBtnProd33.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 34:
                        if (jBtnProd34.isVisible()){
                            A = Integer.parseInt(jBtnProd34.getToolTipText().substring(0, jBtnProd34.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd34.getToolTipText().substring(jBtnProd34.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd34.getText().toUpperCase() + "','" + jBtnProd34.getBackground().getRed() + "','" + jBtnProd34.getBackground().getGreen() + "','" + jBtnProd34.getBackground().getBlue() + "','" + jBtnProd34.getForeground().getRed() + "','" + jBtnProd34.getForeground().getGreen() + "','" + jBtnProd34.getForeground().getBlue() + "','" + jBtnProd34.getBounds().x + "','" + jBtnProd34.getBounds().y + "','" + jBtnProd34.getBounds().height + "','" + jBtnProd34.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 35:
                        if (jBtnProd35.isVisible()){
                            A = Integer.parseInt(jBtnProd35.getToolTipText().substring(0, jBtnProd35.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd35.getToolTipText().substring(jBtnProd35.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd35.getText().toUpperCase() + "','" + jBtnProd35.getBackground().getRed() + "','" + jBtnProd35.getBackground().getGreen() + "','" + jBtnProd35.getBackground().getBlue() + "','" + jBtnProd35.getForeground().getRed() + "','" + jBtnProd35.getForeground().getGreen() + "','" + jBtnProd35.getForeground().getBlue() + "','" + jBtnProd35.getBounds().x + "','" + jBtnProd35.getBounds().y + "','" + jBtnProd35.getBounds().height + "','" + jBtnProd35.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 36:
                        if (jBtnProd36.isVisible()){
                            A = Integer.parseInt(jBtnProd36.getToolTipText().substring(0, jBtnProd36.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd36.getToolTipText().substring(jBtnProd36.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd36.getText().toUpperCase() + "','" + jBtnProd36.getBackground().getRed() + "','" + jBtnProd36.getBackground().getGreen() + "','" + jBtnProd36.getBackground().getBlue() + "','" + jBtnProd36.getForeground().getRed() + "','" + jBtnProd36.getForeground().getGreen() + "','" + jBtnProd36.getForeground().getBlue() + "','" + jBtnProd36.getBounds().x + "','" + jBtnProd36.getBounds().y + "','" + jBtnProd36.getBounds().height + "','" + jBtnProd36.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 37:
                        if (jBtnProd37.isVisible()){
                            A = Integer.parseInt(jBtnProd37.getToolTipText().substring(0, jBtnProd37.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd37.getToolTipText().substring(jBtnProd37.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd37.getText().toUpperCase() + "','" + jBtnProd37.getBackground().getRed() + "','" + jBtnProd37.getBackground().getGreen() + "','" + jBtnProd37.getBackground().getBlue() + "','" + jBtnProd37.getForeground().getRed() + "','" + jBtnProd37.getForeground().getGreen() + "','" + jBtnProd37.getForeground().getBlue() + "','" + jBtnProd37.getBounds().x + "','" + jBtnProd37.getBounds().y + "','" + jBtnProd37.getBounds().height + "','" + jBtnProd37.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 38:
                        if (jBtnProd38.isVisible()){
                            A = Integer.parseInt(jBtnProd38.getToolTipText().substring(0, jBtnProd38.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd38.getToolTipText().substring(jBtnProd38.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd38.getText().toUpperCase() + "','" + jBtnProd38.getBackground().getRed() + "','" + jBtnProd38.getBackground().getGreen() + "','" + jBtnProd38.getBackground().getBlue() + "','" + jBtnProd38.getForeground().getRed() + "','" + jBtnProd38.getForeground().getGreen() + "','" + jBtnProd38.getForeground().getBlue() + "','" + jBtnProd38.getBounds().x + "','" + jBtnProd38.getBounds().y + "','" + jBtnProd38.getBounds().height + "','" + jBtnProd38.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 39:
                        if (jBtnProd39.isVisible()){
                            A = Integer.parseInt(jBtnProd39.getToolTipText().substring(0, jBtnProd39.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd39.getToolTipText().substring(jBtnProd39.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd39.getText().toUpperCase() + "','" + jBtnProd39.getBackground().getRed() + "','" + jBtnProd39.getBackground().getGreen() + "','" + jBtnProd39.getBackground().getBlue() + "','" + jBtnProd39.getForeground().getRed() + "','" + jBtnProd39.getForeground().getGreen() + "','" + jBtnProd39.getForeground().getBlue() + "','" + jBtnProd39.getBounds().x + "','" + jBtnProd39.getBounds().y + "','" + jBtnProd39.getBounds().height + "','" + jBtnProd39.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 40:
                        if (jBtnProd40.isVisible()){
                            A = Integer.parseInt(jBtnProd40.getToolTipText().substring(0, jBtnProd40.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd40.getToolTipText().substring(jBtnProd40.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd40.getText().toUpperCase() + "','" + jBtnProd40.getBackground().getRed() + "','" + jBtnProd40.getBackground().getGreen() + "','" + jBtnProd40.getBackground().getBlue() + "','" + jBtnProd40.getForeground().getRed() + "','" + jBtnProd40.getForeground().getGreen() + "','" + jBtnProd40.getForeground().getBlue() + "','" + jBtnProd40.getBounds().x + "','" + jBtnProd40.getBounds().y + "','" + jBtnProd40.getBounds().height + "','" + jBtnProd40.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 41:
                        if (jBtnProd41.isVisible()){
                            A = Integer.parseInt(jBtnProd41.getToolTipText().substring(0, jBtnProd41.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd41.getToolTipText().substring(jBtnProd41.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd41.getText().toUpperCase() + "','" + jBtnProd41.getBackground().getRed() + "','" + jBtnProd41.getBackground().getGreen() + "','" + jBtnProd41.getBackground().getBlue() + "','" + jBtnProd41.getForeground().getRed() + "','" + jBtnProd41.getForeground().getGreen() + "','" + jBtnProd41.getForeground().getBlue() + "','" + jBtnProd41.getBounds().x + "','" + jBtnProd41.getBounds().y + "','" + jBtnProd41.getBounds().height + "','" + jBtnProd41.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 42:
                        if (jBtnProd42.isVisible()){
                            A = Integer.parseInt(jBtnProd42.getToolTipText().substring(0, jBtnProd42.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd42.getToolTipText().substring(jBtnProd42.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd42.getText().toUpperCase() + "','" + jBtnProd42.getBackground().getRed() + "','" + jBtnProd42.getBackground().getGreen() + "','" + jBtnProd42.getBackground().getBlue() + "','" + jBtnProd42.getForeground().getRed() + "','" + jBtnProd42.getForeground().getGreen() + "','" + jBtnProd42.getForeground().getBlue() + "','" + jBtnProd42.getBounds().x + "','" + jBtnProd42.getBounds().y + "','" + jBtnProd42.getBounds().height + "','" + jBtnProd42.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 43:
                        if (jBtnProd43.isVisible()){
                            A = Integer.parseInt(jBtnProd43.getToolTipText().substring(0, jBtnProd43.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd43.getToolTipText().substring(jBtnProd43.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd43.getText().toUpperCase() + "','" + jBtnProd43.getBackground().getRed() + "','" + jBtnProd43.getBackground().getGreen() + "','" + jBtnProd43.getBackground().getBlue() + "','" + jBtnProd43.getForeground().getRed() + "','" + jBtnProd43.getForeground().getGreen() + "','" + jBtnProd43.getForeground().getBlue() + "','" + jBtnProd43.getBounds().x + "','" + jBtnProd43.getBounds().y + "','" + jBtnProd43.getBounds().height + "','" + jBtnProd43.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 44:
                        if (jBtnProd44.isVisible()){
                            A = Integer.parseInt(jBtnProd44.getToolTipText().substring(0, jBtnProd44.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd44.getToolTipText().substring(jBtnProd44.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd44.getText().toUpperCase() + "','" + jBtnProd44.getBackground().getRed() + "','" + jBtnProd44.getBackground().getGreen() + "','" + jBtnProd44.getBackground().getBlue() + "','" + jBtnProd44.getForeground().getRed() + "','" + jBtnProd44.getForeground().getGreen() + "','" + jBtnProd44.getForeground().getBlue() + "','" + jBtnProd44.getBounds().x + "','" + jBtnProd44.getBounds().y + "','" + jBtnProd44.getBounds().height + "','" + jBtnProd44.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 45:
                        if (jBtnProd45.isVisible()){
                            A = Integer.parseInt(jBtnProd45.getToolTipText().substring(0, jBtnProd45.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd45.getToolTipText().substring(jBtnProd45.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd45.getText().toUpperCase() + "','" + jBtnProd45.getBackground().getRed() + "','" + jBtnProd45.getBackground().getGreen() + "','" + jBtnProd45.getBackground().getBlue() + "','" + jBtnProd45.getForeground().getRed() + "','" + jBtnProd45.getForeground().getGreen() + "','" + jBtnProd45.getForeground().getBlue() + "','" + jBtnProd45.getBounds().x + "','" + jBtnProd45.getBounds().y + "','" + jBtnProd45.getBounds().height + "','" + jBtnProd45.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 46:
                        if (jBtnProd46.isVisible()){
                            A = Integer.parseInt(jBtnProd46.getToolTipText().substring(0, jBtnProd46.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd46.getToolTipText().substring(jBtnProd46.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd46.getText().toUpperCase() + "','" + jBtnProd46.getBackground().getRed() + "','" + jBtnProd46.getBackground().getGreen() + "','" + jBtnProd46.getBackground().getBlue() + "','" + jBtnProd46.getForeground().getRed() + "','" + jBtnProd46.getForeground().getGreen() + "','" + jBtnProd46.getForeground().getBlue() + "','" + jBtnProd46.getBounds().x + "','" + jBtnProd46.getBounds().y + "','" + jBtnProd46.getBounds().height + "','" + jBtnProd46.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 47:
                        if (jBtnProd47.isVisible()){
                            A = Integer.parseInt(jBtnProd47.getToolTipText().substring(0, jBtnProd47.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd47.getToolTipText().substring(jBtnProd47.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd47.getText().toUpperCase() + "','" + jBtnProd47.getBackground().getRed() + "','" + jBtnProd47.getBackground().getGreen() + "','" + jBtnProd47.getBackground().getBlue() + "','" + jBtnProd47.getForeground().getRed() + "','" + jBtnProd47.getForeground().getGreen() + "','" + jBtnProd47.getForeground().getBlue() + "','" + jBtnProd47.getBounds().x + "','" + jBtnProd47.getBounds().y + "','" + jBtnProd47.getBounds().height + "','" + jBtnProd47.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 48:
                        if (jBtnProd48.isVisible()){
                            A = Integer.parseInt(jBtnProd48.getToolTipText().substring(0, jBtnProd48.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd48.getToolTipText().substring(jBtnProd48.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd48.getText().toUpperCase() + "','" + jBtnProd48.getBackground().getRed() + "','" + jBtnProd48.getBackground().getGreen() + "','" + jBtnProd48.getBackground().getBlue() + "','" + jBtnProd48.getForeground().getRed() + "','" + jBtnProd48.getForeground().getGreen() + "','" + jBtnProd48.getForeground().getBlue() + "','" + jBtnProd48.getBounds().x + "','" + jBtnProd48.getBounds().y + "','" + jBtnProd48.getBounds().height + "','" + jBtnProd48.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 49:
                        if (jBtnProd49.isVisible()){
                            A = Integer.parseInt(jBtnProd49.getToolTipText().substring(0, jBtnProd49.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd49.getToolTipText().substring(jBtnProd49.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd49.getText().toUpperCase() + "','" + jBtnProd49.getBackground().getRed() + "','" + jBtnProd49.getBackground().getGreen() + "','" + jBtnProd49.getBackground().getBlue() + "','" + jBtnProd49.getForeground().getRed() + "','" + jBtnProd49.getForeground().getGreen() + "','" + jBtnProd49.getForeground().getBlue() + "','" + jBtnProd49.getBounds().x + "','" + jBtnProd49.getBounds().y + "','" + jBtnProd49.getBounds().height + "','" + jBtnProd49.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 50:
                        if (jBtnProd50.isVisible()){
                            A = Integer.parseInt(jBtnProd50.getToolTipText().substring(0, jBtnProd50.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd50.getToolTipText().substring(jBtnProd50.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd50.getText().toUpperCase() + "','" + jBtnProd50.getBackground().getRed() + "','" + jBtnProd50.getBackground().getGreen() + "','" + jBtnProd50.getBackground().getBlue() + "','" + jBtnProd50.getForeground().getRed() + "','" + jBtnProd50.getForeground().getGreen() + "','" + jBtnProd50.getForeground().getBlue() + "','" + jBtnProd50.getBounds().x + "','" + jBtnProd50.getBounds().y + "','" + jBtnProd50.getBounds().height + "','" + jBtnProd50.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 51:
                        if (jBtnProd51.isVisible()){
                            A = Integer.parseInt(jBtnProd51.getToolTipText().substring(0, jBtnProd51.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd51.getToolTipText().substring(jBtnProd51.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd51.getText().toUpperCase() + "','" + jBtnProd51.getBackground().getRed() + "','" + jBtnProd51.getBackground().getGreen() + "','" + jBtnProd51.getBackground().getBlue() + "','" + jBtnProd51.getForeground().getRed() + "','" + jBtnProd51.getForeground().getGreen() + "','" + jBtnProd51.getForeground().getBlue() + "','" + jBtnProd51.getBounds().x + "','" + jBtnProd51.getBounds().y + "','" + jBtnProd51.getBounds().height + "','" + jBtnProd51.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 52:
                        if (jBtnProd52.isVisible()){
                            A = Integer.parseInt(jBtnProd52.getToolTipText().substring(0, jBtnProd52.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd52.getToolTipText().substring(jBtnProd52.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd52.getText().toUpperCase() + "','" + jBtnProd52.getBackground().getRed() + "','" + jBtnProd52.getBackground().getGreen() + "','" + jBtnProd52.getBackground().getBlue() + "','" + jBtnProd52.getForeground().getRed() + "','" + jBtnProd52.getForeground().getGreen() + "','" + jBtnProd52.getForeground().getBlue() + "','" + jBtnProd52.getBounds().x + "','" + jBtnProd52.getBounds().y + "','" + jBtnProd52.getBounds().height + "','" + jBtnProd52.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 53:
                        if (jBtnProd53.isVisible()){
                            A = Integer.parseInt(jBtnProd53.getToolTipText().substring(0, jBtnProd53.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd53.getToolTipText().substring(jBtnProd53.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd53.getText().toUpperCase() + "','" + jBtnProd53.getBackground().getRed() + "','" + jBtnProd53.getBackground().getGreen() + "','" + jBtnProd53.getBackground().getBlue() + "','" + jBtnProd53.getForeground().getRed() + "','" + jBtnProd53.getForeground().getGreen() + "','" + jBtnProd53.getForeground().getBlue() + "','" + jBtnProd53.getBounds().x + "','" + jBtnProd53.getBounds().y + "','" + jBtnProd53.getBounds().height + "','" + jBtnProd53.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 54:
                        if (jBtnProd54.isVisible()){
                            A = Integer.parseInt(jBtnProd54.getToolTipText().substring(0, jBtnProd54.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd54.getToolTipText().substring(jBtnProd54.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd54.getText().toUpperCase() + "','" + jBtnProd54.getBackground().getRed() + "','" + jBtnProd54.getBackground().getGreen() + "','" + jBtnProd54.getBackground().getBlue() + "','" + jBtnProd54.getForeground().getRed() + "','" + jBtnProd54.getForeground().getGreen() + "','" + jBtnProd54.getForeground().getBlue() + "','" + jBtnProd54.getBounds().x + "','" + jBtnProd54.getBounds().y + "','" + jBtnProd54.getBounds().height + "','" + jBtnProd54.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 55:
                        if (jBtnProd55.isVisible()){
                            A = Integer.parseInt(jBtnProd55.getToolTipText().substring(0, jBtnProd55.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd55.getToolTipText().substring(jBtnProd55.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd55.getText().toUpperCase() + "','" + jBtnProd55.getBackground().getRed() + "','" + jBtnProd55.getBackground().getGreen() + "','" + jBtnProd55.getBackground().getBlue() + "','" + jBtnProd55.getForeground().getRed() + "','" + jBtnProd55.getForeground().getGreen() + "','" + jBtnProd55.getForeground().getBlue() + "','" + jBtnProd55.getBounds().x + "','" + jBtnProd55.getBounds().y + "','" + jBtnProd55.getBounds().height + "','" + jBtnProd55.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 56:
                        if (jBtnProd56.isVisible()){
                            A = Integer.parseInt(jBtnProd56.getToolTipText().substring(0, jBtnProd56.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd56.getToolTipText().substring(jBtnProd56.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd56.getText().toUpperCase() + "','" + jBtnProd56.getBackground().getRed() + "','" + jBtnProd56.getBackground().getGreen() + "','" + jBtnProd56.getBackground().getBlue() + "','" + jBtnProd56.getForeground().getRed() + "','" + jBtnProd56.getForeground().getGreen() + "','" + jBtnProd56.getForeground().getBlue() + "','" + jBtnProd56.getBounds().x + "','" + jBtnProd56.getBounds().y + "','" + jBtnProd56.getBounds().height + "','" + jBtnProd56.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 57:
                        if (jBtnProd57.isVisible()){
                            A = Integer.parseInt(jBtnProd57.getToolTipText().substring(0, jBtnProd57.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd57.getToolTipText().substring(jBtnProd57.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd57.getText().toUpperCase() + "','" + jBtnProd57.getBackground().getRed() + "','" + jBtnProd57.getBackground().getGreen() + "','" + jBtnProd57.getBackground().getBlue() + "','" + jBtnProd57.getForeground().getRed() + "','" + jBtnProd57.getForeground().getGreen() + "','" + jBtnProd57.getForeground().getBlue() + "','" + jBtnProd57.getBounds().x + "','" + jBtnProd57.getBounds().y + "','" + jBtnProd57.getBounds().height + "','" + jBtnProd57.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 58:
                        if (jBtnProd58.isVisible()){
                            A = Integer.parseInt(jBtnProd58.getToolTipText().substring(0, jBtnProd58.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd58.getToolTipText().substring(jBtnProd58.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd58.getText().toUpperCase() + "','" + jBtnProd58.getBackground().getRed() + "','" + jBtnProd58.getBackground().getGreen() + "','" + jBtnProd58.getBackground().getBlue() + "','" + jBtnProd58.getForeground().getRed() + "','" + jBtnProd58.getForeground().getGreen() + "','" + jBtnProd58.getForeground().getBlue() + "','" + jBtnProd58.getBounds().x + "','" + jBtnProd58.getBounds().y + "','" + jBtnProd58.getBounds().height + "','" + jBtnProd58.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 59:
                        if (jBtnProd59.isVisible()){
                            A = Integer.parseInt(jBtnProd59.getToolTipText().substring(0, jBtnProd59.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd59.getToolTipText().substring(jBtnProd59.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd59.getText().toUpperCase() + "','" + jBtnProd59.getBackground().getRed() + "','" + jBtnProd59.getBackground().getGreen() + "','" + jBtnProd59.getBackground().getBlue() + "','" + jBtnProd59.getForeground().getRed() + "','" + jBtnProd59.getForeground().getGreen() + "','" + jBtnProd59.getForeground().getBlue() + "','" + jBtnProd59.getBounds().x + "','" + jBtnProd59.getBounds().y + "','" + jBtnProd59.getBounds().height + "','" + jBtnProd59.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 60:
                        if (jBtnProd60.isVisible()){
                            A = Integer.parseInt(jBtnProd60.getToolTipText().substring(0, jBtnProd60.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd60.getToolTipText().substring(jBtnProd60.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd60.getText().toUpperCase() + "','" + jBtnProd60.getBackground().getRed() + "','" + jBtnProd60.getBackground().getGreen() + "','" + jBtnProd60.getBackground().getBlue() + "','" + jBtnProd60.getForeground().getRed() + "','" + jBtnProd60.getForeground().getGreen() + "','" + jBtnProd60.getForeground().getBlue() + "','" + jBtnProd60.getBounds().x + "','" + jBtnProd60.getBounds().y + "','" + jBtnProd60.getBounds().height + "','" + jBtnProd60.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 61:
                        if (jBtnProd61.isVisible()){
                            A = Integer.parseInt(jBtnProd61.getToolTipText().substring(0, jBtnProd61.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd61.getToolTipText().substring(jBtnProd61.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd61.getText().toUpperCase() + "','" + jBtnProd61.getBackground().getRed() + "','" + jBtnProd61.getBackground().getGreen() + "','" + jBtnProd61.getBackground().getBlue() + "','" + jBtnProd61.getForeground().getRed() + "','" + jBtnProd61.getForeground().getGreen() + "','" + jBtnProd61.getForeground().getBlue() + "','" + jBtnProd61.getBounds().x + "','" + jBtnProd61.getBounds().y + "','" + jBtnProd61.getBounds().height + "','" + jBtnProd61.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 62:
                        if (jBtnProd62.isVisible()){
                            A = Integer.parseInt(jBtnProd62.getToolTipText().substring(0, jBtnProd62.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd62.getToolTipText().substring(jBtnProd62.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd62.getText().toUpperCase() + "','" + jBtnProd62.getBackground().getRed() + "','" + jBtnProd62.getBackground().getGreen() + "','" + jBtnProd62.getBackground().getBlue() + "','" + jBtnProd62.getForeground().getRed() + "','" + jBtnProd62.getForeground().getGreen() + "','" + jBtnProd62.getForeground().getBlue() + "','" + jBtnProd62.getBounds().x + "','" + jBtnProd62.getBounds().y + "','" + jBtnProd62.getBounds().height + "','" + jBtnProd62.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 63:
                        if (jBtnProd63.isVisible()){
                            A = Integer.parseInt(jBtnProd63.getToolTipText().substring(0, jBtnProd63.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd63.getToolTipText().substring(jBtnProd63.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd63.getText().toUpperCase() + "','" + jBtnProd63.getBackground().getRed() + "','" + jBtnProd63.getBackground().getGreen() + "','" + jBtnProd63.getBackground().getBlue() + "','" + jBtnProd63.getForeground().getRed() + "','" + jBtnProd63.getForeground().getGreen() + "','" + jBtnProd63.getForeground().getBlue() + "','" + jBtnProd63.getBounds().x + "','" + jBtnProd63.getBounds().y + "','" + jBtnProd63.getBounds().height + "','" + jBtnProd63.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 64:
                        if (jBtnProd64.isVisible()){
                            A = Integer.parseInt(jBtnProd64.getToolTipText().substring(0, jBtnProd64.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd64.getToolTipText().substring(jBtnProd64.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd64.getText().toUpperCase() + "','" + jBtnProd64.getBackground().getRed() + "','" + jBtnProd64.getBackground().getGreen() + "','" + jBtnProd64.getBackground().getBlue() + "','" + jBtnProd64.getForeground().getRed() + "','" + jBtnProd64.getForeground().getGreen() + "','" + jBtnProd64.getForeground().getBlue() + "','" + jBtnProd64.getBounds().x + "','" + jBtnProd64.getBounds().y + "','" + jBtnProd64.getBounds().height + "','" + jBtnProd64.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                    case 65:
                        if (jBtnProd65.isVisible()){
                            A = Integer.parseInt(jBtnProd65.getToolTipText().substring(0, jBtnProd65.getToolTipText().indexOf(",")));
                            B = Integer.parseInt(jBtnProd65.getToolTipText().substring(jBtnProd65.getToolTipText().indexOf(" ") + 1));
                            DB.Insert("INSERT INTO PDV VALUES (NULL,'" + jBtnProd65.getText().toUpperCase() + "','" + jBtnProd65.getBackground().getRed() + "','" + jBtnProd65.getBackground().getGreen() + "','" + jBtnProd65.getBackground().getBlue() + "','" + jBtnProd65.getForeground().getRed() + "','" + jBtnProd65.getForeground().getGreen() + "','" + jBtnProd65.getForeground().getBlue() + "','" + jBtnProd65.getBounds().x + "','" + jBtnProd65.getBounds().y + "','" + jBtnProd65.getBounds().height + "','" + jBtnProd65.getBounds().width + "', NULL, '" + A + "', 1, 1,'" + B + "');");
                        }
                        break;
                }
            }
            JOptionPane.showMessageDialog(null, "El POS se cerrara para completar la tarea", "Cerrando", JOptionPane.INFORMATION_MESSAGE, Icono);
            System.exit(0);
        } else if (e.getSource() == jBtnColorB){
            ColB = JColorChooser.showDialog(null, "Seleccione un color para el fondo", Color.gray);
            jBtnColorB.setBackground(ColB);
        } else if (e.getSource() == jBtnColorL){
            ColL = JColorChooser.showDialog(null, "Seleccione un color para la letra", Color.gray);
            jBtnColorL.setBackground(ColL);
        } else if (e.getSource() == jBtnCambiarImg){
            JFileChooser file = new JFileChooser();
            file.setApproveButtonText("Cambiar");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "PNG");
            file.setFileFilter(filtro);
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int oclx = file.showOpenDialog(file);
            if (oclx == JFileChooser.APPROVE_OPTION){
                try {
                    File inFile = new File(file.getSelectedFile().toString());
                    File outFile = new File(Path + "Company.zabavy");
                    FileInputStream in = new FileInputStream(inFile);
                    FileOutputStream out = new FileOutputStream(outFile);
                    int c;
                    while((c = in.read()) != -1) out.write(c);
                    in.close();
                    out.close();
                } catch (IOException ex){}
                Icono = new ImageIcon(Path + "Company.zabavy");
                Icon = new ImageIcon(Icono.getImage().getScaledInstance(jLblCompany.getWidth(), jLblCompany.getHeight(), Image.SCALE_DEFAULT));
                jLblCompany.setIcon(Icon);
                Icono  =  new ImageIcon(Path + "Error.zabavy");
            }
        }
    }  
}