package part2oop
import java.sql

import playground.{PrinceCharming, Cinderella => Princess}
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App{
  val writer =  new Writer("Andres", "Escobar Cotan",1987)
  val hello = "Hello"
  val princess = new Princess
  sayHello
  println(SPEED_OF_LIGHT)
  val prince = new PrinceCharming

  prince says hello
  /*
  val date = new Date()
  val sqlDate = new SqlDate()
*/
  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef  - println, ???

}
