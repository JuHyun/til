package sample

object Main extends App {

  println(sample.Blah.sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))

  import sample.Logger.info

  val project1 = new Project("TPS Report", 1)
  val project2 = new Project("Website redesign", 5)

  info("Created projects")
}

class Project(name: String, daysToComplete: Int)
