package interfaces.dialogs;

import data.acess;
import graphics.AButton;
import graphics.ALabel;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.admin.RLoader;
import interfaces.cdap.CLoader;
import interfaces.menu.MLoader;
import interfaces.user.OLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class RegisterAcessDialog extends AWindow
{
      
      public acess here = new acess ();
      
      public ALabel text = new ALabel
                   (
                                " ADMINISTRAÇÃO " ,
                                35 , 10 , 260 , 100 ,
                                new Font( "Consolas" , Font . BOLD , 24 )
                   );
      
      public ALabel text1 = new ALabel
                   (
                                " Insira a senha de acesso: " ,
                                30 , 20 , 270 , 200 ,
                                new Font ( "Consolas" , Font . BOLD , 18 )
                   );
      
      public JPasswordField valid = new JPasswordField ();
      
      public AButton btn_check = new AButton
                   (
                                "Acessar" ,
                                10 , 210 , 310 , 60,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public AButton btn_return = new AButton
                   (
                                "Voltar" ,
                                10 , 280 , 310 , 60,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public RegisterAcessDialog() throws IOException, ClassNotFoundException {
            super ("CDAP - Login" , 350 , 400 , MLoader. BKG );
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
            this.setIconImage (CLoader. frame_logo .getImage () );
            this.setCursor (Curs. CURSORDefault);
            this.setLocationRelativeTo ( null );

            this . text . setForeground ( new Color (255, 255, 255) );
            this . text . setVisible ( true );
            this.add ( text );
            
            this . text1 . setForeground ( new Color (255, 255, 255) );
            this . text1 . setVisible ( true );
            this.add ( text1 );
            
            this . btn_check . setForeground ( new Color (255, 255, 255) );
            this . btn_check . setBackground ( new Color (38, 36, 36) );
            this . btn_check . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            this . btn_check . setVisible ( true );
            this . btn_check . addActionListener ( this );
            this.add ( btn_check );
            
            this . btn_return . setForeground ( new Color (255, 255, 255) );
            this . btn_return . setBackground ( new Color (38, 36, 36) );
            this . btn_return . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            this . btn_return . setVisible ( true );
            this . btn_return . addActionListener ( this );
            this.add ( btn_return );
            
            this.  valid . setForeground ( RLoader . FRG );
            this.  valid . setBounds ( 10 , 140 , 310 , 60 );
            this . valid . setBackground ( RLoader . BK2 );
            this . valid . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 )  );
            this . valid . setHorizontalAlignment ( JTextField.CENTER );
            this . valid . setFont ( new Font ( "Consolas" , Font.PLAIN , 18 ) );
            this . valid . setCaretColor ( new Color (244, 255, 0 ) );
            
            this . valid . addActionListener ( this );
            this.add ( valid );
            
            this . btn_return . addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  btn_return . setBorder ( BorderFactory.createLineBorder ( MLoader . BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  btn_return . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter. acessRegisterDialog . dispose ();
                                                  Linter. adminDialog . build ();
                                                  Linter. adminDialog . run   ();
                                            }
                                      }
                         );
            
            this . btn_check . addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  btn_check . setBorder ( BorderFactory.createLineBorder ( MLoader . BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  btn_check . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                            
                                            }
                                      }
                         );
            
            
            
            // Carregar o objeto acess do arquivo acess.ser
            FileInputStream fileIn = null;
            ObjectInput in;
            
            try {
                  fileIn = new FileInputStream("src//data//acess.ser");
                  in = new ObjectInputStream(fileIn);
                  here = (acess) in.readObject();
                  in.close();
                  fileIn.close();
            } catch (FileNotFoundException e) {
                  System.out.println("Arquivo 'acess' não encontrado.");
            } catch (IOException e) {
                  System.out.println("Erro de I/O ao ler o arquivo 'acess.ser'.");
            } catch (ClassNotFoundException e) {
                  System.out.println("Classe 'acess' não encontrada durante a desserialização.");
            }
            
      }
      
      public void build ()
      {
            System.out.println ("* Final Login");
      }
      
      public void run ()
      {
            
            this.setVisible ( true );
      }
      @Override public void actionPerformed ( ActionEvent e )
      {
            if (e.getSource() == btn_check) {
                  char[] pass1 = valid.getPassword();
                  String pass2 = new String(pass1);
                  
                  if (pass2 != null && pass2.equals(here.password)) {
                        valid.setText("");
                        Linter.acessRegisterDialog.dispose();
                        Linter.registerGraph.build();
                        Linter.registerGraph.run();
                  }
            }
      }
}
