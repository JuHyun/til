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
