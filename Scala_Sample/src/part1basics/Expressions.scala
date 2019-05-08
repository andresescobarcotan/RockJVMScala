package part1basics

object Expressions extends App {
    val x = 1 +2 // Expression
    println(x)
    println(7>>1)
    println(1 == x)   
    println(!(1 == x))
    var aVariable = 2
    aVariable += 3
    println(aVariable)
    
    // Instructions (DO) vs Expressions (VALUE)
    val aCondition = true
    val aConditionedValue = if(aCondition) 5 else 3
    println(aConditionedValue)
    var i = 0
    val aWhile = while (i < 10 ) {
      println(i)
      i+=1
    }
    
    val aWeirdValue = (aVariable = 3) // Unit === void
    println(aWeirdValue)
    
    // side effects: println(), whiles, reassign
    
    val aCodeBlock = {
      val y = 2
      val z = y + 1
      
      if(z > 2) "hello" else "goodbye"
    }
    println(aCodeBlock)
    
    val someValue = {
      2 < 3
    }
    
    val someOtherValue = {
      if(someValue) 239 else 986
    }
    
}