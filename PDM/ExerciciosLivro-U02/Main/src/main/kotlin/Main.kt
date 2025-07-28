//Livro PDM Unidade 2 Topico 1

/* //Declaração de Variaveis
 fun main() {
    //declarando uma variavel
    var idade: Int = 35

    //alterando variavel
    idade = 36
    print(idade)
//    //declarando uma variavel
//    val pi: Double = 3.14
//
//    //Erro, val nao pode mudar
//    pi = 3,1415
//
//    print(pi)

    // Declarando variavel
    var nome: String? = "Kevin"

    //Alterando variavel para null
    nome = null

    print(nome)

    //declarando variavel sem tipo
    var salario = 2500.50

    print(salario)
}*/

/*
//Declaração de Arrays
fun main() {
    val numeros: IntArray = intArrayOf(1, 2, 3, 4, 5)

    val frutas = arrayOf("Maçã", "Banana", "Morango")

    val primeiroNumero = numeros[0]
    val segundaFruta = frutas[1]
}
*/

/*
//Função que calcula a média de um array de números inteiros
fun calcularMedia(numeros: IntArray): Double {
    //Variável para armazenar a soma dos números
    var soma = 0

    //Loop que percorre cada número do array e soma ao acumulador
    for (numero in numeros) {
        soma += numero
    }

    // Retorna a média calculada dividindo a soma pelo tamanho do array
    return soma.toDouble() / numeros.size
}

fun main() {
    //Array com as notas dos alunos
    val notas = intArrayOf(80, 90, 75, 60)
    //Calcula a média das notas chamando a função calcularMedia
    val media = calcularMedia(notas)

    //Imprime o resultado da média
    println("A media das notas é: $media")

}*/

/*
//Listas Mutaveis
fun main(){
    val numeros: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    //Adicionando
    numeros.add(6)
    //Removendo
    numeros.remove(3)
    //Imprimindo
    println("Lista de numeros: $numeros")

}*/

/*
//Conjuntos
fun main (){
    val notas: MutableSet<Double> = mutableSetOf( 8.5, 6.7, 9.4)
    //Adicionando um valor
    notas.add(7.0)
    //removendo um valor
    notas.remove(6.7)
    //imprimindo
    println("Conjunto de notas: $notas")
}*/

/*
//Funções de Extensão
fun main () {
    val numeros = listOf(1, 2, 3, 4, 5)
    val quadrados = numeros.map{it * it}
    val pares = numeros.filter { it % 2 ==0}

    println("Numeros: $numeros")
    println("Quadrado dos numeros: $quadrados")
    println("Numeros pares: $pares")
}*/