import interfaces.Linter;

import javax.swing.*;
import java.io.IOException;



public class Main
{
      public static void main ( String [] args ) throws IOException, ClassNotFoundException
      {
              Linter . mainGraph . build ();
              Linter . mainGraph . run   ();
      }
}
