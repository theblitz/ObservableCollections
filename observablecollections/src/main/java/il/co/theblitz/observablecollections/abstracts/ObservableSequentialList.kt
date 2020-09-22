package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*

abstract class ObservableSequentialList<X, T: AbstractSequentialList<X>>: Serializable, ObservableList<X, T>() {
//    fun add(index: Int, element: X) {
//        collection!!.add(index, element)
//        signalChanged(action = ObservableCollectionsAction.Add, actionInt = index, actionElement = element)
//    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(action = ObservableCollectionsAction.Add, actionInt = index, actionElements = elements, resultBoolean = added)
        return added
    }

}