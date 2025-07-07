package com.carz.playground.OOP

object Collections {
  // ranges
  val first10numbers = 1 to 10
  val f10numbers = first10numbers.toList
  val firstchars = ('A' to 'H').toList

  // foreach returns unit
  // (1 to 10).foreach(_ => println("Scala"))
  val list10strings2 = (1 to 10).map(_ => "Scala")

  // arrays
  val anArray = Array.ofDim[Int](1000) // Int[] (java)
  anArray.update(0, 42) // set 42 at index 0
  val fifthNumber = anArray(4) // anArray[4]


  // sets - collections with no duplicates
  // in sets contains and apply methods do the same thing
  // does not guarantee the elements order
  val aSet = Set(1,2,3,4,2,3,4,1) // [1, 2, 3, 4]

  // sets are immutable
  val aBiggerSet = aSet + 99
  val aSmallerSet = aSet - 4

  // concatenation == union
  val anotherSet = Set(4,5,6,7,8,9)
  val combinedSet = aSet.union(anotherSet) // [5, 1, 6, 9, 2, 7, 3, 8, 4]
  val combinedSet_v2 = aSet ++ anotherSet // [5, 1, 6, 9, 2, 7, 3, 8, 4]
  val combinedSet_v3 = aSet | anotherSet // [5, 1, 6, 9, 2, 7, 3, 8, 4]

  // difference
  val diffSet = aSet.diff(anotherSet) // [1, 2, 3]
  val diffSet_v2 = aSet -- anotherSet // [1, 2, 3]

  // intersection
  val intersection = aSet.intersect(anotherSet) // [4]
  val intersection_v2 = aSet & anotherSet // [4]

  // [5, 10, 20, 1, 6, 9, 2, 12, 3, 18, 16, 8, 4, 15, 24, 25, 36, 30]
  // Again, a Set does not guarantee the order
  // combinations = { x * y | x in Set(1,2,3,4,5,6), y in Set(1,2,3,4,5,6)}
  val combinations = for {
    x <- Set(1,2,3,4,5,6)
    y <- Set(1,2,3,4,5,6)
  } yield x * y

  def main(args: Array[String]): Unit = {
    println(s"first10numbers: $first10numbers")
    println(s"f10numbers: $f10numbers")
    println(s"firstchars: $firstchars")
    println(s"list10strings2: $list10strings2")
    println(s"aSet: $aSet")
    println(s"aSet.contains(3)?: ${aSet.contains(3)}")
    println(s"aSet.contains(99)?: ${aSet(99)}") // using apply method aset.apply(99) = aSet(99)
    println(s"aBiggerSet.contains(99)?: ${aBiggerSet(99)}")
    println(s"aSmallerSet.contains(4)?: ${aSmallerSet(4)}")
    println(combinations)


  }
}
