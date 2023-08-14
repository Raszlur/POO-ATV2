package graphics;
import javax.swing.*;





public class ATextField extends JTextField
{
      public int TF_XPOS;
      public int TF_YPOS;
      public int TF_WIDTH;
      public int TF_HEIGHT;
      
      public ATextField ( int X , int Y , int Width , int Height )
      {
            this.TF_XPOS = X;
            this.TF_YPOS = Y;
            this.TF_HEIGHT = Height;
            this.TF_WIDTH = Width;
            
            this.setBounds ( this.TF_XPOS , this.TF_YPOS , this.TF_WIDTH , this.TF_HEIGHT  );
      }
      
}
