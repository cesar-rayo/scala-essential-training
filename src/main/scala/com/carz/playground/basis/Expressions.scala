package com.carz.playground.basis

object Expressions {

  val sum = 40 + 20
  val mathExpression = 2 + 3 * 4
  val equalityTest = 1 == 3

  val anIfExpression = if (equalityTest) 45 else 99
  val anIfExpression2 = if equalityTest then 45 else 99

  // Code blocks are expressions
  // Using curly braces
  val codeBlock = {
    val localValue = 78
    localValue + 99
  }
  // Using indentation
  val codeBlock2 =
    val localValue = 78
    localValue + 99

  // Switch/Pattern Matching
  val someValue = 42
  val description = someValue match {
    case 1 => "One"
    case 2 => "Two"
    case 42 => "Forty Two"
    case _ => "Did not match"
  }

  def main(args: Array[String]): Unit = {
    println(s"sum: ${sum}")
    println(s"mathExpression: ${mathExpression}")
    println(s"equalityTest: ${equalityTest}")
    println(s"anIfExpression: ${anIfExpression}")
    println(s"if expression: ${if (equalityTest) 45 else 99}")
    println(s"anIfExpression2: ${anIfExpression2}")
    println(s"codeBlock: ${codeBlock}")
    println(s"codeBlock2: ${codeBlock2}")
    println(s"description: ${someValue} -> ${description}")
  }
}
