package interfaces.menu;
import graphics.AButton;
import graphics.ALabel;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;





public class MLoader
{
      // IMAGES
      public static ImageIcon adm_logo = new ImageIcon ( "src//images//menu//adm.png" );
      public static ImageIcon ufj_logo = new ImageIcon ( "src//images//menu//ufj.png" );
      public static ImageIcon info_logo = new ImageIcon ( "src//images//menu//info.png" );
      public static ImageIcon frame_logo = new ImageIcon ( "src//images//icon.png" );
      
      public static ImageIcon INFO = new ImageIcon ();
      
      
      
      
      
      // BUTTONS
      
      public static AButton BTN_Cdap = new AButton
      (
            "CARDÁPIO" ,
            310 , 150 , 280 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      
      public static AButton BTN_Order = new AButton
      (
            "PEDIDO" ,
            310 , 260 , 280 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      
      public static AButton BTN_Admin = new AButton
      (
            "" ,
            410 , 370 , 80 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      
      public static AButton BTN_Info = new AButton
      (
            "" ,
            510 , 370 , 80 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      
      
      
      
      // LABELS
      
      public static ALabel LBA_Name = new ALabel
      (
            "RESTAURANTE UNIVERSITÁRIO" ,
            10 , 10 , 580 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      
      public static ALabel LBA_Image = new ALabel
      (
            "" ,
            25 , 120 , 250 , 250 ,
            new Font ( "Consolas" , Font.ITALIC , 16 )
      );
      
      
      
      
      
      // BORDER
      
      public static Border LBA_Name_Border = BorderFactory.createLineBorder ( new Color (38, 36, 36 ) , 3 );
      
      
      
      
      
      // COLOR
      public static Color BKG = new Color (51, 47, 47 );   /* Background 1 */
      public static Color BK2 = new Color (45, 43, 43 );   /* Background 2 */
      public static Color BRD = new Color (38, 36, 36 );   /* Border Stopped */
      public static Color BR2 = new Color (96, 88, 88 );   /* Border Hover */
      public static Color FRG = new Color (255, 255, 255); /* Foreground */
}
