package il.co.theblitz.observablecollections.abstracts

import android.annotation.TargetApi
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import il.co.theblitz.observablecollections.lists.ObservableArrayList
import java.io.Serializable
import java.util.*
import java.util.function.Predicate
import java.util.stream.Stream
import kotlin.collections.ArrayList
import kotlin.random.Random

@Suppress("unused")
abstract class ObservableCollection<X, T: MutableCollection<X>>(private val skipCurrentValueCall: Boolean = false): Serializable, MutableLiveData<ObservableCollection<X, T>>(), MutableIterable<X>, Cloneable, Iterable<X>{

    protected var _collection: T? = null
    protected open var collection: T?
        get() = _collection
        set(value) {_collection = value}

    protected open fun newInstance(): ObservableCollection<X, T> =  this::class.java.newInstance()

    public override fun clone(): ObservableCollection<X,T>{
        val newInstance = newInstance()
        newInstance.addAll(collection as Collection<X>)
        return newInstance
    }

    protected fun clone(copyDataFrom: ObservableCollection<X,T>?) :ObservableCollection<X,T>{
        val  newInstance = newInstance()
        copyDataFrom?.apply { newInstance.addAll(this) }
        return newInstance
    }

    protected fun clone(copyDataFrom: List<X>?) :ObservableCollection<X,T>{
        val  newInstance = newInstance()
        copyDataFrom?.apply { newInstance.addAll(this) }
        return newInstance
    }

    var action: ObservableCollectionsAction? = null
        private set

    var actionElement: X? = null
        private set

    var actionElements: Collection<X>? = null
        private set

    var actionInt: Int? = null
        private set

    var removedElements: Collection<X>? = null
        private set

    var resultElement: X? = null
        private set

    var resultBoolean: Boolean? = null
        private set

    var resultInt: Int? = null
        private set

//    fun observe(owner: LifecycleOwner, observer: Observer<in ObservableCollection<X, T>>, skipCurrentValueCall: Boolean = false) {
//        this.skipCurrentValueCall = skipCurrentValueCall
//        super.observe(owner, { observer.onChanged(this) })
//    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in ObservableCollection<X, T>>) {
        super.observe(owner, { observer.onChanged(this) })
    }

    protected fun signalChanged(action: ObservableCollectionsAction, actionElement: X? = null, actionElements: Collection<X>? = null, actionInt: Int? = null, removedElements: Collection<X>? = null, resultElement: X? = null, resultBoolean: Boolean? = null, resultInt: Int? = null){
        if (skipCurrentValueCall && !hasActiveObservers())
            return

        this.action = action
        this.actionElement = actionElement
        this.actionElements = actionElements
        this.actionInt = actionInt
        this.removedElements = removedElements
        this.resultElement = resultElement
        this.resultBoolean = resultBoolean
        this.resultInt = resultInt
        value = value
    }

    @TargetApi(24)
    @RequiresApi(24)
    fun parallelStream(): Stream<X> {
        return collection!!.parallelStream()
    }

    @TargetApi(24)
    @RequiresApi(24)
    fun removeIf(filter: Predicate<in X>): Boolean {
        val removedElements: ObservableCollection<X, T> = clone()
        val removed = collection!!.removeIf(filter)
        removedElements.removeAll(collection!!)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.RemoveIf, removedElements = removedElements.collection, resultBoolean = removed)
        return removed
    }

    @TargetApi(24)
    @RequiresApi(24)
    fun spliterator(): Spliterator<X> {
        return collection!!.spliterator()
    }

    @TargetApi(24)
    @RequiresApi(24)
    fun stream(): Stream<X> {
        return collection!!.stream()
    }

    val size: Int
        get() = collection!!.size

    fun contains(element: X): Boolean {
        return collection!!.contains(element)
    }

    fun containsAll(elements: Collection<X>): Boolean {
        return collection!!.containsAll(elements)
    }

    fun isEmpty(): Boolean {
        return collection!!.isEmpty()
    }

    fun isNotEmpty(): Boolean {
        return collection!!.isNotEmpty()
    }

    fun add(element: X): Boolean {
        val size = collection!!.size
        val added = collection!!.add(element)
        if (added)
            signalChanged(action = ObservableCollectionsAction.Add, actionInt = size, actionElement = element, resultBoolean = added)
        return added
    }

    fun addAll(elements: Collection<X>): Boolean {
        val size = collection!!.size
        val added = collection!!.addAll(elements)
        if (added)
            signalChanged(action = ObservableCollectionsAction.AddAll, actionInt = size, actionElements = elements, resultBoolean = added)
        return added
    }

    fun addAll(elements: ObservableCollection<X, T>): Boolean {
        return addAll(elements.collection as MutableCollection<X>)
    }

    fun clear() {
        collection!!.clear()
        signalChanged(action = ObservableCollectionsAction.Clear)
    }

    override fun iterator(): MutableIterator<X> {
        return collection!!.iterator()
    }

    fun remove(element: X): Boolean {
        val removed = collection!!.remove(element)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.Remove, actionElement = element, resultBoolean = removed)
        return removed
    }

    fun removeAll(elements: Collection<X>): Boolean {
        val removed = collection!!.removeAll(elements)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.RemoveAll, actionElements = elements, resultBoolean = removed)
        return removed
    }

    fun removeAll(elements: ObservableCollection<X, T>): Boolean {
        val removed = collection!!.removeAll(elements.collection as MutableCollection<X>)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.RemoveAll, actionElements = elements.collection, resultBoolean = removed)
        return removed
    }

    fun retainAll(elements: Collection<X>): Boolean {
        val removedElements: ObservableCollection<X, T> = clone()
        removedElements.removeAll(elements)
        val changed = collection!!.retainAll(elements)
        if (changed)
            signalChanged(action = ObservableCollectionsAction.RetainAll, actionElements = elements, removedElements = removedElements.collection, resultBoolean = changed)
        return changed
    }

    fun retainAll(elements: ObservableCollection<X, T>): Boolean {
        return retainAll(elements.collection as MutableCollection<X>)
    }

    /**
     * Returns a new ObservableList with the elements of this list
     * sorted according to the specified [comparator]..
     */
    fun sortedWith(comparator: Comparator<in X>): ObservableList<X, ArrayList<X>> {
        val list = ObservableArrayList<X>()
        list.addAll(collection!!.sortedWith(comparator))

        return list
    }

    /**
     * Returns a new ObservableList with the elements of this list randomly shuffled
     * using the specified [random] instance as the source of randomness.
     */
    fun shuffled(random: Random): ObservableList<X, ArrayList<X>> {
        val list = ObservableArrayList<X>()
        list.addAll(collection!!.shuffled(random))

        return list
    }

    /**
     * Returns a new ObservableList with the elements of this list reversed
     * using the specified [random] instance as the source of randomness.
     */
    fun reversed(): ObservableList<X, ArrayList<X>> {
        val list = ObservableArrayList<X>()
        list.addAll(collection!!.reversed())

        return list
    }

}