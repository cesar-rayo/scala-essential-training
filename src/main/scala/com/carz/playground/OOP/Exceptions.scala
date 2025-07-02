package com.carz.playground.OOP

/*
Hierarchy
Throwable
  - Error - JVM-related (memory, stack overflow
  - Exception
    - RuntimeException
      - Custom Exceptions
* */

object Exceptions {
  def sumN(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Negative numbers unsupported!")
    if(n == 0) 0
    else if (n >= 50_000) throw new RuntimeException("Number too big")
    else n + sumN(n - 1)
  }

  val attempt = try {
    sumN(-10)
  } catch {
    case e: IllegalArgumentException => -1
    case e: RuntimeException => Int.MaxValue
  }

  // Using indentation
  val attempt2 =
    try
      sumN(50_000)
    catch
      case e: IllegalArgumentException => -1
      case e: RuntimeException => Int.MaxValue

  class MyException() extends RuntimeException("New exception here!")

  val attempt3 = try {
    throw MyException()
  } catch {
    case mye: MyException => println(s"Something happened: ${mye.getMessage}")
  }

  def main(args: Array[String]): Unit = {
    println(s"attempt: $attempt")
    println(s"attempt2: $attempt2")
  }
}
