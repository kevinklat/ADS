import java.util.*;

public class ExemplosColecoesPequenos {

	public static void main(String[] args) {

		// --- List (ArrayList) ---
		// Coleção ordenada que permite elementos duplicados. Acesso por índice é
		// eficiente.
		System.out.println("--- Exemplo de List (ArrayList) ---");
		List<String> listaTarefas = new ArrayList<>();
		listaTarefas.add("Comprar leite"); // 0
		listaTarefas.add("Comprar arroz"); // Dário Gama 1
		listaTarefas.add("Comprar Shampoo"); // Roberta 2
		listaTarefas.add("Comprar agua"); // Marcos 3
		listaTarefas.add("Pagar contas"); // 4
		listaTarefas.add("Comprar leite"); // Duplicado
		System.out.println("Lista de tarefas; " + listaTarefas);
		System.out.println("Primeira tarefa; " + listaTarefas.get(0));
		listaTarefas.remove(0);
		listaTarefas.remove(4); // Dário
		System.out.println("Lista após remover primeira; " + listaTarefas);
		System.out.println("---------------------------------");

		// --- Set (HashSet) ---
		// Coleção que NÃO permite elementos duplicados. Útil para garantir unicidade.
		System.out.println("\n--- Exemplo de Set (HashSet) ---");
		Set<Integer> numerosUnicos = new HashSet<>();
		numerosUnicos.add(10);
		numerosUnicos.add(20);
		numerosUnicos.add(10); // Duplicado, será ignorado
		System.out.println("Conjunto de números únicos; " + numerosUnicos); // Ordem pode variar
		System.out.println("Contém 20? " + numerosUnicos.contains(20));
		System.out.println("---------------------------------");

		// --- Map (HashMap) ---
		// Mapeia chaves únicas para valores. Útil para buscar valores por uma chave.
		System.out.println("\n--- Exemplo de Map (HashMap) ---");
		Map<String, String> dicionario = new HashMap<>();
		dicionario.put("casa", "Local de moradia");
		dicionario.put("computador", "Máquina para processar dados");
		dicionario.put("casa", "Residência"); // Sobrescreve o valor da chave "casa"
		System.out.println("Dicionário; " + dicionario);
		System.out.println("Definição de 'computador'; " + dicionario.get("computador"));
		System.out.println("---------------------------------");

		// --- Queue (LinkedList) ---
		// Coleção usada para manter elementos antes do processamento (geralmente FIFO -
		// First-In, First-Out).
		System.out.println("\n--- Exemplo de Queue (LinkedList) ---");
		Queue<String> filaImpressao = new LinkedList<>();
		filaImpressao.offer("Documento1.pdf"); // Adiciona ao final da fila
		filaImpressao.offer("Imagem.jpg");
		filaImpressao.offer("Planilha.xlsx");
		System.out.println("Fila de impressão; " + filaImpressao);
		String proximo = filaImpressao.poll(); // Remove e retorna o primeiro elemento
		System.out.println("Próximo a imprimir; " + proximo);
		System.out.println("Fila após imprimir; " + filaImpressao);
		System.out.println("Ver próximo (sem remover); " + filaImpressao.peek());
		System.out.println("---------------------------------");

		// --- Deque (LinkedList) ---
		// Fila de duas pontas. Permite adicionar e remover elementos de ambas as
		// extremidades.
		System.out.println("\n--- Exemplo de Deque (LinkedList) ---");
		Deque<String> historicoNavegacao = new LinkedList<>();
		historicoNavegacao.addFirst("Google"); // Adiciona no início
		historicoNavegacao.addLast("YouTube"); // Adiciona no final
		historicoNavegacao.addFirst("OpenAI");
		System.out.println("Histórico de navegação; " + historicoNavegacao);
		String ultimoAcessado = historicoNavegacao.removeLast(); // Remove do final
		System.out.println("Último acessado; " + ultimoAcessado);
		System.out.println("Histórico após voltar; " + historicoNavegacao);
		System.out.println("Primeiro na frente; " + historicoNavegacao.peekFirst());
		System.out.println("---------------------------------");

	}

}