def convertBooleanToString(bool: Boolean): String = {
  if (bool) "true" else "false"
}

convertBooleanToString(false)
convertBooleanToString(true)

def convertBooleanToStringMatch(bool: Boolean): String = bool match {
  case true => "true"
  case false => "false"
}

convertBooleanToStringMatch(false)
convertBooleanToStringMatch(true)

def isTrue(a: Any): Boolean = a match {
  case 0 | "" | false | Nil => false
  case _ => true
}

isTrue(0)
isTrue(false)
isTrue("")
isTrue(Nil)
isTrue("hello")
isTrue(true)
isTrue(List())
isTrue(Map())

val count = 10
count match {
  case 1 =>
    "one, a lonely number"
  case x if (x == 2 || x == 3) =>
    "two three"
  case x if (x > 3) =>
    "four plus"
  case _ => "zero or less"
}
