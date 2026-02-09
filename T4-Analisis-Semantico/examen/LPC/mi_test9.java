import java.util.ArrayList;
import java.util.List;

public class test9{
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
        for (Integer x : numeros)
            _lista1.add((x * x));
        ArrayList<Integer> _lista2 = new ArrayList<>();
        for (Integer x : _lista1)
            if ((x * x) > 10)
                _lista2.add((x + 1));
        ArrayList<Integer> lista = _lista2;
        ArrayList<Integer> _lista3 = new ArrayList<>();
        for (Integer x : numeros)
        for (Integer y : numeros)
            if ((y > 0 && x < 10))
                _lista3.add((y * x));
        lista = _lista3;
        System.out.println(lista);
   }
} // test9
