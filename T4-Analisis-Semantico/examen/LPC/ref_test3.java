import java.util.ArrayList;
import java.util.List;

public class test3 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(9);
         _temp1.add(8);
         _temp1.add(7);
         _temp1.add(6);
      ArrayList<Integer> lista = _temp1;
      System.out.println(lista);
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
         _temp2.add(2);
         _temp2.add(3);
         _temp2.add(4);
      lista = _temp2;
      System.out.println(lista);
   }
} // test3
