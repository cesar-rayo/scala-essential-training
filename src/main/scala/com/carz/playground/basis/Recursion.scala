package com.carz.playground.basis

object Recursion {
  // sum(3) = 1 + 2 + 3 = 6
  // sum(10) = 1 + 2 + .. + 10 = 55
  // sum(1) = 1 + sum(0) = 1
  // sum(0) = 0
  def sum(n: Int): Int = {
    if (n <= 0) 0
    else n + sum(n-1)
  }

  def printN(string: String, n: Int): Unit = {
    if (n <= 0) ()
    else {
      println(s"printN -> ${n}: ${string}")
      printN(string, n-1)
    }
  }

  /*
  Test all numbers from 2 to n/2, test whether n % d == 0
  var d = 2
  while (d < n/2) {
    if (n % d == 0)
      return false
    d += 1
  }
  return true
   */
  def isPrime(n: Int): Boolean = {
    /*
    isPrime(7) =
      testDivisors(2) =
      testDivisors(3) =
      testDivisors(4) = true
     */
    def testDivisors(d: Int): Boolean = {
      if (d > n/2) true
      else if (n % d == 0) false
      else testDivisors(d + 1)
    }
    if (n <= 0) false
    else if (n==1) false
    else testDivisors(2)
  }

  def concatenateN(string: String, n: Int): String = {
    if (n <= 0) "Not supported"
    else if (n==1) string
    else {
      var result = string
      result += concatenateN(result, n-1)
      result
    }
  }

  def concatenateN1(string: String, n: Int): String = {
    if (n <= 0) "Not supported"
    else string + concatenateN(string, n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 1) 1
    else if (n == 2) 2
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def main(args: Array[String]): Unit = {
    println(s"sum(10): ${sum(10)}")
    printN("Scala", 3)
    println(s"isPrime(7): ${isPrime(7)}")
    println(s"concatenateN: ${concatenateN("Scala", 3)}")
    println(s"concatenateN1: ${concatenateN1("Scala", 3)}")
    println(s"fibonacci: ${fibonacci(6)}")
  }
}
