package graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public abstract class AWindow extends JFrame implements ActionListener
{
      public String WINDOW_TITLE;
      public int WINDOW_WIDTH;
      public int WINDOW_HEIGHT;
      public Color WINDOW_BACKGROUND_COLOR;
      public JLayeredPane WINDOW_PANE;
      
      
      protected AWindow ( String Title , int Width , int Height , Color Background )
      {
               this.WINDOW_TITLE  = Title;
               this.WINDOW_WIDTH  = Width;
               this.WINDOW_HEIGHT = Height;
               this.WINDOW_BACKGROUND_COLOR = Background;
               this.WINDOW_PANE = new JLayeredPane ();
            
               this.setLayout ( null );
               this.setResizable ( false );
               this.setSize ( this.WINDOW_WIDTH , this.WINDOW_HEIGHT );
               this.setTitle ( this.WINDOW_TITLE );
               this.getContentPane () . setBackground ( this.WINDOW_BACKGROUND_COLOR );
      }
      protected AWindow () {}
}
