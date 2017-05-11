package com.stealthit.test

import scala.math.BigDecimal.RoundingMode.HALF_UP


/**
  * Created by parthaghosh on 11/05/2017.
  */
object ShoppingBasket {

  val priceList:Map[String,Double]=Map("Apple" -> 0.60,"Orange" -> 0.25 ).withDefaultValue(0.0)
  val offers = Map[String,(Int,Double) => Double]("Apple" -> byOneGetOneFree,"Orange" -> threeForPriceOfTwo).withDefaultValue(noOffer)

  def checkout(shoppingList: List[String]):Double =
    (shoppingList.groupBy(identity).mapValues(_.size) foldLeft(0.0))((sum,entry) => sum + offers(entry._1)(entry._2,priceList(entry._1)))

  private def round(doubleValue: Double,precision:Int):Double = BigDecimal(doubleValue).setScale(precision,HALF_UP).doubleValue()

  def offer(offerAmount:Int,pricedAmount:Int)(itemCount:Int,unitPrice:Double) = {
    val qualifyingAmount:Int = itemCount/offerAmount;
    val remainingAmount:Int = itemCount % offerAmount;
    round((qualifyingAmount*pricedAmount+remainingAmount) * unitPrice,2)
  }
  def byOneGetOneFree = offer(2,1)_
  def threeForPriceOfTwo = offer(3,2)_
  def noOffer = offer(1,1)_

}
