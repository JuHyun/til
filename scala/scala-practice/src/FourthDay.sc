var add: (Int, Int) => Int = (x, y) => x + y
add(2, 3)

var add2: (Int, Int) => Int = _ + _
add(2, 3)


/////////////////////////////////////
// Processing lists
/////////////////////////////////////

var addOne: (Int) => Int = (x) => x + 1
val map: ((Int => Int), List[Int]) => List[Int] = (f, l) => (f, l) match {
//val map2: ((Int => Int), List[Int]) => List[Int] = {
  case (_, Nil) => Nil
  case (f, x :: xs) => f(x) :: map(f, xs)
}

map(addOne, List(1, 2, 3, 4)) == List(2, 3, 4, 5)

map(_ + 1, List(1, 2, 3, 4)) == List(2, 3, 4, 5)

map(_ * 3, List(1, 2, 3, 4)) == List(6, 9, 12, 15)


val map2: ((Int => Boolean), List[Int]) => List[Int] = {
  case (_, Nil) => Nil
  case (f, x :: xs) => {
    if (f(x)) x :: Nil else map2(f, xs)
  }
}


val filter: ((Int => Boolean), List[Int]) => List[Int] = {
  case (_, Nil) => Nil
  case (f, x :: xs) => {
    if (f(x)) x :: filter(f, xs) else filter(f, xs)
  }
}
filter(_ > 10, List(30, 4, 20, 5, 10, 1))

val filter2: ((Int => Boolean), List[Int]) => List[Int] = {
  case (_, Nil) => Nil
  case (f, x :: xs) if f(x) => x :: filter2(f, xs)
  case (f, _ :: xs) => filter2(f, xs)
}

///////////// Currying ////////////
// a single argument 로만 받는 것!
// (=> (=> =>)) 함수는 뒤에서부터 묶는 것
// :: :: ::
var addCurry: Int => (Int => Int) = a => (b => a + b)
var addCurry2: Int => Int => Int = a => b => a + b



