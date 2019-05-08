package part1basics

object Functions extends App {
  
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  
  println(aFunction("hello",3))
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)
  
  def aRepeatedFunction(aString: String, n: Int):String ={
    if(n==1) aString 
    else aString + aRepeatedFunction(aString, n-1)
  }
  
  println(aRepeatedFunction("hello", 3))
  
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b:Int) : Int =  a + b  
    aSmallerFunction(n, n-1)
  }
  
  /*
   * 1. A greeting function (name, age)  => "Hi, my name is $name and I am $age years old"
   * 2. A factorial function
   * 3. A fibonacci function
   */
   def greeting(name:String, age:Int) : String = {
       val greetings = "Hi, my name is $name and I am $age years old"
       return greetings.replaceAll("\\$name",name).replaceAll("\\$age",String.valueOf(age))
   }
   
   def factorial(n:Integer): Int =  if(n>0) n*factorial(n-1) else 1
   def fibonacci(n:Integer): Int = if(n>2) fibonacci(n-1)+fibonacci(n-2) else 1
   def isPrime(n:Integer):Boolean = {
     def isPrimeUntil(t: Int): Boolean = if(t <=1) true else n % t != 0 && isPrimeUntil(t-1)
     isPrimeUntil(n/2)
   }
   println(greeting("Andres",31)+ " "+ factorial(5)+" "+fibonacci(4)+" Is prime " +isPrime(4))
  
}