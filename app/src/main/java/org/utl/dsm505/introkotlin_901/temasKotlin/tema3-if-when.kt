package org.utl.dsm505.introkotlin_901.temasKotlin

fun main(){
    val d:Int
    val e:true
    if(e){
        d=1

    }else{
        d=2
    }

    println(d)
    val numero=if(e) 1 else 2
    println(numero)
    ///------------------------

    print("Ingrese el sueldo del empleado:")
    val sueldo= readLine().toDouble()
    if(sueldo>300){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }

    /////------------ when

    val objeto:Any="Hola"
    when(objeto){
        "1"-> println("Es uno")
        "Hola"-> println("Es un saludo")
        is String -> println("Es un String")
        else -> println("No se que es")

        ////--------range



    }


}
