package org.utl.dsm505.introkotlin_901.temasKotlin



fun saludo(){
    return println("Hola mundo")
}
fun sum(x:Int, y:Int): Int{
    return x + y

}

fun sum2(x:Int, y:Int) = x + y //FUNCIONES DE LINEAS

fun main(){
    saludo()
    println("---------------------------------------------------" +
            "")
    println(sum(2,3))
    println(sum2(2,3))


}