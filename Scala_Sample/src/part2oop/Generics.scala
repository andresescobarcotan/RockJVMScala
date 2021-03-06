package part2oop

object Generics extends App {
  class MyList[+A] {
    // Use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
     * A = Cat
     * B = Animal
     *
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //1. yes Covariance List list[Cat] extends List[Animal]
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???

  //2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val contravariantList: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)



}
