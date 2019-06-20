package lectures.part2oop

object Exceptions extends App {

  // 1. Throwing Exception.
  //  val aWeiredValue: String = throw new NullPointerException

  //
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 100
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    //    case e: NullPointerException => println("null pointer exception")
    case e: RuntimeException => println("caught the error!")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effect
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception

  val myException = new MyException

  //  throw myException

  /**
    * Excercise
    */
  // 1. Crash your program with OutOfMemoryError
  //  val array = Array.ofDim(Int.MaxValue)

  // 2. Crash with StackOverflowError
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class MyOverflowException extends RuntimeException

  class MyUnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Devision By Zero")

  // 3. PocketCalculator
  // - add(x, y)
  // - subtract(x, y)
  // - multiply(x, y)
  // - divide(x, y)
  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new MyOverflowException
      else if (x < 0 && y < 0 && result > 0) throw new MyUnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new MyOverflowException
      else if (x < 0 && y > 0 && result > 0) throw new MyUnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new MyOverflowException
      else if (x < 0 && y < 0 && result < 0) throw new MyOverflowException
      else if (x > 0 && y < 0 && result > 0) throw new MyUnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new MyUnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  // 4. Throw
  // - OverflowException if add(x, y) exceeds Int.MAX_VALUE
  // - UnderflowException if subtract(x, y) exceeds Int.MIN_VALUE
  // - MathCalculationException for division by 0
  val pocketCalculator = PocketCalculator
//  println(pocketCalculator.add(Int.MaxValue, 10))

//  println(pocketCalculator.subtract(Int.MinValue, 10))

  println(pocketCalculator.divide(10, 0))
}
