package part2oop
import java.time.Year

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.x)
  person.greet("Daniel")
  person.greet()
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  print(novel.isWrittenBy(imposter))
}

//constructor 
class Person(name: String, val age: Int = 0){
  // body
  val x = 2
  
  println(1+3)
  
  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  
  def greet():Unit = println(s"Hi, I am $name")
  
  
  // multiple constructors
  def this(name:String) = this(name, 0) // This is so cool
  def this() = this("John Doe")
}


/* Novel and a Writer 

	Writer : first name, surname, year
	- method fullname

	Novel: name, year of release, author
	~ authorAge
	~ isWrittenBy(author)
  ~ copy(new year of realease) = new instance of Novel
*/
class Writer(firstName:String , surname:String, val birthYear:Int) {
  def fullname():String = {
    return this.firstName + " " + this.surname
  }
}

class Novel(val name:String, val yearOfRelease:Int, val author:Writer) {
  def authorAge():Int = return yearOfRelease - this.author.birthYear
  def isWrittenBy(author:Writer):Boolean = return (author == this.author)
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}
  /*
 * Counter class
 * 	- receives an int value
 *  - method current count
 *  - method to increment/decrement => new counter
 *  - overload inc/dec to receive an amount
 */
class Counter(countValue: Int = 0) {
  def currentCount:Int = return this.countValue
  def incrementCounter(amount:Int = 1):Counter =  new Counter(countValue+amount)
  def decrementCounter(amount:Int = 1):Counter =  new Counter(countValue-amount) 
}
  
  
  
  
  