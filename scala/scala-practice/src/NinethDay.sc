

sealed trait Color

case object Red extends Color // singleton object
case object Green extends Color

case object Blue extends Color

case class RGB2(r: Int, g: Int, b: Int) extends Color

Red.isInstanceOf[Color]

//////////////////////////////////
// Product Types - Haskell
//////////////////////////////////
//data RGBColor = RGB Int Int Int
sealed trait RGBColor

case class RGB(r: Int, g: Int, b: Int) extends RGBColor

RGB(255, 255, 255).isInstanceOf[RGBColor]

RGB.apply _


sealed trait Shape

case class Circle(r: Float) extends Shape

case class Rect(w: Float, h: Float) extends Shape

Circle(10).isInstanceOf[Shape]
Rect(5, 4).isInstanceOf[Shape]

var square: Float => Shape = r => Rect(r, r)
square(3)

var area: Shape => Float = {
  case Circle(r) => 3.14f * r * r
  case Rect(w, h) => w * h
}

area(Circle(3))
area(Rect(3, 3))

sealed trait Maybe[+A]

case object Nathing extends Maybe[Nothing]

case class Just[A](a: A) extends Maybe[A]

// Invariance[A]: default, 상속관계이 있을 때, 바깥 싸고 있는 건 상속관계가 아님.
// Covariance[+A]
// Contravariance[-A]
val safediv: Int => Int => Maybe[Int] = a => {
  case 0 => Nathing
  case y => Just(a / y)
}

safediv(3)(0)

def safehead[A]: List[A] => Maybe[A] = {
  case Nil => Nathing
  case x :: _ => Just(x)
}

safehead(Nil)
safehead(List())
safehead(List(1, 2, 3))

sealed trait Tree[+A]

case class Node[A](l: Tree[A], a: A, r: Tree[A]) extends Tree[A]

case object Empty extends Tree[Nothing]

Node(Node(Empty, "left child", Empty), "parent", Node(Empty, "right child", Empty))

def flatten[A]: Tree[A] => List[A] = {
  case Empty => Nil
  case Node(a, b, c) => flatten(a) ::: List(b) ::: flatten(c)
}

flatten(Node(Node(Empty, "left child", Empty), "parent", Node(Empty, "right child", Empty)))
