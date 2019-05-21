package part3fp

object AnonymousFunction extends App {
  // LAMBDA
  val doubler = (x:Int) => x * 2
  val adder = (a: Int, b: Int) => a + b
  val justDoSomething = () => 3

  println(justDoSomething)
  println(justDoSomething())

  // Curly braces with lambdas
  val stringToInt = { (str:String) => str.toInt
  }
  println(stringToInt("5"))

  // MORE Syntactic sugar
  val niceIncrementer: Int => Int = _ +1 // equivalent to x => x +1
  val niceAdder:(Int, Int) => Int = _ + _

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function

   */
  val superAdd = (x:Int) => (y: Int) => x + y
  println(superAdd(3)(4))

  val myNameAge = (age: Int) => (name:String) => "My name is "+ name + " and I am "+ age.toString

  val thirtyOne = myNameAge(31)
  println(thirtyOne("Andres"))
}
