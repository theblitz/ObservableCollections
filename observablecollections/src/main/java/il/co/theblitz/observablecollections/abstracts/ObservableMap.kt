package il.co.theblitz.observablecollections.abstracts

import android.annotation.TargetApi
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.util.function.Predicate
import java.util.stream.Stream

 abstract class ObservableMap<X, Y, T : MutableMap<X, Y>>(val skipCurrentValueCall: Boolean = false): MutableLiveData<ObservableMap<X, Y, T>>(), Iterable<Map.Entry<X, Y>>{

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
        if (skipCurrentValueCall && !hasActiveObservers())
            return

        this.action = action
        this.actionKey = actionKey
        this.actionValue = actionValue
        this.actionMap = actionMap
        this.resultValue = resultValue
        postValue(value)
    }

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
            signalChanged(action = ObservableCollectionsAction.Remove, actionKey = key, resultValue = value)
        return value
    }

    fun containsKey(key: X): Boolean {
        return map!!.containsKey(key)
    }

    fun containsValue(value: Y): Boolean {
        return map!!.containsValue(value)
    }

    operator fun get(key: X): Y? {
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

    operator fun set(key: X, value: Y): Y? {
         return put(key, value)
    }

    fun putAll(from: Map<out X, Y>) {
        map!!.putAll(from)
        signalChanged(action = ObservableCollectionsAction.PutAll, actionMap = from)

    }

     override fun iterator(): Iterator<Map.Entry<X, Y>> {
         return map!!.iterator()
     }
 }
