package il.co.theblitz.observablecollections.abstracts

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable

abstract class ObservableAbstractCollection<X, T: MutableCollection<X>>: Serializable, MutableLiveData<ObservableAbstractCollection<X, T>>(), MutableCollection<X> {

    protected open var collection: T? = null

    var action: ObservableCollectionsAction? = null

    var actionElement: X? = null
        private set

    var actionElements: Collection<X>? = null
        private set

    var actionInt: Int? = null
        private set

    var resultElement: X? = null
        private set

    var resultBoolean: Boolean? = null
        private set

    var resultInt: Int? = null
        private set

    override fun observe(owner: LifecycleOwner, observer: Observer<in ObservableAbstractCollection<X, T>>) {
        super.observe(owner, Observer { observer.onChanged(this) })
    }

    protected fun signalChanged(action: ObservableCollectionsAction, actionElement: X? = null, actionElements: Collection<X>? = null, actionInt: Int? = null, resultElement: X? = null, resultBoolean: Boolean? = null, resultInt: Int? = null){
        this.action = action
        this.actionElement = actionElement
        this.actionElements = actionElements
        this.actionInt = actionInt
        this.resultElement = resultElement
        this.resultBoolean = resultBoolean
        this.resultInt = resultInt
        value = value
    }

//    @TargetApi(24)
//    override fun parallelStream(): Stream<X> {
//        return collection!!.parallelStream()
//    }
//
//    @TargetApi(24)
//    override fun removeIf(filter: Predicate<in X>): Boolean {
//        val removed = collection!!.removeIf(filter)
//        if (removed)
//            signalChanged()
//        return removed
//    }
//
//    @TargetApi(24)
//
//    override fun spliterator(): Spliterator<X> {
//        return collection!!.spliterator()
//    }
//
//    @TargetApi(24)
//    override fun stream(): Stream<X> {
//        return collection!!.stream()
//    }

    override val size: Int
        get() = collection!!.size

    override fun contains(element: X): Boolean {
        return collection!!.contains(element)
    }

    override fun containsAll(elements: Collection<X>): Boolean {
        return collection!!.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return collection!!.isEmpty()
    }

    override fun add(element: X): Boolean {
        val added = collection!!.add(element)
        if (added)
            signalChanged(action = ObservableCollectionsAction.Add, actionElement = element, resultBoolean = added)
        return added
    }

    override fun addAll(elements: Collection<X>): Boolean {
        val added = collection!!.addAll(elements)
        if (added)
            signalChanged(action = ObservableCollectionsAction.AddAll, actionElements = elements, resultBoolean = added)
        return added
    }

    override fun clear() {
        collection!!.clear()
        signalChanged(action = ObservableCollectionsAction.Clear)
    }

    override fun iterator(): MutableIterator<X> {
        return collection!!.iterator()
    }

    override fun remove(element: X): Boolean {
        val removed = collection!!.remove(element)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.Remove, actionElement = element, resultBoolean = removed)
        return removed
    }

    override fun removeAll(elements: Collection<X>): Boolean {
        val removed = collection!!.removeAll(elements)
        if (removed)
            signalChanged(action = ObservableCollectionsAction.RemoveAll, actionElements = elements, resultBoolean = removed)
        return removed
    }

    override fun retainAll(elements: Collection<X>): Boolean {
        val changed = collection!!.retainAll(elements)
        if (changed)
            signalChanged(action = ObservableCollectionsAction.RetainAll, actionElements = elements,resultBoolean = changed)
        return changed
    }
}