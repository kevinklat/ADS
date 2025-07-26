package atributosestaticos;

public class Cidades {

	public static String cidade = "Gravataí";
			
	
	public static void main(String[] args) {
		
		Cidades c1 = new Cidades();
		Cidades c2 = new Cidades();
		
		System.out.println(c1.cidade);
		System.out.println(c2.cidade);
		
		 c1.cidade = "Alvorada";
		 c2.cidade = "Porto Alegre";
		 
		 System.out.println(""); 
		 System.out.println(c1.cidade);
		 System.out.println(c2.cidade);
		 
		 System.out.println("");
		 System.out.println(Cidades.cidade);
		 
		
		

	}

}
