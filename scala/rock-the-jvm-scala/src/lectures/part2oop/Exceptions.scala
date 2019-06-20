package lectures.part2oop

object Exceptions extends App {

  // 1. Throwing Exception.
  //  val aWeiredValue: String = throw new NullPointerException

  //
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 100
  }

  try {
    getInt(true)
  } catch {
    case e: NullPointerException => println("null pointer exception")
//    case e: RuntimeException => println("caught the error!")
  } finally {
    println("finally")
  }
}
