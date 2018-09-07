import scala.concurrent.Awaitable
// Monoid는 fold를 일반화 시키는 것임.
// 규칙: Monoid는 항등원을 앞에 붙이든 뒤에 붙이든 나 자신이 나와야 함.
// 결합법칙이 지켜져야 함. <-- Monoide는 분산처리할 때 중요함.
// Monoid는 결합을 계속 하기 위함임...
// append가 중요함

// MONAD
// return, bind가 중요함!
// >>==

// typeclassopedia
// traverable, MONAD가 쭝요함!

// List MONAD
// 경우의 수
//List(add1, muliply3) <*> List(1, 2, 3)

//implicit val listMonad = new Monad[List] {
//}

for (x <- List(1, 2)) yield (x + 10)

for {
  x <- List(1, 2)
  y <- List(3, 4, 5)
  if (y != 4)
} yield (x / y)


// scalaz library: 기능은 더 많음.
// cats library: 좀 더 빠름. compact하고 light하게 만든 버전.
// import $ivy.`org.instances.cats-core:1.1.0`
// cats.syntax.all._ : symbol 관련된 것

// cats.Semigroup: monoid의 상위 그룹.
// |+| => combine

//Option(1) |+| None

// cats.Monoid

//import cats.monoid
//
//// semigroup
//
//def foldr[A, B]: (A => B => B) => B => List[A] => B = f => n => {
//  case Nil => n
//  case x :: xs => f(x)(foldr(f)(n)(xs))
//}
//
//
//trait Monoid[M] {
//  def mempty: M
//  def mappend: M => M => M
//  def mconcat: List[M] => M = foldr[M, M](mappend)(mempty)
//}
//
//def foldMap[A, B: Monoid](va: Vector[A])(f: A => B): B = va.map(f).foldLeft(Monoid[B].empty)(_ |+| _)
//va.foldLeft(Monoid[B].empty)(_ |+| f(_))
//
//foldMap(Vector(1,2,3))(identity)
//foldMap(Vector(1,2,3))(_ + " >>> ")
//foldMap("Hello, World".toVector)(_.toString.toUpperCase)

Runtime.getRuntime.availableProcessors

(1 to 12).toVector.grouped(3)
(1 to 12).toVector.grouped(3).foreach(println)

// Future
//trait Future[+T] extends Awaitable[T]
//
//object Future {
//
//}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

//val f = Future(foldMap((1 to 10000).toVector)(identity()))

Future.sequence(List(Future(1), Future(2), Future(3)))

def parallelFoldMap[A, b]

import cats;

