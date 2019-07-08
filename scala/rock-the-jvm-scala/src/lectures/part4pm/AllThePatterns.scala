package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "number"
    case "Scala" => "The scala"
    case true => "true"
    case AllThePatterns => "A single object"
  }

  val matchAnything = x match {
    case _ =>
  }

  val matchVariable = x match {
    case something => s"I've found $something"
  }
  println(matchAnything)

  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"$something , 2"
  }
  println(matchTuple)

  val aNestedTuple = (1, (2, 3))
  val matchNestedTuple = aNestedTuple match {
    case (_, (2, v)) =>
  }

  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) => s"$head, $subhead, $subtail"
  }

  val aStandardList = List(1, 2, 3, 4)
  val matchStandardList = aStandardList match {
    case List(1, _, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 4 => // infix pattern
  }

  val unknown: Any = 2
  val matchUnknown = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  val matchNameBinding = aList match {
    case nonEmptyList@Cons(_, _) => // name binding => use the name here or later
    case Cons(1, rest@Cons(2, _)) => // name binding inside nested patterns
  }

  val multiplePatterns = aList match {
    case Empty | Cons(0, _) =>
    case _ =>
  }

  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  val numbers = List(1, 2, 3)
  val numberMatch = numbers match {
    case listOfString: List[String] => "a List of String"
    case listOfNumber: List[Int] => "a List of Int"
    case _ => "any"
  }

  // JVM tricks
  // doesn't recognize generic
  // case listOfString: List
  // case listOfNumber: List
  println(numberMatch)
}
