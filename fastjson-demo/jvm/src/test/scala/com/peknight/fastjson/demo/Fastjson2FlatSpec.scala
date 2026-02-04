package com.peknight.fastjson.demo

import com.alibaba.fastjson2.JSON
import com.peknight.fastjson.demo.{FooBar, IceCream}
import org.scalatest.flatspec.AnyFlatSpec

import java.time.{LocalDate, LocalTime}

class Fastjson2FlatSpec extends AnyFlatSpec:
  "Fastjson2" should "pass" in {
    val iceCreamJson = """{"name": "Sundae","numCherries":3,"inCone":true}"""
    val iceCream = JSON.parseObject(iceCreamJson, classOf[IceCream])
    assert(iceCream.getName == "Sundae" && iceCream.getNumCherries == 3 && iceCream.getInCone)
    val fooBarJson = """{"date": "20250410", "time": "19:00:05"}"""
    val fooBar = JSON.parseObject(fooBarJson, classOf[FooBar])
    assert(fooBar.getDate === LocalDate.of(2025, 4, 10) && fooBar.getTime === LocalTime.of(19, 0, 5))
  }
end Fastjson2FlatSpec
