package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // WORK with unsafe APIs
  def unsafeMethod(): String = null

  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained method
  def backupMethod(): String = "A Valid result"

  val chainedResult = Option(unsafeMethod()).getOrElse(Option(backupMethod()))
  println(chainedResult)

  // Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A Valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  // Functions on Option
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)
  //  println(noOption.get) // UNSAFE! Do not USE! NoSuchElementException Error!

  // Map, Filter, Flatmap
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehensions
  /**
    * Exercise.
    */
  val config: Map[String, String] = Map(
    "host" -> "172.100.200.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connnected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // Try to establish connection, if so - print the connection method
  val host: Option[String] = config.get("host")
  val port: Option[String] = config.get("port")

  /**
    * if (h != null)
    *   if (p != null)
    *     return Connection.apply(h, p)
    * return null
    */
  val connection: Option[Connection] = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /**
    * if (c != null)
    *   return c.connect
    * return null
    */
  val connectionStatus: Option[String] = connection.map(c => c.connect)
  /**
    * if (connectionStatus == null)
    *   println(None)
    * else
    *   println(Some(connectionStatus))
    */
  println(connectionStatus)
  /**
    * if (connectionStatus != null)
    *   println(connectionStatus)
    */
  connectionStatus.foreach(println)

  // chained simple one
  println("================== chained simple one ======================")
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port)))
    .map(connection => connection.connect)
    .foreach(println)

  // for - comprehensions
  println("================== for-comprehensions ======================")
  val connectionStatuses = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connectionStatuses.foreach(println)
}
