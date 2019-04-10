package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*

abstract class ObservableAbstractSequentialList<X, T: AbstractSequentialList<X>>: Serializable, ObservableAbstractList<X, T>() {
    fun add(index: Int, element: X) {
        collection!!.add(index, element)
        signalChanged(action = ObservableCollectionsAction.Add, actionElement = element)
    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(action = ObservableCollectionsAction.Add, actionElements = elements, resultBoolean = added)
        return added
    }

    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(ObservableCollectionsAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(ObservableCollectionsAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }
}