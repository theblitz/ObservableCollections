package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableCollection
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.util.*

open class ObservableQueue<X, T: Queue<X>>: ObservableCollection<X, T>() {

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