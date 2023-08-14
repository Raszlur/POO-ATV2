package interfaces.menu;

import data.acess;
import graphics.AWindow;
import images.cursors.Curs;
import interfaces.Linter;
import interfaces.menu.MLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


// Interface gráfica do Menu Principal
public class MenuFrame extends AWindow
{
      
      public acess input = new acess ();
      public String [] options = { "Acessar Sistema" , "Redefinir Senha" };
      
      private static JOptionPane placeGetter = new JOptionPane ("Título");
      
      public MenuFrame () throws IOException, ClassNotFoundException, FileNotFoundException {
            super ("CDAP - Menu Principal" , 620 , 500 , MLoader. BKG );
            // Tentar carregar o objeto acess do arquivo
            FileInputStream fileIn = null;
            ObjectInput in;
            boolean isok = true;  // Definir como true inicialmente
            try {
                  fileIn = new FileInputStream("src//data//acess.ser");
            } catch (FileNotFoundException e) {
                  System.out.println("Sistema: O arquivo 'acess' não existe!");
                  isok = false;
            }
            
            if (isok) {
                  in = new ObjectInputStream(fileIn);
                  input = (acess) in.readObject();
                  in.close();
                  fileIn.close();
            } else {
                  // Criar um novo objeto "input" e salvá-lo no arquivo
                  input = new acess();
                  FileOutputStream fileAcess = new FileOutputStream("src//data//acess.ser");
                  ObjectOutput objcAcess = new ObjectOutputStream(fileAcess);
                  
                  objcAcess.writeObject(input);
                  objcAcess.close();
                  fileAcess.close();
            }
            
            
            
            this.setLocationRelativeTo ( null );
            this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
            this.setIconImage ( MLoader. frame_logo . getImage () );
            this.setCursor ( Curs . CURSORDefault );
            
            
            /* LABEL - NOME */
            MLoader. LBA_Name . setForeground ( MLoader.FRG );
            MLoader. LBA_Name . setBackground ( MLoader. BK2 );
            MLoader. LBA_Name . setOpaque ( true );
            MLoader. LBA_Name . setBorder ( MLoader. LBA_Name_Border );
            this . add ( MLoader. LBA_Name );
            
            
            
            /* LABEL - MENU ANIMATION */
            MLoader. LBA_Image . setForeground ( MLoader.FRG );
            MLoader. LBA_Image . setBackground ( MLoader. BK2 );
            MLoader. LBA_Image . setIcon ( MLoader. ufj_logo );
            this . add ( MLoader. LBA_Image );
            
            
            
            /* BUTTON - CDAP */
            MLoader. BTN_Cdap . addActionListener ( this );
            MLoader. BTN_Cdap . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            MLoader. BTN_Cdap . setBackground ( MLoader. BK2 );
            MLoader. BTN_Cdap . setForeground ( MLoader. FRG );
            
            MLoader. BTN_Cdap . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Cdap . setBorder ( BorderFactory.createLineBorder ( MLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Cdap . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
                                            }
                                      }
                         );
            this . add ( MLoader. BTN_Cdap );
            
            
            
