package com.stealthit.test

import org.scalatest.FunSuite
import com.stealthit.test.ShoppingBasket._
/**
  * Created by parthaghosh on 11/05/2017.
  */

class ShoppingBasketTest extends FunSuite {

  test("Empty shopping basket gives checkout value as 0"){
    assert(checkout(List()) == 0.0)
  }

  test("List of Apples and Oranges in any order gives the total checkout value."){
    assert(checkout(List("Apple","Orange","Orange","Apple")) == 1.10)
  }

  test("List of Apples, Oranges and any other items in any order only gives the total checkout value for Apples and Oranges."){
    assert(checkout(List("Apple","Orange","Orange","Blah","Apple")) == 1.10)
  }

  test("List of even number of Apples and Oranges in multiples of three in any order gives the total checkout value."){
    assert(checkout(List("Apple","Orange","Orange","Apple","Orange")) == 1.10)
  }

  test("List of Apples and Oranges in any order gives offer value if amounts qualify for order."){
    assert(checkout(List("Apple","Orange","Orange","Apple","Orange","Apple","Orange")) == 1.95)
  }

}
