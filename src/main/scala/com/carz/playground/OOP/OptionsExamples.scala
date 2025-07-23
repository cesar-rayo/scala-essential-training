package com.carz.playground.OOP

object OptionsExamples {
  val middleName: Option[String] = None
  val middleName2: Option[String] = Some("Middlename")

  case class Rating(googleRating: Option[Int], netflixRating: Option[Int])
  case class Film(name: String, rating: Option[Rating])

  val mulan = Film("Mulan", Some(Rating(Some(5), Some(10))))
  val peter_pan = Film("Peter Pan", Some(Rating(Some(2), Some(10))))
  val snow_white = Film("Snow White", Some(Rating(Some(5), None)))
  val cinderella = Film("Cinderella", None)

//  Returns Option[Int] since it could be the case that we get None values
//  None of the values could be empty or null
  def forComprehension(film: Film): Option[Int] = {
    for{
      rating <- film.rating
      googleRating <- rating.googleRating
      netflixRating <- rating.netflixRating
      if googleRating > 3 // Filter which stops the execution
      averageRating = (googleRating + netflixRating)/2
    } yield averageRating
  }

  case class TicketPrice(standardTicketPrice: Int, firstClassTicketPrice: Option[Int])
  def getFirstClassTicketPrice1(ticketPrice: Option[TicketPrice]): Option[Int] = {
    ticketPrice.flatMap(_.firstClassTicketPrice)
  }

  def getFirstClassTicketPrice2(ticketPrice: Option[TicketPrice]): Option[Int] = {
    for{
      t <- ticketPrice
      firstClassPrice <- t.firstClassTicketPrice
    } yield firstClassPrice
  }

  val ticket1 = TicketPrice(45, Some(54))
  val ticket2 = TicketPrice(58, None)

  def main(args: Array[String]): Unit = {
    println(s"middleName.getOrElse(\"\").length: ${middleName.getOrElse("").length}")
    println(s"middleName2.getOrElse(\"\").length: ${middleName2.getOrElse("").length}")
    println(middleName2.map(word => word.toUpperCase))
    println(s"${mulan.name} ${mulan.rating}")
    println(s"${mulan.rating.map(rating => rating.googleRating).flatten}")
    println(s"${mulan.rating.flatMap(rating => rating.googleRating)}")
    println(s"forComprehension(mulan): ${forComprehension(mulan)}")
    println(s"forComprehension(peter_pan): ${forComprehension(peter_pan)}")
    println(s"forComprehension(snow_white): ${forComprehension(snow_white)}")
    println(s"forComprehension(cinderella): ${forComprehension(cinderella)}")
    println(getFirstClassTicketPrice1(Some(ticket1)))
    println(getFirstClassTicketPrice1(Some(ticket2)))
    println(getFirstClassTicketPrice2(Some(ticket1)))
    println(getFirstClassTicketPrice2(Some(ticket2)))
  }
}
