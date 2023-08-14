package interfaces.dialogs;

import graphics.AButton;
import graphics.ALabel;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.cdap.CLoader;
import interfaces.menu.MLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AdminDialog extends AWindow
{
      public ALabel text = new ALabel
                   (
                                " ADMINISTRAÇÃO " ,
                                10 , 10 , 260 , 100 ,
                                new Font ( "Consolas" , Font . BOLD , 24 )
                   );
      
      public ALabel text1 = new ALabel
                   (
                                " O que você deseja fazer?" ,
                                10 , 20 , 250 , 200 ,
                                new Font ( "Consolas" , Font . BOLD , 18 )
                   );
      
      
      public AButton btn_login = new AButton
                   (
                                "Fazer o login" ,
                                40 , 180 , 200 , 60 ,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public AButton btn_remake = new AButton
                   (
                                "Nova Senha" ,
                                40 , 260 , 200 , 60 ,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public AButton btn_return = new AButton
                   (
                                "Voltar" ,
                                40 , 340 , 200 , 60 ,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public AdminDialog()
      {
            super ("CDAP - Login" , 300 , 470 , MLoader. BKG );
            
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
            
            
            this . btn_return . setForeground ( new Color (255, 255, 255) );
            this . btn_return . setBackground ( new Color (38, 36, 36) );
            this . btn_return . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
            this . btn_return . setVisible ( true );
            this . btn_return . addActionListener ( this );
            this.add ( btn_return );
            
            this . btn_login . setForeground ( new Color (255, 255, 255) );
            this . btn_login . setBackground ( new Color (38, 36, 36) );
            this . btn_login . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
            this . btn_login . setVisible ( true );
            this . btn_login . addActionListener ( this );
            this.add ( btn_login );
            
            this . btn_remake . setForeground ( new Color (255, 255, 255) );
            this . btn_remake . setBackground ( new Color (38, 36, 36) );
            this . btn_remake . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
            this . btn_remake . setVisible ( true );
            this . btn_remake . addActionListener ( this );
            this.add ( btn_remake );
            
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
                                                  Linter. adminDialog . dispose ();
                                                  Linter. mainGraph . build ();
                                                  try {
                                                        Linter. mainGraph . run ();
                                                  } catch (IOException | ClassNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                            }
                                      }
                         );
            
            this . btn_login . addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  btn_login . setBorder ( BorderFactory.createLineBorder ( MLoader . BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  btn_login . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter. adminDialog . dispose ();
                                                  Linter. acessRegisterDialog . build ();
                                                  Linter. acessRegisterDialog . run   ();
                                            }
                                      }
                         );
            
            this . btn_remake . addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  btn_remake . setBorder ( BorderFactory.createLineBorder ( MLoader . BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  btn_remake . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter. adminDialog . dispose ();
                                                  Linter. remakePassDialog . build ();
                                                  Linter. remakePassDialog . run   ();
                                            }
                                      }
                         );
            
            
            
            
      }
      
      public void build ()
      {
            System.out.println ("BOTÃO DE ADMIN");
      }
      
      public void run ()
      {
            this.setVisible ( true );
      }
      
      
      @Override public void actionPerformed ( ActionEvent e )
      {
      }
}
