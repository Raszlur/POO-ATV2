package data;

import data.Alimentos;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class aliments implements Serializable
{
      public List <data.Alimentos> listagem = new ArrayList <> ();
      
      public void removeEquals ( String comparator )
      {
            List <data.Alimentos> itemsToRemove = new ArrayList <> ();
            
            for ( Alimentos alimento : listagem )
            {
               if ( alimento . NAME . equals ( comparator ) )
               {
                 itemsToRemove . add ( alimento );
                 System.out.println ( alimento . NAME );
               }
               
            }
            
            listagem . removeAll ( itemsToRemove );
      }
      
      @Serial private static final long serialVersionUID = 144L;
}
