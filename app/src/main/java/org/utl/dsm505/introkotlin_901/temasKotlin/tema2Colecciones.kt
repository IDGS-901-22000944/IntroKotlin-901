package org.utl.dsm505.introkotlin_901.temasKotlin

fun main(){
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap son como diccionarios
    */

    var readOnlyList:List<String> = listOf("Lunes","Martes","Miercoles","Jueves","Viernes")
    println(readOnlyList)
    println("el primer dia es ${readOnlyList[0]}")
    println("el primer dia es ${readOnlyList.first()}")
    println("el numero de dia es ${readOnlyList.count()}")
    println("el primer dia es ${readOnlyList.size}")
    println("Martes" in readOnlyList)

    var figuras:MutableList<String> = mutableListOf("Circulo", "Cuadarado", "Triangulo")
    println(figuras)
    figuras.add("Pentano")
    println(figuras)
    figuras.removeAt(index =  0)
    println(figuras)
    figuras.remove(element = "Cuadrado")

    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)
}