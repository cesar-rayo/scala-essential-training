package com.carz.playground.OOP

object CaseClasses {
  // Lightweight data structures
  // class arguments are treated as fields automatically
  // toString, equals, hasCode already implemented
  // copy already implemented
  // companion object already created with apply method
  // can be serializable (akka/pekko)
  case class Pet(name: String, age: Int) {

  }

  // No need to use new keyword
  val dino = Pet("Dino", 2)

  val dino2 = dino.copy("Another")
  val dino3 = Pet.apply("Sample", 8) // Pet("Sample", 8)

  // Normal class
  class PetSimple(name: String, age: Int)
  val dinoSimple = new PetSimple("Dino", 2)

  case object UnitedKingdom {
    def name: String = "Some name here"
  }

  // define hierarchies of data structures
  trait Message
  case class InitialInteraction(message: String) extends Message
  case class Text(message: String) extends Message
  // Create an object that marks the end of the conversation
  case object EndConversation extends Message

  // Let's imagine this is an external method
  def getMessage(): Message = InitialInteraction("hello")
  val message: Message = getMessage()

  def processConversation(message: Message): String ={
    message match {
      case InitialInteraction(someContent) => s"I have received [$someContent]"
      case EndConversation => "Conversation has finished"
      case _ => "Conversation still going on"
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"dino.name: ${dino.name}")
    println(s"dino.toString: ${dino.toString}")
    println(s"dinoSimple.toString: ${dinoSimple.toString}")
    println(s"dino2.toString: ${dino2.toString}")
    println(s"processConversation: ${processConversation(InitialInteraction("Hello"))}")
    println(s"processConversation: ${processConversation(Text("Something"))}")
    println(s"processConversation: ${processConversation(EndConversation)}")
  }
}
