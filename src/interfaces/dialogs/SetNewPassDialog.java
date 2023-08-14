package interfaces.dialogs;

import data.acess;
import graphics.AButton;
import graphics.ALabel;
import graphics.ATextField;
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


public class SetNewPassDialog extends AWindow
{
      
      public acess hitcher = new acess ();
      
      public ALabel text = new ALabel
                   (
                                " ADMINISTRAÇÃO " ,
                                35 , 10 , 260 , 100 ,
                                new Font( "Consolas" , Font . BOLD , 24 )
                   );
      
      public ALabel text1 = new ALabel
                   (
                                " Insira a nova senha: " ,
                                30 , 20 , 270 , 200 ,
                                new Font ( "Consolas" , Font . BOLD , 18 )
                   );
      
      public ATextField valid = new ATextField
                   (
                                10 , 140 , 310 , 60
                   );
      
      public AButton btn_check = new AButton
                   (
                                "Checar" ,
                                10 , 210 , 310 , 60,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public AButton btn_return = new AButton
                   (
                                "Voltar" ,
                                10 , 280 , 310 , 60,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public SetNewPassDialog()
      {
            super ("CDAP - Nova Senha" , 350 , 400 , MLoader. BKG );
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
            this.setIconImage ( CLoader. frame_logo .getImage () );
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
            
            this.  valid . setForeground ( RLoader. FRG );
            this . valid . setBackground ( RLoader . BK2 );
            this . valid . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 )  );
            this . valid . setHorizontalAlignment ( JTextField.CENTER );
            this . valid . setFont ( new Font ( "Consolas" , Font.PLAIN , 18 ) );
            this . valid . setCaretColor ( new Color (244, 255, 0 ) );
            
            this . valid . addActionListener ( this );
            this.add ( RLoader . TX_ITEMPRICE );
            this.add ( valid );
            
            this.btn_return.addMouseListener
                         (
                                      new MouseAdapter() {
                                            @Override
                                            public void mouseEntered(MouseEvent e) {
                                                  btn_return.setBorder(BorderFactory.createLineBorder(MLoader.BR2, 3));
                                            }
                                            
                                            @Override
                                            public void mouseExited(MouseEvent e) {
                                                  btn_return.setBorder(BorderFactory.createLineBorder(MLoader.BRD, 3));
                                            }
                                            
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                  Linter.novonome.dispose();
                                                  Linter.adminDialog.build();
                                                  Linter.adminDialog.run();
                                            }
                                      }
                         );
            
            this.btn_check.addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override
                                            public void mouseEntered(MouseEvent e) {
                                                  btn_check.setBorder(BorderFactory.createLineBorder(MLoader.BR2, 3));
                                            }
                                            
                                            @Override
                                            public void mouseExited(MouseEvent e) {
                                                  btn_check.setBorder(BorderFactory.createLineBorder(MLoader.BRD, 3));
                                            }
                                            
                                            @Override
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                  hitcher . password = valid . getText ();
                                                  
                                                  
                                                  FileOutputStream fileSave;
                                                  try {
                                                        fileSave = new FileOutputStream( "src//data//acess.ser" );
                                                  } catch (FileNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  ObjectOutput fileOut;
                                                  try {
                                                        fileOut = new ObjectOutputStream( fileSave );
                                                  } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  
                                                  try {
                                                        fileOut.writeObject ( hitcher );
                                                  } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  try {
                                                        fileOut.close ();
                                                  } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  try {
                                                        fileSave.close ();
                                                  } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  
                                                  Linter. novonome . dispose ();
                                                  System.exit ( 0 );
                                            }
                                      }
                         
                         );
      }
      
      public void build ()
      {
            System.out.println ("*");
      }
      
      public void run () {

            this.setVisible ( true );
      }
      
      
      @Override public void actionPerformed ( ActionEvent e )
      {
      }
}

