sealed trait Color

case object Red extends Color

case object Green extends Color

case object Blue extends Color

//val colorEq: (Color, Color) => Boolean = {
//
//
//}

//def listEq[A]: (List[A], List[A]) => Boolean = {
//
//}

///////////////////////////////
// Type Class
// ad hoc polymorphism
///////////////////////////////


val asc = Ordering.fromLessThan[Int](_ < _)
val desc = Ordering.fromLessThan[Int](_ > _)

List(1, 4, 3).sorted(asc)
List(1, 4, 3).sorted(desc)

implicit val asc2 = Ordering.fromLessThan[Int](_ < _)
List(1, 4, 3).sorted

implicit val asc3 = Ordering.fromLessThan[Int](_ < _)
implicit val desc3 = Ordering.fromLessThan[Int](_ > _)

//List(1, 4, 3).sorted <-- error

trait BasicEq[A] {
  def isEqual: A => A => Boolean
}

//def isEqual[A] =

implicit val intEq = new BasicEq[Int] {
  def isEqual = x => y => x == y
}

implicit val listIntEq = new BasicEq[List[Int]] {
  def isEqual = x => y => (x, y) match {
    case (Nil, Nil) => true
    case (x :: xs, y :: ys) => x == y && isEqual(xs)(ys)
    case _ => false
  }
}

//def map[A, B]: (A => B) => List[A] => List[B]

//trait Functor[F[_+]]


////////////
/// [_] ///
def len(l: Array[_]) = l.length
len(Array(1,2,3)) == 3


trait Applicative[F[+_]] extends Functor[F] {

}
