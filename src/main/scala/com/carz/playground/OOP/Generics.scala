package com.carz.playground.OOP

object Generics {

  // [1,2,3,4,5]
  // first 1
  // rest [2,3,4,5]
  abstract class IntList {
    def first: Int
    def rest: IntList
  }

  class EmptyIntList extends IntList {
    override def first: Int = throw new NoSuchElementException
    override def rest: IntList = throw new NoSuchElementException
  }

  case class NonEmptyIntList(a: Int, r: IntList) extends IntList {
    def first: Int = a
    def rest: IntList = r
  }

  // Reuse this logic on Strings
  // 1- copy everything but with Strings
  // 2- remove the type safety using Any - defeats purpose
  // 3- Use type parameters or generics to make sure all objects are the same class

  abstract class MyList[A] {
    def first: A
    def rest: MyList[A]
    def isEmpty: Boolean
  }

  class EmptyList[A] extends MyList[A] {
    def first: A = throw new NoSuchElementException
    def rest: MyList[A] = throw new NoSuchElementException
    def isEmpty: Boolean = true
  }

  case class NonEmptyList[A](a: A, r: MyList[A]) extends MyList[A] {
    def first: A = a
    def rest: MyList[A] = r
    def isEmpty: Boolean = false
  }

  // Can add type arguments/generics to traits, abstract classes, case classes or normal classes
  // Can't use generics in objects

  trait MyMap[K, V]
  def second[A](list: MyList[A]): A = {
    if (list.isEmpty) throw new NoSuchElementException
    else if (list.rest.isEmpty) throw new NoSuchElementException
    else list.rest.first
  }

  def main(args: Array[String]): Unit = {
    val numbers = NonEmptyIntList(1, NonEmptyIntList(2, NonEmptyIntList(3, new EmptyIntList)))
    println(numbers)
    println(s"numbers.first + 1: ${numbers.first + 1}")

    val numbers2 = NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, new EmptyList)))
    println(s"numbers2.first + 1: ${numbers2.first + 1}")

    val strings = NonEmptyList("One", NonEmptyList("Two", NonEmptyList("Three", new EmptyList)))
    println(s"strings.first + 1: ${strings.first + 1}")

    println(s"second(numbers2): ${second(numbers2)}")
    println(s"second(strings): ${second(strings)}")
  }
}
