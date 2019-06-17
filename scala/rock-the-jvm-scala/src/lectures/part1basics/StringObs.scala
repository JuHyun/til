package lectures.part1basics

object StringObs extends App {

  val str: String = "Hello, I'm a scala string."

  println(str.charAt(1))
  println(str.substring(5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-s"))
  println(str.toLowerCase())
  println(str.length())

  val aNumberString = "45"
  println(aNumberString.toString())
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))
  println(str.takeRight(2))

  // Scala Specific: String Interpolator.

  // S-Interpolator.
  val name = "pikanpie"
  val age = 12
  val greeting = s"Hello, my name is $name, and I'm $age years old."
  val anotherGreeting = s"Hello, I'm $name, I will be ${age + 1} years old soon."
  println(greeting)
  println(anotherGreeting)

  // F-Interpolator(interpolated formatted string)
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minutes"
  println(myth)

  // Raw-Interpolator
  println(raw"This is a \n newline.")
  val escaped = "This is a \n newline."
  println(raw"$escaped")
}
