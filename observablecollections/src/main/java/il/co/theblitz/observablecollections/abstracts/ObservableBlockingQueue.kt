package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import il.co.theblitz.observablecollections.full.ObservableQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit

abstract class ObservableBlockingQueue<X>: ObservableQueue<X, BlockingQueue<X>>() {

    fun offer(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offer(element, p1, p2)
        if (changed)
           signalChanged(action = ObservableCollectionsAction.Offer, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun poll(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.poll(p0, p1)
        if (element != null)
            signalChanged(action = ObservableCollectionsAction.Poll, actionElement = element)
        return element
    }

    fun drainTo(element: MutableCollection<in X>?): Int {
        val count = collection!!.drainTo(element)
        if (count > 0)
            signalChanged(action = ObservableCollectionsAction.DrainTo, resultInt = count)
        return count
    }

    fun drainTo(element: MutableCollection<in X>?, p1: Int): Int {
        val count = collection!!.drainTo(element, p1)
        if (count > 0)
            signalChanged(action = ObservableCollectionsAction.DrainTo, resultInt = count)
        return count
    }

    fun take(): X {
        val element = collection!!.take()
        signalChanged(action = ObservableCollectionsAction.Take, resultElement = element)
        return element
    }

    fun put(element: X) {
        collection!!.put(element)
        signalChanged(action = ObservableCollectionsAction.PutFirst, actionElement = element)
    }

    fun remainingCapacity(): Int {
        return collection!!.remainingCapacity()
    }

}