case class User(name: String, age: Int)

val userBase = List(User("Travis", 28), User("Angelina", 43), User("Brad Pitte", 48))

val twentySomeones = for (user <- userBase if (user.age >= 20 && user.age < 30))
  yield user.name

twentySomeones.foreach(name => println(name))

def foo(n: Int, v: Int) =
  for (i <- 0 until n;
        j <- 0 until n if i + j == v)
//    println(s"($i, $j)")
    yield (i, j)

foo(10, 15) foreach {
  case (i, j) => println(s"($i, $j)")
}

//foo(10, 15)
