package part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
    // higher order function (HOF)

    // map, flatMap, filter in MyList

    // function that applies that another function n times over a value x
    // nTimes(f, n, x)

  def nTimes(f: Int=>Int, n: Int, x:Int):Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  val plusOne = (x:Int) => x +1
  println(nTimes(plusOne, 10, 1).toString)


  def nTimesBetter(f:Int=>Int, n:Int): (Int => Int) =
    if(n <= 0) (x: Int) => x
    else (x:Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // Curried functions
  val superAdder:Int => (Int => Int) = (x: Int) => (y:Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))

  // functions with multiple parameter lists
  def curriedFormatter(c:String)(x:Double): String = c.format(x)

  val standardFormat:(Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  val sqrtExp = (x:Int, y:Int) => Math.sqrt(x*Math.exp(y))

  println(sqrtExp(16,3).toString)

  def toCurry(f: (Int, Int) => Int):  (Int => Int => Int) = x=> y=> f(x, y)
  def fromCurry(f:(Int => Int => Int)):(Int, Int) => Int = (x, y) => f(x)(y)

  def compose[A,B,T](f: A => B, g: T=> A) : T => B = x => f(g(x))
  def andThen[A,B,C](f: A => B, g: B=> C) : A => C = x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  val adder4 = superAdder2(4)
  println(adder4(17))

  val simplerAdder = fromCurry(superAdder)
  println(simplerAdder(4, 17))

  val add2 = (x:Int) => x +2
  val times3= (x: Int) => x*3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)
}
