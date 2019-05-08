package part2oop

object Objetos  {
  
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
  
    // Factory Method
    def from(mother:Person, father:Person) : Person  = new Person("Bobbie")
  }
 
  class Person(val name: String) {
    // instance-level functionality
    
  }
  // COMPANIONS
  def main (args: Array[String]): Unit = {
  
    println(Person.N_EYES)
    println(Person.canFly)
  
    //Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)
    
    val person1 = Person
    val person2 = Person
    println(person1 == person2)
    
    val bobbie = Person.from(mary, john)
    
    // Scala Applications
  }
  
}