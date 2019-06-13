//sample.Blah.sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

class IntPair(val x: Int, val y: Int)

object IntPair {
  import math.Ordering

  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

class X {
  import X._

  def blah = foo
}

object X {
  private def foo  = 42
}

val x = new X()
x.blah


import scala.math._
case class Circle(radius: Double) {
  import Circle._

  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

val circle1 = new Circle(5.0)
circle1.area
