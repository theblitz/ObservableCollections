package il.co.anykey.apps.mutablelivedatacollections.full

import android.annotation.TargetApi
import il.co.anykey.apps.mutablelivedatacollections.abstracts.ObservableAbstractList
import il.co.anykey.apps.mutablelivedatacollections.enums.MLDAction
import java.io.Serializable
import java.util.*
import java.util.function.UnaryOperator

class ObservableVector<X>: Serializable, ObservableAbstractList<X, Vector<X>>(), RandomAccess, Cloneable{

    init {
        collection = Vector<X>()
    }
    
    fun indexOf(o: Any?, index: Int): Int {
        return collection!!.indexOf(o, index)
    }

    fun lastIndexOf(o: Any?, index: Int): Int {
        return collection!!.lastIndexOf(o, index)
    }

    fun add(index: Int, element: X) {
        collection!!.add(index, element)
        signalChanged(MLDAction.Add, actionElement = element)
    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(MLDAction.AddAll, actionElements = elements, resultBoolean = added)
        return added
    }

    fun elementAt(index: Int): X {
        return collection!!.elementAt(index)
    }

    @TargetApi(24)
    fun replaceAll(operator: UnaryOperator<X>) {
        collection!!.replaceAll(operator)
        signalChanged(MLDAction.ReplaceAll)
    }

    fun lastElement(): X {
        return collection!!.lastElement()
    }

    fun firstElement(): X {
        return collection!!.firstElement()
    }

    fun trimToSize() {
        collection!!.trimToSize()
    }

//    fun removeElement(obj: Any?): Boolean {
    fun removeElement(obj: X): Boolean {
        val removed = collection!!.removeElement(obj)
        if (removed)
            signalChanged(MLDAction.RemoveAt, actionElement = obj, resultBoolean = removed)
        return removed
    }

    fun toArray(): Array<Any> {
        return collection!!.toArray()
    }

    fun <T : Any?> toArray(a: Array<out T>?): Array<T> {
        return collection!!.toArray(a)
    }

    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(MLDAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

//    fun sort(c: Comparator<in X>?) {
//        collection!!.sortWith(c)
//    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(MLDAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }

    fun capacity(): Int {
        return collection!!.capacity()
    }

    fun setElementAt(obj: X, index: Int) {
        collection!!.setElementAt(obj, index)
        signalChanged(MLDAction.SetElementAt, actionInt = index, actionElement = obj)
    }

    fun addElement(obj: X) {
        collection!!.addElement(obj)
        signalChanged(MLDAction.AddElement, actionElement = obj)
    }

    fun setSize(newSize: Int) {
        collection!!.setSize(newSize)
    }

    fun copyInto(anArray: Array<out Any>?) {
        collection!!.copyInto(anArray)
    }

    fun removeAllElements() {
        collection!!.removeAllElements()
        signalChanged(action = MLDAction.RemoveAll)
    }

    fun ensureCapacity(minCapacity: Int) {
        collection!!.ensureCapacity(minCapacity)
    }

    fun removeElementAt(index: Int) {
        collection!!.removeElementAt(index)
        signalChanged(action = MLDAction.RemoveElementAt, actionInt = index)
    }

    fun insertElementAt(obj: X, index: Int) {
        collection!!.insertElementAt(obj, index)
        signalChanged(action = MLDAction.InsertElementAt, actionInt = index, actionElement = obj)
    }

    fun elements(): Enumeration<X> {
        return collection!!.elements()
    }

}