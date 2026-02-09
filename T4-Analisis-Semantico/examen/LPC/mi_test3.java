import java.util.ArrayList;
import java.util.List;

public class test3{
   public static void main(String[] args) {
        ArrayList<Integer> _lista0 = new ArrayList<>();
        _lista0.add(9);
        _lista0.add(8);
        _lista0.add(7);
        _lista0.add(6);
        ArrayList<Integer> lista = _lista0;
        System.out.println(lista);
        ArrayList<Integer> _lista1 = new ArrayList<>();
        _lista1.add(2);
        _lista1.add(3);
        _lista1.add(4);
        lista = _lista1;
        System.out.println(lista);
   }
} // test3
