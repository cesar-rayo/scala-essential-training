package com.carz.playground.OOP

object MethodNotation {
  class Person(val name: String) {
    def greet(another: Person): String = {
      s"$name says: Hi, ${another.name}, how are you?"
    }
    // infix keyword is not required, it's just for information
    infix def likes(movie: String): String = {
      s"$name says: I like the movie $movie!!"
    }
    // Alphanumeric values are valid method names, very popular in other frameworks/libs
    infix def ?!(another: Person): String = {
      s"$name says: I'm mad at you ${another.name}!!"
    }
    // apply is a special method
    def apply(progLang: String): Unit = {
      println(s"[$name] is programing in $progLang")
    }
    // overload apply method
    def apply(progLang: String, algorithm: String): Unit = {
      println(s"[$name] is programing in $progLang, using $algorithm algorithm")
    }
  }

  val alice = new Person("Alice")
  // new keyword is no longer needed with latest Scala releases
  val bob = Person("Bob")

  def main(args: Array[String]): Unit = {
    println(alice.greet(bob))
    // if method receives only 1 argument we can do
    // infix notation: instance method argument
    println(alice greet bob)
    println(alice likes "Movie name")
    println(alice ?! bob)

    alice.apply("Scala")
    alice("Scala") // Same as alice.apply("Scala")
    alice("Scala", "Dynamic Programming")
  }

}
