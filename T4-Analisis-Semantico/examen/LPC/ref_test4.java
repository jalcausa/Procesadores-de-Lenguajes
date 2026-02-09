import java.util.ArrayList;
import java.util.List;

public class test4 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(1);
         _temp1.add(2);
         _temp1.add(3);
         _temp1.add(7);
         _temp1.add(11);
         _temp1.add(13);
      ArrayList<Integer> numeros = _temp1;
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
      for(Integer j:numeros) 
            _temp2.add(j*3);
            ArrayList<Integer> _temp3 = new ArrayList<Integer>();
      for(Integer i:_temp2) 
            _temp3.add(i*7+1);
            ArrayList<Integer> lista = _temp3;
      System.out.println(lista);
   }
} // test4
