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

}
