///////////////////////////////////
val foldr: (Int => Int => Int) => Int => List[Int] => Int = f => v => l => (f, v, l) match {
  case (_, v, Nil) => v
  case (f, v, x :: xs) => f(x)(foldr(f)(v)(xs))
}

val add: Int => Int => Int = x => y => x + y
foldr(add)(0)(List(1, 2, 3))

val foldr2: (Int => Int => Int) => Int => List[Int] => Int = f => v => {
  case Nil => v
  case x :: xs => f(x)(foldr(f)(v)(xs))
}

//////////////////////////////////////////////////////////////////
//////////////////// Generic /////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////// Type Parameter => val가 아닌 def로 해야 함.//////
def filter[A]: ((A => Boolean), List[A]) => List[A] = {
  case (_, Nil) => Nil
  case (f, x :: xs) if f(x) => x :: filter(f, xs)
  case (f, _ :: xs) => filter(f, xs)
}

var even: Int => Boolean = _ % 2 == 0
filter((_: Int) % 2 == 0, List(1, 2, 3, 4, 5))


/////////////////// Map /////////////////////
def map[A, B]: ((A => B), List[A]) => List[B] = {
  case (_, Nil) => Nil
  case (f, x :: xs) => f(x) :: map(f, xs)
}

var addOne: String => String = _ + 1
map(addOne, List("a", "b", "c"))


///////////////// Reverse /////////////////
def reverse[A]: List[A] => List[A] = {
  case Nil => Nil
  case x :: xs => reverse(xs) ::: List(x)
}

map(reverse[Int], List(List(1, 2), List(3, 4, 5)))


//////////////////////// Foldr ///////////////////////////
def foldr_g[A, B]: (A => B => B) => B => List[A] => B = f => v => {
  case Nil => v
  case x :: xs => f(x)(foldr_g(f)(v)(xs))
}
