package lectures.part3fp

object AnonymousFunctions extends App {

  //  val doubler: Function[Int, Int] = (a: Int) => a * 2
  //  val doubler: Int => Int = (a: Int) => a * 2
  val doubler: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val justDoSomething: () => Int = () => 3
  println(justDoSomething)
  println(justDoSomething())

  val stringToInt = { (str: String) =>
    str.toInt
  }
  println(stringToInt("10"))

  // MOAR syntact sugar
  //  val niceIncrementer: Int => Int = (a: Int) => a + 1
  val niceIncrementer: Int => Int = _ + 1
  println(niceIncrementer(1))

  //  val niceAdder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val niceAdder: (Int, Int) => Int = _ + _
  println(niceAdder(10, 10))

//  val specialAdder = (x: Int) => (y: Int) => x + y
  val specialAdder: Int => Int => Int = x => y => x + y
  println(specialAdder(10)(10))
}
