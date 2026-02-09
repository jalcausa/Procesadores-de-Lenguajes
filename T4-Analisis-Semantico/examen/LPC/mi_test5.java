import java.util.ArrayList;
import java.util.List;

public class test5{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(13);
        _lista0.add(11);
        _lista0.add(9);
        _lista0.add(7);
        _lista0.add(3);
        _lista0.add(2);
        _lista0.add(1);
        ArrayList<Integer> _lista1 = new ArrayList<>();
        for (Integer k : _lista0)
            _lista1.add((k * k));
        ArrayList<Integer> _lista2 = new ArrayList<>();
        for (Integer j : _lista1)
            _lista2.add((j + j));
        ArrayList<Integer> _lista3 = new ArrayList<>();
        for (Integer i : _lista2)
            _lista3.add(((i * 7) + 1));
        ArrayList<Integer> lista = _lista3;
        System.out.println(lista);
   }
} // test5
