// drop
def drop(n: Int, l: List[Any]): List[Any] = (n, l) match {
  case (0, l) => l
  case (_, Nil) => Nil
  case (n, _ :: xs) => drop(n - 1, xs)
}

drop(0, List(1, 2, 3)) == List(1, 2, 3)
drop(100, Nil) == Nil
drop(1, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5)
drop(2, List(1, 2, 3, 4, 5)) == List(3, 4, 5)
drop(4, List(1, 2, 3, 4, 5)) == List(5)
drop(100, List(1, 2, 3, 4, 5)) == Nil

// take
def take(n: Int, l: List[Any]): List[Any] = (n, l) match {
  case (0, l) => Nil
  case (_, Nil) => Nil
  case (n, x :: xs) => x :: take(n - 1, xs)
}

take(0, List('a', 'b')) == Nil
take(100, Nil) == Nil
take(1, List("hi", "hello")) == List("hi")
take(2, List("hi", "hello")) == List("hi", "hello")
take(3, List(1, 2, 3, 4, 5)) == List(1, 2, 3)
take(100, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5)

// insert
def insert(n: Int, l: List[Int]): List[Int] = (n, l) match {
  case (n, Nil) => List(n)
  case (n, x :: xs) => {
    if (n <= x) n :: x :: xs
    else x :: insert(n, xs)
  }
}

insert(0, Nil) == List(0)
insert(1, Nil) == List(1)
insert(0, List(0, 1)) == List(0, 0, 1)
insert(1, List(0, 1, 2, 3)) == List(0, 1, 1, 2, 3)
insert(3, List(0, 1, 2, 4, 5)) == List(0, 1, 2, 3, 4, 5)
insert(100, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5, 100)

// isort
def isort(l: List[Int]): List[Int] = l match {
  case Nil => Nil
  case x :: xs => insert(x, isort(xs))
}

isort(Nil) == Nil
isort(List(5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5)
isort(List(5, 4, 2, 1, 3)) == List(1, 2, 3, 4, 5)
//insert(5, isort(List(4, 3, 2, 1)))
//insert(5, insert(4, isort(3, 2, 1)))
//insert(5, insert(4, insert(3, isort(2, 1))))
//insert(5, insert(4, insert(3, insert(2, isort(1)))))
//insert(5, insert(4, insert(3, insert(2, isort(insert(1, isort(Nil)))))))
// => insert(5, insert(4, insert(3, insert(2, List(1)))))
// => insert(5, insert(4, insert(3, List(1,2))))
// => insert(5, insert(4, List(1, 2, 3)))


// function vs method
var foo = 1
def bar = 1

foo
bar

// plusOne function vs method
var plusOne: Int => Int = x => x + 1
plusOne(0) == 1
plusOne(1) == 2
plusOne(3)

// method
def m_plusOne(n: Int): Int = n + 1
m_plusOne(0) == 1
m_plusOne(1) == 2
m_plusOne(3)

//var add: (Int, Int) => Int = (x, y) => x + y
var add: (Int, Int) => Int = _ + _
add(0, 1) == 1
add(10, 20) == 30


def m_add(x: Int, y: Int): Int = x + y
m_add(0, 1)

// twice function
var twice: ((Int => Int), Int) => Int = (f, x) => f(f(x))

twice(plusOne, 1) == 3
twice(plusOne, 10) == 12

// multiply function
var multiply: Int => Int => Int = x => y => x * y
multiply(1)(3) == 3
multiply(10)(30) == 300
