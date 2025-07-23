package com.carz.playground.OOP

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object ForComprehension {
  def combinations[A, B](xs: List[A], ys: List[B]): List[(A, B)] = {
    for {
      x <- xs
      y <- ys
    } yield (x, y)
  }

  val future1: Future[Int] = Future {
    println("Future 1 start")
    Thread.sleep(1000);
    println("Future 1 done")
    42
  }
  val future2: Future[Int] = Future {
    println("Future 2 start")
    Thread.sleep(2000);
    println("Future 2 done")
    58
  }

  val combined: Future[Int] = for {
    value1 <- future1 // This will wait for `future1` to complete
    value2 <- future2 // Then wait for `future2` to complete
  } yield {
    value1 + value2
  }

  val numbers = List(1,2,3,4,5)
  val numbers_p = numbers.map(n => n * n)
  val numbers_d = numbers.flatMap(n => List(n, n, n))

  case class Destination(city: String, journeyTime: Int)
  val destinations = List(
    Destination("London", 30),
    Destination("Oxford", 120),
    Destination("Edinburgh", 420),
  )

  def nearbyTrips(destinations: List[Destination], tripTime: Int = 60): List[String] = {
    for {
      destination <- destinations
      if destination.journeyTime <= tripTime
    } yield destination.city
  }

  def main(args: Array[String]): Unit = {
    println(combinations(List(1,2), List("A","B","C")))
    Await.result(combined, Duration.Inf)
    println(s"result: $combined")
    println(nearbyTrips(destinations, 120))
  }
}
