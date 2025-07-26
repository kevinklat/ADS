package teste;

import java.util.*;

import dominio.Estudante;
import dominio.ProviderCodigo;

public class Testador{
    
    public static void main(String[] args) {
        
        Estudante e1 = new Estudante(1, "Lucas"); 
        Estudante e2 = new Estudante(2, "Ana");



        List<Estudante> lista = new ArrayList<>();
        lista.add(e2);
        lista.add(e1);
        lista.add(new Estudante(3, "Emanuelle"));
        
        Collections.sort(lista,new ProviderCodigo());
        lista.sort((o1,o2)->o1.getMatricula()-o2.getMatricula());

        System.out.println(lista);

        Map<Integer, Estudante> mapa = new HashMap<>();
        mapa.put(e1.getMatricula(),e1);
        mapa.put(e2.getMatricula(),e2);

        System.out.println(mapa);
        
 
    }
    
} 