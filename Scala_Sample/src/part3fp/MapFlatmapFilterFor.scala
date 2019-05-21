package part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ +1))
  println(list.map(_ + "is a number"))

  // filter
  println(list.filter(_ %2 != 0))

  // flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))
  // Print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List("a","b","c","d")
  val names = List("Andres", "Sara", "Laura")
  val surnames = List("Escobar", "San Jose", "Pausini")
  println(names.flatMap(x => numbers.map(x+_.toString)).filter(_.contains("4")))
  println(names.flatMap(x => surnames.map(x+" "+_)))
  val peopleBeerAfterBrindis: Int = List("+1","+1", "No puedo ir Estoy de angel custodio en el pueblo.", "+1", "+1", "mañana todos en Maria de Molina que hay que ir de canas!!!","OE, oe oe, oe!!!","+1").filter(x=> x.contains("+1")).length
  println("La gente que ira al brindis sera "+peopleBeerAfterBrindis)

  //foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n %2  == 0
    c <- chars
  } yield " " + c + n

  forCombinations.foreach(print)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map( x =>
    x*2
  )

  /*
    1. MyList supports for comprehensions
    2. Small collection of at most ONE element -> Maybe[+T]
      - map, flatMap, filter
   */




}
