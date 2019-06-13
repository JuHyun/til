def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "tow"
  case _ => "many"
}

matchTest(1)
matchTest(2)
matchTest(3)

def matchTest(x: Any): Any = x match {
  case 1 => "one"
  case "two" => 2
  case y: Int => "scala.Int"
}

matchTest("two")
matchTest(1)
matchTest(10)

abstract class Device

case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}

goIdle(Phone("iphone"))
goIdle(Phone("google"))
goIdle(Computer("mac"))

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}

findPlaceToSit(Couch())
findPlaceToSit(Chair())
