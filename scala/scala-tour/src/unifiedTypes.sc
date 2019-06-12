import scala.collection.mutable

object UnifiedTypes extends App {
  val set = new mutable.LinkedHashSet[Any];
  set += "This is a string"
  set += 732
  set += 'c'
  set += true
  set += main _
  val iter: Iterator[Any] = set.iterator
  while (iter.hasNext) {
    println(iter.next.toString)
  }
}

