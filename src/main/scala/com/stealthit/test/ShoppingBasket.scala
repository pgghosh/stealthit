package com.stealthit.test

import scala.math.BigDecimal.RoundingMode.HALF_UP


/**
  * Created by parthaghosh on 11/05/2017.
  */
object ShoppingBasket {

  val priceList:Map[String,Double]=Map("Apple" -> 0.60,"Orange" -> 0.25 ).withDefaultValue(0.0)

  def checkout(shoppingList: List[String]):Double =
    round((shoppingList foldLeft(0.0))((sum,item) => (sum+priceList(item))),2)

  private def round(doubleValue: Double,precision:Int):Double = BigDecimal(doubleValue).setScale(precision,HALF_UP).doubleValue()

}
