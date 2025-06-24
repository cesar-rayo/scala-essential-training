package com.carz.playground.basis

object ValuesAndTypes {
  // Constant can not be changed
  val testConstant: Int = 42

  var testVariable: Int = 56
  testVariable = 66

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = 45 // 4 bytes
  val aShort: Short = 5665 // 2 bytes
  val aLong: Long = 5622626562L // 8 byt integers
  val aFloat: Float = 2.4f // 4 byte decimal
  val aDouble: Double = 3.14 // 8 byte decimal

  val aString: String  = "Some string"


  def main(args: Array[String]): Unit = {
    println(testConstant)
    println(testVariable)
  }
}
