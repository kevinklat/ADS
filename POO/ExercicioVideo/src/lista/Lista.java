package lista;
import java.util.ArrayList;
import java.util.List;

public class Lista {

    public static void main(String[] args) {
        
        List<String> lista = new ArrayList<>();

        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        for (String s:lista) {
            System.out.println("Letra: "+s);
        }
        System.out.println("");
        lista.remove("B");
        for (String s:lista) {
            System.out.println("Letra: "+s);
        }

    }

}
