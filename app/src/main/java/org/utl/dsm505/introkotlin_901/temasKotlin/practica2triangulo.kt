package org.utl.dsm505.introkotlin_901.temasKotlin


fun main() {
    var cantidad: Int

    do {
        println("\nIngrese una cantidad):")
        cantidad = readLine()?.toIntOrNull() ?: 0

        if (cantidad > 0) {
            // Dibujar el triángulo
            for (i in 1..cantidad) {
                // Imprimir espacios en blanco
                for (j in 1..(cantidad - i)) {
                    print(" ")
                }

                // Imprimir asteriscos
                for (k in 1..(2 * i - 1)) {
                    print("*")
                }

                println() // Salto de línea después de cada fila
            }
        } else if (cantidad < 0) {
            println("Por favor ingrese un número positivo o 0 para salir.")
        }
    } while (cantidad != 0)

    println("Adios!")
}