package playground

class PrinceCharming {
  def says(message:String="No se que decir") = print(message)
}

object PrinceCharming {
  def apply: Unit = new PrinceCharming().says("Soy un principe anonimo")

}