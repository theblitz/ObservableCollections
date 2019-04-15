package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.*
import java.util.concurrent.PriorityBlockingQueue

open class ObservablePriorityBlockingQueue<X>(): ObservableBlockingQueue<X, PriorityBlockingQueue<X>>(), Serializable {

    init {
        collection = PriorityBlockingQueue<X>()
    }

    constructor(inCollection: MutableCollection<X>): this() {
        collection = PriorityBlockingQueue<X>(inCollection)
    }

    constructor(capacity: Int): this() {
        collection = PriorityBlockingQueue<X>(capacity)
    }

    constructor(capacity: Int, comparator: Comparator<in X>?): this() {
        collection = PriorityBlockingQueue<X>(capacity)
    }
}