package lab03

import u02.Modules.Person
import u02.Modules.Person.Teacher
import u02.Optionals.Option.getOrElse
import u03.Lists.List._

import scala.annotation.tailrec

object Lists {
  import u02.Optionals.Option.{Some,None}
  import u02.Optionals._
  import u03.Lists._

  @tailrec
  def drop[A](list: List[A], n: Int): List[A] = list match {
    case Cons(_, t) if n > 0 => drop(t, n-1)
    case Cons(h, t) if n <= 0 => Cons(h, t)
    case _ => Nil()
  }

  def flatMap[A,B](list: List[A])(mapper: A => List[B]): List[B] = list match {
    case Cons(h, t) => append(mapper(h), flatMap(t)(mapper))
    case _ => Nil()
  }

  def map[A, B](list: List[A])(mapper: A => B): List[B] = flatMap(list)(a => Cons(mapper(a), Nil()))

  def filter[A](list: List[A])(predicate: A => Boolean): List[A] = flatMap(list) {
    case a if predicate(a) => Cons(a, Nil())
    case _ => Nil()
  }

  def max(list: List[Int]): Option[Int] = list match {
    case Cons(h, t) => Some(Math.max(h, getOrElse(max(t), Int.MinValue)))
    case _ => None()
  }

  def getTeacherCourses(list: List[Person]): List[String] = flatMap(list){
    case Teacher(_, course) => Cons(course, Nil())
    case _ => Nil()
  }

}
