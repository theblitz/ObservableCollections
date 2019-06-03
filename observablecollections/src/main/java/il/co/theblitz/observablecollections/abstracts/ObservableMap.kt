package il.co.theblitz.observablecollections.abstracts

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction

abstract class ObservableMap<X, Y, T : MutableMap<X, Y>> : MutableLiveData<ObservableMap<X, Y, T>>(){

    protected var map: T? = null

    var action: ObservableCollectionsAction? = null
        private set

    var actionKey: X? = null
        private set

    var actionValue: Y? = null
        private set

    var actionMap: Map<out X, Y>? = null
        private set

    var resultValue: Y? = null
        private set

    override fun observe(owner: LifecycleOwner, observer: Observer<in ObservableMap<X, Y, T>>) {
        super.observe(owner, Observer { observer.onChanged(this) })
    }

    override fun observeForever(observer: Observer<in ObservableMap<X, Y, T>>) {
        super.observeForever(Observer { observer.onChanged(this) })
    }

    protected fun signalChanged(action: ObservableCollectionsAction, actionKey: X? = null, actionValue: Y? = null, actionMap: Map<out X, Y>? = null,
                                resultValue: Y? = null){
        this.action = action
        this.actionKey = actionKey
        this.actionValue = actionValue
        this.actionMap = actionMap
        this.resultValue = resultValue
        value = value
    }

//    @TargetApi(24)
//    fun parallelStream(): Stream<X> {
//        return map!!.parallelStream()
//    }
//
//    @TargetApi(24)
//    fun removeIf(filter: Predicate<in X>): Boolean {
//        val removed = map!!.removeIf(filter)
//        if (removed)
//            signalChanged()
//        return removed
//    }
//
//    @TargetApi(24)
//
//    fun spliterator(): Spliterator<X> {
//        return map!!.spliterator()
//    }
//
//    @TargetApi(24)
//    fun stream(): Stream<X> {
//        return map!!.stream()
//    }

    val size: Int
        get() = map!!.size

    fun isEmpty(): Boolean {
        return map!!.isEmpty()
    }

    fun clear() {
        map!!.clear()
        signalChanged(action = ObservableCollectionsAction.Clear)
    }

    fun remove(key: X): Y? {
        val value = map!!.remove(key)
        if (value != null)
            signalChanged(action = ObservableCollectionsAction.Clear, actionKey = key, resultValue = value)
        return value
    }

    fun containsKey(key: X): Boolean {
        return map!!.containsKey(key)
    }

    fun containsValue(value: Y): Boolean {
        return map!!.containsValue(value)
    }

    fun get(key: X): Y? {
        return map!!.get(key)
    }

    val entries: MutableSet<MutableMap.MutableEntry<X, Y>>
        get() = map!!.entries
    
    val keys: MutableSet<X>
        get() = map!!.keys
    
    val values: MutableCollection<Y>
        get() = map!!.values

    fun put(key: X, value: Y): Y? {
        val resultValue = map!!.put(key, value)
        signalChanged(action = ObservableCollectionsAction.Put, actionKey = key, actionValue = value, resultValue = resultValue)
        return resultValue
    }

    fun putAll(from: Map<out X, Y>) {
        map!!.putAll(from)
        signalChanged(action = ObservableCollectionsAction.PutAll, actionMap = from)
        
    }
}