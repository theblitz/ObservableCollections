package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableCollection
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.util.*

open class ObservableQueue<X, T: Queue<X>>(skipCurrentValueCall: Boolean = false): ObservableCollection<X, T>(skipCurrentValueCall) {

    fun remove(): X {
        val resultElement = collection!!.remove()
        if (resultElement != null)
            signalChanged(ObservableCollectionsAction.Remove, resultElement = resultElement)
        return resultElement
    }


    fun element(): X {
        return collection!!.element()
    }

    fun offer(element: X): Boolean {
        val added = collection!!.offer(element)
        if (added)
            signalChanged(ObservableCollectionsAction.Offer, actionElement = element, resultBoolean = added)
        return added
    }

    fun peek(): X {
        return collection!!.peek()
    }

    fun poll(): X {
        val resultElement = collection!!.poll()
        if (resultElement != null)
            signalChanged(ObservableCollectionsAction.Poll, resultElement = resultElement)
        return resultElement
    }
 }