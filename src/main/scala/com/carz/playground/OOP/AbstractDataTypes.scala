package com.carz.playground.OOP

object AbstractDataTypes {
  // Abstract Classes
  abstract class VideoGame {
    val gameType: String
    def play(): Unit

    def runningPlatform(): String = "PS5"
  }
  // Abstract classes can not be instantiated
  // Each class that extends from abstract needs to provide implementation
  // Using anonymous class
  val testGame: VideoGame = new VideoGame {
    override val gameType: String = "New Game Type"

    override def play(): Unit = {
      println("Running Anonymous class")
    }
  }

  class Shooter extends VideoGame {
    override val gameType: String = "FPS"

    override def play(): Unit = {
      println("Running Shooter game!")
    }

    override def runningPlatform(): String = super.runningPlatform() + ", PC"
  }

  val testGame2 = new Shooter

  // Traits are similar to abstract classes
  trait ThirdPerson {
    def showPerspective(game: VideoGame): Unit
  }

  // Traits can extend other traits
  trait OpenWorld extends ThirdPerson {
    override def showPerspective(game: VideoGame): Unit = {
      println("Show perspective from Open World")
    }
  }

  trait StoryLine {
    def mainCharacter(): String
  }

  // Using abstract class and traits
  class MassEffect extends VideoGame with OpenWorld with StoryLine {
    override val gameType: String = "Open World"
    override def play(): Unit = {
      println("Playing Mass Effect")
    }
    override def mainCharacter(): String = "Commander Shepard"
  }

  val massEffect = new MassEffect

  def main(args: Array[String]): Unit = {
    println(s"testGame.gameType: ${testGame.gameType}")
    testGame.play()
    println(s"testGame.runningPlatform: ${testGame.runningPlatform()}")


    println(s"testGame2.gameType: ${testGame2.gameType}")
    testGame2.play()
    println(s"testGame2.runningPlatform: ${testGame2.runningPlatform()}")

    println(s"massEffect.gameType: ${massEffect.gameType}")
    massEffect.play()
    println(s"massEffect.mainCharacter: ${massEffect.mainCharacter()}")

  }
}
