package com.carz.playground.OOP
import com.carz.playground.OOP.EnumExamples.TrafficLight.*
import com.carz.playground.OOP.EnumExamples.Triathlon.*
import com.carz.playground.OOP.EnumExamples.UnitedKingdom.*

object EnumExamples {

  enum TrafficLight:
    case Red, Amber, Green

  def drivingSignal(trafficLight: TrafficLight): String = {
    trafficLight match {
      case Red => "Stop!"
      case Amber => "Get ready!"
      case Green => "Go!"
    }
  }

  enum Triathlon(val metters: Int) {
    case Swim extends Triathlon(400)
    case Cycle extends Triathlon(5000)
    case Run extends Triathlon(2500)
  }

  def howManyMeters(tri: Triathlon): String = {
    tri match {
      case swim @ Swim => s"Swim - ${swim.metters}mts"
      case cycle @ Cycle => s"Cycle - ${cycle.metters}mts"
      case run @ Run => s"Run - ${run.metters}mts"
    }
  }

  case class Country(name: String, population: Int)
  def population(country: Country): Int = country.population

  enum UnitedKingdom:
    case England, NorthernIreland, Scotland, Wales

  def detectScotland(unitedKingdom: UnitedKingdom): String = {
    if unitedKingdom == Scotland then "it's Scotland"
    else "Somewhere else"
  }

  def detectCountry(unitedKingdom: UnitedKingdom): String = {
    unitedKingdom match {
      case England => "It's England"
      case NorthernIreland => "It's NorthernIreland"
      case Scotland => "It's Scotland"
      case Wales => "It's Wales"
    }
  }


  def main(args: Array[String]): Unit = {
    println(drivingSignal(TrafficLight.Amber))
    println(s"howManyMeters(Cycle): ${howManyMeters(Cycle)}")
    println(detectScotland(England))
    println(detectCountry(Wales))
  }

}
