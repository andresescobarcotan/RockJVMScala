package part3fp

object WhatsAFunction extends App{

  //DREAM: use functions as first class elements
  //problem: oop

  trait MyFunction[A, B] {
    def apply(element: A): B
  }
  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }


  println(stringToIntConverter("3")+4)
  val adder:(Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a +b
  }

  /*
  1. a function which takes 2 strings and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an int and returns another fucntion which takes an int and returns an int
    - what's the type of this function
    - how to do it
   */

  val concatenator:(String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b:String): String = a+b
  }

  println(concatenator("Andres ", "Escobar Cotan"))

  val superadder:(Int) => Function1[Int,Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superadder(3)
  println(adder3(4))
  println(superadder(3)(4)) // curried function

  val myNameAge:(Int) => Function1[String, String] = new Function1[Int, Function1[String,String]]{
    override def apply(age: Int): Function1[String, String] = new Function1[String, String] {
      override def apply(name:String):String = {
          "My name is "+ name + " and I am "+ age.toString
      }
    }
  }

  val thirtyOne = myNameAge(31)
  println(thirtyOne("Andres"))

}
