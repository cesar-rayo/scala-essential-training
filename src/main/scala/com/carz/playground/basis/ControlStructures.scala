package com.carz.playground.basis

object ControlStructures {
  // println returns Unit similar to Void
  val printing: Unit = println("Something happened") // Executing the println while evaluating it's a side effect
  val theUnit: Unit = ()

  val aCodeBlock = {
    val aLocalValue = 45
    println("Instruction 1")
    println("Instruction 2")
  }

  var aVariable = 10
  val reassignment: Unit = aVariable += 1

  def main(args: Array[String]): Unit = {
    println(s"printing: ${printing}")
    println(s"printing == theUnit : ${printing == theUnit}")

    var theNumber = 1
    while (theNumber <= 3) {
      println(s"theNumber: ${theNumber}")
      theNumber += 1
    }
  }
}
