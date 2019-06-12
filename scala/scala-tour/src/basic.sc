// function
println({
  val x: Int = 1 + 1
  x + 1
})

val addOne = (x : Int) => x + 1
println(addOne(10))

val add = (x: Int, y: Int) => x + y

println(add(10, 10))

val getTheAnswer = () => 42
println(getTheAnswer())


// method
def addMethod(x: Int, y: Int): Int = x + y
print(addMethod(10, 10))

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(10, 10)(2))

def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")

def getSquareString(input: Double): String = {
  val square = input * input
  square.toString
}

println(getSquareString(10.1))

// class
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = {
    println(prefix + name + suffix)
  }
}

val greeter = new Greeter("Hello, ", "!")
greeter.greet("pikanpie")


// case class
case class Point(x: Int, y: Int)

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are diffrent.")
}

if (anotherPoint == yetAnotherPoint) {
  println(anotherPoint + " and " + yetAnotherPoint + " are the same.")
} else {
  println(anotherPoint + " and " + yetAnotherPoint + " are diffrent.")
}

// object
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val newId: Int = IdFactory.create()
println(newId)

val newerId: Int = IdFactory.create()
println(newerId)

val anotherNewId: Int = IdFactory.create()
println(anotherNewId)


// trait
trait GreeterTrait {
  def greet(name: String): Unit
}

trait AnotherGreeterTrait {
  def greet(name: String): Unit = println("Hello, " + name + " !")
}

class DefaultGreeter extends AnotherGreeterTrait

val defaultGreeter = new DefaultGreeter()
defaultGreeter.greet("angelina")

class CustomGreeter(prefix: String, sufix: String) extends GreeterTrait {
  override def greet(name: String): Unit = {
    println(prefix + name + sufix)
  }
}

val customGreeter = new CustomGreeter("How are you, ", " ?")
customGreeter.greet("Jolie")


// main method
object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala developers!")
  }
}














