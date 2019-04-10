package il.co.anykey.apps.mutablelivedatacollections.abstracts

import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.util.*

abstract class ObservableQueue<X, T: Queue<X>>: ObservableAbstractCollection<X, T>() {

    fun remove(): X {
        val resultElement = collection!!.remove()
        if (resultElement != null)
            signalChanged(MLDAction.Remove, resultElement = resultElement)
        return resultElement
    }


    fun element(): X {
        return collection!!.element()
    }

    fun offer(element: X): Boolean {
        val added = collection!!.offer(element)
        if (added)
            signalChanged(MLDAction.Offer, actionElement = element, resultBoolean = added)
        return added
    }

    fun peek(): X {
        return collection!!.peek()
    }

    fun poll(): X {
        val resultElement = collection!!.poll()
        if (resultElement != null)
            signalChanged(MLDAction.Poll, resultElement = resultElement)
        return resultElement
    }
 }