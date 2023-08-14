package interfaces.user;
import graphics.AButton;
import graphics.ALabel;
import graphics.APanel;

import javax.swing.*;
import java.awt.*;





public class OLoader
{
      // LABEL
      public static ALabel LBA_FRAMENAME = new ALabel
      (
            "FAZER UM PEDIDO" ,
            10 , 10 , 555 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      // BUTTONS
      public static AButton BTN_RETURN = new AButton
      (
            "VOLTAR" ,
            315 , 545 , 250 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static AButton BTN_ADD = new AButton
      (
            "ADICIONAR" ,
            315 , 350 , 120 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 18 )
      );
      
      public static AButton BTN_REMOVE = new AButton
      (
            "REMOVER" ,
            445 , 350 , 120 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 18 )
      );
      
      public static AButton BTN_PAY = new AButton
      (
            "PAGAR" ,
            315 , 490 , 250 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_COMIDA = new ALabel
      (
            "COMIDAS" ,
            80 , 80 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_BEBIDA = new ALabel
      (
            "BEBIDAS" ,
            80 , 330 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_PAYMENT = new ALabel
      (
            "PEDIDO" ,
            390 , 80 , 100 , 100 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_TOTALPRICE = new ALabel
      (
            "TOTAL R$0,00" ,
            315 , 425 , 250 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      
      
      /////////
      
      // PANEL
      public static APanel PAN_COMIDAS = new APanel ( 10 , 140 , 250 , 200 );
      
      // LIST - COMIDA
      public static DefaultListModel< String > DFLM_ListadeComidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeComidas = new JList <> ( DFLM_ListadeComidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Comidas = new JScrollPane ( JL_ListadeComidas );
      
      /////////
      
      // PANEL
      public static APanel PAN_BEBIDAS = new APanel ( 10 , 395 , 250 , 200 );
      
      // LIST - COMIDA
      public static DefaultListModel< String > DFLM_ListadeBebidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeBebidas = new JList <> ( DFLM_ListadeBebidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Bebidas = new JScrollPane ( JL_ListadeBebidas );
      
      /////////
      
      // PANEL
      public static APanel PAN_PAYMENT = new APanel ( 315 , 140 , 250 , 200 );
      
      // LIST - PAYMENT
      public static DefaultListModel< String > DFLM_PAYMENT = new DefaultListModel <> ();
      public static JList < String > JL_PAYMENT = new JList <> ( DFLM_PAYMENT );
      
      // SCROLLBAR
      public static JScrollPane JSCP_PAYMENT = new JScrollPane ( JL_PAYMENT );
      
      /////////

      
      public static ALabel SEPARATOR = new ALabel
      (
            "" ,
            285 , 100 , 5 , 500 ,
            null
      );
      
      // COLOR
      public static Color BKG = new Color (51, 47, 47 );   /* Background 1 */
      public static Color BK2 = new Color (45, 43, 43 );   /* Background 2 */
      public static Color BRD = new Color (38, 36, 36 );   /* Border Stopped */
      public static Color BR2 = new Color (96, 88, 88 );   /* Border Hover */
      public static Color FRG = new Color (255, 255, 255); /* Foreground */
}
