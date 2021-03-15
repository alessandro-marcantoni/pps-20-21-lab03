package lab03

import u03.Lists.List._

object Lists {
  import u03.Lists._

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

}
