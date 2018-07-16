def filter[A]: ((A => Boolean), List[A]) => List[A] = {
  case (_, Nil) => Nil
  case (f, x :: xs) if f(x) => x :: filter(f, xs)
  case (f, _ :: xs) => filter(f, xs)
}

filter((_: Int) > 10, List(10, 3, 4, 30, 20))

def map[A, B]: ((A => B), List[A]) => List[B] = {
  case (_, Nil) => Nil
  case (f, x :: xs) => f(x) :: map(f, xs)
}

var addOne: Int => String = "abc" + _
map(addOne, List(1, 3, 4, 6, 10))


def drop[A]: Int => List[A] => List[A] = n => l => (n, l) match {
  case (0, l) => l
  case (_, Nil) => Nil
  case (n, x :: xs) => drop(n - 1)(xs)
}

drop(0)(List(1, 2, 3, 4, 5))
drop(1)(List(1, 2, 3, 4, 5))
drop(2)(List(1, 2, 3, 4, 5))
drop(9)(List(1, 2, 3, 4, 5))

def drop2[A]: Int => List[A] => List[A] = n => {
  case l if n == 0 => l
  case Nil => Nil
  case x :: xs => drop2(n - 1)(xs)
}

drop2(0)(List(1, 2, 3, 4, 5))
drop2(1)(List(1, 2, 3, 4, 5))
drop2(2)(List(1, 2, 3, 4, 5))
drop2(9)(List(1, 2, 3, 4, 5))


def take[A]: Int => List[A] => List[A] = n => {
  case Nil => Nil
  case l if n == 0 => Nil
  case x :: xs => x :: take(n - 1)(xs)
}

take(0)(List(1, 2, 3, 4, 5))
take(1)(List(1, 2, 3, 4, 5))
take(2)(List(1, 2, 3, 4, 5))


def dropWhile[A]: (A => Boolean) => List[A] => List[A] = f => {
  case Nil => Nil
  case x :: xs if f(x) => dropWhile(f)(xs)
  case l => l
}

dropWhile((_: Int) > 3)(List(1, 2, 3, 4, 5))
dropWhile((_: Int) < 3)(List(1, 2, 3, 4, 5))
dropWhile((x: Int) => x > 3)(List(1, 2, 3, 4, 5))

def takeWhile[A]: (A => Boolean) => List[A] => List[A] = f => {
  case Nil => Nil
  case x :: xs if f(x) => x :: takeWhile(f)(xs)
  case l => Nil
}

takeWhile((_: Int) > 3)(List(1, 2, 3, 4, 5))
takeWhile((_: Int) < 3)(List(1, 2, 3, 4, 5))

def splitAt[A]: Int => List[A] => (List[A], List[A]) =
  n => l => (take(n)(l), drop(n)(l))

def span[A]: (A => Boolean) => List[A] => (List[A], List[A]) =
  f => l => (takeWhile(f)(l), dropWhile(f)(l))

span((x: Int) => x < 3)(List(1, 2, 3, 4, 5))


def foldr_g[A, B]: (A => B => B) => B => List[A] => B = f => v => {
  case Nil => v
  case x :: xs => f(x)(foldr_g(f)(v)(xs))
}

var add: Int => Int => Int = x => y => x + y
var sum = foldr_g(add)(0)

sum(List(1, 2, 3))

def length[A]: List[A] => Int = foldr_g((_: A) => (y: Int) => 1 + y)(0)
length(List(1, 2, 3, 4, 5))

def reverse[A]: List[A] => List[A] = foldr_g((x: A) => (xs: List[A]) => xs ::: List(x))(Nil)
reverse(List(1, 2, 3, 4, 5))


// homework!
def foldl[A, B]: (A => B => A) => A => List[B] => A = f => v => {
  case Nil => v
  case x::xs => foldl(f)(f(v)(x))(xs)
}
