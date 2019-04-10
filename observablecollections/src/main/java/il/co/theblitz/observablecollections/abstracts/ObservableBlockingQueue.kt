package il.co.anykey.apps.mutablelivedatacollections.abstracts

import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit

abstract class ObservableBlockingQueue<X>: ObservableQueue<X, BlockingQueue<X>>() {

    fun offer(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offer(element, p1, p2)
        if (changed)
           signalChanged(action = MLDAction.Offer, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun poll(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.poll(p0, p1)
        if (element != null)
            signalChanged(action = MLDAction.Poll, actionElement = element)
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

    fun put(element: X) {
        collection!!.put(element)
        signalChanged(action = MLDAction.PutFirst, actionElement = element)
    }

    fun remainingCapacity(): Int {
        return collection!!.remainingCapacity()
    }

}