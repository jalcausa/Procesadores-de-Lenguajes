import java.util.ArrayList;
import java.util.List;

public class test4{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(1);
        _lista0.add(2);
        _lista0.add(3);
        _lista0.add(7);
        _lista0.add(11);
        _lista0.add(13);
        ArrayList<Integer> numeros = _lista0;
        ArrayList<Integer> _lista1 = new ArrayList<>();
        for (Integer j : numeros)
            _lista1.add((j * 3));
        ArrayList<Integer> _lista2 = new ArrayList<>();
        for (Integer i : _lista1)
            _lista2.add(((i * 7) + 1));
        ArrayList<Integer> lista = _lista2;
        System.out.println(lista);
   }
} // test4
