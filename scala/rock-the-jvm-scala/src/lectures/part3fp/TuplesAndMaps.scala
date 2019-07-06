package lectures.part3fp

object TuplesAndMaps extends App {

  // tuple: finite ordered "lists"
  val aTuple = (2, "Hello Scala") // equivalent to Tuple2[Int, String] = (Int, String)
  println(aTuple)
  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  // Maps: key -> value
  val aMap: Map[String, Int] = Map()
  println(aMap)

  val phonebook = Map(("Jim", 50), "Danial" -> 40).withDefaultValue(-1)
  // a -> b is a sugar for (a, b)
  println(phonebook)

  // Map operations
  println(phonebook.contains("Danial"))
  println(phonebook("Danial"))
  println(phonebook get "Danial")
  println(phonebook("not-found"))

  // add a pairing
  val newPairing = "Marry" -> 33
  println(newPairing)
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  println(newPhonebook - "Jim")

  // functional on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKey
  println(newPhonebook.filterKeys(x => x.startsWith("M"))) // filterKeys(_.startWith("M"))

  // mapValues
  println(newPhonebook.mapValues(value => "010-" + value))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Angelina", 45)).toMap)

  val names = List("Angelina", "Daniel", "Tom", "Alan", "Jim", "Jack", "Jason")
  println(names.groupBy(name => name.charAt(0)))

  /**
    * Exercise.
    */
  println("========================== exercise ===================================")
  val persons = Map(("Jim", 555), "JIM" -> 900)
  val anotherPersons = Map("Jim" -> 9000, ("Angelina", 10000))
  val mergedPersons = persons ++ anotherPersons
  println(mergedPersons)

  println("--------------- 2-1. -----------------------")

  //  - add person to the network
  //  - remove
  //  - friend (mutual)
  //  - unfriend
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def frined(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val frinedB = network(b)

    network + (a -> (friendA + b)) + (b -> (frinedB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val frinedA = network(a)
    val frinedB = network(b)

    network + (a -> (frinedA - b)) + (b -> (frinedB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, friends.head, person))
    }

    val unfrineded = removeAux(network(person), network)
    unfrineded - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(add(empty, "Marry"), "Bob"), "Angelina")
  println(network)

  val marryAndAngelina = frined(network, "Marry", "Angelina")
  println(marryAndAngelina)
  val bobAndAngelina = frined(marryAndAngelina, "Bob", "Angelina")
  println(bobAndAngelina)

  val goodByeBobAndAngelina = unfriend(bobAndAngelina, "Bob", "Angelina")
  println(goodByeBobAndAngelina)

  val removeAngelina = remove(bobAndAngelina, "Angelina")
  println(removeAngelina)

  println("--------------- 2-2. -----------------------")
  /** *********************
    * Jim, Bob, Marry
    * - nFrined
    * - most friends
    * - how many friends no friend
    * - socialConnection
    */
  val people = add(add(add(empty, "Jim"), "Bob"), "Marry")
  val jimAndBob = frined(people, "Jim", "Bob")
  val testNetwork = frined(jimAndBob, "Bob", "Marry")
  println(testNetwork)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(testNetwork, "Bob"))

  //  def mostFriends(network: Map[String, Set[String]]): String = {
  //    def mostFriendsAux(maxFriends: Int,
  //                       friends: Map[String, Set[String]],
  //                       mostFriend: (String, Set[String])): (String, Set[String]) = {
  //      if (friends.isEmpty) mostFriend
  //      else {
  //        val numberOfFriends = nFriends(friends, friends.head._1)
  //        if (numberOfFriends > maxFriends) {
  //          mostFriendsAux(numberOfFriends, friends.tail, friends.head)
  //        } else {
  //          mostFriendsAux(maxFriends, friends.tail, mostFriend)
  //        }
  //      }
  //    }
  //
  //    val mostFriend = mostFriendsAux(network.head._2.size, network.tail, network.head)
  //    mostFriend._1
  //  }
  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pairing => pairing._2.size)._1

  println(mostFriends(testNetwork))

  def nPeopleWithNoFriend(network: Map[String, Set[String]]): Int =
    network.filterKeys(key => network(key).isEmpty == 0).size //network.filter(pairing => pairing._2.isEmpty).size
  // network.count(pairing => pairing._2.isEmpty) // == network.filter(_._2.isEmpty).size

  println(nPeopleWithNoFriend(testNetwork))
  println(nPeopleWithNoFriend(add(add(empty, "Katy"), "Bread")))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (target == person) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNetwork, "Marry", "Bob"))
}

