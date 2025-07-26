package metodosestaticos;

public class MetodoEstatico {
	
	public static int somar(int n1, int n2) {
		return n1+n2;
	}

	public static void main(String[] args) {
		
		//MetodoEstatico m = new MetodoEstatico();
		System.out.println(MetodoEstatico.somar(6, 6));

	}

}
