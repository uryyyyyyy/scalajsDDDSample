package com.github.uryyyyyyy.scalajsddd.sample.front

import scala.scalajs.js.annotation.JSExport

@JSExport("ExportToJS")
object ExportToJS {

  @JSExport
  def main(): Unit = {
    println("helloWorld")
  }

  @JSExport
  def func1(): String = {
    "helloWorld"
  }

  @JSExport
  def func2(str :String): Unit = {
    println(str)
  }

  @JSExport
  def func3(str :String): String = {
    str + str
  }
}