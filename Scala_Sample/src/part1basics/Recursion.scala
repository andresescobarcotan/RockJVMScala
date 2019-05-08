package part1basics
import scala.annotation.tailrec
import scala.math.BigInt.int2bigInt

object Recursion extends App {
  
  def factorial(n:Integer): Int =  if(n>0) n*factorial(n-1) else 1
  def anotherFactorial(n: Int): BigInt = {
  @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =  if(x <= 1) accumulator else factHelper(x-1, x * accumulator)
    
    factHelper(n, 1)
  }
  @tailrec
   def concatenateTailrec(aString: String, n:Int, accumulator:String):String = {
    if (n <=0) accumulator 
    else concatenateTailrec(aString, n-1, aString+accumulator)
  }
 
   
  def isPrime(n:Int):Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean):Boolean = {
        if(isStillPrime) false  
        else if (t<=1) true
        else isPrimeTailRec(t-1, n%t!=0 && isStillPrime)
    }
    
    isPrimeTailRec(n/2, true)
  }
  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.
  
  /*
   * 1. Concatenate a string n times
   * 2. isPrime function tail recursive
   * 3. Fibonacci, funcion tail recursive
   */
   println(concatenateTailrec("Andres",3,""))
   println(isPrime(2003))
   
   def fibonacci(n:Int): Int = {
     @tailrec
     def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = 
        if(i>=n) last
        else fiboTailrec(i+1, last+nextToLast, last)
        
        if(n <= 2) 1
        else fiboTailrec(2,1,1)
     
   }
   
   println(fibonacci(8))
}