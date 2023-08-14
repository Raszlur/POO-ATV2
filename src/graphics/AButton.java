package graphics;
import javax.swing.*;
import java.awt.*;





public class AButton extends JButton
{
      public String BUTTON_TEXT;
      public int BUTTON_XPOS;
      public int BUTTON_YPOS;
      public int BUTTON_WIDTH;
      public int BUTTON_HEIGHT;
      public Font BUTTON_FONT;
      public Color BUTTON_FOREGROUND_COLOR;
      public Color BUTTON_BACKGROUND_COLOR;
      
      
      public AButton ( String Text , int X , int Y , int Width , int Height , Font Fonte )
      {
            this.BUTTON_TEXT = Text;
            this.BUTTON_WIDTH = Width;
            this.BUTTON_HEIGHT = Height;
            this.BUTTON_XPOS = X;
            this.BUTTON_YPOS = Y;
            this.BUTTON_FONT = Fonte;
            
            this.setText ( this.BUTTON_TEXT );
            this.setFont ( this.BUTTON_FONT );
               
            this.setHorizontalAlignment ( JButton.CENTER );
            this.setVerticalAlignment ( JButton.CENTER );
               
            this.setFocusable ( false );
            
            this.setBounds ( this.BUTTON_XPOS , this.BUTTON_YPOS , this.BUTTON_WIDTH , this.BUTTON_HEIGHT );
      }
      public AButton () {}
}
