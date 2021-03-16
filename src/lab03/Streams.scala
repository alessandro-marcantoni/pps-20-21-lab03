package lab03

import scala.annotation.tailrec

object Streams {

  import u03.Streams.Stream._
  import u03.Streams._

  @tailrec
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
    case (stream, 0) => stream
    case (Cons(_, ft), n) => drop(ft())(n-1)
    case (Empty(), _) => empty()
  }

  def constant[A](k: A): Stream[A] = cons(k, constant(k))

  def fibonacci(): Stream[Int] = {
    def _fib(prev: Int, curr: Int): Stream[Int] = cons(prev, _fib(curr, prev+curr))
    _fib(0, 1)
  }

}
