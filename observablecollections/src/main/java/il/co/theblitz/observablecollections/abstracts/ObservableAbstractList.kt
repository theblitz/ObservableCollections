package il.co.anykey.apps.mutablelivedatacollections.abstracts

import java.io.Serializable

abstract class ObservableAbstractList<X, T: MutableList<X>>: Serializable, ObservableAbstractCollection<X, T>() {

//    @TargetApi(24)
//    fun spliterator(): Spliterator<X> {
//        return collection!!.spliterator()
//    }

    fun get(index: Int): X {
        return collection!!.get(index)
    }

    fun indexOf(element: X): Int {
        return collection!!.indexOf(element)
    }

    fun lastIndexOf(element: X): Int {
        return collection!!.lastIndexOf(element)
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
}