package com.carz.playground.OOP

object Objects {
  // singleton pattern
  // there is only one possible instance of this type
  object MySingleton {
    val aField = "Something"
    def aMethod(x: Int): Int = {
      x + 1
    }
  }
  val theSingleton = MySingleton
  val anotherSingleton = MySingleton

  // Companions: combination of class + object
  class Person(name: String) {
    def sayHi(): String = {
      s"Hi, my name is $name"
    }
    def getNEyes(): Int = Person.N_EYES
  }
  // If it has the same name, they are companions (complement each other)
  // Used to define static fields and methods
  object Person {
    val N_EYES = 2
    def canFly(): Boolean = false
  }

  val person1 = new Person("Daniel")

  object BigFoot extends Person("Big Foot")
  val bigFoot = BigFoot

  def main(args: Array[String]): Unit = {
    println(s"theSingleton == anotherSingleton?: ${theSingleton == anotherSingleton}")
    println(s"theSingleton.aField: ${theSingleton.aField}")
    println(s"theSingleton.aMethod(10): ${theSingleton.aMethod(10)}")
    println(s"person1.sayHi: ${person1.sayHi()}")
    println(s"person1.getNEyes: ${person1.getNEyes()}")
    println(s"Person.canFly: ${Person.canFly()}")
    println(s"Person.N_EYES: ${Person.N_EYES}")
    println(s"bigFoot.sayHi: ${bigFoot.sayHi()}")
  }
}
