enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (val nome: String, val email: String, val formacao: Formacao)


data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudo = ConteudoEducacional("Introdução ao Kotlin")
    val formacao = Formacao("Kotlin", listOf(conteudo) , Nivel.BASICO)
    val usuario = Usuario("João", "joao@hotmail.com", formacao)
    formacao.matricular(usuario)

    // Exibindo detalhes da formação e dos inscritos
    println("Formação: ${formacao.nome}")
    println("Conteúdos:")
    formacao.conteudos.forEach { println("- ${it.nome}: ${it.duracao} minutos") }
    println("Inscritos:")
    formacao.inscritos.forEach { println("- ${it.nome} (${it.email})") }
}