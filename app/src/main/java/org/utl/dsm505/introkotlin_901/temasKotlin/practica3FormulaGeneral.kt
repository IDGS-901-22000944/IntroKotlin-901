package org.utl.dsm505.introkotlin_901.temasKotlin

fun main() {
    println("Progrma para carcular la formula general")


    print("Ingrese el valor de a: ")
    val a = readLine()?.toDoubleOrNull()

    print("Ingrese el valor de b: ")
    val b = readLine()?.toDoubleOrNull()

    print("Ingrese el valor de c: ")
    val c = readLine()?.toDoubleOrNull()

    if (a == null || b == null || c == null) {
        println("Error: Debes ingresar valores numericos validos")
        return
    }

    if (a == 0.0) {
        println("Error: 'a' no puede ser cero en una ecuación cuadratica")
        return
    }

    val discriminante = b * b - 4 * a * c

    when {
        discriminante > 0 -> {
            val x1 = (-b + Math.sqrt(discriminante)) / (2 * a)
            val x2 = (-b - Math.sqrt(discriminante)) / (2 * a)
            println("Las raices son reales y diferentes:")
            println("x1 = $x1")
            println("x2 = $x2")
        }
        discriminante == 0.0 -> {
            val x = -b / (2 * a)
            println("Las raices son reales e iguales:")
            println("x = $x")
        }
        else -> {
            val parteReal = -b / (2 * a)
            val parteImaginaria = Math.sqrt(-discriminante) / (2 * a)
            println("Las raices son complejas:")
            println("x1 = ${parteReal} + ${parteImaginaria}i")
            println("x2 = ${parteReal} - ${parteImaginaria}i")
        }
    }
}