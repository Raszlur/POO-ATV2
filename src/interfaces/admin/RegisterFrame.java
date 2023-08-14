package interfaces.admin;

import data.Alimentos;
import data.aliments;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.admin.RLoader;
import interfaces.cdap.CLoader;
import interfaces.menu.MLoader;
import interfaces.user.OLoader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;





public class RegisterFrame extends AWindow
{
      
      public FileNameExtensionFilter imageFilter;
      public aliments list = new aliments ();
      public Alimentos comida = new Alimentos ();
      
      public String remover = null;
      
      public RegisterFrame ()
      {
            super ("CDAP - Cadastro de Cardápio" , 850 , 720 , RLoader. BKG );
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
            this.setIconImage ( CLoader . frame_logo . getImage () );
            this.setCursor ( Curs . CURSORDefault );
            
            // CARREGANDO O OBJETO
            /*
            SE O OBJETO EXISTIR ELE É CARREGADO PARA ESSA INTERFACE
            CASO NÃO EXISTA É CRIADO PARA PODER SER UTILIZADO
            */
            
            FileInputStream fileIn = null;
            ObjectInput in = null;
            boolean isok = true;
            
            try {  fileIn = new FileInputStream ("src//data//listagem.ser" ); }
            catch ( Exception e ) { System.out.println ("Sistema: O arquivo 'aliments' não existe!"); isok = false; }
            
            /* O ARQUIVO EXISTE? */
            if ( isok )
            {
                  try { in = new ObjectInputStream ( fileIn ); }
                  catch ( Exception e ) { System.out.println ("Sistema: 1"); }
                  
                  try { list = ( aliments ) in . readObject (); }
                  catch ( Exception e ) { System.out.println ("Sistema: 2"); }
                  
                  try { in . close (); }
                  catch ( Exception e ) { System.out.println ("Sistema: 3"); }
                  
                  try { fileIn . close (); }
                  catch ( Exception e ) { System.out.println ("Sistema: 4"); }
                  
                  int index = 0;
                  
                  RLoader. DFLM_ListadeBebidas . clear ();
                  RLoader. DFLM_ListadeComidas . clear ();
                  
                  while ( list . listagem . size () > index )
                  {
                        if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                              RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                        
                        index++;
                  }
                  
                  index = 0;
                  
                  while ( list . listagem . size () > index )
                  {
                        if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                              RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                        
                        index++;
                  }
            }
            
            /* O ARQUIVO NÃO EXISTE? */
            else
            {
                  FileOutputStream fileAcess = null;
                  ObjectOutput objcAcess = null;
                  
                  try { fileAcess = new FileOutputStream ( "src//data//listagem.ser" ); }
                  catch ( Exception e ) { System.out.println ("1"); }
                  
                  try { objcAcess = new ObjectOutputStream ( fileAcess ); }
                  catch ( Exception e ) { System.out.println ("2"); }
                  
                  try { objcAcess . writeObject ( list ); }
                  catch ( Exception e ) { System.out.println ("3"); }
                  
                  try { objcAcess . close (); }
                  catch ( Exception e ) { System.out.println ("4"); }
                  
                  try { fileAcess . close (); }
                  catch ( Exception e ) { System.out.println ("5"); }
            }
            
            
            
            
            
            /* LABEL - FRAME NAME */
            RLoader. LBA_FRAMENAME . setForeground ( RLoader. FRG );
            RLoader. LBA_FRAMENAME . setBackground ( RLoader. BK2 );
            RLoader. LBA_FRAMENAME . setOpaque ( true );
            RLoader. LBA_FRAMENAME . setBorder ( MLoader . LBA_Name_Border );
            this.add ( RLoader. LBA_FRAMENAME );
            
            /* LABEL - DIAS TAG */
            RLoader. LBA_DAYSNAME . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_DAYSNAME );
            
