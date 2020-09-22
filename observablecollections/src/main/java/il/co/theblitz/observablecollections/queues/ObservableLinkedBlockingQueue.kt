package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.LinkedBlockingQueue

open class ObservableLinkedBlockingQueue<X>(skipCurrentValueCall: Boolean = false): ObservableBlockingQueue<X, LinkedBlockingQueue<X>>(skipCurrentValueCall), Serializable {

    init {
        collection = LinkedBlockingQueue<X>()
    }

    constructor(inCollection: MutableCollection<X>): this() {
        collection = LinkedBlockingQueue<X>(inCollection)
    }

    constructor(capacity: Int): this() {
        collection = LinkedBlockingQueue<X>(capacity)
    }

}