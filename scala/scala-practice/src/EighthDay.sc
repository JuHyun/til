////////////////////////////
//  def vs val
////////////////////////////
// def: method
// val: function
////////////////////////////
val add: (Int, Int) => Int = (x, y) => x + y
add(1, 2)

var addCur: Int => Int => Int = x => y => x + y
addCur(1)(2)

//def addDef(x: Int)(y: Int): Int = (x) => (y) => x + y

def a = 3
a

def foo = {
  println("hahaha");
  3
}

foo

foo

var fooz = foo _

fooz
fooz()

var bar = {
  println("hohoho");
  3
}

bar

bar

def add2[A](a: A, b: A): A = ???
add2 _

add2[Int] _

add2[String] _

//add2(1, 2)

////////////////////////
// Y Combinator
////////////////////////

////////////////////////
// Z Combinator
////////////////////////

////////////////////////
// Data Type
////////////////////////
// expression, type: source level, value: runtime level


// SUM Type
sealed trait Bool

case object True extends Bool // singleton object
case object False extends Bool

True

val not: Bool => Bool = {
  case True => False
  case False => True
}

not(True)
not(False)
not(not(False))


//var and:(Bool, Bool) => Bool = (a, b) => if (a)


sealed trait Season

case object Spring extends Season // singleton object
case object Summer extends Season

case object Fall extends Season

case object Winter extends Season

val toInt: Season => Int = {
  case Spring => 0
  case Summer => 1
  case Fall => 2
  case Winter => 3
}

toInt(Summer)


//// homework.
// toSeason
// Next
