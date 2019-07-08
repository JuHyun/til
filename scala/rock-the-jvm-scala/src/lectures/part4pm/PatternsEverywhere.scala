package lectures.part4pm

object PatternsEverywhere extends App {

  // catchs are actually MATCHES
  /**
    * try {
    *
    * } catch (e) {
    * e match {
    * case e: RuntimeException => "runtime"
    * case npe: NullPointerException => "npe"
    * case _ => "something else"
    * }
    * }
    */
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x
  println(evenOnes)

  // generators are also based on PATTERN MATCHING
  // case class, :: operator, etc ...
  val tuples = List((1, 2), (10, 11))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  println(filterTuples)

  // multiple value definitions based on PATTERN MATCHING
  val tuple = (1, 2, "hello")
  val (a, b, c) = tuple
  println(a)
  println(b)
  println(c)

  val head :: tail = list
  println("head => " + head)
  println("tail => " + tail)

  // partial function based on PATTERN MATCHING
  val mappedList = list.map {
    case x if x % 2 == 0 => x + " is even."
    case 1 => "the one"
    case _ => "something else"
  }
  println(mappedList)

  // equivalent to
  val mappedList2 = list.map { e =>
    e match {
      case x if x % 2 == 0 => x + " is even."
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList2)

}
