///////////////////////////
// Generic, Type Parameter
///////////////////////////
def filterGeneric[A]: ((A => Boolean), List[A]) => List[A] = {
  case (f, Nil) => Nil
  case (f, x :: xs) if f(x) => x :: filterGeneric(f, xs)
  case (f, _ :: xs) => filterGeneric(f, xs)
}

var isTwoLength: String => Boolean = l => l.length == 2
filterGeneric(isTwoLength, Nil) == Nil
filterGeneric(isTwoLength, List("abc", "ab", "bc", "bccd")) == List("ab", "bc")

var even: Int => Boolean = _ % 2 == 1

filterGeneric(even, List(1, 2, 3, 4, 5, 6, 7)) == List(1, 3, 5, 7)


def mapGeneric[A, B]: ((A => B), List[A]) => List[B] = {
  case (f, Nil) => Nil
  case (f, x :: xs) => f(x) :: mapGeneric(f, xs)
}

var convertString: Int => String = "Input: " + _

mapGeneric(convertString, List(1, 2, 3, 4, 5))

// reverse
def reverse[A]: List[A] => List[A] = {
  case Nil => Nil
  case x :: xs => reverse(xs) ::: x :: Nil
}

reverse(List()) == Nil
reverse(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1)

mapGeneric(reverse[Int], List(List(3, 2, 1), List(5, 4)))

// (Int => Int => Int) => Int => List[Int] => Int
def foldrGeneric[A, B]: (A => B => B) => B => List[A] => B = f => i => {
  case Nil => i
  case x :: xs => f(x)(foldrGeneric(f)(i)(xs))
}

// currying: single argument
var addCurry: Int => Int => Int = x => y => x + y
foldrGeneric(addCurry)(0)(List(1, 2, 3, 4, 5)) == 15

var multiplyCurry: Int => Int => Int = x => y => x * y
foldrGeneric(multiplyCurry)(1)(List(1, 2, 3, 4, 5)) == 120

var concateCurry: String => String => String = s1 => s2 => s1 + s2
foldrGeneric(concateCurry)("")(List("h", "e", "l", "l", "o")) == "hello"

// drop
def drop[A]: Int => List[A] => List[A] = n => {
  case Nil => Nil
  case l if n == 0 => l
  case x :: xs => drop(n - 1)(xs)
}

//def drop[A]: Int => List[A] => List[A] = n => l => (n, l) match {
//  case (_, Nil) => Nil
//  case (n, l) if n == 0 => l
//  case (n, x :: xs) => drop(n - 1)(xs)
//}

drop(0)(Nil) == Nil
drop(0)(List(1, 2, 3)) == List(1, 2, 3)
drop(1)(List(1, 2, 3)) == List(2, 3)
drop(2)(List(1, 2, 3)) == List(3)
drop(3)(List(1, 2, 3)) == Nil
drop(100)(List(1, 2, 3)) == Nil

// take
def take[A]: Int => List[A] => List[A] = n => {
  case Nil => Nil
  case _ if n == 0 => Nil
  //  case l if n >= l.length => l
  case x :: xs => x :: take(n - 1)(xs)
}

take(1)(Nil) == Nil
take(0)(List('a', 'b', 'c')) == Nil
take(1)(List('a', 'b', 'c')) == List('a')
take(3)(List('a', 'b', 'c')) == List('a', 'b', 'c')

// dropWhile
def dropWhile[A]: (A => Boolean) => List[A] => List[A] = f => {
  case Nil => Nil
  case x :: xs if f(x) => dropWhile(f)(xs)
  case x :: xs => x :: dropWhile(f)(xs)
}

dropWhile((_: Int) % 2 == 0)(Nil) == Nil
dropWhile((_: Int) % 2 == 0)(List(1, 2, 3, 4, 5)) == List(1, 3, 5)
dropWhile((_: Int) > 3)(List(1, 2, 3, 4, 5)) == List(1, 2, 3)

// takeWhile
def takeWhile[A]: (A => Boolean) => List[A] => List[A] = f => {
  case Nil => Nil
  case x :: xs if f(x) => x :: takeWhile(f)(xs)
  case _ :: xs => takeWhile(f)(xs)
}

takeWhile((_: Int) % 2 == 0)(Nil) == Nil
takeWhile((_: Int) % 2 == 0)(List(1, 2, 3, 4, 5)) == List(2, 4)
takeWhile((_: Int) > 3)(List(1, 2, 3, 4, 5)) == List(4, 5)

// splitAt
def splitAt[A]: Int => List[A] => (List[A], List[A]) = n => l => (take(n)(l), drop(n)(l))

splitAt(0)(List(1, 2, 3, 4, 5)) == (Nil, List(1, 2, 3, 4, 5))
splitAt(1)(List(1, 2, 3, 4, 5)) == (List(1), List(2, 3, 4, 5))
splitAt(2)(List(1, 2, 3, 4, 5)) == (List(1, 2), List(3, 4, 5))
splitAt(5)(List(1, 2, 3, 4, 5)) == (List(1, 2, 3, 4, 5), Nil)
splitAt(100)(List(1, 2, 3, 4, 5)) == (List(1, 2, 3, 4, 5), Nil)

// span
def span[A]: (A => Boolean) => List[A] => (List[A], List[A]) = f => l => (takeWhile(f)(l), dropWhile(f)(l))

span((_: Int) < 1)(List(1, 2, 3, 4, 5)) == (Nil, List(1, 2, 3, 4, 5))
span((_: Int) < 2)(List(1, 2, 3, 4, 5)) == (List(1), List(2, 3, 4, 5))
span((_: Int) < 3)(List(1, 2, 3, 4, 5)) == (List(1, 2), List(3, 4, 5))
span((_: Int) < 10)(List(1, 2, 3, 4, 5)) == (List(1, 2, 3, 4, 5), Nil)

// foldr
def foldr[A, B]: (A => B => B) => B => List[A] => B = f => n => {
  case Nil => n
  case x :: xs => f(x)(foldr(f)(n)(xs))
}

var add: Int => Int => Int = x => y => x + y
foldr(add)(0)(Nil) == 0
foldr(add)(0)(List(1, 2, 3, 4, 5)) == 15

// length
def length[A]: List[A] => Int = l => foldr((_: A) => (y: Int) => y + 1)(0)(l)
// 1, (2,3,4,5) => f(1)(foldr(f)(0)(List(2,3,4,5))
// 2, (3,4,5) => f(1)(f(2)(foldr(f)(0)(List(3,4,5)))
// 3, (4,5) => f(1)(f(2)f(3)(foldr(f)(0)(List(4,5))))
// 4, (5) => f(1)(f(2)f(3)f(4)(foldr(f)(0)(List(5)))))
// 5, Nil => f(1)(f(2)f(3)f(4)f(5)(foldr(f)(0)(Nil)))))
// => f(1)(f(2)f(3)f(4)f(5)(0))))
// => f(1)(f(2)f(3)f(4)(1)))
// => f(1)(f(2)f(3)(2))
// => f(1)(f(2)(3))
// => f(1)(4)
// => 5

length(List()) == 0
length(List(1, 2, 3, 4, 5)) == 5

// reverse
def reverseDef[A]: List[A] => List[A] = l => foldr((x: A) => (y: List[A]) => y ::: x :: Nil)(Nil)(l)
reverseDef(Nil) == Nil
reverseDef(List(5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5)


// foldl