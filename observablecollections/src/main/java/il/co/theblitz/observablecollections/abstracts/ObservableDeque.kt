package il.co.anykey.apps.mutablelivedatacollections.abstracts

import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.util.*

abstract class ObservableDeque<X, T : Deque<X>> : ObservableQueue<X, T>() {

    fun peekLast(): X {
        return collection!!.peekLast()
    }

    fun push(element: X) {
        collection!!.push(element)
        signalChanged(MLDAction.Push, actionElement = element)
    }

    fun getLast(): X {
        return collection!!.getLast()
    }

    fun addLast(element: X) {
        collection!!.addLast(element)
        signalChanged(MLDAction.AddLast, actionElement = element)
    }

    fun addFirst(element: X) {
        collection!!.addFirst(element)
        signalChanged(MLDAction.AddFirst, actionElement = element)
    }

    fun offerLast(element: X): Boolean {
        val added = collection!!.offerLast(element)
        if (added)
            signalChanged(MLDAction.OfferLast, actionElement = element, resultBoolean = added)
        return added
    }

    fun removeFirst(): X {
        val element = collection!!.removeFirst()
        if (element != null)
            signalChanged(MLDAction.RemoveFirst, resultElement = element)
        return element
    }

    fun getFirst(): X {
        return collection!!.first
    }

    fun removeLastOccurrence(element: X?): Boolean {
        val removed = collection!!.removeLastOccurrence(element)
        if (removed)
            signalChanged(MLDAction.RemoveLastOccurrence, actionElement = element, resultBoolean = removed)
        return removed
    }

    fun peekFirst(): X {
        return collection!!.peekFirst()
    }

    fun removeLast(): X {
        val resultElement = collection!!.removeLast()
        signalChanged(MLDAction.RemoveLast, resultElement = resultElement)
        return resultElement
    }

    fun offerFirst(element: X): Boolean {
        val offered = collection!!.offerFirst(element)
        if (offered)
            signalChanged(MLDAction.OfferFirst, actionElement = element, resultBoolean = offered)
        return offered
    }


    fun pollFirst(): X {
        val resultElement = collection!!.pollFirst()
        if (resultElement != null)
            signalChanged(MLDAction.PollFirst, resultElement = resultElement)
        return resultElement
    }

    fun pollLast(): X {
        val resultElement = collection!!.pollLast()
        if (resultElement != null)
            signalChanged(MLDAction.PollLast, resultElement = resultElement)
        return resultElement
    }

    fun pop(): X {
        val resultElement = collection!!.pop()
        signalChanged(MLDAction.Pop, resultElement = resultElement)
        return resultElement
    }

    fun removeFirstOccurrence(element: X?): Boolean {
        val removed = collection!!.removeFirstOccurrence(element)
        if (removed)
            signalChanged(MLDAction.RemoveFirstOccurrence, actionElement = element, resultBoolean = removed)
        return removed
    }

    fun descendingIterator(): MutableIterator<X> {
        return collection!!.descendingIterator()
    }

}