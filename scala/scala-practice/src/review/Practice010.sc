//////////////// Data Type //////////////////
sealed trait Season

case object Spring extends Season

case object Summer extends Season

case object Fall extends Season

case object Winter extends Season

var toInt: Season => Int = {
  case Spring => 0
  case Summer => 1
  case Fall => 2
  case Winter => 3
}
toInt(Spring) == 0
toInt(Summer) == 1
toInt(Fall) == 2
toInt(Winter) == 3

var toSeason: Int => Season = {
  case 0 => Spring
  case 1 => Summer
  case 2 => Fall
  case 3 => Winter
}
toSeason(0) == Spring
toSeason(1) == Summer
toSeason(2) == Fall
toSeason(3) == Winter

var next: Season => Season = season => toSeason((toInt(season) + 1) % 4)
next(Spring) == Summer
next(Summer) == Fall
next(Fall) == Winter
next(Winter) == Spring


sealed trait Color

case object Green extends Color

case object Red extends Color

case object Blue extends Color

case class RBD(r: Int, g: Int, b: Int) extends Color

Red.isInstanceOf[Color] == true


sealed trait Shape

case class Circle(r: Int) extends Shape

case class Rectangle(w: Int, h: Int) extends Shape

var square1: Int => Shape = r => Rectangle(r, r)
square1(3) == Rectangle(3, 3)

var area: Shape => Float = {
  case Circle(r) => 3.14f * r * r
  case Rectangle(w, h) => w * h
}
area(Circle(3)) == 3.14f * 3 * 3
area(Rectangle(2, 4)) == 2 * 4


sealed trait Maybe[+A]

case object CustomNothing extends Maybe[Nothing]

case class Just[A](a: A) extends Maybe[A]

var safediv: Int => Int => Maybe[Int] = a => {
  case 0 => CustomNothing
  case b => Just(a / b)
}
safediv(100)(0) == CustomNothing
safediv(0)(100) == Just(0 / 100)
safediv(10)(100) == Just(10 / 100)

def safehead[A]: List[A] => Maybe[A] = {
  case Nil => CustomNothing
  case x :: _ => Just(x)
}
safehead(List()) == CustomNothing
safehead(List(1, 2, 3, 4, 5)) == Just(1)


sealed trait Tree[+A]

case object Empty extends Tree[Nothing]

case class Node[A](l: Tree[A], n: A, r: Tree[A]) extends Tree[A]

Node(Empty, "center", Empty)
Node(Node(Empty, "left", Empty), "center", Empty)
Node(Node(Empty, "left", Empty), "center", Node(Empty, "right", Empty))

def flatten[A]: Tree[A] => List[A] = {
  case Empty => Nil
  case Node(l, n, r) => flatten(l) ::: List(n) ::: flatten(r)
}

flatten(Node(Empty, "center", Empty)) == List("center")
flatten(Node(Node(Empty, "left", Empty), "center", Empty)) == List("left", "center")
flatten(Node(Node(Empty, "left", Empty), "center", Node(Empty, "right", Empty))) == List("left", "center", "right")
