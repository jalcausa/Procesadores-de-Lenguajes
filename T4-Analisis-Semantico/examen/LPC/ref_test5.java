import java.util.ArrayList;
import java.util.List;

public class test5 {
   public static void main(String[] args) {
      ArrayList<Integer> _temp1 = new ArrayList<Integer>();
         _temp1.add(13);
         _temp1.add(11);
         _temp1.add(9);
         _temp1.add(7);
         _temp1.add(3);
         _temp1.add(2);
         _temp1.add(1);
      ArrayList<Integer> _temp2 = new ArrayList<Integer>();
      for(Integer k:_temp1) 
            _temp2.add(k*k);
            ArrayList<Integer> _temp3 = new ArrayList<Integer>();
      for(Integer j:_temp2) 
            _temp3.add(j+j);
            ArrayList<Integer> _temp4 = new ArrayList<Integer>();
      for(Integer i:_temp3) 
            _temp4.add(i*7+1);
            ArrayList<Integer> lista = _temp4;
      System.out.println(lista);
   }
} // test5
