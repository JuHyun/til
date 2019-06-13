def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)

def modN(n: Int)(x: Int) = ((x % n) == 0)

val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
filter(nums, modN(2))
filter(nums, modN(3))

def foldLeft[B](z: B)(op: (B, A) => B): B

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res = numbers.foldLeft(0)((m, n) => m + n)
println(res)

val multiplyRes = numbers.foldLeft(1)(_ * _)
print(multiplyRes)

val numberFunc = numbers.foldLeft(List[Int]()) _
val squares = numberFunc((xs, x) => xs :+ x*x)
print(squares)

val cubes = numberFunc((xs, x) => xs :+ x*x*x)
println(cubes)
