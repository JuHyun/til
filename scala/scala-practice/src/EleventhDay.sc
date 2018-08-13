// Generization
//MAP --> FMAP

sealed trait Tree[+A]

case class Node[A](l: Tree[A], a: A, r: Tree[A]) extends Tree[A]

case object Empty extends Tree[Nothing]

def flatten[A]: Tree[A] => List[A] = {
  case Empty => Nil
  case Node(a, b, c) => flatten(a) ::: List(b) ::: flatten(c)
}

trait Functor[F[+ _]] {
  def fmap[A, B]: (A => B) => F[A] => F[B]
}

implicit val treeFunctor = new Functor[Tree] {
  def fmap[A, B] = f => {
    case Empty => Empty
    case Node(l, a, r) => Node(fmap(f)(l), f(a), fmap(f)(r))
  }
}


sealed trait Maybe[+A]

case object Nathing extends Maybe[Nothing]

case class Just[A](a: A) extends Maybe[A]

// <&> : fmap
// <*> : apply

// monoid, monad 이해해야 한다!!

// functor applicative monad로 검색
