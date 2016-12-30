package com.github.uryyyyyyy.scalajsddd.sample.front

import com.github.uryyyyyyy.scalajsddd.sample.domain.ToDo

import scala.scalajs.js
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

  @JSExport
  def fetch(url :String): js.Promise[ToDo] = {
    val jsDict = js.Dictionary("method" -> "GET", "mode" -> "cors", "headers" -> js.Dictionary("Content-Type" -> "application/json"))
    val result = js.Dynamic.global.fetch(url, jsDict)
      .then((response: js.Dynamic) => response.json())
      //.then((json: js.Dynamic) => json.asInstanceOf[ToDoTrait])
      .then((json: js.Dynamic) => {
      js.Dynamic.global.console.log(json)
      val todo = json.asInstanceOf[ToDoTrait]
      println(todo)
      ToDo(todo.id, todo.title, todo.finished)
    })
    result.asInstanceOf[js.Promise[ToDo]]
  }
}

@js.native
trait ToDoTrait extends js.Object {
  val id: Int = js.native
  val title: String = js.native
  val finished: Boolean = js.native
}