// map
var map: ((Int => Int), List[Int]) => List[Int] = (f, l) => (f, l) match {
  case (_, Nil) => Nil
  case (f, x :: xs) => f(x) :: map(f, xs)
}

var addOne: Int => Int = _ + 1

map(addOne, Nil) == Nil
map(addOne, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5, 6)
map(x => x + 1, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5, 6)
map(_ + 1, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5, 6)


// map like filter
var map2: ((Int => Boolean), List[Int]) => List[Int] = {
  case (f, Nil) => Nil
  case (f, x :: xs) => {
    if (f(x)) x :: map2(f, xs) else map2(f, xs)
  }
}

map2(_ % 2 != 0, List(1, 2, 3, 4, 5)) == List(1, 3, 5)


// filter
var filter: ((Int => Boolean), List[Int]) => List[Int] = {
  case (_, Nil) => Nil
  case (f, x :: xs) if f(x) => x :: filter(f, xs)
  case (f, _ :: xs) => filter(f, xs)
}

filter(_ % 2 != 0, List()) == Nil
filter(_ % 2 != 0, List(1, 2, 3, 4, 5)) == List(1, 3, 5)
filter(_ > 3, List(1, 2, 3, 4, 5)) == List(4, 5)

// currying: single argument
var addCurry: Int => Int => Int = x => y => x + y

addCurry(10)(20) == 30
addCurry(-10)(10) == 0

// multiplyCurry
var multiplyCurry: Int => Int => Int = x => y => x * y

multiplyCurry(10)(20) == 200
multiplyCurry(-10)(10) == -100

// foldr
var foldr: (Int => Int => Int) => Int => List[Int] => Int = f => i => {
  case Nil => i
  case x :: xs => f(x)(foldr(f)(i)(xs))
}

foldr(addCurry)(0)(List(1, 2, 3, 4, 5)) == 15
foldr(multiplyCurry)(1)(List(1, 2, 3, 4, 5)) == 120
