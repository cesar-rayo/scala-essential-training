package com.carz.playground.OOP

object OOBasics {

  class Person(val name: String, age: Int) {
    val allCaps = name.toUpperCase()

    def greet(someone: Person): String = {
      s"Hello ${someone.allCaps}!"
    }

    // Overloading greet method
    def greet(): String = {
      s"Hello Everyone, I'm ${allCaps}!"
    }
  }

  val person1 = new Person("Person One", 18)
  val person2 = new Person("Person Two", 22)

  class Driver(firstName: String, lastName: String,val birthYear: Int){
    def getFullName(): String = {
      s"$firstName $lastName"
    }
  }

  class Car(make: String, model: String, year: Int, owner: Driver) {
    def ownerAge(): Int = {
      year - owner.birthYear
    }
    def isOwnedBy(driver: Driver): Boolean = {
      driver == owner
    }
    def copy(newReleaseYear: Int): Car = {
      new Car(make, model, newReleaseYear, owner)
    }

    override def toString: String = {
      s"Make: $make, Model: $model, Year: $year, Owner: ${owner.getFullName()}"
    }
  }

  val driver1 = new Driver("First Name", "Last Name", 1989)
  val driver2 = new Driver("First Name", "Last Name", 1988)
  val car1 = new Car("Hyundai", "Eon", 2015, driver1)
  val copyCar1 = car1.copy(2016)

  def main(args: Array[String]): Unit = {
    println(person1.allCaps)
    println(person1.greet(person2))
    println(person1.greet())
    println(s"Person1 name: ${person1.name}")
    // Can not access age since we are missing val/var keyword in class constructor
    // println(person1.age)
    println("===============================================")
    println(s"car1.isOwnedBy(driver1): ${car1.isOwnedBy(driver1)}")
    println(s"car1.isOwnedBy(driver2): ${car1.isOwnedBy(driver2)}")
    println(s"car1.ownerAge(): ${car1.ownerAge()}")
    println(s"car1: {${car1.toString}}")
    println(s"copyCar1: {${copyCar1.toString}}")
  }
}
