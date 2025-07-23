package com.carz.playground.OOP

object PartyAtHome {
  def partyAtHome(guests: Int): Boolean = if guests < 15 then true else false
  def greeting(name: String): String = {
    name match {
      case "Ada" | "Deji" => s"Hey! $name"
      case newName => s"New name here [$newName]"
    }
  }

  case class Person(name: String, age: Int)
  class Person2(val name: String, age: Int)

  def main(args: Array[String]): Unit = {
    println(partyAtHome(16))
    println(partyAtHome(14))
    println(greeting("Ada"))
    println(greeting("Something else"))
  }
}
