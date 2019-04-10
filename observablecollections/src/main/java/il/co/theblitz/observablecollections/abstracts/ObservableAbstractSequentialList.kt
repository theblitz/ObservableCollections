package il.co.anykey.apps.mutablelivedatacollections.abstracts

import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.io.Serializable
import java.util.*

abstract class ObservableAbstractSequentialList<X, T: AbstractSequentialList<X>>: Serializable, ObservableAbstractList<X, T>() {
    fun add(index: Int, element: X) {
        collection!!.add(index, element)
        signalChanged(action = MLDAction.Add, actionElement = element)
    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(action = MLDAction.Add, actionElements = elements, resultBoolean = added)
        return added
    }

    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(MLDAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(MLDAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }
}