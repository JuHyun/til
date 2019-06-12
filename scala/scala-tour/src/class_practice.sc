class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y += dy
  }

  override def toString: String = "(" + x + "," + y + ")"
}

val point = new Point(5, 5)
println(point.toString)

point.move(3, 2)
println(point.toString)

object Classes {
  def main(args: Array[String]): Unit = {
    val pt = new Point(1, 2)
    println(pt)
    pt.move(10, 10)
    println(pt)
  }
}
