package sem.pirho.pique

import java.util.concurrent.atomic.AtomicIntegerArray
import java.util.function.{IntUnaryOperator, UnaryOperator}

case class PiQue[T](capacity:Int = 1024) {
  private var head: Segment[T]   = new Segment[T]()
  head.mkNext()
  private var insert: Segment[T] = head


  private class Segment[T] {
    var next:Segment[T] = _
    val elems = Array[T](capacity)
    val witten = Array[Boolean]
    def mkNext(): Unit = { next = new Segment[T]() }




  }
  private object Flags {

  }

  private class Flags {

  }

}
