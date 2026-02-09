import java.util.ArrayList;
import java.util.List;

public class test7 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(2);
         _temp1.add(3);
         _temp1.add(5);
         _temp1.add(7);
      ArrayList<Integer> numeros = _temp1;
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
      for(Integer x:numeros) 
            _temp2.add(x*x);
            ArrayList<Integer> _temp3 = new ArrayList<Integer>();
      for(Integer x:_temp2) for(Integer y:numeros) 
            _temp3.add(x+y);
            ArrayList<Integer> lista = _temp3;
      System.out.println(lista);
   }
} // test7
