package lectures.part3fp

object HOFsCurries extends App {

  //  val superFuction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne: Int => Int = _ + 1

  println(nTimes(plusOne, 0, 1))
  println(nTimes(plusOne, 10, 1))

  // nTimeBetter(f, n) => f(f(...f(f(f(x)))))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne(... plusOne(plusOne(10))))
  // val y =- increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried function
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  println("%5.3f".format(Math.PI))

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
