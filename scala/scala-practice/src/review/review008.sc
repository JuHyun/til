sealed trait Bool

case object True extends Bool

case object False extends Bool

True.isInstanceOf[Bool] == true
False

var and: (Bool, Bool) => Bool = {
  case (True, True) => True
  case (_, _) => False
}
and(True, True) == True
and(True, False) == False
and(False, True) == False
and(False, False) == False

var not: Bool => Bool = {
  case True => False
  case False => True
}

not(True) == False
not(False) == True
not(not(True)) == True

var or: (Bool, Bool) => Bool = {
  case (False, False) => False
  case (_, _) => True
}

or(True, True) == True
or(True, False) == True
or(False, True) == True
or(False, False) == False

var xor: (Bool, Bool) => Bool = (a, b) => if (not(a) == b) True else False

xor(True, True) == False
xor(True, False) == True
xor(False, True) == True
xor(False, False) == False

sealed trait Season

case object Spring extends Season