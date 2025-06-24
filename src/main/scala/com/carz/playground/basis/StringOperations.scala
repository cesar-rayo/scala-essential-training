package com.carz.playground.basis

object StringOperations {
  val aString = "Scala Something"
  val length = aString.length
  val checkEmpty = aString.isEmpty
  val startsWith = aString.startsWith("Scala")
  val combine = aString + " Something else"
  val findIndex = aString.indexOf("Java")
  val findIndex2 = aString.indexOf("Scala")

  val interpolation = s"The string [$aString] has length $length, eval: ${8/2}"
  // the s-interpolation uses the method toString of each element

  def main(args: Array[String]): Unit = {
    println(s"findIndex: ${findIndex}")
    println(s"findIndex2: ${findIndex2}")
    println(s"interpolation: ${interpolation}")
  }

}
