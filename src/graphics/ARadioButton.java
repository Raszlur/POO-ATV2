package graphics;
import javax.swing.*;
import java.awt.*;


public class ARadioButton extends JRadioButton
{
      public String COMBO_TEXT;
      public int COMBO_XPOS;
      public int COMBO_YPOS;
      public int COMBO_WIDTH;
      public int COMBO_HEIGHT;
      public Font COMBO_FONTE;
      
      public ARadioButton ( String Text , int X , int Y , int Width , int Height , Font Fonte )
      {
            this.COMBO_TEXT = Text;
            this.COMBO_XPOS = X;
            this.COMBO_YPOS = Y;
            this.COMBO_WIDTH = Width;
            this.COMBO_HEIGHT = Height;
            this.COMBO_FONTE = Fonte;
            
            this.setFont ( this.COMBO_FONTE );
            this.setText ( this.COMBO_TEXT );
            
            this.setFocusable ( false );
            this.setOpaque ( false );
            
            this.setHorizontalTextPosition ( JRadioButton.RIGHT );
            
            this.setBounds ( this.COMBO_XPOS , this.COMBO_YPOS , this.COMBO_WIDTH , this.COMBO_HEIGHT );
      }
      public ARadioButton () {}
}
