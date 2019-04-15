package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.SynchronousQueue

open class ObservableSynchronousQueue<X>(): ObservableBlockingQueue<X, SynchronousQueue<X>>(), Serializable {

    init {
        collection = SynchronousQueue<X>()
    }

    constructor(fair: Boolean): this() {
        collection = SynchronousQueue<X>(fair)
    }

}