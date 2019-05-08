package part2oop

object Exceptions extends App{

  val x: String = null
  val aWeirdValue: String = null

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail:Int = try{
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will be executed no matter what
    // optional
    // does not influence the return
    // use finally for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  // val array = Array.ofDim(Int.MaxValue) Out of memory
  // SO
  /*def infinite: Int = 1+ infinite
  val noLimit = infinite*/
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")
  object PocketCalculator {
    def add(x:Int , y:Int):Int = {
      val result = x +y
      if(x>0 && y > 0 && result < 0) throw new OverflowException
      else if(x<0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x:Int , y:Int):Int = {
      val result = x - y
      if(x>0 && y < 0 && result < 0) throw new OverflowException
      else if(x<0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y:Int) = {
      val result = x * y
      if ( x > 0 && y > 0 && result < 0) throw new OverflowException
      else if ( x < 0 && y < 0 && result > 0) throw new UnderflowException
      else if ( x < 0 && y < 0 && result > 0) throw new OverflowException
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x/y
    }


  }
  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}

