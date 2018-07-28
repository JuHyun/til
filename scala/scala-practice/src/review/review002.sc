// 1. list_ref
//def list_ref(l: List[Any], n: Int): Any = (l, n) match {
//  case (Nil, _) => Nil
//  case (x :: xs, 0) => x
//  case (x :: xs, n) => if (n > l.length - 1) list_ref(xs, l.length - 2) else list_ref(xs, n - 1)
//}
def list_ref(l: List[Any], n: Int): Any = {
  if (l == Nil) Nil
  else if (n == 0) l.head
  else if (n >= l.length) list_ref(l.tail, l.length - 2)
  else list_ref(l.tail, n - 1)
}

list_ref(Nil, 100) == Nil
list_ref(List('a', 'b'), 0) == 'a'
list_ref(List(1, 2), 0) == 1
list_ref(List(1, 2, 3, 4, 5), 100) == 5
list_ref(List(1, 2, 3, 4, 5), 1) == 2
list_ref(List(1, 2, 3, 4, 5), 3) == 4

// 2. length
//def length(l: List[Any]): Int = l match {
//  case Nil => 0
//  case x :: xs => 1 + length(xs)
//}
def length(l: List[Any]): Int = {
  if (l.isEmpty) 0 else 1 + length(l.tail)
}

length(Nil) == 0
length(List(1, 2, 3, 4, 5)) == 5
length(List('a', 2, "hello")) == 3

// 3. append
//def append(l1: List[Any], l2: List[Any]): List[Any] = {
//  if (l1 == Nil) l2 else l1.head :: append(l1.tail, l2)
//}
//def append(l1: List[Any], l2: List[Any]): List[Any] = (l1, l2) match {
//  case (Nil, _) => l2
//  case (x :: xs, y) => x :: append(xs, y)
//}
def append(l1: List[Any], l2: List[Any]): List[Any] = l1 match {
  case Nil => l2
  case x :: xs => x :: append(xs, l2)
}
append(Nil, Nil) == Nil
append(Nil, List(1, 2, 3)) == List(1, 2, 3)
append(List(1, 2, 3), Nil) == List(1, 2, 3)
append(List(1, 2, 3), List(4, 5)) == List(1, 2, 3, 4, 5)


// 4. sum
//def sum(l: List[Int]): Int = l match {
//  case Nil => 0
//  case x :: xs => x + sum(xs)
//}
def sum(l: List[Int]): Int = {
  if (l == Nil) 0 else l.head + sum(l.tail)
}

sum(Nil) == 0
sum(List()) == 0
sum(List(1, 2, 3, 4, 5)) == 15

// 5. product
//def product(l: List[Int]): Int = l match {
//  case Nil => 1
//  case x :: xs => x * product(xs)
//}
def product(l: List[Int]): Int = {
  if (l.isEmpty) 1 else l.head * product(l.tail)
}

product(Nil) == 1
product(List(1, 2, 3)) == 6

// 6. reverse
//def reverse(l: List[Any]): List[Any] = l match {
//  case Nil => Nil
//  case x :: xs => reverse(xs) ::: x :: Nil
//}
def reverse(l: List[Any]): List[Any] = {
  def reverse_iter(l: List[Any], r: List[Any]): List[Any] = l match {
    case Nil => r
    case x :: xs => reverse_iter(xs, x :: r)
  }

  reverse_iter(l, Nil)
}

reverse(Nil) == Nil
reverse(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1)
reverse(List('w', 'h', 'a', 't', 'h')) == List('h', 't', 'a', 'h', 'w')
