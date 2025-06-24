package com.carz.playground.basis

object Functions {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def aVoidFunction(aString: String): Unit = {
    println(s"aVoidFunction: ${aString}")
  }

  def functionWithSideEffects(aString: String): String = {
    println(aString)
    aString + " " + aString // returned Value
  }

  def aBigFunction(n: Int): Int = {
    // Define a smaller local function
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    // Invoke smaller function and return
    aSmallerFunction(n, n + 1)
  }

  val anInvocation = aFunction("Scala", 999)
  val anInvocation2 = aVoidFunction("Scala")

  def main(args: Array[String]): Unit = {
    println(s"anInvocation: ${anInvocation}")
    println(s"aBigFunction(3): ${aBigFunction(3)}")
  }
}
