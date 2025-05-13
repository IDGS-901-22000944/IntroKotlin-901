package org.utl.dsm505.introkotlin_901.temasKotlin

class FigurasGeometricas {
    class Cuadrado {
        fun calcularArea() {
            println("\nCALCULAR AREA DE CUADRADO")
            print("Ingrese el lado del cuadrado: ")
            val lado = readLine()?.toDoubleOrNull()
            if (lado != null && lado > 0) {
                val area = lado * lado
                println("El area del cuadrado es: $area")
            } else {
                println("Error: Ingrese un valor numerico que sea positivo.")
            }
        }
    }

    class Pentagono {
        fun calcularArea() {
            println("\nCALCULAR AREA DE PENTAGONO")
            print("Ingrese el perimetro: ")
            val perimetro = readLine()?.toDoubleOrNull()
            print("Ingrese el apotema: ")
            val apotema = readLine()?.toDoubleOrNull()

            if (perimetro != null && apotema != null && perimetro > 0 && apotema > 0) {
                val area = (perimetro * apotema) / 2
                println("El area del pentagono es: $area")
            } else {
                println("Error ingresa los valores numericos que sean positivos.")
            }
        }
    }

    class Triangulo {
        fun calcularArea() {
            println("\nCALCULAR AREA DE TRIANGULO")
            print("Ingrese la base: ")
            val base = readLine()?.toDoubleOrNull()
            print("Ingrese la altura: ")
            val altura = readLine()?.toDoubleOrNull()

            if (base != null && altura != null && base > 0 && altura > 0) {
                val area = (base * altura) / 2
                println("El area del triangulo es: $area")
            } else {
                println("Error al ingresar los valores numericos que sean positivos.")
            }
        }
    }

    class Circulo {
        fun calcularArea() {
            println("\nCALCULAR AREA DE CIRCULO")
            print("Ingrese el radio del circulo: ")
            val radio = readLine()?.toDoubleOrNull()
            if (radio != null && radio > 0) {
                val pi = 3.1415
                val area = pi * radio * radio
                println("El area del circulo es: $area")
            } else {
                println("Error: Ingrese un valor numerico que sea positivo.")
            }
        }
    }

    fun mostrarMenu() {
        var opcion: Int
        do {
            println("\nMENU DE FIGURAS GEOMETRICAS")
            println("1. Cuadrado")
            println("2. Pentagono")
            println("3. Triangulo")
            println("4. Circulo")
            println("5. Salir")
            print("Seleccione una opcion: ")

            opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> Cuadrado().calcularArea()
                2 -> Pentagono().calcularArea()
                3 -> Triangulo().calcularArea()
                4 -> Circulo().calcularArea()
                5 -> println("Byee")
                else -> println("Intenta de nuevo.")
            }
        } while (opcion != 5)
    }
}

fun main() {
    val figuras = FigurasGeometricas()
    figuras.mostrarMenu()
}