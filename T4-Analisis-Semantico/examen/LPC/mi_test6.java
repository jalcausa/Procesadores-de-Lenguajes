import java.util.ArrayList;
import java.util.List;

public class test6{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(9);
        _lista0.add(8);
        _lista0.add(7);
        ArrayList<Integer> _lista1 = new ArrayList<>();
        _lista1.add(1);
        _lista1.add(2);
        _lista1.add(3);
        ArrayList<Integer> _lista2 = new ArrayList<>();
        for (Integer n : _lista0)
        for (Integer m : _lista1)
            _lista2.add((n * m));
        ArrayList<Integer> lista = _lista2;
        System.out.println(lista);
   }
} // test6
