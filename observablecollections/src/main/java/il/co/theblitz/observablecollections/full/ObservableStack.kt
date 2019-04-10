package il.co.anykey.apps.mutablelivedatacollections.full

import il.co.anykey.apps.mutablelivedatacollections.abstracts.ObservableAbstractList
import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.io.Serializable
import java.util.*

open class ObservableStack<X>: Serializable, ObservableAbstractList<X, Stack<X>>(), RandomAccess, Cloneable {

    init {
        collection = Stack<X>()
    }

    fun search(o: Any?): Int {
        return collection!!.search(o)
    }

    fun push(item: X): X {
        val resultElement = collection!!.push(item)
        signalChanged(MLDAction.Push, actionElement = item, resultElement = resultElement)
        return resultElement
    }

    fun peek(): X {
        return collection!!.peek()
    }

    fun empty(): Boolean {
        return collection!!.empty()
    }

    fun pop(): X {
        val resultElement = collection!!.pop()
        signalChanged(MLDAction.Push, resultElement = resultElement)
        return resultElement
    }

}