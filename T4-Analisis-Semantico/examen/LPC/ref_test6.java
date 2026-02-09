import java.util.ArrayList;
import java.util.List;

public class test6 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(9);
         _temp1.add(8);
         _temp1.add(7);
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
         _temp2.add(1);
         _temp2.add(2);
         _temp2.add(3);
      ArrayList<Integer> _temp3 = new ArrayList<Integer>();
      for(Integer n:_temp1) for(Integer m:_temp2) 
            _temp3.add(n*m);
            ArrayList<Integer> lista = _temp3;
      System.out.println(lista);
   }
} // test6
