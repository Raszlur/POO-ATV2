package graphics;
import javax.swing.*;
import java.awt.*;


public class AComboBox extends JComboBox
{
      public int COMBO_XPOS;
      public int COMBO_YPOS;
      public int COMBO_WIDTH;
      public int COMBO_HEIGHT;
      
      public Font COMBO_FONTE;
      
      public AComboBox ( String Text , int X , int Y , int Width , int Height , Font Fonte )
      {
            this.COMBO_XPOS = X;
            this.COMBO_YPOS = Y;
            this.COMBO_FONTE = Fonte;
            this.COMBO_WIDTH = Width;
            this.COMBO_HEIGHT = Height;
            
            this.setLayout ( null );
            
            this.setAlignmentX ( JComboBox.CENTER_ALIGNMENT );
            this.setAlignmentY ( JComboBox.CENTER_ALIGNMENT );
            
            this.setFont ( COMBO_FONTE );
            this.setBounds ( this.COMBO_XPOS , this.COMBO_XPOS , COMBO_WIDTH , COMBO_HEIGHT );
      }
      public AComboBox () {}
}