            /* LABEL - COMIDA TAG */
            RLoader. LBA_FOOD . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_FOOD );
            
            /* LABEL - DRINK TAG */
            RLoader. LBA_DRINK . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_DRINK );
            
            /* LABEL - DAYS CONTAINER */
            RLoader. LBA_DAYSCONTAINER . setForeground ( RLoader. FRG );
            RLoader. LBA_DAYSCONTAINER . setBackground ( RLoader. BK2 );
            RLoader. LBA_DAYSCONTAINER . setOpaque ( true );
            RLoader. LBA_DAYSCONTAINER . setBorder ( MLoader . LBA_Name_Border );
            
            /* LABEL - SEPARATOR */
            RLoader. LBA_SEPARATOR . setBackground ( RLoader. BK2 );
            RLoader. LBA_SEPARATOR . setOpaque ( true );
            RLoader. LBA_SEPARATOR . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            this.add ( RLoader. LBA_SEPARATOR );
            
            
            /*--------------------------------------------------------------------------------------------*/
            
            /* RADIO BUTTON - SEGUNDA */
            RLoader. R_SEG . addActionListener ( this );
            RLoader. R_SEG . setSelected ( true );
            RLoader. R_SEG . setCursor ( Curs . CURSORHover );
            RLoader. R_SEG . setForeground ( RLoader. FRG );
            
            /* RADIO BUTTON - TERÇA */
            RLoader. R_TER . addActionListener ( this );
            RLoader. R_TER . setCursor ( Curs . CURSORHover );
            RLoader. R_TER . setForeground ( RLoader. FRG );
            
            /* RADIO BUTTON - QUARTA */
            RLoader. R_QUA . addActionListener ( this );
            RLoader. R_QUA . setCursor ( Curs . CURSORHover );
            RLoader. R_QUA . setForeground ( RLoader. FRG );
            
            /* RADIO BUTTON - QUINTA */
            RLoader. R_QUI . addActionListener ( this );
            RLoader. R_QUI . setCursor ( Curs . CURSORHover );
            RLoader. R_QUI . setForeground ( RLoader. FRG );
            
            /* RADIO BUTTON - SEXTA */
            RLoader. R_SEX . addActionListener ( this );
            RLoader. R_SEX . setCursor ( Curs . CURSORHover );
            RLoader. R_SEX . setForeground ( RLoader. FRG );
            
            /* GROUP - TODOS */
            RLoader. Container . add ( RLoader. R_SEG );
            RLoader. Container . add ( RLoader. R_TER );
            RLoader. Container . add ( RLoader. R_QUA );
            RLoader. Container . add ( RLoader. R_QUI );
            RLoader. Container . add ( RLoader. R_SEX );
            
            
            this . add ( RLoader. R_SEG );
            this . add ( RLoader. R_TER );
            this . add ( RLoader. R_QUA );
            this . add ( RLoader. R_QUI );
            this . add ( RLoader. R_SEX );
            this . add ( RLoader. LBA_DAYSCONTAINER );
            
            
            
            
            
            
            
            /*--------------------------------------------------------------------------------------------*/
            
            
            
            
            
            
            
            /* JSCROLLBAR - COMIDAS */
            RLoader. JSCP_Comidas . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 1 ) );
            RLoader. JSCP_Comidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            RLoader. JSCP_Comidas . getVerticalScrollBar () . setBackground ( RLoader. BKG );
            RLoader. JSCP_Comidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = RLoader. BRD; }
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
            RLoader. JL_ListadeComidas . setBackground ( RLoader. BK2 );
            RLoader. JL_ListadeComidas . setForeground ( RLoader. FRG );
            RLoader. JL_ListadeComidas . setSelectionBackground ( RLoader. SE1 );
            RLoader. JL_ListadeComidas . setSelectionForeground ( RLoader. FRG );
            
            RLoader. JL_ListadeComidas . setFixedCellHeight ( 25 );
            RLoader. JL_ListadeComidas . setFixedCellWidth ( 10 );
            RLoader. JL_ListadeComidas . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            RLoader. JL_ListadeComidas . setCursor ( Curs .CURSORHover );
            
            RLoader. JL_ListadeComidas . addListSelectionListener
                         (
                                      e ->
                                      {
                                            if ( !e.getValueIsAdjusting () )
                                            {
                                                  RLoader. JL_ListadeBebidas . clearSelection ();
                                                  remover = RLoader. JL_ListadeComidas . getSelectedValue ();
                                                  
                                                  if ( remover != null ) System.out.println ("Sistema: Comida selecionada { " + remover + " }");
                                            }
                                      }
                         );
            
            /* PANEL - COMIDAS */
            RLoader. PAN_Comidas . add ( RLoader. JSCP_Comidas , BorderLayout . CENTER );
            this.add ( RLoader. PAN_Comidas );
            
            
            
            
            
            
            
            
            
            
            /* JSCROLLBAR - BEBIDAS */
            RLoader. JSCP_Bebidas . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 1 ) );
            RLoader. JSCP_Bebidas . setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
            
            RLoader. JSCP_Bebidas . getVerticalScrollBar () . setBackground ( RLoader. BKG );
            RLoader. JSCP_Bebidas . getVerticalScrollBar () . setUI
                         (
                                      new BasicScrollBarUI ()
                                      {
                                            @Override protected void configureScrollBarColors () { this.thumbColor = RLoader. BRD; }
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
            RLoader. JL_ListadeBebidas . setBackground ( RLoader. BK2 );
            RLoader. JL_ListadeBebidas . setForeground ( RLoader. FRG );
            RLoader. JL_ListadeBebidas . setSelectionBackground ( RLoader. SE1 );
            RLoader. JL_ListadeBebidas . setSelectionForeground ( RLoader. FRG );
            
            RLoader. JL_ListadeBebidas . addListSelectionListener
                         (
                                      e ->
                                      {
                                            if ( !e.getValueIsAdjusting () )
                                            {
                                                  RLoader. JL_ListadeComidas . clearSelection ();
                                                  remover = RLoader. JL_ListadeBebidas . getSelectedValue ();
                                                  
                                                  if ( remover != null ) System.out.println ("Sistema: Bebida selecionada { " + remover + " }");
                                            }
                                      }
                         );
            
            RLoader. JL_ListadeBebidas . setFixedCellHeight ( 25 );
            RLoader. JL_ListadeBebidas . setFixedCellWidth ( 10 );
            RLoader. JL_ListadeBebidas . setBorder ( BorderFactory.createLineBorder ( OLoader . BRD , 3 ) );
            RLoader. JL_ListadeBebidas . setCursor ( Curs . CURSORHover );
            
            
            
            
            /* PANEL - BEBIDAS */
            RLoader. PAN_Bebidas . add ( RLoader. JSCP_Bebidas , BorderLayout . CENTER );
            this.add ( RLoader. PAN_Bebidas );
            
            
            
            //////////////////////////////////////////////////////////////////////////////////////////
            
            
            
            /* TEXT FIELD - FOOD NAME*/
            RLoader. TX_FOODNAME . setForeground ( RLoader. FRG );
            RLoader. TX_FOODNAME . setBackground ( RLoader. BK2 );
            RLoader. TX_FOODNAME . setBorder ( BorderFactory.createLineBorder ( OLoader . BRD , 3 )  );
            RLoader. TX_FOODNAME . setHorizontalAlignment ( JTextField.CENTER );
            RLoader. TX_FOODNAME . setFont ( new Font ( "Verdana" , Font.PLAIN , 16 ) );
            RLoader. TX_FOODNAME . setCaretColor ( new Color (244, 255, 0) );
            
            RLoader. TX_FOODNAME . addActionListener ( this );
            this.add ( RLoader. TX_FOODNAME );
            
            /* LABEL - INSERT FOOD */
            RLoader. LBA_INSERTNAME . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_INSERTNAME );
            
            
            
            
            
            
            /* LABEL - SET TYPE FOOD */
            RLoader. LBA_INSERTTYPE . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_INSERTTYPE );
            
            /* RADIOBUTTONS - TYPES */
            RLoader. RAD_FOOD . addActionListener ( this );
            RLoader. RAD_FOOD . setSelected ( true );
            RLoader. RAD_FOOD . setCursor ( Curs . CURSORHover );
            RLoader. RAD_FOOD . setForeground ( new Color (83, 255, 223) );
            this.add ( RLoader. RAD_FOOD );
            
            RLoader. RAD_DRINK . addActionListener ( this );
            RLoader. RAD_DRINK . setCursor ( Curs . CURSORHover );
            RLoader. RAD_DRINK . setForeground ( new Color (83, 255, 223) );
            this.add ( RLoader. RAD_DRINK );
            
            RLoader. TYPECONTAINER . add ( RLoader. RAD_DRINK );
            RLoader. TYPECONTAINER . add ( RLoader. RAD_FOOD );
            
            
            
            
            
            
            
            /* LABEL - SET PRICE */
            RLoader. LBA_ITEMPRICE . setForeground ( RLoader. FRG );
            this.add ( RLoader. LBA_ITEMPRICE );
            
            /* TEXT FIELD - ITEM PRICE */
            RLoader. TX_ITEMPRICE . setForeground ( RLoader. FRG );
            RLoader. TX_ITEMPRICE . setBackground ( RLoader. BK2 );
            RLoader. TX_ITEMPRICE . setBorder ( BorderFactory.createLineBorder ( OLoader . BRD , 3 )  );
            RLoader. TX_ITEMPRICE . setHorizontalAlignment ( JTextField.CENTER );
            RLoader. TX_ITEMPRICE . setFont ( new Font ( "Verdana" , Font.PLAIN , 16 ) );
            RLoader. TX_ITEMPRICE . setCaretColor ( new Color (244, 255, 0 ) );
            
            RLoader. TX_ITEMPRICE . addActionListener ( this );
            this.add ( RLoader. TX_ITEMPRICE );
            
            
            
            
            
            /* BUTTON - ADD IMAGE */
            RLoader. BTN_LOADIMAGE . addActionListener ( this );
            RLoader. BTN_LOADIMAGE . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            RLoader. BTN_LOADIMAGE . setBackground ( OLoader . BK2 );
            RLoader. BTN_LOADIMAGE . setForeground ( OLoader . FRG );
            RLoader. BTN_LOADIMAGE . setCursor ( Curs . CURSORHover );
            this . add ( RLoader. BTN_LOADIMAGE );
            
            
            /* BUTTON - ADD ALIMENTO */
            RLoader. BTN_SAVEALIM . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            RLoader. BTN_SAVEALIM . setBackground ( OLoader . BK2 );
            RLoader. BTN_SAVEALIM . setForeground ( OLoader . FRG );
            RLoader. BTN_SAVEALIM . setCursor ( Curs . CURSORHover );
            this . add ( RLoader. BTN_SAVEALIM );
            
            
            /* BUTTON - RETURN */
            RLoader. BTN_RETURNMENU . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            RLoader. BTN_RETURNMENU . setBackground ( OLoader . BK2 );
            RLoader. BTN_RETURNMENU . setForeground ( OLoader . FRG );
            RLoader. BTN_RETURNMENU . setCursor ( Curs . CURSORHover );
            this . add ( RLoader. BTN_RETURNMENU );
            
            /* BUTTON - REMOVE */
            RLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
            RLoader. BTN_REMOVE . setBackground ( OLoader . BK2 );
            RLoader. BTN_REMOVE . setForeground ( OLoader . FRG );
            RLoader. BTN_REMOVE . setCursor ( Curs . CURSORHover );
            this . add ( RLoader. BTN_REMOVE );
            
            
            /* IMAGE */
            
            JLabel holder = new JLabel ( RLoader. IMAGE );
            RLoader. IMAGE_CONTAINER . setOpaque ( false );
            
            RLoader. IMAGE_CONTAINER . add ( holder );
            this.add ( RLoader. IMAGE_CONTAINER );
            
            ///////////////////
            /* RETURN BUTTON */
            ///////////////////
            RLoader. BTN_RETURNMENU . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  RLoader. BTN_RETURNMENU . setBorder ( BorderFactory.createLineBorder ( RLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  RLoader. BTN_RETURNMENU . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  Linter. registerGraph . dispose ();
                                                  Linter. mainGraph . build ();
                                                  try { Linter. mainGraph . run (); }
                                                  catch ( Exception ex ) { System.out.println ("Error"); }
                                            }
                                      }
                         );
            ///////////////////
            
            
            
            
            
            //////////////////
            /* IMAGE BUTTON */
            //////////////////
            RLoader. BTN_LOADIMAGE . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  RLoader. BTN_LOADIMAGE . setBorder ( BorderFactory.createLineBorder ( RLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  RLoader. BTN_LOADIMAGE . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  File selectedFile;
                                                  JFileChooser loadImage = new JFileChooser ();
                                                  
                                                  
                                                  //* * * * * * * * *//
                                                  //* Customization *//
                                                  //* * * * * * * * *//
                                                  loadImage . setDialogTitle ("CDAP - Escolha uma Imagem");
                                                  loadImage . setCurrentDirectory ( new File ( System.getProperty ( "user.home" ) ) );
                                                  imageFilter = new FileNameExtensionFilter ("Imagens", "jpg", "jpeg", "png", "gif");
                                                  loadImage . setFileFilter ( imageFilter ); // Filtra por tipos de arquivo específicos
                                                  //* * * * * * * * *//
                                                  
                                                  
                                                  
                                                  int resultado = loadImage.showOpenDialog (null );
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  if ( resultado == JFileChooser.APPROVE_OPTION )
                                                  {
                                                        selectedFile = loadImage . getSelectedFile ();
                                                        comida . IMAGE = new ImageIcon ( selectedFile . getAbsolutePath () );
                                                  }
                                            }
                                      }
                         );
            ///////////////////
            
            
            
            
            
            /////////////////////
            /* ADD FOOD BUTTON */
            /////////////////////
            RLoader. BTN_SAVEALIM . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  RLoader. BTN_SAVEALIM . setBorder ( BorderFactory.createLineBorder ( RLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  RLoader. BTN_SAVEALIM . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  comida . NAME = RLoader. TX_FOODNAME . getText ();
                                                  
                                                  comida . TYPE = RLoader.RAD_DRINK.isSelected ();
                                                  
                                                  String getcher = RLoader. TX_ITEMPRICE . getText ();
                                                  comida . PRICE = Double.parseDouble ( getcher );
                                                  
                                                  if      ( RLoader. R_SEG . isSelected () ) comida . DAY = 2;
                                                  else if ( RLoader. R_TER . isSelected () ) comida . DAY = 3;
                                                  else if ( RLoader. R_QUA . isSelected () ) comida . DAY = 4;
                                                  else if ( RLoader. R_QUI . isSelected () ) comida . DAY = 5;
                                                  else if ( RLoader. R_SEX . isSelected () ) comida . DAY = 6;
                                                  
                                                  if ( comida . PRICE != 0 && !comida . NAME . isEmpty () )
                                                  {
                                                        
                                                        list . listagem . add ( new Alimentos ( comida . DAY , comida . PRICE , comida . IMAGE , comida . NAME , comida . TYPE ) );
                                                        
                                                        RLoader. DFLM_ListadeBebidas . clear ();
                                                        RLoader. DFLM_ListadeComidas . clear ();
                                                        
                                                        int index = 0;
                                                        
                                                        while ( list . listagem . size () > index )
                                                        {
                                                              if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                                    RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                                                              
                                                              index++;
                                                        }
                                                        
                                                        index = 0;
                                                        
                                                        while ( list . listagem . size () > index )
                                                        {
                                                              if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                                    RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                                                              
                                                              index++;
                                                        }
                                                        
                                                        RLoader. TX_FOODNAME . setText ( null );
                                                        RLoader. TX_ITEMPRICE . setText ( null );
                                                        comida . IMAGE = null;
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        // SALVAMENTO DA ATUALIZAÇÃO
                                                        FileOutputStream fileAcess;
                                                        ObjectOutput objcAcess;
                                                        
                                                        try { fileAcess = new FileOutputStream ( "src//data//listagem.ser" ); }
                                                        catch ( FileNotFoundException ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { objcAcess = new ObjectOutputStream ( fileAcess ); }
                                                        catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        // FECHAMENTO DE OBJETO
                                                        try { objcAcess . writeObject ( list ); }
                                                        catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { objcAcess . close (); }
                                                        catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { fileAcess . close (); }
                                                        catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        
                                                        
                                                        // ATUALIZAÇÃO DO OBJETO ATUAL
                                                        FileInputStream fileIn = null;
                                                        ObjectInput in;
                                                        
                                                        try {  fileIn = new FileInputStream ("src//data//listagem.ser" ); }
                                                        catch ( Exception aexception ) { System.out.println ("O arquivo não existe!"); }
                                                        
                                                        try { in = new ObjectInputStream ( fileIn ); }
                                                        catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { list = ( aliments ) in . readObject (); }
                                                        catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { in . close (); }
                                                        catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                        
                                                        try { fileIn . close (); }
                                                        catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                  }
                                            }
                                      }
                         );
            
            
            
            
            
            /////////////////////
            /* ADD REMOVE BUTTON */
            /////////////////////
            RLoader. BTN_REMOVE . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  RLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( RLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  RLoader. BTN_REMOVE . setBorder ( BorderFactory.createLineBorder ( RLoader. BRD , 3 ) );
                                            }
                                            @Override public void mouseClicked ( MouseEvent e )
                                            {
                                                  list . removeEquals ( remover );
                                                  
                                                  RLoader. DFLM_ListadeBebidas . clear ();
                                                  RLoader. DFLM_ListadeComidas . clear ();
                                                  
                                                  int index = 0;
                                                  
                                                  while ( list . listagem . size () > index )
                                                  {
                                                        if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                              RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                                                        
                                                        System.out.println ( list . listagem . get ( index ) . NAME );
                                                        index++;
                                                  }
                                                  
                                                  index = 0;
                                                  
                                                  while ( list . listagem . size () > index )
                                                  {
                                                        if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                              RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                                                        
                                                        System.out.println ( list . listagem . get ( index ) . NAME );
                                                        index++;
                                                  }
                                                  
                                                  // SALVAMENTO DA ATUALIZAÇÃO
                                                  FileOutputStream fileAcess;
                                                  ObjectOutput objcAcess;
                                                  
                                                  try { fileAcess = new FileOutputStream ( "src//data//listagem.ser" ); }
                                                  catch ( FileNotFoundException ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { objcAcess = new ObjectOutputStream ( fileAcess ); }
                                                  catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  // FECHAMENTO DE OBJETO
                                                  try { objcAcess . writeObject ( list ); }
                                                  catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { objcAcess . close (); }
                                                  catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { fileAcess . close (); }
                                                  catch ( IOException ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  
                                                  
                                                  // ATUALIZAÇÃO DO OBJETO ATUAL
                                                  FileInputStream fileIn = null;
                                                  ObjectInput in;
                                                  
                                                  try {  fileIn = new FileInputStream ("src//data//listagem.ser" ); }
                                                  catch ( Exception aexception ) { System.out.println ("O arquivo não existe!"); }
                                                  
                                                  try { in = new ObjectInputStream ( fileIn ); }
                                                  catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { list = ( aliments ) in . readObject (); }
                                                  catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { in . close (); }
                                                  catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  try { fileIn . close (); }
                                                  catch ( Exception ex ) { throw new RuntimeException ( ex ); }
                                                  
                                                  list . removeEquals ( remover );
                                                  
                                                  RLoader. DFLM_ListadeBebidas . clear ();
                                                  RLoader. DFLM_ListadeComidas . clear ();
                                                  
                                                  index = 0;
                                                  
                                                  while ( list . listagem . size () > index )
                                                  {
                                                        if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                              RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                                                        
                                                        System.out.println ( list . listagem . get ( index ) . NAME );
                                                        index++;
                                                  }
                                                  
                                                  index = 0;
                                                  
                                                  while ( list . listagem . size () > index )
                                                  {
                                                        if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == comida . DAY )
                                                              RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                                                        
                                                        System.out.println ( list . listagem . get ( index ) . NAME );
                                                        index++;
                                                  }
                                            }
                                      }
                         );
            
            
            
            
            
            
      }
      
      public void build ()
      {
            System.out.println (" REGISTER ");
      }
      
      
      
      public void run ()
      {
            this.add ( RLoader . TX_ITEMPRICE );
            
            //////////////////////////
            // PROGRAM FINALIZATION //
            //////////////////////////
            this.setVisible ( true );
            
      }
      

      
      @Override public void actionPerformed ( ActionEvent e )
      {
              if ( e.getSource () == RLoader.R_SEG )
              {
                RLoader. DFLM_ListadeBebidas . clear ();
                RLoader. DFLM_ListadeComidas . clear ();
                
                int index = 0;
                
                while ( list . listagem . size () > index )
                {
                     if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                       RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                       
                     System.out.println ( list . listagem . get ( index ) . NAME );
                     index++;
                }
                
                index = 0;
                
                while ( list . listagem . size () > index )
                {
                     if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 2 )
                       RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                       
                     System.out.println ( list . listagem . get ( index ) . NAME );
                     index++;
                }
              }
            
              if ( e.getSource () == RLoader.R_TER )
              {
                    RLoader. DFLM_ListadeBebidas . clear ();
                    RLoader. DFLM_ListadeComidas . clear ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 3 )
                                RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 3 )
                                RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              if ( e.getSource () == RLoader.R_QUA )
              {
                    RLoader. DFLM_ListadeBebidas . clear ();
                    RLoader. DFLM_ListadeComidas . clear ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 4 )
                                RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 4 )
                                RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              if ( e.getSource () == RLoader.R_QUI )
              {
                    RLoader. DFLM_ListadeBebidas . clear ();
                    RLoader. DFLM_ListadeComidas . clear ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 5 )
                                RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 5 )
                                RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
              
              if ( e.getSource () == RLoader.R_SEX )
              {
                    RLoader. DFLM_ListadeBebidas . clear ();
                    RLoader. DFLM_ListadeComidas . clear ();
                    
                    int index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 6 )
                                RLoader. DFLM_ListadeBebidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
                    
                    index = 0;
                    
                    while ( list . listagem . size () > index )
                    {
                          if ( ! list . listagem . get ( index ) . TYPE && list . listagem .get ( index ) . DAY == 6 )
                                RLoader. DFLM_ListadeComidas . addElement ( list . listagem . get ( index ) . NAME );
                          
                          System.out.println ( list . listagem . get ( index ) . NAME );
                          index++;
                    }
              }
      }
}
