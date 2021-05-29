package com.vinctus

package object mappable {

  def map2cc[T: Mappable](map: Map[String, Any]): T = implicitly[Mappable[T]].fromMap(map)

}