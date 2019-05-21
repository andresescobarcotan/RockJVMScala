package exercises


/*
trait MyPredicate[-T] {
  def test(t:T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(a:A): B
}
*/

abstract class MyList[+A] {

  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */

    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](newElement:B): MyList[B]
    def printElements: String
    override def toString: String = "["+printElements+"]"
    def map[B](transformer: A => B):MyList[B]
    def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def filter(predicate: A => Boolean):MyList[A]
    def ++[B >: A] (list: MyList[B]): MyList[B]
    //HOFs
    def foreach(f:A=>Unit): Unit
    def sort(compare:(A, A)=>Int): MyList[A]
    def zipWith[B,C](list:MyList[B], zip:(A,B) => C): MyList[C]
    def fold[B](start: B)(operator: (B, A) => B): B

}

case object Empty extends  MyList[Nothing]{
  def head: Nothing = throw  new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](newElement:B):MyList[B] = new Cons[B](newElement, Empty)
  def printElements:String =  ""
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean):MyList[Nothing] = Empty
  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list
  override def foreach(f: Nothing => Unit): Unit = ()
  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
      if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else Empty
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](newElement:B):MyList[B] = new Cons(newElement, this)
  def printElements: String = {
    if(t.isEmpty) {""+h}
    else{h + " "+ t.printElements}
  }
  def filter(predicate: A => Boolean): MyList[A] =
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def ++[B >: A] (list: MyList[B]): MyList[B] = new Cons(h,t ++ list)
  def flatMap[B](transformer: A => MyList[B]) : MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]):MyList[A] =
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x,sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
      if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new Cons(zip(h,list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }

}




object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  val anotherListOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", new Cons("Good",Empty)))

  /*
1. Expand myList
  - foreach Method A => Unit
  - sort function((A, A) => Int) => MyList
  - zipWith(list, A, A => B) => MyList[B]
  - fold

2. toCurry(f: (Int, Int) => Int) => (Int => INt => Int)
   fromCurry(f: (Int, Int) => Int) => (Int => INt => Int)

3. compose(f,g) => x => f(g(x))
  andThen(f,g) => x => g(f(x))

*/

  println(listOfIntegers.foreach(println))
  println(listOfIntegers.sort((x, y)=> y-x))
  println(listOfIntegers.zipWith[String,String](anotherListOfStrings,_+","+_))
  println(listOfIntegers.fold(0)(_+_))

  // for comprehension
  val combinations = for {
    n <- listOfIntegers
    string <-listOfStrings
  } yield n + "-" + string

  println(combinations)
}

