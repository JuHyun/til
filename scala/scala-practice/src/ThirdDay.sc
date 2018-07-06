/////////////////////////////////////////////////////
//                   Drop                          //
/////////////////////////////////////////////////////
def drop(n: Int, l: List[Any]): List[Any] = (n, l) match {
  case (0, xs) => xs
  case (n, Nil) => Nil
  case (n, _ :: xs) => drop(n, xs)
}

/////////////////////////////////////////////////////
//                   Take                          //
/////////////////////////////////////////////////////
def take(n: Int, l: List[Any]): List[Any] = (n, l) match {
  case (0, xs) => Nil
  case (n, Nil) => Nil
  case (n, x :: xs) => x :: take(n - 1, xs)
}

take(1, List(1, 2, 3))
take(2, List(1, 2, 3))
take(3, List(1, 2, 3))
take(10, List(1, 2, 3))


/////////////////////////////////////////////////////
//                   Insert                        //
/////////////////////////////////////////////////////
def insert(n: Int, l: List[Int]): List[Int] = (n, l) match {
  case (0, l) => l
  case (n, Nil) => n :: Nil
  case (n, x :: xs) => {
    if (n < x) n :: x :: xs else x :: insert(n, xs)
  }
}

insert(0, List(1, 2, 3))
insert(4, List(1, 2, 3))
insert(2, List(1, 3, 4))
insert(3, List(1, 2, 3, 4))

/////////////////////////////////////////////////////
//                   isort                         //
/////////////////////////////////////////////////////
def isort(l: List[Int]): List[Int] = l match {
  case Nil => Nil
  case x :: xs => insert(x, isort(xs))
}


isort(List(3, 2, 1))


var foo = 1
var bar = () => 1

// function
var plusOne: Int => Int = x => x + 1
var add: (Int, Int) => Int = (x, y) => x + y

plusOne(10)
add(10, 20)

// method
def plusOne_(x: Int): Int = x + 1

var twice: ((Int => Int), Int) => Int = (f, x) => f(f(x))

twice(plusOne, 0)
twice(plusOne, 1)
twice(plusOne, 2)

var multiply3: Int => Int = x => x * 3
twice(multiply3, 5)


