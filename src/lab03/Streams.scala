package lab03

object Streams {

  import u03.Streams.Stream._
  import u03.Streams._

  def drop[A](stream: Stream[A])(n: Int): Stream[A] = stream match {
    case Cons(_, ft) if n > 0 => drop(ft())(n-1)
    case Cons(fh, ft) if n <= 0 => cons(fh(), ft())
    case _ => empty()
  }

}
