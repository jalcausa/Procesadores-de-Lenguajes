import java.util.ArrayList;
import java.util.List;

public class pruebas/test8 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(1);
         _temp1.add(2);
         _temp1.add(3);
         _temp1.add(4);
         _temp1.add(5);
      ArrayList<Integer> numeros = _temp1;
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
      for(Integer x:numeros) 
         if (x%2==0)
            _temp2.add(x*x);
            ArrayList<Integer> cuadrados = _temp2;
      System.out.println(cuadrados);
   }
} // pruebas/test8
