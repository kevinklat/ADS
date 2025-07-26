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

//Continua na unidade 2 topico 1 Collections