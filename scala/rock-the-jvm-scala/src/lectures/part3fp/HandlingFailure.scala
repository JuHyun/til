package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success("success")
  val aFailure = Failure(new RuntimeException("super fail!!"))
  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("I will not give you any string!")

  //  println(unsafeMethod()) // occurs RuntimeException!
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw exception
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "This is a backup method"

  val fallbackTry = Try(unsafeMethod()) orElse Try(backupMethod())
  println(fallbackTry)

  //
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("I will not give you any string!"))

  def betterBackupMethod(): Try[String] = Success("This is a backup method")

  val betterFallbackTry = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFallbackTry)

  // map, filter, flatmap
  println(aSuccess.map(x => (" " + x) * 10))
  println(aSuccess.flatMap(x => Success((" " + x) * 3)))
  println(aSuccess.filter(_.contains("o")))

  /**
    * Exercise.
    */
  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection failed")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  /**
    * Exercise.
    * - if you get the html page from connection, print it to console
    */

  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  println(possibleConnection)
  val possibleHtml: Try[String] = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHtml.foreach(renderHTML)

  // chained: shorthand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for - comprehension version
  val html = for {
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } yield renderHTML(html)
}
