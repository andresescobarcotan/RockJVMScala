package part3fp

import scala.util.Random

object Sequences extends App{

  // Seq
  val aSequence = Seq(2,4,1,3)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges

  val aRanges: Seq[Int] = 1 to 10
  aRanges.foreach(println)
  (1 to 10).foreach(x => println("Hello"))


  // List
  val aList = List(1,2 ,3)
  val coolness = 256 :: aList
  println(coolness)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-|-"))

  // arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  //mutation
  numbers(2) = 0
  println(numbers.mkString(" "))


  // arrays and seq
  val numbersSeq :Seq[Int] = numbers
  println(numbersSeq)

  // vector
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 10
  // vectors vs list
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      //operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  // keeps reference to tails
  println(getWriteTime(numbersList))
  // depth of the tree is small
  println(getWriteTime(numbersVector))

}
