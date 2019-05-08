package part2oop

object MethodNotations extends App{
  
  class Person(val name:String, favoriteMovie: String, val age: Int=0) {
    def likes(movie:String) : Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with  ${person.name}"
    def +(nickname: String):Person = new Person(s"$name ($nickname)", favoriteMovie)
    def isWoman:Boolean = true
    def unary_! : String = s"$name What the heck!"
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n:Int): String = s"$name watched $favoriteMovie $n times"
    
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this.learns("Scala")
  }
  
  val mary = new Person("Mary", "Casablanca")
  println(mary.likes("Casablanca"))
  println(mary likes "Casablanca") // Infixed notation only works with method with only one parameter
  val Tom = new Person("Tom", "Fight Club")
  println(mary + Tom)
  println(!mary)
 //Postfix Notation
  println(mary isAlive)
  println(mary())
  println((mary + "the Rockstar").apply())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(4))
  
  
  
}