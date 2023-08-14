package data;
import javax.swing.*;
import java.io.Serializable;


public class Alimentos implements Serializable
{
      public boolean TYPE;
      public String NAME;
      public double PRICE;
      public ImageIcon IMAGE;
      public int DAY;
      
      public Alimentos ( int Day , double Price , ImageIcon Image , String Name , boolean Type )
      {
            this.DAY = Day;
            this.NAME = Name;
            this.PRICE = Price;
            this.IMAGE = Image;
            this.TYPE = Type;
      }
      public Alimentos () {}
}