            /* BUTTON - PEDIDO */
            MLoader. BTN_Order . addActionListener ( this );
            MLoader. BTN_Order . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            MLoader. BTN_Order . setBackground ( MLoader. BK2 );
            MLoader. BTN_Order . setForeground ( MLoader. FRG );
            MLoader. BTN_Order . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Order . setBorder ( BorderFactory.createLineBorder ( MLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Order . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
                                            }
                                      }
                         );
            this . add ( MLoader. BTN_Order );
            
            
            
            /* BUTTON - ADMINISTRAÇÃO */
            MLoader. BTN_Admin . addActionListener ( this );
            MLoader. BTN_Admin . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            MLoader. BTN_Admin . setBackground ( MLoader. BK2 );
            MLoader. BTN_Admin . setForeground ( MLoader. FRG );
            MLoader. BTN_Admin . setIcon ( MLoader. adm_logo );
            MLoader. BTN_Admin . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Admin . setBorder ( BorderFactory.createLineBorder ( MLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Admin . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
                                            }
                                      }
                         );
            this . add ( MLoader. BTN_Admin );
            
            /* BUTTON - INFO */
            MLoader. BTN_Info . addActionListener ( this );
            MLoader. BTN_Info . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
            MLoader. BTN_Info . setBackground ( MLoader. BK2 );
            MLoader. BTN_Info . setForeground ( MLoader. FRG );
            MLoader. BTN_Info . setIcon ( MLoader. info_logo );
            MLoader. BTN_Info . addMouseListener
                         (
                                      new MouseAdapter ()
                                      {
                                            @Override public void mouseEntered ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Info . setBorder ( BorderFactory.createLineBorder ( MLoader. BR2 , 3 ) );
                                            }
                                            @Override public void mouseExited ( MouseEvent e )
                                            {
                                                  MLoader. BTN_Info . setBorder ( BorderFactory.createLineBorder ( MLoader. BRD , 3 ) );
                                            }
                                      }
                         );
            this . add ( MLoader. BTN_Info );
            
            // CARREGAMENTO DO OBJETO RESPONSÁVEL PELO ACESSO
            
            // FUNCIONA DA SEGUINTE FORMA
            /*
               1º Instanciamos 3 variáveis para o carregamento ( Carrega objeto , Leitura do objeto , checagem )
               2º Tentamos executar a leitura, caso dê erro o programa carrega o objeto predefinido e o salva para a próxima execução
               3º Caso o objeto exista ele é carregado para o endereço do objeto original
            */
            

      }
      
      
      public void build ()
      {
            System.out.println ("MENU PRINCIPAL");
      }
      
      
      public void run () throws IOException, ClassNotFoundException
      {
            // Tentar carregar o objeto acess do arquivo
            FileInputStream fileIn = null;
            ObjectInput in;
            boolean isok = true;  // Definir como true inicialmente
            try {
                  fileIn = new FileInputStream("src//data//acess.ser");
            } catch (FileNotFoundException e) {
                  System.out.println("Sistema: O arquivo 'acess' não existe!");
                  isok = false;
            }
            
            if (isok) {
                  in = new ObjectInputStream(fileIn);
                  input = (acess) in.readObject();
                  in.close();
                  fileIn.close();
            } else {
                  // Criar um novo objeto "input" e salvá-lo no arquivo
                  input = new acess();
                  FileOutputStream fileAcess = new FileOutputStream("src//data//acess.ser");
                  ObjectOutput objcAcess = new ObjectOutputStream(fileAcess);
                  
                  objcAcess.writeObject(input);
                  objcAcess.close();
                  fileAcess.close();
            }
            this.setVisible(true);
      }
      
      
      
      
      @Override public void actionPerformed ( ActionEvent e )
      {
            
               if ( e.getSource () == MLoader. BTN_Cdap )
               {
                     Linter. mainGraph . dispose ();
                     Linter. cdapGraph . build ();
                     Linter. cdapGraph . run ();
               }
               
               
               
               
               
               else if ( e.getSource () == MLoader. BTN_Order )
               {
                     Linter. mainGraph . dispose ();
                     Linter. orderGraph . build ();
                     Linter. orderGraph . run ();
               }
               
               
               
               
               
               // CASO O USUÁRIO CLIQUE NO BOTÃO DE INFORMAÇÃO // UMA DIALOG BOX IRÁ SER ABERTA // COM ALGUMAS INFORMAÇÕES //
               else if ( e.getSource () == MLoader. BTN_Info )
               {
                   Linter.programInfoDialogDialog. build ();
                   Linter.programInfoDialogDialog. run   ();
               }
            
               
               
               
               
               // CASO O USUÁRIO CLIQUE NO BOTÃO DE ADMINISTRAÇÃO // UMA DIALOG BOX IRÁ SER ABERTA // COM UM VALIDADOR //
               else if ( e.getSource () == MLoader. BTN_Admin )
               {
                    Linter. mainGraph . dispose ();
                    Linter. adminDialog . build ();
                    Linter. adminDialog . run   ();
               }

}
}