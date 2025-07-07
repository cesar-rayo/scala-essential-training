package com.carz.playground.OOP

object TuplesMaps {

  // tuples
  val aTuple = (2, "Scala", "some")
  val firstField = aTuple._1
  val thirdField = aTuple._3

  val aTupe_v2 = 2 -> "Scala" // Only works for tuples with 2 elements

  // maps: keys -> values, unique keys (dictionaries)
  // maps are immutable
  val aMap = Map()
  val phoneBook = Map(
    ("Jim", 555),
    ("Daniel", 921),
    ("Jane", 123)
  )
  val phoneBook_v2 = Map(
    "Jim" -> 555,
    "Daniel" -> 921,
    "Jane" -> 123
  )

  // Add new element
  val phoneBook_v3 = phoneBook_v2 + ("Mary" -> 568)
  val phoneBook_v4 = phoneBook_v3 - "Daniel"

  // List <-> Map conversions
  val listOfEntries = List(
    "Jim" -> 555,
    "Daniel" -> 921,
    "Jane" -> 123
  )
  val mapOfEntries = listOfEntries.toMap
  val listphoneBook_v4 = phoneBook_v4.toList

  def main(args: Array[String]): Unit = {
    println(s"aTuple: $aTuple")
    println(s"thirdField: $thirdField")
    println(s"aTupe_v2._2: ${aTupe_v2._2}")
    println(s"phoneBook: $phoneBook")
    println(s"phoneBook_v2: $phoneBook_v2")
    println(s"phoneBook_v2.contains(\"Daniel\"): ${phoneBook_v2.contains("Daniel")}")
    println(s"phoneBook_v3(\"Mary\"): ${phoneBook_v3("Mary")}")
    println(s"phoneBook_v4.contains(\"Daniel\"): ${phoneBook_v4.contains("Daniel")}")
    println(s"phoneBook_v3.keySet: ${phoneBook_v3.keySet}")
    println(s"phoneBook_v3.values: ${phoneBook_v3.values}") // returns iterable
    println(s"phoneBook_v3.values.toList: ${phoneBook_v3.values.toList.mkString("[", ",", "]")}")
    println(s"mapOfEntries: $mapOfEntries")
    println(s"listphoneBook_v4: $listphoneBook_v4")
  }
}
