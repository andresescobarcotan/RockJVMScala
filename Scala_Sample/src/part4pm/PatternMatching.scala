package part4pm

import scala.util.Random

object PatternMatching extends App {

  // Switch on steroids
  val random = new Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the, charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)


  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi , my name is $n and I can't drink"
    case Person(n, a) => s"Hi , my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting)

  // PM on sealed hierarchies
  class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // Match everything
  val isEven = x match {
    case n if n %2 == 0 => true
    case _ => false
  }

  // Why?!
  val isEvenCond = if(x % 2 == 0) true else false // ?!
  val isEvenNormal = x % 2 == 0

  /*
    Exercise
    Simplefuncion uses PM
    takes an Expr => human readable form

    Sum(Number(2), Number(3), Number
   */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def humanExpression(e:Expr):String = {
    e match {
      case Number(n) => String.valueOf(n)
      case Sum(e1, e2) => humanExpression(e1) + "+" + humanExpression(e2)
      case Prod(e1, e2) =>  {
        def maybeShowParentheses(exp: Expr) = exp match {
          case Prod(_, _) => humanExpression(exp)
          case Number(_) => humanExpression(exp)
          case _ => "("+ humanExpression(exp)+ ")"

        }
        maybeShowParentheses(e1) + "*" + maybeShowParentheses(e2)
      }
    }
  }

  println(humanExpression(Number(5)))
  println(humanExpression(Sum(Number(2), Number(3))))
  println(humanExpression(Sum(Number(2), Sum(Number(3), Number(4)))))
  println(humanExpression(Prod(Sum(Number(2), Number(1)),Number(3))))

}
