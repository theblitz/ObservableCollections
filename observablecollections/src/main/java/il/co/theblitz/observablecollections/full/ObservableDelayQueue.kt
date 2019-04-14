package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.DelayQueue
import java.util.concurrent.Delayed

open class ObservableDelayQueue<X: Delayed>(): ObservableBlockingQueue<X, DelayQueue<X>>(), Serializable {

    init {
        collection = DelayQueue<X>()
    }

    constructor(inCollection: MutableCollection<X>): this() {
        collection = DelayQueue<X>(inCollection)
    }

}