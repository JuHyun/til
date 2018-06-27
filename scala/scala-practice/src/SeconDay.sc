1 :: Nil

1 :: (2 :: Nil)

1 :: 2 :: 3 :: 4 :: Nil


List()

List(1, 2)

1 :: (List(2, 3, 4))

Nil

Nil == List()

List(1, 2) :: List(3, 4) :: Nil

//:type List(1,2,3)

List(1, "asdf")

def list_ref(l: List[Any], n: Int): Any = {
  if (n == 0) l.head else list_ref(l.tail, n - 1)
}

1 == list_ref(List(1, 2, 3), 0)
3 == list_ref(List(1, 2, 3), 2)

def length(l: List[Any]): Int = {
  if (l == Nil) 0 else 1 + length(l.tail)
}


4 == length(List(1, 2, 3, 4))

def append(l1: List[Any], l2: List[Any]): List[Any] = {
  if (l1 == Nil) l1 else l1.head :: append(l1.tail, l2)
}

List(1, 2, 3, 4, 5, 6) == append(List(1, 2, 3), List(4, 5, 6))


List(1, 2, 3) :: List(4, 5) :: Nil

List(1, 2, 3) ::: List(4, 5)

//head
//tail
//isEmpty
//length
//:::

def sum(l: List[Int]): Int = {
  if (l == Nil) 0 else l.head + sum(l.tail)
}

sum(List(1, 2, 3)) == 6

def sum__(l: List[Int]): Int = l match {
  case Nil => 0
  case _ => l.head + sum_(l.tail)
}

def sum_(l: List[Int]): Int = l match {
  case Nil => 0
  case x :: xs => x + sum_(xs)
}

def product(l: List[Int]): Int = l match {
  case Nil => 1
  case x :: xs => x * product(xs)
}

6 == product(List(1, 2, 3))
24 == product(List(1, 2, 3, 4))


def length_(l: List[Any]): Int = l match {
  case Nil => 0
  case _ :: xs => 1 + length_(xs)
}

3 == length_(List(1, 2, 3))


def append_(l1: List[Any], l2: List[Any]): List[Any] = l1 match {
  case Nil => l2
  case x :: xs => x :: append_(xs, l2)
}

List(4, 5, 6) == append_(Nil, List(4, 5, 6))
List(1, 2, 3, 4, 5, 6) == append_(List(1, 2, 3), List(4, 5, 6))
List(4, 5, 6) == append_(List(4, 5, 6), Nil)

// assignment
// reverse 
