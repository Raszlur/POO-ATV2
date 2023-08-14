package interfaces;

import interfaces.admin.RegisterFrame;
import interfaces.cdap.CdapFrame;
import interfaces.dialogs.*;
import interfaces.menu.MenuFrame;
import interfaces.user.OrderFrame;

import java.io.IOException;

public class Linter
{
      public static MenuFrame mainGraph;
      
      static {
            try {
                  mainGraph = new MenuFrame ();
            } catch (IOException e) {
                  throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                  throw new RuntimeException(e);
            }
      }
      
      public static OrderFrame orderGraph = new OrderFrame ();
      public static RegisterFrame registerGraph = new RegisterFrame ();
      public static CdapFrame cdapGraph = new CdapFrame ();
      
      // Dialogs
      public static ProgramInfoDialog programInfoDialogDialog = new ProgramInfoDialog();
      public static AdminDialog adminDialog = new AdminDialog();
      public static RegisterAcessDialog acessRegisterDialog;
      
      static {
            try {
                  acessRegisterDialog = new RegisterAcessDialog();
            } catch (IOException e) {
                  throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                  throw new RuntimeException(e);
            }
      }
      
      public static CheckNewPassDialog remakePassDialog;
      
      static {
            try {
                  remakePassDialog = new CheckNewPassDialog();
            } catch (IOException e) {
                  throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                  throw new RuntimeException(e);
            }
      }
      
      public static SetNewPassDialog novonome = new SetNewPassDialog ();
      public static ClosedDayDialog donthave = new ClosedDayDialog ();
      
}
