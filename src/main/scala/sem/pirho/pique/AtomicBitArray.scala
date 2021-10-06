package sem.pirho.pique

import java.util.concurrent.atomic.AtomicIntegerArray
import java.util.function.IntUnaryOperator

object AtomicBitArray {
  private val allOne  = -1
  private val toggle = createToggles
  private val setTrue = createSetTrues
  private val setFalse = createSetFalses


  def apply(capacity:Int) = new AtomicBitArray(capacity)

  private def createToggles: Array[IntUnaryOperator] =
    (0 until 32).foldLeft (new Array[IntUnaryOperator](32)) {
      case (acc, i) =>
        val mask = 1 << i
        acc(i) = new IntUnaryOperator { override def applyAsInt(x: Int): Int = x ^ mask }
        acc
    }

  private def createSetFalses: Array[IntUnaryOperator] =
    (0 until 32).foldLeft (new Array[IntUnaryOperator](32)) {
      case (acc, i) =>
        val mask = allOne ^ (i << i)
        acc(i) = new IntUnaryOperator { override def applyAsInt(x: Int): Int = x & mask }
        acc
    }

  private def createSetTrues: Array[IntUnaryOperator] =
    (0 until 32).foldLeft (new Array[IntUnaryOperator](32)) {
      case (acc, i) =>
        val mask = (i << i)
        acc(i) = new IntUnaryOperator { override def applyAsInt(x: Int): Int = x | mask }
        acc
    }

}

class AtomicBitArray private (capacity:Int) {
  private val store = new AtomicIntegerArray(capacity >> 5) //divide capacity by 32

  def toggle(idx:Int) = {
    store

  }

      store.getAndUpdate()
  }

}
