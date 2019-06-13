abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next(): T
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = {
    while (hasNext) f(next())
  }
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  override def hasNext = i < s.length()

  override def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

class Iter extends StringIterator("Scala") with RichIterator

val iter = new Iter
iter foreach println
