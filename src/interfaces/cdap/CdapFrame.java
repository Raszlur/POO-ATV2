package interfaces.cdap;

import data.Alimentos;
import data.aliments;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.cdap.CLoader;
import interfaces.menu.MLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;


public class CdapFrame extends AWindow
{
      
      public aliments list = new aliments ();
      public Alimentos comida = new Alimentos ();
      
      public ImageIcon IMAGE;
      public double PRICE;
      
      public CdapFrame ()
      {
            super ("CDAP - Cardápio" , 800 , 640 , MLoader . BKG );
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
            this.setIconImage ( CLoader. frame_logo .getImage () );
            this.setCursor ( Curs. CURSORDefault );
            
            
            
            /* LABEL - DIA DA SEMANA */
            CLoader. LBA_FRAMENAME . setForeground ( CLoader. FRG );
            CLoader. LBA_FRAMENAME . setBackground ( CLoader. BK2 );
            CLoader. LBA_FRAMENAME . setOpaque ( true );
            CLoader. LBA_FRAMENAME . setBorder ( MLoader . LBA_Name_Border );
            this.add ( CLoader. LBA_FRAMENAME );
            
            /*--------------------------------------------------------------------------------------------*/
            
            /* LABEL - SELECTION HOLDER + SELECTION HOLDER + DAYS OF THE WEEK */
            CLoader. LBA_CONTAINER . setForeground ( CLoader. FRG );
            CLoader. LBA_CONTAINER . setBackground ( CLoader. BK2 );
            CLoader. LBA_CONTAINER . setOpaque ( true );
            CLoader. LBA_CONTAINER . setBorder ( MLoader . LBA_Name_Border );
            
            CLoader. LBA_SELECNAME . setForeground ( CLoader. FRG );
            
            /*--------------------------------------------------------------------------------------------*/
            
            /* RADIO BUTTON - SEGUNDA */
            CLoader. R_SEG . addActionListener ( this );
            CLoader. R_SEG . setSelected ( true );
            CLoader. R_SEG . setCursor ( Curs . CURSORHover );
            CLoader. R_SEG . setForeground ( CLoader. FRG );
            
            /* RADIO BUTTON - TERÇA */
            CLoader. R_TER . addActionListener ( this );
            CLoader. R_TER . setCursor ( Curs . CURSORHover );
            CLoader. R_TER . setForeground ( CLoader. FRG );
            
            /* RADIO BUTTON - QUARTA */
            CLoader. R_QUA . addActionListener ( this );
            CLoader. R_QUA . setCursor ( Curs . CURSORHover );
            CLoader. R_QUA . setForeground ( CLoader. FRG );
            
            /* RADIO BUTTON - QUINTA */
            CLoader. R_QUI . addActionListener ( this );
            CLoader. R_QUI . setCursor ( Curs . CURSORHover );
            CLoader. R_QUI . setForeground ( CLoader. FRG );
            
            /* RADIO BUTTON - SEXTA */
            CLoader. R_SEX . addActionListener ( this );
            CLoader. R_SEX . setCursor ( Curs . CURSORHover );
            CLoader. R_SEX . setForeground ( CLoader. FRG );
            
            /* GROUP - TODOS */
            CLoader. Container . add ( CLoader. R_SEG );
            CLoader. Container . add ( CLoader. R_TER );
            CLoader. Container . add ( CLoader. R_QUA );
            CLoader. Container . add ( CLoader. R_QUI );
            CLoader. Container . add ( CLoader. R_SEX );
            
            /* ADDING TO THE WINDOW */
            // 1. ALL THE RADIOBUTTONS
            // 2. THE "CONTAINER NAME"
            // 3. THE BACKGROUND BOX
            this . add ( CLoader. R_SEG );
            this . add ( CLoader. R_TER );
            this . add ( CLoader. R_QUA );
            this . add ( CLoader. R_QUI );
            this . add ( CLoader. R_SEX );
            this . add ( CLoader. LBA_SELECNAME );
            this . add ( CLoader. LBA_CONTAINER );
            
            /*--------------------------------------------------------------------------------------------*/
            /*--------------------------------------------------------------------------------------------*/
            
            /* LABEL - COMIDA */
            CLoader. LBA_COMIDA . setForeground ( CLoader. FRG );
            this.add ( CLoader. LBA_COMIDA );
            
            /* LABEL - BEBIDA */
            CLoader. LBA_BEBIDA . setForeground ( CLoader. FRG );
            this.add ( CLoader. LBA_BEBIDA );
            
            /*--------------------------------------------------------------------------------------------*/
            /*--------------------------------------------------------------------------------------------*/
            
            /* DEFAULT LIST MODEL - COMIDAS */
            // CLoader . DFLM_ListadeComidas . addElement ( "Arroz + Feijão + Carne + Pure" );
            
            /* JSCROLLBAR - COMIDAS */
            CLoader. JSCP_Comidas . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 1 ) );
            CLoader. JSCP_Comidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            CLoader. JSCP_Comidas . getVerticalScrollBar () . setBackground ( CLoader. BKG );
            CLoader. JSCP_Comidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = CLoader. BRD; }
                                            @Override protected JButton createDecreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            @Override protected JButton createIncreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            private static JButton createZeroButton ()
                                            {
                                                  JButton button = new JButton();
                                                  Dimension zeroDim = new Dimension(0, 0);
                                                  button.setPreferredSize(zeroDim);
                                                  button.setMinimumSize(zeroDim);
                                                  button.setMaximumSize(zeroDim);
                                                  return button;
                                            }
                                      }
                         );
            
            
            
            
            
            /* JLIST - COMIDAS */
            CLoader. JL_ListadeComidas . setBackground ( CLoader. BK2 );
            CLoader. JL_ListadeComidas . setForeground ( CLoader. FRG );
            CLoader. JL_ListadeComidas . setSelectionBackground ( CLoader. SE1 );
            CLoader. JL_ListadeComidas . setSelectionForeground ( CLoader. FRG );
            CLoader. JL_ListadeComidas . setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
            
            
            CLoader. JL_ListadeComidas . setFixedCellHeight ( 25 );
            CLoader. JL_ListadeComidas . setFixedCellWidth ( 10 );
            CLoader. JL_ListadeComidas . setVerifyInputWhenFocusTarget ( false );
            CLoader. JL_ListadeComidas . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            CLoader. JL_ListadeComidas . setCursor ( Curs .CURSORHover );
            /* PANEL - COMIDAS */
            CLoader. PAN_Comidas . add ( CLoader. JSCP_Comidas , BorderLayout . CENTER );
            this.add ( CLoader. PAN_Comidas );
            
            
            /* ****************************************************************************************** */
            
            
            /* DEFAULT LIST MODEL - BEBIDAS */
            // CLoader . DFLM_ListadeBebidas . addElement ( "Refrigerante Sprite Light 250 ml" );
            
            /* JSCROLLBAR - BEBIDAS */
            CLoader. JSCP_Bebidas . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 1 ) );
            CLoader. JSCP_Bebidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            CLoader. JSCP_Bebidas . getVerticalScrollBar () . setBackground ( CLoader. BKG );
            CLoader. JSCP_Bebidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = CLoader. BRD; }
                                            @Override protected JButton createDecreaseButton ( int orientation ) { return this.createZeroButton(); }
                                            
                                            @Override protected JButton createIncreaseButton ( int orientation ) { return this.createZeroButton(); }
                                            
                                            private static JButton createZeroButton ()
                                            {
                                                  JButton button = new JButton();
                                                  Dimension zeroDim = new Dimension(0, 0);
                                                  button.setPreferredSize(zeroDim);
                                                  button.setMinimumSize(zeroDim);
                                                  button.setMaximumSize(zeroDim);
                                                  return button;
                                            }
                                      }
                         );
            
            
            /* JLIST - BEBIDAS */
            CLoader. JL_ListadeBebidas . setBackground ( CLoader. BK2 );
            CLoader. JL_ListadeBebidas . setForeground ( CLoader. FRG );
            CLoader. JL_ListadeBebidas . setSelectionBackground ( CLoader. SE1 );
            CLoader. JL_ListadeBebidas . setSelectionForeground ( CLoader. FRG );
            CLoader. JL_ListadeBebidas . setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
            CLoader. JL_ListadeBebidas . setVerifyInputWhenFocusTarget ( true );
            
            CLoader. JL_ListadeBebidas . setFixedCellHeight ( 25 );
            CLoader. JL_ListadeBebidas . setFixedCellWidth ( 10 );
            CLoader. JL_ListadeBebidas . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            CLoader. JL_ListadeBebidas . setCursor ( Curs . CURSORHover );
            
            /* PANEL - BEBIDAS */
            CLoader. PAN_Bebidas . add ( CLoader. JSCP_Bebidas , BorderLayout . CENTER );
            this.add ( CLoader. PAN_Bebidas );
            
            /*--------------------------------------------------------------------------------------------*/
            /*--------------------------------------------------------------------------------------------*/
            /*--------------------------------------------------------------------------------------------*/
            /*--------------------------------------------------------------------------------------------*/
            
            /* FOOD INFO */
            
            // BACKGROUND
            CLoader. PAN_IMAGE . setBackground ( CLoader. BK2 );
            CLoader. PAN_IMAGE . setForeground ( CLoader. FRG );
            CLoader. PAN_IMAGE . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            this . add ( CLoader. PAN_IMAGE );
            
            // ITEM PRICE
            CLoader. LBA_ITEMPRICE . setForeground ( CLoader. FRG );
            CLoader. LBA_ITEMPRICE . setBackground ( CLoader. BK2 );
            CLoader. LBA_ITEMPRICE . setOpaque ( true );
            CLoader. LBA_ITEMPRICE . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            this . add ( CLoader. LBA_ITEMPRICE );
            
            // RETURN BUTTON
            CLoader. BTN_RETURN . addActionListener ( this );
            CLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            CLoader. BTN_RETURN . setBackground ( MLoader . BK2 );
            CLoader. BTN_RETURN . setForeground ( MLoader . FRG );
            CLoader. BTN_RETURN . setCursor ( Curs . CURSORHover );
            this . add ( CLoader. BTN_RETURN );
            
            // EXECUÇÃO DOS DIAS
            CLoader . JL_ListadeComidas . addListSelectionListener
            (
                   e ->
                   {
                       int idx = 0;
                       String sleetcher;
                       
                       if ( !e.getValueIsAdjusting () )
                       {
                         CLoader. JL_ListadeBebidas . clearSelection ();
                         CLoader. PAN_IMAGE . removeIMG ();
                         sleetcher = CLoader.JL_ListadeComidas . getSelectedValue ();
                         System.out.println ( sleetcher );
                         
                         
                         while ( list . listagem . size () > idx )
                         {
                              if ( list . listagem . get ( idx ) . NAME . equals ( sleetcher ) )
                              {
                                CLoader. LBA_ITEMPRICE . setText ( "PREÇO R$ " + list . listagem . get ( idx ) . PRICE );
                                
                                if ( list . listagem . get ( idx ) . IMAGE != null )
                                  CLoader. PAN_IMAGE . addIMG ( list . listagem . get ( idx ) . IMAGE );
                                  
                                break;
                               }
                               idx++;
                         }
                       }
                   }
            );
            
            CLoader . JL_ListadeBebidas . addListSelectionListener
            (
                   e ->
                   {
                       int idx = 0;
                       String getcher;
                                            
                       if ( !e.getValueIsAdjusting () )
                       {
                         CLoader. JL_ListadeComidas . clearSelection ();
                         CLoader. PAN_IMAGE . removeIMG ();
                         getcher = CLoader. JL_ListadeBebidas . getSelectedValue ();
                         System.out.println ( getcher );
                                                  
                                                  
                         while ( list . listagem . size () > idx )
                         {
                              if ( list . listagem . get ( idx ) . NAME . equals ( getcher ) )
                              {
                                CLoader. LBA_ITEMPRICE .setText ( "PREÇO R$ " + list . listagem . get ( idx ) . PRICE );
                                                              
                                if ( list . listagem . get ( idx ) . IMAGE != null )
                                  CLoader. PAN_IMAGE . addIMG ( list . listagem . get ( idx ) . IMAGE );
                                break;
                               }
                               idx++;
                         }
                         
                       }
                   }
            );
            
            /* BUTTON - RETURN TO MENU */
            CLoader. BTN_RETURN . addActionListener ( this );
            CLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
            CLoader. BTN_RETURN . setBackground ( CLoader. BK2 );
            CLoader. BTN_RETURN . setForeground ( CLoader. FRG );
            CLoader. BTN_RETURN . addMouseListener
                         (
                                      new MouseAdapter()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  CLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( CLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  CLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( CLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter. cdapGraph . dispose ();
                                                  Linter. mainGraph . build ();
                                                  try {
                                                        Linter. mainGraph . run   ();
                                                  } catch (IOException | ClassNotFoundException ex) {
                                                        throw new RuntimeException ( ex );
                                                  }
                                            }
                                      }
                         );
            this . add ( CLoader. BTN_RETURN );
      }
      
      public void build ()
      {
            // FAZEMOS UM RELOAD DO OBJETO PARA ESSA INTERFACE
            FileInputStream fileIn = null;
            ObjectInput in = null;
            
            try {  fileIn = new FileInputStream ("src//data//listagem.ser" ); }
            catch ( Exception e ) { System.out.println ("Sistema: O arquivo 'aliments' não existe!"); }
            
            try { in = new ObjectInputStream( fileIn ); }
            catch ( Exception e ) { System.out.println ("Sistema: 1"); }
            
            try { list = ( aliments ) in . readObject (); }
            catch ( Exception e ) { System.out.println ("Sistema: 2"); }
            
            try { in . close (); }
            catch ( Exception e ) { System.out.println ("Sistema: 3"); }
            
            try { fileIn . close (); }
            catch ( Exception e ) { System.out.println ("Sistema: 4"); }
            System.out.println ("CARDÁPIO");
            
            // LOAD DA LABEL INICIAL
            int index = 0;
            
            CLoader. DFLM_ListadeBebidas . clear ();
            CLoader. DFLM_ListadeComidas . clear ();
            
            while ( list . listagem . size () > index )
            {
                  if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                        CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                  
                  index++;
            }
            
            index = 0;
            
            while ( list . listagem . size () > index )
            {
                  if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                        CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                  
                  index++;
            }
            
            CLoader . R_SEG . setSelected ( true );
      }
      
      public void run ()
      {
            this.revalidate ();
            this.repaint ();
            this.setVisible ( true );
      }
      
      
      @Override public void actionPerformed ( ActionEvent e )
      {
              if ( e.getSource () == CLoader.R_SEG )
              {
                CLoader. DFLM_ListadeBebidas . clear ();
                CLoader. DFLM_ListadeComidas . clear ();
                
                CLoader. LBA_ITEMPRICE . setText ("PREÇO R$ ");
                CLoader. PAN_IMAGE . removeIMG ();
                
                int index = 0;
                
                while ( list . listagem . size () > index )
                {
                     if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                       CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                       
                     System.out.println ( list . listagem . get ( index ) . NAME );
                     index++;
                }
                
                index = 0;
                
                while ( list . listagem . size () > index )
                {
                     if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                       CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                       
                     System.out.println ( list . listagem . get ( index ) . NAME );
                     index++;
                }
              }
            
              
              
              
              
              
              if ( e.getSource () == CLoader. R_TER )
              {
                    CLoader. DFLM_ListadeBebidas . clear ();
                    CLoader. DFLM_ListadeComidas . clear ();
                    
                    CLoader. LBA_ITEMPRICE . setText ("PREÇO R$ ");
                    CLoader. PAN_IMAGE . removeIMG ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 3 )
                                CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 3 )
                                CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              
              
              
              
              
              if ( e.getSource () == CLoader.R_QUA )
              {
                    CLoader. DFLM_ListadeBebidas . clear ();
                    CLoader. DFLM_ListadeComidas . clear ();
                    
                    CLoader. LBA_ITEMPRICE . setText ("PREÇO R$ ");
                    CLoader. PAN_IMAGE . removeIMG ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 4 )
                                CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 4 )
                                CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              
              
              
              
              
              if ( e.getSource () == CLoader.R_QUI )
              {
                    CLoader. DFLM_ListadeBebidas . clear ();
                    CLoader. DFLM_ListadeComidas . clear ();
                    
                    CLoader. LBA_ITEMPRICE . setText ("PREÇO R$ ");
                    CLoader. PAN_IMAGE . removeIMG ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 5 )
                                CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 5 )
                                CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              
              
              
              
              
              if ( e.getSource () == CLoader.R_SEX )
              {
                    CLoader. DFLM_ListadeBebidas . clear ();
                    CLoader. DFLM_ListadeComidas . clear ();
                    
                    CLoader. LBA_ITEMPRICE . setText ("PREÇO R$ ");
                    CLoader. PAN_IMAGE . removeIMG ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 6 )
                                CLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 6 )
                                CLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
      }
}
