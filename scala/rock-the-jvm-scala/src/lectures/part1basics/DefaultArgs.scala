package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n == 1) acc
    else trFact(n - 1, n * acc)
  }

  val factory10 = trFact(10)
  println(s"factory10 = $factory10")

  def saveImage(src: String, width: Int = 1000, height: Int = 1000, ext: String = "jpg"): Unit =
    println(s"$src $width $height $ext")

  saveImage("sample")
  saveImage(width = 50, src = "test", ext = "bmp")
}
