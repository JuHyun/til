def square(n: Int): Int = n * n

square(3) == 9
square(10) == 100

def plusOne(n: Int): Int = n + 1

plusOne(1) == 2
plusOne(2) == 3
plusOne(10) == 11

def one() = 1

one()
one

if (false) 1 else 0.0
if (false) 1 else 0
if (false) 1 else null

def factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)

factorial(1) == 1
factorial(2) == 2
factorial(3) == 6
factorial(4) == 24
factorial(5) == 120

def factorial2(n: Int): Int = n match {
  case 0 => 1
  case _ => n * factorial2(n - 1)
}
factorial2(1) == 1
factorial2(2) == 2
factorial2(3) == 6
factorial2(4) == 24
factorial2(5) == 120
factorial2(100)

def factorial3(n: BigInt): BigInt = n match {
  case n: BigInt if (n <= 1) => 1
  case _ => n * factorial3(n - 1)
}
factorial3(1) == 1
factorial3(2) == 2
factorial3(3) == 6
factorial3(4) == 24
factorial3(5) == 120
factorial3(100)

// 5 * factorial(4)
// 5 * 4 * factorial(3)
// 5 * 4 * 3 * factorial(2)
// 5 * 4 * 3 * 2 * factorial(1)
// 5 * 4 * 3 * 2 * 1 * factorial(0)
def factorial4(n: BigInt): BigInt = {
  def factorial_iter(p: BigInt, c: BigInt, n: BigInt): BigInt = {
    if (p <= 1) n else factorial_iter(p - 1, p - 1, c * n)
  }

  factorial_iter(n, 1, n)
}
// 3 1 3 =>
// 2 2 1 * 3
// 1 1 2 * 3


factorial4(1) == 1
factorial4(2) == 2
factorial4(3) == 6
factorial4(4) == 24
factorial4(5) == 120
factorial4(100)

def fibonachi(n: BigInt): BigInt = n match {
  case n: BigInt if (n == 0) => 0
  case n: BigInt if (n == 1) => 1
  case _ => fibonachi(n - 2) + fibonachi(n - 1)
}

fibonachi(0) == 0
fibonachi(1) == 1
fibonachi(2) == 1
fibonachi(3) == 2
fibonachi(4) == 3
fibonachi(5) == 5
fibonachi(6) == 8
fibonachi(7) == 13

//0 => 0 1 0 => 0
//1 => 0 1 1 => 1, 0, 0 =>  1
//2 => 0 1 2 => 1, 0, 1 =>  1, 1, 0 => 1
//3 => 0 1 3 => 1, 0, 2 =>  1, 1, 1 => 2, 1, 0 => 2
def fibonachi2(n: BigInt): BigInt = {
  def fibonachi_iter(p1: BigInt, p2: BigInt, n: BigInt): BigInt = {
    if (n == 0) p1 else fibonachi_iter(p1 + p2, p1, n - 1)
  }

  fibonachi_iter(0, 1, n)
}
fibonachi2(0) == 0
fibonachi2(1) == 1
fibonachi2(2) == 1
fibonachi2(3) == 2
fibonachi2(4) == 3
fibonachi2(5) == 5
fibonachi2(6) == 8
fibonachi2(7) == 13

//////////////////////////////////////
def list_ref(l: List[Any], n: Int): Any = n match {
  case 0 => l.head
  case n if (n >= l.length) => list_ref(l.tail, l.length - 2)
  case _ => list_ref(l.tail, n - 1)
  //  if (n == 0) l.head else list_ref(l.tail, n - 1)
}

list_ref(List(1, 2, 3, 4, 5, 6), 0) == 1
list_ref(List(1, 2, 3, 4, 5, 6), 1) == 2
list_ref(List(1, 2, 3, 4, 5, 6), 3) == 4
list_ref(List(1, 2, 3, 4, 5, 6), 5) == 6
list_ref(List(1, 2, 3, 4, 5, 6), 6) == 6
list_ref(List(1, 2, 3, 4, 5, 6), 7) == 6

def length(l: List[Any]): Int = l match {
  case Nil => 0
  case _ => length(l.tail) + 1
}

length(Nil) == 0
length(List()) == 0
length(List(1)) == 1
length(List("string")) == 1
length(List(1, "abc", 'A')) == 3

def append(l1: List[Any], l2: List[Any]): List[Any] = l1 match {
  case Nil => l2
  case x :: xs => l1.head :: append(xs, l2)
}

append(List(), List(4)) == List(4)
append(Nil, List(4)) == List(4)
append(List(1, 2, 3), List(4)) == List(1, 2, 3, 4)

def sum(l: List[Int]): Int = {
  if (l == Nil) 0 else l.head + sum(l.tail)
}

sum(Nil) == 0
sum(List()) == 0
sum(List(1)) == 1
sum(List(1, 2, 3)) == 6
sum(List(1, 2, 3, 4, 5)) == 15

def sum2(l: List[Int]): Int = l match {
  case Nil => 0
  case x :: xs => x + sum2(xs)
}

sum2(Nil) == 0
sum2(List()) == 0
sum2(List(1)) == 1
sum2(List(1, 2, 3)) == 6
sum2(List(1, 2, 3, 4, 5)) == 15

def product(l: List[Int]): Int = {
  if (l == Nil) 1 else l.head * product(l.tail)
}

product(Nil) == 1
product(List()) == 1
product(List(1)) == 1
product(List(1, 2)) == 2
product(List(1, 2, 3, 4, 5)) == 120

def product2(l: List[Int]): Int = l match {
  case Nil => 1
  case x :: xs => x * product2(xs)
}

product2(Nil) == 1
product2(List()) == 1
product2(List(1)) == 1
product2(List(1, 2)) == 2
product2(List(1, 2, 3, 4, 5)) == 120

def reverse(l: List[Any]): List[Any] = l match {
  case Nil => Nil
  case x :: xs => reverse(xs) ::: List(x)
}

reverse(Nil) == Nil
reverse(List()) == Nil
reverse(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1)
reverse(List("abc", 2, 'c', 'd')) == List('d', 'c', 2, "abc")

def reverse2(l: List[Any]): List[Any] = {
  def reverse_iter(l: List[Any], r: List[Any]): List[Any] = l match {
    case Nil => r
    case x :: xs => reverse_iter(xs, x :: r)
  }

  reverse_iter(l, Nil)
}

reverse2(Nil) == Nil
reverse2(List()) == Nil
reverse2(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1)
reverse2(List("abc", 2, 'c', 'd')) == List('d', 'c', 2, "abc")

def drop(l: List[Any], n: Int): List[Any] = (l, n) match {
  case (xs, 0) => xs
  case (Nil, _) => Nil
  case (x :: xs, n) => x :: drop(xs, n - 1)
}

drop(List(1, 2, 3), 0) == List(1, 2, 3)
drop(Nil, 3) == Nil
drop(List(1, 2, 3), 1) == List(1)