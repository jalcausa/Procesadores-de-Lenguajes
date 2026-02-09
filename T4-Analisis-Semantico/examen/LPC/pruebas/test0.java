import java.util.ArrayList;
import java.util.List;

public class pruebas/test0{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(1);
        _lista0.add(2);
        _lista0.add(3);
        _lista0.add(4);
        _lista0.add(5);
        ArrayList<Integer> numeros = _lista0;
        ArrayList<Integer> _lista1 = new ArrayList<>();
        for (Integer x : numeros)
            _lista1.add((x * x));
        ArrayList<Integer> cuadrados = _lista1;
        System.out.println(cuadrados);
   }
} // pruebas/test0
