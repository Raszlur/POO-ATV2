package graphics;
import javax.swing.*;
import java.awt.*;





public class ALabel extends JLabel
{
      public String LABEL_TEXT;
      
      public int LABEL_WIDTH;
      public int LABEL_HEIGHT;
      public int LABEL_XPOS;
      public int LABEL_YPOS;
      public Font LABEL_FONT;
      
      public ALabel ( String Text , int x , int y , int Width , int Height , Font Fonte )
      {
            this.LABEL_TEXT = Text;
            this.LABEL_WIDTH = Width;
            this.LABEL_HEIGHT = Height;
            this.LABEL_XPOS = x;
            this.LABEL_YPOS = y;
            this.LABEL_FONT = Fonte;
            
            this.setText ( this.LABEL_TEXT );
            this.setBounds ( this.LABEL_XPOS , this.LABEL_YPOS , this.LABEL_WIDTH , this.LABEL_HEIGHT );
            
            this.setFont ( this.LABEL_FONT );
            
            this.setVerticalAlignment ( JLabel.CENTER );
            this.setHorizontalAlignment ( JLabel.CENTER );
            this.setHorizontalTextPosition ( JLabel.CENTER );
            this.setVerticalTextPosition ( JLabel.CENTER );
      }
      public ALabel () {}
      
}
