package part2oop

object Inheritance extends App{
  
  // single class inheritance
  sealed class Animal {
   val creatureType = "wild"
    def eat = println("nomnom")
  }
  
   class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch crunch")
    }
  }
  
  val cat = new Cat
  cat.crunch
  
  // constructors
  class Person(name: String, age:Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age:Int, idCard:String) extends Person(name)
  
  // Overriding
  class Dog(dogType: String) extends Animal {
    override val creatureType = dogType
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)
  
  // type substition (broad: polymorphism)
  val unknownAnimal:Animal = new Dog("K9")
  unknownAnimal.eat
}