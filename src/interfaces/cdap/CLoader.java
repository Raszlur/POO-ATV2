package interfaces.cdap;
import graphics.AButton;
import graphics.ALabel;
import graphics.APanel;
import graphics.ARadioButton;
import javax.swing.*;
import java.awt.*;





public class CLoader
{
      // IMAGES
      public static ImageIcon frame_logo = new ImageIcon ( "src//images//icon.png" );
      
      // LABELS
      public static ALabel LBA_FRAMENAME = new ALabel
      (
            "CARDÁPIO" ,
            10 , 10 , 765 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      public static ALabel LBA_CONTAINER = new ALabel
      (
            "" ,
            10 , 200 , 225 , 265 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      public static ALabel LBA_SELECNAME = new ALabel
      (
            "SELEÇÃO" ,
            70 , 180 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_COMIDA = new ALabel
      (
            "COMIDAS" ,
            340 , 80 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_BEBIDA = new ALabel
      (
            "BEBIDAS" ,
            340 , 320 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      /* ITEM INFO */
      
      public static ALabel LBA_ITEMPRICE = new ALabel
      (
            "PREÇO R$" ,
            540 , 450 , 235 , 70 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      
      // PANEL
      public static APanel PAN_IMAGE = new APanel ( 540 , 180 , 235 , 235 );
      
      
      
      
      
////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // PANEL
      public static APanel PAN_Bebidas = new APanel ( 270 , 140 , 250 , 200 );
      
      // LIST - BEBIDA
      public static DefaultListModel < String > DFLM_ListadeBebidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeBebidas = new JList <> ( DFLM_ListadeBebidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Bebidas = new JScrollPane ( JL_ListadeBebidas );
      
////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // PANEL
      public static APanel PAN_Comidas = new APanel ( 270 , 380 , 250 , 200 );
      
      // LIST - COMIDA
      public static DefaultListModel < String > DFLM_ListadeComidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeComidas = new JList <> ( DFLM_ListadeComidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Comidas = new JScrollPane ( JL_ListadeComidas );

////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // RADIO
      public static ButtonGroup Container = new ButtonGroup ();
      public static ARadioButton R_SEG = new ARadioButton
      (
            "Segunda-Feira" ,
            30 , 260 , 170 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_TER = new ARadioButton
      (
            "Terça-Feira" ,
            30 , 300 , 150 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_QUA = new ARadioButton
      (
            "Quarta-Feira" ,
            30 , 340 , 160 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_QUI = new ARadioButton
      (
            "Quinta-Feira" ,
            30 , 380 , 160 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_SEX = new ARadioButton
      (
            "Sexta-Feira" ,
            30 , 420 , 150 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      // BUTTON
      public static AButton BTN_RETURN = new AButton
      (
            "VOLTAR" ,
            10 , 500 , 225 , 70 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      
      
      // COLOR
      public static Color BKG = new Color (51, 47, 47 );   /* Background 1 */
      public static Color BK2 = new Color (45, 43, 43 );   /* Background 2 */
      public static Color BRD = new Color (38, 36, 36 );   /* Border Stopped */
      public static Color BR2 = new Color (96, 88, 88 );   /* Border Hover */
      public static Color FRG = new Color (255, 255, 255 ); /* Foreground */
      
      public static Color SE1 = new Color (78, 73, 164 ); /* SELECTION BACKGROUND */
      public static Color SE2 = new Color (222, 40, 179 ); /* SELECTION FOREGROUND  */
      public static Color ED1 = new Color (72, 75, 72 ); /* FOOD NAME  */
}
