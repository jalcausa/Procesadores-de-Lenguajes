import java.util.ArrayList;
import java.util.List;

public class test7{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(2);
        _lista0.add(3);
        _lista0.add(5);
        _lista0.add(7);
        ArrayList<Integer> numeros = _lista0;
        ArrayList<Integer> _lista1 = new ArrayList<>();
        for (Integer x : numeros)
            _lista1.add((x * x));
        ArrayList<Integer> _lista2 = new ArrayList<>();
        for (Integer x : _lista1)
        for (Integer y : numeros)
            _lista2.add((x + y));
        ArrayList<Integer> lista = _lista2;
        System.out.println(lista);
   }
} // test7
