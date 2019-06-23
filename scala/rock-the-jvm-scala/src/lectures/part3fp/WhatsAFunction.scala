package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("10") + 1)

  val adder: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2

  println(adder(10, 20))

  val concatenator: (String, String) => String = (v1: String, v2: String) => v1 + v2
  println(concatenator("abcde", "xyz"))

  //  val plus: Function[Int, Function[Int, Int]] = new Function[Int, Function[Int, Int]] {
  //    override def apply(a: Int): Function[Int, Int] = new Function[Int, Int] {
  //      override def apply(b: Int): Int = a + b
  //    }
  //  }
  val plus: Function[Int, Function[Int, Int]] = (a: Int) => (b: Int) => a + b
  val plus10 = plus(10)
  println(plus10(10))
  println(plus(10)(10))

  val multiply: Int => (Int => Int) = (a: Int) => (b: Int) => a * b


  println(multiply(10)(10))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}

