package il.co.anykey.apps.mutablelivedatacollections.abstracts

import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.util.concurrent.BlockingDeque
import java.util.concurrent.TimeUnit

abstract class ObservableBlockingDeque<X, Y: BlockingDeque<X>>: ObservableDeque<X, Y>() {
    fun offer(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offer(element, p1, p2)
        if (changed)
           signalChanged(action = MLDAction.Offer, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun offerLast(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offerLast(element, p1, p2)
        if (changed)
            signalChanged(action = MLDAction.OfferLast, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun offerFirst(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offerFirst(element, p1, p2)
        if (changed)
            signalChanged(action = MLDAction.OfferFirst, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun pollFirst(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.pollFirst(p0, p1)
        if (element != null)
            signalChanged(action = MLDAction.PollFirst, actionElement = element)
        return element
    }

    fun pollLast(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.pollLast(p0, p1)
        if (element != null)
            signalChanged(action = MLDAction.PollLast, actionElement = element)
        return element
    }

    fun poll(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.poll(p0, p1)
        if (element != null)
            signalChanged(action = MLDAction.Poll, actionElement = element)
        return element
    }

    fun putFirst(element: X) {
        collection!!.putFirst(element)
        signalChanged(MLDAction.PutFirst, actionElement = element)
    }

    fun takeLast(): X {
        val element = collection!!.takeLast()
        signalChanged(action = MLDAction.TakeLast, actionElement = element)
        return element
    }

    fun takeFirst(): X {
        val element = collection!!.takeFirst()
        signalChanged(action = MLDAction.TakeFirst, actionElement = element)
        return element
    }

    fun drainTo(element: MutableCollection<in X>?): Int {
        val count = collection!!.drainTo(element)
        if (count > 0)
            signalChanged(action = MLDAction.DrainTo, resultInt = count)
        return count
    }

    fun drainTo(element: MutableCollection<in X>?, p1: Int): Int {
        val count = collection!!.drainTo(element, p1)
        if (count > 0)
            signalChanged(action = MLDAction.DrainTo, resultInt = count)
        return count
    }

    fun take(): X {
        val element = collection!!.take()
        signalChanged(action = MLDAction.Take, resultElement = element)
        return element
    }

    fun putLast(element: X) {
        collection!!.putLast(element)
        signalChanged(action = MLDAction.PutLast, actionElement = element)
    }

    fun put(element: X) {
        collection!!.put(element)
        signalChanged(action = MLDAction.PutFirst, actionElement = element)
    }

    fun remainingCapacity(): Int {
        return collection!!.remainingCapacity()
    }

}