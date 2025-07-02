package com.carz.playground.OOP

object AnonymousFunctions {
  // apply method and FunctionN
  val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(n: Int): Int = n * 2
  }

  // Function types
  // Int => Int same as Function1[Int, Int]
  // (n: Int) => n * 2 same as all the new Function1 declaration
  val doubler_v2: Int => Int = (n: Int) => n * 2 // lambda equivalent

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // Zero argument function Function0[A] type
  val justDoSomething: Function0[String] = new Function0[String] {
    override def apply(): String = "Do something"
  }
  val justDoSomething_v2: () => String = () => "Do something"

  // alt syntax using curly braces
  val stringToInt = { (string: String) =>
    val stringLength = string.length
    stringLength + 45
  }

  // Using Type inference
  val doubler_v3: Int => Int = n => n * 2
  val adder_v2: (Int, Int) => Int = (a, b) => a + b

  // Shortest notation
  val doubler_v4: Int => Int = _ * 2
  val adder_v3: (Int, Int) => Int = _ + _

  def main(args: Array[String]): Unit = {
    println(doubler(5))
    println(doubler_v2(4))
    println(s"doubler_v4(4): ${doubler_v4(4)}")
    println(s"adder(4,3): ${adder(4,3)}")
    println(s"adder_v3(4,3): ${adder_v3(4,3)}")
    println(s"justDoSomething: ${justDoSomething()}")
    println(s"justDoSomething_v2: ${justDoSomething_v2()}")
    println(s"stringToInt(\"Scala\"): ${stringToInt("Scala")}")
  }
}
