package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number."))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  /**
    * Exercise.
    * print all combinations between two lists.
    * => List(a1, a2, a3, a4, b1, b2, ... , d3, d4)
    **/
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  // Iterating.
  val compose = (x: Int, list: List[Char]) => list.map("" + _ + x)
  println(numbers.flatMap(compose(_, chars)))
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val colors = List("white", "black")
  val allCombinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(col => col + n + c)))
  println(allCombinations)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    col <- colors
  } yield (col + n + c)
  println(forCombinations)

  // foreach
  list.foreach(println)

  for {
    n <- numbers
  } println(n)

  // Syntax overload
  val addTwo = list.map { x =>
    x + 2
  }
  println(addTwo)


  /**
    * Small collection
    */
}
