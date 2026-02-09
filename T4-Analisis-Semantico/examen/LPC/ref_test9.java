import java.util.ArrayList;
import java.util.List;

public class test9 {
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
      for(Integer x:numeros) 
            _temp2.add(x*x);
            ArrayList<Integer> _temp3 = new ArrayList<Integer>();
      for(Integer x:_temp2) 
         if (x*x>10)
            _temp3.add(x+1);
            ArrayList<Integer> lista = _temp3;
      ArrayList<Integer> _temp4 = new ArrayList<Integer>();
      for(Integer x:numeros) for(Integer y:numeros) 
         if (y>0&&x<10)
            _temp4.add(y*x);
            lista = _temp4;
      System.out.println(lista);
   }
} // test9
