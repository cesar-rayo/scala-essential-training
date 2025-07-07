package com.carz.playground.OOP

import scala.Int.unbox

object Lists {
  // single linked list
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val biggerList = 5 :: aList // add element at first position [5, 1, 2, 3] returns new List
  val biggerList_v2 = biggerList :+ 4 // [5, 1, 2, 3, 4]

  // utility methods
  val scalax5 = List.fill(3)("Scala") // ["Scala", "Scala", "Scala"]
  val reversedList = biggerList_v2.reverse // List(4, 3, 2, 1, 5)
  val contatenate = biggerList ++ List(6,7,8) // List(5, 1, 2, 3, 6, 7, 8)
  val stringRep = contatenate.mkString("-") // 5-1-2-3-6-7-8
  val stringRep2 = contatenate.mkString("[", ",", "]") // [5,1,2,3,6,7,8]

  val biggerList_v2Total = biggerList_v2.reduce((a,b) => a+b)
  val biggerList_v2TotalV2 = biggerList_v2.reduce(_ + _) // same as (a,b) => a+b

  // map transforms a list by applying a function in each element
  val tenxList = aList.map(x => x * 10) // List(10, 20, 30)
  val scalaList = aList.map(x => s"Scala $x") // List(Scala 1, Scala 2, Scala 3)

  // filter returns a new list with the items that satisfies the boolean function
  val evenNumbers = aList.filter(x => x % 2 == 0) // List(2)
  val oddNumbers = aList.filter(x => x % 2 != 0) // List(1, 3)

  // higher-order functions = take functions as arguments or return functions as results
  val expandedListz = aList.map(x => List(x, x + 1)) // List(List(1, 2), List(2, 3), List(3, 4))
  // flatMap - transform a list by applying the function to every element + combine the mini-list
  val expandedList = aList.flatMap(x => List(x, x + 1)) // List(1, 2, 2, 3, 3, 4)

  // Take a list of numbers and return a list of strings
  // [1, 2, 3] => [word, wordword, wordwordword]
  def repeatWord(string: String, n: Int): String = {
    if (n <= 0) ""
    else string + repeatWord(string, n-1)
  }
  def generateWordList(numbers: List[Int], word: String): List[String] = {
    numbers.map(x => repeatWord(word, x)) // List(scala, scalascala, scalascalascala)
  }

  // Generate the first n numbers in a list with a recursive function
  /*
    n List
    5 generateN(4) :+ 5
    4 generateN(3) :+ 4
    3 generateN(2) :+ 3
    2 generateN(1) :+ 2
    1 generateN(0) :+ 1
    0 List()
  * */
  def generateNumbers(n: Int): List[Int] = {
    if (n <= 0) List()
    else generateNumbers(n-1) :+ n
  }
  val numbersList = generateNumbers(40)

  // from a list of numbers return the prime numbers
  def isPrime(n: Int): Boolean = {
    def testDivisors(d: Int): Boolean = {
      if (d > n / 2) true
      else if (n % d == 0) false
      else testDivisors(d + 1)
    }
    if (n <= 0) false
    else if (n == 1) false
    else testDivisors(2)
  }

  val primeNumbers = numbersList.filter(x => isPrime(x))

  // from a list of numbers return the list of digits
  // [12,56,5,851] => [1,2,5,6,5,8,5,1]
  val anotherList = List(12, 56, 5, 851)

  def formatDigits(numbers: List[Int]): String = {
    numbers.map(x => x.toString.split("").mkString(",")).mkString("[", ",", "]")
  }

  def digits(n: Int): List[Int] = {
    // 123 => 3,2,1
    def getDigits(number: Int): List[Int] = {
      if (number <= 0) List()
      else {
        val lastDigit = number % 10
        val quotient = number / 10
        lastDigit :: getDigits(quotient)
      }
    }
    if (n < 0) List()
    else if (n == 0) List(0)
    else getDigits(n).reverse
  }
  // [12, 987] => [[1,2], [9,8,7]] => [1,2,9,8,7]
  val complexFlatMap = anotherList.flatMap(x => digits(x))

  // List Comprehensions
  val numbers = List(1,2,3,4)
  val colors = List("black", "white", "blue")
  // List(1-black, 1-white, 1-blue, 2-black, 2-white, 2-blue, 3-black, 3-white, 3-blue, 4-black, 4-white, 4-blue)
  val combinations = numbers.flatMap(n => colors.map(c => s"$n-$c"))

  // This is an expression, "for every number in numbers and for every color in colors generate s"$n-$c"
  val combinations_2 = for {
    n <- numbers // <-- generator
    c <- colors
  } yield s"$n-$c"

  def generateLetters(letter: Char): List[Char] = {
    if (letter == 'A') List('A')
    else generateLetters((letter.toInt - 1).toChar):+ letter
  }

  // Generate a Chessboard
  val numbers2 = generateNumbers(8)
  val letters = generateLetters('H')
  // List(A1, B1, C1, D1, E1, F1,..., H8)
  val chessboard = for {
    n <- numbers2
    l <- letters
  } yield s"$l$n"


  def main(args: Array[String]): Unit = {
    println(s"aList: $aList")
    println(s"Head: ${aList.head}")
    println(s"Tail: ${aList.tail}")
    println("==============================")
    println(s"biggerList: $biggerList")
    println(s"aList: $aList")
    println(s"biggerList_v2: ${biggerList_v2.mkString("[", ",", "]")}")
    println(s"biggerList_v2Total: $biggerList_v2Total")
    println(s"biggerList_v2TotalV2: $biggerList_v2TotalV2")
    println(s"generateWordList(aList): ${generateWordList(aList, "word").mkString("[", ",", "]")}")
    println(s"anotherList: $anotherList")
    println(s"formatDigits(anotherList): ${formatDigits(anotherList)}")
    println(s"complexFlatMap ${complexFlatMap.mkString("[", ",", "]")}")
    println(s"numbersList: ${numbersList.mkString("[", ",", "]")}")
    println(s"primeNumbers(numbersList): ${primeNumbers.mkString("[", ",", "]")}")
    println(s"combinations: $combinations")
    println(s"combinations_2: $combinations_2")
    println(s"letter_combinations: $chessboard")
  }

}
