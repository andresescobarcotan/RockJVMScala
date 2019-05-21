package part4pm

object PatternsEverywhere extends App {

  try {

  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples

  } yield first*second
  // case classes, :: operators, ...

  // big idea #3
  val tuple = (1,2,3)
  val (a, b, c) = tuple
  println(b)
  // Multiple value definitions based on PATTERN MATCHING
  // ALL THE POWER

  val head :: tail = list // Esto es una pasada
  println(head)
  println(tail)

  // partial function

  val mappedList = list.map {
    case v if v % 2 == 0 =>  v+ "is Even"
    case 1 => "The One"
    case _ => "Something else"
  } // partial function literal

  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 =>  v+ "is Even"
    case 1 => "The One"
    case _ => "Something else"
  }
  }

  println(mappedList)
}

