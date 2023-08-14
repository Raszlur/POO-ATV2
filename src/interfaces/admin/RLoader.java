package interfaces.admin;


import graphics.*;

import javax.swing.*;
import java.awt.*;

public class RLoader
{
      
      // IMAGES
      public static ImageIcon IMAGE = new ImageIcon ( "src//images//register//enjoy.gif" );
      
      // PANEL
      public static APanel IMAGE_CONTAINER = new APanel
      (
            25 , 420 , 240 , 150
      );
      
      
      
      // LABEL
      public static ALabel LBA_FRAMENAME = new ALabel
      (
            "CADASTRO DE CARDÁPIO" ,
            10 , 10 , 815 , 80 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      public static ALabel LBA_DAYSNAME = new ALabel
      (
            "DIAS DA SEMANA" ,
            10 , 95 , 240 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_FOOD = new ALabel
      (
            "COMIDAS" ,
            290 , 380 , 220 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_DRINK = new ALabel
      (
            "BEBIDAS" ,
            290 , 95 , 220 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ALabel LBA_DAYSCONTAINER = new ALabel
      (
            "" ,
            10 , 140 , 240 , 240 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      
      public static ALabel LBA_SEPARATOR = new ALabel
      (
            "" ,
            560 , 110 , 5 , 555 ,
            new Font ( "Consolas" , Font.BOLD , 32 )
      );
      

      
      
      
      
      
      
      
      // RADIO
      public static ButtonGroup Container = new ButtonGroup ();
      public static ARadioButton R_SEG = new ARadioButton
      (
            "Segunda-Feira" ,
            45 , 155 , 170 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_TER = new ARadioButton
      (
            "Terça-Feira" ,
            45 , 200 , 150 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_QUA = new ARadioButton
      (
            "Quarta-Feira" ,
            45 , 245 , 160 , 30 ,
             new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_QUI = new ARadioButton
      (
            "Quinta-Feira" ,
            45 , 290 , 160 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton R_SEX = new ARadioButton
      (
            "Sexta-Feira" ,
             45 , 335 , 150 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      // BUTTON
      public static AButton BTN_RETURN = new AButton
      (
            "VOLTAR" ,
             10 , 500 , 225 , 70 ,
             new Font ( "Consolas" , Font.BOLD , 18 )
      );
      
      
      
      ////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // PANEL
      public static APanel PAN_Bebidas = new APanel ( 280 , 140 , 250 , 240 );
      
      // LIST - BEBIDA
      public static DefaultListModel < String > DFLM_ListadeBebidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeBebidas = new JList <> ( DFLM_ListadeBebidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Bebidas = new JScrollPane ( JL_ListadeBebidas );

////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // PANEL
      public static APanel PAN_Comidas = new APanel ( 280 , 425 , 250 , 240 );
      
      // LIST - COMIDA
      public static DefaultListModel < String > DFLM_ListadeComidas = new DefaultListModel <> ();
      public static JList < String > JL_ListadeComidas = new JList <> ( DFLM_ListadeComidas );
      
      // SCROLLBAR
      public static JScrollPane JSCP_Comidas = new JScrollPane ( JL_ListadeComidas );

////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      
      
      
      
      
      
      
      
      
      // TEXT FIELD NAME
      public static ATextField TX_FOODNAME = new ATextField
      (
             590 , 150 , 230 , 60
      );
      
      // LABEL NAME
      public static ALabel LBA_INSERTNAME = new ALabel
      (
            "NOME DO ALIMENTO" ,
            590 , 100 , 230 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      
      
      
      // LABEL TYPE
      public static ALabel LBA_INSERTTYPE = new ALabel
      (
            "TIPO DO ALIMENTO" ,
            590 , 220 , 230 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      
      public static ButtonGroup TYPECONTAINER = new ButtonGroup ();
      public static ARadioButton RAD_FOOD = new ARadioButton
      (
            "COMIDA" ,
            590 , 275 , 91 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      public static ARadioButton RAD_DRINK = new ARadioButton
      (
            "BEBIDA" ,
            720 , 275 , 91 , 30 ,
            new Font ( "Consolas" , Font.PLAIN , 20 )
      );
      
      
      
      
      
      
      // LABEL TYPE
      public static ALabel LBA_ITEMPRICE = new ALabel
      (
            "PREÇO DO ALIMENTO" ,
            590 , 320 , 230 , 50 ,
            new Font ( "Consolas" , Font.BOLD , 20 )
      );
      // TEXT FIELD NAME
      public static ATextField TX_ITEMPRICE = new ATextField
      (
            590 , 370 , 230 , 60
      );
      
      
      
      
      
      // BUTTONS
      public static AButton BTN_LOADIMAGE = new AButton
      (
            "ADICIONAR IMAGEM" ,
            590 , 450 , 230 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 24 )
      );
      
      public static AButton BTN_SAVEALIM = new AButton
      (
            "SALVAR ALIMENTO" ,
            590 , 530 , 230 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 24 )
      );
      
      public static AButton BTN_RETURNMENU = new AButton
      (
            "VOLTAR" ,
            10 , 605 , 240 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 24 )
      );
      public static AButton BTN_REMOVE = new AButton
      (
            "REMOVER ALIMENTO" ,
            590 , 610 , 230 , 60 ,
            new Font ( "Consolas" , Font.BOLD , 24 )
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
