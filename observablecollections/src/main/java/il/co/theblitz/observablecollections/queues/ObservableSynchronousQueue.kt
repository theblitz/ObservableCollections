package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.*
import java.util.concurrent.SynchronousQueue

open class ObservableSynchronousQueue<X>(fair: Boolean, skipCurrentValueCall: Boolean = false): ObservableBlockingQueue<X, SynchronousQueue<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = SynchronousQueue<X>()
    }

    constructor(fair: Boolean): this(fair, false) {
        collection = SynchronousQueue<X>(fair)
    }

}