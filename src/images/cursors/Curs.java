package images.cursors;

import java.awt.*;

public class Curs
{
      static Toolkit tkit = Toolkit . getDefaultToolkit ();
      static Point point = new Point (0 ,0 );
      
      static Image CUR_Def = tkit.getImage ("src//images//cursors//cursor_def.png");
      static Image CUR_Hov = tkit.getImage ("src//images//cursors//cursor_hov.png");
      
      public static Cursor CURSORDefault = tkit.createCustomCursor ( CUR_Def , point, "DEF" );
      public static Cursor CURSORHover = tkit.createCustomCursor ( CUR_Hov , point, "HOV" );
}
