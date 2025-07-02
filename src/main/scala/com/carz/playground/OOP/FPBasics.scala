package com.carz.playground.OOP

object FPBasics {
  case class Person(name: String, favMovie: String) {
    def apply(n: Int): String = {
      s"$name watched $favMovie $n times"
    }
  }

  val daniel = Person("Daniel", "Interstellar")
  val danielStatement = daniel.apply(4)
  val danielStatement2 = daniel(4)

  // create function types
  trait SimpleMathFunction {
    def apply(n: Int): Int
  }

  val doubler: SimpleMathFunction = new SimpleMathFunction {
    override def apply(n: Int): Int = n * 2
  }

  val six = doubler(3) //doubler.apply(3)

  // Using a more general approach with generic types
  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doubler_v2 = new MyFunction[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }

  val six_v2 = doubler_v2(3)

  // In FP the functions are first class elements of the language
  // we can pass functions as arguments or return them as results
  // Int => Int can be expressed as apply(Int): Int
  // (String, Int) => String can be expressed as apply(String, Int): String

  trait MyStringIntFunction {
    def apply(s: String, i: Int): String
  }

  val myCombinator = new MyStringIntFunction {
    override def apply(s: String, i: Int): String = s"$s, ($i)"
  }

  // Using Function traits from Scala; Function1 takes 1 argument
  val doubler_v3 = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }

  // Function2[input1, input2, output]
  val myCombinator_v2 = new Function2[String, Int, String] {
    override def apply(s: String, i: Int): String = s"$s, ($i)"
  }
  val myCombinator_v3 = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = s"$a => ($b)"
  }
  val mySuperFunction = new Function4[Int, String, Double, Boolean, Int] {
    override def apply(v1: Int, v2: String, v3: Double, v4: Boolean): Int = v1 * 10
  }

  def main(args: Array[String]): Unit = {
    println(s"danielStatement: $danielStatement")
    println(s"danielStatement2: $danielStatement2")
    println(s"six: $six")
    println(s"six_v2: $six_v2")
    // myCombinator acts as a function here
    println(s"myCombinator(\"word\", 45): ${myCombinator("word", 45)}")

    println(s"doubler_v3(4): ${doubler_v3(4)}")
    println(s"myCombinator_v2(\"word\", 4): ${myCombinator_v2("word", 4)}")
    println(s"myCombinator_v3(\"word1\", \"word2\"): ${myCombinator_v3("word1", "word2")}")
    println(s"mySuperFunction: ${mySuperFunction(5, "word", 3.15, true)}")
  }
}
