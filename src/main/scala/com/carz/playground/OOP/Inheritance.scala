package com.carz.playground.OOP

object Inheritance {

  class VideoGame {
    val gameType = "interactive"
    def play(): Unit = {
      println("Game Running!")
    }
  }

  // Single class inheritance
  class Shooter extends VideoGame {
    def multiplayer(): Unit = {
      play()
      println("Something else")
    }
  }

  val crysis = new Shooter

  // Inherit constructor
  class Person(val name: String, age: Int)

  class Adult extends Person("Daniel", 25)
  val daniel = new Adult

  class Adult2(name: String, age: Int) extends Person(name, age)
  val john = new Adult2("John Doe", 52)

  // Overriding
  class RPG extends VideoGame {
    override val gameType: String = "role-playing"
    override def play(): Unit = {
      println("Level up!")
    }
  }

  val wow = new RPG

  // Subtype polymorphism
  // Declare a parent type and provide an instance of a derived type
  val wow2: VideoGame = new RPG

  // Anonymous Classes
  // Override on the spot
  val psychonauts = new VideoGame {
    override val gameType: String = "platformer"
    override def play(): Unit = {
      println("Another method here!")
    }
  }

  def main(args: Array[String]): Unit = {
    println(crysis.gameType)
    crysis.multiplayer()

    println(daniel.name)
    println(john.name)

    println(s"wow.gameType: ${wow.gameType}")
    wow.play()

    println(s"wow2.gameType: ${wow2.gameType}")
    wow2.play()

    println(s"psychonauts.gameType: ${psychonauts.gameType}")
    psychonauts.play()
  }
}
