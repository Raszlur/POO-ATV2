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

public class ClosedDayDialog extends AWindow
{
      public ALabel text = new ALabel
                   (
                                "CDAP" ,
                                10 , 10 , 260 , 100 ,
                                new Font ( "Consolas" , Font . BOLD , 24 )
                   );
      
      public ALabel text1 = new ALabel
                   (
                                "O CDAP ESTÁ FECHADO" ,
                                40 , 10 , 200 , 200 ,
                                new Font ( "Consolas" , Font . BOLD , 18 )
                   );
      
      public ALabel text2 = new ALabel
                   (
                                "Venha durante segunda até sexta" ,
                                40 , 40 , 200 , 200 ,
                                new Font ( "Consolas" , Font . BOLD , 18 )
                   );
      
      public AButton btn = new AButton
                   (
                                "Voltar" ,
                                40 , 180 , 200 , 60 ,
                                new Font ( "Consolas" , Font.BOLD , 24 )
                   );
      
      public ClosedDayDialog ()
      {
            super ("CDAP - Fechado" , 300 , 300 , MLoader. BKG );
            
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
            
            this . text2 . setForeground ( new Color (255, 255, 255) );
            this . text2 . setVisible ( true );
            this.add ( text2 );
            
            this . btn . setForeground ( new Color (255, 255, 255) );
            this . btn . setBackground ( new Color (38, 36, 36) );
            this . btn . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
            this . btn . setVisible ( true );
            this . btn . addActionListener ( this );
            this.add ( btn );
            
            
            this . btn . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  btn . setBorder ( BorderFactory.createLineBorder ( MLoader . BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  btn . setBorder ( BorderFactory.createLineBorder ( MLoader . BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter . orderGraph . dispose ();
                                                  Linter . donthave . dispose ();
                                                  Linter . mainGraph . build ();
                                                  try {
                                                        Linter . mainGraph . run ();
                                                  } catch (IOException | ClassNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                            }
                                      }
                         );
      }
      
      public void build ()
      {
            System.out.println (" * Dialógo caso o dia seja diferente de 1 até 7");
      }
      
      public void run ()
      {

            this.setVisible ( true );
      }
      
      @Override public void actionPerformed ( ActionEvent e )
      {
      }
}
