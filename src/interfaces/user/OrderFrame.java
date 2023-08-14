package interfaces.user;

import data.aliments;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.cdap.CLoader;
import interfaces.menu.MLoader;
import interfaces.user.OLoader;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class OrderFrame extends AWindow
{
      
      public LocalDate dataAtual = LocalDate . now ();
      public DayOfWeek diaDaSemana = dataAtual . getDayOfWeek ();
      int diaAtual = diaDaSemana . getValue ();
      
      public aliments list = new aliments ();
      
      public ListSelectionListener paymentListener = null;
      public ListSelectionListener bebidasListener = null;
      public ListSelectionListener comidasListener = null;
      
      double totalPayment = 0.0;
      
      public OrderFrame ()
      {
            super ("CDAP - Fazer um Pedido" , 590 , 645 , OLoader. BKG );
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
            this.setIconImage ( CLoader. frame_logo .getImage () );
            this.setCursor ( Curs. CURSORDefault );
            
            this.revalidate ();
            this.repaint ();
            
            
            System.out.println ( diaAtual );
            
            
            
            

            
            
            
            
            
            /* LABEL - DIA DA SEMANA */
            OLoader. LBA_FRAMENAME . setForeground ( OLoader. FRG );
            OLoader. LBA_FRAMENAME . setBackground ( OLoader. BK2 );
            OLoader. LBA_FRAMENAME . setOpaque ( true );
            OLoader. LBA_FRAMENAME . setBorder ( MLoader. LBA_Name_Border );
            this.add ( OLoader. LBA_FRAMENAME );
            
            /* BUTTON - RETURN */
            OLoader. BTN_RETURN . addActionListener ( this );
            OLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( CLoader . BRD , 3 ) );
            OLoader. BTN_RETURN . setBackground ( OLoader. BK2 );
            OLoader. BTN_RETURN . setForeground ( OLoader. FRG );
            OLoader. BTN_RETURN . setCursor ( Curs . CURSORHover );
            
            
            
            
            
            
            /* BUTTON - ADD */
            OLoader. BTN_ADD . addActionListener ( this );
            OLoader. BTN_ADD . setBorder ( BorderFactory.createLineBorder ( new Color (42, 44, 40 ) , 3 ) );
            OLoader. BTN_ADD . setBackground ( new Color (88, 126, 73 ) );
            OLoader. BTN_ADD . setForeground ( new Color (255, 255, 255 ) );
            OLoader. BTN_ADD . setCursor ( Curs . CURSORHover );
            
            
            
            
            
            
            /* BUTTON - REMOVE */
            OLoader. BTN_REMOVE . addActionListener ( this );
            OLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( new Color (75, 21, 26) , 3 ) );
            OLoader. BTN_REMOVE . setBackground ( new Color (141, 24, 34) );
            OLoader. BTN_REMOVE . setForeground ( OLoader. FRG );
            OLoader. BTN_REMOVE . setCursor ( Curs . CURSORHover );
            
            
            
            
            
            
            
            /* BUTTON - PAY */
            this . add ( OLoader. BTN_PAY );
            OLoader. BTN_PAY . addActionListener ( this );
            OLoader. BTN_PAY . setBorder ( BorderFactory.createLineBorder ( CLoader . BRD , 3 ) );
            OLoader. BTN_PAY . setBackground ( OLoader. BK2 );
            OLoader. BTN_PAY . setForeground ( OLoader. FRG );
            OLoader. BTN_PAY . setCursor ( Curs . CURSORHover );
            
            
            
            
            
            
            
            
            /* LABEL - FOOD LIST NAME  */
            OLoader. LBA_COMIDA . setForeground ( OLoader. FRG );
            this.add ( OLoader. LBA_COMIDA );
            
            
            
            /* LABEL - DRINK LIST NAME  */
            OLoader. LBA_BEBIDA . setForeground ( OLoader. FRG );
            this.add ( OLoader. LBA_BEBIDA );
            
            
            
            
            /* LABEL - PAYMENT LIST  */
            OLoader. LBA_PAYMENT . setForeground ( OLoader. FRG );
            this.add ( OLoader. LBA_PAYMENT );
            
            /* LISTS */
            
            
            
            
            
            
            
            
            
            /* JSCROLLBAR - COMIDAS */
            OLoader. JSCP_Comidas . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 1 ) );
            OLoader. JSCP_Comidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            OLoader. JSCP_Comidas . getVerticalScrollBar () . setBackground ( OLoader. BKG );
            OLoader. JSCP_Comidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = OLoader. BRD; }
                                            @Override protected JButton createDecreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            @Override protected JButton createIncreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            private static JButton createZeroButton ()
                                            {
                                                  JButton button = new JButton ();
                                                  Dimension zeroDim = new Dimension (0, 0 );
                                                  button.setPreferredSize ( zeroDim );
                                                  button.setMinimumSize ( zeroDim );
                                                  button.setMaximumSize ( zeroDim );
                                                  return button;
                                            }
                                      }
                         );
            
            
            /* JLIST - COMIDAS */
            OLoader. JL_ListadeComidas . setBackground ( OLoader. BK2 );
            OLoader. JL_ListadeComidas . setForeground ( OLoader. FRG );
            OLoader. JL_ListadeComidas . setSelectionBackground ( CLoader . SE1 );
            OLoader. JL_ListadeComidas . setSelectionForeground ( OLoader. FRG );
            
            
            OLoader. JL_ListadeComidas . setFixedCellHeight ( 25 );
            OLoader. JL_ListadeComidas . setFixedCellWidth ( 10 );
            OLoader. JL_ListadeComidas . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
            OLoader. JL_ListadeComidas . setCursor ( Curs .CURSORHover );
            OLoader. JL_ListadeComidas . addListSelectionListener ( comidasListener );
            
            
            /* PANEL - COMIDAS */
            OLoader. PAN_COMIDAS . add ( OLoader. JSCP_Comidas , BorderLayout . CENTER );
            this.add ( OLoader. PAN_COMIDAS );
            
            
            
            
            
            
            
            
            /* JSCROLLBAR - BEBIDAS */
            OLoader. JSCP_Bebidas . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 1 ) );
            OLoader. JSCP_Bebidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            OLoader. JSCP_Bebidas . getVerticalScrollBar () . setBackground ( OLoader. BKG );
            OLoader. JSCP_Bebidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = OLoader. BRD; }
                                            @Override protected JButton createDecreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            @Override protected JButton createIncreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            private static JButton createZeroButton ()
                                            {
                                                  JButton button = new JButton ();
                                                  Dimension zeroDim = new Dimension (0, 0 );
                                                  button.setPreferredSize ( zeroDim );
                                                  button.setMinimumSize ( zeroDim );
                                                  button.setMaximumSize ( zeroDim );
                                                  return button;
                                            }
                                      }
                         );
            
            
            /* JLIST - BEBIDAS */
            OLoader. JL_ListadeBebidas . setBackground ( OLoader. BK2 );
            OLoader. JL_ListadeBebidas . setForeground ( OLoader. FRG );
            OLoader. JL_ListadeBebidas . setSelectionBackground ( CLoader . SE1 );
            OLoader. JL_ListadeBebidas . setSelectionForeground ( OLoader. FRG );
            
            
            OLoader. JL_ListadeBebidas . setFixedCellHeight ( 25 );
            OLoader. JL_ListadeBebidas . setFixedCellWidth ( 10 );
            OLoader. JL_ListadeBebidas . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
            OLoader. JL_ListadeBebidas . setCursor ( Curs . CURSORHover );
            OLoader. JL_ListadeComidas . addListSelectionListener ( bebidasListener );
            
            /* PANEL - BEBIDAS */
            OLoader. PAN_BEBIDAS . add ( OLoader. JSCP_Bebidas , BorderLayout . CENTER );
            this.add ( OLoader. PAN_BEBIDAS );
            
            
            
            
            
            
            
            
            /* JSCROLLBAR - PAYMENT */
            OLoader. JSCP_PAYMENT . setBorder ( BorderFactory.createLineBorder ( new Color (70, 110, 107) , 1 ) );
            OLoader. JSCP_PAYMENT . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            OLoader. JSCP_PAYMENT . getVerticalScrollBar () . setBackground ( new Color (52, 72, 69) );
            OLoader. JSCP_PAYMENT . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = new Color (53, 79, 100); }
                                            @Override protected JButton createDecreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            @Override protected JButton createIncreaseButton ( int orientation ) { return this.createZeroButton (); }
                                            
                                            private static JButton createZeroButton ()
                                            {
                                                  JButton button = new JButton ();
                                                  Dimension zeroDim = new Dimension (0, 0 );
                                                  button.setPreferredSize ( zeroDim );
                                                  button.setMinimumSize ( zeroDim );
                                                  button.setMaximumSize ( zeroDim );
                                                  return button;
                                            }
                                      }
                         );
            
            
            /* JLIST - PAYMENT */
            OLoader. JL_PAYMENT . setBackground ( new Color (68, 72, 80) );
            OLoader. JL_PAYMENT . setForeground ( new Color (255, 255, 255) );
            OLoader. JL_PAYMENT . setSelectionBackground ( new Color (145, 114, 41) );
            OLoader. JL_PAYMENT . setSelectionForeground ( new Color (255, 255, 255) );
            
            
            OLoader. JL_PAYMENT . setFixedCellHeight ( 25 );
            OLoader. JL_PAYMENT . setFixedCellWidth ( 10 );
            OLoader. JL_PAYMENT . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
            OLoader. JL_PAYMENT . setCursor ( Curs . CURSORHover );
            OLoader. JL_ListadeComidas . addListSelectionListener ( paymentListener );
            
            
            
            /* PANEL - COMIDAS */
            OLoader. PAN_PAYMENT . add ( OLoader. JSCP_PAYMENT , BorderLayout . CENTER );
            this.add ( OLoader. PAN_PAYMENT );
            
            
            /* LABEL - SEPARADOR */
            OLoader. SEPARATOR . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
            this.add ( OLoader. SEPARATOR );
            
            /* LABEL - TOTAL PRICE */
            OLoader. LBA_TOTALPRICE . setForeground ( OLoader. FRG );
            OLoader. LBA_TOTALPRICE . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
            this.add ( OLoader. LBA_TOTALPRICE );
            
            /* BUTTON - RETURN TO MENU */
            OLoader. BTN_RETURN . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  OLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( OLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  OLoader. BTN_RETURN . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  
                                                  totalPayment = 0;
                                                  OLoader. DFLM_PAYMENT . clear ();
                                                  
                                                  Linter. orderGraph . dispose ();
                                                  Linter. mainGraph . build ();
                                                  try {
                                                        Linter. mainGraph . run   ();
                                                  } catch (IOException | ClassNotFoundException ex) {
                                                        throw new RuntimeException ( ex );
                                                  }
                                            }
                                      }
                         );
            this . add ( OLoader. BTN_RETURN );
            
            
            
            /* BUTTON - ADD */
            OLoader. BTN_ADD . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  OLoader. BTN_ADD . setBorder ( BorderFactory.createLineBorder ( new Color (94, 211, 71) , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  OLoader. BTN_ADD . setBorder ( BorderFactory.createLineBorder ( new Color (42, 44, 40 ) , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  String selectedBebida = OLoader. JL_ListadeBebidas . getSelectedValue ();
                                                  String selectedComida = OLoader. JL_ListadeComidas . getSelectedValue ();
                                                  String paymentSelected =  OLoader. JL_PAYMENT . getSelectedValue ();
                                                  
                                                  int index = 0;
                                                  
                                                  boolean bebidaAchada = false;
                                                  boolean comidaAchada = false;
                                                  
                                                  while ( list . listagem . size () > index && ( !bebidaAchada || !comidaAchada ) )
                                                  {
                                                        if ( list . listagem . get ( index ) . NAME . equals ( selectedBebida ) && !bebidaAchada )
                                                        {
                                                              totalPayment += list . listagem . get ( index ) . PRICE;
                                                              OLoader. DFLM_PAYMENT . addElement ( selectedBebida );
                                                              bebidaAchada = true;
                                                        }
                                                        
                                                        else if ( list . listagem . get ( index ) . NAME . equals ( selectedComida ) && !comidaAchada )
                                                        {
                                                              totalPayment += list . listagem . get ( index ) . PRICE;
                                                              OLoader. DFLM_PAYMENT . addElement ( selectedComida );
                                                              comidaAchada = true;
                                                        }
                                                        
                                                        index++;
                                                  }
                                                  
                                                  DecimalFormat decimalFormat = new DecimalFormat ("#.00"); // Define o formato para duas casas decimais
                                                  String formattedTotal = decimalFormat.format ( totalPayment ); // Formata o valor do totalPayment
                                                  
                                                  OLoader. LBA_TOTALPRICE . setText ("TOTAL R$ " + formattedTotal );
                                            }
                                      }
                         );
            this . add ( OLoader. BTN_ADD );
            
            /* BUTTON - REMOVE */
            OLoader. BTN_REMOVE . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  OLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( new Color (199, 12, 12)  , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  OLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( new Color (96, 18, 26 ) , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  String paymentSelected =  OLoader. JL_PAYMENT . getSelectedValue ();
                                                  
                                                  int index = 0;
                                                  
                                                  while ( list . listagem . size () > index )
                                                  {
                                                        if ( list . listagem . get ( index ) . NAME . equals ( paymentSelected ) )
                                                        {
                                                              totalPayment -= list . listagem . get ( index ) . PRICE;
                                                              break;
                                                        }
                                                        
                                                        index++;
                                                  }
                                                  
                                                  OLoader. DFLM_PAYMENT . removeElement ( paymentSelected );
                                                  
                                                  DecimalFormat decimalFormat = new DecimalFormat ("#.00"); // Define o formato para duas casas decimais
                                                  String formattedTotal = decimalFormat.format ( totalPayment ); // Formata o valor do totalPayment
                                                  
                                                  if ( totalPayment > 0 )
                                                        OLoader. LBA_TOTALPRICE . setText ("TOTAL R$ " + formattedTotal );
                                                  else
                                                        OLoader. LBA_TOTALPRICE . setText ("TOTAL R$0,00");
                                            }
                                      }
                         );
            this . add ( OLoader. BTN_REMOVE );
            
            /* BUTTON - PAY */
            OLoader. BTN_PAY . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  OLoader. BTN_PAY . setBorder ( BorderFactory.createLineBorder ( OLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  OLoader. BTN_PAY . setBorder ( BorderFactory.createLineBorder ( OLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter . orderGraph . dispose ();
                                                  Linter . mainGraph . build ();
                                                  try {
                                                        Linter . mainGraph . run ();
                                                  } catch (IOException | ClassNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                  }
                                                  
                                            }
                                            
                                      }
                         );
            this . add ( OLoader. BTN_PAY );
            
            
            // Antes de adicionar novos ouvintes, remova os anteriores se existirem
            OLoader. JL_PAYMENT . removeListSelectionListener ( paymentListener );
            OLoader. JL_ListadeBebidas . removeListSelectionListener ( bebidasListener );
            OLoader. JL_ListadeComidas . removeListSelectionListener ( comidasListener );
            
            // Crie os ouvintes uma vez e reutilize-os sempre que necessário
            ListSelectionListener payment = e ->
            {
                  if (!e.getValueIsAdjusting () )
                  {
                        OLoader.JL_ListadeComidas.clearSelection();
                        OLoader.JL_ListadeBebidas.clearSelection();
                        String selection = OLoader.JL_PAYMENT.getSelectedValue();
                  }
            };
            
            ListSelectionListener drinks = e ->
            {
                  if (!e.getValueIsAdjusting())
                  {
                        OLoader.JL_ListadeComidas.clearSelection();
                        OLoader.JL_PAYMENT.clearSelection();
                        String selection = OLoader.JL_ListadeBebidas.getSelectedValue();
                  }
            };
            
            ListSelectionListener comidas = e ->
            {
                  if (!e.getValueIsAdjusting())
                  {
                        OLoader.JL_ListadeBebidas.clearSelection();
                        OLoader.JL_PAYMENT.clearSelection();
                        String selection = OLoader.JL_ListadeComidas.getSelectedValue();
                  }
            };
            
            OLoader.JL_PAYMENT.addListSelectionListener ( payment );
            OLoader.JL_ListadeBebidas.addListSelectionListener ( drinks );
            OLoader.JL_ListadeComidas.addListSelectionListener ( comidas );
            
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
            
            System.out.println ("PEDIDO");
            
            if ( diaAtual >= 1 && diaAtual <= 5 )
            {
                  // LOAD DA LABEL INICIAL
                  int index = 0;
                  
                  OLoader. DFLM_ListadeBebidas . clear ();
                  OLoader. DFLM_ListadeComidas . clear ();
                  OLoader. DFLM_PAYMENT . clear ();
                  totalPayment = 0.0;
                  OLoader. LBA_TOTALPRICE . setText ("TOTAL R$0,00");
                  
                  while ( list . listagem . size () > index )
                  {
                        if ( list . listagem . get ( index ) . TYPE && list . listagem . get ( index ) . DAY == diaAtual + 1 )
                              OLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                        
                        index++;
                  }
                  
                  index = 0;
                  
                  while ( list . listagem . size () > index )
                  {
                        if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == diaAtual + 1 )
                              OLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                        
                        index++;
                  }
            }
            else if ( diaAtual >= 6 )
            {
                  Linter . donthave . build ();
                  Linter . donthave . run ();
            }
      }
      
      
      
      
      
      
      
      
      
      public void run ()
      {
            this.setVisible ( true );
      }
      
      @Override public void actionPerformed ( ActionEvent e )
      {
      }
}
