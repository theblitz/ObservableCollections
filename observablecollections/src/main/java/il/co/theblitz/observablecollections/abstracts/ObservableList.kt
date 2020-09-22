package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*
import kotlin.random.Random

@Suppress("unused")
abstract class ObservableList<X, T: MutableList<X>>(skipCurrentValue: Boolean = false): Serializable, ObservableCollection<X, T>(skipCurrentValue) {

    override var collection: T?
        get() = _collection
        set(value) {_collection = value}

    fun add(index: Int, element: X) {
        collection!!.add(index, element)
        signalChanged(ObservableCollectionsAction.Add, actionInt = index, actionElement = element)
    }

    fun get(index: Int): X {
        return collection!![index]
    }

    fun getOrNull(index: Int): X? {
        return collection!!.getOrNull(index)
    }

    fun getOrElse(index: Int, defaultValue: (Int) -> X): X {
        return collection!!.getOrElse(index, defaultValue)
    }

    fun indexOf(element: X): Int {
        return collection!!.indexOf(element)
    }

    fun lastIndexOf(element: X): Int {
        return collection!!.lastIndexOf(element)
    }

    fun indexOfFirst(predicate: (X) -> Boolean): Int {
        return collection!!.indexOfFirst(predicate)
    }

    fun indexOfLast(predicate: (X) -> Boolean): Int {
        return collection!!.indexOfLast(predicate)
    }

    fun listIterator(): ListIterator<X> {
        return collection!!.listIterator()
    }

    fun listIterator(index: Int): ListIterator<X> {
        return collection!!.listIterator(index)
    }

    fun subList(fromIndex: Int, toIndex: Int): List<X> {
        return collection!!.subList(fromIndex, toIndex)
    }


    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(ObservableCollectionsAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

    fun fill(value: X) {
        collection!!.fill(value)
        signalChanged(ObservableCollectionsAction.Fill, actionElement = value)
    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(ObservableCollectionsAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }

    fun reverse() {
        collection!!.reverse()
        signalChanged(ObservableCollectionsAction.Reverse)
    }

    fun shuffle(random: Random) {
        collection!!.shuffle(random)
        signalChanged(ObservableCollectionsAction.Shuffle)
    }

    fun sortWith(comparator: Comparator<in X>) {
        collection!!.sortWith(comparator)
        signalChanged(ObservableCollectionsAction.Sort)
    }
}