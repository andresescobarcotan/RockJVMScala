package part2oop

object CaseClasses extends App {

  /*
   equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. Class parameters are false
  val jim = new Person("Jim", 34)
  println(jim)
  val jim2 = new Person("Jim", age = 34)
  println(jim==jim2)
  val jim3 = jim.copy(age = 45)
  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6. CCs are serializable
  // Akka

  //7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom  {
    def  name:String = "The UK of GB and NI"
  }

}
