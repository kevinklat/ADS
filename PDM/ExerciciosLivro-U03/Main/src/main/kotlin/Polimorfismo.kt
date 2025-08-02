interface Forma {
    fun desenhar()
}

class Circulo : Forma {
    override fun desenhar() {
        println("Desenhando um círculo.")
    }
}

class Quadrado : Forma {
    override fun desenhar() {
        println("Desenhando um quadrado.")
    }
}

fun main() {
    val formas: Array<Forma> = arrayOf(Circulo(), Quadrado())
    for (forma in formas) {
        forma.desenhar()
    }
}