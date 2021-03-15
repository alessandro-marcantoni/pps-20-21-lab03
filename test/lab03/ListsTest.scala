package lab03

import lab03.Lists._
import u03.Lists.List.{Cons, Nil}
import u02.Optionals.Option.{None, Some}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.Modules.Person
import u02.Modules.Person.{Student, Teacher}

class ListsTest {

  val lst: Cons[Int] = Cons(10, Cons(20, Cons(30, Nil())))

  @Test
  def dropTest(): Unit = {
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst, 1))
    assertEquals(Cons(30, Nil()), drop(lst, 2))
    assertEquals(Nil(), drop(lst, 5))
  }

  @Test
  def flatMapTest(): Unit = {
    assertEquals(
      Cons(11,Cons(21,Cons(31,Nil()))),
      flatMap(lst)(v => Cons(v+1, Nil()))
    )
    assertEquals(
      Cons(11,Cons(12,Cons(21,Cons(22,Cons(31,Cons(32,Nil())))))),
      flatMap(lst)(v => Cons(v+1, Cons(v+2, Nil())))
    )
  }

  @Test
  def mapTest(): Unit = {
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map(lst)(_+1))
    assertEquals(Cons(5, Cons(10, Cons(15, Nil()))), map(lst)(_/2))
  }

  @Test
  def filterTest(): Unit = {
    assertEquals(Nil(), filter(lst)(_%10 != 0))
    assertEquals(Cons(10, Cons(20, Nil())), filter(lst)(_<25))
  }

  @Test
  def maxTest(): Unit = {
    assertEquals(Some(25), max(Cons(10, Cons(25, Cons(20, Nil())))))
    assertEquals(None(), max(Nil()))
  }

  @Test
  def listWithPeopleTest(): Unit = {
    val people:Cons[Person] = Cons(Teacher("Viroli", "PPS"),
        Cons(Teacher("Ricci", "PCD"),
        Cons(Teacher("Mirri", "ASW"),
        Cons(Student("Alessandro", 2020),
        Cons(Student("Simone", 2020), Nil())))))
    assertEquals(
      Cons("PPS", Cons("PCD", Cons("ASW", Nil()))),
      getTeacherCourses(people)
    )
  }

}
