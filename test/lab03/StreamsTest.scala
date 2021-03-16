package lab03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream

class StreamsTest {

  @Test
  def takeTest(): Unit = {
    val s = Stream.take(Stream.iterate(0)(_+1))(10)
    assertEquals(
      Cons(6,Cons(7,Cons(8,Cons(9,Nil())))),
      Stream.toList(Streams.drop(s)(6)))
  }

  @Test
  def constantTest(): Unit = {
    assertEquals(
      Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil()))))),
      Stream.toList(Stream.take(Streams.constant("x"))(5)))
  }

  @Test
  def fibonacciTest(): Unit = {
    val fibs: Stream[Int] = Streams.fibonacci()
    assertEquals(
      Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil())))))))),
      Stream.toList(Stream.take(fibs)(8)))
  }

}
