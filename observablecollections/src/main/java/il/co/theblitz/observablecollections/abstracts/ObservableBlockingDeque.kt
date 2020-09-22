package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.util.concurrent.BlockingDeque
import java.util.concurrent.TimeUnit

abstract class ObservableBlockingDeque<X, Y: BlockingDeque<X>>(skipCurrentValueCall: Boolean = false): ObservableDeque<X, Y>(skipCurrentValueCall) {
    fun offer(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offer(element, p1, p2)
        if (changed)
           signalChanged(action = ObservableCollectionsAction.Offer, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun offerLast(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offerLast(element, p1, p2)
        if (changed)
            signalChanged(action = ObservableCollectionsAction.OfferLast, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun offerFirst(element: X, p1: Long, p2: TimeUnit?): Boolean {
        val changed = collection!!.offerFirst(element, p1, p2)
        if (changed)
            signalChanged(action = ObservableCollectionsAction.OfferFirst, actionElement = element, resultBoolean = changed)
        return changed
    }

    fun pollFirst(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.pollFirst(p0, p1)
        if (element != null)
            signalChanged(action = ObservableCollectionsAction.PollFirst, actionElement = element)
        return element
    }

    fun pollLast(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.pollLast(p0, p1)
        if (element != null)
            signalChanged(action = ObservableCollectionsAction.PollLast, actionElement = element)
        return element
    }

    fun poll(p0: Long, p1: TimeUnit?): X {
        val element = collection!!.poll(p0, p1)
        if (element != null)
            signalChanged(action = ObservableCollectionsAction.Poll, actionElement = element)
        return element
    }

    fun putFirst(element: X) {
        collection!!.putFirst(element)
        signalChanged(ObservableCollectionsAction.PutFirst, actionElement = element)
    }

    fun takeLast(): X {
        val element = collection!!.takeLast()
        signalChanged(action = ObservableCollectionsAction.TakeLast, actionElement = element)
        return element
    }

    fun takeFirst(): X {
        val element = collection!!.takeFirst()
        signalChanged(action = ObservableCollectionsAction.TakeFirst, actionElement = element)
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

    fun putLast(element: X) {
        collection!!.putLast(element)
        signalChanged(action = ObservableCollectionsAction.PutLast, actionElement = element)
    }

    fun put(element: X) {
        collection!!.put(element)
        signalChanged(action = ObservableCollectionsAction.PutFirst, actionElement = element)
    }

    fun remainingCapacity(): Int {
        return collection!!.remainingCapacity()
    }

}