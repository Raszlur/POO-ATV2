package graphics;
import javax.swing.*;
import java.awt.*;


public class APanel extends JPanel
{
      public int PANEL_XPOS;
      public int PANEL_YPOS;
      public int PANEL_WIDTH;
      public int PANEL_HEIGHT;
      
      public APanel ( int X , int Y , int Width , int Height )
      {
            this.PANEL_XPOS = X;
            this.PANEL_YPOS = Y;
            this.PANEL_WIDTH = Width;
            this.PANEL_HEIGHT = Height;
            
            this.setLayout ( new BorderLayout () );
            this.setBounds ( this.PANEL_XPOS , this.PANEL_YPOS , this.PANEL_WIDTH , this.PANEL_HEIGHT );
      }
      public APanel ( BorderLayout borderLayout ) {}
      public APanel ( ) {}
      
      public void addIMG ( ImageIcon image )
      {
            JLabel imageLabel = new JLabel ( image );
            this . add ( imageLabel , BorderLayout . CENTER );
            this . revalidate();
            this . repaint();
      }
      public void removeIMG ()
      {
            Component [] components = this . getComponents ();
            
            for ( Component component : components )
               if ( component instanceof JLabel )
                 this . remove ( component );
            
            this . revalidate();
            this . repaint();
      }
}
