package playground

object RomanTranslator extends App{
  val STEP = 2
  val carateresRomanos = Array("I", "V", "X", "L", "C", "D", "M", "i", "v")
  
  def traductorNumerosCinta(numero:Int, desplazamiento:Int):String = {
    val numberSequence = Array("a","aa","aaa","ab","b","ba","baa","baaa","ac")
    val numeroTraducido: String = numberSequence(numero-1)
    return numeroTraducido.replaceAll("a", carateresRomanos(desplazamiento)).replaceAll("b", carateresRomanos(desplazamiento+1)).replaceAll("c", carateresRomanos(desplazamiento+2))
  }  
  
  def calcularNumeroRomano(numero:Int, iteracion:Int): String = {
    if(numero > 0) {
      val resto = numero%10
      val paso = iteracion*STEP
      if(resto > 0) {
        return calcularNumeroRomano(numero/10, iteracion+1)+traductorNumerosCinta(resto, paso)
      } else { return ""}
    } else { return ""}
    
  }
  
  def main(numeroOriginal:Int){
    val numeroRomano: String = calcularNumeroRomano(numeroOriginal, 0)
    println("Decimal: "+numeroOriginal+ " Romano: "+numeroRomano)
  }
  
  main(1)
  main(2)
  main(3)
  main(4)
  main(5)
  main(6)
  main(7)
  main(8)
  main(9)
}
