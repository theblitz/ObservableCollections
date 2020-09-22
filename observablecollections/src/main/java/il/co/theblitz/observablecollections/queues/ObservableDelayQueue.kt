package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.*
import java.util.concurrent.DelayQueue
import java.util.concurrent.Delayed

open class ObservableDelayQueue<X: Delayed>(skipCurrentValueCall: Boolean = false): ObservableBlockingQueue<X, DelayQueue<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = DelayQueue<X>()
    }

    constructor(inCollection: MutableCollection<X>): this() {
        collection = DelayQueue<X>(inCollection)
    }

}